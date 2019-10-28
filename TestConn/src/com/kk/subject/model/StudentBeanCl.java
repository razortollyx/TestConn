/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.sql.Connection;
/*   5:    */ import java.sql.PreparedStatement;
/*   6:    */ import java.sql.ResultSet;
/*   7:    */ import java.sql.SQLException;
/*   8:    */ import java.util.ArrayList;
/*   9:    */ 
/*  10:    */ public class StudentBeanCl
/*  11:    */ {
/*  12: 10 */   private Connection ct = null;
/*  13: 11 */   private PreparedStatement ps = null;
/*  14: 12 */   private ResultSet rs = null;
/*  15:    */   
/*  16:    */   public void closeSourse()
/*  17:    */   {
/*  18:    */     try
/*  19:    */     {
/*  20: 17 */       if (this.rs != null)
/*  21:    */       {
/*  22: 18 */         this.rs.close();
/*  23: 19 */         this.rs = null;
/*  24:    */       }
/*  25: 21 */       if (this.ps != null)
/*  26:    */       {
/*  27: 22 */         this.ps.close();
/*  28: 23 */         this.ps = null;
/*  29:    */       }
/*  30: 25 */       if (this.ct != null)
/*  31:    */       {
/*  32: 26 */         this.ct.close();
/*  33: 27 */         this.ct = null;
/*  34:    */       }
/*  35:    */     }
/*  36:    */     catch (SQLException e)
/*  37:    */     {
/*  38: 31 */       e.printStackTrace();
/*  39:    */     }
/*  40:    */   }
/*  41:    */   
/*  42:    */   public int updateBySql(String sql)
/*  43:    */   {
/*  44: 37 */     int i = 0;
/*  45:    */     try
/*  46:    */     {
/*  47: 39 */       this.ct = new ConnDb().getConn();
/*  48: 40 */       this.ps = this.ct.prepareStatement(sql);
/*  49: 41 */       i = this.ps.executeUpdate();
/*  50: 42 */       return i;
/*  51:    */     }
/*  52:    */     catch (Exception e)
/*  53:    */     {
/*  54: 45 */       e.printStackTrace();
/*  55: 46 */       return -1;
/*  56:    */     }
/*  57:    */     finally
/*  58:    */     {
/*  59: 48 */       closeSourse();
/*  60:    */     }
/*  61:    */   }
/*  62:    */   
/*  63:    */   public int batchAddStu(String cls_id, String stuNum, String yuanxi)
/*  64:    */   {
/*  65: 55 */     int num = Integer.parseInt(stuNum);
/*  66: 56 */     int i = 0;int affect = 0;
/*  67: 57 */     String stu_id = "";
/*  68: 58 */     String major = new ClsBeanCl().getMajorById(cls_id);
/*  69:    */     do
/*  70:    */     {
/*  71: 60 */       if (i < 10) {
/*  72: 61 */         stu_id = cls_id + "0" + i;
/*  73:    */       } else {
/*  74: 63 */         stu_id = cls_id + i;
/*  75:    */       }
/*  76: 65 */       affect += insertById(stu_id, cls_id, major, yuanxi);i++;
/*  77: 59 */     } while (i <= num);
/*  78: 67 */     return affect;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public int insertById(String id, String cls_id, String major, String yuanxi)
/*  82:    */   {
/*  83: 73 */     String sql = "insert into t_student (id,psw,class,major,yuanxi) values ('" + id + "','" + id + "','" + cls_id + "','" + major + "','" + yuanxi + "')";
/*  84: 74 */     System.out.println("sql=" + sql);
/*  85: 75 */     int i = 0;
/*  86:    */     try
/*  87:    */     {
/*  88: 77 */       this.ct = new ConnDb().getConn();
/*  89: 78 */       this.ps = this.ct.prepareStatement(sql);
/*  90: 79 */       i = this.ps.executeUpdate();
/*  91: 80 */       return i;
/*  92:    */     }
/*  93:    */     catch (Exception e)
/*  94:    */     {
/*  95: 83 */       e.printStackTrace();
/*  96: 84 */       return -1;
/*  97:    */     }
/*  98:    */     finally
/*  99:    */     {
/* 100: 86 */       closeSourse();
/* 101:    */     }
/* 102:    */   }
/* 103:    */   
/* 104:    */   public int insertByStudentBean(StudentBean sb)
/* 105:    */   {
/* 106: 93 */     String sql = "insert into t_student (id,psw,name,sex,class,major,phoneNum,email,privilege,selectedNum,yuanxi) values (?,?,?,?,?,?,?,?,?,?,?)";
/* 107: 94 */     int i = 0;
/* 108:    */     try
/* 109:    */     {
/* 110: 96 */       this.ct = new ConnDb().getConn();
/* 111: 97 */       this.ps = this.ct.prepareStatement(sql);
/* 112: 98 */       this.ps.setString(1, sb.getId());
/* 113: 99 */       this.ps.setString(2, sb.getPsw());
/* 114:100 */       this.ps.setString(3, sb.getName());
/* 115:101 */       this.ps.setString(4, SEX.toStringValue(sb.getSex()));
/* 116:102 */       this.ps.setString(5, sb.getCls());
/* 117:103 */       this.ps.setString(6, sb.getMajor());
/* 118:104 */       this.ps.setString(7, sb.getPhoneNum());
/* 119:105 */       this.ps.setString(8, sb.getEmail());
/* 120:106 */       this.ps.setInt(9, sb.getPrivilege());
/* 121:107 */       this.ps.setInt(10, sb.getSelectNum());
/* 122:108 */       this.ps.setString(11, sb.getYuanxi());
/* 123:109 */       i = this.ps.executeUpdate();
/* 124:110 */       return i;
/* 125:    */     }
/* 126:    */     catch (Exception e)
/* 127:    */     {
/* 128:113 */       e.printStackTrace();
/* 129:114 */       return -1;
/* 130:    */     }
/* 131:    */     finally
/* 132:    */     {
/* 133:116 */       closeSourse();
/* 134:    */     }
/* 135:    */   }
/* 136:    */   
/* 137:    */   public ArrayList<StudentBean> getAllStu(String yuanxi)
/* 138:    */   {
/* 139:122 */     ArrayList<StudentBean> al = new ArrayList();
/* 140:123 */     StudentBean sb = null;
/* 141:124 */     String sql = "select * from t_student where yuanxi='" + yuanxi + "' order by major,class";
/* 142:    */     try
/* 143:    */     {
/* 144:126 */       this.ct = new ConnDb().getConn();
/* 145:127 */       this.ps = this.ct.prepareStatement(sql);
/* 146:128 */       this.rs = this.ps.executeQuery();
/* 147:129 */       while (this.rs.next())
/* 148:    */       {
/* 149:130 */         sb = new StudentBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 150:131 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 151:132 */           this.rs.getString(7), this.rs.getString(8), this.rs.getInt(9), this.rs.getInt(10), this.rs.getString(11));
/* 152:133 */         al.add(sb);
/* 153:    */       }
/* 154:135 */       return al;
/* 155:    */     }
/* 156:    */     catch (Exception e)
/* 157:    */     {
/* 158:138 */       e.printStackTrace();
/* 159:139 */       return null;
/* 160:    */     }
/* 161:    */     finally
/* 162:    */     {
/* 163:141 */       closeSourse();
/* 164:    */     }
/* 165:    */   }
/* 166:    */   
/* 167:    */   public ArrayList<StudentBean> getStuByCls(String cls, String yuanxi)
/* 168:    */   {
/* 169:147 */     ArrayList<StudentBean> al = new ArrayList();
/* 170:148 */     StudentBean sb = null;
/* 171:149 */     String sql = "select * from t_student where class='" + cls + "' and yuanxi='" + yuanxi + "' order by major,class";
/* 172:    */     try
/* 173:    */     {
/* 174:151 */       this.ct = new ConnDb().getConn();
/* 175:152 */       this.ps = this.ct.prepareStatement(sql);
/* 176:153 */       this.rs = this.ps.executeQuery();
/* 177:154 */       while (this.rs.next())
/* 178:    */       {
/* 179:155 */         sb = new StudentBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 180:156 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 181:157 */           this.rs.getString(7), this.rs.getString(8), this.rs.getInt(9), this.rs.getInt(10), this.rs.getString(11));
/* 182:158 */         al.add(sb);
/* 183:    */       }
/* 184:160 */       return al;
/* 185:    */     }
/* 186:    */     catch (Exception e)
/* 187:    */     {
/* 188:163 */       e.printStackTrace();
/* 189:164 */       return null;
/* 190:    */     }
/* 191:    */     finally
/* 192:    */     {
/* 193:166 */       closeSourse();
/* 194:    */     }
/* 195:    */   }
/* 196:    */   
/* 197:    */   public ArrayList<StudentBean> getStuByMajor(String majorName, String yuanxi)
/* 198:    */   {
/* 199:172 */     ArrayList<StudentBean> al = new ArrayList();
/* 200:173 */     StudentBean sb = null;
/* 201:174 */     String sql = "select * from t_student where major='" + majorName + "' and yuanxi='" + yuanxi + "' order by major,class";
/* 202:    */     try
/* 203:    */     {
/* 204:176 */       this.ct = new ConnDb().getConn();
/* 205:177 */       this.ps = this.ct.prepareStatement(sql);
/* 206:178 */       this.rs = this.ps.executeQuery();
/* 207:179 */       while (this.rs.next())
/* 208:    */       {
/* 209:180 */         sb = new StudentBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 210:181 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 211:182 */           this.rs.getString(7), this.rs.getString(8), this.rs.getInt(9), this.rs.getInt(10), this.rs.getString(11));
/* 212:183 */         al.add(sb);
/* 213:    */       }
/* 214:185 */       return al;
/* 215:    */     }
/* 216:    */     catch (Exception e)
/* 217:    */     {
/* 218:188 */       e.printStackTrace();
/* 219:189 */       return null;
/* 220:    */     }
/* 221:    */     finally
/* 222:    */     {
/* 223:191 */       closeSourse();
/* 224:    */     }
/* 225:    */   }
/* 226:    */   
/* 227:    */   public int delStuById(String stuId)
/* 228:    */   {
/* 229:198 */     String sql = "delete from t_student where id='" + stuId + "'";
/* 230:199 */     int i = 0;
/* 231:    */     try
/* 232:    */     {
/* 233:201 */       this.ct = new ConnDb().getConn();
/* 234:202 */       this.ps = this.ct.prepareStatement(sql);
/* 235:203 */       i = this.ps.executeUpdate();
/* 236:204 */       return i;
/* 237:    */     }
/* 238:    */     catch (Exception e)
/* 239:    */     {
/* 240:207 */       e.printStackTrace();
/* 241:208 */       return -1;
/* 242:    */     }
/* 243:    */     finally
/* 244:    */     {
/* 245:210 */       closeSourse();
/* 246:    */     }
/* 247:    */   }
/* 248:    */   
/* 249:    */   public StudentBean getStuById(String stuId)
/* 250:    */   {
/* 251:215 */     String sql = "select * from t_student where id='" + stuId + "'";
/* 252:216 */     StudentBean sb = null;
/* 253:    */     try
/* 254:    */     {
/* 255:218 */       this.ct = new ConnDb().getConn();
/* 256:219 */       this.ps = this.ct.prepareStatement(sql);
/* 257:220 */       this.rs = this.ps.executeQuery();
/* 258:221 */       if (this.rs.next()) {
/* 259:222 */         sb = new StudentBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 260:223 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 261:224 */           this.rs.getString(7), this.rs.getString(8), this.rs.getInt(9), this.rs.getInt(10), this.rs.getString(11));
/* 262:    */       }
/* 263:226 */       return sb;
/* 264:    */     }
/* 265:    */     catch (Exception e)
/* 266:    */     {
/* 267:229 */       e.printStackTrace();
/* 268:230 */       return null;
/* 269:    */     }
/* 270:    */     finally
/* 271:    */     {
/* 272:232 */       closeSourse();
/* 273:    */     }
/* 274:    */   }
/* 275:    */   
/* 276:    */   public boolean checkExist(String stuId)
/* 277:    */   {
/* 278:237 */     if (getStuById(stuId) != null) {
/* 279:237 */       return true;
/* 280:    */     }
/* 281:238 */     return false;
/* 282:    */   }
/* 283:    */   
/* 284:    */   public int batchDelByClsId(String id)
/* 285:    */   {
/* 286:249 */     String sql = "delete from t_student where id like '%" + id + "%'";
/* 287:250 */     int i = 0;
/* 288:    */     try
/* 289:    */     {
/* 290:252 */       this.ct = new ConnDb().getConn();
/* 291:253 */       this.ps = this.ct.prepareStatement(sql);
/* 292:254 */       i = this.ps.executeUpdate();
/* 293:255 */       return i;
/* 294:    */     }
/* 295:    */     catch (Exception e)
/* 296:    */     {
/* 297:258 */       e.printStackTrace();
/* 298:259 */       return -1;
/* 299:    */     }
/* 300:    */     finally
/* 301:    */     {
/* 302:261 */       closeSourse();
/* 303:    */     }
/* 304:    */   }
/* 305:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StudentBeanCl
 * JD-Core Version:    0.7.0.1
 */