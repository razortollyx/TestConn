/*   1:    */ package com.kk.teacher.controller;
/*   2:    */ 
/*   3:    */ import com.kk.subject.model.SubjectBean;
/*   4:    */ import com.kk.subject.model.SubjectBeanCl;
/*   5:    */ import com.kk.subject.model.TeacherBean;
/*   6:    */ import com.kk.subject.model.TeacherBeanCl;
/*   7:    */ import com.kk.subject.model.TeacherSubBeanCl;
/*   8:    */ import java.io.IOException;
/*   9:    */ import java.sql.Date;
/*  10:    */ import javax.servlet.ServletException;
/*  11:    */ import javax.servlet.http.HttpServlet;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import javax.servlet.http.HttpSession;
/*  15:    */ 
/*  16:    */ public class TeaSubManageServlet
/*  17:    */   extends HttpServlet
/*  18:    */ {
/*  19:    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*  20:    */     throws ServletException, IOException
/*  21:    */   {
/*  22: 32 */     doPost(request, response);
/*  23:    */   }
/*  24:    */   
/*  25:    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*  26:    */     throws ServletException, IOException
/*  27:    */   {
/*  28: 48 */     request.setCharacterEncoding("UTF-8");
/*  29:    */     
/*  30:    */ 
/*  31: 51 */     String flag = request.getParameter("flag");
/*  32: 52 */     String sql = "";
/*  33:    */     
/*  34: 54 */     HttpSession session = request.getSession(true);
/*  35: 55 */     session.setMaxInactiveInterval(1800);
/*  36: 56 */     String t_id = ((TeacherBean)session.getAttribute("user")).getId();
/*  37: 57 */     if (flag.equals("sub_modify"))
/*  38:    */     {
/*  39: 58 */       String id = request.getParameter("id");
/*  40: 59 */       String title = request.getParameter("title");
/*  41: 60 */       String direction = request.getParameter("direction");
/*  42: 61 */       String introduction = request.getParameter("introduction");
/*  43: 62 */       String schedule = request.getParameter("schedule");
/*  44: 63 */       String reference = request.getParameter("reference");
/*  45: 64 */       String requirement = request.getParameter("requirement");
/*  46: 65 */       String domain = request.getParameter("domain");
/*  47: 66 */       String key = request.getParameter("key");
/*  48: 67 */       Date time = new Date(System.currentTimeMillis());
/*  49: 68 */       sql = "update t_subject set title='" + title + "',direction='" + direction + "',introduction='" + introduction + 
/*  50: 69 */         "',schedule='" + schedule + "',reference='" + reference + "',requirement='" + requirement + 
/*  51: 70 */         "',domain='" + domain + "',time='" + time + "',keyNum='" + key + "' where id='" + id + "'";
/*  52: 71 */       new SubjectBeanCl().modifySubject(sql);
/*  53:    */       
/*  54:    */ 
/*  55: 74 */       response.sendRedirect("teacher/teacher.jsp?function=sub_mine");
/*  56:    */     }
/*  57: 75 */     else if (flag.equals("sub_modify1"))
/*  58:    */     {
/*  59: 76 */       String id = request.getParameter("id");
/*  60: 77 */       String title = request.getParameter("title");
/*  61: 78 */       String direction = request.getParameter("direction");
/*  62: 79 */       String introduction = request.getParameter("introduction");
/*  63: 80 */       String schedule = request.getParameter("schedule");
/*  64: 81 */       String reference = request.getParameter("reference");
/*  65: 82 */       String requirement = request.getParameter("requirement");
/*  66: 83 */       String domain = request.getParameter("domain");
/*  67: 84 */       Date time = new Date(System.currentTimeMillis());
/*  68: 85 */       sql = "update t_subject set title='" + title + "',direction='" + direction + "',introduction='" + introduction + 
/*  69: 86 */         "',schedule='" + schedule + "',reference='" + reference + "',requirement='" + requirement + 
/*  70: 87 */         "',domain='" + domain + "',time='" + time + "',state='1' where id='" + id + "'";
/*  71: 88 */       new SubjectBeanCl().modifySubject(sql);
/*  72:    */       
/*  73: 90 */       response.sendRedirect("teacher/sub_modify1.jsp");
/*  74:    */     }
/*  75: 94 */     else if (flag.equals("sub_add"))
/*  76:    */     {
/*  77: 95 */       String title = request.getParameter("title");
/*  78: 96 */       String teacher = request.getParameter("teacher");
/*  79: 97 */       String direction = request.getParameter("direction");
/*  80: 98 */       String introduction = request.getParameter("introduction");
/*  81: 99 */       String schedule = request.getParameter("schedule");
/*  82:100 */       String reference = request.getParameter("reference");
/*  83:101 */       String requirement = request.getParameter("requirement");
/*  84:    */       
/*  85:103 */       String key = request.getParameter("key");
/*  86:104 */       String yuanxi = session.getAttribute("yuanxi").toString();
/*  87:    */       
/*  88:106 */       String domain = "";
/*  89:    */       
/*  90:    */ 
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:113 */       SubjectBean subBean = new SubjectBean(title, teacher, direction, introduction, schedule, reference, requirement, domain, 0, 0, key, yuanxi);
/*  96:114 */       int s_id = new SubjectBeanCl().insertSubject(subBean);
/*  97:115 */       new TeacherSubBeanCl().insertSubject(t_id, s_id);
/*  98:116 */       new TeacherBeanCl().updateData(" update t_teacher set subNum=subNum+1 where id='" + t_id + "'");
/*  99:    */       
/* 100:    */ 
/* 101:119 */       response.sendRedirect("teacher/teacher.jsp?function=sub_mine");
/* 102:    */     }
/* 103:120 */     else if (flag.equals("sub_del"))
/* 104:    */     {
/* 105:121 */       String id = request.getParameter("id");
/* 106:122 */       new SubjectBeanCl().delSubjectById(id);
/* 107:123 */       new TeacherBeanCl().updateData("update t_teacher set subNum=subNum-1 where id='" + t_id + "'");
/* 108:    */       
/* 109:125 */       response.sendRedirect("teacher/teacher.jsp?function=sub_mine");
/* 110:    */     }
/* 111:    */   }
/* 112:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.teacher.controller.TeaSubManageServlet
 * JD-Core Version:    0.7.0.1
 */