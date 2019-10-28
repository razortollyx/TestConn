/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import com.ax.subject.model.ConnDb;
/*   4:    */ import com.common.controller.Md5;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.sql.Connection;
/*   7:    */ import java.sql.PreparedStatement;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.sql.Statement;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ 
/*  13:    */ public class TeacherBeanCl
/*  14:    */ {
/*  15: 13 */   private Connection ct = null;
/*  16: 14 */   private PreparedStatement ps = null;
/*  17: 15 */   private ResultSet rs = null;
/*  18: 16 */   private TeacherBean tb = null;
/*  19: 18 */   private Statement sm = null;
/*  20:    */   
/*  21:    */   public TeacherBean getTeacherById(String id)
/*  22:    */   {
/*  23: 23 */     this.tb = null;
/*  24:    */     try
/*  25:    */     {
/*  26: 25 */       String sql = "select * from T_Teacher where id='" + id + "'";
/*  27: 26 */       this.ct = new ConnDb().getConn();
/*  28: 27 */       this.ps = this.ct.prepareStatement(sql);
/*  29:    */       
/*  30: 29 */       this.rs = this.ps.executeQuery();
/*  31: 31 */       if (this.rs.next())
/*  32:    */       {
/*  33: 32 */         this.tb = new TeacherBean();
/*  34:    */         
/*  35: 34 */         this.tb.setId(this.rs.getString(1));
/*  36: 35 */         this.tb.setPsw(this.rs.getString(2));
/*  37: 36 */         this.tb.setName(this.rs.getString(3));
/*  38: 37 */         this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
/*  39: 38 */         this.tb.setPhoneNum(this.rs.getString(5));
/*  40: 39 */         this.tb.setEmail(this.rs.getString(6));
/*  41: 40 */         this.tb.setJobTitle(this.rs.getString(7));
/*  42: 41 */         this.tb.setSubNum(this.rs.getShort(8));
/*  43: 42 */         this.tb.setMaxSubNum(this.rs.getShort(9));
/*  44: 43 */         this.tb.setDepartment(this.rs.getString(10));
/*  45: 44 */         this.tb.setType(this.rs.getInt(11));
/*  46: 45 */         this.tb.setXibie(this.rs.getString(12));
/*  47:    */       }
/*  48: 47 */       return this.tb;
/*  49:    */     }
/*  50:    */     catch (SQLException e)
/*  51:    */     {
/*  52: 50 */       e.printStackTrace();
/*  53: 51 */       return null;
/*  54:    */     }
/*  55:    */     finally
/*  56:    */     {
/*  57: 53 */       closeSourse();
/*  58:    */     }
/*  59:    */   }

				public TeacherBean getTeacherByNameAndYuanxi(String name , String yuanxi)
/*  22:    */   {
/*  23: 23 */     this.tb = null;
/*  24:    */     try
/*  25:    */     {
/*  26: 25 */       String sql = "select * from T_Teacher where name='" + name + "' and department ='" + yuanxi + "' " ;
/*  27: 26 */       this.ct = new ConnDb().getConn();
/*  28: 27 */       this.ps = this.ct.prepareStatement(sql);
/*  29:    */       
/*  30: 29 */       this.rs = this.ps.executeQuery();
/*  31: 31 */       if (this.rs.next())
/*  32:    */       {
/*  33: 32 */         this.tb = new TeacherBean();
/*  34:    */         
/*  35: 34 */         this.tb.setId(this.rs.getString(1));
/*  36: 35 */         this.tb.setPsw(this.rs.getString(2));
/*  37: 36 */         this.tb.setName(this.rs.getString(3));
/*  38: 37 */         this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
/*  39: 38 */         this.tb.setPhoneNum(this.rs.getString(5));
/*  40: 39 */         this.tb.setEmail(this.rs.getString(6));
/*  41: 40 */         this.tb.setJobTitle(this.rs.getString(7));
/*  42: 41 */         this.tb.setSubNum(this.rs.getShort(8));
/*  43: 42 */         this.tb.setMaxSubNum(this.rs.getShort(9));
/*  44: 43 */         this.tb.setDepartment(this.rs.getString(10));
/*  45: 44 */         this.tb.setType(this.rs.getInt(11));
/*  46: 45 */         this.tb.setXibie(this.rs.getString(12));
/*  47:    */       }
/*  48: 47 */       return this.tb;
/*  49:    */     }
/*  50:    */     catch (SQLException e)
/*  51:    */     {
/*  52: 50 */       e.printStackTrace();
/*  53: 51 */       return null;
/*  54:    */     }
/*  55:    */     finally
/*  56:    */     {
/*  57: 53 */       closeSourse();
/*  58:    */     }
/*  59:    */   }
/*  60:    */   
/*  61:    */   public ArrayList<TeacherBean> getAllTea()
/*  62:    */   {
/*  63: 60 */     ArrayList<TeacherBean> alTea = new ArrayList();
/*  64:    */     try
/*  65:    */     {
/*  66: 62 */       String sql = "select * from T_Teacher ";
/*  67: 63 */       this.ct = new ConnDb().getConn();
/*  68: 64 */       this.ps = this.ct.prepareStatement(sql);
/*  69:    */       
/*  70: 66 */       this.rs = this.ps.executeQuery();
/*  71: 68 */       while (this.rs.next())
/*  72:    */       {
/*  73: 69 */         this.tb = new TeacherBean();
/*  74:    */         
/*  75: 71 */         this.tb.setId(this.rs.getString(1));
/*  76: 72 */         this.tb.setPsw(this.rs.getString(2));
/*  77: 73 */         this.tb.setName(this.rs.getString(3));
/*  78: 74 */         this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
/*  79: 75 */         this.tb.setPhoneNum(this.rs.getString(5));
/*  80: 76 */         this.tb.setEmail(this.rs.getString(6));
/*  81: 77 */         this.tb.setJobTitle(this.rs.getString(7));
/*  82: 78 */         this.tb.setSubNum(this.rs.getShort(8));
/*  83: 79 */         this.tb.setMaxSubNum(this.rs.getShort(9));
/*  84: 80 */         this.tb.setDepartment(this.rs.getString(10));
/*  85: 81 */         this.tb.setType(this.rs.getInt(11));
/*  86: 82 */         alTea.add(this.tb);
/*  87:    */       }
/*  88: 85 */       return alTea;
/*  89:    */     }
/*  90:    */     catch (SQLException e)
/*  91:    */     {
/*  92: 88 */       e.printStackTrace();
/*  93: 89 */       return null;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 91 */       closeSourse();
/*  98:    */     }
/*  99:    */   }
/* 100:    */   
/* 101:    */   public ArrayList<TeacherBean> getTeaByDepartment(String department)
/* 102:    */   {
/* 103:102 */     ArrayList<TeacherBean> alTea = new ArrayList();
/* 104:    */     try
/* 105:    */     {
/* 106:104 */       String sql = "select * from T_Teacher where department=?";
/* 107:105 */       this.ct = new ConnDb().getConn();
/* 108:106 */       this.ps = this.ct.prepareStatement(sql);
/* 109:107 */       this.ps.setString(1, department);
/* 110:108 */       this.rs = this.ps.executeQuery();
/* 111:110 */       while (this.rs.next())
/* 112:    */       {
/* 113:111 */         this.tb = new TeacherBean();
/* 114:    */         
/* 115:113 */         this.tb.setId(this.rs.getString(1));
/* 116:114 */         this.tb.setPsw(this.rs.getString(2));
/* 117:115 */         this.tb.setName(this.rs.getString(3));
/* 118:116 */         this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
/* 119:117 */         this.tb.setPhoneNum(this.rs.getString(5));
/* 120:118 */         this.tb.setEmail(this.rs.getString(6));
/* 121:119 */         this.tb.setJobTitle(this.rs.getString(7));
/* 122:120 */         this.tb.setSubNum(this.rs.getShort(8));
/* 123:121 */         this.tb.setMaxSubNum(this.rs.getShort(9));
/* 124:122 */         this.tb.setDepartment(this.rs.getString(10));
/* 125:123 */         this.tb.setType(this.rs.getInt(11));
/* 126:124 */         alTea.add(this.tb);
/* 127:    */       }
/* 128:127 */       return alTea;
/* 129:    */     }
/* 130:    */     catch (SQLException e)
/* 131:    */     {
/* 132:130 */       e.printStackTrace();
/* 133:131 */       return null;
/* 134:    */     }
/* 135:    */     finally
/* 136:    */     {
/* 137:133 */       closeSourse();
/* 138:    */     }
/* 139:    */   }
/* 140:    */   
/* 141:    */   public int insertByTb(TeacherBean tb1)
/* 142:    */   {
/* 143:139 */     int i = 0;
/* 144:    */     try
/* 145:    */     {
/* 146:142 */       String sql = "insert into t_teacher (id,psw,name,sex,phoneNum,email,jobTitle,subNum,maxSubNum,department,type,xibie) values (?,?,?,?,?,?,?,?,?,?,?,?)";
/* 147:143 */       this.ct = new ConnDb().getConn();
/* 148:144 */       this.ps = this.ct.prepareStatement(sql);
/* 149:145 */       this.ps.setString(1, tb1.getId());
/* 150:146 */       this.ps.setString(2, tb1.getPsw());
/* 151:147 */       this.ps.setString(3, tb1.getName());
/* 152:148 */       this.ps.setString(4, SEX.toStringValue(tb1.getSex()));
/* 153:149 */       this.ps.setString(5, tb1.getPhoneNum());
/* 154:150 */       this.ps.setString(6, tb1.getEmail());
/* 155:151 */       this.ps.setString(7, tb1.getJobTitle());
/* 156:152 */       this.ps.setInt(8, tb1.getSubNum());
/* 157:153 */       this.ps.setInt(9, tb1.getMaxSubNum());
/* 158:154 */       this.ps.setString(10, tb1.getDepartment());
/* 159:155 */       this.ps.setInt(11, tb1.getType());
/* 160:156 */       this.ps.setString(12, tb1.getXibie());
/* 161:157 */       i = this.ps.executeUpdate();
/* 162:158 */       return i;
/* 163:    */     }
/* 164:    */     catch (Exception e)
/* 165:    */     {
/* 166:161 */       e.printStackTrace();
/* 167:162 */       return -1;
/* 168:    */     }
/* 169:    */     finally
/* 170:    */     {
/* 171:164 */       closeSourse();
/* 172:    */     }
/* 173:    */   }
/* 174:    */   
/* 175:    */   public int modifyByTb(TeacherBean tb2)
/* 176:    */   {
/* 177:171 */     int i = 0;
/* 178:    */     try
/* 179:    */     {
/* 180:174 */       String sql = "update t_teacher set psw=?,name=?,sex=?,phoneNum=?,email=?,jobTitle=?,subNum=?,maxSubNum=?,department=?,type=? where id=?";
/* 181:175 */       this.ct = new ConnDb().getConn();
/* 182:176 */       this.ps = this.ct.prepareStatement(sql);
/* 183:    */       
/* 184:178 */       this.ps.setString(1, tb2.getPsw());
/* 185:179 */       this.ps.setString(2, tb2.getName());
/* 186:180 */       this.ps.setString(3, SEX.toStringValue(tb2.getSex()));
/* 187:181 */       this.ps.setString(4, tb2.getPhoneNum());
/* 188:182 */       this.ps.setString(5, tb2.getEmail());
/* 189:183 */       this.ps.setString(6, tb2.getJobTitle());
/* 190:184 */       this.ps.setInt(7, tb2.getSubNum());
/* 191:185 */       this.ps.setInt(8, tb2.getMaxSubNum());
/* 192:186 */       this.ps.setString(9, tb2.getDepartment());
/* 193:187 */       this.ps.setInt(10, tb2.getType());
/* 194:188 */       this.ps.setString(11, tb2.getId());
/* 195:189 */       i = this.ps.executeUpdate();
/* 196:190 */       System.out.println(i + "\t" + tb2.getType() + "\t" + tb2.getDepartment());
/* 197:191 */       return i;
/* 198:    */     }
/* 199:    */     catch (Exception e)
/* 200:    */     {
/* 201:194 */       e.printStackTrace();
/* 202:195 */       return -1;
/* 203:    */     }
/* 204:    */     finally
/* 205:    */     {
/* 206:197 */       closeSourse();
/* 207:    */     }
/* 208:    */   }


				public int modifyByTb1(TeacherBean tb2)
/* 176:    */   {
/* 177:171 */     int i = 0;
/* 178:    */     try
/* 179:    */     {
/* 180:174 */       String sql = "update t_teacher set psw=?,name=?,sex=?,phoneNum=?,email=?,jobTitle=?,subNum=?,maxSubNum=?,department=?,type=?,xibie=? where id=?";
/* 181:175 */       this.ct = new ConnDb().getConn();
/* 182:176 */       this.ps = this.ct.prepareStatement(sql);
/* 183:    */       
/* 184:178 */       this.ps.setString(1, tb2.getPsw());
/* 185:179 */       this.ps.setString(2, tb2.getName());
/* 186:180 */       this.ps.setString(3, SEX.toStringValue(tb2.getSex()));
/* 187:181 */       this.ps.setString(4, tb2.getPhoneNum());
/* 188:182 */       this.ps.setString(5, tb2.getEmail());
/* 189:183 */       this.ps.setString(6, tb2.getJobTitle());
/* 190:184 */       this.ps.setInt(7, tb2.getSubNum());
/* 191:185 */       this.ps.setInt(8, tb2.getMaxSubNum());
/* 192:186 */       this.ps.setString(9, tb2.getDepartment());
/* 193:187 */       this.ps.setInt(10, tb2.getType());
					this.ps.setString(11, tb2.getXibie());

/* 194:188 */       this.ps.setString(12, tb2.getId());
/* 195:189 */       i = this.ps.executeUpdate();
/* 196:190 */       System.out.println(i + "\t" + tb2.getType() + "\t" + tb2.getDepartment() + tb2.getXibie());
/* 197:191 */       return i;
/* 198:    */     }
/* 199:    */     catch (Exception e)
/* 200:    */     {
/* 201:194 */       e.printStackTrace();
/* 202:195 */       return -1;
/* 203:    */     }
/* 204:    */     finally
/* 205:    */     {
/* 206:197 */       closeSourse();
/* 207:    */     }
/* 208:    */   }
/* 209:    */   
/* 210:    */   public int modifyAdByTb(AdminBean tb2)
/* 211:    */   {
/* 212:203 */     int i = 0;
/* 213:    */     try
/* 214:    */     {
/* 215:205 */       String sql = "update t_admin set psw=?,name=?,phoneNum=?,email=? where id=?";
/* 216:206 */       this.ct = new ConnDb().getConn();
/* 217:207 */       this.ps = this.ct.prepareStatement(sql);
/* 218:    */       
/* 219:209 */       this.ps.setString(1, tb2.getPsw());
/* 220:210 */       this.ps.setString(2, tb2.getName());
/* 221:211 */       this.ps.setString(3, tb2.getPhoneNum());
/* 222:212 */       this.ps.setString(4, tb2.getEmail());
/* 223:213 */       this.ps.setString(5, tb2.getId());
/* 224:214 */       i = this.ps.executeUpdate();
/* 225:215 */       return i;
/* 226:    */     }
/* 227:    */     catch (Exception e)
/* 228:    */     {
/* 229:218 */       e.printStackTrace();
/* 230:219 */       return -1;
/* 231:    */     }
/* 232:    */     finally
/* 233:    */     {
/* 234:221 */       closeSourse();
/* 235:    */     }
/* 236:    */   }




/* 237:    */   
/* 238:    */   public int delTeacherById(String teaId)
/* 239:    */   {
/* 240:226 */     int j = 0;
/* 241:227 */     int[] subIds = new TeacherSubBeanCl().getS_id(teaId);
/* 242:229 */     if (subIds == null) {
/* 243:229 */       System.out.println("subIds.length=0");
/* 244:    */     }
/* 245:    */     try
/* 246:    */     {
/* 247:231 */       this.ct = new ConnDb().getConn();
/* 248:232 */       if (subIds != null)
/* 249:    */       {
/* 250:234 */         String sql = "delete from T_Teacher_Sub where t_id=?";
/* 251:235 */         this.ps = this.ct.prepareStatement(sql);
/* 252:236 */         this.ps.setString(1, teaId);
/* 253:237 */         this.ps.executeUpdate();
/* 254:    */         
/* 255:239 */         sql = "delete from t_subject where id=?";
/* 256:240 */         this.ps = this.ct.prepareStatement(sql);
/* 257:241 */         for (int i = 0; i < subIds.length; i++)
/* 258:    */         {
/* 259:242 */           this.ps.setInt(1, subIds[i]);
/* 260:243 */           this.ps.executeUpdate();
/* 261:    */         }
/* 262:    */       }
/* 263:247 */       String sql = "delete from t_teacher where id=?";
/* 264:248 */       this.ps = this.ct.prepareStatement(sql);
/* 265:249 */       this.ps.setString(1, teaId);
/* 266:250 */       j = this.ps.executeUpdate();
/* 267:251 */       return j;
/* 268:    */     }
/* 269:    */     catch (Exception e)
/* 270:    */     {
/* 271:    */       int i;
/* 272:254 */       e.printStackTrace();
/* 273:255 */       return j;
/* 274:    */     }
/* 275:    */     finally
/* 276:    */     {
/* 277:257 */       closeSourse();
/* 278:    */     }
/* 279:    */   }
/* 280:    */   
/* 281:    */   public int delAdminById(String adminId)
/* 282:    */   {
/* 283:262 */     int j = 0;
/* 284:    */     try
/* 285:    */     {
/* 286:265 */       this.ct = new ConnDb().getConn();
/* 287:    */       
/* 288:267 */       String sql = "delete from t_admin where id=?";
/* 289:268 */       this.ps = this.ct.prepareStatement(sql);
/* 290:269 */       this.ps.setString(1, adminId);
/* 291:270 */       j = this.ps.executeUpdate();
/* 292:271 */       return j;
/* 293:    */     }
/* 294:    */     catch (Exception e)
/* 295:    */     {
/* 296:    */       int i;
/* 297:274 */       e.printStackTrace();
/* 298:275 */       return j;
/* 299:    */     }
/* 300:    */     finally
/* 301:    */     {
/* 302:277 */       closeSourse();
/* 303:    */     }
/* 304:    */   }
/* 305:    */   
/* 306:    */   public boolean checkUser(String u, String p)
/* 307:    */   {
/* 308:283 */     boolean b = false;
/* 309:284 */     Md5 md5 = new Md5();
/* 310:    */     try
/* 311:    */     {
/* 312:287 */       this.ct = new ConnDb().getConn();
/* 313:288 */       this.ps = this.ct.prepareStatement("select psw from T_Teacher where id='" + u + "'");
/* 314:    */       
/* 315:    */ 
/* 316:291 */       this.rs = this.ps.executeQuery("select psw from T_Teacher where id='" + u + "'");
/* 317:293 */       if (this.rs.next())
/* 318:    */       {
/* 319:297 */         String str = this.rs.getString(1);
/* 320:298 */         String str1 = Md5.MD5(str);
/* 321:    */         
/* 322:300 */         String ptr = Md5.MD5(p);
/* 323:303 */         if (str1.equals(ptr)) {
/* 324:305 */           b = true;
/* 325:    */         }
/* 326:    */       }
/* 327:    */     }
/* 328:    */     catch (Exception e)
/* 329:    */     {
/* 330:311 */       e.printStackTrace();
/* 331:    */     }
/* 332:    */     finally
/* 333:    */     {
/* 334:313 */       closeSourse();
/* 335:    */     }
/* 336:315 */     return b;
/* 337:    */   }
/* 338:    */   
/* 339:    */   public int updateData(String sql)
/* 340:    */   {
/* 341:320 */     int i = 0;
/* 342:    */     try
/* 343:    */     {
/* 344:322 */       this.ct = new ConnDb().getConn();
/* 345:323 */       this.ps = this.ct.prepareStatement(sql);
/* 346:324 */       i = this.ps.executeUpdate();
/* 347:    */       
/* 348:326 */       return i;
/* 349:    */     }
/* 350:    */     catch (Exception e)
/* 351:    */     {
/* 352:329 */       e.printStackTrace();
/* 353:330 */       return -1;
/* 354:    */     }
/* 355:    */     finally
/* 356:    */     {
/* 357:332 */       closeSourse();
/* 358:    */     }
/* 359:    */   }
/* 360:    */   
/* 361:    */   public void closeSourse()
/* 362:    */   {
/* 363:    */     try
/* 364:    */     {
/* 365:339 */       if (this.rs != null)
/* 366:    */       {
/* 367:340 */         this.rs.close();
/* 368:341 */         this.rs = null;
/* 369:    */       }
/* 370:343 */       if (this.ps != null)
/* 371:    */       {
/* 372:344 */         this.ps.close();
/* 373:345 */         this.ps = null;
/* 374:    */       }
/* 375:347 */       if (this.ct != null)
/* 376:    */       {
/* 377:348 */         this.ct.close();
/* 378:349 */         this.ct = null;
/* 379:    */       }
/* 380:    */     }
/* 381:    */     catch (SQLException e)
/* 382:    */     {
/* 383:353 */       e.printStackTrace();
/* 384:    */     }
/* 385:    */   }
/* 386:    */   
/* 387:    */   public boolean checkExist(String teaId)
/* 388:    */   {
/* 389:359 */     if (getTeacherById(teaId) != null) {
/* 390:359 */       return true;
/* 391:    */     }
/* 392:360 */     return false;
/* 393:    */   }
/* 394:    */   
/* 395:    */   public boolean checkEmail(String id, String email)
/* 396:    */   {
/* 397:365 */     String sql = "select * from t_teacher where id=? and email=?";
/* 398:366 */     boolean b = false;
/* 399:    */     try
/* 400:    */     {
/* 401:368 */       this.ct = new ConnDb().getConn();
/* 402:369 */       this.ps = this.ct.prepareStatement(sql);
/* 403:370 */       this.ps.setString(1, id);
/* 404:371 */       this.ps.setString(2, email);
/* 405:372 */       this.rs = this.ps.executeQuery();
/* 406:373 */       if (this.rs.next()) {
/* 407:373 */         b = true;
/* 408:    */       }
/* 409:    */     }
/* 410:    */     catch (Exception e)
/* 411:    */     {
/* 412:376 */       e.printStackTrace();
/* 413:    */     }
/* 414:    */     finally
/* 415:    */     {
/* 416:378 */       closeSourse();
/* 417:    */     }
/* 418:380 */     return b;
/* 419:    */   }
/* 420:    */   
/* 421:    */   public String getTeaDepartment(String teaName)
/* 422:    */   {
/* 423:385 */     String teaDepa = null;
/* 424:    */     try
/* 425:    */     {
/* 426:387 */       this.ct = new ConnDb().getConn();
/* 427:388 */       this.sm = this.ct.createStatement();
/* 428:389 */       this.rs = this.sm.executeQuery("select department from t_teacher where name='" + teaName + "'");
/* 429:390 */       if (this.rs.next()) {
/* 430:390 */         teaDepa = this.rs.getString(1);
/* 431:    */       }
/* 432:393 */       return teaDepa;
/* 433:    */     }
/* 434:    */     catch (Exception e)
/* 435:    */     {
/* 436:396 */       e.printStackTrace();
/* 437:397 */       return null;
/* 438:    */     }
/* 439:    */     finally
/* 440:    */     {
/* 441:399 */       closeSourse();
/* 442:    */     }
/* 443:    */   }
/* 444:    */   
/* 445:    */   public ArrayList<TeacherBean> getAllTeacherByName(String teacherName)
/* 446:    */   {
/* 447:405 */     ArrayList<TeacherBean> al = new ArrayList();
/* 448:406 */     TeacherBean tb = null;
/* 449:    */     try
/* 450:    */     {
/* 451:408 */       String sql = "select *from t_teacher where name like '%" + teacherName + "%'";
/* 452:409 */       this.ct = new ConnDb().getConn();
/* 453:410 */       this.sm = this.ct.createStatement();
/* 454:411 */       this.rs = this.sm.executeQuery(sql);
/* 455:412 */       while (this.rs.next())
/* 456:    */       {
/* 457:413 */         tb = new TeacherBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 458:414 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 459:415 */           this.rs.getString(7), this.rs.getInt(8), this.rs.getInt(9), 
/* 460:416 */           this.rs.getString(10), this.rs.getInt(11));
/* 461:417 */         al.add(tb);
/* 462:    */       }
/* 463:    */     }
/* 464:    */     catch (Exception e)
/* 465:    */     {
/* 466:424 */       e.printStackTrace();
/* 467:    */     }
/* 468:    */     finally
/* 469:    */     {
/* 470:426 */       closeSourse();
/* 471:    */     }
/* 472:428 */     return al;
/* 473:    */   }
/* 474:    */   
/* 475:    */   public ArrayList<TeacherBean> getAllTeacherByDirection(String direction)
/* 476:    */   {
/* 477:436 */     ArrayList<TeacherBean> al = new ArrayList();
/* 478:437 */     TeacherBean tb = null;
/* 479:    */     try
/* 480:    */     {
/* 481:439 */       String sql = "select *from t_teacher where department like '%" + direction + "%'";
/* 482:440 */       this.ct = new ConnDb().getConn();
/* 483:441 */       this.sm = this.ct.createStatement();
/* 484:442 */       this.rs = this.sm.executeQuery(sql);
/* 485:443 */       while (this.rs.next())
/* 486:    */       {
/* 487:444 */         tb = new TeacherBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 488:445 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 489:446 */           this.rs.getString(7), this.rs.getInt(8), this.rs.getInt(9), 
/* 490:447 */           this.rs.getString(10), this.rs.getInt(11));
/* 491:448 */         al.add(tb);
/* 492:    */       }
/* 493:    */     }
/* 494:    */     catch (Exception e)
/* 495:    */     {
/* 496:455 */       e.printStackTrace();
/* 497:    */     }
/* 498:    */     finally
/* 499:    */     {
/* 500:457 */       closeSourse();
/* 501:    */     }
/* 502:459 */     return al;
/* 503:    */   }
/* 504:    */   
/* 505:    */   public ArrayList<TeacherBean> getAllTeacherByTeacherNameandDirection(String teacherName, String direction)
/* 506:    */   {
/* 507:466 */     ArrayList<TeacherBean> al = new ArrayList();
/* 508:467 */     TeacherBean tb = null;
/* 509:    */     try
/* 510:    */     {
/* 511:469 */       String sql = "select * from t_teacher where name like '%" + teacherName + "%' and department like'%" + direction + "%'";
/* 512:470 */       this.ct = new ConnDb().getConn();
/* 513:471 */       this.sm = this.ct.createStatement();
/* 514:472 */       this.rs = this.sm.executeQuery(sql);
/* 515:473 */       while (this.rs.next())
/* 516:    */       {
/* 517:474 */         tb = new TeacherBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 518:475 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 519:476 */           this.rs.getString(7), this.rs.getInt(8), this.rs.getInt(9), 
/* 520:477 */           this.rs.getString(10), this.rs.getInt(11));
/* 521:478 */         al.add(tb);
/* 522:    */       }
/* 523:    */     }
/* 524:    */     catch (Exception e)
/* 525:    */     {
/* 526:485 */       e.printStackTrace();
/* 527:    */     }
/* 528:    */     finally
/* 529:    */     {
/* 530:487 */       closeSourse();
/* 531:    */     }
/* 532:489 */     return al;
/* 533:    */   }
/* 534:    */   
/* 535:    */   public ArrayList<TeacherBean> getTeacherByNameAndDept(String teacherName, String department, String xibie)
/* 536:    */   {
/* 537:501 */     ArrayList<TeacherBean> al = new ArrayList();
/* 538:502 */     TeacherBean tb = null;
/* 539:    */     try
/* 540:    */     {
/* 541:505 */       String sql = "select * from t_teacher where name like '%" + teacherName + "%' and department='" + department + "' and xibie='" + xibie + "' ORDER BY xibie,id";
/* 542:506 */       if ("0".equals(xibie)) {
/* 543:507 */         sql = "select * from t_teacher where name like '%" + teacherName + "%' and department='" + department + "'  ORDER BY xibie,id";
/* 544:    */       }
/* 545:510 */       this.ct = new ConnDb().getConn();
/* 546:511 */       this.sm = this.ct.createStatement();
/* 547:512 */       this.rs = this.sm.executeQuery(sql);
/* 548:513 */       while (this.rs.next())
/* 549:    */       {
/* 550:514 */         tb = new TeacherBean(this.rs.getString(1), this.rs.getString(2), this.rs.getString(3), 
/* 551:515 */           SEX.toEnum(this.rs.getString(4)), this.rs.getString(5), this.rs.getString(6), 
/* 552:516 */           this.rs.getString(7), this.rs.getInt(8), this.rs.getInt(9), 
/* 553:517 */           this.rs.getString(10), this.rs.getInt(11), this.rs.getString(12));
/* 554:518 */         al.add(tb);
/* 555:    */       }
/* 556:    */     }
/* 557:    */     catch (Exception e)
/* 558:    */     {
/* 559:525 */       e.printStackTrace();
/* 560:    */     }
/* 561:    */     finally
/* 562:    */     {
/* 563:527 */       closeSourse();
/* 564:    */     }
/* 565:529 */     return al;
/* 566:    */   }
/* 567:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.TeacherBeanCl
 * JD-Core Version:    0.7.0.1
 */