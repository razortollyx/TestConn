/*    1:     */ package com.kk.subject.model;
/*    2:     */ 
/*    3:     */ import com.ax.subject.model.ConnDb;
/*    4:     */ import java.io.PrintStream;
/*    5:     */ import java.sql.Connection;
/*    6:     */ import java.sql.PreparedStatement;
/*    7:     */ import java.sql.ResultSet;
/*    8:     */ import java.sql.SQLException;
import java.util.ArrayList;
/*   10:     */ 
/*   11:     */ public class StuSubTeaBeanCl
/*   12:     */ {
/*   13:     */   private Connection ct;
/*   14:     */   private PreparedStatement ps;
/*   15:     */   private ResultSet rs;
/*   16:     */   private Connection ct1;
/*   17:     */   private PreparedStatement ps1;
/*   18:     */   private ResultSet rs1;
/*   19:     */   private Connection ct2;
/*   20:     */   private PreparedStatement ps2;
/*   21:     */   private ResultSet rs2;
/*   22:     */   private Connection ct3;
/*   23:     */   private PreparedStatement ps3;
/*   24:     */   private ResultSet rs3;
/*   25:     */   private Connection ct4;
/*   26:     */   private PreparedStatement ps4;
/*   27:     */   private ResultSet rs4;
/*   28:  28 */   static int recursion = 0;
/*   29:     */   
/*   30:     */   public ArrayList<StuSubTeaBean> getAllSSTBbySubID(String subid)
/*   31:     */   {
/*   32:  31 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*   33:     */     
/*   34:  33 */     String sql = "select * from t_stu_sub where sub_Id ='" + subid + "'";
/*   35:     */     try
/*   36:     */     {
/*   37:  35 */       this.ct = new ConnDb().getConn();
/*   38:  36 */       this.ps = this.ct.prepareStatement(sql);
/*   39:  37 */       this.rs = this.ps.executeQuery();
/*   40:  38 */       while (this.rs.next())
/*   41:     */       {
/*   42:  39 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*   43:  40 */         sstb.setStuId(this.rs.getString(1));
/*   44:  41 */         sstb.setSubId(this.rs.getInt(2));
/*   45:  42 */         sstb.setWish(this.rs.getInt(3));
/*   46:  43 */         sstb.setState(this.rs.getInt(4));
/*   47:  44 */         sstb.setTotal(this.rs.getInt(5));
/*   48:  45 */         AllSSTB.add(sstb);
/*   49:     */       }
/*   50:  47 */       return AllSSTB;
/*   51:     */     }
/*   52:     */     catch (Exception e)
/*   53:     */     {
/*   54:  50 */       e.printStackTrace();
/*   55:  51 */       return null;
/*   56:     */     }
/*   57:     */     finally
/*   58:     */     {
/*   59:  53 */       closeSourse();
/*   60:     */     }
/*   61:     */   }
/*   62:     */   
/*   63:     */   public ArrayList<StuSubTeaBean> getAllSSTBbyStuID(String stuid)
/*   64:     */   {
/*   65:  58 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*   66:     */     
/*   67:  60 */     String sql = "select * from t_stu_sub where stu_Id ='" + stuid + "'";
/*   68:     */     try
/*   69:     */     {
/*   70:  62 */       this.ct = new ConnDb().getConn();
/*   71:  63 */       this.ps = this.ct.prepareStatement(sql);
/*   72:  64 */       this.rs = this.ps.executeQuery();
/*   73:  65 */       while (this.rs.next())
/*   74:     */       {
/*   75:  66 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*   76:  67 */         sstb.setStuId(this.rs.getString(1));
/*   77:  68 */         sstb.setSubId(this.rs.getInt(2));
/*   78:  69 */         sstb.setWish(this.rs.getInt(3));
/*   79:  70 */         sstb.setState(this.rs.getInt(4));
/*   80:  71 */         sstb.setTotal(this.rs.getInt(5));
/*   81:  72 */         AllSSTB.add(sstb);
/*   82:     */       }
/*   83:  74 */       return AllSSTB;
/*   84:     */     }
/*   85:     */     catch (Exception e)
/*   86:     */     {
/*   87:  77 */       e.printStackTrace();
/*   88:  78 */       return null;
/*   89:     */     }
/*   90:     */     finally
/*   91:     */     {
/*   92:  80 */       closeSourse();
/*   93:     */     }
/*   94:     */   }
/*   95:     */   
/*   96:     */   public int[] getAllSSTBbySubIDandState(String subid)
/*   97:     */   {
/*   98:  87 */     int i = 0;
/*   99:  88 */     int[] a = new int[10000];
/*  100:     */     
/*  101:  90 */     System.out.println(subid);
/*  102:  91 */     String sql = "select * from t_stu_sub where sub_Id ='" + subid + "' ";
/*  103:     */     try
/*  104:     */     {
/*  105:  93 */       this.ct = new ConnDb().getConn();
/*  106:  94 */       this.ps = this.ct.prepareStatement(sql);
/*  107:  95 */       this.rs = this.ps.executeQuery();
/*  108:  96 */       while (this.rs.next()) {
/*  109:  97 */         if (this.rs.getInt(4) != 0)
/*  110:     */         {
/*  111:  98 */           System.out.println(this.rs.getInt(4));
/*  112:  99 */           a[i] = this.rs.getInt(4);
/*  113: 100 */           i++;
/*  114:     */         }
/*  115:     */       }
/*  116: 103 */       return a;
/*  117:     */     }
/*  118:     */     catch (Exception e)
/*  119:     */     {
/*  120:     */       int[] arrayOfInt1;
/*  121: 106 */       e.printStackTrace();
/*  122: 107 */       return a;
/*  123:     */     }
/*  124:     */     finally
/*  125:     */     {
/*  126: 109 */       closeSourse();
/*  127:     */     }
/*  128:     */   }
/*  129:     */   
/*  130:     */   public int SetAll(String stuId, String subId, String State, String total)
/*  131:     */   {
/*  132: 118 */     int r = 0;
/*  133: 119 */     String sql = "update t_stu_sub set state='" + State + 
/*  134: 120 */       "' where stu_id=? and sub_id=?";
/*  135:     */     try
/*  136:     */     {
/*  137: 122 */       this.ct = new ConnDb().getConn();
/*  138:     */       
/*  139:     */ 
/*  140: 125 */       this.ps = this.ct.prepareStatement(sql);
/*  141: 126 */       this.ps.setString(1, stuId);
/*  142: 127 */       this.ps.setString(2, subId);
/*  143: 128 */       r += this.ps.executeUpdate();
/*  144:     */       
/*  145:     */ 
/*  146: 131 */       sql = "update t_stu_sub set total='" + total + 
/*  147: 132 */         "' where stu_id=? and sub_id=?";
/*  148: 133 */       this.ps = this.ct.prepareStatement(sql);
/*  149: 134 */       this.ps.setString(1, stuId);
/*  150: 135 */       this.ps.setString(2, subId);
/*  151: 136 */       r += this.ps.executeUpdate();
/*  152: 137 */       return r;
/*  153:     */     }
/*  154:     */     catch (Exception e)
/*  155:     */     {
/*  156: 140 */       e.printStackTrace();
/*  157: 141 */       return -1;
/*  158:     */     }
/*  159:     */     finally
/*  160:     */     {
/*  161: 143 */       closeSourse();
/*  162:     */     }
/*  163:     */   }
/*  164:     */   
/*  165:     */   public int ChangeAll(String subId, String state)
/*  166:     */   {
/*  167: 152 */     System.out.println(subId + "XXX");
/*  168: 153 */     int r = 0;
/*  169: 154 */     String sql = "update t_stu_sub set state='0',total='0' where sub_id = '" + 
/*  170: 155 */       subId + "' and state='" + state + "'";
/*  171:     */     try
/*  172:     */     {
/*  173: 157 */       this.ct = new ConnDb().getConn();
/*  174: 158 */       this.ps = this.ct.prepareStatement(sql);
/*  175: 159 */       this.ps.executeUpdate();
/*  176: 160 */       return 1;
/*  177:     */     }
/*  178:     */     catch (Exception e)
/*  179:     */     {
/*  180: 163 */       e.printStackTrace();
/*  181: 164 */       return -1;
/*  182:     */     }
/*  183:     */     finally
/*  184:     */     {
/*  185: 166 */       closeSourse();
/*  186:     */     }
/*  187:     */   }
/*  188:     */   
/*  189:     */   public int chooseStu(String stuId, String subId, String State, String total)
/*  190:     */   {
/*  191: 176 */     int r = 0;
/*  192: 177 */     String sql = "update t_stu_sub set finally=1 where stu_id=? and sub_id=? and state=? and total=?";
/*  193:     */     try
/*  194:     */     {
/*  195: 179 */       this.ct = new ConnDb().getConn();
/*  196:     */       
/*  197:     */ 
/*  198: 182 */       this.ps = this.ct.prepareStatement(sql);
/*  199: 183 */       this.ps.setString(1, stuId);
/*  200: 184 */       this.ps.setString(2, subId);
/*  201: 185 */       this.ps.setString(3, State);
/*  202: 186 */       this.ps.setString(4, total);
/*  203: 187 */       r += this.ps.executeUpdate();
/*  204:     */       
/*  205:     */ 
/*  206:     */ 
/*  207:     */ 
/*  208:     */ 
/*  209:     */ 
/*  210:     */ 
/*  211:     */ 
/*  212:     */ 
/*  213:     */ 
/*  214: 198 */       sql = "update t_stu_sub set finally=0 where sub_id=? and stu_id<>?";
/*  215: 199 */       this.ps = this.ct.prepareStatement(sql);
/*  216: 200 */       this.ps.setString(1, subId);
/*  217: 201 */       this.ps.setString(2, stuId);
/*  218: 202 */       r += this.ps.executeUpdate();
/*  219:     */       
/*  220: 204 */       sql = "update t_stu_sub set finally=0 where stu_id=? and sub_id<>?";
/*  221: 205 */       this.ps = this.ct.prepareStatement(sql);
/*  222: 206 */       this.ps.setString(1, stuId);
/*  223: 207 */       this.ps.setString(2, subId);
/*  224: 208 */       r += this.ps.executeUpdate();
/*  225: 209 */       return r;
/*  226:     */     }
/*  227:     */     catch (Exception e)
/*  228:     */     {
/*  229: 212 */       e.printStackTrace();
/*  230: 213 */       return -1;
/*  231:     */     }
/*  232:     */     finally
/*  233:     */     {
/*  234: 215 */       closeSourse();
/*  235:     */     }
/*  236:     */   }
/*  237:     */   
/*  238:     */   public int repeal(String stuId, String subId)
/*  239:     */   {
/*  240: 225 */     int r = 0;
/*  241: 226 */     String sql = "update t_stu_sub set state=0 ,total=0 where stu_id=? and sub_id=?";
/*  242:     */     try
/*  243:     */     {
/*  244: 228 */       this.ct = new ConnDb().getConn();
/*  245:     */       
/*  246:     */ 
/*  247: 231 */       this.ps = this.ct.prepareStatement(sql);
/*  248: 232 */       this.ps.setString(1, stuId);
/*  249: 233 */       this.ps.setString(2, subId);
/*  250: 234 */       r = this.ps.executeUpdate();
/*  251:     */       
/*  252:     */ 
/*  253:     */ 
/*  254:     */ 
/*  255:     */ 
/*  256:     */ 
/*  257:     */ 
/*  258:     */ 
/*  259:     */ 
/*  260:     */ 
/*  261:     */ 
/*  262:     */ 
/*  263:     */ 
/*  264: 248 */       return r;
/*  265:     */     }
/*  266:     */     catch (Exception e)
/*  267:     */     {
/*  268: 251 */       e.printStackTrace();
/*  269: 252 */       return -1;
/*  270:     */     }
/*  271:     */     finally
/*  272:     */     {
/*  273: 254 */       closeSourse();
/*  274:     */     }
/*  275:     */   }
/*  276:     */   
/*  277:     */   public ArrayList<StuSubTeaBean> getAllSSTB(String teaId)
/*  278:     */   {
/*  279: 259 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  280:     */     
/*  281: 261 */     String sql = "select * from t_stu_sub where sub_Id in (select s_id from t_teacher_sub where t_id=?)";
/*  282:     */     try
/*  283:     */     {
/*  284: 263 */       this.ct = new ConnDb().getConn();
/*  285: 264 */       this.ps = this.ct.prepareStatement(sql);
/*  286: 265 */       this.ps.setString(1, teaId);
/*  287: 266 */       this.rs = this.ps.executeQuery();
/*  288: 267 */       while (this.rs.next())
/*  289:     */       {
/*  290: 268 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  291: 269 */         sstb.setStuId(this.rs.getString(1));
/*  292: 270 */         sstb.setSubId(this.rs.getInt(2));
/*  293: 271 */         sstb.setWish(this.rs.getInt(3));
/*  294: 272 */         sstb.setState(this.rs.getInt(4));
/*  295: 273 */         sstb.setTeaName(new SubjectBeanCl()
/*  296: 274 */           .getSubjectById(this.rs.getInt(2)).getTeacher());
/*  297: 275 */         sstb.setSubTitle(new SubjectBeanCl().getSubjectById(
/*  298: 276 */           this.rs.getInt(2)).getTitle());
/*  299: 277 */         sstb.setStuName(new StudentBeanCl().getStuById(String.valueOf(this.rs.getInt(1))).getName());
/*  301: 279 */         AllSSTB.add(sstb);
/*  302:     */       }
/*  303: 281 */       return AllSSTB;
/*  304:     */     }
/*  305:     */     catch (Exception e)
/*  306:     */     {
/*  307: 284 */       e.printStackTrace();
/*  308: 285 */       return null;
/*  309:     */     }
/*  310:     */     finally
/*  311:     */     {
/*  312: 287 */       closeSourse();
/*  313:     */     }
/*  314:     */   }
/*  315:     */   
/*  316:     */   public ArrayList<StuSubTeaBean> ExcelgetAllSSTB(String yuanxi)
/*  317:     */   {
/*  318: 395 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  319:     */     try
/*  320:     */     {
/*  321: 398 */       this.ct = new ConnDb().getConn();
/*  322: 399 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub where finally='1' and yuanxi='" + yuanxi + "'order by stu_Id ");
/*  323: 400 */       this.rs = this.ps.executeQuery();
/*  324:     */       
/*  325:     */ 
/*  326:     */ 
/*  327:     */ 
/*  328: 405 */       TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
/*  329: 406 */       TeacherBeanCl tbc = new TeacherBeanCl();
/*  330: 407 */       SubjectBeanCl sbc = new SubjectBeanCl();
/*  331: 408 */       StudentBeanCl stubc = new StudentBeanCl();
/*  332: 413 */       while (this.rs.next())
/*  333:     */       {
/*  334: 414 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  335: 415 */         sstb.setStuId(this.rs.getString(1));
/*  336: 416 */         sstb.setSubId(this.rs.getInt(2));
/*  337: 417 */         sstb.setWish(this.rs.getInt(3));
/*  338: 418 */         sstb.setState(this.rs.getInt(4));
/*  339: 419 */         sstb.setChoose(this.rs.getInt(6));
/*  346: 426 */         String teaId = tsbc.getTeaId(sstb.getSubId());
/*  347: 427 */         sstb.setTeaName(tbc.getTeacherById(teaId).getName());
/*  348: 428 */         sstb.setSubTitle(sbc.getSubjectById(String.valueOf(this.rs.getInt(2))).getTitle());
/*  349: 429 */         sstb.setStuName(stubc.getStuById(this.rs.getString(1)).getName());
/*  350:     */         
/*  351: 431 */         AllSSTB.add(sstb);
/*  352:     */       }
/*  353: 434 */       return AllSSTB;
/*  354:     */     }
/*  355:     */     catch (Exception e)
/*  356:     */     {
/*  357: 437 */       e.printStackTrace();
/*  358: 438 */       return null;
/*  359:     */     }
/*  360:     */     finally
/*  361:     */     {
/*  362: 440 */       closeSourse();
/*  363:     */     }
/*  364:     */   }
/*  365:     */   
/*  366:     */   public ArrayList<StuSubTeaBean> getAllSSTB()
/*  367:     */   {
/*  368: 445 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  369:     */     try
/*  370:     */     {
/*  371: 448 */       this.ct = new ConnDb().getConn();
/*  372: 449 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub order by sub_id");
/*  373: 450 */       this.rs = this.ps.executeQuery();
/*  374: 465 */       while (this.rs.next())
/*  375:     */       {
/*  376: 466 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  377: 467 */         sstb.setStuId(this.rs.getString(1));
/*  378: 468 */         sstb.setSubId(this.rs.getInt(2));
/*  379: 469 */         sstb.setWish(this.rs.getInt(3));
/*  380: 470 */         sstb.setState(this.rs.getInt(4));
/*  381:     */         
/*  382:     */ 
/*  383:     */ 
/*  384:     */ 
/*  385:     */ 
/*  386:     */ 
/*  387:     */ 
/*  388:     */ 
/*  389:     */ 
/*  390:     */ 
/*  391:     */ 
/*  392:     */ 
/*  393: 483 */         sstb.setTeaName("");
/*  394: 484 */         sstb.setSubTitle("");
/*  395: 485 */         sstb.setStuName("");
/*  396:     */         
/*  397:     */ 
/*  398:     */ 
/*  399:     */ 
/*  400: 490 */         AllSSTB.add(sstb);
/*  401:     */       }
/*  402: 493 */       return AllSSTB;
/*  403:     */     }
/*  404:     */     catch (Exception e)
/*  405:     */     {
/*  406: 496 */       e.printStackTrace();
/*  407: 497 */       return null;
/*  408:     */     }
/*  409:     */     finally
/*  410:     */     {
/*  411: 499 */       closeSourse();
/*  412:     */     }
/*  413:     */   }
/*  414:     */   
/*  415:     */   public ArrayList<StuSubTeaBean> getAllSSTB2(String teaId)
/*  416:     */   {
/*  417: 504 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  418:     */     try
/*  419:     */     {
/*  420: 507 */       this.ct = new ConnDb().getConn();
/*  421: 508 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub where sub_id in (select s_id from t_teacher_sub where t_id='" + 
/*  422: 509 */         teaId + "' ) order by wish ASC ");
/*  423: 510 */       this.rs = this.ps.executeQuery();
/*  424: 525 */       while (this.rs.next())
/*  425:     */       {
/*  426: 526 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  427: 527 */         sstb.setStuId(this.rs.getString(1));
/*  428: 528 */         sstb.setSubId(this.rs.getInt(2));
/*  429: 529 */         sstb.setWish(this.rs.getInt(3));
/*  430: 530 */         sstb.setState(this.rs.getInt(4));
/*  431:     */         
/*  432:     */ 
/*  433:     */ 
/*  434:     */ 
/*  435:     */ 
/*  436:     */ 
/*  437:     */ 
/*  438:     */ 
/*  439:     */ 
/*  440:     */ 
/*  441:     */ 
/*  442:     */ 
/*  443: 543 */         sstb.setTeaName("");
/*  444: 544 */         sstb.setSubTitle("");
/*  445: 545 */         sstb.setStuName("");
/*  446:     */         
/*  447:     */ 
/*  448:     */ 
/*  449:     */ 
/*  450: 550 */         AllSSTB.add(sstb);
/*  451:     */       }
/*  452: 553 */       return AllSSTB;
/*  453:     */     }
/*  454:     */     catch (Exception e)
/*  455:     */     {
/*  456: 556 */       e.printStackTrace();
/*  457: 557 */       return null;
/*  458:     */     }
/*  459:     */     finally
/*  460:     */     {
/*  461: 559 */       closeSourse();
/*  462:     */     }
/*  463:     */   }
/*  464:     */   
/*  465:     */   public ArrayList<StuSubTeaBean> getAllSSTB3(String teaId)
/*  466:     */   {
/*  467: 564 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  468:     */     try
/*  469:     */     {
/*  470: 567 */       this.ct = new ConnDb().getConn();
/*  471: 568 */       this.ps = this.ct.prepareStatement("select * from stuselecttitle where title1 in (select s_id from t_teacher_sub where t_id='" + 
/*  472: 569 */         teaId + 
/*  473: 570 */         "' ) or title2  in (select s_id from t_teacher_sub where t_id='" + 
/*  474: 571 */         teaId + 
/*  475: 572 */         "' )or title3  in (select s_id from t_teacher_sub where t_id='" + 
/*  476: 573 */         teaId + 
/*  477: 574 */         "' )or title4 in (select s_id from t_teacher_sub where t_id='" + 
/*  478: 575 */         teaId + 
/*  479: 576 */         "' or title5 in (select s_id from t_teacher_sub where t_id='" + 
/*  480: 577 */         teaId + 
/*  481: 578 */         "' )or title6  in (select s_id from t_teacher_sub where t_id='" + 
/*  482: 579 */         teaId + "' )) ");
/*  483: 580 */       this.rs = this.ps.executeQuery();
/*  484: 595 */       while (this.rs.next())
/*  485:     */       {
/*  486: 596 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  487: 597 */         sstb.setStuId(this.rs.getString(1));
/*  488: 598 */         sstb.setSubId(this.rs.getInt(2));
/*  489: 599 */         sstb.setTeaName("");
/*  490: 600 */         sstb.setSubTitle("");
/*  491: 601 */         sstb.setStuName("");
/*  492: 602 */         System.out.println("查询成功");
/*  493:     */         
/*  494:     */ 
/*  495:     */ 
/*  496:     */ 
/*  497:     */ 
/*  498:     */ 
/*  499:     */ 
/*  500:     */ 
/*  501:     */ 
/*  502:     */ 
/*  503:     */ 
/*  504:     */ 
/*  505:     */ 
/*  506:     */ 
/*  507:     */ 
/*  508: 618 */         AllSSTB.add(sstb);
/*  509:     */       }
/*  510: 621 */       return AllSSTB;
/*  511:     */     }
/*  512:     */     catch (Exception e)
/*  513:     */     {
/*  514: 624 */       e.printStackTrace();
/*  515: 625 */       return null;
/*  516:     */     }
/*  517:     */     finally
/*  518:     */     {
/*  519: 627 */       closeSourse();
/*  520:     */     }
/*  521:     */   }
/*  522:     */   
/*  523:     */   public ArrayList<StuSubTeaBean> getAllSSTB3()
/*  524:     */   {
/*  525: 632 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  526:     */     try
/*  527:     */     {
/*  528: 635 */       this.ct = new ConnDb().getConn();
/*  529: 636 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub ");
/*  530: 637 */       this.rs = this.ps.executeQuery();
/*  531:     */       
/*  532:     */ 
/*  533:     */ 
/*  534:     */ 
/*  535: 642 */       TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
/*  536: 643 */       TeacherBeanCl tbc = new TeacherBeanCl();
/*  537: 644 */       SubjectBeanCl sbc = new SubjectBeanCl();
/*  538: 645 */       StudentBeanCl stubc = new StudentBeanCl();
/*  539: 650 */       while (this.rs.next())
/*  540:     */       {
/*  541: 651 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  542: 652 */         String teaId = tsbc.getTeaId(sstb.getSubId());
/*  543:     */         
/*  544: 654 */         sstb.setStuId(this.rs.getString(1));
/*  545: 655 */         sstb.setSubId(this.rs.getInt(2));
/*  546:     */         
/*  547: 657 */         sstb.setWish(this.rs.getInt(3));
/*  548:     */         
/*  549: 659 */         sstb.setStuName(stubc.getStuById(String.valueOf(this.rs.getInt(1))).getName());
/*  550: 660 */         sstb.setTeaName(tbc.getTeacherById(teaId).getName());
/*  551: 661 */         sstb.setSubTitle(sbc.getSubjectById(this.rs.getInt(2)).getTitle());
/*  552: 662 */         sstb.setState(this.rs.getInt(8));
/*  553:     */         
/*  554:     */ 
/*  555:     */ 
/*  556:     */ 
/*  557:     */ 
/*  558:     */ 
/*  559:     */ 
/*  560:     */ 
/*  561:     */ 
/*  562:     */ 
/*  563:     */ 
/*  564:     */ 
/*  565:     */ 
/*  566:     */ 
/*  567:     */ 
/*  568:     */ 
/*  569:     */ 
/*  570: 680 */         AllSSTB.add(sstb);
/*  571:     */       }
/*  572: 683 */       return AllSSTB;
/*  573:     */     }
/*  574:     */     catch (Exception e)
/*  575:     */     {
/*  576: 686 */       e.printStackTrace();
/*  577: 687 */       return null;
/*  578:     */     }
/*  579:     */     finally
/*  580:     */     {
/*  581: 689 */       closeSourse();
/*  582:     */     }
/*  583:     */   }
/*  584:     */   
/*  585:     */   public ArrayList<StuSubTeaBean> getAllSSTB1(String department)
/*  586:     */   {
/*  587: 694 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  588:     */     try
/*  589:     */     {
/*  590: 698 */       this.ct = new ConnDb().getConn();
/*  591: 699 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub where sub_id in (select s_id from t_teacher_sub where t_id in (select id from t_teacher where  department='" + 
/*  592: 700 */         department + "')) and finally='1' order by total, state");
/*  593:     */       
/*  594:     */ 
/*  595: 703 */       this.rs = this.ps.executeQuery();
/*  596:     */       
/*  597:     */ 
/*  598:     */ 
/*  599:     */ 
/*  600: 708 */       TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
/*  601: 709 */       TeacherBeanCl tbc = new TeacherBeanCl();
/*  602: 710 */       SubjectBeanCl sbc = new SubjectBeanCl();
/*  603: 711 */       StudentBeanCl stubc = new StudentBeanCl();
/*  604: 716 */       while (this.rs.next())
/*  605:     */       {
/*  606: 717 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  607: 718 */         sstb.setStuId(this.rs.getString(1));
/*  608: 719 */         sstb.setSubId(this.rs.getInt(2));
/*  609: 720 */         sstb.setWish(this.rs.getInt(3));
/*  610: 721 */         sstb.setState(this.rs.getInt(4));
/*  611: 722 */         sstb.setChoose(this.rs.getInt(6));
/*  612:     */         
/*  613:     */ 
/*  614:     */ 
/*  615:     */ 
/*  616:     */ 
/*  617:     */ 
/*  618:     */ 
/*  619:     */ 
/*  620:     */ 
/*  621:     */ 
/*  622:     */ 
/*  623:     */ 
/*  624: 735 */         sstb.setTeaName("");
/*  625: 736 */         sstb.setSubTitle("");
/*  626: 737 */         sstb.setStuName("");
/*  627:     */         
/*  628:     */ 
/*  629:     */ 
/*  630:     */ 
/*  631: 742 */         AllSSTB.add(sstb);
/*  632:     */       }
/*  633: 745 */       return AllSSTB;
/*  634:     */     }
/*  635:     */     catch (Exception e)
/*  636:     */     {
/*  637: 748 */       e.printStackTrace();
/*  638: 749 */       return null;
/*  639:     */     }
/*  640:     */     finally
/*  641:     */     {
/*  642: 751 */       closeSourse();
/*  643:     */     }
/*  644:     */   }
/*  645:     */   
/*  646:     */   public ArrayList<StuSubTeaBean> getMyAllResult(String teacherName, String department)
/*  647:     */   {
/*  648: 757 */     System.out.println(department);
/*  649: 758 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  650:     */     try
/*  651:     */     {
/*  652: 761 */       String sql = "select * from t_stu_sub where sub_id in( select s_id	 from t_teacher_sub where t_id in (select id from t_teacher where name like '%" + 
/*  653: 762 */         teacherName + 
/*  654: 763 */         "%' ))" + 
/*  655: 764 */         "and sub_id in (select s_id from t_teacher_sub where t_id in (select id from t_teacher where  department='" + 
/*  656: 765 */         department + "')) order by sub_id , total ,state";
/*  657: 766 */       if ("0".equals(department)) {
/*  658: 767 */         sql = 
/*  659: 768 */           "select * from t_stu_sub where sub_id in( select s_id from t_teacher_sub where t_id in (select id from t_teacher where name like '%" + teacherName + "%' )) order by sub_id";
/*  660: 769 */       } else if ((teacherName == null) && ("0".equals(department))) {
/*  661: 770 */         sql = "select * from t_stu_sub order by sub_id";
/*  662:     */       }
/*  663: 772 */       this.ct = new ConnDb().getConn();
/*  664: 773 */       this.ps = this.ct.prepareStatement(sql);
/*  665: 774 */       this.rs = this.ps.executeQuery();
/*  666: 787 */       while (this.rs.next())
/*  667:     */       {
/*  668: 788 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  669: 789 */         sstb.setStuId(this.rs.getString(1));
/*  670: 790 */         sstb.setSubId(this.rs.getInt(2));
/*  671: 791 */         sstb.setWish(this.rs.getInt(3));
/*  672: 792 */         sstb.setState(this.rs.getInt(4));
/*  673:     */         
/*  674:     */ 
/*  675:     */ 
/*  676:     */ 
/*  677:     */ 
/*  678:     */ 
/*  679:     */ 
/*  680:     */ 
/*  681:     */ 
/*  682:     */ 
/*  683:     */ 
/*  684:     */ 
/*  685: 805 */         sstb.setTeaName("");
/*  686: 806 */         sstb.setSubTitle("");
/*  687: 807 */         sstb.setStuName("");
/*  688:     */         
/*  689:     */ 
/*  690:     */ 
/*  691:     */ 
/*  692: 812 */         AllSSTB.add(sstb);
/*  693:     */       }
/*  694: 815 */       return AllSSTB;
/*  695:     */     }
/*  696:     */     catch (Exception e)
/*  697:     */     {
/*  698: 818 */       e.printStackTrace();
/*  699: 819 */       return null;
/*  700:     */     }
/*  701:     */     finally
/*  702:     */     {
/*  703: 821 */       closeSourse();
/*  704:     */     }
/*  705:     */   }
/*  706:     */   
/*  707:     */   public int get1()
/*  708:     */   {
/*  709: 826 */     int count = 0;
/*  710: 827 */     StuSubTeaBean sstb = null;
/*  711:     */     try
/*  712:     */     {
/*  713: 829 */       this.ct = new ConnDb().getConn();
/*  714: 830 */       String sql = "select count(*) from t_stu_sub where finally='1'";
/*  715: 831 */       this.ps = this.ct.prepareStatement(sql);
/*  716: 832 */       this.rs = this.ps.executeQuery();
/*  717: 833 */       while (this.rs.next()) {
/*  718: 834 */         count = this.rs.getInt(1);
/*  719:     */       }
/*  720:     */     }
/*  721:     */     catch (Exception e)
/*  722:     */     {
/*  723: 839 */       e.printStackTrace();
/*  724:     */     }
/*  725:     */     finally
/*  726:     */     {
/*  727: 842 */       closeSourse();
/*  728:     */     }
/*  729: 846 */     return count;
/*  730:     */   }
/*  731:     */   
/*  732:     */   public ArrayList<StuSubTeaBean> getSSTBbySubId(String subId)
/*  733:     */   {
/*  734: 850 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  735:     */     try
/*  736:     */     {
/*  737: 853 */       this.ct = new ConnDb().getConn();
/*  738: 854 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub where sub_id=?");
/*  739: 855 */       this.ps.setString(1, subId);
/*  740: 856 */       this.rs = this.ps.executeQuery();
/*  741: 857 */       while (this.rs.next())
/*  742:     */       {
/*  743: 858 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  744: 859 */         sstb.setStuId(this.rs.getString(1));
/*  745: 860 */         sstb.setSubId(this.rs.getInt(2));
/*  746: 861 */         sstb.setWish(this.rs.getInt(3));
/*  747: 862 */         sstb.setState(this.rs.getInt(4));
/*  748: 863 */         sstb.setTeaName(new SubjectBeanCl()
/*  749: 864 */           .getSubjectById(this.rs.getInt(2)).getTeacher());
/*  750: 865 */         sstb.setSubTitle(new SubjectBeanCl().getSubjectById(
/*  751: 866 */           this.rs.getInt(2)).getTitle());
/*  752: 867 */         sstb.setStuName(new StudentBeanCl().getStuById(String.valueOf(
/*  753: 868 */           this.rs.getInt(1))).getName());
/*  754: 869 */         AllSSTB.add(sstb);
/*  755:     */       }
/*  756: 871 */       return AllSSTB;
/*  757:     */     }
/*  758:     */     catch (Exception e)
/*  759:     */     {
/*  760: 874 */       e.printStackTrace();
/*  761: 875 */       return null;
/*  762:     */     }
/*  763:     */     finally
/*  764:     */     {
/*  765: 877 */       closeSourse();
/*  766:     */     }
/*  767:     */   }
/*  768:     */   
/*  769:     */   public ArrayList<StuSubTeaBean> getSSTBbySubIdandStuId(String subId, String stuId)
/*  770:     */   {
/*  771: 883 */     ArrayList<StuSubTeaBean> AllSSTB = new ArrayList();
/*  772:     */     try
/*  773:     */     {
/*  774: 886 */       this.ct = new ConnDb().getConn();
/*  775: 887 */       this.ps = this.ct.prepareStatement("select * from t_stu_sub where sub_id=?");
/*  776: 888 */       this.ps.setString(1, subId);
/*  777: 889 */       this.rs = this.ps.executeQuery();
/*  778: 890 */       while (this.rs.next())
/*  779:     */       {
/*  780: 891 */         StuSubTeaBean sstb = new StuSubTeaBean();
/*  781: 892 */         sstb.setStuId(this.rs.getString(1));
/*  782: 893 */         sstb.setSubId(this.rs.getInt(2));
/*  783: 894 */         sstb.setWish(this.rs.getInt(3));
/*  784: 895 */         sstb.setState(this.rs.getInt(4));
/*  785: 896 */         sstb.setTeaName(new SubjectBeanCl()
/*  786: 897 */           .getSubjectById(this.rs.getInt(2)).getTeacher());
/*  787: 898 */         sstb.setSubTitle(new SubjectBeanCl().getSubjectById(
/*  788: 899 */           this.rs.getInt(2)).getTitle());
/*  789: 900 */         sstb.setStuName(new StudentBeanCl().getStuById(
/*  790: 901 */           String.valueOf(this.rs.getInt(1))).getName());
/*  791: 902 */         AllSSTB.add(sstb);
/*  792:     */       }
/*  793: 904 */       return AllSSTB;
/*  794:     */     }
/*  795:     */     catch (Exception e)
/*  796:     */     {
/*  797: 907 */       e.printStackTrace();
/*  798: 908 */       return null;
/*  799:     */     }
/*  800:     */     finally
/*  801:     */     {
/*  802: 910 */       closeSourse();
/*  803:     */     }
/*  804:     */   }
/*  805:     */   
/*  806:     */   public ArrayList<StudentBean> getFailedStu(String yuanxi)
/*  807:     */   {
/*  808: 920 */     ArrayList<StudentBean> alStuBean = new ArrayList();
/*  809:     */     
/*  810: 922 */     String sql = "select * from t_student as a where id not in (select b.stu_id FROM t_stu_sub as b where finally='1') and yuanxi='" + 
/*  811: 923 */       yuanxi + "'";
/*  812:     */     try
/*  813:     */     {
/*  814: 925 */       this.ct = new ConnDb().getConn();
/*  815: 926 */       this.ps = this.ct.prepareStatement(sql);
/*  816: 927 */       this.rs = this.ps.executeQuery();
/*  817: 928 */       while (this.rs.next())
/*  818:     */       {
/*  819: 929 */         StudentBean sb = new StudentBean(this.rs.getString(1), this.rs.getString(2), 
/*  820: 930 */           this.rs.getString(3), SEX.toEnum(this.rs.getString(4)), 
/*  821: 931 */           this.rs.getString(5), this.rs.getString(6), this.rs.getString(7), 
/*  822: 932 */           this.rs.getString(8), this.rs.getInt(9), this.rs.getInt(10), 
/*  823: 933 */           this.rs.getString(11));
/*  824: 934 */         alStuBean.add(sb);
/*  825:     */       }
/*  826:     */     }
/*  827:     */     catch (Exception e)
/*  828:     */     {
/*  829: 937 */       e.printStackTrace();
/*  830:     */     }
/*  831:     */     finally
/*  832:     */     {
/*  833: 939 */       closeSourse();
/*  834:     */     }
/*  835: 941 */     return alStuBean;
/*  836:     */   }
/*  837:     */   
/*  838:     */   public ArrayList<SubjectBean> getFailedSub(String yuanxi)
/*  839:     */   {
/*  840: 950 */     ArrayList<SubjectBean> alStuBean = new ArrayList();
/*  841:     */     
/*  842: 952 */     String sql = "select a.id from t_subject as a where id not in (select b.sub_id FROM t_stu_sub as b where finally='1') and yuanxi='" + 
/*  843: 953 */       yuanxi + "'";
/*  844:     */     try
/*  845:     */     {
/*  846: 955 */       this.ct = new ConnDb().getConn();
/*  847: 956 */       this.ps = this.ct.prepareStatement(sql);
/*  848: 957 */       this.rs = this.ps.executeQuery();
/*  849: 958 */       while (this.rs.next())
/*  850:     */       {
/*  851: 959 */         SubjectBean sb = new SubjectBeanCl().getSubjectById(String.valueOf(this.rs.getInt(1)));
/*  852: 960 */         alStuBean.add(sb);
/*  853:     */       }
/*  854:     */     }
/*  855:     */     catch (Exception e)
/*  856:     */     {
/*  857: 963 */       e.printStackTrace();
/*  858:     */     }
/*  859:     */     finally
/*  860:     */     {
/*  861: 965 */       closeSourse();
/*  862:     */     }
/*  863: 967 */     return alStuBean;
/*  864:     */   }
/*  865:     */   
/*  866:     */   public void closeSourse()
/*  867:     */   {
/*  868:     */     try
/*  869:     */     {
/*  870: 973 */       if (this.rs != null)
/*  871:     */       {
/*  872: 974 */         this.rs.close();
/*  873: 975 */         this.rs = null;
/*  874:     */       }
/*  875: 977 */       if (this.ps != null)
/*  876:     */       {
/*  877: 978 */         this.ps.close();
/*  878: 979 */         this.ps = null;
/*  879:     */       }
/*  880: 981 */       if (this.ct != null)
/*  881:     */       {
/*  882: 982 */         this.ct.close();
/*  883: 983 */         this.ct = null;
/*  884:     */       }
/*  885:     */     }
/*  886:     */     catch (SQLException e)
/*  887:     */     {
/*  888: 987 */       e.printStackTrace();
/*  889:     */     }
/*  890:     */   }
/*  891:     */   
/*  892:     */   public int assignWish4BySubStuId(int subId, String stuId)
/*  893:     */   {
/*  894: 999 */     int i = 0;
/*  895:1000 */     String sql = "update t_stu_sub set state='1' where stu_Id=? and sub_Id=? and wish='4'";
/*  896:     */     try
/*  897:     */     {
/*  898:1002 */       this.ct = new ConnDb().getConn();
/*  899:1003 */       this.ps = this.ct.prepareStatement(sql);
/*  900:1004 */       this.ps.setString(1, stuId);
/*  901:1005 */       this.ps.setInt(2, subId);
/*  902:1006 */       i = this.ps.executeUpdate();
/*  903:     */     }
/*  904:     */     catch (Exception e)
/*  905:     */     {
/*  906:1009 */       e.printStackTrace();
/*  907:1010 */       i = -1;
/*  908:     */     }
/*  909:     */     finally
/*  910:     */     {
/*  911:1012 */       closeSourse();
/*  912:     */     }
/*  913:1014 */     return i;
/*  914:     */   }
/*  915:     */   
/*  916:     */   public int assignByStuIdSubId(String stuId, int subId)
/*  917:     */   {
/*  918:1025 */     int i = 0;
/*  919:1026 */     String sql = "insert into t_stu_sub (stu_Id,sub_Id,wish,state) values (?,?,?,?)";
/*  920:     */     try
/*  921:     */     {
/*  922:1028 */       this.ct = new ConnDb().getConn();
/*  923:1029 */       this.ps = this.ct.prepareStatement(sql);
/*  924:1030 */       this.ps.setString(1, stuId);
/*  925:1031 */       this.ps.setInt(2, subId);
/*  926:1032 */       this.ps.setInt(3, 5);
/*  927:1033 */       this.ps.setInt(4, 1);
/*  928:1034 */       i = this.ps.executeUpdate();
/*  929:     */     }
/*  930:     */     catch (Exception e)
/*  931:     */     {
/*  932:1037 */       e.printStackTrace();
/*  933:1038 */       assignWish4BySubStuId(subId, stuId);
/*  934:1039 */       i = -1;
/*  935:     */     }
/*  936:     */     finally
/*  937:     */     {
/*  938:1041 */       closeSourse();
/*  939:     */     }
/*  940:1043 */     return i;
/*  941:     */   }
/*  942:     */   
/*  943:     */   public void autoAssign(String yuanxi)
/*  944:     */   {
/*  945:1052 */     assignWish123();
/*  946:     */     
/*  947:1054 */     String[] subStuId = getFirstSubStuId();
/*  948:1055 */     if ((subStuId != null) && (++recursion < 1000))
/*  949:     */     {
/*  950:1056 */       System.out.println("subId=" + subStuId[0] + "\tstuId=" + 
/*  951:1057 */         subStuId[1]);
/*  952:1058 */       int a = assignWish4BySubStuId(Integer.parseInt(subStuId[0]), subStuId[1]);
/*  953:1059 */       System.out.println("a=" + a);
/*  954:1060 */       autoAssign(yuanxi);
/*  955:     */     }
/*  956:     */     else
/*  957:     */     {
/*  958:1062 */       recursion = 0;
/*  959:1063 */       randomAssign(yuanxi);
/*  960:1064 */       System.out.println("randomAssign");
/*  961:     */     }
/*  962:     */   }
/*  963:     */   
/*  964:     */   public void auto()
/*  965:     */   {
					
/*  966:1072 */     for (int i = 2; i <= 9; i++)
/*  967:     */     {
/*  968:1073 */       System.out.println("第"+(i-1)+"次循环" );
					  for(int j1=1;j1<=3;j1++){
						  if((i-j1)<=0) break;
/*  969:     */       try
/*  970:     */       {
						
/*  971:1075 */         int count = 0;
/*  972:1076 */         String sql2 = "select * from t_stu_sub  as a where a.wish = '" + 
/*  973:1077 */           (i-j1) + 
/*  974:1078 */           "' and a.state='"+j1+"' and a.stu_id not in (select stu_id from t_stu_sub  where finally=1 )and a.sub_id not in (select sub_id from t_stu_sub  where finally=1) order by state, total";
/*  975:1079 */         this.ct = new ConnDb().getConn();
/*  976:1080 */         this.ps = this.ct.prepareStatement(sql2);
/*  977:1081 */         this.rs = this.ps.executeQuery();
/*  978:1082 */         while (this.rs.next())
/*  979:     */         {
/*  980:1083 */           count++;
/*  981:1084 */           System.out.println("目前未匹配的总数"+count);
/*  982:1085 */           System.out.println(this.rs.getString(1) + "xxx" + this.rs.getInt(2));
/*  983:1086 */           int subid = this.rs.getInt(2);
                          
/*  984:1087 */           String stuid = this.rs.getString(1);
/*  985:1088 */           String sql4 = "select *  from t_stu_sub  as a where a.wish = '" + 
/*  986:1089 */             (i-j1) + 
/*  987:1090 */             "' and sub_id='" + 
/*  988:1091 */             subid + 
/*  989:1092 */             "' and a.state='"+j1+"' and a.stu_id not in (select stu_id from t_stu_sub  where finally=1 )and a.sub_id not in (select sub_id from t_stu_sub  where finally=1) order by state, total";
/*  991:1094 */ 		  this.ct1 = new ConnDb().getConn();
						  this.ps1 = this.ct1.prepareStatement(sql4);
/*  992:1095 */           this.rs1 = this.ps1.executeQuery();
/*  993:1096 */           int m = 0;
/*  994:1097 */           while (this.rs1.next()) {
/*  995:1098 */             m++;
/*  996:     */           }
/*  997:1100 */           System.out.println(m + "XXXXXX");
/*  998:1101 */           int n = 0;
/*  999:1102 */           if (m == 1)
/* 1000:     */           {
/* 1001:1103 */             n = -1;
/* 1002:     */           }
/* 1003:     */           else
/* 1004:     */           {
/* 1005:1104 */             if (m == 0) {
/* 1006:     */               continue;
/* 1007:     */             }
/* 1008:1107 */             n = 0;
/* 1009:     */           }
/* 1010:1112 */           int[] subStuId = new int[m];
/* 1011:1113 */           String[] StuId = new String[m];
/* 1012:1114 */           int[] total = new int[m];
/* 1013:1115 */           if (n == -1)
/* 1014:     */           {
/* 1015:1116 */             String sql5 = "update t_stu_sub set finally='1' where sub_id='" + 
/* 1016:1117 */               subid + "' and stu_id='" + stuid + "'";

							//System.out.println(stuid+ "xxx"+subid +" finally=1 , i = "+i  );
/* 1017:1118 */             this.ct2 = new ConnDb().getConn();
/* 1018:1119 */             this.ps2 = this.ct2.prepareStatement(sql5);
/* 1019:1120 */             this.ps2.executeUpdate();
							ct2.close();
/* 1020:     */           }
/* 1021:     */           else
/* 1022:     */           {
/* 1023:1122 */             String sql3 = "select * from t_stu_sub  as a where a.wish = '" + 
/* 1024:1123 */               i + 
/* 1025:1124 */               "' and sub_id='" + 
/* 1026:1125 */               subid + 
/* 1027:1126 */               "'and a.state<>'0' and a.stu_id not in (select stu_id from t_stu_sub  where finally=1 )and a.sub_id not in (select sub_id from t_stu_sub  where finally=1) order by state, total";
/* 1028:1127 */             
						    this.ct3 = new ConnDb().getConn();
/* 1029:1128 */             this.ps3 = this.ct3.prepareStatement(sql3);
/* 1030:1129 */             this.rs3 = this.ps3.executeQuery();
/* 1031:1130 */             int count1 = 0;
/* 1032:1131 */             while (this.rs3.next())
/* 1033:     */             {
/* 1034:1132 */               count1++;
/* 1035:1133 */               total[n] = this.rs3.getInt(5);
/* 1036:1134 */               subStuId[n] = this.rs3.getInt(2);
/* 1037:1135 */               StuId[n] = this.rs3.getString(1);
/* 1038:1136 */               System.out.println(count1 + "XX" + total[n] + "XX" + 
/* 1039:1137 */                 subStuId[n] + "XX" + StuId[n]);
/* 1040:1138 */               n++;
/* 1041:     */             }
							
/* 1042:1140 */             int min = total[0];
/* 1043:1141 */             int minid = 0;
/* 1044:1142 */             for (int j = 0; j < total.length; j++) {
/* 1045:1143 */               if (total[j] < min)
/* 1046:     */               {
/* 1047:1144 */                 min = total[j];
/* 1048:1145 */                 minid = j;
/* 1049:     */               }
/* 1050:     */             }
/* 1051:1148 */             subid = subStuId[minid];
/* 1052:1149 */             stuid = StuId[minid];
/* 1053:1150 */             System.out.println("更新为" + subid + "XX" + stuid);

/* 1054:1151 */             String sql6 = "update t_stu_sub set finally='1' where sub_id='" + 
/* 1055:1152 */               subid + "' and stu_id='" + stuid + "' order by state, total" ;
						    //System.out.println(stuid+ "xxx"+subid +" finally=1 , i = "+i  );
/* 1017:1118 */             this.ct4 = new ConnDb().getConn();

/* 1057:1154 */             this.ps4 = this.ct4.prepareStatement(sql6);
/* 1058:1155 */             this.ps4.executeUpdate();
							rs3.close();
							ps3.close();
							ct3.close();
							ps4.close();
							ct4.close();
/* 1059:     */           }

/* 1060:     */         }
						
/* 1061:     */       }
/* 1062:     */       catch (Exception e)
/* 1063:     */       {
/* 1064:1159 */         e.printStackTrace();
/* 1065:     */       }
/* 1066:     */       finally
/* 1067:     */       {
/* 1068:1161 */         closeSourse();
/* 1069:     */       }
/* 1070:     */     }
					}
/* 1071:     */   }
/* 1072:     */   
/* 1073:     */   public void assignWish123()
/* 1074:     */   {
/* 1075:1168 */     String sql = "select from t_stu_sub where wish in(1,2,3)";
/* 1076:     */   }
/* 1077:     */   
/* 1078:     */   public void randomAssign(String yuanxi)
/* 1079:     */   {
/* 1080:1175 */     ArrayList<StudentBean> failStu = getFailedStu(yuanxi);
/* 1081:1176 */     ArrayList<SubjectBean> failSub = getFailedSub(yuanxi);
/* 1082:1177 */     if ((failStu.size() > 0) && (failSub.size() > 0) && (++recursion < 1000))
/* 1083:     */     {
/* 1084:1178 */       assignByStuIdSubId(((StudentBean)failStu.get(0)).getId(), 
/* 1085:1179 */         ((SubjectBean)failSub.get(0)).getId());
/* 1086:1180 */       randomAssign(yuanxi);
/* 1087:     */     }
/* 1088:     */     else
/* 1089:     */     {
/* 1090:1182 */       recursion = 0;
/* 1091:     */     }
/* 1092:     */   }
/* 1093:     */   
/* 1094:     */   public String[] getFirstSubStuId()
/* 1095:     */   {
/* 1096:1193 */     String[] subStuId = null;
/* 1097:1194 */     String sql = "select t1.sub_id,t1.stu_id,count(t1.sub_id) as c from t_stu_sub as t1 where wish='4' and t1.sub_id not in (select sub_id from t_stu_sub as t2 where t2.state='1') and t1.stu_id not in (select stu_id from t_stu_sub as t3 where state='1')  group by sub_id order by c";
/* 1098:     */     try
/* 1099:     */     {
/* 1100:1198 */       this.ct = new ConnDb().getConn();
/* 1101:1199 */       this.ps = this.ct.prepareStatement(sql);
/* 1102:1200 */       this.rs = this.ps.executeQuery();
/* 1103:1201 */       if (this.rs.next())
/* 1104:     */       {
/* 1105:1202 */         subStuId = new String[2];
/* 1106:1203 */         subStuId[0] = this.rs.getString(1);
/* 1107:1204 */         subStuId[1] = String.valueOf(this.rs.getInt(2));
/* 1108:1205 */         return subStuId;
/* 1109:     */       }
/* 1110:     */     }
/* 1111:     */     catch (Exception e)
/* 1112:     */     {
/* 1113:1208 */       e.printStackTrace();
/* 1114:     */     }
/* 1115:     */     finally
/* 1116:     */     {
/* 1117:1210 */       closeSourse();
/* 1118:     */     }
/* 1119:1210 */     closeSourse();
/* 1120:     */     
/* 1121:1212 */     return null;
/* 1122:     */   }
/* 1123:     */   
/* 1124:     */   public ArrayList<StudentBean> getFailedStu(String major, String cls, String yuanxi)
/* 1125:     */   {
/* 1126:1217 */     ArrayList<StudentBean> alStuBean = new ArrayList();
/* 1127:     */     
/* 1128:1219 */     String sql = "select * from t_student as a where id not in (select b.stu_id FROM t_stu_sub as b where finally='1') and yuanxi='" + 
/* 1129:1220 */       yuanxi + 
/* 1130:1221 */       "' and major = '" + 
/* 1131:1222 */       major + 
/* 1132:1223 */       "' and class = '" + 
/* 1133:1224 */       cls + 
/* 1134:1225 */       "' order by yuanxi,class";
/* 1135:1226 */     if (("0".equals(major)) && ("0".equals(cls))) {
/* 1136:1228 */       sql = 
/* 1137:1229 */         "select * from t_student as a where id not in (select b.stu_id FROM t_stu_sub as b where finally='1') and yuanxi='" + yuanxi + "' order by yuanxi,class";
/* 1138:1230 */     } else if ("0".equals(major)) {
/* 1139:1232 */       sql = 
/* 1140:1233 */         "select * from t_student as a where id not in (select b.stu_id FROM t_stu_sub as b where finally='1')  and class = '" + cls + "' and yuanxi='" + yuanxi + "' order by yuanxi,class";
/* 1141:1234 */     } else if ("0".equals(cls)) {
/* 1142:1235 */       sql = 
/* 1143:1236 */         "select * from t_student as a where id not in (select b.stu_id FROM t_stu_sub as b where finally='1')  and major = '" + major + "' and yuanxi='" + yuanxi + "' order by yuanxi,class";
/* 1144:     */     }
/* 1145:     */     try
/* 1146:     */     {
/* 1147:1240 */       this.ct = new ConnDb().getConn();
/* 1148:1241 */       this.ps = this.ct.prepareStatement(sql);
/* 1149:1242 */       this.rs = this.ps.executeQuery();
/* 1150:1243 */       while (this.rs.next())
/* 1151:     */       {
/* 1152:1244 */         StudentBean sb = new StudentBean(this.rs.getString(1), this.rs.getString(2), 
/* 1153:1245 */           this.rs.getString(3), SEX.toEnum(this.rs.getString(4)), 
/* 1154:1246 */           this.rs.getString(5), this.rs.getString(6), this.rs.getString(7), 
/* 1155:1247 */           this.rs.getString(8), this.rs.getInt(9), this.rs.getInt(10), 
/* 1156:1248 */           this.rs.getString(11));
/* 1157:1249 */         alStuBean.add(sb);
/* 1158:     */       }
/* 1159:     */     }
/* 1160:     */     catch (Exception e)
/* 1161:     */     {
/* 1162:1252 */       e.printStackTrace();
/* 1163:     */     }
/* 1164:     */     finally
/* 1165:     */     {
/* 1166:1254 */       closeSourse();
/* 1167:     */     }
/* 1168:1256 */     return alStuBean;
/* 1169:     */   }
/* 1170:     */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StuSubTeaBeanCl
 * JD-Core Version:    0.7.0.1
 */