package com.common.controller;

import com.kk.subject.model.ExportExcel;
import com.kk.subject.model.SubjectBean;
import com.kk.subject.model.SubjectBeanCl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExportServlet
  extends HttpServlet
{
  static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("aapplication/x-xls;charset=utf-8");
    

    response.addHeader("content-type", "application/x-xls");
    response.addHeader("Content-Disposition", 
      "attachment;filename=\"" + new String("毕业题目表.xls".getBytes("GB2312"), 
      "iso8859-1") + "\"");
    
    ExportExcel<SubjectBean> ex = new ExportExcel();
    String[] headers = { "编号", "题目名称", "出题老师", "方向", "介绍", "计划", 
		      "参考文献", "学生要求",  "审核状态",  "关键词", "所属学院"};
    String yuanxi = request.getParameter("yuanxi");
    System.out.println(yuanxi);
    ArrayList<SubjectBean> alsb = new SubjectBeanCl().getAllSub(yuanxi);
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
    doGet(request, response);
  }
}
