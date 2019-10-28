package com.ax.subject.model;

public class SetBean
{
  private String id;
  private int warnNum;
  private int maxSelNum;
  private String graduateGrade;
  private int alternative;
  
  public int getAlternative()
  {
    return this.alternative;
  }
  
  public void setAlternative(int alternative)
  {
    this.alternative = alternative;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public int getWarnNum()
  {
    return this.warnNum;
  }
  
  public void setWarnNum(int warnNum)
  {
    this.warnNum = warnNum;
  }
  
  public int getMaxSelNum()
  {
    return this.maxSelNum;
  }
  
  public void setMaxSelNum(int maxSelNum)
  {
    this.maxSelNum = maxSelNum;
  }
  
  public String getGraduateGrade()
  {
    return this.graduateGrade;
  }
  
  public void setGraduateGrade(String graduateGrade)
  {
    this.graduateGrade = graduateGrade;
  }
}
