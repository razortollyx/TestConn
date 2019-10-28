/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.PreparedStatement;
/*   5:    */ import java.sql.ResultSet;
/*   6:    */ import java.sql.SQLException;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ 
/*   9:    */ public class DepartmentCl
/*  10:    */ {
/*  11: 11 */   private Connection ct = null;
/*  12: 12 */   private PreparedStatement ps = null;
/*  13: 13 */   private ResultSet rs = null;
/*  14:    */   
/*  15:    */   public ArrayList<Department> getAllDep(String yuanxi)
/*  16:    */   {
/*  17: 17 */     String sql = "select * from t_department where yuanxi= '" + yuanxi + "'";
/*  18: 18 */     ArrayList<Department> al = new ArrayList();
/*  19: 19 */     Department d = null;
/*  20:    */     try
/*  21:    */     {
/*  22: 21 */       this.ct = new ConnDb().getConn();
/*  23: 22 */       this.ps = this.ct.prepareStatement(sql);
/*  24: 23 */       this.rs = this.ps.executeQuery();
/*  25: 24 */       while (this.rs.next())
/*  26:    */       {
/*  27: 25 */         d = new Department(this.rs.getInt(1), this.rs.getString(2));
/*  28: 26 */         al.add(d);
/*  29:    */       }
/*  30: 28 */       return al;
/*  31:    */     }
/*  32:    */     catch (Exception e)
/*  33:    */     {
/*  34: 31 */       e.printStackTrace();
/*  35: 32 */       return null;
/*  36:    */     }
/*  37:    */     finally
/*  38:    */     {
/*  39: 34 */       closeSourse();
/*  40:    */     }
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void closeSourse()
/*  44:    */   {
/*  45:    */     try
/*  46:    */     {
/*  47: 41 */       if (this.rs != null)
/*  48:    */       {
/*  49: 42 */         this.rs.close();
/*  50: 43 */         this.rs = null;
/*  51:    */       }
/*  52: 45 */       if (this.ps != null)
/*  53:    */       {
/*  54: 46 */         this.ps.close();
/*  55: 47 */         this.ps = null;
/*  56:    */       }
/*  57: 49 */       if (this.ct != null)
/*  58:    */       {
/*  59: 50 */         this.ct.close();
/*  60: 51 */         this.ct = null;
/*  61:    */       }
/*  62:    */     }
/*  63:    */     catch (SQLException e)
/*  64:    */     {
/*  65: 55 */       e.printStackTrace();
/*  66:    */     }
/*  67:    */   }
/*  68:    */   
/*  69:    */   public ArrayList<String> getAllDepartments()
/*  70:    */   {
/*  71: 60 */     String sql = "select  department from t_department";
/*  72:    */     
/*  73: 62 */     ArrayList<String> deptNameArr = new ArrayList();
/*  74:    */     try
/*  75:    */     {
/*  76: 64 */       this.ct = new ConnDb().getConn();
/*  77: 65 */       this.ps = this.ct.prepareStatement(sql);
/*  78: 66 */       this.rs = this.ps.executeQuery();
/*  79: 67 */       while (this.rs.next())
/*  80:    */       {
/*  81: 68 */         String deptName = new String(this.rs.getString(1));
/*  82: 69 */         deptNameArr.add(deptName);
/*  83:    */       }
/*  84: 71 */       return deptNameArr;
/*  85:    */     }
/*  86:    */     catch (Exception e)
/*  87:    */     {
/*  88: 74 */       e.printStackTrace();
/*  89: 75 */       return null;
/*  90:    */     }
/*  91:    */     finally
/*  92:    */     {
/*  93: 77 */       closeSourse();
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  69:    */   public ArrayList<String> getAllDepartmentsByYuanxi(String yuanxi)
/*  70:    */   {
/*  71: 60 */     String sql = "select  department from t_department where yuanxi = '"+yuanxi+"' ";
/*  72:    */     
/*  73: 62 */     ArrayList<String> deptNameArr = new ArrayList();
/*  74:    */     try
/*  75:    */     {
/*  76: 64 */       this.ct = new ConnDb().getConn();
/*  77: 65 */       this.ps = this.ct.prepareStatement(sql);
/*  78: 66 */       this.rs = this.ps.executeQuery();
/*  79: 67 */       while (this.rs.next())
/*  80:    */       {
/*  81: 68 */         String deptName = new String(this.rs.getString(1));
/*  82: 69 */         deptNameArr.add(deptName);
/*  83:    */       }
/*  84: 71 */       return deptNameArr;
/*  85:    */     }
/*  86:    */     catch (Exception e)
/*  87:    */     {
/*  88: 74 */       e.printStackTrace();
/*  89: 75 */       return null;
/*  90:    */     }
/*  91:    */     finally
/*  92:    */     {
/*  93: 77 */       closeSourse();
/*  94:    */     }
/*  95:    */   }

/*  97:    */   public int addDep(String department, String yuanxi)
/*  98:    */   {
/*  99: 82 */     String sql = "insert into t_department (department,yuanxi) values (?,?)";
/* 100: 83 */     int i = 0;
/* 101:    */     try
/* 102:    */     {
/* 103: 85 */       this.ct = new ConnDb().getConn();
/* 104: 86 */       this.ps = this.ct.prepareStatement(sql);
/* 105: 87 */       this.ps.setString(1, department);
/* 106: 88 */       this.ps.setString(2, yuanxi);
/* 107: 89 */       i = this.ps.executeUpdate();
/* 108: 90 */       return i;
/* 109:    */     }
/* 110:    */     catch (Exception e)
/* 111:    */     {
/* 112: 93 */       e.printStackTrace();
/* 113: 94 */       return -1;
/* 114:    */     }
/* 115:    */     finally
/* 116:    */     {
/* 117: 96 */       closeSourse();
/* 118:    */     }
/* 119:    */   }
/* 120:    */   
/* 121:    */   public int delDepById(String id)
/* 122:    */   {
/* 123:102 */     String sql = "delete from t_department where id=?";
/* 124:103 */     int i = 0;
/* 125:    */     try
/* 126:    */     {
/* 127:105 */       this.ct = new ConnDb().getConn();
/* 128:106 */       this.ps = this.ct.prepareStatement(sql);
/* 129:107 */       this.ps.setString(1, id);
/* 130:108 */       i = this.ps.executeUpdate();
/* 131:109 */       return i;
/* 132:    */     }
/* 133:    */     catch (Exception e)
/* 134:    */     {
/* 135:112 */       e.printStackTrace();
/* 136:113 */       return -1;
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:115 */       closeSourse();
/* 141:    */     }
/* 142:    */   }
/* 143:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.DepartmentCl
 * JD-Core Version:    0.7.0.1
 */