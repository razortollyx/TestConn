package com.ax.subject.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SetBeanCl
{
  private Connection ct = null;
  private Statement sm = null;
  private ResultSet rs = null;
  SetBean sb = new SetBean();
  
  public SetBean getAllinfo(String yuanxi)
  {
    try
    {
      String sql = "select * from t_settings where department='" + yuanxi + "'";
      this.ct = new ConnDb().getConn();
      this.sm = this.ct.createStatement();
      this.rs = this.sm.executeQuery(sql);
      if (this.rs.next())
      {
        this.sb.setId(this.rs.getString(1));
        this.sb.setWarnNum(this.rs.getInt(2));
        this.sb.setMaxSelNum(this.rs.getInt(3));
        this.sb.setGraduateGrade(this.rs.getString(4));
        this.sb.setAlternative(this.rs.getInt(5));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return this.sb;
  }
}
