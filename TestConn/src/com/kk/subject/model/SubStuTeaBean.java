/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class SubStuTeaBean
/*  4:   */ {
/*  5:   */   private int sub_id;
/*  6:   */   private int stu_id;
/*  7:   */   private String tea_id;
/*  8:   */   
/*  9:   */   public SubStuTeaBean() {}
/* 10:   */   
/* 11:   */   public SubStuTeaBean(int sub_id, int stu_id, String tea_id)
/* 12:   */   {
/* 13:15 */     setStu_id(stu_id);
/* 14:16 */     setSub_id(sub_id);
/* 15:17 */     setTea_id(tea_id);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public int getSub_id()
/* 19:   */   {
/* 20:20 */     return this.sub_id;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setSub_id(int sub_id)
/* 24:   */   {
/* 25:23 */     this.sub_id = sub_id;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public int getStu_id()
/* 29:   */   {
/* 30:26 */     return this.stu_id;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setStu_id(int stu_id)
/* 34:   */   {
/* 35:29 */     this.stu_id = stu_id;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getTea_id()
/* 39:   */   {
/* 40:32 */     return this.tea_id;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setTea_id(String tea_id)
/* 44:   */   {
/* 45:35 */     this.tea_id = tea_id;
/* 46:   */   }
/* 47:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.SubStuTeaBean
 * JD-Core Version:    0.7.0.1
 */