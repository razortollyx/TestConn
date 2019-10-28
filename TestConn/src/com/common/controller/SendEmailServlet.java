package com.common.controller;

import com.ax.subject.model.StudentBean;
import com.ax.subject.model.StudentBeanCl;
import com.kk.subject.model.TeacherBean;
import com.kk.subject.model.TeacherBeanCl;
import email.MailSenderInfo;
import email.SimpleMailSender;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmailServlet
  extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String id = request.getParameter("id");
    String email = request.getParameter("email");
    StudentBeanCl sbc = new StudentBeanCl();
    TeacherBeanCl tbc = new TeacherBeanCl();
    if ((sbc.checkEmail(id, email)) || (tbc.checkEmail(id, email)))
    {
      String psw = "";
      if (tbc.checkEmail(id, email)) {
        psw = tbc.getTeacherById(id).getPsw();
      } else {
        psw = sbc.getStudentById(id).getPsw();
      }
      MailSenderInfo mailInfo = new MailSenderInfo();
      mailInfo.setMailServerHost("smtp.sina.com.cn");
      mailInfo.setMailServerPort("25");
      mailInfo.setValidate(true);
      mailInfo.setUserName("a20101001698@sina.com");
      mailInfo.setPassword("ts9unha8");
      mailInfo.setFromAddress("a20101001698@sina.com");
      mailInfo.setToAddress(email);
      mailInfo.setSubject("密码找回");
      mailInfo.setContent("你的密码为" + psw + ",请妥善保管好您的密码。\n\n\t\t\t此为系统邮件，请勿回复!");
      

      SimpleMailSender sms = new SimpleMailSender();
      sms.sendTextMail(mailInfo);
      


      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    else
    {
      String err = "账号与邮箱不匹配 ！请重新输入";
      request.getRequestDispatcher("Found.jsp?err=" + err).forward(request, response);
    }
  }
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
  
  public void destroy() {}
}
