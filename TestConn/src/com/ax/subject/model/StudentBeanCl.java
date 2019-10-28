package com.ax.subject.model;

import com.common.controller.Md5;
import com.kk.subject.model.StuWishBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentBeanCl
{
  private Connection ct = null;
  private Statement sm = null;
  private ResultSet rs = null;
  private StudentBean tb = null;
  
  public StudentBean getStudentById(String id)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from T_Student where id='" + id + "'";
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.tb = new StudentBean();
        this.tb.setId(this.rs.getString(1));
        this.tb.setPsw(this.rs.getString(2));
        this.tb.setName(this.rs.getString(3));
        this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
        this.tb.setCls(this.rs.getString(5));
        this.tb.setMajor(this.rs.getString(6));
        this.tb.setPhoneNum(this.rs.getString(7));
        this.tb.setEmail(this.rs.getString(8));
        
        this.tb.setPrivilege(this.rs.getShort(9));
        this.tb.setSelectNum(this.rs.getShort(10));
        this.tb.setYuanxi(this.rs.getString(11));
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
  
  public  ArrayList<StudentBean> getAllStudent(String yuanxi)
  {
	ArrayList<StudentBean> AllSSTB = new ArrayList();
    try
    {
      
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from T_Student where yuanxi = '"+yuanxi+"' ";
      this.rs = this.sm.executeQuery(sql);
      while(this.rs.next())
      {
    	StudentBean tb = new StudentBean();
        tb = new StudentBean();
        
        tb.setId(this.rs.getString(1));
        tb.setPsw(this.rs.getString(2));
        tb.setName(this.rs.getString(3));
        tb.setSex(SEX.toEnum(this.rs.getString(4)));
        tb.setCls(this.rs.getString(5));
        tb.setMajor(this.rs.getString(6));
        tb.setPhoneNum(this.rs.getString(7));
        tb.setEmail(this.rs.getString(8));
        tb.setPrivilege(this.rs.getShort(9));
        tb.setSelectNum(this.rs.getShort(10));
        tb.setYuanxi(this.rs.getString(11));
        AllSSTB.add(tb);
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
    return AllSSTB;
   
  }
  
  public StudentBean getStudentByName(String Name)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      String sql = "select * from T_Student where name='" + Name + "'";
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.tb = new StudentBean();
        this.tb.setId(this.rs.getString(1));
        this.tb.setPsw(this.rs.getString(2));
        this.tb.setName(this.rs.getString(3));
        this.tb.setSex(SEX.toEnum(this.rs.getString(4)));
        this.tb.setCls(this.rs.getString(5));
        this.tb.setMajor(this.rs.getString(6));
        this.tb.setPhoneNum(this.rs.getString(7));
        this.tb.setEmail(this.rs.getString(8));
        
        this.tb.setPrivilege(this.rs.getShort(9));
        this.tb.setSelectNum(this.rs.getShort(10));
        this.tb.setYuanxi(this.rs.getString(11));
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
  
  public StudentBean getStudentById(int id)
  {
    return getStudentById(id);
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
  
  public boolean checkGraduate(String id, String gradu)
  {
    boolean b = false;
    try
    {
      int id1 = Integer.parseInt(id.substring(3, 5));
      int gradu1 = Integer.parseInt(gradu.substring(2));
      if (id1 == gradu1) {
        b = true;
      }
    }
    catch (NumberFormatException e)
    {
      return false;
    }
    return b;
  }
  
  public boolean checkUser(String id, String p)
  {
    boolean b = false;
    Md5 md5 = new Md5();
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      
      this.rs = this.sm.executeQuery("select psw from T_Student where id='" + id + "'");
      if (this.rs.next())
      {
        String str = this.rs.getString(1);
        String str1 = Md5.MD5(str);
        
        String ptr = Md5.MD5(p);
        if (str1.equals(ptr)) {
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
  
  public boolean checkEmail(String id, String p)
  {
    boolean b = false;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      
      this.rs = this.sm.executeQuery("select email from T_Student where id='" + id + "'");
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
  
  public boolean Fill_Info(String id)
  {
    boolean a = false;
    this.tb = getStudentById(id);
    if ((this.tb.getName() != null) && (!this.tb.getName().equals("")) && (this.tb.getEmail() != null) && (!this.tb.getEmail().equals("")) && (this.tb.getPhoneNum() != null) && (!this.tb.getPhoneNum().equals(""))) {
      a = true;
    }
    return a;
  }
  
  public String phoneNumberExitCheck(String id, String phoneNum)
  {
    String result = "false";
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_student where phoneNum = '" + phoneNum + "' and id<>'" + id + "' ";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        result = "true";
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
    return result;
  }
  
  public String emaliExitCheck(String id, String email)
  {
    String result = "false";
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_student where email = '" + email + "' and id<>'" + id + "'";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        result = "true";
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
    return result;
  }
}
