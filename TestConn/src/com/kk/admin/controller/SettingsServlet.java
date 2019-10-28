/*   1:    */ package com.kk.admin.controller;
/*   2:    */ 
/*   3:    */ import com.ax.subject.model.TeacherBeanCl;
/*   4:    */ import com.kk.subject.model.AdminBean;
/*   5:    */ import com.kk.subject.model.AdminBeanCl;
/*   6:    */ import com.kk.subject.model.Department;
/*   7:    */ import com.kk.subject.model.DepartmentCl;
/*   8:    */ import com.kk.subject.model.Direction;
/*   9:    */ import com.kk.subject.model.DirectionCl;
/*  10:    */ import com.kk.subject.model.JobTitleBeanCl;
/*  11:    */ import com.kk.subject.model.SettingsCl;
/*  12:    */ import com.kk.subject.model.StageBeanCl;
/*  13:    */ import java.io.IOException;
/*  14:    */ import java.io.PrintStream;
/*  15:    */ import java.util.ArrayList;
/*  16:    */ import javax.servlet.ServletException;
/*  17:    */ import javax.servlet.http.HttpServlet;
/*  18:    */ import javax.servlet.http.HttpServletRequest;
/*  19:    */ import javax.servlet.http.HttpServletResponse;
/*  20:    */ import javax.servlet.http.HttpSession;
/*  21:    */ 
/*  22:    */ public class SettingsServlet
/*  23:    */   extends HttpServlet
/*  24:    */ {
/*  25:    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*  26:    */     throws ServletException, IOException
/*  27:    */   {
/*  28: 30 */     int k = 0;
/*  29:    */     
/*  30: 32 */     request.setCharacterEncoding("UTF-8");
/*  31: 33 */     HttpSession session = request.getSession(true);
/*  32:    */     
/*  33: 35 */     String flag = request.getParameter("flag");
/*  34: 36 */     System.out.println("SettingsServlet：flag=" + flag);
/*  35:    */     
/*  36: 38 */     String yuanxi = session.getAttribute("yuanxi").toString();
/*  37: 39 */     System.out.println(yuanxi);
/*  38: 41 */     if (flag.equals("admin_psw_modify"))
/*  39:    */     {
/*  40: 42 */       String id = ((AdminBean)session.getAttribute("user")).getId();
/*  41: 43 */       String newPsw = request.getParameter("newPsw1");
/*  42: 44 */       String sql = "update t_admin set psw='" + newPsw + "' where id='" + id + "'";
/*  43:    */       
/*  44: 46 */       AdminBeanCl abc = new AdminBeanCl();
/*  45: 47 */       abc.updateData(sql);
/*  46: 48 */       AdminBean ab = abc.getAdminById(id);
/*  47:    */       
/*  48: 50 */       session.setAttribute("user", abc.getAdminById(id));
/*  49: 51 */       if (ab.getYuanxi().equals("校级管理员")) {
/*  50: 53 */         response.sendRedirect("sadmin/admin.jsp?function=attentions");
/*  51:    */       } else {
/*  52: 55 */         response.sendRedirect("admin/admin.jsp?function=attentions");
/*  53:    */       }
/*  54:    */     }
/*  55: 57 */     else if (flag.equals("setStage"))
/*  56:    */     {
/*  57: 58 */       String[] strStartTime = request.getParameterValues("startTime");
/*  58: 59 */       String[] strEndTime = request.getParameterValues("endTime");
/*  59: 60 */       String[] statename = request.getParameterValues("statename");
/*  60:    */       
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64: 65 */       System.out.println(yuanxi);
/*  65: 66 */       new StageBeanCl().setStage(strStartTime, strEndTime, statename, yuanxi);
/*  66: 67 */       response.sendRedirect("admin/admin.jsp?function=stage");
/*  67:    */     }
/*  68:    */     else
/*  69:    */     {
/*  70: 70 */       if (flag.equals("warnNum"))
/*  71:    */       {
/*  72: 71 */         String warnNum = request.getParameter("warnNum").trim();
/*  73: 72 */         if (!warnNum.equals("")) {
/*  74: 72 */           new SettingsCl().setWarnNum(warnNum, yuanxi);
/*  75:    */         }
/*  76:    */       }
/*  77: 73 */       else if (flag.equals("maxSelNum"))
/*  78:    */       {
/*  79: 74 */         String maxSelNum = request.getParameter("maxSelNum").trim();
/*  80: 75 */         if (!maxSelNum.equals("")) {
/*  81: 75 */           new SettingsCl().setMaxSelNum(maxSelNum, yuanxi);
/*  82:    */         }
/*  83:    */       }
/*  84: 76 */       else if (flag.equals("maxNum"))
/*  85:    */       {
/*  86: 77 */         String maxNum = request.getParameter("maxNum").trim();
/*  87: 78 */         if (!maxNum.equals(""))
/*  88:    */         {
/*  89: 79 */           new SettingsCl().setmaxNum(maxNum, yuanxi);
/*  90: 80 */           new TeacherBeanCl().updatemaxNum(maxNum, yuanxi);
/*  91:    */         }
/*  92:    */       }
/*  93: 82 */       else if (flag.equals("del_direc"))
/*  94:    */       {
/*  95: 83 */         String d_id = request.getParameter("id");
/*  96: 84 */         int id = Integer.parseInt(d_id);
/*  97: 85 */         new DirectionCl().delById(id);
/*  98:    */       }
/*  99: 86 */       else if (flag.equals("add_direc"))
/* 100:    */       {
/* 101: 87 */         String direction = request.getParameter("direction").trim().toString();
/* 102: 88 */         ArrayList<Direction> ald = new DirectionCl().getAllDirec(yuanxi);
/* 103: 89 */         for (int i = 0; i < ald.size(); i++)
/* 104:    */         {
/* 105: 90 */           System.out.println("XXx" + direction);
/* 106: 91 */           System.out.println("XXX" + ((Direction)ald.get(i)).getDirection());
/* 107: 92 */           System.out.println(((Direction)ald.get(i)).getDirection().toString() == direction);
/* 108: 93 */           if (((Direction)ald.get(i)).getDirection().toString().equals(direction)) {
/* 109: 94 */             k = -1;
/* 110:    */           }
/* 111:    */         }
/* 112: 97 */         if ((k == 0) && 
/* 113: 98 */           (!direction.equals(""))) {
/* 114: 98 */           new DirectionCl().insertDirec(direction, yuanxi);
/* 115:    */         }
/* 116:    */       }
/* 117:101 */       else if (flag.equals("graduateGrade"))
/* 118:    */       {
/* 119:102 */         String graduateGrade = request.getParameter("graduateGrade").trim();
/* 120:103 */         if (!graduateGrade.equals("")) {
/* 121:103 */           new SettingsCl().setGraduateGrade(graduateGrade, yuanxi);
/* 122:    */         }
/* 123:    */       }
/* 124:104 */       else if (flag.equals("add_jobTitle"))
/* 125:    */       {
/* 126:105 */         String jobTitle = request.getParameter("jobTitle").trim().toString();
/* 127:106 */         String[] job = new JobTitleBeanCl().getAllJT(yuanxi);
/* 128:107 */         for (int i = 0; i < job.length; i++) {
/* 129:108 */           if (job[i].equals(jobTitle)) {
/* 130:109 */             k = -1;
/* 131:    */           }
/* 132:    */         }
/* 133:112 */         if ((k == 0) && 
/* 134:113 */           (!jobTitle.equals("")) && (!new JobTitleBeanCl().jtExist(jobTitle, yuanxi))) {
/* 135:113 */           new JobTitleBeanCl().insertJt(jobTitle, yuanxi);
/* 136:    */         }
/* 137:    */       }
/* 138:115 */       else if (flag.equals("del_jobTitle"))
/* 139:    */       {
/* 140:116 */         String jobTitle = request.getParameter("jobTitle").toString();
/* 141:117 */         if (!jobTitle.equals("")) {
/* 142:117 */           new JobTitleBeanCl().delJt(jobTitle);
/* 143:    */         }
/* 144:    */       }
/* 145:118 */       else if (flag.equals("add_dep"))
/* 146:    */       {
/* 147:119 */         String department = request.getParameter("department");
/* 148:120 */         ArrayList<Department> ale = new DepartmentCl().getAllDep(yuanxi);
/* 149:121 */         for (int i = 0; i < ale.size(); i++) {
/* 150:122 */           if (((Department)ale.get(i)).getDepartment().toString().equals(department)) {
/* 151:123 */             k = -1;
/* 152:    */           }
/* 153:    */         }
/* 154:126 */         if ((k == 0) && 
/* 155:127 */           (department != null) && (!"".equals(department))) {
/* 156:127 */           new DepartmentCl().addDep(department, yuanxi);
/* 157:    */         }
/* 158:    */       }
/* 159:130 */       else if (flag.equals("del_dep"))
/* 160:    */       {
/* 161:131 */         String id = request.getParameter("id");
/* 162:132 */         if ((id != null) && (!"".equals(id))) {
/* 163:132 */           new DepartmentCl().delDepById(id);
/* 164:    */         }
/* 165:    */       }
/* 166:134 */       response.sendRedirect("admin/admin.jsp?function=settings&key=" + k);
/* 167:    */     }
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 171:    */     throws ServletException, IOException
/* 172:    */   {
/* 173:151 */     doGet(request, response);
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.SettingsServlet
 * JD-Core Version:    0.7.0.1
 */