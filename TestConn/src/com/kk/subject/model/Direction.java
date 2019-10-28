/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class Direction
/*  4:   */ {
/*  5:   */   private int id;
/*  6:   */   private String direction;
/*  7:   */   
/*  8:   */   public Direction() {}
/*  9:   */   
/* 10:   */   public Direction(int id, String direction)
/* 11:   */   {
/* 12:12 */     setDirection(direction);
/* 13:13 */     setId(id);
/* 14:   */   }
/* 15:   */   
/* 16:   */   public int getId()
/* 17:   */   {
/* 18:17 */     return this.id;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setId(int id)
/* 22:   */   {
/* 23:20 */     this.id = id;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getDirection()
/* 27:   */   {
/* 28:23 */     return this.direction;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setDirection(String direction)
/* 32:   */   {
/* 33:26 */     this.direction = direction;
/* 34:   */   }
/* 35:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.Direction
 * JD-Core Version:    0.7.0.1
 */