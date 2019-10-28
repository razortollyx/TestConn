package com.kk.subject.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ax.subject.model.TeacherBean;

public class StuspBeanCI {
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private StuWishBean sb = null;
	
	 public void closeSourse()
	{
	 /*  18:    */     try
	 /*  19:    */     {
	 /*  20: 17 */       if (this.rs != null)
	 /*  21:    */       {
	 /*  22: 18 */         this.rs.close();
	 /*  23: 19 */         this.rs = null;
	 /*  24:    */       }
	 /*  25: 21 */       if (this.ps != null)
	 /*  26:    */       {
	 /*  27: 22 */         this.ps.close();
	 /*  28: 23 */         this.ps = null;
	 /*  29:    */       }
	 /*  30: 25 */       if (this.ct != null)
	 /*  31:    */       {
	 /*  32: 26 */         this.ct.close();
	 /*  33: 27 */         this.ct = null;
	 /*  34:    */       }
	 /*  35:    */     }
	 /*  36:    */     catch (SQLException e)
	 /*  37:    */     {
	 /*  38: 31 */       e.printStackTrace();
	 /*  39:    */     }
	}
	
	 				 public int updateBySql(String sql)
	 /*  43:    */   {
	 /*  44: 37 */     int i = 0;
	 /*  45:    */     try
	 /*  46:    */     {
	 /*  47: 39 */       this.ct = new ConnDb().getConn();
	 /*  48: 40 */       this.ps = this.ct.prepareStatement(sql);
	 /*  49: 41 */       i = this.ps.executeUpdate();
	 /*  50: 42 */       return i;
	 /*  51:    */     }
	 /*  52:    */     catch (Exception e)
	 /*  53:    */     {
	 /*  54: 45 */       e.printStackTrace();
	 /*  55: 46 */       return -1;
	 /*  56:    */     }
	 /*  57:    */     finally
	 /*  58:    */     {
	 /*  59: 48 */       closeSourse();
	 /*  60:    */     }
	 /*  61:    */   }
	 
	 /* 249:    */   public StuspBean getStuSpById(String sub_id)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     StuspBean sstb = null;
	 /* 253:    */     try
	 /* 254:    */     {
		 				 String sql = "select * from t_tezhao where sub_id='" + sub_id + "' ";	
	 /* 255:218 */       this.ct = new ConnDb().getConn();
	 /* 256:219 */       this.ps = this.ct.prepareStatement(sql);
	 /* 257:220 */       this.rs = this.ps.executeQuery();
	 					 
	 					 sstb = new StuspBean();
	 /* 258:221 */       while (this.rs.next()) {
		 					
		 					sstb.setSub_id(this.rs.getString(1));
		 					sstb.setStu_id(this.rs.getString(2));

	          
		 					
	 /* 262:    */       }
	 /* 263:226 */        return sstb;
	 /* 264:    */     }
	 /* 265:    */     catch (Exception e)
	 /* 266:    */     {
	 /* 267:229 */       e.printStackTrace();
	 /* 268:230 */       return null;
	 /* 269:    */     }
	 /* 270:    */     finally
	 /* 271:    */     {
	 /* 272:232 */       closeSourse();
	 /* 273:    */     }
	 					
	 /* 274:    */   }
	 
	 /* 249:    */   public int setStuSubById(String sub_id,String stu_id,String yuanxi)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     int i=0;
	 /* 253:    */     try
	 /* 254:    */     {
		 				 String sql = " INSERT INTO t_stu_sub (stu_Id, sub_Id, wish, state, total, yuanxi) VALUES ('" + stu_id + "', '" + sub_id + "','1','1','2','"+yuanxi+"') ";	

		 				 System.out.print("插入成功");
	 					 this.ct = new ConnDb().getConn();
	 /* 104: 88 */       this.ps = this.ct.prepareStatement(sql);
	 /* 105: 89 */       i = this.ps.executeUpdate();
	 /* 106: 90 */       return i;
	 /* 258:221 */      
	 /* 264:    */     }
	 /* 265:    */     catch (Exception e)
	 /* 266:    */     {
	 /* 267:229 */       e.printStackTrace();
	 					 return -1;
	 /* 268:230 */     }
	 /* 270:    */     finally
	 /* 271:    */     {
	 /* 272:232 */       closeSourse();
	 /* 273:    */     }
	                   
	 					
	 /* 274:    */   }
	 
	 
	 				 public int delStuSubById(String sub_id,String stu_id)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     int i=0;
	 /* 253:    */     try
	 /* 254:    */     {
		 				 String sql = " DELETE FROM t_stu_sub WHERE sub_id='" + sub_id + "' AND stu_Id = '"+ stu_id +"'  ";	

	 
	 					 this.ct = new ConnDb().getConn();
	 /* 104: 88 */       this.ps = this.ct.prepareStatement(sql);
	 /* 105: 89 */       i = this.ps.executeUpdate();
	 /* 106: 90 */       return i;
	 /* 258:221 */      
	 /* 264:    */     }
	 /* 265:    */     catch (Exception e)
	 /* 266:    */     {
	 /* 267:229 */       e.printStackTrace();
	 					 return -1;
	 /* 268:230 */     }
	 /* 270:    */     finally
	 /* 271:    */     {
	 /* 272:232 */       closeSourse();
	 /* 273:    */     }
	                   
	 					
	 /* 274:    */   }	 
	 
	 
	 
	 
	 
	 				public int setStuSpById(String sub_id,String stu_id,String yuanxi)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     int i=0;
	 /* 253:    */     try
	 /* 254:    */     {	
		 				 String sql = "INSERT INTO t_tezhao (sub_id, stu_id, yuanxi) VALUES ('" + sub_id + "', '" + stu_id + "', '" + yuanxi + "') ";	

	 
	 					 this.ct = new ConnDb().getConn();
	 /* 104: 88 */       this.ps = this.ct.prepareStatement(sql);
	 /* 105: 89 */       i = this.ps.executeUpdate();
	 /* 106: 90 */       return i;
	 /* 258:221 */      
	 /* 264:    */     }
	 /* 265:    */     catch (Exception e)
	 /* 266:    */     {
	 /* 267:229 */       e.printStackTrace();
	 					 return -1;
	 /* 268:230 */     }
	 /* 270:    */     finally
	 /* 271:    */     {
	 /* 272:232 */       closeSourse();
	 /* 273:    */     }
	                   
	 					
	 /* 274:    */   }
	 					public int delStuSpById(String sub_id)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     int i=0;
	 /* 253:    */     try
	 /* 254:    */     {
		 				 String sql = " DELETE FROM t_tezhao WHERE sub_id='" + sub_id + "' ";	

	 
	 					 this.ct = new ConnDb().getConn();
	 /* 104: 88 */       this.ps = this.ct.prepareStatement(sql);
	 /* 105: 89 */       i = this.ps.executeUpdate();
	 /* 106: 90 */       return i;
	 /* 258:221 */      
	 /* 264:    */     }
	 /* 265:    */     catch (Exception e)
	 /* 266:    */     {
	 /* 267:229 */       e.printStackTrace();
	 					 return -1;
	 /* 268:230 */     }
	 /* 270:    */     finally
	 /* 271:    */     {
	 /* 272:232 */       closeSourse();
	 /* 273:    */     }
	                   
	 					
	 /* 274:    */   }	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 					public int getSubWishById(String sub_id)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     
	 /* 253:    */     try
	 /* 254:    */     {
		 				 StuWishBean sstb = new StuWishBean();
		 				 sstb = new StuWishBean();
		 				 String sql = "select count(*) from t_stu_sub where sub_Id='" + sub_id + "' ";	
	 /* 255:218 */       this.ct = new ConnDb().getConn();
	 /* 256:219 */       this.ps = this.ct.prepareStatement(sql);
	 /* 257:220 */       this.rs = this.ps.executeQuery();
	 /* 258:221 */       while (this.rs.next()) {
		 					
		 					
		 					sstb.setsub_Num(this.rs.getString(4));
		 					
		 				    
	 /* 259:222 */           
		 					
	 /* 262:    */       }
	 /* 263:226 */        return Integer.parseInt(sstb.getsub_Num());
	 /* 264:    */     }
	 /* 265:    */     catch (Exception e)
	 /* 266:    */     {
	 /* 267:229 */       e.printStackTrace();
	 /* 268:230 */       return 0;
	 /* 269:    */     }
	 /* 270:    */     finally
	 /* 271:    */     {
	 /* 272:232 */       closeSourse();
	 /* 273:    */     }
	 					
	 /* 274:    */   }	 
}
