/*  1:   */ package com.kk.admin.controller;
/*  2:   */ 
/*  3:   */ import com.kk.subject.model.NoticeBean;
/*  4:   */ import com.kk.subject.model.NoticeBeanCl;
/*  5:   */ import com.kk.subject.model.Tools;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.sql.Date;
/*  8:   */ import javax.servlet.ServletException;
/*  9:   */ import javax.servlet.http.HttpServlet;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ 
/* 13:   */ public class NoticeManageServlet
/* 14:   */   extends HttpServlet
/* 15:   */ {
/* 16:   */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/* 17:   */     throws ServletException, IOException
/* 18:   */   {
/* 19:29 */     doPost(request, response);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 23:   */     throws ServletException, IOException
/* 24:   */   {
/* 25:45 */     request.setCharacterEncoding("UTF-8");
/* 26:46 */     String flag = request.getParameter("flag");
/* 27:47 */     if (flag.equals("add_notice"))
/* 28:   */     {
/* 29:48 */       String title = request.getParameter("title");
/* 30:49 */       String publisher = request.getParameter("publisher");
/* 31:50 */       String strTime = request.getParameter("time");
/* 32:51 */       String detail = request.getParameter("detail");
/* 33:52 */       Date time = Tools.strToDate(strTime);
/* 34:53 */       String yuanxi = request.getParameter("selDepartment");
/* 35:54 */       NoticeBean nb = new NoticeBean(title, publisher, time, detail, yuanxi);
/* 36:55 */       int noticeId = new NoticeBeanCl().insertNoticeBean(nb);
/* 37:56 */       response.sendRedirect("admin/admin.jsp?function=../common/notice_detail&noticeId=" + noticeId);
/* 38:   */     }
/* 39:57 */     else if (flag.equals("batch_del_notice"))
/* 40:   */     {
/* 41:58 */       String[] checkv = request.getParameterValues("pick");
/* 42:59 */       if (checkv != null) {
/* 43:60 */         for (int i = 0; i < checkv.length; i++) {
/* 44:61 */           new NoticeBeanCl().delMoticeById(checkv[i]);
/* 45:   */         }
/* 46:   */       }
/* 47:64 */       response.sendRedirect("admin/admin.jsp?function=notice_all");
/* 48:   */     }
/* 49:   */   }
/* 50:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.NoticeManageServlet
 * JD-Core Version:    0.7.0.1
 */