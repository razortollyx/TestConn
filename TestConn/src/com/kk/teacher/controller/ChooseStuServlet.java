/*  1:   */ package com.kk.teacher.controller;
/*  2:   */ 
/*  3:   */ import com.kk.subject.model.StuSubTeaBeanCl;
/*  4:   */ import java.io.IOException;
/*  5:   */ import javax.servlet.ServletException;
/*  6:   */ import javax.servlet.http.HttpServlet;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ 
/* 10:   */ public class ChooseStuServlet
/* 11:   */   extends HttpServlet
/* 12:   */ {
/* 13:   */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/* 14:   */     throws ServletException, IOException
/* 15:   */   {
/* 16:26 */     doPost(request, response);
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 20:   */     throws ServletException, IOException
/* 21:   */   {
/* 22:41 */     request.setCharacterEncoding("UTF-8");
/* 23:   */     
/* 24:   */ 
/* 25:44 */     String flag = request.getParameter("flag");
/* 26:   */     
/* 27:46 */     StuSubTeaBeanCl sstbc = new StuSubTeaBeanCl();
/* 28:48 */     if (flag.equals("chooseStu"))
/* 29:   */     {
/* 30:49 */       String subId = request.getParameter("subId");
/* 31:50 */       String stuId = request.getParameter("stuId");
/* 32:   */       
/* 33:   */ 
/* 34:53 */       response.sendRedirect("teacher/teacher.jsp?function=choose_stu");
/* 35:   */     }
/* 36:55 */     else if (flag.equals("repeal"))
/* 37:   */     {
/* 38:56 */       String subId = request.getParameter("subId");
/* 39:57 */       String stuId = request.getParameter("stuId");
/* 40:   */       
/* 41:59 */       sstbc.repeal(stuId, subId);
/* 42:   */       
/* 43:61 */       response.sendRedirect("teacher/teacher.jsp?function=choose_stu");
/* 44:   */     }
/* 45:   */   }
/* 46:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.teacher.controller.ChooseStuServlet
 * JD-Core Version:    0.7.0.1
 */