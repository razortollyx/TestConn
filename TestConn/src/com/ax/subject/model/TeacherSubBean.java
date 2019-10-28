package com.ax.subject.model;

public class TeacherSubBean
{
  private String t_id;
  private int s_id;
  
  public TeacherSubBean(String t_id, int s_id)
  {
    setS_id(s_id);
    setT_id(t_id);
  }
  
  public String getT_id()
  {
    return this.t_id;
  }
  
  public void setT_id(String t_id)
  {
    this.t_id = t_id;
  }
  
  public int getS_id()
  {
    return this.s_id;
  }
  
  public void setS_id(int s_id)
  {
    this.s_id = s_id;
  }
}
