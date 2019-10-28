/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.PreparedStatement;
/*   5:    */ import java.sql.ResultSet;
/*   6:    */ import java.sql.SQLException;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ 
/*   9:    */ public class NoticeBeanCl
/*  10:    */ {
/*  11: 13 */   private Connection ct = null;
/*  12: 14 */   private PreparedStatement ps = null;
/*  13: 15 */   private ResultSet rs = null;
/*  14:    */   
/*  15:    */   public void closeSourse()
/*  16:    */   {
/*  17:    */     try
/*  18:    */     {
/*  19: 20 */       if (this.rs != null)
/*  20:    */       {
/*  21: 21 */         this.rs.close();
/*  22: 22 */         this.rs = null;
/*  23:    */       }
/*  24: 24 */       if (this.ps != null)
/*  25:    */       {
/*  26: 25 */         this.ps.close();
/*  27: 26 */         this.ps = null;
/*  28:    */       }
/*  29: 28 */       if (this.ct != null)
/*  30:    */       {
/*  31: 29 */         this.ct.close();
/*  32: 30 */         this.ct = null;
/*  33:    */       }
/*  34:    */     }
/*  35:    */     catch (SQLException e)
/*  36:    */     {
/*  37: 34 */       e.printStackTrace();
/*  38:    */     }
/*  39:    */   }
/*  40:    */   
/*  41:    */   public int insertNoticeBean(NoticeBean nb)
/*  42:    */   {
/*  43: 40 */     int nId = -1;
/*  44:    */     try
/*  45:    */     {
/*  46: 42 */       this.ct = new ConnDb().getConn();
/*  47: 43 */       String sql = "insert into t_notice (title, publisher, time, detail,yuanxi) values(?,?,?,?,?)";
/*  48: 44 */       this.ps = this.ct.prepareStatement(sql, 1);
/*  49: 45 */       this.ps.setString(1, nb.getTitle());
/*  50: 46 */       this.ps.setString(2, nb.getPublisher());
/*  51: 47 */       this.ps.setDate(3, nb.getTime());
/*  52: 48 */       this.ps.setString(4, nb.getDetail());
/*  53: 49 */       this.ps.setString(5, nb.getYuanxi());
/*  54: 50 */       this.ps.executeUpdate();
/*  55:    */       
/*  56: 52 */       this.rs = this.ps.getGeneratedKeys();
/*  57: 53 */       if (this.rs.next()) {
/*  58: 54 */         nId = this.rs.getInt(1);
/*  59:    */       }
/*  60: 57 */       if (this.rs.next()) {
/*  61: 58 */         nId = this.rs.getInt(1);
/*  62:    */       }
/*  63: 60 */       return nId;
/*  64:    */     }
/*  65:    */     catch (Exception e)
/*  66:    */     {
/*  67: 63 */       e.printStackTrace();
/*  68: 64 */       return -1;
/*  69:    */     }
/*  70:    */     finally
/*  71:    */     {
/*  72: 66 */       closeSourse();
/*  73:    */     }
/*  74:    */   }
/*  75:    */   
/*  76:    */   public NoticeBean getNoticeById(String id)
/*  77:    */   {
/*  78: 72 */     String sql = "select * from t_notice where id=?";
/*  79: 73 */     NoticeBean nb = null;
/*  80:    */     try
/*  81:    */     {
/*  82: 75 */       this.ct = new ConnDb().getConn();
/*  83: 76 */       this.ps = this.ct.prepareStatement(sql);
/*  84: 77 */       this.ps.setString(1, id);
/*  85: 78 */       this.rs = this.ps.executeQuery();
/*  86: 79 */       if (this.rs.next()) {
/*  87: 80 */         nb = new NoticeBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), this.rs.getDate(4), this.rs.getString(5));
/*  88:    */       }
/*  89: 82 */       return nb;
/*  90:    */     }
/*  91:    */     catch (Exception e)
/*  92:    */     {
/*  93: 85 */       e.printStackTrace();
/*  94: 86 */       return null;
/*  95:    */     }
/*  96:    */     finally
/*  97:    */     {
/*  98: 88 */       closeSourse();
/*  99:    */     }
/* 100:    */   }
/* 101:    */   
/* 102:    */   public ArrayList<NoticeBean> getAllNotice(String yuanxi)
/* 103:    */   {
/* 104: 95 */     ArrayList<NoticeBean> al = new ArrayList();
/* 105: 96 */     NoticeBean nb = null;
/* 106: 97 */     String sql = "select * from t_notice where yuanxi='" + yuanxi + "'";
/* 107:    */     try
/* 108:    */     {
/* 109: 99 */       this.ct = new ConnDb().getConn();
/* 110:100 */       this.ps = this.ct.prepareStatement(sql);
/* 111:101 */       this.rs = this.ps.executeQuery();
/* 112:102 */       while (this.rs.next())
/* 113:    */       {
/* 114:103 */         nb = new NoticeBean(this.rs.getInt(1), this.rs.getString(2), this.rs.getString(3), this.rs.getDate(4), this.rs.getString(5));
/* 115:104 */         al.add(nb);
/* 116:    */       }
/* 117:106 */       return al;
/* 118:    */     }
/* 119:    */     catch (Exception e)
/* 120:    */     {
/* 121:109 */       e.printStackTrace();
/* 122:110 */       return null;
/* 123:    */     }
/* 124:    */     finally
/* 125:    */     {
/* 126:112 */       closeSourse();
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   public int delMoticeById(String id)
/* 131:    */   {
/* 132:118 */     String sql = "delete from t_notice where id=?";
/* 133:119 */     int i = -1;
/* 134:    */     try
/* 135:    */     {
/* 136:121 */       this.ct = new ConnDb().getConn();
/* 137:122 */       this.ps = this.ct.prepareStatement(sql);
/* 138:123 */       this.ps.setString(1, id);
/* 139:124 */       i = this.ps.executeUpdate();
/* 140:125 */       return i;
/* 141:    */     }
/* 142:    */     catch (Exception e)
/* 143:    */     {
/* 144:    */       
/* 145:128 */       e.printStackTrace();
/* 146:129 */       return i;
/* 147:    */     }
/* 148:    */     finally
/* 149:    */     {
/* 150:131 */       closeSourse();
/* 151:    */     }
/* 152:    */   }
/* 153:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.NoticeBeanCl
 * JD-Core Version:    0.7.0.1
 */