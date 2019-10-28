/*  1:   */ package com.kk.subject.model;
/*  2:   */ 
/*  3:   */ import java.sql.Date;
/*  4:   */ 
/*  5:   */ public class NoticeBean
/*  6:   */ {
/*  7:   */   private int id;
/*  8:   */   private String title;
/*  9:   */   private String publisher;
/* 10:   */   private Date time;
/* 11:   */   private String detail;
/* 12:   */   private String yuanxi;
/* 13:   */   
/* 14:   */   public NoticeBean() {}
/* 15:   */   
/* 16:   */   public NoticeBean(String title, String publisher, Date time, String detail, String yuanxi)
/* 17:   */   {
/* 18:19 */     setTitle(title);
/* 19:20 */     setPublisher(publisher);
/* 20:21 */     setTime(time);
/* 21:22 */     setDetail(detail);
/* 22:23 */     setYuanxi(yuanxi);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public NoticeBean(String title, String publisher, Date time, String detail)
/* 26:   */   {
/* 27:27 */     setTitle(title);
/* 28:28 */     setPublisher(publisher);
/* 29:29 */     setTime(time);
/* 30:30 */     setDetail(detail);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public NoticeBean(int id, String title, String publisher, Date time, String detail)
/* 34:   */   {
/* 35:34 */     setId(id);
/* 36:35 */     setTitle(title);
/* 37:36 */     setPublisher(publisher);
/* 38:37 */     setTime(time);
/* 39:38 */     setDetail(detail);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public int getId()
/* 43:   */   {
/* 44:41 */     return this.id;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setId(int id)
/* 48:   */   {
/* 49:44 */     this.id = id;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getTitle()
/* 53:   */   {
/* 54:47 */     return this.title;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setTitle(String title)
/* 58:   */   {
/* 59:50 */     this.title = title;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public String getPublisher()
/* 63:   */   {
/* 64:53 */     return this.publisher;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setPublisher(String publisher)
/* 68:   */   {
/* 69:56 */     this.publisher = publisher;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Date getTime()
/* 73:   */   {
/* 74:59 */     return this.time;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setTime(Date time)
/* 78:   */   {
/* 79:62 */     this.time = time;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public String getDetail()
/* 83:   */   {
/* 84:65 */     return this.detail;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setDetail(String detail)
/* 88:   */   {
/* 89:68 */     this.detail = detail;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public String getYuanxi()
/* 93:   */   {
/* 94:71 */     return this.yuanxi;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public void setYuanxi(String yuanxi)
/* 98:   */   {
/* 99:74 */     this.yuanxi = yuanxi;
/* :0:   */   }
/* :1:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.subject.model.NoticeBean
 * JD-Core Version:    0.7.0.1
 */