/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public enum SEX
/*  4:   */ {
/*  5: 5 */   MALE("男"),  FEMALE("女");
/*  6:   */   
/*  7:   */   public String stringValue;
/*  8:   */   
/*  9:   */   private SEX(String stringValue)
/* 10:   */   {
/* 11: 8 */     this.stringValue = stringValue;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public static SEX toEnum(String sex)
/* 15:   */   {
/* 16:13 */     if (sex.equals("男")) {
/* 17:14 */       return MALE;
/* 18:   */     }
/* 19:16 */     return FEMALE;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public static String toStringValue(SEX sex)
/* 23:   */   {
/* 24:21 */     return sex.stringValue;
/* 25:   */   }
/* 26:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.SEX
 * JD-Core Version:    0.7.0.1
 */