package com.ax.subject.model;

import java.sql.Date;

public class SubjectBean
{
  private int id;
  private String title;
  private String teacher;
  private String direction;
  private String introduction;
  private String schedule;
  private String reference;
  private String requirement;
  private String domain;
  private Date time;
  private int state;
  private int selectedNum;
  
  public SubjectBean() {}
  
  public SubjectBean(int id, String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, Date time, int state, int selectedNum)
  {
    setId(id);
    setTitle(title);
    setTeacher(teacher);
    setDirection(direction);
    setIntroduction(introduction);
    setSchedule(schedule);
    setReference(reference);
    setRequirement(requirement);
    setDomain(domain);
    setTime(time);
    setState(state);
    setSelectedNum(selectedNum);
  }
  
  public SubjectBean(String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, Date time, int state, int selectedNum)
  {
    setTitle(title);
    setTeacher(teacher);
    setDirection(direction);
    setIntroduction(introduction);
    setSchedule(schedule);
    setReference(reference);
    setRequirement(requirement);
    setDomain(domain);
    setTime(time);
    setState(state);
    setSelectedNum(selectedNum);
  }
  
  public SubjectBean(String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, int state, int selectedNum)
  {
    setId(this.id);
    setTitle(title);
    setTeacher(teacher);
    setDirection(direction);
    setIntroduction(introduction);
    setSchedule(schedule);
    setReference(reference);
    setRequirement(requirement);
    setDomain(domain);
    setTime(this.time);
    setState(state);
    setSelectedNum(selectedNum);
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getTeacher()
  {
    return this.teacher;
  }
  
  public void setTeacher(String teacher)
  {
    this.teacher = teacher;
  }
  
  public String getDirection()
  {
    return this.direction;
  }
  
  public void setDirection(String direction)
  {
    this.direction = direction;
  }
  
  public String getIntroduction()
  {
    return this.introduction;
  }
  
  public void setIntroduction(String introduction)
  {
    this.introduction = introduction;
  }
  
  public String getSchedule()
  {
    return this.schedule;
  }
  
  public void setSchedule(String schedule)
  {
    this.schedule = schedule;
  }
  
  public String getReference()
  {
    return this.reference;
  }
  
  public void setReference(String reference)
  {
    this.reference = reference;
  }
  
  public String getRequirement()
  {
    return this.requirement;
  }
  
  public void setRequirement(String requirement)
  {
    this.requirement = requirement;
  }
  
  public String getDomain()
  {
    return this.domain;
  }
  
  public void setDomain(String domain)
  {
    this.domain = domain;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setState(int state)
  {
    this.state = state;
  }
  
  public int getSelectedNum()
  {
    return this.selectedNum;
  }
  
  public void setSelectedNum(int selectedNum)
  {
    this.selectedNum = selectedNum;
  }
  
  public Date getTime()
  {
    return this.time;
  }
  
  public void setTime(Date time)
  {
    this.time = time;
  }
}
