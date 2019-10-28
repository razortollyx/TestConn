/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ import com.common.controller.MyComparator;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.sql.Date;
/*  6:   */ import java.util.ArrayList;
/*  7:   */ import java.util.Collections;
/*  8:   */ 
/*  9:   */ public class Tools
/* 10:   */ {
/* 11:   */   public static Date strToDate(String strDate)
/* 12:   */   {
/* 13:23 */     return Date.valueOf(strDate);
/* 14:   */   }
/* 15:   */   
/* 16:   */   public static ArrayList sortArrayList(ArrayList al, String attiName)
/* 17:   */   {
/* 18:33 */     MyComparator mp = new MyComparator();
/* 19:34 */     mp.setAttiName(attiName);
/* 20:35 */     Collections.sort(al, mp);
/* 21:36 */     return al;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public static String getDescribeOfState(int state)
/* 25:   */   {
/* 26:39 */     switch (state)
/* 27:   */     {
/* 28:   */     case -2: 
/* 29:40 */       return "其他题目命中";
/* 30:   */     case -1: 
/* 31:41 */       return "老师已选其他学生";
/* 32:   */     case 0: 
/* 33:42 */       return "老师没有分配";
/* 34:   */     case 1: 
/* 35:43 */       return "第1志愿";
/* 36:   */     case 2: 
/* 37:44 */       return "第2志愿";
/* 38:   */     case 3: 
/* 39:45 */       return "第3志愿";
/* 40:   */     }
/* 41:46 */     return "参数出错";
/* 42:   */   }
/* 43:   */   
/* 44:   */   public static String getDescribeOfState1(int state)
/* 45:   */   {
/* 46:51 */     switch (state)
/* 47:   */     {
/* 48:   */     case -2: 
/* 49:52 */       return "其他题目命中";
/* 50:   */     case -1: 
/* 51:53 */       return "老师已选其他学生";
/* 52:   */     case 0: 
/* 53:54 */       return "正在选题";
/* 54:   */     case 1: 
/* 55:55 */       return "第1志愿";
/* 56:   */     case 2: 
/* 57:56 */       return "第2志愿";
/* 58:   */     case 3: 
/* 59:57 */       return "第3志愿";
/* 60:   */     }
/* 61:58 */     return "参数出错";
/* 62:   */   }
/* 63:   */   
/* 64:   */   public static String getHandleDescribe(int state)
/* 65:   */   {
/* 66:69 */     switch (state)
/* 67:   */     {
/* 68:   */     case -2: 
/* 69:   */     case -1: 
/* 70:71 */       return "";
/* 71:   */     case 1: 
/* 72:   */     case 2: 
/* 73:   */     case 3: 
/* 74:75 */       return "撤销";
/* 75:   */     case 0: 
/* 76:76 */       return "命中";
/* 77:   */     }
/* 78:77 */     return "参数出错";
/* 79:   */   }
/* 80:   */   
/* 81:   */   public static String getScrollNotice(String yuanxi)
/* 82:   */   {
/* 83:87 */     int id = new StageBeanCl().getCurrentId(yuanxi);
/* 84:88 */     int stage = new StageBeanCl().getCurrentStage(yuanxi);
/* 85:89 */     String describeOfStage = "";
/* 86:90 */     System.out.println("现在阶段——————" + id);
/* 87:91 */     if (stage != -1)
/* 88:   */     {
				  char chi = (char)id;
				  char ch1=' ';
/* 89:92 */       describeOfStage = new StageBeanCl().getdescribeOfStage(id);
/* 90:93 */       describeOfStage = describeOfStage.replace("、", "").replace(chi,ch1).replaceAll("\\d+", "");
/* 91:94 */       describeOfStage = "现在是" + describeOfStage;
/* 92:   */     }
/* 93:   */     else
/* 94:   */     {
/* 95:97 */       describeOfStage = "该时间段只能浏览！";
/* 96:   */     }
/* 97:99 */     return describeOfStage;
/* 98:   */   }
/* 99:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.Tools
 * JD-Core Version:    0.7.0.1
 */