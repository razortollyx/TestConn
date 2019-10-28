package com.ax.subject.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentSubjectBeanCl
{
  private Connection ct = null;
  private Statement sm = null;
  private ResultSet rs = null;
  private TeacherBean tb = null;
  
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
      closeSource();
    }
    return i;
  }
  
  public String getWish(int sub_id, String stu_id)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery("select wish from t_stu_sub where sub_id='" + 
        sub_id + "' and stu_id ='" + stu_id + "'");
      if (this.rs.next()) {
        return this.rs.getString(1);
      }
      return "NULL";
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return "NULL";
    }
    finally
    {
      closeSource();
    }
  }
  
  public int getSubIdByWish(String wish, String stu_id)
  {
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery("select sub_id from t_stu_sub where wish = '" + 
        wish + "' and stu_id = '" + stu_id + "'");
      if (this.rs.next()) {
        return this.rs.getInt(1);
      }
      return 0;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return -1;
    }
    finally
    {
      closeSource();
    }
  }
  
  public ArrayList<StudentSubjectBean> getSubAlByStuId(String stuId)
  {
    ArrayList<StudentSubjectBean> ssbAl = new ArrayList();
    StudentSubjectBean ssb = null;
    String sql = "select * from t_stu_sub where stu_Id='" + stuId + "'";
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        ssb = new StudentSubjectBean();
        ssb.setStu_id(stuId);
        ssb.setSub_id(this.rs.getInt(2));
        ssb.setWish(this.rs.getInt(3));
        ssb.setState(this.rs.getInt(4));
        ssbAl.add(ssb);
        System.out.println("111");
      }
      return ssbAl;
    }
    catch (Exception e) {}
    return null;
  }
  
  public int getSelectedAlternativeByStuId(int stuId)
  {
    int i = 0;
    String sql = "select count(*) from t_stu_sub where stu_Id='" + stuId + 
      "'and wish='" + 4 + "'";
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        i = this.rs.getInt(1);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    return i;
  }
  
  public void closeSource()
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
  
  public boolean existSubIdStuId(String subId, String stuId)
  {
    String sql = "select * from t_stu_sub where stu_id = '" + stuId + 
      "' and sub_id = '" + subId + "'";
    boolean a = false;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        a = true;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    return a;
  }
  
  public String getWishBySubIdStuId(String subId, String stuId)
  {
    int wish = -1;
    String sql = "select wish from t_stu_sub where sub_id = '" + subId + 
      "' and stu_id = '" + stuId + "'";
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        wish = this.rs.getInt(1);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    return String.valueOf(wish);
  }
  
  public int deleteByStuIdWish(String stuId, String wish)
  {
    String sql = "delete from t_stu_sub where stu_id = '" + stuId + 
      "' and wish = '" + wish + "'";
    int i = 0;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      i = this.sm.executeUpdate(sql);
      i = 1;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    return i;
  }
  
  public int selectByStuIdWish(String stuId, String wish)
  {
    String sql = "select * from t_stu_sub where stu_id = '" + stuId + "' and wish = '" + wish + "'";
    System.out.println(stuId);
    System.out.println(wish + "xxx");
    int subid = 0;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        subid = this.rs.getInt(2);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    return subid;
  }
  
  public int updateWish(String subId, String stuId, String wish)
  {
    String sql = "update t_stu_sub set wish = '" + wish + 
      "' where stu_id = '" + stuId + "' and sub_id = '" + subId + 
      "'";
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
      closeSource();
    }
    return i;
  }
  
  public boolean getExistWish(String wish, String stuId)
  {
    String sql = "select * from t_stu_sub where wish = '" + wish + 
      "' and stu_id = '" + stuId + "'";
    boolean a = false;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next()) {
        a = true;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    return a;
  }
  
  public int insertByStuIdWish1(String subId, String stuId, String wish)
  {
    int w = Integer.parseInt(wish);
    String sql = "update stuselecttitle set title1='" + subId + 
      "' where Stuid='" + stuId + "'";
    if (w == 2) {
      sql = 
        "update stuselecttitle set title2='" + subId + "' where Stuid='" + stuId + "'";
    } else if (w == 3) {
      sql = 
        "update stuselecttitle set title3='" + subId + "' where Stuid='" + stuId + "'";
    } else if (w == 4) {
      sql = 
        "update stuselecttitle set title4='" + subId + "' where Stuid='" + stuId + "'";
    } else if (w == 5) {
      sql = 
        "update stuselecttitle set title5='" + subId + "' where Stuid='" + stuId + "'";
    } else if (w == 6) {
      sql = 
        "update stuselecttitle set title6='" + subId + "' where Stuid='" + stuId + "'";
    }
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
      closeSource();
    }
    return i;
  }
  
  public StudentSubjectBean getinfoByStuid(String id)
  {
    StudentSubjectBean ssb = null;
    String sql = "select * from stuselecttitle where Stuid = '" + id + "'";
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        ssb = new StudentSubjectBean();
        ssb.setStu_id(id);
        ssb.setTitle1(this.rs.getInt(2));
        ssb.setTitle2(this.rs.getInt(3));
        ssb.setTitle3(this.rs.getInt(4));
        ssb.setTitle4(this.rs.getInt(5));
        ssb.setTitle5(this.rs.getInt(6));
        ssb.setTitle6(this.rs.getInt(7));
        return ssb;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      closeSource();
    }
    closeSource();
    
    return null;
  }
  
  public int insertByStuIdWish(String subId, String stuId, String wish, String yuanxi)
  {
    String sql = "insert into t_stu_sub (sub_Id,stu_Id,wish,yuanxi) values ('" + 
      subId + "','" + stuId + "','" + wish + "','" + yuanxi + "')";
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
      closeSource();
    }
    return i;
  }
}
