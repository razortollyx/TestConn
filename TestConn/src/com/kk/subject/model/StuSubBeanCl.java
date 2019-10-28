/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.sql.Connection;
/*   5:    */ import java.sql.PreparedStatement;
/*   6:    */ import java.sql.ResultSet;
/*   7:    */ import java.sql.SQLException;
import java.util.ArrayList;

import com.ax.subject.model.ConnDb;
/*   9:    */ 
/*  10:    */ public class StuSubBeanCl
/*  11:    */ {
/*  12:    */   private Connection ct;
/*  13:    */   private PreparedStatement ps;
/*  14:    */   private ResultSet rs;
/*  15:    */   
/*  16:    */   public ArrayList<StuSubBean> getAllSSB(String yuanxi)
/*  17:    */   {
/*  18: 17 */     ArrayList<StuSubBean> AllSSB = new ArrayList();
/*  19: 18 */     StuSubBean ssb = null;
/*  20: 19 */     String sql = "select * from t_stu_sub where yuanxi='" + yuanxi + "'";
/*  21:    */     try
/*  22:    */     {
/*  23: 21 */       this.ct = new ConnDb().getConn();
/*  24: 22 */       this.ps = this.ct.prepareStatement(sql);
/*  25: 23 */       this.rs = this.ps.executeQuery();
/*  26: 25 */       while (this.rs.next())
/*  27:    */       {
/*  28: 26 */         ssb = new StuSubBean(this.rs.getString(1), this.rs.getInt(2), this.rs.getInt(3), this.rs.getInt(4));
/*  29: 27 */         AllSSB.add(ssb);
/*  30:    */       }
/*  31: 29 */       return AllSSB;
/*  32:    */     }
/*  33:    */     catch (Exception e)
/*  34:    */     {
/*  35: 32 */       e.printStackTrace();
/*  36: 33 */       return null;
/*  37:    */     }
/*  38:    */     finally
/*  39:    */     {
/*  40: 35 */       closeSourse();
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   public ArrayList<StuSubBean> getAllSSBbystuid(String yuanxi, String stuid)
/*  45:    */   {
/*  46: 40 */     ArrayList<StuSubBean> AllSSB = new ArrayList();
/*  47: 41 */     StuSubBean ssb = null;
/*  48: 42 */     String sql = "select * from t_stu_sub where yuanxi='" + yuanxi + "' and stu_id='" + stuid + "'";
/*  49:    */     try
/*  50:    */     {
/*  51: 44 */       this.ct = new ConnDb().getConn();
/*  52: 45 */       this.ps = this.ct.prepareStatement(sql);
/*  53: 46 */       this.rs = this.ps.executeQuery();
/*  54: 48 */       while (this.rs.next())
/*  55:    */       {
/*  56: 49 */         ssb = new StuSubBean(this.rs.getString(1), this.rs.getInt(2), this.rs.getInt(3), this.rs.getInt(4));
/*  57: 50 */         AllSSB.add(ssb);
/*  58:    */       }
/*  59: 52 */       return AllSSB;
/*  60:    */     }
/*  61:    */     catch (Exception e)
/*  62:    */     {
/*  63: 55 */       e.printStackTrace();
/*  64: 56 */       return null;
/*  65:    */     }
/*  66:    */     finally
/*  67:    */     {
/*  68: 58 */       closeSourse();
/*  69:    */     }
/*  70:    */   }
/*  71:    */   
/*  72:    */   public int assignByStuIdSubId(String stuId, String subId, String yuanxi)
/*  73:    */   {
/*  74: 68 */     int i = 0;
/*  75:    */     
/*  76: 70 */     String sql = "insert into t_stu_sub (stu_Id,sub_Id,finally,yuanxi) values (?,?,?,?)";
/*  77:    */     try
/*  78:    */     {
/*  79: 72 */       System.out.println(yuanxi + "XXXXX");
/*  80: 73 */       this.ct = new ConnDb().getConn();
/*  81: 74 */       this.ps = this.ct.prepareStatement(sql);
/*  82: 75 */       this.ps.setString(1, stuId);
/*  83: 76 */       this.ps.setString(2, subId);
/*  84: 77 */       this.ps.setInt(3, 1);
/*  85: 78 */       this.ps.setString(4, yuanxi);
/*  86:    */       
/*  87:    */ 
/*  88: 81 */       i = this.ps.executeUpdate();
/*  89:    */     }
/*  90:    */     catch (Exception e)
/*  91:    */     {
/*  92: 84 */       e.printStackTrace();
/*  93: 85 */       i = -1;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 87 */       closeSourse();
/*  98:    */     }
/*  99: 89 */     return i;
/* 100:    */   }

/*  72:    */   public int assignByStuIdSubId1(String stuId, String subId, String yuanxi)
/*  73:    */   {
/*  74: 68 */     int i = 0;
/*  75:    */     
/*  76: 70 */     String sql = "UPDATE t_stu_sub SET finally='1' WHERE sub_Id ='"+subId+"' AND stu_Id = '"+stuId+"' AND yuanxi='"+yuanxi+"'";
/*  77:    */     try
/*  78:    */     {
/*  79: 72 */       System.out.println(yuanxi + "XXXXX");
/*  80: 73 */       this.ct = new ConnDb().getConn();
/*  81: 74 */       this.ps = this.ct.prepareStatement(sql);

/*  88: 81 */       i = this.ps.executeUpdate();
/*  89:    */     }
/*  90:    */     catch (Exception e)
/*  91:    */     {
/*  92: 84 */       e.printStackTrace();
/*  93: 85 */       i = -1;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 87 */       closeSourse();
/*  98:    */     }
/*  99: 89 */     return i;
/* 100:    */   }

/* 101:    */   
/* 102:    */   public void closeSourse()
/* 103:    */   {
/* 104:    */     try
/* 105:    */     {
/* 106: 95 */       if (this.rs != null)
/* 107:    */       {
/* 108: 96 */         this.rs.close();
/* 109: 97 */         this.rs = null;
/* 110:    */       }
/* 111: 99 */       if (this.ps != null)
/* 112:    */       {
/* 113:100 */         this.ps.close();
/* 114:101 */         this.ps = null;
/* 115:    */       }
/* 116:103 */       if (this.ct != null)
/* 117:    */       {
/* 118:104 */         this.ct.close();
/* 119:105 */         this.ct = null;
/* 120:    */       }
/* 121:    */     }
/* 122:    */     catch (SQLException e)
/* 123:    */     {
/* 124:109 */       e.printStackTrace();
/* 125:    */     }
/* 126:    */   }
/* 127:    */   
/* 128:    */   public int repealAssign(String stuId, String subId)
/* 129:    */   {
/* 130:122 */     int i = 0;
/* 131:123 */     String sql = "delete from t_stu_sub where stu_id=? and sub_id=?";
/* 132:    */     try
/* 133:    */     {
/* 134:125 */       this.ct = new ConnDb().getConn();
/* 135:126 */       this.ps = this.ct.prepareStatement(sql);
/* 136:127 */       this.ps.setString(1, stuId);
/* 137:128 */       this.ps.setString(2, subId);
/* 138:129 */       i = this.ps.executeUpdate();
/* 139:    */     }
/* 140:    */     catch (Exception e)
/* 141:    */     {
/* 142:132 */       e.printStackTrace();
/* 143:133 */       return -1;
/* 144:    */     }
/* 145:    */     finally
/* 146:    */     {
/* 147:135 */       closeSourse();
/* 148:    */     }
/* 149:137 */     return i;
/* 150:    */   }
/* 151:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StuSubBeanCl
 * JD-Core Version:    0.7.0.1
 */