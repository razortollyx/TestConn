/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class ClsBean
/*  4:   */ {
/*  5:   */   private String id;
/*  6:   */   private String majorName;
/*  7:   */   private int stuNum;
/*  8:   */   
/*  9:   */   public ClsBean() {}
/* 10:   */   
/* 11:   */   public ClsBean(String id, String majorName, int stuNum)
/* 12:   */   {
/* 13:13 */     setId(id);
/* 14:14 */     setMajorName(majorName);
/* 15:15 */     setStuNum(stuNum);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getId()
/* 19:   */   {
/* 20:19 */     return this.id;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setId(String id)
/* 24:   */   {
/* 25:22 */     this.id = id;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getMajorName()
/* 29:   */   {
/* 30:25 */     return this.majorName;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setMajorName(String majorName)
/* 34:   */   {
/* 35:28 */     this.majorName = majorName;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public int getStuNum()
/* 39:   */   {
/* 40:31 */     return this.stuNum;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setStuNum(int stuNum)
/* 44:   */   {
/* 45:34 */     this.stuNum = stuNum;
/* 46:   */   }
/* 47:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.ClsBean
 * JD-Core Version:    0.7.0.1
 */