package com.kk.subject.model;

import java.io.Serializable;

public class StuspBean implements Serializable
/*   7:    */ {
	/*   8:    */   private String stu_id;
	/*  12:    */   private String sub_id;
	/*  13:    */   
	/*  14:    */   
				public StuspBean(){}
				
				public StuspBean(String sub_id){
					    setSub_id(sub_id);
				}
				
				public StuspBean(String stu_id,String sub_id){
						setStu_id(stu_id);
					    setSub_id(sub_id);
					    
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
				
				

}
