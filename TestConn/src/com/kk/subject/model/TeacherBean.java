/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ public class TeacherBean
/*   4:    */ {
/*   5:    */   private String id;
/*   6:    */   private String psw;
/*   7:    */   private String name;
/*   8:    */   private SEX sex;
/*   9:    */   private String phoneNum;
/*  10:    */   private String email;
/*  11:    */   private String jobTitle;
/*  12:    */   private int subNum;
/*  13:    */   private int maxSubNum;
/*  14:    */   private String department;
/*  15:    */   private int type;
/*  16:    */   private String xibie;
/*  17:    */   
/*  18:    */   public TeacherBean() {}
/*  19:    */   
                public TeacherBean(String id,String name) {
                	setId(id);
                	setName(name);
                }

/*  20:    */   public TeacherBean(String id, String psw, String name, SEX sex, String phoneNum, String email, String jobTitle, int subNum, int maxSubNum)
/*  21:    */   {
/*  22: 24 */     setId(id);
/*  23: 25 */     setPsw(psw);
/*  24: 26 */     setName(name);
/*  25: 27 */     setSex(sex);
/*  26: 28 */     setPhoneNum(phoneNum);
/*  27: 29 */     setEmail(email);
/*  28: 30 */     setJobTitle(jobTitle);
/*  29: 31 */     setSubNum(subNum);
/*  30: 32 */     setMaxSubNum(maxSubNum);
/*  31:    */   }
/*  32:    */   
/*  33:    */   public TeacherBean(String id, String psw, String name, SEX sex, String phoneNum, String email, String jobTitle, int subNum, int maxSubNum, String department, int type, String xibie)
/*  34:    */   {
/*  35: 36 */     setId(id);
/*  36: 37 */     setPsw(psw);
/*  37: 38 */     setName(name);
/*  38: 39 */     setSex(sex);
/*  39: 40 */     setPhoneNum(phoneNum);
/*  40: 41 */     setEmail(email);
/*  41: 42 */     setJobTitle(jobTitle);
/*  42: 43 */     setSubNum(subNum);
/*  43: 44 */     setMaxSubNum(maxSubNum);
/*  44: 45 */     setDepartment(department);
/*  45: 46 */     setType(type);
/*  46: 47 */     setXibie(xibie);
/*  47:    */   }
/*  48:    */   
/*  49:    */   public TeacherBean(String id, String psw, String name, SEX sex, String phoneNum, String email, String jobTitle, int subNum, int maxSubNum, String department, int type)
/*  50:    */   {
/*  51: 51 */     setId(id);
/*  52: 52 */     setPsw(psw);
/*  53: 53 */     setName(name);
/*  54: 54 */     setSex(sex);
/*  55: 55 */     setPhoneNum(phoneNum);
/*  56: 56 */     setEmail(email);
/*  57: 57 */     setJobTitle(jobTitle);
/*  58: 58 */     setSubNum(subNum);
/*  59: 59 */     setMaxSubNum(maxSubNum);
/*  60: 60 */     setDepartment(department);
/*  61: 61 */     setType(type);
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getDepartment()
/*  65:    */   {
/*  66: 64 */     return this.department;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setDepartment(String department)
/*  70:    */   {
/*  71: 67 */     this.department = department;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public int getType()
/*  75:    */   {
/*  76: 70 */     return this.type;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setType(int type)
/*  80:    */   {
/*  81: 73 */     this.type = type;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getId()
/*  85:    */   {
/*  86: 76 */     return this.id;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setId(String id)
/*  90:    */   {
/*  91: 79 */     this.id = id;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getPsw()
/*  95:    */   {
/*  96: 82 */     return this.psw;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setPsw(String psw)
/* 100:    */   {
/* 101: 85 */     this.psw = psw;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getName()
/* 105:    */   {
/* 106: 88 */     return this.name;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setName(String name)
/* 110:    */   {
/* 111: 91 */     this.name = name;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getPhoneNum()
/* 115:    */   {
/* 116: 94 */     return this.phoneNum;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setPhoneNum(String phoneNum)
/* 120:    */   {
/* 121: 97 */     this.phoneNum = phoneNum;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getEmail()
/* 125:    */   {
/* 126:100 */     return this.email;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setEmail(String email)
/* 130:    */   {
/* 131:103 */     this.email = email;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getJobTitle()
/* 135:    */   {
/* 136:106 */     return this.jobTitle;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setJobTitle(String jobTitle)
/* 140:    */   {
/* 141:109 */     this.jobTitle = jobTitle;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public int getMaxSubNum()
/* 145:    */   {
/* 146:112 */     return this.maxSubNum;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setMaxSubNum(int maxSubNum)
/* 150:    */   {
/* 151:115 */     this.maxSubNum = maxSubNum;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public SEX getSex()
/* 155:    */   {
/* 156:118 */     return this.sex;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setSex(SEX sex)
/* 160:    */   {
/* 161:121 */     this.sex = sex;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public int getSubNum()
/* 165:    */   {
/* 166:124 */     return this.subNum;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setSubNum(int subNum)
/* 170:    */   {
/* 171:127 */     this.subNum = subNum;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String getXibie()
/* 175:    */   {
/* 176:130 */     return this.xibie;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setXibie(String xibie)
/* 180:    */   {
/* 181:133 */     this.xibie = xibie;
/* 182:    */   }
/* 183:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.TeacherBean
 * JD-Core Version:    0.7.0.1
 */