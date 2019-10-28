/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class AdminBean
/*  4:   */ {
/*  5:   */   private String id;
/*  6:   */   private String psw;
/*  7:   */   private String name;
/*  8:   */   private int type;
/*  9:   */   private String sex;
/* 10:   */   private String phoneNum;
/* 11:   */   private String email;
/* 12:   */   private String yuanxi;
/* 13:   */   
/* 14:   */   public AdminBean() {}
/* 15:   */   
/* 16:   */   public AdminBean(String id, String psw, String name, int type, String sex, String phoneNum, String email, String yuanxi)
/* 17:   */   {
/* 18:22 */     this.id = id;
/* 19:23 */     this.psw = psw;
/* 20:24 */     this.name = name;
/* 21:25 */     this.type = type;
/* 22:26 */     this.sex = sex;
/* 23:27 */     this.phoneNum = phoneNum;
/* 24:28 */     this.email = email;
/* 25:29 */     this.yuanxi = yuanxi;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public AdminBean(String id, String psw, String name, String phoneNum, String email)
/* 29:   */   {
/* 30:33 */     this.id = id;
/* 31:34 */     this.psw = psw;
/* 32:35 */     this.name = name;
/* 33:36 */     this.phoneNum = phoneNum;
/* 34:37 */     this.email = email;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getName()
/* 38:   */   {
/* 39:40 */     return this.name;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setName(String name)
/* 43:   */   {
/* 44:43 */     this.name = name;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getSex()
/* 48:   */   {
/* 49:46 */     return this.sex;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setSex(String sex)
/* 53:   */   {
/* 54:49 */     this.sex = sex;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getPhoneNum()
/* 58:   */   {
/* 59:52 */     return this.phoneNum;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setPhoneNum(String phoneNum)
/* 63:   */   {
/* 64:55 */     this.phoneNum = phoneNum;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String getEmail()
/* 68:   */   {
/* 69:58 */     return this.email;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setEmail(String email)
/* 73:   */   {
/* 74:61 */     this.email = email;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public String getYuanxi()
/* 78:   */   {
/* 79:64 */     return this.yuanxi;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setYuanxi(String yuanxi)
/* 83:   */   {
/* 84:67 */     this.yuanxi = yuanxi;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public int getType()
/* 88:   */   {
/* 89:71 */     return this.type;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setType(int type)
/* 93:   */   {
/* 94:74 */     this.type = type;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public String getId()
/* 98:   */   {
/* 99:77 */     return this.id;
/* :0:   */   }
/* :1:   */   
/* :2:   */   public void setId(String id)
/* :3:   */   {
/* :4:80 */     this.id = id;
/* :5:   */   }
/* :6:   */   
/* :7:   */   public String getPsw()
/* :8:   */   {
/* :9:83 */     return this.psw;
/* ;0:   */   }
/* ;1:   */   
/* ;2:   */   public void setPsw(String psw)
/* ;3:   */   {
/* ;4:86 */     this.psw = psw;
/* ;5:   */   }
/* ;6:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.AdminBean
 * JD-Core Version:    0.7.0.1
 */