/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import com.ax.subject.model.ConnDb;
/*   4:    */ import com.common.controller.Md5;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ 
/*  11:    */ public class AdminBeanCl
/*  12:    */ {
/*  13: 11 */   private Connection ct = null;
/*  14: 12 */   private PreparedStatement ps = null;
/*  15: 13 */   private ResultSet rs = null;
/*  16:    */   
/*  17:    */   public AdminBean getAdminById(String id)
/*  18:    */   {
/*  19: 16 */     String sql = "select * from t_admin where id='" + id + "'";
/*  20:    */     try
/*  21:    */     {
/*  22: 18 */       this.ct = new ConnDb().getConn();
/*  23: 19 */       this.ps = this.ct.prepareStatement(sql);
/*  24: 20 */       this.rs = this.ps.executeQuery();
/*  25: 21 */       if (this.rs.next())
/*  26:    */       {
/*  27: 22 */         AdminBean ab = new AdminBean();
/*  28: 23 */         ab.setId(this.rs.getString(1));
/*  29: 24 */         ab.setPsw(this.rs.getString(2));
/*  30: 25 */         ab.setName(this.rs.getString(3));
/*  31: 26 */         ab.setType(this.rs.getInt(4));
/*  32: 27 */         ab.setSex(this.rs.getString(5));
/*  33: 28 */         ab.setPhoneNum(this.rs.getString(6));
/*  34: 29 */         ab.setEmail(this.rs.getString(7));
/*  35: 30 */         ab.setYuanxi(this.rs.getString(8));
/*  36: 31 */         return ab;
/*  37:    */       }
/*  38: 33 */       return null;
/*  39:    */     }
/*  40:    */     catch (Exception e)
/*  41:    */     {
/*  42: 37 */       e.printStackTrace();
/*  43: 38 */       return null;
/*  44:    */     }
/*  45:    */     finally
/*  46:    */     {
/*  47: 40 */       closeSourse();
/*  48:    */     }
/*  49:    */   }
/*  50:    */   
/*  51:    */   public AdminBean getAdminByyuanxi(String yuanxi)
/*  52:    */   {
/*  53: 44 */     String sql = "select * from t_admin where department='" + yuanxi + "'";
/*  54:    */     try
/*  55:    */     {
/*  56: 46 */       this.ct = new ConnDb().getConn();
/*  57: 47 */       this.ps = this.ct.prepareStatement(sql);
/*  58: 48 */       this.rs = this.ps.executeQuery();
/*  59: 49 */       if (this.rs.next())
/*  60:    */       {
/*  61: 50 */         AdminBean ab = new AdminBean();
/*  62: 51 */         ab.setId(this.rs.getString(1));
/*  63: 52 */         ab.setPsw(this.rs.getString(2));
/*  64: 53 */         ab.setName(this.rs.getString(3));
/*  65: 54 */         ab.setType(this.rs.getInt(4));
/*  66: 55 */         ab.setSex(this.rs.getString(5));
/*  67: 56 */         ab.setPhoneNum(this.rs.getString(6));
/*  68: 57 */         ab.setEmail(this.rs.getString(7));
/*  69: 58 */         ab.setYuanxi(this.rs.getString(8));
/*  70: 59 */         return ab;
/*  71:    */       }
/*  72: 61 */       return null;
/*  73:    */     }
/*  74:    */     catch (Exception e)
/*  75:    */     {
/*  76: 65 */       e.printStackTrace();
/*  77: 66 */       return null;
/*  78:    */     }
/*  79:    */     finally
/*  80:    */     {
/*  81: 68 */       closeSourse();
/*  82:    */     }
/*  83:    */   }
/*  84:    */   
/*  85:    */   public ArrayList<AdminBean> getAll()
/*  86:    */   {
/*  87: 72 */     ArrayList<AdminBean> al = new ArrayList();
/*  88: 73 */     String sql = "select * from t_admin";
/*  89:    */     try
/*  90:    */     {
/*  91: 75 */       this.ct = new ConnDb().getConn();
/*  92: 76 */       this.ps = this.ct.prepareStatement(sql);
/*  93: 77 */       this.rs = this.ps.executeQuery();
/*  94: 78 */       while (this.rs.next())
/*  95:    */       {
/*  96: 79 */         AdminBean ab = new AdminBean();
/*  97: 80 */         ab.setId(this.rs.getString(1));
/*  98: 81 */         ab.setPsw(this.rs.getString(2));
/*  99: 82 */         ab.setName(this.rs.getString(3));
/* 100: 83 */         ab.setType(this.rs.getInt(4));
/* 101: 84 */         ab.setSex(this.rs.getString(5));
/* 102: 85 */         ab.setPhoneNum(this.rs.getString(6));
/* 103: 86 */         ab.setEmail(this.rs.getString(7));
/* 104: 87 */         ab.setYuanxi(this.rs.getString(8));
/* 105: 88 */         if (!ab.getYuanxi().endsWith("校级管理员")) {
/* 106: 89 */           al.add(ab);
/* 107:    */         }
/* 108:    */       }
/* 109:    */     }
/* 110:    */     catch (Exception e)
/* 111:    */     {
/* 112: 94 */       e.printStackTrace();
/* 113: 95 */       return null;
/* 114:    */     }
/* 115:    */     finally
/* 116:    */     {
/* 117: 97 */       closeSourse();
/* 118:    */     }
/* 119: 99 */     return al;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void closeSourse()
/* 123:    */   {
/* 124:    */     try
/* 125:    */     {
/* 126:105 */       if (this.rs != null)
/* 127:    */       {
/* 128:106 */         this.rs.close();
/* 129:107 */         this.rs = null;
/* 130:    */       }
/* 131:109 */       if (this.ps != null)
/* 132:    */       {
/* 133:110 */         this.ps.close();
/* 134:111 */         this.ps = null;
/* 135:    */       }
/* 136:113 */       if (this.ct != null)
/* 137:    */       {
/* 138:114 */         this.ct.close();
/* 139:115 */         this.ct = null;
/* 140:    */       }
/* 141:    */     }
/* 142:    */     catch (SQLException e)
/* 143:    */     {
/* 144:119 */       e.printStackTrace();
/* 145:    */     }
/* 146:    */   }
/* 147:    */   
/* 148:    */   public int insertByTb(AdminBean ad)
/* 149:    */   {
/* 150:125 */     int i = 0;
/* 151:    */     try
/* 152:    */     {
/* 153:128 */       String sql = "insert into t_admin (id,psw,name,type,sex,phoneNum,email,department) values (?,?,?,?,?,?,?,?)";
/* 154:129 */       this.ct = new ConnDb().getConn();
/* 155:130 */       this.ps = this.ct.prepareStatement(sql);
/* 156:131 */       this.ps.setString(1, ad.getId());
/* 157:132 */       this.ps.setString(2, ad.getPsw());
/* 158:133 */       this.ps.setString(3, ad.getName());
/* 159:134 */       this.ps.setInt(4, ad.getType());
/* 160:135 */       this.ps.setString(5, ad.getSex());
/* 161:136 */       this.ps.setString(6, ad.getPhoneNum());
/* 162:137 */       this.ps.setString(7, ad.getEmail());
/* 163:138 */       this.ps.setString(8, ad.getYuanxi());
/* 164:139 */       i = this.ps.executeUpdate();
/* 165:140 */       return i;
/* 166:    */     }
/* 167:    */     catch (Exception e)
/* 168:    */     {
/* 169:143 */       e.printStackTrace();
/* 170:144 */       return -1;
/* 171:    */     }
/* 172:    */     finally
/* 173:    */     {
/* 174:146 */       closeSourse();
/* 175:    */     }
/* 176:    */   }
/* 177:    */   
/* 178:    */   public int updateData(String sql)
/* 179:    */   {
/* 180:153 */     int i = 0;
/* 181:    */     try
/* 182:    */     {
/* 183:155 */       this.ct = new ConnDb().getConn();
/* 184:156 */       this.ps = this.ct.prepareStatement(sql);
/* 185:157 */       i = this.ps.executeUpdate();
/* 186:158 */       return i;
/* 187:    */     }
/* 188:    */     catch (Exception e)
/* 189:    */     {
/* 190:161 */       e.printStackTrace();
/* 191:162 */       return -1;
/* 192:    */     }
/* 193:    */     finally
/* 194:    */     {
/* 195:164 */       closeSourse();
/* 196:    */     }
/* 197:    */   }
/* 198:    */   
/* 199:    */   public boolean checkExist(String adminId)
/* 200:    */   {
/* 201:170 */     if (getAdminById(adminId) != null) {
/* 202:171 */       return true;
/* 203:    */     }
/* 204:173 */     return false;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public boolean checkExist1(String yuanxi)
/* 208:    */   {
/* 209:178 */     if (getAdminByyuanxi(yuanxi) != null) {
/* 210:179 */       return true;
/* 211:    */     }
/* 212:181 */     return false;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public boolean checkUser(String id, String psw)
/* 216:    */   {
/* 217:185 */     boolean b = false;
/* 218:186 */     Md5 md5 = new Md5();
/* 219:187 */     String sql = "select psw from t_admin where id='" + id + "'";
/* 220:    */     try
/* 221:    */     {
/* 222:189 */       this.ct = new ConnDb().getConn();
/* 223:190 */       this.ps = this.ct.prepareStatement(sql);
/* 224:    */       
/* 225:192 */       this.rs = this.ps.executeQuery(sql);
/* 226:193 */       if (this.rs.next())
/* 227:    */       {
/* 228:195 */         String str = this.rs.getString(1);
/* 229:196 */         String str1 = Md5.MD5(str);
/* 230:    */         
/* 231:198 */         String ptr = Md5.MD5(psw);
/* 232:200 */         if (str1.equals(ptr)) {
/* 233:202 */           b = true;
/* 234:    */         }
/* 235:    */       }
/* 236:    */     }
/* 237:    */     catch (Exception e)
/* 238:    */     {
/* 239:208 */       e.printStackTrace();
/* 240:    */     }
/* 241:    */     finally
/* 242:    */     {
/* 243:211 */       closeSourse();
/* 244:    */     }
/* 245:213 */     return b;
/* 246:    */   }
/* 247:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.AdminBeanCl
 * JD-Core Version:    0.7.0.1
 */