/*   1:    */ package com.kk.subject.model;
/*   2:    */ 
/*   3:    */ import java.sql.Date;
/*   4:    */ 
/*   5:    */ public class SubjectBean
/*   6:    */ {
/*   7:    */   private int id;
/*   8:    */   private String title;
/*   9:    */   private String teacher;
/*  10:    */   private String direction;
/*  11:    */   private String introduction;
/*  12:    */   private String schedule;
/*  13:    */   private String reference;
/*  14:    */   private String requirement;
/*  15:    */   private String domain;
/*  16:    */   private Date time;
/*  17:    */   private int state;
/*  18:    */   private int selectedNum;
/*  19:    */   private String key;
/*  20:    */   private String yuanxi;
/*  21:    */   
/*  22:    */   public SubjectBean() {}
/*  23:    */   
/*  24:    */   public SubjectBean(int id, String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, Date time, int state, int selectedNum, String key, String yuanxi)
/*  25:    */   {
/*  26: 27 */     setId(id);
/*  27: 28 */     setTitle(title);
/*  28: 29 */     setTeacher(teacher);
/*  29: 30 */     setDirection(direction);
/*  30: 31 */     setIntroduction(introduction);
/*  31: 32 */     setSchedule(schedule);
/*  32: 33 */     setReference(reference);
/*  33: 34 */     setRequirement(requirement);
/*  34: 35 */     setDomain(domain);
/*  35: 36 */     setTime(time);
/*  36: 37 */     setState(state);
/*  37: 38 */     setSelectedNum(selectedNum);
/*  38: 39 */     setkey(key);
/*  39: 40 */     setYuanxi(yuanxi);
/*  40:    */   }
/*  41:    */   
/*  42:    */   public SubjectBean(int id, String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, Date time, int state, int selectedNum)
/*  43:    */   {
/*  44: 45 */     setId(id);
/*  45: 46 */     setTitle(title);
/*  46: 47 */     setTeacher(teacher);
/*  47: 48 */     setDirection(direction);
/*  48: 49 */     setIntroduction(introduction);
/*  49: 50 */     setSchedule(schedule);
/*  50: 51 */     setReference(reference);
/*  51: 52 */     setRequirement(requirement);
/*  52: 53 */     setDomain(domain);
/*  53: 54 */     setTime(time);
/*  54: 55 */     setState(state);
/*  55: 56 */     setSelectedNum(selectedNum);
/*  56:    */   }
/*  57:    */   
/*  58:    */   public SubjectBean(String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, Date time, int state, int selectedNum)
/*  59:    */   {
/*  60: 61 */     setTitle(title);
/*  61: 62 */     setTeacher(teacher);
/*  62: 63 */     setDirection(direction);
/*  63: 64 */     setIntroduction(introduction);
/*  64: 65 */     setSchedule(schedule);
/*  65: 66 */     setReference(reference);
/*  66: 67 */     setRequirement(requirement);
/*  67: 68 */     setDomain(domain);
/*  68: 69 */     setTime(time);
/*  69: 70 */     setState(state);
/*  70: 71 */     setSelectedNum(selectedNum);
/*  71:    */   }
/*  72:    */   
/*  73:    */   public SubjectBean(String title, String teacher, String direction, String introduction, String schedule, String reference, String requirement, String domain, int state, int selectedNum, String key, String yuanxi)
/*  74:    */   {
/*  75: 76 */     setId(this.id);
/*  76: 77 */     setTitle(title);
/*  77: 78 */     setTeacher(teacher);
/*  78: 79 */     setDirection(direction);
/*  79: 80 */     setkey(key);
/*  80: 81 */     introduction = introduction.equals("此处填写题目简介") ? "" : introduction;
/*  81: 82 */     schedule = schedule.equals("此处填写进程安排") ? "" : schedule;
/*  82: 83 */     reference = reference.equals("此处填写参考文献") ? "" : reference;
/*  83: 84 */     requirement = requirement.equals("此处填写学生要求") ? "" : requirement;
/*  84: 85 */     domain = domain.equals("此处填写题目所属领域") ? "" : domain;
/*  85:    */     
/*  86: 87 */     setIntroduction(introduction);
/*  87: 88 */     setSchedule(schedule);
/*  88: 89 */     setReference(reference);
/*  89: 90 */     setRequirement(requirement);
/*  90: 91 */     setDomain(domain);
/*  91: 92 */     setTime(this.time);
/*  92: 93 */     setState(state);
/*  93: 94 */     setSelectedNum(selectedNum);
/*  94: 95 */     setYuanxi(yuanxi);
/*  95:    */   }
/*  96:    */   
/*  97:    */   public int getId()
/*  98:    */   {
/*  99: 98 */     return this.id;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setId(int id)
/* 103:    */   {
/* 104:101 */     this.id = id;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getTitle()
/* 108:    */   {
/* 109:104 */     return this.title;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setTitle(String title)
/* 113:    */   {
/* 114:107 */     this.title = title;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getTeacher()
/* 118:    */   {
/* 119:110 */     return this.teacher;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setTeacher(String teacher)
/* 123:    */   {
/* 124:113 */     this.teacher = teacher;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String getDirection()
/* 128:    */   {
/* 129:116 */     return this.direction;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setDirection(String direction)
/* 133:    */   {
/* 134:119 */     this.direction = direction;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String getIntroduction()
/* 138:    */   {
/* 139:122 */     return this.introduction;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setIntroduction(String introduction)
/* 143:    */   {
/* 144:125 */     this.introduction = introduction;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getSchedule()
/* 148:    */   {
/* 149:128 */     return this.schedule;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setSchedule(String schedule)
/* 153:    */   {
/* 154:131 */     this.schedule = schedule;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public String getReference()
/* 158:    */   {
/* 159:134 */     return this.reference;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setReference(String reference)
/* 163:    */   {
/* 164:137 */     this.reference = reference;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public String getRequirement()
/* 168:    */   {
/* 169:140 */     return this.requirement;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setRequirement(String requirement)
/* 173:    */   {
/* 174:143 */     this.requirement = requirement;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public String getDomain()
/* 178:    */   {
/* 179:146 */     return this.domain;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setDomain(String domain)
/* 183:    */   {
/* 184:149 */     this.domain = domain;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public int getState()
/* 188:    */   {
/* 189:152 */     return this.state;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setState(int state)
/* 193:    */   {
/* 194:155 */     this.state = state;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public int getSelectedNum()
/* 198:    */   {
/* 199:158 */     return this.selectedNum;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setSelectedNum(int selectedNum)
/* 203:    */   {
/* 204:161 */     this.selectedNum = selectedNum;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public String getkey()
/* 208:    */   {
/* 209:165 */     return this.key;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setkey(String key)
/* 213:    */   {
/* 214:168 */     this.key = key;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public Date getTime()
/* 218:    */   {
/* 219:171 */     return this.time;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setTime(Date time)
/* 223:    */   {
/* 224:174 */     this.time = time;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public String getKey()
/* 228:    */   {
/* 229:177 */     return this.key;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void setKey(String key)
/* 233:    */   {
/* 234:180 */     this.key = key;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public String getYuanxi()
/* 238:    */   {
/* 239:183 */     return this.yuanxi;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public void setYuanxi(String yuanxi)
/* 243:    */   {
/* 244:186 */     this.yuanxi = yuanxi;
/* 245:    */   }
/* 246:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.SubjectBean
 * JD-Core Version:    0.7.0.1
 */