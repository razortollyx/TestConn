package com.ax.subject.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherBeanCl
{
  private Connection ct = null;
  private Statement sm = null;
  private ResultSet rs = null;
  private TeacherBean tb = null;
  
  public TeacherBean getTeacherById(String id)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from T_Teacher where id='" + id + "'";
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.tb = new TeacherBean();
        
        this.tb.setId(this.rs.getString(1));
        this.tb.setPsw(this.rs.getString(2));
        this.tb.setName(this.rs.getString(3));
        this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
        this.tb.setPhoneNum(this.rs.getString(5));
        this.tb.setEmail(this.rs.getString(6));
        this.tb.setJobTitle(this.rs.getString(7));
        this.tb.setMaxSubNum(this.rs.getShort(8));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSourse();
    }
    return this.tb;
  }
  
  public TeacherBean getTeacherBySubId(String sub_id)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from t_teacher where id in (select  t_id from t_teacher_sub where s_id='" + sub_id + "')";
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.tb = new TeacherBean();
        
        this.tb.setId(this.rs.getString(1));
        this.tb.setPsw(this.rs.getString(2));
        this.tb.setName(this.rs.getString(3));
        this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
        this.tb.setPhoneNum(this.rs.getString(5));
        this.tb.setEmail(this.rs.getString(6));
        this.tb.setJobTitle(this.rs.getString(7));
        this.tb.setMaxSubNum(this.rs.getShort(8));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSourse();
    }
    return this.tb;
  }
  
  public TeacherBean getTeacherByName(String Name)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from t_teacher where name ='" + Name + "')";
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.tb = new TeacherBean();
        
        this.tb.setId(this.rs.getString(1));
        this.tb.setPsw(this.rs.getString(2));
        this.tb.setName(this.rs.getString(3));
        this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
        this.tb.setPhoneNum(this.rs.getString(5));
        this.tb.setEmail(this.rs.getString(6));
        this.tb.setJobTitle(this.rs.getString(7));
        this.tb.setMaxSubNum(this.rs.getShort(8));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSourse();
    }
    return this.tb;
  }
  
  public int updatemaxNum(String maxnum, String yuanxi)
  {
    int i = 0;
    try
    {
      System.out.println(maxnum + "x");
      
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "update t_teacher  set maxSubNum='" + maxnum + "' where department='" + yuanxi + "'";
      i = this.sm.executeUpdate(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSourse();
    }
    return i;
  }
  
  public void closeSourse()
  {
    try
    {
      if (this.rs != null)
      {
        this.rs.close();
        this.rs = null;
      }
      if (this.sm != null)
      {
        this.sm.close();
        this.sm = null;
      }
      if (this.ct != null)
      {
        this.ct.close();
        this.ct = null;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  public boolean checkUser(String u, String p)
  {
    boolean b = false;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      
      this.rs = this.sm.executeQuery("select psw from T_Teacher where id='" + u + "'");
      if (this.rs.next()) {
        if (this.rs.getString(1).equals(p)) {
          b = true;
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSourse();
    }
    return b;
  }
  
  public int updateData(String sql)
  {
    int i = 0;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      i = this.sm.executeUpdate(sql);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSourse();
    }
    return i;
  }
}
