/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.PreparedStatement;
/*   5:    */ import java.sql.ResultSet;
/*   6:    */ import java.sql.SQLException;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ 
/*   9:    */ public class MajorBeanCl
/*  10:    */ {
/*  11:  8 */   private Connection ct = null;
/*  12:  9 */   private PreparedStatement ps = null;
/*  13: 10 */   private ResultSet rs = null;
/*  14:    */   
/*  15:    */   public void closeSourse()
/*  16:    */   {
/*  17:    */     try
/*  18:    */     {
/*  19: 15 */       if (this.rs != null)
/*  20:    */       {
/*  21: 16 */         this.rs.close();
/*  22: 17 */         this.rs = null;
/*  23:    */       }
/*  24: 19 */       if (this.ps != null)
/*  25:    */       {
/*  26: 20 */         this.ps.close();
/*  27: 21 */         this.ps = null;
/*  28:    */       }
/*  29: 23 */       if (this.ct != null)
/*  30:    */       {
/*  31: 24 */         this.ct.close();
/*  32: 25 */         this.ct = null;
/*  33:    */       }
/*  34:    */     }
/*  35:    */     catch (SQLException e)
/*  36:    */     {
/*  37: 29 */       e.printStackTrace();
/*  38:    */     }
/*  39:    */   }
/*  40:    */   
/*  41:    */   public ArrayList getAllMajor(String yuanxi)
/*  42:    */   {
/*  43: 35 */     String sql = "select * from t_major where academy='" + yuanxi + "'";
/*  44: 36 */     ArrayList<MajorBean> al = new ArrayList();
/*  45: 37 */     MajorBean mb = null;
/*  46:    */     try
/*  47:    */     {
/*  48: 41 */       this.ct = new ConnDb().getConn();
/*  49: 42 */       this.ps = this.ct.prepareStatement(sql);
/*  50: 43 */       this.rs = this.ps.executeQuery();
/*  51: 44 */       while (this.rs.next())
/*  52:    */       {
/*  53: 45 */         mb = new MajorBean(this.rs.getInt(1), this.rs.getString(2));
/*  54: 46 */         al.add(mb);
/*  55:    */       }
/*  56: 48 */       return al;
/*  57:    */     }
/*  58:    */     catch (Exception e)
/*  59:    */     {
/*  60: 51 */       e.printStackTrace();
/*  61: 52 */       return null;
/*  62:    */     }
/*  63:    */     finally
/*  64:    */     {
/*  65: 54 */       closeSourse();
/*  66:    */     }
/*  67:    */   }
/*  68:    */   
/*  69:    */   public ArrayList getAllMajor1(String yuanxi)
/*  70:    */   {
/*  71: 60 */     String sql = "select major from t_major where academy='" + yuanxi + "'";
/*  72: 61 */     ArrayList<String> al = new ArrayList();
/*  73: 62 */     String mb = null;
/*  74:    */     try
/*  75:    */     {
/*  76: 66 */       this.ct = new ConnDb().getConn();
/*  77: 67 */       this.ps = this.ct.prepareStatement(sql);
/*  78: 68 */       this.rs = this.ps.executeQuery();
/*  79: 69 */       while (this.rs.next())
/*  80:    */       {
/*  81: 70 */         mb = new String(this.rs.getString(1));
/*  82: 71 */         al.add(mb);
/*  83:    */       }
/*  84: 73 */       return al;
/*  85:    */     }
/*  86:    */     catch (Exception e)
/*  87:    */     {
/*  88: 76 */       e.printStackTrace();
/*  89: 77 */       return null;
/*  90:    */     }
/*  91:    */     finally
/*  92:    */     {
/*  93: 79 */       closeSourse();
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   public int insertMajor(String major, String yuanxi)
/*  98:    */   {
/*  99: 84 */     String sql = "insert into t_major (major,academy) values ('" + major + "','" + yuanxi + "')";
/* 100: 85 */     int i = 0;
/* 101:    */     try
/* 102:    */     {
/* 103: 87 */       this.ct = new ConnDb().getConn();
/* 104: 88 */       this.ps = this.ct.prepareStatement(sql);
/* 105: 89 */       i = this.ps.executeUpdate();
/* 106: 90 */       return i;
/* 107:    */     }
/* 108:    */     catch (Exception e)
/* 109:    */     {
/* 110: 93 */       e.printStackTrace();
/* 111: 94 */       return -1;
/* 112:    */     }
/* 113:    */     finally
/* 114:    */     {
/* 115: 96 */       closeSourse();
/* 116:    */     }
/* 117:    */   }
/* 118:    */   
/* 119:    */   public int delMajorById(String id)
/* 120:    */   {
/* 121:102 */     String sql = "delete from t_major where id='" + id + "'";
/* 122:103 */     int i = 0;
/* 123:    */     try
/* 124:    */     {
/* 125:105 */       this.ct = new ConnDb().getConn();
/* 126:106 */       this.ps = this.ct.prepareStatement(sql);
/* 127:107 */       i = this.ps.executeUpdate();
/* 128:108 */       return i;
/* 129:    */     }
/* 130:    */     catch (Exception e)
/* 131:    */     {
/* 132:111 */       e.printStackTrace();
/* 133:112 */       return -1;
/* 134:    */     }
/* 135:    */     finally
/* 136:    */     {
/* 137:114 */       closeSourse();
/* 138:    */     }
/* 139:    */   }
/* 140:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.MajorBeanCl
 * JD-Core Version:    0.7.0.1
 */