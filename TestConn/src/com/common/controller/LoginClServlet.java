package com.common.controller;

import com.ax.subject.model.SetBean;
import com.ax.subject.model.SetBeanCl;
import com.ax.subject.model.StudentBean;
import com.ax.subject.model.StudentBeanCl;
import com.kk.subject.model.AdminBean;
import com.kk.subject.model.AdminBeanCl;
import com.kk.subject.model.TeacherBean;
import com.kk.subject.model.TeacherBeanCl;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginClServlet
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
    
    HttpSession session = request.getSession(true);
    
    session.setMaxInactiveInterval(10800);
    String ver = (String)request.getSession().getAttribute("captcha");
    String ver1 = request.getParameter("ver").trim();
    String err = "";
    if (!ver.equals(ver1))
    {
      err = "验证码错误！";
    }
    else
    {
      String type = request.getParameter("u_type");
      String id = request.getParameter("id").trim();
      String psw = request.getParameter("psw").trim();
      if (type.equals("tea"))
      {
        TeacherBeanCl tbc = new TeacherBeanCl();
        if (tbc.checkUser(id, psw))
        {
          TeacherBean tb = tbc.getTeacherById(id);
            
          session.setAttribute("user", tb);
          session.setAttribute("yuanxi", tb.getDepartment());
          session.setAttribute("teaname", tb.getName());
          response.sendRedirect("teacher/teacher.jsp?function=info_view");
          return;
        }
        err = "用户名或密码不正确！";
      }
      else if (type.equals("stu"))
      {
        StudentBeanCl sbc = new StudentBeanCl();
        if (sbc.checkUser(id, psw))
        {
          
          StudentBean sb = new StudentBeanCl().getStudentById(id);
          session.setAttribute("user", sb);
          System.out.println(sb.getId());
          session.setAttribute("yuanxi", sb.getYuanxi());
          session.setAttribute("stuname", sb.getName());
          response.sendRedirect("student/student.jsp?function=info_view");
          String gradute = new SetBeanCl().getAllinfo(sb.getYuanxi())
            .getGraduateGrade();
          System.out.println(gradute);
          err = "目前无法访问";
          return;
          
        }
        err = "用户名或密码不正确！";
        
      }
      else if (type.equals("admin"))
      {
        AdminBeanCl abc = new AdminBeanCl();
        if (abc.checkUser(id, psw))
        {
          AdminBean ab = abc.getAdminById(id);
          session.setAttribute("user", ab);
          int t = ab.getType();
          String yuanxi = ab.getYuanxi();
          session.setAttribute("yuanxi", yuanxi);
          System.out.println(yuanxi);
          if (t == 0) {
            response.sendRedirect("sadmin/admin.jsp?function=attentions");
          } else {
            response.sendRedirect("admin/admin.jsp?function=attentions");
          }
          return;
        }
        err = "用户名或密码不正确！";
      }
    }
    if (!err.equals("")) {
      request.getRequestDispatcher("login.jsp?err=" + err).forward(
        request, response);
    }
  }
}
