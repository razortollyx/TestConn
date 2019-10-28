/*   1:    */ package com.kk.admin.controller;
/*   2:    */ 
/*   3:    */ import com.kk.subject.model.AdminBean;
/*   4:    */ import com.kk.subject.model.AdminBeanCl;
/*   5:    */ import com.kk.subject.model.SEX;
/*   6:    */ import com.kk.subject.model.SettingsCl;
/*   7:    */ import com.kk.subject.model.StageBeanCl;
/*   8:    */ import com.kk.subject.model.SubjectBeanCl;
/*   9:    */ import com.kk.subject.model.TeacherBean;
/*  10:    */ import com.kk.subject.model.TeacherBeanCl;
/*  11:    */ import com.kk.subject.model.TeacherSubBeanCl;
/*  12:    */ import java.io.IOException;
/*  13:    */ import java.io.PrintStream;
/*  14:    */ import javax.servlet.ServletException;
/*  15:    */ import javax.servlet.http.HttpServlet;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import javax.servlet.http.HttpSession;
/*  19:    */ 
/*  20:    */ public class TeaManageServlet
/*  21:    */   extends HttpServlet
/*  22:    */ {
/*  23:    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*  24:    */     throws ServletException, IOException
/*  25:    */   {
/*  26: 29 */     doPost(request, response);
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*  30:    */     throws ServletException, IOException
/*  31:    */   {
/*  32: 46 */     request.setCharacterEncoding("UTF-8");
/*  33:    */     
/*  34: 48 */     HttpSession session = request.getSession(true);
/*  35: 49 */     String flag = request.getParameter("flag");
/*  36:    */     
/*  37: 51 */     String sql = "";
/*  38: 52 */     if (flag.equals("tea_add"))
/*  39:    */     {
/*  40: 53 */       String id = request.getParameter("teaId");
/*  41: 54 */       String psw = request.getParameter("psw");
/*  42: 55 */       String name = request.getParameter("name");
/*  43: 56 */       String sex = request.getParameter("sex");
/*  44: 57 */       String phoneNum = request.getParameter("phoneNum");
/*  45: 58 */       String email = request.getParameter("email");
/*  46: 59 */       String jobTitle = request.getParameter("jobTitle");
/*  47: 60 */       String maxSubNum = request.getParameter("maxSubNum").trim();
/*  48:    */       
/*  49: 62 */       String department = session.getAttribute("yuanxi").toString();
/*  50: 63 */       String xibie = request.getParameter("xibie").toString();
/*  51: 64 */       System.out.println(department);
/*  52: 65 */       System.out.println(xibie);
/*  53: 66 */       String type = request.getParameter("type").trim();
/*  54: 67 */       TeacherBean tb = new TeacherBean(id, psw, name, SEX.toEnum(sex), phoneNum, email, jobTitle, 
/*  55: 68 */         0, Integer.parseInt(maxSubNum), department, Integer.parseInt(type), xibie);
/*  56: 69 */       new TeacherBeanCl().insertByTb(tb);
/*  57: 70 */       response.sendRedirect("admin/admin.jsp?function=tea_all");
/*  58:    */     }
/*  59: 71 */     else if (flag.equals("admin_add"))
/*  60:    */     {
/*  61: 72 */       String id = request.getParameter("adminId");
/*  62: 73 */       String psw = request.getParameter("psw");
/*  63: 74 */       String name = request.getParameter("name");
/*  64: 75 */       String sex = request.getParameter("sex");
/*  65: 76 */       String phoneNum = request.getParameter("phoneNum");
/*  66: 77 */       String email = request.getParameter("email");
/*  67: 78 */       String department = request.getParameter("yuanxi").trim();
/*  68: 79 */       AdminBean ad = new AdminBean(id, psw, name, 1, sex, phoneNum, email, department);
/*  69: 80 */       new AdminBeanCl().insertByTb(ad);
/*  70: 81 */       new SettingsCl().insertByyuanxi(department);
/*  71: 82 */       new StageBeanCl().insertByyuanxi(department);
/*  72: 83 */       response.sendRedirect("sadmin/admin.jsp?function=admin_all");
/*  73:    */     }
/*  74: 84 */     else if (flag.equals("tea_del"))
/*  75:    */     {
/*  76: 85 */       String teaId = request.getParameter("teaId").trim();
/*  77: 86 */       new TeacherBeanCl().delTeacherById(teaId);
/*  78: 87 */       response.sendRedirect("admin/admin.jsp?function=tea_all");
/*  79:    */     }
/*  80: 88 */     else if (flag.equals("batch_del_tea"))
/*  81:    */     {
/*  82: 90 */       String[] checkv = request.getParameterValues("pick");
/*  83: 91 */       if (checkv != null) {
/*  84: 92 */         for (int i = 0; i < checkv.length; i++) {
/*  85: 93 */           new TeacherBeanCl().delTeacherById(checkv[i]);
/*  86:    */         }
/*  87:    */       }
/*  88: 96 */       response.sendRedirect("admin/admin.jsp?function=tea_all");
/*  89:    */     }
/*  90: 97 */     else if (flag.equals("tea_modify"))
/*  91:    */     {
/*  92: 98 */       String id = request.getParameter("id");
/*  93: 99 */       String psw = request.getParameter("psw");
/*  94:100 */       String name = request.getParameter("name");
/*  95:101 */       String sex = request.getParameter("sex");
/*  96:102 */       String phoneNum = request.getParameter("phoneNum");
/*  97:103 */       String email = request.getParameter("email");
/*  98:104 */       String jobTitle = request.getParameter("jobTitle");
/*  99:105 */       String subNum = request.getParameter("subNum");
/* 100:106 */       String maxSubNum = request.getParameter("maxSubNum").trim();
/* 101:107 */       String department = session.getAttribute("yuanxi").toString();
/* 102:108 */       String type = request.getParameter("type").trim();
/* 103:    */       String xibie = request.getParameter("department");
					System.out.println("xibie:"+xibie);
					System.out.println("department:"+request.getParameter("yuanxi"));


/* 104:110 */       TeacherBean tb = new TeacherBean(id, psw, name, SEX.toEnum(sex), phoneNum, email, jobTitle, 
/* 105:111 */       Integer.parseInt(subNum), Integer.parseInt(maxSubNum), department, Integer.parseInt(type),xibie);
/* 106:112 */       
					if(new TeacherSubBeanCl().isExistTeaId(id)!=null) {
						System.out.println("new TeacherSubBeanCl().isExistTeaId(id):"+new TeacherSubBeanCl().isExistTeaId(id));
						new TeacherSubBeanCl().updateTeacherName(id, name);
					}
/* 107:113 */       new TeacherBeanCl().modifyByTb1(tb);
/* 108:114 */       response.sendRedirect("admin/admin.jsp?function=tea_all");
/* 109:    */     }
/* 110:115 */     else if (flag.equals("screening"))
/* 111:    */     {
/* 112:117 */       String teacherName = request.getParameter("teacher").trim();
/* 113:118 */       String selDepartment = session.getAttribute("yuanxi").toString();
/* 114:119 */       String xibie = request.getParameter("selDepartment");
/* 115:120 */       if ((xibie == null) || ("".equals(xibie))) {
/* 116:120 */         xibie = "0";
/* 117:    */       }
/* 118:121 */       if (teacherName == null) {
/* 119:121 */         teacherName = "";
/* 120:    */       }
/* 121:122 */       session.setAttribute("searchResult", new TeacherBeanCl().getTeacherByNameAndDept(teacherName, selDepartment, xibie));
/* 122:123 */       session.setAttribute("selDepartment", selDepartment);
/* 123:124 */       session.setAttribute("teacher", teacherName);
/* 124:125 */       response.sendRedirect("admin/admin.jsp?function=tea_all");
/* 125:    */     }
/* 126:126 */     else if (flag.equals("screening1"))
/* 127:    */     {
/* 128:128 */       String teacherName = request.getParameter("teacher").trim();
/* 129:129 */       String selDepartment = request.getParameter("yuanxi").trim();
/* 130:130 */       String xibie = request.getParameter("direction").trim();
/* 131:131 */       String key = request.getParameter("key").trim();
/* 132:132 */       String year = request.getParameter("year").trim();
/* 133:133 */       if ((xibie == null) || ("".equals(xibie))) {
/* 134:133 */         xibie = "0";
/* 135:    */       }
/* 136:135 */       if (teacherName == null) {
/* 137:135 */         teacherName = "";
/* 138:    */       }
/* 139:136 */       if (key == null) {
/* 140:136 */         key = "";
/* 141:    */       }
/* 142:137 */       if (year == null) {
/* 143:137 */         year = "";
/* 144:    */       }
/* 145:139 */       session.setAttribute("searchResult", new SubjectBeanCl().getSubjectByYear(teacherName, selDepartment, key, year, xibie));
/* 146:140 */       session.setAttribute("selDepartment", selDepartment);
/* 147:141 */       session.setAttribute("teacher", teacherName);
/* 148:142 */       session.setAttribute("key", key);
/* 149:143 */       session.setAttribute("year", year);
/* 150:144 */       response.sendRedirect("admin/admin.jsp?function=sub_all1");
/* 151:    */     }
/* 152:145 */     else if (flag.equals("screening2"))
/* 153:    */     {
/* 154:147 */       String teacherName = request.getParameter("teacher").trim();
/* 155:148 */       String selDepartment = request.getParameter("selDepartment").trim();
/* 156:149 */       String key = request.getParameter("key").trim();
/* 157:151 */       if ((selDepartment == null) || ("".equals(selDepartment))) {
/* 158:151 */         selDepartment = "0";
/* 159:    */       }
/* 160:152 */       if (teacherName == null) {
/* 161:152 */         teacherName = "";
/* 162:    */       }
/* 163:155 */       session.setAttribute("searchResult", new SubjectBeanCl().getSubjectByNameAndDept(teacherName, selDepartment, key));
/* 164:156 */       session.setAttribute("selDepartment", selDepartment);
/* 165:157 */       session.setAttribute("teacher", teacherName);
/* 166:158 */       response.sendRedirect("admin/admin.jsp?function=choose_state");
/* 167:    */     }
/* 168:159 */     else if (flag.equals("QueryByCriteria"))
/* 169:    */     {
/* 170:160 */       String selDepartment = request.getParameter("selDepartment").trim();
/* 171:161 */       session.setAttribute("selDepartment", selDepartment);
/* 172:162 */       response.sendRedirect("admin/admin.jsp?function=tea_all");
/* 173:    */     }
/* 174:163 */     else if (flag.equals("admin_modify"))
/* 175:    */     {
/* 176:164 */       String id = request.getParameter("id");
/* 177:165 */       String psw = request.getParameter("psw");
/* 178:166 */       String name = request.getParameter("name");
/* 179:167 */       String phoneNum = request.getParameter("phoneNum");
/* 180:168 */       String email = request.getParameter("email");
/* 181:169 */       System.out.println("1111");
/* 182:170 */       AdminBean tb = new AdminBean(id, psw, name, phoneNum, email);
/* 183:171 */       System.out.println(name);
/* 184:172 */       new TeacherBeanCl().modifyAdByTb(tb);
/* 185:173 */       response.sendRedirect("sadmin/admin.jsp?function=admin_all");
/* 186:    */     }
/* 187:174 */     else if (flag.equals("admin_del"))
/* 188:    */     {
/* 189:175 */       String adminId = request.getParameter("adminId").trim();
/* 190:176 */       new TeacherBeanCl().delAdminById(adminId);
/* 191:177 */       String yuanxi = request.getParameter("yuanxi").trim();
/* 192:178 */       System.out.println(yuanxi);
/* 193:179 */       new SettingsCl().delSettingsByyuanxi(yuanxi);
/* 194:180 */       new StageBeanCl().delStageByyuanxi(yuanxi);
/* 195:181 */       response.sendRedirect("sadmin/admin.jsp?function=admin_all");
/* 196:    */     }
/* 197:    */   }
/* 198:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.TeaManageServlet
 * JD-Core Version:    0.7.0.1
 */