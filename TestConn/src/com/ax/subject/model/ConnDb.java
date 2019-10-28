package com.ax.subject.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDb
{
  private Connection ct = null;
  
  public Connection getConn()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      


      this.ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1111?useUnicode=true&characterEncoding=UTF-8","root","123456");
      //("jdbc:mysql://localhost:3307/test4?useUnicode=true&characterEncoding=UTF-8","root","root1234");
      //jdbc:mysql://106.12.44.134:3306/lixiang88","lixiang88","abc123abc123" 
      if (this.ct.isClosed()) {
        System.out.println("连接不成功！");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return this.ct;
  }
}
