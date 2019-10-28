package com.ax.subject.controller;

import com.ax.subject.model.SetBeanCl;
import com.ax.subject.model.StudentBean;
import com.ax.subject.model.StudentBeanCl;
import com.ax.subject.model.StudentSubjectBeanCl;
import com.ax.subject.model.SubjectBeanCl;
import com.kk.subject.model.StuWishBean;
import com.kk.subject.model.StuWishBeanCI;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateDataServlet
  extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("UTF-8");
    
    String flag = request.getParameter("flag");
    String sql = "";
    HttpSession session = request.getSession(true);
    if (flag.equals("student_info_modify"))
    {
      String id = request.getParameter("id");
      String name = request.getParameter("name");
      String sex = request.getParameter("sex");
      String cls = request.getParameter("selCls");
      String major = request.getParameter("major");
      String phoneNum = request.getParameter("phoneNum");
      String email = request.getParameter("email");
      sql = "update t_student set name='" + name + "',sex='" + sex + "',class = '" + cls + "',major = '" + major + "',phoneNum='" + phoneNum + "',email='" + email + "' where id='" + id + "'";
      System.out.println(sql);
      StudentBeanCl sbc = new StudentBeanCl();
      
      sbc.updateData(sql);
      
      session.setAttribute("user", sbc.getStudentById(id));
      request.getRequestDispatcher("student/student.jsp?function=info_view").forward(request, response);
    }
    else if (flag.equals("student_psw_modify"))
    {
      String id = ((StudentBean)session.getAttribute("user")).getId();
      String newPsw = request.getParameter("newPsw1");
      sql = "update t_student set psw='" + newPsw + "' where id='" + id + "'";
      System.out.println("sql=" + sql);
      StudentBeanCl sbc = new StudentBeanCl();
      sbc.updateData(sql);
      
      session.setAttribute("user", sbc.getStudentById(id));
      request.getRequestDispatcher("student/student.jsp?function=info_view").forward(request, response);
    }
    else if (flag.equals("select_sub"))
    {
      StudentBean stuBean = (StudentBean)session.getAttribute("user");
      
      String stuId = stuBean.getId();
      String wish = request.getParameter("wish_type");
      String yuanxi = stuBean.getYuanxi();
      
      
      ArrayList<StuWishBean> arrSSTB = new StuWishBeanCI().getStuWishById(stuId);
      int warnNum = new SetBeanCl().getAllinfo(yuanxi).getWarnNum();
      if(arrSSTB.size()>=warnNum) {
    	  
      	  request.setAttribute("tishi", "该题目选题人数已满！请选择其他题目");
	      request.getRequestDispatcher("student/student.jsp?function=sub_all").forward(request,response);

      }
      System.out.println("选择的志愿" + wish);
      String subId = request.getParameter("subId");
      StudentSubjectBeanCl ssbc = new StudentSubjectBeanCl();
      ssbc.insertByStuIdWish1(subId, stuId, wish);
      SubjectBeanCl sbc = new SubjectBeanCl();
      int k = ssbc.selectByStuIdWish(stuId, wish);
      if (k != 0)
      {
        System.out.println(subId);
        sbc.updateSelectedNum(String.valueOf(k), -1);
      }
      sbc.updateSelectedNum(subId, 1);
      ssbc.deleteByStuIdWish(stuId, wish);
      ssbc.insertByStuIdWish(subId, stuId, wish, yuanxi);
      session.setAttribute("searchResult", null);
      response.sendRedirect("student/student.jsp?function=sub_all");
    }
    else if (flag.equals("screening"))
    {
      String teacherName = request.getParameter("teacher");
      System.out.println(teacherName);
      String Direction = request.getParameter("direction");
      String Title = request.getParameter("title");
      String yuanxi = request.getParameter("selDepartment");
      String id = request.getParameter("userid");
      session.setAttribute("Direction", Direction);
      session.setAttribute("Title", Title);
      session.setAttribute("teacherName", teacherName);
      System.out.println(yuanxi);
      if ((teacherName != null) && (Direction == "") && (Title == ""))
      {
        System.out.println("11");
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeacher(teacherName, yuanxi, id));
      }
      else if ((teacherName == "") && (Direction != null) && (Title == ""))
      {
        System.out.println("2");
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromDirection(Direction, yuanxi, id));
      }
      else if ((teacherName == "") && (Direction == "") && (Title != null))
      {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTitle(Title, yuanxi, id));
      }
      else if ((teacherName == "") && (Direction != null) && (Title != null))
      {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromDirandTit(Direction, Title, yuanxi, id));
      }
      else if ((teacherName != null) && (Direction != null) && (Title == ""))
      {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeaandDir(teacherName, Direction, yuanxi, id));
      }
      else if ((teacherName != null) && (Direction == "") && (Title != null))
      {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeaandTit(teacherName, Title, yuanxi, id));
      }
      else if ((teacherName != null) && (Direction != null) && (Title != null))
      {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeaandDirandTit(teacherName, Direction, Title, yuanxi, id));
      }
      request.setAttribute("tishi", "选题成功！");
      response.sendRedirect("student/student.jsp?function=sub_all");
    }
    else if (flag.equals("screening1"))
    {
      String teacherName = request.getParameter("teacher");
      String yuanxi = request.getParameter("selDepartment");
      System.out.println(yuanxi);
      String Direction = request.getParameter("direction");
      String Title = request.getParameter("title");
      String id = request.getParameter("userid");
      if ((teacherName != null) && (Direction == null) && (Title == null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeacher(teacherName, yuanxi, id));
      } else if ((teacherName == null) && (Direction != null) && (Title == null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromDirection(Direction, yuanxi, id));
      } else if ((teacherName == null) && (Direction == null) && (Title != null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTitle(Title, yuanxi, id));
      } else if ((teacherName == null) && (Direction != null) && (Title != null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromDirandTit(Direction, Title, yuanxi, id));
      } else if ((teacherName != null) && (Direction != null) && (Title == null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeaandDir(teacherName, Direction, yuanxi, id));
      } else if ((teacherName != null) && (Direction == null) && (Title != null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeaandTit(teacherName, Title, yuanxi, id));
      } else if ((teacherName != null) && (Direction != null) && (Title != null)) {
        session.setAttribute("searchResult", new SubjectBeanCl().getAllSubFromTeaandDirandTit(teacherName, Direction, Title, yuanxi, id));
      }
      response.sendRedirect("student/student.jsp?function=sub_all1");
    }
    else if (flag.equals("alternative"))
    {
      String stuId = ((StudentBean)session.getAttribute("user")).getId();
      StudentSubjectBeanCl ssbc = new StudentSubjectBeanCl();
      String[] checkv = request.getParameterValues("pick");
      if (checkv != null)
      {
        for (int i = 0; i < checkv.length; i++)
        {
          sql = " insert into t_stu_sub (sub_Id,stu_Id,wish) values ('" + checkv[i] + "','" + stuId + "','" + 4 + "')";
          new StudentSubjectBeanCl().updateData(sql);
        }
        response.sendRedirect("student/student.jsp?function=sub_all1");
      }
    }
    else if (flag.equals("deleteSub"))
    {
      String stuId = ((StudentBean)session.getAttribute("user")).getId();
      String subId = request.getParameter("subId");
      

      SubjectBeanCl sbc = new SubjectBeanCl();
      StudentSubjectBeanCl ssbc = new StudentSubjectBeanCl();
      ssbc.getWish(Integer.parseInt(subId), stuId);
      if (!ssbc.getWish(Integer.parseInt(subId), stuId).equals(Character.valueOf('4')))
      {
        if (sbc.delSubjectById(stuId, subId))
        {
          sbc.updateSelectedNum(subId, -1);
          response.sendRedirect("student/student.jsp?function=chakan_choose");
        }
      }
      else if (sbc.delSubjectById(stuId, subId)) {
        response.sendRedirect("student/student.jsp?function=chakan_choose");
      }
    }
    else if (flag.equals("deleteSub1"))
    {
      String stuId = ((StudentBean)session.getAttribute("user")).getId();
      String subId = request.getParameter("subId");
      

      SubjectBeanCl sbc = new SubjectBeanCl();
      StudentSubjectBeanCl ssbc = new StudentSubjectBeanCl();
      ssbc.getWish(Integer.parseInt(subId), stuId);
      if (!ssbc.getWish(Integer.parseInt(subId), stuId).equals(Character.valueOf('4')))
      {
        if (sbc.delSubjectById(stuId, subId))
        {
          sbc.updateSelectedNum(subId, -1);
          response.sendRedirect("student/student.jsp?function=sub_all");
        }
      }
      else if (sbc.delSubjectById(stuId, subId)) {
        response.sendRedirect("student/student.jsp?function=sub_all");
      }
    }
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}
