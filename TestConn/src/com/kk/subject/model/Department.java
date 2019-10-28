/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class Department
/*  4:   */ {
/*  5:   */   private int id;
/*  6:   */   private String department;
/*  7:   */   
/*  8:   */   public Department() {}
/*  9:   */   
/* 10:   */   public Department(int id, String department)
/* 11:   */   {
/* 12:11 */     setDepartment(department);
/* 13:12 */     setId(id);
/* 14:   */   }
/* 15:   */   
/* 16:   */   public int getId()
/* 17:   */   {
/* 18:16 */     return this.id;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setId(int id)
/* 22:   */   {
/* 23:19 */     this.id = id;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getDepartment()
/* 27:   */   {
/* 28:22 */     return this.department;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setDepartment(String department)
/* 32:   */   {
/* 33:25 */     this.department = department;
/* 34:   */   }
/* 35:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.Department
 * JD-Core Version:    0.7.0.1
 */