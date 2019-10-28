package com.common.controller;

import com.kk.subject.model.ExportExcel;
import com.kk.subject.model.ExportExcel2;
import com.kk.subject.model.StuSubTeaBean;
import com.kk.subject.model.StuSubTeaBeanCl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExportServlet1
  extends HttpServlet
{
  static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    HttpSession session = request.getSession(true);
    

    response.setContentType("application/x-xls;charset=utf-8");
    

    response.addHeader("Content-Disposition", 
      "attachment;filename=\"" + new String("毕业生选题结果表.xls".getBytes("GB2312"), 
      "iso8859-1") + "\"");
    ExportExcel2 ex = new ExportExcel2();

    String yuanxi = session.getAttribute("yuanxi").toString();
        
    String[] headers = {  "题目编号", "题目", "学生姓名", "学生学号","学生选择志愿", "教师姓名",  "老师分配志愿",  "是否选中" };
    ArrayList<StuSubTeaBean> alsb = new StuSubTeaBeanCl().ExcelgetAllSSTB(yuanxi);
    try
    {
      OutputStream out = response.getOutputStream();
      ex.exportExcel(headers, alsb, out);
      out.close();
      System.out.println("excel导出成功！");
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("post");
    doGet(request, response);
  }
}
