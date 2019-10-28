/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import com.ax.subject.model.ConnDb;
/*   4:    */ import java.sql.Connection;
/*   5:    */ import java.sql.PreparedStatement;
/*   6:    */ import java.sql.ResultSet;
/*   7:    */ import java.sql.SQLException;
/*   8:    */ 
/*   9:    */ public class SettingsCl
/*  10:    */ {
/*  11: 10 */   private Connection ct = null;
/*  12: 11 */   private PreparedStatement ps = null;
/*  13: 12 */   private ResultSet rs = null;
/*  14:    */   
/*  15:    */   public int delSettingsByyuanxi(String yuanxi)
/*  16:    */   {
/*  17: 15 */     int j = 0;
/*  18:    */     try
/*  19:    */     {
/*  20: 18 */       this.ct = new ConnDb().getConn();
/*  21:    */       
/*  22: 20 */       String sql = "delete from t_settings where department='" + yuanxi + "'";
/*  23: 21 */       this.ps = this.ct.prepareStatement(sql);
/*  24: 22 */       j = this.ps.executeUpdate();
/*  25: 23 */       return j;
/*  26:    */     }
/*  27:    */     catch (Exception e)
/*  28:    */     {
/*  29:    */       int i;
/*  30: 26 */       e.printStackTrace();
/*  31: 27 */       return j;
/*  32:    */     }
/*  33:    */     finally
/*  34:    */     {
/*  35: 29 */       closeSourse();
/*  36:    */     }
/*  37:    */   }
/*  38:    */   
/*  39:    */   public int insertByyuanxi(String yuanxi)
/*  40:    */   {
/*  41: 34 */     int i = 0;
/*  42:    */     try
/*  43:    */     {
/*  44: 36 */       String sql = "insert into t_settings (department) values (?) ";
/*  45: 37 */       this.ct = new ConnDb().getConn();
/*  46: 38 */       this.ps = this.ct.prepareStatement(sql);
/*  47: 39 */       this.ps.setString(1, yuanxi);
/*  48: 40 */       i = this.ps.executeUpdate();
/*  49: 41 */       return i;
/*  50:    */     }
/*  51:    */     catch (Exception e)
/*  52:    */     {
/*  53: 44 */       e.printStackTrace();
/*  54: 45 */       return -1;
/*  55:    */     }
/*  56:    */     finally
/*  57:    */     {
/*  58: 47 */       closeSourse();
/*  59:    */     }
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Settings getSettings(String yuanxi)
/*  63:    */   {
/*  64: 53 */     Settings s = null;
/*  65:    */     try
/*  66:    */     {
/*  67: 55 */       this.ct = new ConnDb().getConn();
/*  68: 56 */       this.ps = this.ct.prepareStatement("select * from t_settings where department='" + yuanxi + "' ");
/*  69: 57 */       this.rs = this.ps.executeQuery();
/*  70: 58 */       if (this.rs.next()) {
/*  71: 58 */         s = new Settings(this.rs.getInt(2), this.rs.getInt(3), this.rs.getInt(4), this.rs.getInt(5));
/*  72:    */       }
/*  73: 59 */       return s;
/*  74:    */     }
/*  75:    */     catch (Exception e)
/*  76:    */     {
/*  77: 62 */       e.printStackTrace();
/*  78: 63 */       return null;
/*  79:    */     }
/*  80:    */     finally
/*  81:    */     {
/*  82: 65 */       closeSourse();
/*  83:    */     }
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int setWarnNum(String warnNum, String yuanxi)
/*  87:    */   {
/*  88: 71 */     String sql = "update t_settings set warnNum='" + warnNum + "' where department='" + yuanxi + "'";
/*  89: 72 */     int i = 0;
/*  90:    */     try
/*  91:    */     {
/*  92: 74 */       this.ct = new ConnDb().getConn();
/*  93: 75 */       this.ps = this.ct.prepareStatement(sql);
/*  94: 76 */       i = this.ps.executeUpdate();
/*  95: 77 */       return i;
/*  96:    */     }
/*  97:    */     catch (Exception e)
/*  98:    */     {
/*  99: 80 */       e.printStackTrace();
/* 100: 81 */       return -1;
/* 101:    */     }
/* 102:    */     finally
/* 103:    */     {
/* 104: 83 */       closeSourse();
/* 105:    */     }
/* 106:    */   }
/* 107:    */   
/* 108:    */   public int setMaxSelNum(String maxSelNum, String yuanxi)
/* 109:    */   {
/* 110: 89 */     String sql = "update t_settings set maxSelNum='" + maxSelNum + "'  where department='" + yuanxi + "'";
/* 111: 90 */     int i = 0;
/* 112:    */     try
/* 113:    */     {
/* 114: 92 */       this.ct = new ConnDb().getConn();
/* 115: 93 */       this.ps = this.ct.prepareStatement(sql);
/* 116: 94 */       i = this.ps.executeUpdate();
/* 117: 95 */       return i;
/* 118:    */     }
/* 119:    */     catch (Exception e)
/* 120:    */     {
/* 121: 98 */       e.printStackTrace();
/* 122: 99 */       return -1;
/* 123:    */     }
/* 124:    */     finally
/* 125:    */     {
/* 126:101 */       closeSourse();
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   public int setmaxNum(String maxSelNum, String yuanxi)
/* 131:    */   {
/* 132:106 */     String sql = "update t_settings set alternative='" + maxSelNum + "'  where department='" + yuanxi + "'";
/* 133:107 */     int i = 0;
/* 134:    */     try
/* 135:    */     {
/* 136:109 */       this.ct = new ConnDb().getConn();
/* 137:110 */       this.ps = this.ct.prepareStatement(sql);
/* 138:111 */       i = this.ps.executeUpdate();
/* 139:112 */       return i;
/* 140:    */     }
/* 141:    */     catch (Exception e)
/* 142:    */     {
/* 143:115 */       e.printStackTrace();
/* 144:116 */       return -1;
/* 145:    */     }
/* 146:    */     finally
/* 147:    */     {
/* 148:118 */       closeSourse();
/* 149:    */     }
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void closeSourse()
/* 153:    */   {
/* 154:    */     try
/* 155:    */     {
/* 156:124 */       if (this.rs != null)
/* 157:    */       {
/* 158:125 */         this.rs.close();
/* 159:126 */         this.rs = null;
/* 160:    */       }
/* 161:128 */       if (this.ps != null)
/* 162:    */       {
/* 163:129 */         this.ps.close();
/* 164:130 */         this.ps = null;
/* 165:    */       }
/* 166:132 */       if (this.ct != null)
/* 167:    */       {
/* 168:133 */         this.ct.close();
/* 169:134 */         this.ct = null;
/* 170:    */       }
/* 171:    */     }
/* 172:    */     catch (SQLException e)
/* 173:    */     {
/* 174:138 */       e.printStackTrace();
/* 175:    */     }
/* 176:    */   }
/* 177:    */   
/* 178:    */   public int setGraduateGrade(String graduateGrade, String yuanxi)
/* 179:    */   {
/* 180:144 */     String sql = "update t_settings set graduateGrade='" + graduateGrade + "' where department='" + yuanxi + "'";
/* 181:145 */     int i = 0;
/* 182:    */     try
/* 183:    */     {
/* 184:147 */       this.ct = new ConnDb().getConn();
/* 185:148 */       this.ps = this.ct.prepareStatement(sql);
/* 186:149 */       i = this.ps.executeUpdate();
/* 187:150 */       return i;
/* 188:    */     }
/* 189:    */     catch (Exception e)
/* 190:    */     {
/* 191:153 */       e.printStackTrace();
/* 192:154 */       return -1;
/* 193:    */     }
/* 194:    */     finally
/* 195:    */     {
/* 196:156 */       closeSourse();
/* 197:    */     }
/* 198:    */   }
/* 199:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.SettingsCl
 * JD-Core Version:    0.7.0.1
 */