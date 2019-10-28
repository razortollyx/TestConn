package com.common.controller;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SortServlet
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
    HttpSession hs = request.getSession(true);
    
    System.out.println("SortServlet");
    
    String attiName = request.getParameter("attiName");
    if (attiName != null) {
      System.out.println("attiName=" + attiName);
    }
    hs.setAttribute("attiName", attiName);
    response.sendRedirect(request.getParameter("url"));
  }
}
