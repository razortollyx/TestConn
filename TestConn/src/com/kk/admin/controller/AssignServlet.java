/*  1:   */ package com.kk.admin.controller;
/*  2:   */ 
/*  3:   */ import com.kk.subject.model.StuSubBean;
import com.kk.subject.model.StuSubBeanCl;
/*  4:   */ import com.kk.subject.model.StuSubTeaBean;
/*  5:   */ import com.kk.subject.model.StuSubTeaBeanCl;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.io.PrintStream;
/*  8:   */ import java.util.ArrayList;
/*  9:   */ import javax.servlet.ServletException;
/* 10:   */ import javax.servlet.http.HttpServlet;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 13:   */ 
/* 14:   */ public class AssignServlet
/* 15:   */   extends HttpServlet
/* 16:   */ {
/* 17:   */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/* 18:   */     throws ServletException, IOException
/* 19:   */   {
/* 20:28 */     doPost(request, response);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/* 24:   */     throws ServletException, IOException
/* 25:   */   {
/* 26:44 */     request.setCharacterEncoding("UTF-8");
/* 27:   */     
/* 28:46 */     String flag = request.getParameter("flag");
/* 29:48 */     if (flag.equals("assign"))
/* 30:   */     {
/* 31:49 */       String stuId = request.getParameter("pickStu");
/* 32:50 */       String subId = request.getParameter("pickSub");
/* 33:51 */       String yuanxi = request.getParameter("selDepartment");
				  ArrayList<StuSubBean> arrSSTB;	
				  arrSSTB  =	new StuSubBeanCl().getAllSSB(yuanxi);
				  int t=0;
				  System.out.println("arrSSTB.size():"+arrSSTB.size());
				  for(int j=0;j<arrSSTB.size();j++){
					  StuSubBean sstb = arrSSTB.get(j);
				      if(   (stuId.equals(sstb.getStuId())) && (subId.equals(String.valueOf(sstb.getSubId())))){
				    	  System.out.println(stuId);
				    	  System.out.println(subId);
				    	  
				    	  t++;
				      }
				      
				  
				  }
				  if(t!=0){
					int m =  new StuSubBeanCl().assignByStuIdSubId1(stuId, subId, yuanxi);
					System.out.println("m="+m);
				  }else{
				  
/* 34:52 */       int i = new StuSubBeanCl().assignByStuIdSubId(stuId, subId, yuanxi);
					System.out.println("i="+i);
/* 35:53 */       }
				  response.sendRedirect("admin/admin.jsp?function=fail");
/* 36:   */     }
/* 37:54 */     else if (flag.equals("repeal"))
/* 38:   */     {
/* 39:55 */       String stuId = request.getParameter("stuId");
/* 40:56 */       String subId = request.getParameter("subId");
/* 41:57 */       int i = new StuSubBeanCl().repealAssign(stuId, subId);
/* 42:   */       
/* 43:59 */       response.sendRedirect("admin/admin.jsp?function=choose_result");
/* 44:   */     }
/* 45:60 */     else if (flag.equals("repeal1"))
/* 46:   */     {
/* 47:61 */       String stuId = request.getParameter("stuId");
/* 48:62 */       String subId = request.getParameter("subId");
/* 49:63 */       int i = new StuSubBeanCl().repealAssign(stuId, subId);
/* 50:   */       
/* 51:65 */       response.sendRedirect("teacher/teacher.jsp?function=choose_stu1");
/* 52:   */     }
/* 53:66 */     else if (flag.equals("autoAssign"))
/* 54:   */     {
/* 55:67 */       String yuanxi = request.getParameter("selDepartment");
/* 56:68 */       new StuSubTeaBeanCl().autoAssign(yuanxi);
/* 57:69 */       response.sendRedirect("admin/admin.jsp?function=fail");
/* 58:   */     }
/* 59:70 */     else if (flag.equals("randomAssign"))
/* 60:   */     {
/* 61:71 */       String yuanxi = request.getParameter("selDepartment");
/* 62:72 */       new StuSubTeaBeanCl().randomAssign(yuanxi);
/* 63:73 */       response.sendRedirect("admin/admin.jsp?function=fail");
/* 64:   */     }
/* 65:74 */     else if (flag.equals("auto"))
/* 66:   */     {
/* 67:75 */       String yuanxi = request.getParameter("selDepartment");
/* 68:76 */       String teacher = "";
/* 69:77 */       ArrayList<StuSubTeaBean> arrSSTB = new StuSubTeaBeanCl().getMyAllResult(teacher, yuanxi);
/* 70:78 */       System.out.println(arrSSTB.size());
/* 71:79 */       new StuSubTeaBeanCl().auto();
/* 72:   */       
/* 73:81 */       response.sendRedirect("admin/admin.jsp?function=choose_result1");
/* 74:   */     }
/* 75:   */   }
/* 76:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.admin.controller.AssignServlet
 * JD-Core Version:    0.7.0.1
 */