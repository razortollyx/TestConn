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
/*  11:    */ import java.util.Calendar;
/*  12:    */ 
/*  13:    */ public class SubjectBeanCl
/*  14:    */ {
/*  15: 17 */   private Connection ct = null;
/*  16: 18 */   private PreparedStatement ps = null;
/*  17: 19 */   private ResultSet rs = null;
/*  18:    */   
/*  19:    */   public int insertSubject(SubjectBean subBean)
/*  20:    */   {
/*  21: 25 */     int s_id = -1;
/*  22:    */     try
/*  23:    */     {
/*  24: 27 */       this.ct = new ConnDb().getConn();
/*  25: 28 */       System.out.println(subBean.getkey());
/*  26: 29 */       String sql = "insert into t_subject(title, teacher, direction, introduction, schedule, reference, requirement, domain, time, state, selectedNum, keyNum,yuanxi) values(?,?,?,?,?,?,?,?,'" + new Date(System.currentTimeMillis()) + "',?,?,?,?)";
/*  27: 30 */       this.ps = this.ct.prepareStatement(sql, 1);
/*  28: 31 */       this.ps.setString(1, subBean.getTitle());
/*  29: 32 */       this.ps.setString(2, subBean.getTeacher());
/*  30: 33 */       this.ps.setString(3, subBean.getDirection());
/*  31: 34 */       this.ps.setString(4, subBean.getIntroduction());
/*  32: 35 */       this.ps.setString(5, subBean.getSchedule());
/*  33: 36 */       this.ps.setString(6, subBean.getReference());
/*  34: 37 */       this.ps.setString(7, subBean.getRequirement());
/*  35: 38 */       this.ps.setString(8, subBean.getDomain());
/*  36: 39 */       this.ps.setInt(9, subBean.getState());
/*  37: 40 */       this.ps.setInt(10, subBean.getSelectedNum());
/*  38: 41 */       this.ps.setString(11, subBean.getkey());
/*  39: 42 */       this.ps.setString(12, subBean.getYuanxi());
/*  40: 43 */       this.ps.executeUpdate();
/*  41:    */       
/*  42: 45 */       System.out.println("sql=" + sql);
/*  43:    */       
/*  44: 47 */       this.rs = this.ps.getGeneratedKeys();
/*  45: 48 */       if (this.rs.next()) {
/*  46: 49 */         s_id = this.rs.getInt(1);
/*  47:    */       }
/*  48: 52 */       if (this.rs.next()) {
/*  49: 53 */         s_id = this.rs.getInt(1);
/*  50:    */       }
/*  51: 55 */       return s_id;
/*  52:    */     }
/*  53:    */     catch (Exception e)
/*  54:    */     {
/*  55: 58 */       e.printStackTrace();
/*  56: 59 */       return -1;
/*  57:    */     }
/*  58:    */     finally
/*  59:    */     {
/*  60: 61 */       closeSourse();
/*  61:    */     }
/*  62:    */   }
/*  63:    */   
/*  64:    */   public SubjectBean getSubjectById(String id)
/*  65:    */   {
/*  66: 67 */     SubjectBean sb = null;
/*  67:    */     try
/*  68:    */     {
/*  69: 69 */       this.ct = new ConnDb().getConn();
/*  70: 70 */       String sql = "select * from t_subject where id=?";
/*  71: 71 */       this.ps = this.ct.prepareStatement(sql);
/*  72: 72 */       this.ps.setString(1, id);
/*  73: 73 */       this.rs = this.ps.executeQuery();
/*  74: 74 */       if (this.rs.next()) {
/*  75: 75 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/*  76: 76 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/*  77: 77 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/*  78: 78 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12), this.rs.getString(13), this.rs.getString(14));
/*  79:    */       }
/*  80: 80 */       return sb;
/*  81:    */     }
/*  82:    */     catch (Exception e)
/*  83:    */     {
/*  84: 83 */       e.printStackTrace();
/*  85: 84 */       return null;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 86 */       closeSourse();
/*  90:    */     }
/*  91:    */   }
/*  92:    */   
/*  93:    */   public SubjectBean getSubjectById(int id)
/*  65:    */   {
/*  66: 67 */     SubjectBean sb = null;
/*  67:    */     try
/*  68:    */     {
/*  69: 69 */       this.ct = new ConnDb().getConn();
/*  70: 70 */       String sql = "select * from t_subject where id=?";
/*  71: 71 */       this.ps = this.ct.prepareStatement(sql);
/*  72: 72 */       this.ps.setLong(1, id);
/*  73: 73 */       this.rs = this.ps.executeQuery();
/*  74: 74 */       if (this.rs.next()) {
/*  75: 75 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/*  76: 76 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/*  77: 77 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/*  78: 78 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12), this.rs.getString(13), this.rs.getString(14));
/*  79:    */       }
/*  80: 80 */       return sb;
/*  81:    */     }
/*  82:    */     catch (Exception e)
/*  83:    */     {
/*  84: 83 */       e.printStackTrace();
/*  85: 84 */       return null;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 86 */       closeSourse();
/*  90:    */     }
/*  91:    */   }

/*  98:    */   public ArrayList<SubjectBean> getAllSub4()
/*  99:    */   {
/* 100: 94 */     ArrayList<SubjectBean> al = new ArrayList();
/* 101: 95 */     SubjectBean sb = null;
/* 102: 96 */     Calendar date = Calendar.getInstance();
/* 103: 97 */     Calendar now = Calendar.getInstance();
/* 104: 98 */     String year = String.valueOf(now.get(1));
/* 105:    */     
/* 106:100 */     Date d = null;
/* 107:    */     try
/* 108:    */     {
/* 109:102 */       this.ct = new ConnDb().getConn();
/* 110:103 */       String sql = "select * from t_subject";
/* 111:104 */       this.ps = this.ct.prepareStatement(sql);
/* 112:105 */       this.rs = this.ps.executeQuery();
/* 113:106 */       while (this.rs.next())
/* 114:    */       {
/* 115:107 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 116:108 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 117:109 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 118:110 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 119:111 */         d = this.rs.getDate(10);
/* 120:112 */         if (d != null) {
/* 121:112 */           date.setTime(d);
/* 122:    */         }
/* 123:113 */         String y = String.valueOf(date.get(1));
/* 124:114 */         System.out.println(y);
/* 125:115 */         if (y.equals(year)) {
/* 126:117 */           al.add(sb);
/* 127:    */         }
/* 128:    */       }
/* 129:120 */       return al;
/* 130:    */     }
/* 131:    */     catch (Exception e)
/* 132:    */     {
/* 133:123 */       e.printStackTrace();
/* 134:124 */       return null;
/* 135:    */     }
/* 136:    */     finally
/* 137:    */     {
/* 138:126 */       closeSourse();
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public ArrayList<SubjectBean> getAllSub(String yuanxi)
/* 143:    */   {
/* 144:132 */     ArrayList<SubjectBean> al = new ArrayList();
/* 145:133 */     SubjectBean sb = null;
/* 146:134 */     Calendar date = Calendar.getInstance();
/* 147:135 */     Calendar now = Calendar.getInstance();
/* 148:136 */     String year = String.valueOf(now.get(1));
/* 149:    */     
/* 150:138 */     Date d = null;
/* 151:    */     try
/* 152:    */     {
/* 153:140 */       this.ct = new ConnDb().getConn();
/* 154:141 */       String sql = "select * from t_subject where yuanxi='" + yuanxi + "'order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 155:142 */       this.ps = this.ct.prepareStatement(sql);
/* 156:143 */       this.rs = this.ps.executeQuery();
/* 157:144 */       while (this.rs.next())
/* 158:    */       {
/* 159:145 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 160:146 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 161:147 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 162:148 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12), this.rs.getString(13), this.rs.getString(14));
/* 163:149 */         d = this.rs.getDate(10);
/* 164:150 */         if (d != null) {
/* 165:150 */           date.setTime(d);
/* 166:    */         }
/* 167:151 */         String y =String.valueOf(date.get(1));
/* 168:152 */         System.out.println(y);
/* 169:153 */         if (y.equals(year)) {
/* 170:155 */           al.add(sb);
/* 171:    */         }
/* 172:    */       }
/* 173:158 */       return al;
/* 174:    */     }
/* 175:    */     catch (Exception e)
/* 176:    */     {
/* 177:161 */       e.printStackTrace();
/* 178:162 */       return null;
/* 179:    */     }
/* 180:    */     finally
/* 181:    */     {
/* 182:164 */       closeSourse();
/* 183:    */     }
/* 184:    */   }
/* 185:    */   
/* 186:    */   public ArrayList<SubjectBean> getAllSub2(String yuanxi)
/* 187:    */   {
/* 188:171 */     ArrayList<SubjectBean> al = new ArrayList();
/* 189:172 */     SubjectBean sb = null;
/* 190:173 */     Calendar date = Calendar.getInstance();
/* 191:174 */     Calendar now = Calendar.getInstance();
/* 192:175 */     String year = String.valueOf(now.get(1));
/* 193:    */     
/* 194:177 */     Date d = null;
/* 195:    */     try
/* 196:    */     {
/* 197:179 */       this.ct = new ConnDb().getConn();
/* 198:180 */       String sql = "select * from t_subject where yuanxi='" + yuanxi + "' order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 199:181 */       this.ps = this.ct.prepareStatement(sql);
/* 200:182 */       this.rs = this.ps.executeQuery();
/* 201:183 */       while (this.rs.next())
/* 202:    */       {
/* 203:184 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 204:185 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 205:186 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 206:187 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 207:188 */         d = this.rs.getDate(10);
/* 208:189 */         if (d != null) {
/* 209:189 */           date.setTime(d);
/* 210:    */         }
/* 211:190 */         String y = String.valueOf(date.get(1));
/* 212:191 */         System.out.println(y);
/* 213:192 */         if (!y.equals(year)) {
/* 214:194 */           al.add(sb);
/* 215:    */         }
/* 216:    */       }
/* 217:197 */       return al;
/* 218:    */     }
/* 219:    */     catch (Exception e)
/* 220:    */     {
/* 221:200 */       e.printStackTrace();
/* 222:201 */       return null;
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:203 */       closeSourse();
/* 227:    */     }
/* 228:    */   }
/* 229:    */   
/* 230:    */   public ArrayList<SubjectBean> getAllSub1(String department)
/* 231:    */   {
/* 232:210 */     ArrayList<SubjectBean> al = new ArrayList();
/* 233:211 */     SubjectBean sb = null;
/* 234:    */     try
/* 235:    */     {
/* 236:213 */       this.ct = new ConnDb().getConn();
/* 237:214 */       String sql = "select * from  t_subject where teacher in  ( select name from t_teacher where department ='" + department + "' ) order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 238:215 */       this.ps = this.ct.prepareStatement(sql);
/* 239:216 */       this.rs = this.ps.executeQuery();
/* 240:217 */       while (this.rs.next())
/* 241:    */       {
/* 242:218 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 243:219 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 244:220 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 245:221 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 246:222 */         al.add(sb);
/* 247:    */       }
/* 248:224 */       return al;
/* 249:    */     }
/* 250:    */     catch (Exception e)
/* 251:    */     {
/* 252:227 */       e.printStackTrace();
/* 253:228 */       return null;
/* 254:    */     }
/* 255:    */     finally
/* 256:    */     {
/* 257:230 */       closeSourse();
/* 258:    */     }
/* 259:    */   }
/* 260:    */   
/* 261:    */   public ArrayList<SubjectBean> getAllSub12(String department, String xibie)
/* 262:    */   {
/* 263:237 */     ArrayList<SubjectBean> al = new ArrayList();
/* 264:238 */     SubjectBean sb = null;
/* 265:    */     try
/* 266:    */     {
/* 267:240 */       this.ct = new ConnDb().getConn();
/* 268:241 */       String sql = "select * from  t_subject where teacher in  ( select name from t_teacher where department ='" + department + "' and xibie='" + xibie + "' ) order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 269:242 */       this.ps = this.ct.prepareStatement(sql);
/* 270:243 */       this.rs = this.ps.executeQuery();
/* 271:244 */       while (this.rs.next())
/* 272:    */       {
/* 273:245 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 274:246 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 275:247 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 276:248 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 277:249 */         al.add(sb);
/* 278:    */       }
/* 279:251 */       return al;
/* 280:    */     }
/* 281:    */     catch (Exception e)
/* 282:    */     {
/* 283:254 */       e.printStackTrace();
/* 284:255 */       return null;
/* 285:    */     }
/* 286:    */     finally
/* 287:    */     {
/* 288:257 */       closeSourse();
/* 289:    */     }
/* 290:    */   }
/* 291:    */   
/* 292:    */   public int get1(String str)
/* 293:    */   {
/* 294:263 */     int count = 0;
/* 295:264 */     SubjectBean sb = null;
/* 296:    */     try
/* 297:    */     {
/* 298:266 */       this.ct = new ConnDb().getConn();
/* 299:267 */       String sql = "select sum(subNum) from t_teacher where department='" + str + "' ";
/* 300:268 */       this.ps = this.ct.prepareStatement(sql);
/* 301:269 */       this.rs = this.ps.executeQuery();
/* 302:270 */       while (this.rs.next()) {
/* 303:271 */         count = this.rs.getInt(1);
/* 304:    */       }
/* 305:    */     }
/* 306:    */     catch (Exception e)
/* 307:    */     {
/* 308:276 */       e.printStackTrace();
/* 309:    */     }
/* 310:    */     finally
/* 311:    */     {
/* 312:279 */       closeSourse();
/* 313:    */     }
/* 314:284 */     return count;
/* 315:    */   }
/* 316:    */   
/* 317:    */   public ArrayList<SubjectBean> getSubjectByNameAndDept(String teacherName, String department, String k)
/* 318:    */   {
/* 319:288 */     ArrayList<SubjectBean> al = new ArrayList();
/* 320:289 */     SubjectBean sb = null;
/* 321:    */     try
/* 322:    */     {
/* 323:291 */       String sql = "select * from t_subject where teacher like '%" + teacherName + "%' and teacher in (select name from t_teacher where  department='" + department + "')";
/* 324:292 */       if ("0".equals(department)) {
/* 325:293 */         sql = "select * from t_subject where title like '%" + k + "%'";
/* 326:    */       }
/* 327:296 */       this.ct = new ConnDb().getConn();
/* 328:297 */       this.ps = this.ct.prepareStatement(sql);
/* 329:298 */       this.rs = this.ps.executeQuery();
/* 330:299 */       while (this.rs.next())
/* 331:    */       {
/* 332:300 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 333:301 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 334:302 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 335:303 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 336:304 */         al.add(sb);
/* 337:    */       }
/* 338:    */     }
/* 339:    */     catch (Exception e)
/* 340:    */     {
/* 341:308 */       e.printStackTrace();
/* 342:    */     }
/* 343:    */     finally
/* 344:    */     {
/* 345:310 */       closeSourse();
/* 346:    */     }
/* 347:312 */     return al;
/* 348:    */   }
/* 349:    */   
				public ArrayList<SubjectBean> getSubjectByDept(String department)
/* 318:    */   {
/* 319:288 */     ArrayList<SubjectBean> al = new ArrayList();
/* 320:289 */     SubjectBean sb = null;
/* 321:    */     try
/* 322:    */     {
/* 323:291 */       String sql = "select * from t_subject where yuanxi='" + department + "' ";
/* 324:292 */       
/* 327:296 */       this.ct = new ConnDb().getConn();
/* 328:297 */       this.ps = this.ct.prepareStatement(sql);
/* 329:298 */       this.rs = this.ps.executeQuery();
/* 330:299 */       while (this.rs.next())
/* 331:    */       {
/* 332:300 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 333:301 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 334:302 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 335:303 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 336:304 */         al.add(sb);
/* 337:    */       }
/* 338:    */     }
/* 339:    */     catch (Exception e)
/* 340:    */     {
/* 341:308 */       e.printStackTrace();
/* 342:    */     }
/* 343:    */     finally
/* 344:    */     {
/* 345:310 */       closeSourse();
/* 346:    */     }
/* 347:312 */     return al;
/* 348:    */   }


/* 350:    */   public ArrayList<SubjectBean> getSubjectByYear(String teacherName, String department, String k, String year, String xibie)
/* 351:    */   {
/* 352:316 */     ArrayList<SubjectBean> al = new ArrayList();
/* 353:    */     
/* 354:318 */     SubjectBean sb = null;
/* 355:319 */     Calendar date = Calendar.getInstance();
/* 356:320 */     Date d = null;
/* 357:    */     try
/* 358:    */     {
/* 359:322 */       String sql = "select * from t_subject where yuanxi = '%" + department + "%' and teacher like '%" + teacherName + "%' and teacher in (select name from t_teacher where  department='" + department + "') and title like '%" + k + "%' and direction='" + xibie + "' ";
/* 360:323 */       if ("0".equals(xibie)) {
/* 361:324 */         sql = "select * from t_subject where yuanxi = '%" + department + "%' and teacher like '%" + teacherName + "%' and teacher in (select name from t_teacher where  department='" + department + "') and title like '%" + k + "%' ";
/* 362:    */       }
/* 363:326 */       this.ct = new ConnDb().getConn();
/* 364:327 */       this.ps = this.ct.prepareStatement(sql);
/* 365:328 */       this.rs = this.ps.executeQuery();
/* 366:    */       label388:
/* 367:329 */       for (; this.rs.next(); al.add(sb))
/* 368:    */       {
/* 369:330 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 370:331 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 371:332 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 372:333 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 373:334 */         d = this.rs.getDate(10);
/* 374:335 */         if (d != null) {
/* 375:335 */           date.setTime(d);
/* 376:    */         }
/* 377:336 */         String y = String.valueOf(date.get(1));
/* 378:340 */         if ((!year.equals(y)) && (!year.equals(""))) {
/* 379:    */           break label388;
/* 380:    */         }
/* 381:    */       }
/* 382:    */     }
/* 383:    */     catch (Exception e)
/* 384:    */     {
/* 385:344 */       e.printStackTrace();
/* 386:    */     }
/* 387:    */     finally
/* 388:    */     {
/* 389:346 */       closeSourse();
/* 390:    */     }
/* 391:348 */     return al;
/* 392:    */   }
/* 393:    */   
/* 394:    */   public ArrayList<SubjectBean> getSubByState(String state)
/* 395:    */   {
/* 396:355 */     ArrayList<SubjectBean> al = new ArrayList();
/* 397:356 */     SubjectBean sb = null;
/* 398:    */     try
/* 399:    */     {
/* 400:361 */       this.ct = new ConnDb().getConn();
/* 401:362 */       String sql = "select * from t_subject where state=?";
/* 402:363 */       this.ps = this.ct.prepareStatement(sql);
/* 403:364 */       this.ps.setString(1, state);
/* 404:365 */       this.rs = this.ps.executeQuery();
/* 405:366 */       while (this.rs.next())
/* 406:    */       {
/* 407:367 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 408:368 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 409:369 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 410:370 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 411:371 */         al.add(sb);
/* 412:    */       }
/* 413:373 */       return al;
/* 414:    */     }
/* 415:    */     catch (Exception e)
/* 416:    */     {
/* 417:376 */       e.printStackTrace();
/* 418:377 */       return null;
/* 419:    */     }
/* 420:    */     finally
/* 421:    */     {
/* 422:379 */       closeSourse();
/* 423:    */     }
/* 424:    */   }
/* 425:    */   
/* 426:    */   public ArrayList<SubjectBean> getSubByState1(String state, String department)
/* 427:    */   {
/* 428:385 */     ArrayList<SubjectBean> al = new ArrayList();
/* 429:386 */     SubjectBean sb = null;
/* 430:387 */     if (state.equals("all")) {
/* 431:388 */       return getAllSub1(department);
/* 432:    */     }
/* 433:    */     try
/* 434:    */     {
/* 435:391 */       this.ct = new ConnDb().getConn();
/* 436:    */       
/* 437:393 */       String sql = "select * from  t_subject where state = '" + state + "' and teacher in  ( select name from t_teacher where department ='" + department + "' ) order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 438:    */       
/* 439:395 */       this.ps = this.ct.prepareStatement(sql);
/* 440:    */       
/* 441:397 */       this.rs = this.ps.executeQuery();
/* 442:398 */       while (this.rs.next())
/* 443:    */       {
/* 444:399 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 445:400 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 446:401 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 447:402 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 448:403 */         al.add(sb);
/* 449:    */       }
/* 450:405 */       return al;
/* 451:    */     }
/* 452:    */     catch (Exception e)
/* 453:    */     {
/* 454:408 */       e.printStackTrace();
/* 455:409 */       return null;
/* 456:    */     }
/* 457:    */     finally
/* 458:    */     {
/* 459:411 */       closeSourse();
/* 460:    */     }
/* 461:    */   }
/* 462:    */   
/* 463:    */   public ArrayList<SubjectBean> getSubByState3(String state, String department, String xibie)
/* 464:    */   {
/* 465:418 */     ArrayList<SubjectBean> al = new ArrayList();
/* 466:419 */     SubjectBean sb = null;
/* 467:420 */     if (state.equals("all")) {
/* 468:421 */       return getAllSub12(department, xibie);
/* 469:    */     }
/* 470:    */     try
/* 471:    */     {
/* 472:424 */       this.ct = new ConnDb().getConn();
/* 473:    */       
/* 474:426 */       String sql = "select * from  t_subject where state = '" + state + "' and teacher in  ( select name from t_teacher where department ='" + department + "' and xibie='" + xibie + "') order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 475:    */       
/* 476:428 */       this.ps = this.ct.prepareStatement(sql);
/* 477:    */       
/* 478:430 */       this.rs = this.ps.executeQuery();
/* 479:431 */       while (this.rs.next())
/* 480:    */       {
/* 481:432 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 482:433 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 483:434 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 484:435 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 485:436 */         al.add(sb);
/* 486:    */       }
/* 487:438 */       return al;
/* 488:    */     }
/* 489:    */     catch (Exception e)
/* 490:    */     {
/* 491:441 */       e.printStackTrace();
/* 492:442 */       return null;
/* 493:    */     }
/* 494:    */     finally
/* 495:    */     {
/* 496:444 */       closeSourse();
/* 497:    */     }
/* 498:    */   }
/* 499:    */   
/* 500:    */   public ArrayList<SubjectBean> getSubByState2(String state, String department)
/* 501:    */   {
/* 502:450 */     ArrayList<SubjectBean> al = new ArrayList();
/* 503:451 */     SubjectBean sb = null;
/* 504:452 */     if (state.equals("all")) {
/* 505:453 */       return getAllSub1(department);
/* 506:    */     }
/* 507:    */     try
/* 508:    */     {
/* 509:456 */       this.ct = new ConnDb().getConn();
/* 510:457 */       String sql = "select * from  t_subject where state = '" + state + "' and teacher in  ( select name from t_teacher where department ='" + department + "' ) order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
/* 511:458 */       this.ps = this.ct.prepareStatement(sql);
/* 512:459 */       this.rs = this.ps.executeQuery();
/* 513:460 */       while (this.rs.next())
/* 514:    */       {
/* 515:461 */         sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
/* 516:462 */           this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
/* 517:463 */           this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
/* 518:464 */           this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
/* 519:465 */         al.add(sb);
/* 520:    */       }
/* 521:467 */       return al;
/* 522:    */     }
/* 523:    */     catch (Exception e)
/* 524:    */     {
/* 525:470 */       e.printStackTrace();
/* 526:471 */       return null;
/* 527:    */     }
/* 528:    */     finally
/* 529:    */     {
/* 530:473 */       closeSourse();
/* 531:    */     }
/* 532:    */   }
/* 533:    */   
/* 534:    */   public int delSubjectById(String id)
/* 535:    */   {
/* 536:496 */     return modifySubject("delete from t_subject where id='" + id + "'");
/* 537:    */   }
/* 538:    */   
/* 539:    */   public int modifySubject(String sql)
/* 540:    */   {
/* 541:501 */     int i = 0;
/* 542:    */     try
/* 543:    */     {
/* 544:503 */       this.ct = new ConnDb().getConn();
/* 545:504 */       this.ps = this.ct.prepareStatement(sql);
/* 546:    */       
/* 547:506 */       i = this.ps.executeUpdate(sql);
/* 548:    */       
/* 549:508 */       return i;
/* 550:    */     }
/* 551:    */     catch (Exception e)
/* 552:    */     {
/* 553:511 */       e.printStackTrace();
/* 554:512 */       return -1;
/* 555:    */     }
/* 556:    */     finally
/* 557:    */     {
/* 558:514 */       closeSourse();
/* 559:    */     }
/* 560:    */   }
/* 561:    */   
/* 562:    */   public void closeSourse()
/* 563:    */   {
/* 564:    */     try
/* 565:    */     {
/* 566:521 */       if (this.rs != null)
/* 567:    */       {
/* 568:522 */         this.rs.close();
/* 569:523 */         this.rs = null;
/* 570:    */       }
/* 571:525 */       if (this.ps != null)
/* 572:    */       {
/* 573:526 */         this.ps.close();
/* 574:527 */         this.ps = null;
/* 575:    */       }
/* 576:529 */       if (this.ct != null)
/* 577:    */       {
/* 578:530 */         this.ct.close();
/* 579:531 */         this.ct = null;
/* 580:    */       }
/* 581:    */     }
/* 582:    */     catch (SQLException e)
/* 583:    */     {
/* 584:535 */       e.printStackTrace();
/* 585:    */     }
/* 586:    */   }
/* 587:    */   
/* 588:    */   public int[] getSubIdsByTitle(String title)
/* 589:    */   {
/* 590:541 */     int[] subIds = null;
/* 591:542 */     int i = 0;
/* 592:    */     try
/* 593:    */     {
/* 594:544 */       this.ct = new ConnDb().getConn();
/* 595:545 */       String sql = "select count(*) from t_subject where title=?";
/* 596:546 */       this.ps = this.ct.prepareStatement(sql);
/* 597:547 */       this.ps.setString(1, title);
/* 598:548 */       this.rs = this.ps.executeQuery();
/* 599:549 */       if (this.rs.next()) {
/* 600:549 */         i = this.rs.getInt(1);
/* 601:    */       }
/* 602:550 */       System.out.println("title=" + title + "\t i=" + i);
/* 603:551 */       if (i == 0) {
/* 604:552 */         return null;
/* 605:    */       }
/* 606:554 */       subIds = new int[i];
/* 607:555 */       sql = "select id from t_subject where title=?";
/* 608:556 */       this.ps = this.ct.prepareStatement(sql);
/* 609:557 */       this.ps.setString(1, title);
/* 610:558 */       this.rs = this.ps.executeQuery();
/* 611:    */       
/* 612:560 */       i = 0;
/* 613:561 */       while (this.rs.next()) {
/* 614:562 */         subIds[(i++)] = this.rs.getInt(1);
/* 615:    */       }
/* 616:565 */       return subIds;
/* 617:    */     }
/* 618:    */     catch (Exception e)
/* 619:    */     {
/* 620:568 */       e.printStackTrace();
/* 621:569 */       return null;
/* 622:    */     }
/* 623:    */     finally
/* 624:    */     {
/* 625:571 */       closeSourse();
/* 626:    */     }
/* 627:    */   }
/* 628:    */   
/* 629:    */   public int verifyById(String subId, int state)
/* 630:    */   {
/* 631:578 */     int i = 0;
/* 632:579 */     String sql = "update t_subject set state=? where id=?";
/* 633:    */     try
/* 634:    */     {
/* 635:581 */       this.ct = new ConnDb().getConn();
/* 636:582 */       this.ps = this.ct.prepareStatement(sql);
/* 637:583 */       this.ps.setInt(1, state);
/* 638:584 */       this.ps.setString(2, subId);
/* 639:585 */       i = this.ps.executeUpdate();
/* 640:586 */       return i;
/* 641:    */     }
/* 642:    */     catch (Exception e)
/* 643:    */     {
/* 644:589 */       e.printStackTrace();
/* 645:590 */       return -1;
/* 646:    */     }
/* 647:    */     finally
/* 648:    */     {
/* 649:592 */       closeSourse();
/* 650:    */     }
/* 651:    */   }
/* 652:    */   
/* 653:    */   public void verifyByIds(String[] subIds, int state)
/* 654:    */   {
/* 655:599 */     for (int i = 0; i < subIds.length; i++) {
/* 656:600 */       verifyById(subIds[i], state);
/* 657:    */     }
/* 658:    */   }
/* 659:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.SubjectBeanCl
 * JD-Core Version:    0.7.0.1
 */