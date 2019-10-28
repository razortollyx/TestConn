/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.SQLException;
/*   5:    */ import java.sql.Statement;
/*   6:    */ 
/*   7:    */ public class TEST
/*   8:    */ {
/*   9: 20 */   private Connection ct = null;
/*  10:    */   
/*  11:    */   public static void main(String[] args)
/*  12:    */   {
/*  13: 92 */     new TeacherBeanCl().updateData("update t_stu_sub set state=0");
/*  14:    */   }
/*  15:    */   
/*  16:    */   public void query() {}
/*  17:    */   
/*  18:    */   public void insert(String sql)
/*  19:    */   {
/*  20:101 */     ConnDb cd = new ConnDb();
/*  21:102 */     Connection ct = cd.getConn();
/*  22:    */     try
/*  23:    */     {
/*  24:104 */       Statement sm = ct.createStatement();
/*  25:105 */       sm.executeUpdate(sql);
/*  26:    */     }
/*  27:    */     catch (SQLException e)
/*  28:    */     {
/*  29:108 */       e.printStackTrace();
/*  30:    */     }
/*  31:    */   }
/*  32:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.TEST
 * JD-Core Version:    0.7.0.1
 */