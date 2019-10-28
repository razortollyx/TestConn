package com.kk.subject.model;

import java.io.Serializable;

public class StuWishBean implements Serializable
/*   7:    */ {
	/*   8:    */   private String stu_id;
	/*  12:    */   private String sub_id;
	/*  13:    */   private String WishNum;
					private String sub_Num;
	/*  14:    */   
				public StuWishBean(){}
				
				public StuWishBean(String sub_id){
					    setSub_id(sub_id);
				}
				
				public StuWishBean(String stu_id,String sub_id,String WishNum){
						setStu_id(stu_id);
					    setSub_id(sub_id);
					    setWishNum(WishNum);
				}
				
				public String getStu_id()
				{
				     return this.stu_id;
				}
				
				public void setStu_id(String stu_id)
				{
				    this.stu_id = stu_id;
				}
				
				public String getSub_id()
				{
				     return this.sub_id;
				}
				
				public void setSub_id(String sub_id)
				{
				    this.sub_id = sub_id;
				}
				public String getWishNum()
				{
				     return this.WishNum;
				}
				
				public void setWishNum(String WishNum)
				{
				    this.WishNum = WishNum;
				}
				
				public String getsub_Num()
				{
				     return this.sub_Num;
				}
				
				public void setsub_Num(String sub_Num)
				{
				    this.sub_Num = sub_Num;
				}
				

}
