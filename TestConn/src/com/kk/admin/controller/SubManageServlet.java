/*  1:   */ package com.kk.admin.controller;
/*  2:   */ 
/*  3:   */ import com.kk.subject.model.SubjectBean;
/*  4:   */ import com.kk.subject.model.SubjectBeanCl;
/*  5:   */ import com.kk.subject.model.TeacherBean;
/*  6:   */ import com.kk.subject.model.TeacherBeanCl;
/*  7:   */ import com.kk.subject.model.TeacherSubBeanCl;
/*  8:   */ import java.io.IOException;
/*  9:   */ import javax.servlet.ServletException;
/* 10:   */ import javax.servlet.http.HttpServlet;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import javax.servlet.http.HttpSession;
/* 14:   */ 
/* 15:   */ public class SubManageServlet
/* 16:   */   extends HttpServlet
/* 17:   */ {
/* 18:   */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/* 19:   */     throws ServletException, IOException
/* 20:   */   {
/* 21:33 */     doPost(request, response);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 25:   */     throws ServletException, IOException
/* 26:   */   {
/* 27:50 */     request.setCharacterEncoding("UTF-8");
/* 28:51 */     String flag = request.getParameter("flag");
/* 29:52 */     HttpSession session = request.getSession(true);
/* 30:54 */     if (flag.equals("sub_add"))
/* 31:   */     {
/* 32:55 */       String title = request.getParameter("title");
/* 33:56 */       String teaId = request.getParameter("teacher");
/* 34:57 */       String direction = request.getParameter("direction").trim();
/* 35:58 */       String introduction = request.getParameter("introduction").trim();
/* 36:59 */       String schedule = request.getParameter("schedule").trim();
/* 37:60 */       String reference = request.getParameter("reference").trim();
/* 38:61 */       String requirement = request.getParameter("requirement").trim();
/* 39:62 */       String domain = request.getParameter("domain").trim();
/* 40:   */       
/* 41:64 */       String key = request.getParameter("key").trim();
/* 42:65 */       String yuanxi = (String)session.getAttribute("yuanxi");
/* 43:66 */       String teaName = new TeacherBeanCl().getTeacherById(teaId).getName();
/* 44:   */       
/* 45:68 */       SubjectBean subBean = new SubjectBean(title, teaName, direction, introduction, schedule, reference, requirement, domain, 0, 0, key, yuanxi);
/* 46:69 */       int subId = new SubjectBeanCl().insertSubject(subBean);
/* 47:70 */       new TeacherSubBeanCl().insertSubject(teaId, subId);
/* 48:71 */       new TeacherBeanCl().updateData(" update t_teacher set subNum=subNum+1 where id='" + teaId + "'");
/* 49:   */       
/* 50:73 */       response.sendRedirect("admin/admin.jsp?function=sub_add");
/* 51:   */     }
/* 52:74 */     else if (flag.equals("screeningSub"))
/* 53:   */     {
/* 54:75 */       String viewType = request.getParameter("viewType");
/* 55:76 */       session.setAttribute("viewType", viewType);
/* 56:77 */       response.sendRedirect("admin/admin.jsp?function=sub_verify");
/* 57:   */     }
/* 58:78 */     else if (flag.equals("batch_verify_sub"))
/* 59:   */     {
/* 60:79 */       String[] checkv = request.getParameterValues("pick");
/* 61:80 */       if (checkv != null) {
/* 62:80 */         new SubjectBeanCl().verifyByIds(checkv, 1);
/* 63:   */       }
/* 64:81 */       response.sendRedirect("admin/admin.jsp?function=sub_verify");
/* 65:   */     }
/* 66:82 */     else if (flag.equals("batch_not_pass"))
/* 67:   */     {
/* 68:83 */       String[] checkv = request.getParameterValues("pick");
/* 69:84 */       if (checkv != null) {
/* 70:84 */         new SubjectBeanCl().verifyByIds(checkv, -1);
/* 71:   */       }
/* 72:86 */       response.sendRedirect("admin/admin.jsp?function=sub_verify");
/* 73:   */     }
/* 74:87 */     else if (flag.equals("screeningSub1"))
/* 75:   */     {
/* 76:88 */       String viewType = request.getParameter("viewType");
/* 77:89 */       session.setAttribute("viewType", viewType);
/* 78:90 */       response.sendRedirect("teacher/teacher.jsp?function=sub_verify");
/* 79:   */     }
/* 80:91 */     else if (flag.equals("batch_verify_sub1"))
/* 81:   */     {
/* 82:92 */       String[] checkv = request.getParameterValues("pick");
/* 83:93 */       if (checkv != null) {
/* 84:93 */         new SubjectBeanCl().verifyByIds(checkv, 1);
/* 85:   */       }
/* 86:94 */       response.sendRedirect("teacher/teacher.jsp?function=sub_verify");
/* 87:   */     }
/* 88:95 */     else if (flag.equals("batch_not_pass1"))
/* 89:   */     {
/* 90:96 */       String[] checkv = request.getParameterValues("pick");
/* 91:97 */       if (checkv != null) {
/* 92:97 */         new SubjectBeanCl().verifyByIds(checkv, -1);
/* 93:   */       }
/* 94:98 */       response.sendRedirect("teacher/teacher.jsp?function=sub_verify");
/* 95:   */     }
				else if (flag.equals("screeningxibie"))
/* 89:   */     {
/* 90:96 */       String xibie  = request.getParameter("selDepartment");

/* 72:86 */       response.sendRedirect("admin/admin.jsp?function=sub_verify");
/* 95:   */     }
/* 96:   */   }
/* 97:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.SubManageServlet
 * JD-Core Version:    0.7.0.1
 */