package com.ax.subject.model;

public enum SEX
{
  MALE("男"),  FEMALE("女");
  
  public String stringValue;
  
  private SEX(String stringValue)
  {
    this.stringValue = stringValue;
  }
  
  public static SEX toEnum(String sex)
  {
    if (sex.equals("男")) {
      return MALE;
    }
    return FEMALE;
  }
  
  public static String toStringValue(SEX sex)
  {
    return sex.stringValue;
  }
}
