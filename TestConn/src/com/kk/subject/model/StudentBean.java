/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class StudentBean
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8:    */   private String id;
/*   9:    */   private String psw;
/*  10:    */   private String name;
/*  11:    */   private SEX sex;
/*  12:    */   private String cls;
/*  13:    */   private String major;
/*  14:    */   private String phoneNum;
/*  15:    */   private String email;
/*  16:    */   private int privilege;
/*  17:    */   private int selectNum;
/*  18:    */   private String yuanxi;
/*  19:    */   
/*  20:    */   /**
 * 
 */
public StudentBean() {}
@Override
public String toString() {
	return "StudentBean [id=" + id + ", psw=" + psw + ", name=" + name + ", sex=" + sex + ", cls=" + cls + ", major="
			+ major + ", phoneNum=" + phoneNum + ", email=" + email + ", privilege=" + privilege + ", selectNum="
			+ selectNum + ", yuanxi=" + yuanxi + "]";
}
/*  21:    */   
/*  22:    */   public StudentBean(String id, String psw, String name, SEX sex, String cls, String major, String phoneNum, String email, int privilege, int selectNum, String yuanxi)
/*  23:    */   {
/*  24: 23 */     setId(id);
/*  25: 24 */     setPsw(psw);
/*  26: 25 */     setName(name);
/*  27: 26 */     setSex(sex);
/*  28: 27 */     setCls(cls);
/*  29: 28 */     setMajor(major);
/*  30: 29 */     setPhoneNum(phoneNum);
/*  31: 30 */     setEmail(email);
/*  32: 31 */     setPrivilege(privilege);
/*  33: 32 */     setSelectNum(selectNum);
/*  34: 33 */     setYuanxi(yuanxi);
/*  35:    */   }
/*  36:    */   
/*  37:    */   public String getYuanxi()
/*  38:    */   {
/*  39: 38 */     return this.yuanxi;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setYuanxi(String yuanxi)
/*  43:    */   {
/*  44: 41 */     this.yuanxi = yuanxi;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public String getId()
/*  48:    */   {
/*  49: 44 */     return this.id;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void setId(String id)
/*  53:    */   {
/*  54: 47 */     this.id = id;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getPsw()
/*  58:    */   {
/*  59: 50 */     return this.psw;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setPsw(String psw)
/*  63:    */   {
/*  64: 53 */     this.psw = psw;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getName()
/*  68:    */   {
/*  69: 56 */     return this.name;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setName(String name)
/*  73:    */   {
/*  74: 59 */     this.name = name;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public SEX getSex()
/*  78:    */   {
/*  79: 62 */     return this.sex;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setSex(SEX sex)
/*  83:    */   {
/*  84: 65 */     this.sex = sex;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getCls()
/*  88:    */   {
/*  89: 68 */     return this.cls;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setCls(String cls)
/*  93:    */   {
/*  94: 71 */     this.cls = cls;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getMajor()
/*  98:    */   {
/*  99: 74 */     return this.major;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setMajor(String major)
/* 103:    */   {
/* 104: 77 */     this.major = major;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getPhoneNum()
/* 108:    */   {
/* 109: 80 */     return this.phoneNum;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setPhoneNum(String phoneNum)
/* 113:    */   {
/* 114: 83 */     this.phoneNum = phoneNum;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getEmail()
/* 118:    */   {
/* 119: 86 */     return this.email;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setEmail(String email)
/* 123:    */   {
/* 124: 89 */     this.email = email;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public int getPrivilege()
/* 128:    */   {
/* 129: 92 */     return this.privilege;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setPrivilege(int privilege)
/* 133:    */   {
/* 134: 95 */     this.privilege = privilege;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public int getSelectNum()
/* 138:    */   {
/* 139: 98 */     return this.selectNum;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setSelectNum(int selectNum)
/* 143:    */   {
/* 144:101 */     this.selectNum = selectNum;
/* 145:    */   }
/* 146:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StudentBean
 * JD-Core Version:    0.7.0.1
 */