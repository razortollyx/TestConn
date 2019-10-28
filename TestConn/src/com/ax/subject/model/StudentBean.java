package com.ax.subject.model;

public class StudentBean
{
  private String id;
  private String psw;
  private String name;
  private SEX sex;
  private String cls;
  private String major;
  private String phoneNum;
  private String email;
  private int privilege;
  private int selectNum;
  private String yuanxi;
  
  public StudentBean() {}
  
  public StudentBean(String id, String psw, String name, SEX sex, String cls, String major, String phoneNum, String email, int privilege, int selectNum)
  {
    setId(id);
    setPsw(psw);
    setName(name);
    setSex(sex);
    setCls(cls);
    setMajor(major);
    setPhoneNum(phoneNum);
    setEmail(email);
    
    setPrivilege(privilege);
    setSelectNum(selectNum);
  }
  
  public StudentBean(String id, String psw, String name, SEX sex, String cls, String major, String phoneNum, String email, int privilege, int selectNum, String yuanxi)
  {
    setId(id);
    setPsw(psw);
    setName(name);
    setSex(sex);
    setCls(cls);
    setMajor(major);
    setPhoneNum(phoneNum);
    setEmail(email);
    
    setPrivilege(privilege);
    setSelectNum(selectNum);
    setYuanxi(yuanxi);
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
  
  public SEX getSex()
  {
    return this.sex;
  }
  
  public void setSex(SEX sex)
  {
    this.sex = sex;
  }
  
  public String getCls()
  {
    return this.cls;
  }
  
  public void setCls(String cls)
  {
    this.cls = cls;
  }
  
  public String getMajor()
  {
    return this.major;
  }
  
  public void setMajor(String major)
  {
    this.major = major;
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
  
  public int getPrivilege()
  {
    return this.privilege;
  }
  
  public void setPrivilege(int privilege)
  {
    this.privilege = privilege;
  }
  
  public int getSelectNum()
  {
    return this.selectNum;
  }
  
  public void setSelectNum(int selectNum)
  {
    this.selectNum = selectNum;
  }
  
  public String getYuanxi()
  {
    return this.yuanxi;
  }
  
  public void setYuanxi(String yuanxi)
  {
    this.yuanxi = yuanxi;
  }
}
