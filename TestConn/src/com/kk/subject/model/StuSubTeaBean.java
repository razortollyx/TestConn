/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ public class StuSubTeaBean
/*  4:   */   implements Comparable<StuSubTeaBean>
/*  5:   */ {
/*  6:   */   private String stuId;
/*  7:   */   private int subId;
/*  8:   */   private int wish;
/*  9:   */   private String stuName;
/* 10:   */   private String teaName;
/* 11:   */   private String subTitle;
/* 12:   */   private int state;
/* 13:   */   private int total;
/* 14:   */   private int choose;
/* 15:   */   
/* 16:   */   public StuSubTeaBean() {}
/* 17:   */   
/* 18:   */   public StuSubTeaBean(String stuId, int subId, int wish, String stuName, String teaName, String subTitle, int state)
/* 19:   */   {
/* 20:20 */     setStuId(stuId);
/* 21:21 */     setSubId(subId);
/* 22:22 */     setWish(wish);
/* 23:23 */     setStuName(stuName);
/* 24:24 */     setTeaName(teaName);
/* 25:25 */     setState(state);
/* 26:26 */     setSubTitle(subTitle);
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getStuId()
/* 30:   */   {
/* 31:30 */     return this.stuId;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setStuId(String stuId)
/* 35:   */   {
/* 36:33 */     this.stuId = stuId;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public int getSubId()
/* 40:   */   {
/* 41:36 */     return this.subId;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setSubId(int subId)
/* 45:   */   {
/* 46:39 */     this.subId = subId;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int getWish()
/* 50:   */   {
/* 51:42 */     return this.wish;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setWish(int wish)
/* 55:   */   {
/* 56:45 */     this.wish = wish;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public String getTeaName()
/* 60:   */   {
/* 61:48 */     return this.teaName;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setTeaName(String teaName)
/* 65:   */   {
/* 66:51 */     this.teaName = teaName;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public int getState()
/* 70:   */   {
/* 71:54 */     return this.state;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setState(int state)
/* 75:   */   {
/* 76:57 */     this.state = state;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public String getSubTitle()
/* 80:   */   {
/* 81:60 */     return this.subTitle;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setSubTitle(String subTitle)
/* 85:   */   {
/* 86:63 */     this.subTitle = subTitle;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public String getStuName()
/* 90:   */   {
/* 91:66 */     return this.stuName;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public void setStuName(String stuName)
/* 95:   */   {
/* 96:69 */     this.stuName = stuName;
/* 97:   */   }
/* 98:   */   
/* 99:   */   public int getTotal()
/* :0:   */   {
/* :1:72 */     return this.total;
/* :2:   */   }
/* :3:   */   
/* :4:   */   public void setTotal(int total)
/* :5:   */   {
/* :6:75 */     this.total = total;
/* :7:   */   }
/* :8:   */   
/* :9:   */   public int getChoose()
/* ;0:   */   {
/* ;1:78 */     return this.choose;
/* ;2:   */   }
/* ;3:   */   
/* ;4:   */   public void setChoose(int choose)
/* ;5:   */   {
/* ;6:81 */     this.choose = choose;
/* ;7:   */   }
/* ;8:   */   
/* ;9:   */   public int compareTo(StuSubTeaBean sstb)
/* <0:   */   {
/* <1:86 */     return this.subId - sstb.subId;
/* <2:   */   }
/* <3:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.StuSubTeaBean
 * JD-Core Version:    0.7.0.1
 */