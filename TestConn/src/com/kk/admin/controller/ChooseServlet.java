/*   1:    */ package com.kk.admin.controller;
/*   2:    */ 
/*   3:    */ import com.kk.subject.model.StuSubTeaBeanCl;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import javax.servlet.ServletException;
/*   7:    */ import javax.servlet.http.HttpServlet;
/*   8:    */ import javax.servlet.http.HttpServletRequest;
/*   9:    */ import javax.servlet.http.HttpServletResponse;
/*  10:    */ import javax.servlet.http.HttpSession;
/*  11:    */ 
/*  12:    */ public class ChooseServlet
/*  13:    */   extends HttpServlet
/*  14:    */ {
/*  15:    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*  16:    */     throws ServletException, IOException
/*  17:    */   {
/*  18: 37 */     doPost(request, response);
/*  19:    */   }
/*  20:    */   
/*  21:    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*  22:    */     throws ServletException, IOException
/*  23:    */   {
/*  24: 57 */     request.setCharacterEncoding("UTF-8");
/*  25: 58 */     request.setCharacterEncoding("UTF-8");
/*  26:    */     
/*  27: 60 */     HttpSession session = request.getSession(true);
/*  28:    */     
/*  29:    */ 
/*  30: 63 */     String flag = request.getParameter("flag");
/*  31:    */     
/*  32: 65 */     StuSubTeaBeanCl sstbc = new StuSubTeaBeanCl();
/*  33: 67 */     if (flag.equals("chooseStu"))
/*  34:    */     {
/*  35: 69 */       String subId = request.getParameter("subId");
/*  36: 70 */       String stuId = request.getParameter("stuId");
/*  37: 71 */       String state = request.getParameter("state");
/*  38: 72 */       String wish = request.getParameter("wish");
/*  39: 73 */       System.out.println(wish);
/*  40: 74 */       int s = Integer.parseInt(state);
/*  41: 75 */       int w = Integer.parseInt(wish);
/*  42: 76 */       int t = s + w;
/*  43: 77 */       System.out.println(t);
/*  44:    */       
/*  45: 79 */       response.sendRedirect("admin/admin.jsp?function=choose_result");
/*  46:    */     }
/*  47: 81 */     else if (flag.equals("repeal"))
/*  48:    */     {
/*  49: 82 */       String subId = request.getParameter("subId");
/*  50: 83 */       String stuId = request.getParameter("stuId");
/*  51:    */       
/*  52: 85 */       sstbc.repeal(stuId, subId);
/*  53:    */       
/*  54: 87 */       response.sendRedirect("admin/admin.jsp?function=choose_result");
/*  55:    */     }
/*  56: 88 */     else if (flag.equals("chooseStu1"))
/*  57:    */     {
/*  58: 97 */       String subId = request.getParameter("subId");
/*  59: 98 */       String stuId = request.getParameter("stuId");
/*  60: 99 */       String state = request.getParameter("wish_type");
/*  61:    */       
/*  62:101 */       String wish = request.getParameter("wish");
/*  63:102 */       int s = Integer.parseInt(state);
/*  64:103 */       int w = Integer.parseInt(wish);
/*  65:104 */       int t = s + w;
/*  66:105 */       String total = Integer.toString(t);
/*  67:106 */       System.out.println(wish);
/*  68:107 */       System.out.println(state);
/*  69:108 */       System.out.println(t);
/*  70:109 */       sstbc.ChangeAll(subId, state);
/*  71:110 */       sstbc.SetAll(stuId, subId, state, total);
/*  72:    */       
/*  73:    */ 
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:    */ 
/*  89:    */ 
/*  90:    */ 
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:148 */       response.sendRedirect("teacher/teacher.jsp?function=choose_stu1");
/* 110:    */     }
/* 111:150 */     else if (flag.equals("repeal1"))
/* 112:    */     {
/* 113:151 */       String subId = request.getParameter("subId");
/* 114:152 */       String stuId = request.getParameter("stuId");
/* 115:153 */       sstbc.repeal(stuId, subId);
/* 116:    */       
/* 117:155 */       response.sendRedirect("teacher/teacher.jsp?function=choose_stu1");
/* 118:    */     }
/* 119:156 */     else if (flag.equals("screening"))
/* 120:    */     {
/* 121:157 */       String teacherName = request.getParameter("teacher").trim();
/* 122:158 */       String selDepartment = request.getParameter("selDepartment").trim();
/* 123:159 */       if ((selDepartment == null) || ("".equals(selDepartment))) {
/* 124:160 */         selDepartment = "0";
/* 125:    */       }
/* 126:161 */       if (teacherName == null) {
/* 127:162 */         teacherName = "";
/* 128:    */       }
/* 129:163 */       session.setAttribute("searchResult", new StuSubTeaBeanCl()
/* 130:164 */         .getMyAllResult(teacherName, selDepartment));
/* 131:165 */       session.setAttribute("selDepartment", selDepartment);
/* 132:166 */       session.setAttribute("teacher", teacherName);
/* 133:167 */       response.sendRedirect("admin/admin.jsp?function=choose_result");
/* 134:    */     }
/* 135:    */   }
/* 136:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.ChooseServlet
 * JD-Core Version:    0.7.0.1
 */