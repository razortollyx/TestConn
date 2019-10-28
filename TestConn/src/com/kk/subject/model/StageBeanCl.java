/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import com.ax.subject.model.ConnDb;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.Date;
/*   7:    */ import java.sql.PreparedStatement;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ 
/*  12:    */ public class StageBeanCl
/*  13:    */ {
/*  14:    */   private Connection ct;
/*  15:    */   private PreparedStatement ps;
/*  16:    */   private ResultSet rs;
/*  17:    */   
/*  18:    */   public void closeSourse()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 16 */       if (this.rs != null)
/*  23:    */       {
/*  24: 17 */         this.rs.close();
/*  25: 18 */         this.rs = null;
/*  26:    */       }
/*  27: 20 */       if (this.ps != null)
/*  28:    */       {
/*  29: 21 */         this.ps.close();
/*  30: 22 */         this.ps = null;
/*  31:    */       }
/*  32: 24 */       if (this.ct != null)
/*  33:    */       {
/*  34: 25 */         this.ct.close();
/*  35: 26 */         this.ct = null;
/*  36:    */       }
/*  37:    */     }
/*  38:    */     catch (SQLException e)
/*  39:    */     {
/*  40: 30 */       e.printStackTrace();
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   public int delStageByyuanxi(String yuanxi)
/*  45:    */   {
/*  46: 36 */     int j = 0;
/*  47:    */     try
/*  48:    */     {
/*  49: 39 */       this.ct = new ConnDb().getConn();
/*  50:    */       
/*  51: 41 */       String sql = "delete from t_stage where department='" + yuanxi + "'";
/*  52: 42 */       this.ps = this.ct.prepareStatement(sql);
/*  53: 43 */       j = this.ps.executeUpdate();
/*  54: 44 */       return j;
/*  55:    */     }
/*  56:    */     catch (Exception e)
/*  57:    */     {
/*  58:    */       int i;
/*  59: 47 */       e.printStackTrace();
/*  60: 48 */       return j;
/*  61:    */     }
/*  62:    */     finally
/*  63:    */     {
/*  64: 50 */       closeSourse();
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public ArrayList<StageBean> getAllStage(String yuanxi)
/*  69:    */   {
/*  70: 55 */     ArrayList<StageBean> arrSb = new ArrayList();
/*  71:    */     try
/*  72:    */     {
/*  73: 58 */       this.ct = new ConnDb().getConn();
					
					String testsql="select * from t_stage where department='"+yuanxi+"' ";
/*  74: 59 */       this.ps = this.ct.prepareStatement(testsql);
/*  75: 60 */       this.rs = this.ps.executeQuery();
				    
/*  76: 61 */       while (this.rs.next())
/*  77:    */       {
					 	                 
/*  78: 62 */         StageBean sb = new StageBean();
/*  79: 63 */         sb.setName(this.rs.getString(2));
/*  80: 64 */         sb.setStartTime(this.rs.getDate(3));
/*  81: 65 */         sb.setEndTime(this.rs.getDate(4));
/*  82: 66 */         arrSb.add(sb);
					  
/*  83:    */       }
					System.out.println("get"+arrSb.size());
/*  84: 68 */       return arrSb;
/*  85:    */     }
/*  86:    */     catch (Exception e)
/*  87:    */     {
/*  88: 71 */       e.printStackTrace();
/*  89: 72 */       return null;
/*  90:    */     }
/*  91:    */     finally
/*  92:    */     {
/*  93: 74 */       closeSourse();
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   public int insertByyuanxi(String yuanxi)
/*  98:    */   {
/*  99: 80 */     int i = 0;
/* 100:    */     try
/* 101:    */     {
/* 102: 82 */       String state1 = "1、" + yuanxi + "老师出题阶段";
					String state2 = "2、" + yuanxi + "特招阶段";
                    String state3 = "3、" + yuanxi + "系主任审核阶段";
/* 103: 83 */       String state4 = "4、" + yuanxi + "学生选题阶段";
/* 104: 84 */       String state5 = "5、" + yuanxi + "老师选志愿阶段";
/* 105: 85 */       String state6 = "6、" + yuanxi + "管理员调整结果阶段";
/* 106: 86 */       String sql = "insert into t_stage (name,department) values (?,?) ";
/* 107: 87 */       this.ct = new ConnDb().getConn();
/* 108: 88 */       this.ps = this.ct.prepareStatement(sql);
/* 109: 89 */       this.ps.setString(1, state1);
/* 110: 90 */       this.ps.setString(2, yuanxi);
/* 111: 91 */       i = this.ps.executeUpdate();

                    System.out.print(1111);

/* 112: 92 */       String sql1 = "insert into t_stage (name,department) values (?,?) ";
/* 113: 93 */       this.ct = new ConnDb().getConn();
/* 114: 94 */       this.ps = this.ct.prepareStatement(sql1);
/* 115: 95 */       this.ps.setString(1, state2);
/* 116: 96 */       this.ps.setString(2, yuanxi);
/* 117: 97 */       i = this.ps.executeUpdate();

					System.out.print(222);
/* 118: 98 */       String sql2 = "insert into t_stage (name,department) values (?,?) ";
/* 119: 99 */       this.ct = new ConnDb().getConn();
/* 120:100 */       this.ps = this.ct.prepareStatement(sql2);
/* 121:101 */       this.ps.setString(1, state3);
/* 122:102 */       this.ps.setString(2, yuanxi);
/* 123:103 */       i = this.ps.executeUpdate();

/* 124:104 */       String sql3 = "insert into t_stage (name,department) values (?,?) ";
/* 125:105 */       this.ct = new ConnDb().getConn();
/* 126:106 */       this.ps = this.ct.prepareStatement(sql3);
/* 127:107 */       this.ps.setString(1, state4);
/* 128:108 */       this.ps.setString(2, yuanxi);
/* 129:109 */       i = this.ps.executeUpdate();
/* 130:110 */       

					String sql4 = "insert into t_stage (name,department) values (?,?) ";
/* 107: 87 */       this.ct = new ConnDb().getConn();
/* 108: 88 */       this.ps = this.ct.prepareStatement(sql4);
/* 109: 89 */       this.ps.setString(1, state5);
/* 110: 90 */       this.ps.setString(2, yuanxi);
/* 111: 91 */       i = this.ps.executeUpdate();

					String sql5 = "insert into t_stage (name,department) values (?,?) ";
/* 107: 87 */       this.ct = new ConnDb().getConn();
/* 108: 88 */       this.ps = this.ct.prepareStatement(sql5);
/* 109: 89 */       this.ps.setString(1, state6);
/* 110: 90 */       this.ps.setString(2, yuanxi);
/* 111: 91 */       i = this.ps.executeUpdate();
					return i;
/* 131:    */     }
/* 132:    */     catch (Exception e)
/* 133:    */     {
/* 134:113 */       e.printStackTrace();
/* 135:114 */       return -1;
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:116 */       closeSourse();
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public ArrayList<StageBean> getAllStage1(String yuanxi)
/* 144:    */   {
/* 145:121 */     ArrayList<StageBean> arrSb = new ArrayList();
/* 146:    */     try
/* 147:    */     {
/* 148:124 */       this.ct = new ConnDb().getConn();
/* 149:125 */       this.ps = this.ct.prepareStatement("select * from t_stage where department='" + 
/* 150:126 */         yuanxi + "'");
/* 151:127 */       this.rs = this.ps.executeQuery();
/* 152:128 */       while (this.rs.next())
/* 153:    */       {
/* 154:129 */         StageBean sb = new StageBean();
/* 155:130 */         sb.setId(this.rs.getInt(1));
/* 156:131 */         sb.setName(this.rs.getString(2));
/* 157:132 */         sb.setStartTime(this.rs.getDate(3));
/* 158:133 */         sb.setEndTime(this.rs.getDate(4));
/* 159:134 */         arrSb.add(sb);
/* 160:    */       }
/* 161:136 */       return arrSb;
/* 162:    */     }
/* 163:    */     catch (Exception e)
/* 164:    */     {
/* 165:139 */       e.printStackTrace();
/* 166:140 */       return null;
/* 167:    */     }
/* 168:    */     finally
/* 169:    */     {
/* 170:142 */       closeSourse();
/* 171:    */     }
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setStage(String[] strStartTime, String[] strEndTime, String[] stateName, String yuanxi)
/* 175:    */   {
/* 176:149 */     Date[] sTimes = strTimesToDateTimes(strStartTime);
/* 177:150 */     Date[] eTimes = strTimesToDateTimes(strEndTime);
/* 178:    */     try
/* 179:    */     {
/* 180:153 */       this.ct = new ConnDb().getConn();
/* 181:154 */       this.ps = this.ct.prepareStatement("update t_stage set startTime=?,endTime=? where name=? and department='" + 
/* 182:155 */         yuanxi + "'");
/* 183:156 */       for (int i = 0; i < sTimes.length; i++)
/* 184:    */       {
/* 185:157 */         this.ps.setDate(1, sTimes[i]);
/* 186:158 */         this.ps.setDate(2, eTimes[i]);
/* 187:159 */         this.ps.setString(3, stateName[i]);
/* 188:160 */         this.ps.executeUpdate();
/* 189:    */       }
/* 190:    */     }
/* 191:    */     catch (Exception e)
/* 192:    */     {
/* 193:164 */       e.printStackTrace();
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:166 */       closeSourse();
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   public int getCurrentStage(String yuanxi)
/* 202:    */   {
/* 203:177 */     int i = 0;
/* 204:178 */     Date currentTime = new Date(System.currentTimeMillis());
/* 205:179 */     String strTime = currentTime.toString();
/* 206:180 */     currentTime = Date.valueOf(strTime);
/* 207:181 */     ArrayList<StageBean> alStage = getAllStage1(yuanxi);
/* 208:182 */     if (alStage == null) {
/* 209:183 */       return 0;
/* 210:    */     }
/* 211:184 */     for (; i < alStage.size(); i++)
/* 212:    */     {
/* 213:185 */       StageBean sb = (StageBean)alStage.get(i);
/* 214:186 */       if ((sb.getStartTime() != null) && 
/* 215:187 */         (currentTime.compareTo(sb.getStartTime()) >= 0) && 
/* 216:188 */         (currentTime.compareTo(sb.getEndTime()) <= 0)) {
/* 217:    */         break;
/* 218:    */       }
/* 219:    */     }
/* 220:193 */     if (i >= alStage.size()) {
/* 221:194 */       i = -1;
/* 222:    */     }
/* 223:195 */     System.out.println("第几条记录" + i);
/* 224:196 */     return i;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public int getCurrentId(String yuanxi)
/* 228:    */   {
/* 229:204 */     int i = 0;
/* 230:205 */     int id = 0;
/* 231:206 */     Date currentTime = new Date(System.currentTimeMillis());
/* 232:207 */     String strTime = currentTime.toString();
/* 233:208 */     currentTime = Date.valueOf(strTime);
/* 234:209 */     System.out.println(yuanxi);
/* 235:210 */     ArrayList<StageBean> alStage = getAllStage1(yuanxi);
/* 236:211 */     System.out.println(yuanxi+"的阶段有：" + alStage.size()+"阶段！");
/* 237:212 */     if (alStage == null) {
/* 238:213 */       return 0;
/* 239:    */     }
/* 240:214 */     for (; i < alStage.size(); i++)
/* 241:    */     {
					
/* 242:215 */       StageBean sb = (StageBean)alStage.get(i);
					

/* 243:216 */       if ((sb.getStartTime() != null) && (currentTime.compareTo(sb.getStartTime()) >= 0) && (currentTime.compareTo(sb.getEndTime()) <= 0))
/* 246:    */       {
/* 247:219 */         id = sb.getId();
/* 248:220 */         System.out.println("现在是第"+i+"阶段");
/* 249:221 */         break;
/* 250:    */       }
/* 251:    */     }
/* 252:225 */     if (i >= alStage.size()) {
/* 253:226 */       id = 0;
/* 254:    */     }
/* 255:227 */     System.out.println("id为" + id);
/* 256:228 */     return id;
/* 257:    */   }
/* 258:    */   
/* 259:    */   private Date[] strTimesToDateTimes(String[] strtimes)
/* 260:    */   {
/* 261:233 */     Date[] dates = new Date[strtimes.length];
/* 262:234 */     for (int i = 0; i < strtimes.length; i++) {
/* 263:235 */       dates[i] = Date.valueOf(strtimes[i]);
/* 264:    */     }
/* 265:237 */     return dates;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public String getdescribeOfStage(int stage)
/* 269:    */   {
/* 270:248 */     String sql = "select * from t_stage where id = '" + stage + "'";
/* 271:249 */     String describeOfStage = "不在选题阶段";
/* 272:    */     try
/* 273:    */     {
/* 274:251 */       this.ct = new ConnDb().getConn();
/* 275:252 */       this.ps = this.ct.prepareStatement(sql);
/* 276:253 */       this.rs = this.ps.executeQuery();
/* 277:254 */       if (this.rs.next()) {
/* 278:255 */         describeOfStage = this.rs.getString(2);
/* 279:    */       }
/* 280:    */     }
/* 281:    */     catch (Exception e)
/* 282:    */     {
/* 283:259 */       e.printStackTrace();
/* 284:    */     }
/* 285:    */     finally
/* 286:    */     {
/* 287:261 */       closeSourse();
/* 288:    */     }
/* 289:263 */     return describeOfStage;
/* 290:    */   }
/* 291:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StageBeanCl
 * JD-Core Version:    0.7.0.1
 */