/*   1:    */ package com.kk.admin.controller;
/*   2:    */ 
/*   3:    */ import com.kk.subject.model.ClsBeanCl;
/*   4:    */ import com.kk.subject.model.MajorBeanCl;
/*   5:    */ import com.kk.subject.model.SEX;
/*   6:    */ import com.kk.subject.model.StuSubTeaBeanCl;
/*   7:    */ import com.kk.subject.model.StudentBean;
/*   8:    */ import com.kk.subject.model.StudentBeanCl;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.io.PrintStream;
/*  11:    */ import javax.servlet.ServletException;
/*  12:    */ import javax.servlet.http.HttpServlet;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import javax.servlet.http.HttpSession;
/*  16:    */ 
/*  17:    */ public class StuManageServlet
/*  18:    */   extends HttpServlet
/*  19:    */ {
/*  20:    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*  21:    */     throws ServletException, IOException
/*  22:    */   {
/*  23: 30 */     request.setCharacterEncoding("UTF-8");
/*  24:    */     
/*  25: 32 */     String flag = request.getParameter("flag");
/*  26:    */     
/*  27: 34 */     HttpSession session = request.getSession(true);
/*  28: 36 */     if (flag.equals("add_major"))
/*  29:    */     {
/*  30: 37 */       String major = request.getParameter("major").trim();
/*  31: 38 */       String yuanxi = session.getAttribute("yuanxi").toString();
/*  32: 39 */       if (!major.equals("")) {
/*  33: 39 */         new MajorBeanCl().insertMajor(major, yuanxi);
/*  34:    */       }
/*  35: 40 */       response.sendRedirect("admin/admin.jsp?function=major_manage");
/*  36:    */     }
/*  37: 41 */     else if (flag.equals("del_major"))
/*  38:    */     {
/*  39: 42 */       String id = request.getParameter("id").trim();
/*  40: 43 */       if (!id.equals("")) {
/*  41: 43 */         new MajorBeanCl().delMajorById(id);
/*  42:    */       }
/*  43: 44 */       response.sendRedirect("admin/admin.jsp?function=major_manage");
/*  44:    */     }
/*  45: 45 */     else if (flag.equals("add_cls"))
/*  46:    */     {
/*  47: 46 */       String cls_id = request.getParameter("cls_id").trim();
/*  48: 47 */       String major = request.getParameter("major").trim();
/*  49: 48 */       String stuNum = request.getParameter("stuNum").trim();
/*  50: 49 */       String yuanxi = session.getAttribute("yuanxi").toString();
/*  51: 50 */       if (!cls_id.equals("")) {
/*  52: 50 */         new ClsBeanCl().insert(cls_id, major, stuNum, yuanxi);
/*  53:    */       }
/*  54: 51 */       response.sendRedirect("admin/admin.jsp?function=class_manage");
/*  55:    */     }
/*  56: 52 */     else if (flag.equals("del_cls"))
/*  57:    */     {
/*  58: 53 */       String cls_id = request.getParameter("cls_id").trim();
/*  59: 54 */       if (!cls_id.equals("")) {
/*  60: 54 */         new ClsBeanCl().delClsById(cls_id);
/*  61:    */       }
/*  62: 55 */       response.sendRedirect("admin/admin.jsp?function=class_manage");
/*  63:    */     }
/*  64: 56 */     else if (flag.equals("batch_add_stu"))
/*  65:    */     {
/*  66: 57 */       String cls = request.getParameter("cls").trim();
/*  67: 58 */       String stuNum = request.getParameter("stuNum").trim();
/*  68: 59 */       String yuanxi = session.getAttribute("yuanxi").toString();
/*  69: 60 */       if (!cls.equals("")) {
/*  70: 60 */         new StudentBeanCl().batchAddStu(cls, stuNum, yuanxi);
/*  71:    */       }
/*  72: 61 */       response.sendRedirect("admin/admin.jsp?function=stu_add");
/*  73:    */     }
/*  74: 62 */     else if (flag.equals("add_stu"))
/*  75:    */     {
/*  76: 63 */       String stuId = request.getParameter("stuId").trim().toString();
/*  77: 64 */       String name = request.getParameter("name");
/*  78: 65 */       String sex = request.getParameter("sex");
/*  79: 66 */       String cls = request.getParameter("class");
/*  80: 67 */       String major = request.getParameter("major");
/*  81: 68 */       String phoneNum = request.getParameter("phoneNum");
/*  82: 69 */       String email = request.getParameter("email");
/*  83: 70 */       int privilege = Integer.parseInt(request.getParameter("privilege"));
/*  84: 71 */       String yuanxi = session.getAttribute("yuanxi").toString();
/*  85: 72 */       StudentBean sb = new StudentBean(stuId, stuId, name, SEX.toEnum(sex), cls, major, phoneNum, email, privilege, 0, yuanxi);
/*  86: 73 */       new StudentBeanCl().insertByStudentBean(sb);
/*  87: 74 */       response.sendRedirect("admin/admin.jsp?function=stu_add");
/*  88:    */     }
/*  89: 75 */     else if (flag.equals("QueryByCriteria"))
/*  90:    */     {
/*  91: 76 */       String selMajor = request.getParameter("selMajor").trim();
/*  92: 77 */       String selCls = request.getParameter("selCls").trim();
/*  93: 78 */       session.setAttribute("selMajor", selMajor);
/*  94: 79 */       session.setAttribute("selCls", selCls);
/*  95: 80 */       response.sendRedirect("admin/admin.jsp?function=stu_all");
/*  96:    */     }
/*  97: 81 */     else if (flag.equals("stu_del"))
/*  98:    */     {
/*  99: 82 */       String stuId = request.getParameter("stuId").trim();
/* 100: 83 */       if (!stuId.equals("")) {
/* 101: 83 */         new StudentBeanCl().delStuById(stuId);
/* 102:    */       }
/* 103: 84 */       response.sendRedirect("admin/admin.jsp?function=stu_all");
/* 104:    */     }
/* 105: 85 */     else if (flag.equals("stu_modify"))
/* 106:    */     {
/* 107: 86 */       String id = request.getParameter("id");
/* 108: 87 */       String psw = request.getParameter("psw");
/* 109: 88 */       String name = request.getParameter("name");
/* 110: 89 */       String phoneNum = request.getParameter("phoneNum");
/* 111: 90 */       String email = request.getParameter("email");
/* 112: 91 */       String privilege = request.getParameter("privilege");
/* 113: 92 */       String sex = request.getParameter("sex");
/* 114:    */       
/* 115: 94 */       String sql = "update t_student set psw='" + psw + "',name='" + name + "',sex='" + sex + "',phoneNum='" + phoneNum + "',email='" + email + "',privilege='" + privilege + "' where id='" + id + "'";
/* 116: 95 */       new StudentBeanCl().updateBySql(sql);
/* 117: 96 */       response.sendRedirect("admin/admin.jsp?function=stu_all");
/* 118:    */     }
/* 119: 97 */     else if (flag.equals("batch_del_stu"))
/* 120:    */     {
/* 121: 98 */       String[] checkv = request.getParameterValues("pick");
/* 122: 99 */       String sql = "";
/* 123:100 */       if (checkv != null) {
/* 124:101 */         for (int i = 0; i < checkv.length; i++) {
/* 125:102 */           new StudentBeanCl().delStuById(checkv[i]);
/* 126:    */         }
/* 127:    */       }
/* 128:105 */       response.sendRedirect("admin/admin.jsp?function=stu_all");
/* 129:    */     }
/* 130:106 */     else if (flag.equals("cls_modify"))
/* 131:    */     {
/* 132:108 */       String cls_id = request.getParameter("cls_id");
/* 133:    */       
/* 134:110 */       int stuNum = Integer.parseInt(request.getParameter("stuNum"));
/* 135:    */       
/* 136:112 */       String major = request.getParameter("major");
/* 137:113 */       String yuanxi = session.getAttribute("yuanxi").toString();
/* 138:114 */       ClsBeanCl cbc = new ClsBeanCl();
/* 139:    */       
/* 140:    */ 
/* 141:    */ 
/* 142:    */ 
/* 143:    */ 
/* 144:120 */       cbc.insertCls(cls_id, major,String.valueOf(stuNum), yuanxi);
/* 145:121 */       response.sendRedirect("admin/admin.jsp?function=class_manage");
/* 146:    */     }
/* 147:122 */     else if (flag.equals("screening"))
/* 148:    */     {
/* 149:124 */       String major = request.getParameter("selMajor").trim();
/* 150:125 */       String cls = request.getParameter("selClass").trim();
/* 151:126 */       String yuanxi = request.getParameter("selDepartment").trim();
/* 152:127 */       System.out.println(yuanxi);
/* 153:128 */       if ((major == null) || ("".equals(major))) {
/* 154:128 */         major = "0";
/* 155:    */       }
/* 156:129 */       if ((cls == null) || ("".equals(cls))) {
/* 157:129 */         cls = "0";
/* 158:    */       }
/* 159:131 */       session.setAttribute("searchResult", new StuSubTeaBeanCl().getFailedStu(major, cls, yuanxi));
/* 160:132 */       session.setAttribute("selMajor", major);
/* 161:133 */       session.setAttribute("selClass", cls);
/* 162:134 */       response.sendRedirect("admin/admin.jsp?function=fail_stu");
/* 163:    */     }
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 167:    */     throws ServletException, IOException
/* 168:    */   {
/* 169:152 */     doGet(request, response);
/* 170:    */   }
/* 171:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.StuManageServlet
 * JD-Core Version:    0.7.0.1
 */