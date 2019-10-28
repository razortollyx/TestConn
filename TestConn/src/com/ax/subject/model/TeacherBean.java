package com.ax.subject.model;

public class TeacherBean
{
  private String id;
  private String psw;
  private String name;
  private SEX sex;
  private String phoneNum;
  private String email;
  private String jobTitle;
  private int maxSubNum;
  
  public TeacherBean() {}
  
  public TeacherBean(String id, String psw, String name, SEX sex, String phoneNum, String email, String jobTitle, int maxSubNum)
  {
    setId(id);
    setPsw(psw);
    setName(name);
    setSex(sex);
    setPhoneNum(phoneNum);
    setEmail(email);
    setJobTitle(jobTitle);
    setMaxSubNum(maxSubNum);
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getPsw()
  {
    return this.psw;
  }
  
  public void setPsw(String psw)
  {
    this.psw = psw;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getPhoneNum()
  {
    return this.phoneNum;
  }
  
  public void setPhoneNum(String phoneNum)
  {
    this.phoneNum = phoneNum;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getJobTitle()
  {
    return this.jobTitle;
  }
  
  public void setJobTitle(String jobTitle)
  {
    this.jobTitle = jobTitle;
  }
  
  public int getMaxSubNum()
  {
    return this.maxSubNum;
  }
  
  public void setMaxSubNum(int maxSubNum)
  {
    this.maxSubNum = maxSubNum;
  }
  
  public SEX getSex()
  {
    return this.sex;
  }
  
  public void setSex(SEX sex)
  {
    this.sex = sex;
  }
}
