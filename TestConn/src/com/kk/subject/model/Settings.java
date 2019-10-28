/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class Settings
/*  4:   */ {
/*  5:   */   private int warnNum;
/*  6:   */   private int maxSelNum;
/*  7:   */   private int graduateGrade;
/*  8:   */   private int maxnum;
/*  9:   */   
/* 10:   */   public Settings(int warnNum, int maxSelNum, int graduateGrade)
/* 11:   */   {
/* 12:12 */     setMaxSelNum(maxSelNum);
/* 13:13 */     setWarnNum(warnNum);
/* 14:14 */     setGraduateGrade(graduateGrade);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public Settings(int warnNum, int maxSelNum, int graduateGrade, int maxnum)
/* 18:   */   {
/* 19:18 */     setMaxSelNum(maxSelNum);
/* 20:19 */     setWarnNum(warnNum);
/* 21:20 */     setGraduateGrade(graduateGrade);
/* 22:21 */     setMaxnum(maxnum);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int getMaxnum()
/* 26:   */   {
/* 27:24 */     return this.maxnum;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setMaxnum(int maxnum)
/* 31:   */   {
/* 32:28 */     this.maxnum = maxnum;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Settings() {}
/* 36:   */   
/* 37:   */   public int getWarnNum()
/* 38:   */   {
/* 39:35 */     return this.warnNum;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setWarnNum(int warnNum)
/* 43:   */   {
/* 44:38 */     this.warnNum = warnNum;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public int getMaxSelNum()
/* 48:   */   {
/* 49:41 */     return this.maxSelNum;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setMaxSelNum(int maxSelNum)
/* 53:   */   {
/* 54:44 */     this.maxSelNum = maxSelNum;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public int getGraduateGrade()
/* 58:   */   {
/* 59:47 */     return this.graduateGrade;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setGraduateGrade(int graduateGrade)
/* 63:   */   {
/* 64:50 */     this.graduateGrade = graduateGrade;
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.Settings
 * JD-Core Version:    0.7.0.1
 */