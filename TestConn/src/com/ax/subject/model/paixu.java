package com.ax.subject.model;

import java.io.PrintStream;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class paixu
{
  public static void main(String[] args)
  {
    String[] a1 = { "保定", "何子安", "于小云", "刘帝", "刘何保定子安", "刘", "刘娜", "家强", "刘博" };
    getSortOfChinese(a1);
    for (int i = 0; i < a1.length; i++) {
      System.out.println(a1[i]);
    }
  }
  
  public static String[] getSortOfChinese(String[] a)
  {
    Comparator cmp = Collator.getInstance(Locale.CHINA);
    

    Arrays.sort(a, cmp);
    return a;
  }
}
