/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class StuSubBean
/*  4:   */ {
/*  5:   */   private String stuId;
/*  6:   */   private int subId;
/*  7:   */   private int wish;
/*  8:   */   private int state;
/*  9:   */   
/* 10:   */   public StuSubBean() {}
/* 11:   */   
/* 12:   */   public StuSubBean(String stuId, int subId, int wish, int state)
/* 13:   */   {
/* 14:12 */     setStuId(stuId);
/* 15:13 */     setSubId(subId);
/* 16:14 */     setWish(wish);
/* 17:15 */     setState(state);
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getStuId()
/* 21:   */   {
/* 22:19 */     return this.stuId;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setStuId(String stuId)
/* 26:   */   {
/* 27:22 */     this.stuId = stuId;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public int getSubId()
/* 31:   */   {
/* 32:25 */     return this.subId;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setSubId(int subId)
/* 36:   */   {
/* 37:28 */     this.subId = subId;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public int getWish()
/* 41:   */   {
/* 42:31 */     return this.wish;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setWish(int wish)
/* 46:   */   {
/* 47:34 */     this.wish = wish;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public int getState()
/* 51:   */   {
/* 52:37 */     return this.state;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setState(int state)
/* 56:   */   {
/* 57:40 */     this.state = state;
/* 58:   */   }
/* 59:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StuSubBean
 * JD-Core Version:    0.7.0.1
 */