package com.ax.subject.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class SubjectBeanCl
{
  private Connection ct = null;
  private Statement sm = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  
  public int insertSubject(SubjectBean subBean)
  {
    int s_id = -1;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "insert into t_subject (title, teacher, direction, introduction, schedule, reference, requirement, domain, time, state, selectedNum) values(?,?,?,?,?,?,?,?,'" + 
      
        new Date(System.currentTimeMillis()) + "',?,?)";
      this.ps = this.ct.prepareStatement(sql, 1);
      this.ps.setString(1, subBean.getTitle());
      this.ps.setString(2, subBean.getTeacher());
      this.ps.setString(3, subBean.getDirection());
      this.ps.setString(4, subBean.getIntroduction());
      this.ps.setString(5, subBean.getSchedule());
      this.ps.setString(6, subBean.getReference());
      this.ps.setString(7, subBean.getRequirement());
      this.ps.setString(8, subBean.getDomain());
      this.ps.setInt(9, subBean.getState());
      this.ps.setInt(10, subBean.getSelectedNum());
      this.ps.executeUpdate();
      
      System.out.println("sql=" + sql);
      
      this.rs = this.ps.getGeneratedKeys();
      if (this.rs.next()) {
        s_id = this.rs.getInt(1);
      }
      if (this.rs.next()) {
        s_id = this.rs.getInt(1);
      }
      return s_id;
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
  
  public SubjectBean getSubjectById(int id)
  {
    SubjectBean sb = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where id='" + id + "'";
      this.ps = this.ct.prepareStatement(sql);
      this.rs = this.ps.executeQuery();
      if (this.rs.next()) {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
      }
      return sb;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
    finally
    {
      closeSource();
    }
  }
  
  public SubjectBean getSubjectById(String id)
  {
    return getSubjectById(Integer.parseInt(id));
  }
  
  public ArrayList<SubjectBean> getAllSub(String id, String yuanxi)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject as a where a.state = '1' and yuanxi='" + yuanxi + "'  and a.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "') order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
      this.ps = this.ct.prepareStatement(sql);
      this.rs = this.ps.executeQuery();
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        if (y.equals(year)) {
          al.add(sb);
        }
      }
      return al;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
    finally
    {
      closeSource();
    }
  }
  
  public ArrayList<SubjectBean> getAlternativeSub(int id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    








    SubjectBean sb = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject as a where a.state = '1' and a.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "') order by  convert(teacher USING gbk) COLLATE gbk_chinese_ci";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        al.add(sb);
      }
      return al;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return null;
    }
    finally
    {
      closeSource();
    }
  }
  
  public ArrayList<SubjectBean> getAllSubFromTeacher(String teacherName, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where teacher like '%" + teacherName + "%' and state=1 and yuanxi='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "') ";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public ArrayList<SubjectBean> getAllSubFromDirection(String direction, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where direction like '%" + direction + "%' and state=1 and yuanxi='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "')";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public ArrayList<SubjectBean> getAllSubFromTitle(String title, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where title like '%" + title + "%'and state=1 and yuanxi='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "')";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public ArrayList<SubjectBean> getAllSubFromTeaandDir(String teacherName, String direction, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where teacher like '%" + teacherName + "%' and direction like '%" + direction + "%'  and state=1 and yuanxi='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "')";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public ArrayList<SubjectBean> getAllSubFromTeaandTit(String teacherName, String title, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where teacher like '%" + teacherName + "%' and title like '%" + title + "%' and yuanxi='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "') ";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public ArrayList<SubjectBean> getAllSubFromDirandTit(String direction, String title, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where direction like '%" + direction + "%' and title like '%" + title + "%' and state=1 and yuanxi ='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "')";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public ArrayList<SubjectBean> getAllSubFromTeaandDirandTit(String teacherName, String direction, String title, String yuanxi, String id)
  {
    ArrayList<SubjectBean> al = new ArrayList();
    SubjectBean sb = null;
    Calendar date = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String year = String.valueOf(now.get(1));
    Date d = null;
    try
    {
      this.ct = new ConnDb().getConn();
      String sql = "select * from t_subject where teacher like '%" + teacherName + "%' and direction like '%" + direction + "%' and title like '%" + title + "%'  and state=1 and yuanxi='" + yuanxi + "' and t_subject.id not in (select sub_id from t_stu_sub as b where stu_id='" + id + "')";
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      while (this.rs.next())
      {
        sb = new SubjectBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), 
          this.rs.getString(4), this.rs.getString(5), this.rs.getString(6), 
          this.rs.getString(7), this.rs.getString(8), this.rs.getString(9), 
          this.rs.getDate(10), this.rs.getInt(11), this.rs.getInt(12));
        d = this.rs.getDate(10);
        if (d != null) {
          date.setTime(d);
        }
        String y = String.valueOf(date.get(1));
        System.out.println(y);
        if (y.equals(year)) {
          al.add(sb);
        }
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
    return al;
  }
  
  public int delSubjectById(String id)
  {
    int i = 0;
    try
    {
      String sql = "delete from t_subject where id='" + id + "'";
      this.ct = new ConnDb().getConn();
      this.ps = this.ct.prepareStatement(sql);
      
      i = this.ps.executeUpdate(sql);
      
      return i;
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
  
  public boolean delSubjectById(String stuId, String subId)
  {
    boolean a = false;
    try
    {
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      int i = this.sm.executeUpdate("delete from t_stu_sub where stu_id ='" + stuId + "' and sub_Id = '" + subId + "' ");
      if (i == 1) {
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
  
  public void closeSource()
  {
    try
    {
      if (this.rs != null)
      {
        this.rs.close();
        this.rs = null;
      }
      if (this.ps != null)
      {
        this.ps.close();
        this.ps = null;
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
  
  public int updateSelectedNum(String temp, int a)
  {
    String sql = "";
    if (a == 1) {
      sql = "update t_subject set selectedNum = selectedNum+1 where  id = '" + temp + "'";
    } else if (a == -1) {
      sql = "update t_subject set selectedNum = selectedNum-1 where  id = '" + temp + "'";
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
}
