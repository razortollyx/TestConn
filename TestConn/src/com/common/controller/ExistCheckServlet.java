package com.common.controller;

import com.kk.subject.model.AdminBeanCl;
import com.kk.subject.model.TeacherBean;
import com.kk.subject.model.TeacherBeanCl;
import com.kk.subject.model.TeacherSubBeanCl;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExistCheckServlet
  extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("UTF-8");
    String flag = request.getParameter("flag");
    
    String b = "false";
    if (flag.equals("stu_exist_check"))
    {
      String stuId = request.getParameter("stuId");
      if (new com.kk.subject.model.StudentBeanCl().checkExist(stuId)) {
        b = "true";
      }
    }
    else if (flag.equals("tea_exist_check"))
    {
      String teaId = request.getParameter("teaId");
      if (new TeacherBeanCl().checkExist(teaId)) {
        b = "true";
      }
    }
    else if (flag.equals("admin_exist_check"))
    {
      String adminId = request.getParameter("adminId");
      if (new AdminBeanCl().checkExist(adminId)) {
        b = "true";
      }
    }
    else if (flag.equals("yuanxi_exist_check"))
    {
      String yuanxi = request.getParameter("yuanxi");
      yuanxi = new String(yuanxi.getBytes("ISO-8859-1"), "utf-8");
      System.out.println(yuanxi + "XXX");
      if (new AdminBeanCl().checkExist1(yuanxi)) {
        b = "true";
      }
    }
    else if (flag.equals("title_exist_check"))
    {
      String teaId = request.getParameter("teaId").trim();
      String title = request.getParameter("title").trim();
      System.out.println("title=" + title);
      TeacherBean tb = new TeacherBeanCl().getTeacherById(teaId);
      if (tb.getMaxSubNum() <= tb.getSubNum()) {
        b = "limited";
      } else {
        b = new TeacherSubBeanCl().titleExistCheck(teaId, title);
      }
    }
    else if (flag.equals("phoneNum_exist_check"))
    {
      String id = request.getParameter("id").trim();
      String pm = request.getParameter("phoneNum").trim();
      b = new com.ax.subject.model.StudentBeanCl().phoneNumberExitCheck(id, pm);
    }
    else if (flag.equals("email_exist_check"))
    {
      String id = request.getParameter("id").trim();
      String email = request.getParameter("email").trim();
      b = new com.ax.subject.model.StudentBeanCl().emaliExitCheck(id, email);
    }
    response.getWriter().print(b);
  }
}
