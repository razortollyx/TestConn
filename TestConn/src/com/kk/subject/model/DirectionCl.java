/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.sql.Connection;
/*  5:   */ import java.sql.PreparedStatement;
/*  6:   */ import java.sql.ResultSet;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.ArrayList;
/*  9:   */ 
/* 10:   */ public class DirectionCl
/* 11:   */ {
/* 12: 8 */   private Connection ct = null;
/* 13: 9 */   private PreparedStatement ps = null;
/* 14:10 */   private ResultSet rs = null;
/* 15:   */   
/* 16:   */   public ArrayList getAllDirec(String yuanxi)
/* 17:   */   {
/* 18:14 */     System.out.println("getAllDirec院系："+yuanxi);
/* 19:15 */     String sql = "select * from t_direction where department='" + yuanxi + "' ";
/* 20:16 */     ArrayList<Direction> al = new ArrayList();
/* 21:17 */     Direction d = null;
/* 22:   */     try
/* 23:   */     {
/* 24:21 */       this.ct = new ConnDb().getConn();
/* 25:22 */       this.ps = this.ct.prepareStatement(sql);
/* 26:23 */       this.rs = this.ps.executeQuery();
/* 27:24 */       while (this.rs.next())
/* 28:   */       {
/* 29:25 */         d = new Direction(this.rs.getInt(1), this.rs.getString(2));
/* 30:26 */         al.add(d);
/* 31:   */       }
/* 32:28 */       return al;
/* 33:   */     }
/* 34:   */     catch (Exception e)
/* 35:   */     {
/* 36:31 */       e.printStackTrace();
/* 37:32 */       return null;
/* 38:   */     }
/* 39:   */     finally
/* 40:   */     {
/* 41:34 */       closeSourse();
/* 42:   */     }
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void closeSourse()
/* 46:   */   {
/* 47:   */     try
/* 48:   */     {
/* 49:41 */       if (this.rs != null)
/* 50:   */       {
/* 51:42 */         this.rs.close();
/* 52:43 */         this.rs = null;
/* 53:   */       }
/* 54:45 */       if (this.ps != null)
/* 55:   */       {
/* 56:46 */         this.ps.close();
/* 57:47 */         this.ps = null;
/* 58:   */       }
/* 59:49 */       if (this.ct != null)
/* 60:   */       {
/* 61:50 */         this.ct.close();
/* 62:51 */         this.ct = null;
/* 63:   */       }
/* 64:   */     }
/* 65:   */     catch (SQLException e)
/* 66:   */     {
/* 67:55 */       e.printStackTrace();
/* 68:   */     }
/* 69:   */   }
/* 70:   */   
/* 71:   */   public int delById(int id)
/* 72:   */   {
/* 73:62 */     String sql = "delete from t_direction where id='" + id + "'";
/* 74:63 */     int i = 0;
/* 75:   */     try
/* 76:   */     {
/* 77:65 */       this.ct = new ConnDb().getConn();
/* 78:66 */       this.ps = this.ct.prepareStatement(sql);
/* 79:67 */       i = this.ps.executeUpdate();
/* 80:68 */       return i;
/* 81:   */     }
/* 82:   */     catch (Exception e)
/* 83:   */     {
/* 84:71 */       e.printStackTrace();
/* 85:72 */       return -1;
/* 86:   */     }
/* 87:   */     finally
/* 88:   */     {
/* 89:74 */       closeSourse();
/* 90:   */     }
/* 91:   */   }
/* 92:   */   
/* 93:   */   public int insertDirec(String direction, String yuanxi)
/* 94:   */   {
/* 95:81 */     String sql = "insert into t_direction (direction,department) values (?,?)";
/* 96:82 */     int i = 0;
/* 97:   */     try
/* 98:   */     {
/* 99:84 */       this.ct = new ConnDb().getConn();
/* :0:85 */       this.ps = this.ct.prepareStatement(sql);
/* :1:86 */       this.ps.setString(1, direction);
/* :2:87 */       this.ps.setString(2, yuanxi);
/* :3:88 */       i = this.ps.executeUpdate();
/* :4:89 */       return i;
/* :5:   */     }
/* :6:   */     catch (Exception e)
/* :7:   */     {
/* :8:92 */       e.printStackTrace();
/* :9:93 */       return -1;
/* ;0:   */     }
/* ;1:   */     finally
/* ;2:   */     {
/* ;3:95 */       closeSourse();
/* ;4:   */     }
/* ;5:   */   }
/* ;6:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.DirectionCl
 * JD-Core Version:    0.7.0.1
 */