/*  1:   */ package com.kk.teacher.controller;
/*  2:   */ 
/*  3:   */ import com.kk.subject.model.TeacherBean;
/*  4:   */ import com.kk.subject.model.TeacherBeanCl;
/*  5:   */ import com.kk.subject.model.TeacherSubBeanCl;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.io.PrintStream;
/*  8:   */ import javax.servlet.RequestDispatcher;
/*  9:   */ import javax.servlet.ServletException;
/* 10:   */ import javax.servlet.http.HttpServlet;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import javax.servlet.http.HttpSession;
/* 14:   */ 
/* 15:   */ public class InfoManageServlet
/* 16:   */   extends HttpServlet
/* 17:   */ {
/* 18:   */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/* 19:   */     throws ServletException, IOException
/* 20:   */   {
/* 21:30 */     doPost(request, response);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 25:   */     throws ServletException, IOException
/* 26:   */   {
/* 27:46 */     request.setCharacterEncoding("UTF-8");
/* 28:   */     
/* 29:   */ 
/* 30:49 */     String flag = request.getParameter("flag");
/* 31:50 */     String sql = "";
/* 32:   */     
/* 33:52 */     HttpSession session = request.getSession(true);
/* 34:54 */     if (flag.equals("teacher_info_modify"))
/* 35:   */     {
/* 36:56 */       String id = request.getParameter("id");
/* 37:57 */       String name = request.getParameter("name").trim();
/* 38:58 */       String sex = request.getParameter("sex");
/* 39:59 */       String phoneNum = request.getParameter("phoneNum");
/* 40:60 */       String email = request.getParameter("email");
/* 41:61 */       String jobTitle = request.getParameter("jobTitle");
/* 42:   */       
/* 43:63 */       sql = "update t_teacher set name='" + name + "',sex='" + sex + "',phoneNum='" + phoneNum + "',email='" + email + "',jobTitle='" + jobTitle + "' where id='" + id + "'";
/* 44:   */       
/* 45:65 */       TeacherBeanCl tbc = new TeacherBeanCl();
/* 46:   */       
/* 47:67 */       String oldName = tbc.getTeacherById(id).getName();
/* 48:68 */       if (!oldName.equals(name)) {
/* 49:70 */         new TeacherSubBeanCl().updateTeacherName(id, name);
/* 50:   */       }
/* 51:73 */       tbc.updateData(sql);
/* 52:74 */       TeacherBean tb = tbc.getTeacherById(id);
/* 53:   */       
/* 54:   */ 
/* 55:77 */       session.setAttribute("user", tb);
/* 56:78 */       response.sendRedirect("teacher/teacher.jsp?function=info_view");
/* 57:   */     }
/* 58:79 */     else if (flag.equals("teacher_psw_modify"))
/* 59:   */     {
/* 60:80 */       String id = ((TeacherBean)session.getAttribute("user")).getId();
/* 61:81 */       String newPsw = request.getParameter("newPsw1");
/* 62:82 */       sql = "update t_teacher set psw='" + newPsw + "' where id='" + id + "'";
/* 63:   */       
/* 64:84 */       System.out.println("sql=" + sql);
/* 65:   */       
/* 66:86 */       TeacherBeanCl tbc = new TeacherBeanCl();
/* 67:87 */       tbc.updateData(sql);
/* 68:   */       
/* 69:   */ 
/* 70:90 */       session.setAttribute("user", tbc.getTeacherById(id));
/* 71:   */       
/* 72:92 */       request.getRequestDispatcher("teacher/teacher.jsp?function=info_view").forward(request, response);
/* 73:   */     }
/* 74:   */   }
/* 75:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.teacher.controller.InfoManageServlet
 * JD-Core Version:    0.7.0.1
 */