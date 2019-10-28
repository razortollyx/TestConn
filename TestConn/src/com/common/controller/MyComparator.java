package com.common.controller;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;

public class MyComparator
  implements Comparator
{
  String attiName = null;
  
  public int compare(Object obj1, Object obj2)
  {
    if (this.attiName == null) {
      return 2;
    }
    if (compareField(obj1, obj2, this.attiName) > 0) {
      return 1;
    }
    if (compareField(obj1, obj2, this.attiName) < 0) {
      return -1;
    }
    return 0;
  }
  
  private static Object getAttiValueByName(String attiName, Object obj)
  {
    try
    {
      String Letter = attiName.substring(0, 1).toUpperCase();
      String methodStr = "get" + Letter + attiName.substring(1);
      Method method = obj.getClass().getMethod(methodStr, new Class[0]);
      
      return method.invoke(obj, new Object[0]);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("------------------------------------------------------");
      System.out.println("---------该" + attiName + "属性不存在----------------------");
      System.out.println("------------------------------------------------------");
    }
    return null;
  }
  
  private static int compareField(Object obj1, Object obj2, String attiName)
  {
    try
    {
      Object value1 = getAttiValueByName(attiName, obj1);
      Object value2 = getAttiValueByName(attiName, obj2);
      if ((value1 instanceof String))
      {
        String v1 = getAttiValueByName(attiName, obj1).toString();
        String v2 = getAttiValueByName(attiName, obj2).toString();
        Collator myCollator = Collator.getInstance();
        CollationKey[] keys = new CollationKey[5];
        keys[0] = myCollator.getCollationKey(v1);
        keys[1] = myCollator.getCollationKey(v2);
        return keys[0].compareTo(keys[1]);
      }
      if (("java.lang.Boolean".equals(value1.getClass().getName())) || ("java.lang.Byte".equals(value1.getClass().getName()))) {
        return 0;
      }
      BigDecimal b1 = new BigDecimal(value1.toString());
      BigDecimal b2 = new BigDecimal(value2.toString());
      return b1.compareTo(b2);
    }
    catch (Exception e)
    {
      System.out.println("-----------------------------------------------------------------------------");
      System.out.println("---------对象的该属性不存在或者不允许在此安全级别上反射该属性，详情请查阅JAVA DOC--------");
      System.out.println("-----------------------------------------------------------------------------");
      e.printStackTrace();
    }
    return -1;
  }
  
  public String getAttiName()
  {
    return this.attiName;
  }
  
  public void setAttiName(String attiName)
  {
    this.attiName = attiName;
  }
}
