/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class MajorBean
/*  4:   */ {
/*  5:   */   private int id;
/*  6:   */   private String major;
/*  7: 7 */   private final String academy = "计算机学院";
/*  8:   */   
/*  9:   */   public MajorBean(int id, String major)
/* 10:   */   {
/* 11:10 */     setId(id);
/* 12:11 */     setMajor(major);
/* 13:   */   }
/* 14:   */   
/* 15:   */   public int getId()
/* 16:   */   {
/* 17:14 */     return this.id;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setId(int id)
/* 21:   */   {
/* 22:17 */     this.id = id;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getMajor()
/* 26:   */   {
/* 27:20 */     return this.major;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setMajor(String major)
/* 31:   */   {
/* 32:23 */     this.major = major;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getAcademy()
/* 36:   */   {
/* 37:26 */     return "计算机学院";
/* 38:   */   }
/* 39:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.MajorBean
 * JD-Core Version:    0.7.0.1
 */