/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.sql.Connection;
/*  5:   */ import java.sql.DriverManager;
/*  6:   */ 
/*  7:   */ public class ConnDb
/*  8:   */ {
/*  9: 7 */   private Connection ct = null;
/* 10:   */   
/* 11:   */   public Connection getConn()
/* 12:   */   {
/* 13:   */     try
/* 14:   */     {
/* 15:13 */       Class.forName("com.mysql.jdbc.Driver");
/* 16:   */       
/* 17:   */ 
/* 18:16 */       this.ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1111?useUnicode=true&characterEncoding=UTF-8","root","123456");
                  //jdbc:mysql://localhost:3307/test4?useUnicode=true&characterEncoding=UTF-8","root","root1234"
                  //jdbc:mysql://106.12.44.134:3306/lixiang88","lixiang88","abc123abc123" 
/* 19:17 */       if (this.ct.isClosed()) {
/* 20:18 */         System.out.println("连接不成功！");
/* 21:   */       }
/* 22:   */     }
/* 23:   */     catch (Exception e)
/* 24:   */     {
/* 25:22 */       e.printStackTrace();
/* 26:   */     }
/* 27:24 */     return this.ct;
/* 28:   */   }
/* 29:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.ConnDb
 * JD-Core Version:    0.7.0.1
 */