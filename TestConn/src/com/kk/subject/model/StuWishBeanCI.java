package com.kk.subject.model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ax.subject.model.TeacherBean;

public class StuWishBeanCI {
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
	 
	 /* 249:    */   public ArrayList<StuWishBean> getStuWishById(String sub_id)
	 /* 250:    */   {
	 /* 251:215 */     
	 /* 252:216 */     ArrayList<StuWishBean> AllSSTB = new ArrayList();
	 /* 253:    */     try
	 /* 254:    */     {
		 				 String sql = "select * from t_stu_sub where sub_Id='" + sub_id + "' ";	
	 /* 255:218 */       this.ct = new ConnDb().getConn();
	 /* 256:219 */       this.ps = this.ct.prepareStatement(sql);
	 /* 257:220 */       this.rs = this.ps.executeQuery();
	 /* 258:221 */       while (this.rs.next()) {
		 					StuWishBean sstb = new StuWishBean();
		                    sstb = new StuWishBean();
		 					sstb.setStu_id(this.rs.getString(1));
		 					sstb.setSub_id(this.rs.getString(2));
		 					sstb.setWishNum(this.rs.getString(3));
		 					
		 				    
	 /* 259:222 */           
		 					AllSSTB.add(sstb);
	 /* 262:    */       }
	 /* 263:226 */        return AllSSTB;
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
