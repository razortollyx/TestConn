/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.sql.Connection;
/*   5:    */ import java.sql.PreparedStatement;
/*   6:    */ import java.sql.ResultSet;
/*   7:    */ import java.sql.SQLException;
/*   8:    */ import java.util.ArrayList;
/*   9:    */ 
/*  10:    */ public class ClsBeanCl
/*  11:    */ {
/*  12:  7 */   private Connection ct = null;
/*  13:  8 */   private PreparedStatement ps = null;
/*  14:  9 */   private ResultSet rs = null;
/*  15:    */   
/*  16:    */   public void closeSourse()
/*  17:    */   {
/*  18:    */     try
/*  19:    */     {
/*  20: 14 */       if (this.rs != null)
/*  21:    */       {
/*  22: 15 */         this.rs.close();
/*  23: 16 */         this.rs = null;
/*  24:    */       }
/*  25: 18 */       if (this.ps != null)
/*  26:    */       {
/*  27: 19 */         this.ps.close();
/*  28: 20 */         this.ps = null;
/*  29:    */       }
/*  30: 22 */       if (this.ct != null)
/*  31:    */       {
/*  32: 23 */         this.ct.close();
/*  33: 24 */         this.ct = null;
/*  34:    */       }
/*  35:    */     }
/*  36:    */     catch (SQLException e)
/*  37:    */     {
/*  38: 28 */       e.printStackTrace();
/*  39:    */     }
/*  40:    */   }
/*  41:    */   
/*  42:    */   public ArrayList<ClsBean> getAllCls(String yuanxi)
/*  43:    */   {
/*  44: 34 */     String sql = "select * from t_class where yuanxi='" + yuanxi + "'";
/*  45: 35 */     ArrayList<ClsBean> al = new ArrayList();
/*  46: 36 */     ClsBean cb = null;
/*  47:    */     try
/*  48:    */     {
/*  49: 39 */       this.ct = new ConnDb().getConn();
/*  50: 40 */       this.ps = this.ct.prepareStatement(sql);
/*  51: 41 */       this.rs = this.ps.executeQuery();
/*  52: 42 */       while (this.rs.next())
/*  53:    */       {
/*  54: 43 */         cb = new ClsBean(this.rs.getString(1), this.rs.getString(2), this.rs.getInt(3));
/*  55: 44 */         al.add(cb);
/*  56:    */       }
/*  57: 46 */       return al;
/*  58:    */     }
/*  59:    */     catch (Exception e)
/*  60:    */     {
/*  61: 49 */       e.printStackTrace();
/*  62: 50 */       return null;
/*  63:    */     }
/*  64:    */     finally
/*  65:    */     {
/*  66: 52 */       closeSourse();
/*  67:    */     }
/*  68:    */   }
/*  69:    */   
/*  70:    */   public ArrayList getAllCls1(String yuanxi)
/*  71:    */   {
/*  72: 58 */     String sql = "select id from t_class where yuanxi='" + yuanxi + "'";
/*  73: 59 */     ArrayList<String> al = new ArrayList();
/*  74: 60 */     String cb = null;
/*  75:    */     try
/*  76:    */     {
/*  77: 63 */       this.ct = new ConnDb().getConn();
/*  78: 64 */       this.ps = this.ct.prepareStatement(sql);
/*  79: 65 */       this.rs = this.ps.executeQuery();
/*  80: 66 */       while (this.rs.next())
/*  81:    */       {
/*  82: 67 */         cb = new String(this.rs.getString(1));
/*  83: 68 */         al.add(cb);
/*  84:    */       }
/*  85: 70 */       return al;
/*  86:    */     }
/*  87:    */     catch (Exception e)
/*  88:    */     {
/*  89: 73 */       e.printStackTrace();
/*  90: 74 */       return null;
/*  91:    */     }
/*  92:    */     finally
/*  93:    */     {
/*  94: 76 */       closeSourse();
/*  95:    */     }
/*  96:    */   }
/*  97:    */   
/*  98:    */   public int insertCls(String cls_id, String major, String stuNum, String yuanxi)
/*  99:    */   {
/* 100: 90 */     String sql = "update t_class set majorName='" + major + "',stuNum='" + stuNum + "',yuanxi='" + yuanxi + "'where id='" + cls_id + "'";
/* 101: 91 */     String sql1 = "update t_student set major='" + major + "' where class='" + cls_id + "'";
/* 102: 92 */     int i = 0;
/* 103:    */     try
/* 104:    */     {
/* 105: 95 */       this.ct = new ConnDb().getConn();
/* 106: 96 */       this.ps = this.ct.prepareStatement(sql);
/* 107: 97 */       i = this.ps.executeUpdate();
/* 108: 98 */       this.ps = this.ct.prepareStatement(sql1);
/* 109: 99 */       i = this.ps.executeUpdate();
/* 110:    */       
/* 111:    */ 
/* 112:102 */       return i;
/* 113:    */     }
/* 114:    */     catch (Exception e)
/* 115:    */     {
/* 116:105 */       e.printStackTrace();
/* 117:106 */       return -1;
/* 118:    */     }
/* 119:    */     finally
/* 120:    */     {
/* 121:108 */       closeSourse();
/* 122:    */     }
/* 123:    */   }
/* 124:    */   
/* 125:    */   public int insert(String cls_id, String major, String stuNum, String yuanxi)
/* 126:    */   {
/* 127:114 */     String sql = "insert t_class (id,majorName,stuNum,yuanxi) values('" + cls_id + "','" + major + "','" + stuNum + "','" + yuanxi + "')";
/* 128:115 */     int i = 0;
/* 129:    */     try
/* 130:    */     {
/* 131:118 */       this.ct = new ConnDb().getConn();
/* 132:119 */       this.ps = this.ct.prepareStatement(sql);
/* 133:120 */       i = this.ps.executeUpdate();
/* 134:    */       
/* 135:    */ 
/* 136:123 */       return i;
/* 137:    */     }
/* 138:    */     catch (Exception e)
/* 139:    */     {
/* 140:126 */       e.printStackTrace();
/* 141:127 */       return -1;
/* 142:    */     }
/* 143:    */     finally
/* 144:    */     {
/* 145:129 */       closeSourse();
/* 146:    */     }
/* 147:    */   }
/* 148:    */   
/* 149:    */   public int delClsById(String id)
/* 150:    */   {
/* 151:140 */     String sql = "delete from t_class where id='" + id + "'";
/* 152:    */     
/* 153:    */ 
/* 154:143 */     String sql1 = "delete from t_student where id='" + id + "'";
/* 155:144 */     int i = 0;
/* 156:    */     try
/* 157:    */     {
/* 158:146 */       this.ct = new ConnDb().getConn();
/* 159:147 */       this.ps = this.ct.prepareStatement(sql);
/* 160:148 */       i = this.ps.executeUpdate();
/* 161:149 */       System.out.println("删除成功 ");
/* 162:150 */       this.ps = this.ct.prepareStatement(sql1);
/* 163:151 */       this.ps.executeUpdate();
/* 164:    */       
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:157 */       return i;
/* 170:    */     }
/* 171:    */     catch (Exception e)
/* 172:    */     {
/* 173:160 */       e.printStackTrace();
/* 174:161 */       return -1;
/* 175:    */     }
/* 176:    */     finally
/* 177:    */     {
/* 178:163 */       closeSourse();
/* 179:    */     }
/* 180:    */   }
/* 181:    */   
/* 182:    */   public String getMajorById(String cls_id)
/* 183:    */   {
/* 184:169 */     String sql = "select majorName from t_class where id='" + cls_id + "'";
/* 185:    */     
/* 186:171 */     System.out.println("sql=" + sql);
/* 187:    */     try
/* 188:    */     {
/* 189:174 */       this.ct = new ConnDb().getConn();
/* 190:175 */       this.ps = this.ct.prepareStatement(sql);
/* 191:176 */       this.rs = this.ps.executeQuery();
/* 192:177 */       if (this.rs.next()) {
/* 193:177 */         return this.rs.getString(1);
/* 194:    */       }
/* 195:    */     }
/* 196:    */     catch (Exception e)
/* 197:    */     {
/* 198:180 */       e.printStackTrace();
/* 199:    */     }
/* 200:    */     finally
/* 201:    */     {
/* 202:182 */       closeSourse();
/* 203:    */     }
/* 204:182 */     closeSourse();
/* 205:    */     
/* 206:184 */     return null;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public int[] getClsByMajor(String majorName)
/* 210:    */   {
/* 211:190 */     String sql = "select count(*) from(select id from t_class where majorName='" + majorName + "') as t_clsIds";
/* 212:191 */     int[] ClsArray = null;
/* 213:192 */     int i = 0;
/* 214:    */     try
/* 215:    */     {
/* 216:195 */       this.ct = new ConnDb().getConn();
/* 217:196 */       this.ps = this.ct.prepareStatement(sql);
/* 218:197 */       this.rs = this.ps.executeQuery();
/* 219:198 */       if (this.rs.next()) {
/* 220:198 */         ClsArray = new int[this.rs.getInt(1)];
/* 221:    */       }
/* 222:199 */       sql = "select id from t_class where majorName='" + majorName + "'";
/* 223:200 */       this.ps = this.ct.prepareStatement(sql);
/* 224:201 */       this.rs = this.ps.executeQuery();
/* 225:202 */       while (this.rs.next()) {
/* 226:203 */         ClsArray[(i++)] = this.rs.getInt(1);
/* 227:    */       }
/* 228:205 */       return ClsArray;
/* 229:    */     }
/* 230:    */     catch (Exception e)
/* 231:    */     {
/* 232:208 */       e.printStackTrace();
/* 233:209 */       return null;
/* 234:    */     }
/* 235:    */     finally
/* 236:    */     {
/* 237:211 */       closeSourse();
/* 238:    */     }
/* 239:    */   }
/* 240:    */   
/* 241:    */   public int[] getAllClsArr(String yuanxi)
/* 242:    */   {
/* 243:217 */     String sql = "select count(*) from t_class where yuanxi='" + yuanxi + "'";
/* 244:218 */     int[] ClsArray = null;
/* 245:219 */     int i = 0;
/* 246:    */     try
/* 247:    */     {
/* 248:222 */       synchronized (sql)
/* 249:    */       {
/* 250:223 */         this.ct = new ConnDb().getConn();
/* 251:224 */         this.ps = this.ct.prepareStatement(sql);
/* 252:225 */         this.rs = this.ps.executeQuery();
/* 253:226 */         if (this.rs.next()) {
/* 254:226 */           ClsArray = new int[this.rs.getInt(1)];
/* 255:    */         }
/* 256:227 */         sql = "select id from t_class where yuanxi='" + yuanxi + "'";
/* 257:228 */         this.ps = this.ct.prepareStatement(sql);
/* 258:229 */         this.rs = this.ps.executeQuery();
/* 259:230 */         while (this.rs.next()) {
/* 260:231 */           ClsArray[(i++)] = this.rs.getInt(1);
/* 261:    */         }
/* 262:    */       }
/* 263:234 */       return ClsArray;
/* 264:    */     }
/* 265:    */     catch (Exception e)
/* 266:    */     {
/* 267:237 */       e.printStackTrace();
/* 268:238 */       return null;
/* 269:    */     }
/* 270:    */     finally
/* 271:    */     {
/* 272:240 */       closeSourse();
/* 273:    */     }
/* 274:    */   }
/* 275:    */   
/* 276:    */   public ClsBean getClsById(String cls_id)
/* 277:    */   {
/* 278:250 */     String sql = "select * from t_class where id='" + cls_id + "'";
/* 279:251 */     ClsBean cb = null;
/* 280:252 */     int i = 0;
/* 281:    */     try
/* 282:    */     {
/* 283:255 */       this.ct = new ConnDb().getConn();
/* 284:256 */       this.ps = this.ct.prepareStatement(sql);
/* 285:257 */       this.rs = this.ps.executeQuery();
/* 286:258 */       if (this.rs.next()) {
/* 287:259 */         cb = new ClsBean(this.rs.getString(1), this.rs.getString(2), this.rs.getInt(3));
/* 288:    */       }
/* 289:261 */       return cb;
/* 290:    */     }
/* 291:    */     catch (Exception e)
/* 292:    */     {
/* 293:264 */       e.printStackTrace();
/* 294:265 */       return null;
/* 295:    */     }
/* 296:    */     finally
/* 297:    */     {
/* 298:267 */       closeSourse();
/* 299:    */     }
/* 300:    */   }
/* 301:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.ClsBeanCl
 * JD-Core Version:    0.7.0.1
 */