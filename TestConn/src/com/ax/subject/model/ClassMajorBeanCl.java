package com.ax.subject.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassMajorBeanCl
{
  private Connection ct = null;
  private Statement sm = null;
  private ResultSet rs = null;
  private ClassMajorBean cmb = null;
  
  public ClassMajorBean getClassById()
  {
    try
    {
      this.cmb = new ClassMajorBean();
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from t_class ";
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.cmb.setId(this.rs.getString(1));
        this.cmb.setMajorname(this.rs.getString(2));
        this.cmb.setStuNum(this.rs.getString(3));
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
    return this.cmb;
  }
  
  public int[] getClassId()
  {
    int[] AllClassId = null;
    int i = 0;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select count(*)  from t_class ";
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next()) {
        AllClassId = new int[this.rs.getInt(1)];
      }
      String sql1 = "select id from t_class";
      this.rs = this.sm.executeQuery(sql1);
      while (this.rs.next()) {
        AllClassId[(i++)] = this.rs.getInt(1);
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
    return AllClassId;
  }
  
  public ArrayList<ClassMajorBean> getAllClassMajorBean()
  {
    ArrayList<ClassMajorBean> AllMajor = new ArrayList();
    ClassMajorBean cmb = null;
    int i = 0;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      




      String sql1 = "select * from t_class";
      this.rs = this.sm.executeQuery(sql1);
      while (this.rs.next())
      {
        cmb = new ClassMajorBean();
        cmb.setId(this.rs.getString(1));
        cmb.setMajorname(this.rs.getString(2));
        cmb.setStuNum(String.valueOf(this.rs.getInt(3)));
        AllMajor.add(cmb);
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
    return AllMajor;
  }
  
  public String getMajorNameById(String id)
  {
    String majorName = "";
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      
      String sql = "select majorName form t_class  where id = '" + id + "'";
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next()) {
        majorName = this.rs.getString(1);
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
    return majorName;
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
}
