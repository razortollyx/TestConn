/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.Date;
/*   5:    */ import java.sql.ResultSet;
/*   6:    */ import java.sql.SQLException;
/*   7:    */ import java.sql.Statement;
import java.util.Calendar;
/*   9:    */ 
/*  10:    */ public class TeacherSubBeanCl
/*  11:    */ {
/*  12: 13 */   private Connection ct = null;
/*  13: 14 */   private Statement sm = null;
/*  14: 15 */   private ResultSet rs = null;
/*  15:    */   
/*  16:    */   public void insertSubject(String t_id, int s_id)
/*  17:    */   {
/*  18: 19 */     int i = 0;
/*  19:    */     try
/*  20:    */     {
/*  21: 21 */       this.ct = new ConnDb().getConn();
/*  22: 22 */       this.sm = this.ct.createStatement();
/*  23: 23 */       String sql = "insert into t_teacher_sub (t_id, s_id) values ('" + t_id + "','" + s_id + "')";
/*  24:    */       
/*  25: 25 */       i = this.sm.executeUpdate(sql);
/*  26:    */     }
/*  27:    */     catch (Exception e)
/*  28:    */     {
/*  29: 29 */       e.printStackTrace();
/*  30:    */     }
/*  31:    */     finally
/*  32:    */     {
/*  33: 31 */       closeSourse();
/*  34:    */     }
/*  35:    */   }
/*  36:    */   
/*  37:    */   public int[] getS_id(String t_id)
/*  38:    */   {
/*  39: 37 */     int i = -1;
/*  40: 38 */     int[] s_id = null;
/*  41: 39 */     int[] sa_id = null;
/*  42: 40 */     int i1 = 0;
/*  43: 41 */     int count = 0;
/*  44: 42 */     Calendar date = Calendar.getInstance();
/*  45: 43 */     Calendar now = Calendar.getInstance();
/*  46: 44 */     Date d = null;
/*  47:    */     try
/*  48:    */     {
/*  49: 46 */       this.ct = new ConnDb().getConn();
/*  50: 47 */       this.sm = this.ct.createStatement();
/*  51: 48 */       String sql = "select count(*) from t_teacher_sub where t_id='" + t_id + "'";
/*  52: 49 */       this.rs = this.sm.executeQuery(sql);
/*  53: 50 */       if (this.rs.next()) {
/*  54: 50 */         i = this.rs.getInt(1);
/*  55:    */       }
/*  56: 51 */       if (i == 0) {
/*  57: 52 */         return null;
/*  58:    */       }
/*  59: 54 */       sql = "select s_id from t_teacher_sub where t_id='" + t_id + "'";
/*  60: 55 */       this.rs = this.sm.executeQuery(sql);
/*  61:    */       
/*  62: 57 */       sa_id = new int[i];
/*  63:    */       
/*  64: 59 */       i = 0;
/*  65: 60 */       while (this.rs.next()) {
/*  66: 62 */         sa_id[(i++)] = this.rs.getInt(1);
/*  67:    */       }
/*  68: 66 */       for (int n = 0; n < i; n++)
/*  69:    */       {
/*  70: 70 */         sql = "select time from t_subject where id='" + sa_id[n] + "'";
/*  71:    */         
/*  72: 72 */         this.rs = this.sm.executeQuery(sql);
/*  73: 73 */         if (this.rs.next()) {
/*  74: 73 */           d = this.rs.getDate(1);
/*  75:    */         }
/*  76: 74 */         if (d != null) {
/*  77: 74 */           date.setTime(d);
/*  78:    */         }
/*  79: 75 */         String y = String.valueOf(date.get(1));
/*  80:    */         String year = String.valueOf(now.get(1)); 
/*  81: 77 */         String year2 = String.valueOf(now.get(1)-1);
					  System.out.println("year:"+year+"  year1:"+year2);
/*  82: 80 */         if (y.equals(year) || y.equals(year2)) {
/*  83: 82 */           count++;
/*  84:    */         }
/*  85:    */       }
/*  86: 87 */       s_id = new int[count];
/*  87: 89 */       for (int m = 0; m < i; m++)
/*  88:    */       {
/*  89: 93 */         sql = "select time from t_subject where id='" + sa_id[m] + "'";
/*  90:    */         
/*  91: 95 */         this.rs = this.sm.executeQuery(sql);
/*  92: 96 */         if (this.rs.next()) {
/*  93: 96 */           d = this.rs.getDate(1);
/*  94:    */         }
/*  95: 97 */         if (d != null) {
/*  96: 97 */           date.setTime(d);
/*  97:    */         }
/*  98: 98 */         String y1 = String.valueOf(date.get(1));
/*  99:    */         String year2 = String.valueOf(now.get(1)-1);
/* 100:100 */         String year1 = String.valueOf(now.get(1));
/* 101:103 */         if (y1.equals(year1)||y1.equals(year2)) {
/* 102:105 */           s_id[(i1++)] = sa_id[m];
/* 103:    */         }
/* 104:    */       }
/* 105:110 */       return s_id;
/* 106:    */     }
/* 107:    */     catch (Exception e)
/* 108:    */     {
/* 109:113 */       e.printStackTrace();
/* 110:114 */       return null;
/* 111:    */     }
/* 112:    */     finally
/* 113:    */     {
/* 114:116 */       closeSourse();
/* 115:    */     }
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void closeSourse()
/* 119:    */   {
/* 120:    */     try
/* 121:    */     {
/* 122:124 */       if (this.rs != null)
/* 123:    */       {
/* 124:125 */         this.rs.close();
/* 125:126 */         this.rs = null;
/* 126:    */       }
/* 127:128 */       if (this.sm != null)
/* 128:    */       {
/* 129:129 */         this.sm.close();
/* 130:130 */         this.sm = null;
/* 131:    */       }
/* 132:132 */       if (this.ct != null)
/* 133:    */       {
/* 134:133 */         this.ct.close();
/* 135:134 */         this.ct = null;
/* 136:    */       }
/* 137:    */     }
/* 138:    */     catch (SQLException e)
/* 139:    */     {
/* 140:138 */       e.printStackTrace();
/* 141:    */     }
/* 142:    */   }
/* 143:    */   
/* 144:    */   public int updateTeacherName(String teaId, String newName)
/* 145:    */   {
/* 146:150 */     int i = 0;
/* 147:151 */     int[] subIds = getS_id(teaId);
/* 148:    */     try
/* 149:    */     {
/* 150:153 */       this.ct = new ConnDb().getConn();
/* 151:154 */       this.sm = this.ct.createStatement();
/* 152:155 */       int j = 0;
/* 153:    */       do
/* 154:    */       {
/* 155:156 */         String sql = "update t_subject set teacher='" + newName + "' where id='" + subIds[j] + "'";
/* 156:157 */         i += this.sm.executeUpdate(sql);j++;
/* 157:155 */         if (subIds == null) {
/* 158:    */           break;
/* 159:    */         }
/* 160:155 */       } while (j < subIds.length);
/* 161:    */     }
/* 162:    */     catch (Exception e)
/* 163:    */     {
/* 164:162 */       e.printStackTrace();
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:164 */       closeSourse();
/* 169:    */     }
/* 170:166 */     return i;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String titleExistCheck(String teaId, String title)
/* 174:    */   {
/* 175:176 */     String result = "false";
/* 176:177 */     int[] subIds = new SubjectBeanCl().getSubIdsByTitle(title);
/* 177:178 */     if (subIds != null)
/* 178:    */     {
/* 179:179 */       TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
/* 180:180 */       for (int i = 0; i < subIds.length; i++)
/* 181:    */       {
/* 182:181 */         String tId = tsbc.getTeaId(subIds[i]);
/* 183:182 */         if (teaId.equals(tId))
/* 184:    */         {
/* 185:183 */           result = "self";
/* 186:184 */           return result;
/* 187:    */         }
/* 188:    */       }
/* 189:187 */       result = "true";
/* 190:    */     }
/* 191:189 */     return result;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public String getTeaId(int subId)
/* 195:    */   {
/* 196:196 */     String teaId = null;
/* 197:    */     try
/* 198:    */     {
/* 199:198 */       this.ct = new ConnDb().getConn();
/* 200:199 */       this.sm = this.ct.createStatement();
/* 201:200 */       this.rs = this.sm.executeQuery("select t_id from t_teacher_sub where s_id='" + subId + "'");
/* 202:201 */       if (this.rs.next()) {
/* 203:201 */         teaId = this.rs.getString(1);
/* 204:    */       }
/* 205:202 */       return teaId;
/* 206:    */     }
/* 207:    */     catch (Exception e)
/* 208:    */     {
/* 209:205 */       e.printStackTrace();
/* 210:206 */       return null;
/* 211:    */     }
/* 212:    */     finally
/* 213:    */     {
/* 214:208 */       closeSourse();
/* 215:    */     }
/* 216:    */   }
/* 217:    */ 
	
				public String isExistTeaId(String id)
/* 195:    */   {
/* 196:196 */     String teaId = null;
/* 197:    */     try
/* 198:    */     {
/* 199:198 */       this.ct = new ConnDb().getConn();
/* 200:199 */       this.sm = this.ct.createStatement();
/* 201:200 */       this.rs = this.sm.executeQuery("select * from t_teacher_sub where t_id='" + id + "'");
/* 202:201 */       if (this.rs.next()) {
/* 203:201 */         teaId = this.rs.getString(1);
/* 204:    */       }
/* 205:202 */       return teaId;
/* 206:    */     }
/* 207:    */     catch (Exception e)
/* 208:    */     {
/* 209:205 */       e.printStackTrace();
/* 210:206 */       return null;
/* 211:    */     }
/* 212:    */     finally
/* 213:    */     {
/* 214:208 */       closeSourse();
/* 215:    */     }
/* 216:    */   }
/* 217:    */ 
}
/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.TeacherSubBeanCl
 * JD-Core Version:    0.7.0.1
 */