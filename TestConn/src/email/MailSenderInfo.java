/*  1:   */ package email;
/*  2:   */ 
/*  3:   */ import java.util.Properties;
/*  4:   */ 
/*  5:   */ public class MailSenderInfo
/*  6:   */ {
/*  7:   */   private String mailServerHost;
/*  8: 7 */   private String mailServerPort = "25";
/*  9:   */   private String fromAddress;
/* 10:   */   private String toAddress;
/* 11:   */   private String userName;
/* 12:   */   private String password;
/* 13:16 */   private boolean validate = false;
/* 14:   */   private String subject;
/* 15:   */   private String content;
/* 16:   */   private String[] attachFileNames;
/* 17:   */   
/* 18:   */   public Properties getProperties()
/* 19:   */   {
/* 20:25 */     Properties p = new Properties();
/* 21:26 */     p.put("mail.smtp.host", this.mailServerHost);
/* 22:27 */     p.put("mail.smtp.port", this.mailServerPort);
/* 23:28 */     p.put("mail.smtp.auth", this.validate ? "true" : "false");
/* 24:29 */     return p;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getMailServerHost()
/* 28:   */   {
/* 29:32 */     return this.mailServerHost;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setMailServerHost(String mailServerHost)
/* 33:   */   {
/* 34:35 */     this.mailServerHost = mailServerHost;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getMailServerPort()
/* 38:   */   {
/* 39:38 */     return this.mailServerPort;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setMailServerPort(String mailServerPort)
/* 43:   */   {
/* 44:41 */     this.mailServerPort = mailServerPort;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public boolean isValidate()
/* 48:   */   {
/* 49:44 */     return this.validate;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setValidate(boolean validate)
/* 53:   */   {
/* 54:47 */     this.validate = validate;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String[] getAttachFileNames()
/* 58:   */   {
/* 59:50 */     return this.attachFileNames;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setAttachFileNames(String[] fileNames)
/* 63:   */   {
/* 64:53 */     this.attachFileNames = fileNames;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String getFromAddress()
/* 68:   */   {
/* 69:56 */     return this.fromAddress;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setFromAddress(String fromAddress)
/* 73:   */   {
/* 74:59 */     this.fromAddress = fromAddress;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public String getPassword()
/* 78:   */   {
/* 79:62 */     return this.password;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setPassword(String password)
/* 83:   */   {
/* 84:65 */     this.password = password;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public String getToAddress()
/* 88:   */   {
/* 89:68 */     return this.toAddress;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setToAddress(String toAddress)
/* 93:   */   {
/* 94:71 */     this.toAddress = toAddress;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public String getUserName()
/* 98:   */   {
/* 99:74 */     return this.userName;
/* :0:   */   }
/* :1:   */   
/* :2:   */   public void setUserName(String userName)
/* :3:   */   {
/* :4:77 */     this.userName = userName;
/* :5:   */   }
/* :6:   */   
/* :7:   */   public String getSubject()
/* :8:   */   {
/* :9:80 */     return this.subject;
/* ;0:   */   }
/* ;1:   */   
/* ;2:   */   public void setSubject(String subject)
/* ;3:   */   {
/* ;4:83 */     this.subject = subject;
/* ;5:   */   }
/* ;6:   */   
/* ;7:   */   public String getContent()
/* ;8:   */   {
/* ;9:86 */     return this.content;
/* <0:   */   }
/* <1:   */   
/* <2:   */   public void setContent(String textContent)
/* <3:   */   {
/* <4:89 */     this.content = textContent;
/* <5:   */   }
/* <6:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     email.MailSenderInfo
 * JD-Core Version:    0.7.0.1
 */