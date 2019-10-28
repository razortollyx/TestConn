/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.sql.Connection;
/*   5:    */ import java.sql.PreparedStatement;
/*   6:    */ import java.sql.ResultSet;
/*   7:    */ import java.sql.SQLException;
/*   8:    */ 
/*   9:    */ public class JobTitleBeanCl
/*  10:    */ {
/*  11: 10 */   private Connection ct = null;
/*  12: 11 */   private PreparedStatement ps = null;
/*  13: 12 */   private ResultSet rs = null;
/*  14:    */   
/*  15:    */   public void closeSourse()
/*  16:    */   {
/*  17:    */     try
/*  18:    */     {
/*  19: 17 */       if (this.rs != null)
/*  20:    */       {
/*  21: 18 */         this.rs.close();
/*  22: 19 */         this.rs = null;
/*  23:    */       }
/*  24: 21 */       if (this.ps != null)
/*  25:    */       {
/*  26: 22 */         this.ps.close();
/*  27: 23 */         this.ps = null;
/*  28:    */       }
/*  29: 25 */       if (this.ct != null)
/*  30:    */       {
/*  31: 26 */         this.ct.close();
/*  32: 27 */         this.ct = null;
/*  33:    */       }
/*  34:    */     }
/*  35:    */     catch (SQLException e)
/*  36:    */     {
/*  37: 31 */       e.printStackTrace();
/*  38:    */     }
/*  39:    */   }
/*  40:    */   
/*  41:    */   public int getJTid(String yuanxi, String jobtitle)
/*  42:    */   {
/*  43: 36 */     int k = 0;
/*  44: 37 */     String sql = "select id from t_JobTitle where department='" + yuanxi + "' and jobTitle='" + jobtitle + "'";
/*  45:    */     try
/*  46:    */     {
/*  47: 39 */       this.ct = new ConnDb().getConn();
/*  48: 40 */       this.ps = this.ct.prepareStatement(sql);
/*  49: 41 */       this.rs = this.ps.executeQuery();
/*  50: 42 */       if (this.rs.next()) {
/*  51: 43 */         k = this.rs.getInt(1);
/*  52:    */       }
/*  53: 45 */       return k;
/*  54:    */     }
/*  55:    */     catch (Exception e)
/*  56:    */     {
/*  57:    */       int i;
/*  58: 47 */       e.printStackTrace();
/*  59: 48 */       return k;
/*  60:    */     }
/*  61:    */     finally
/*  62:    */     {
/*  63: 50 */       closeSourse();
/*  64:    */     }
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String[] getAllJT(String yuanxi)
/*  68:    */   {
/*  69: 58 */     String sql = "select count(*) from t_JobTitle where department='" + yuanxi + "'";
/*  70: 59 */     String[] jtArr = null;
/*  71: 60 */     ClsBean cb = null;
/*  72:    */     try
/*  73:    */     {
/*  74: 63 */       this.ct = new ConnDb().getConn();
/*  75: 64 */       this.ps = this.ct.prepareStatement(sql);
/*  76: 65 */       this.rs = this.ps.executeQuery();
/*  77: 66 */       if (this.rs.next())
/*  78:    */       {
/*  79: 67 */         jtArr = new String[this.rs.getInt(1)];
/*  80:    */         
/*  81: 69 */         sql = "select * from t_JobTitle  where department='" + yuanxi + "'";
/*  82: 70 */         this.ps = this.ct.prepareStatement(sql);
/*  83: 71 */         this.rs = this.ps.executeQuery();
/*  84: 72 */         for (int i = 0; (i < jtArr.length) && (this.rs.next()); i++) {
/*  85: 73 */           jtArr[i] = this.rs.getString(1);
/*  86:    */         }
/*  87:    */       }
/*  88: 76 */       return jtArr;
/*  89:    */     }
/*  90:    */     catch (Exception e)
/*  91:    */     {
/*  92: 79 */       e.printStackTrace();
/*  93: 80 */       return null;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 82 */       closeSourse();
/*  98:    */     }
/*  99:    */   }
/* 100:    */   
/* 101:    */   public int delJt(String jobTitle)
/* 102:    */   {
/* 103: 88 */     System.out.println(jobTitle);
/* 104: 89 */     String sql = "delete from t_JobTitle where id='" + jobTitle + "'";
/* 105: 90 */     int i = -1;
/* 106:    */     try
/* 107:    */     {
/* 108: 92 */       this.ct = new ConnDb().getConn();
/* 109: 93 */       this.ps = this.ct.prepareStatement(sql);
/* 110: 94 */       i = this.ps.executeUpdate();
/* 111:    */       
/* 112: 96 */       return i;
/* 113:    */     }
/* 114:    */     catch (Exception e)
/* 115:    */     {
/* 116:    */       
/* 117: 99 */       e.printStackTrace();
/* 118:100 */       return i;
/* 119:    */     }
/* 120:    */     finally
/* 121:    */     {
/* 122:102 */       closeSourse();
/* 123:    */     }
/* 124:    */   }
/* 125:    */   
/* 126:    */   public boolean jtExist(String jobTitle, String yuanxi)
/* 127:    */   {
/* 128:108 */     String[] jtArr = getAllJT(yuanxi);
/* 129:110 */     for (int i = 0; i < jtArr.length; i++) {
/* 130:111 */       if (jobTitle.equals(jtArr[i])) {
/* 131:111 */         return true;
/* 132:    */       }
/* 133:    */     }
/* 134:113 */     return false;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public int insertJt(String jobTitle, String yuanxi)
/* 138:    */   {
/* 139:118 */     String sql = "insert into t_JobTitle (jobTitle,department) values (?,?)";
/* 140:119 */     int i = -1;
/* 141:    */     try
/* 142:    */     {
/* 143:121 */       this.ct = new ConnDb().getConn();
/* 144:122 */       this.ps = this.ct.prepareStatement(sql);
/* 145:123 */       this.ps.setString(1, jobTitle);
/* 146:124 */       this.ps.setString(2, yuanxi);
/* 147:125 */       i = this.ps.executeUpdate();
/* 148:    */       
/* 149:127 */       return i;
/* 150:    */     }
/* 151:    */     catch (Exception e)
/* 152:    */     {
/* 153:    */       
/* 154:130 */       e.printStackTrace();
/* 155:131 */       return i;
/* 156:    */     }
/* 157:    */     finally
/* 158:    */     {
/* 159:133 */       closeSourse();
/* 160:    */     }
/* 161:    */   }
/* 162:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.JobTitleBeanCl
 * JD-Core Version:    0.7.0.1
 */