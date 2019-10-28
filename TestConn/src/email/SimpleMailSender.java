/*  1:   */ package email;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ import java.util.Properties;
/*  5:   */ import javax.mail.Address;
/*  6:   */ import javax.mail.BodyPart;
/*  7:   */ import javax.mail.Message;
/*  8:   */ import javax.mail.Message.RecipientType;
/*  9:   */ import javax.mail.MessagingException;
/* 10:   */ import javax.mail.Multipart;
/* 11:   */ import javax.mail.Session;
/* 12:   */ import javax.mail.Transport;
/* 13:   */ import javax.mail.internet.InternetAddress;
/* 14:   */ import javax.mail.internet.MimeBodyPart;
/* 15:   */ import javax.mail.internet.MimeMessage;
/* 16:   */ import javax.mail.internet.MimeMultipart;
/* 17:   */ 
/* 18:   */ public class SimpleMailSender
/* 19:   */ {
/* 20:   */   public boolean sendTextMail(MailSenderInfo mailInfo)
/* 21:   */   {
/* 22:21 */     MyAuthenticator authenticator = null;
/* 23:22 */     Properties pro = mailInfo.getProperties();
/* 24:23 */     if (mailInfo.isValidate()) {
/* 25:25 */       authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
/* 26:   */     }
/* 27:28 */     Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
/* 28:   */     try
/* 29:   */     {
/* 30:31 */       Message mailMessage = new MimeMessage(sendMailSession);
/* 31:   */       
/* 32:33 */       Address from = new InternetAddress(mailInfo.getFromAddress());
/* 33:   */       
/* 34:35 */       mailMessage.setFrom(from);
/* 35:   */       
/* 36:37 */       Address to = new InternetAddress(mailInfo.getToAddress());
/* 37:38 */       mailMessage.setRecipient(Message.RecipientType.TO, to);
/* 38:   */       
/* 39:40 */       mailMessage.setSubject(mailInfo.getSubject());
/* 40:   */       
/* 41:42 */       mailMessage.setSentDate(new Date());
/* 42:   */       
/* 43:44 */       String mailContent = mailInfo.getContent();
/* 44:45 */       mailMessage.setText(mailContent);
/* 45:   */       
/* 46:47 */       Transport.send(mailMessage);
/* 47:48 */       return true;
/* 48:   */     }
/* 49:   */     catch (MessagingException ex)
/* 50:   */     {
/* 51:50 */       ex.printStackTrace();
/* 52:   */     }
/* 53:52 */     return false;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public static boolean sendHtmlMail(MailSenderInfo mailInfo)
/* 57:   */   {
/* 58:57 */     MyAuthenticator authenticator = null;
/* 59:58 */     Properties pro = mailInfo.getProperties();
/* 60:60 */     if (mailInfo.isValidate()) {
/* 61:61 */       authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
/* 62:   */     }
/* 63:64 */     Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
/* 64:   */     try
/* 65:   */     {
/* 66:67 */       Message mailMessage = new MimeMessage(sendMailSession);
/* 67:   */       
/* 68:69 */       Address from = new InternetAddress(mailInfo.getFromAddress());
/* 69:   */       
/* 70:71 */       mailMessage.setFrom(from);
/* 71:   */       
/* 72:73 */       Address to = new InternetAddress(mailInfo.getToAddress());
/* 73:   */       
/* 74:75 */       mailMessage.setRecipient(Message.RecipientType.TO, to);
/* 75:   */       
/* 76:77 */       mailMessage.setSubject(mailInfo.getSubject());
/* 77:   */       
/* 78:79 */       mailMessage.setSentDate(new Date());
/* 79:   */       
/* 80:81 */       Multipart mainPart = new MimeMultipart();
/* 81:   */       
/* 82:83 */       BodyPart html = new MimeBodyPart();
/* 83:   */       
/* 84:85 */       html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
/* 85:86 */       mainPart.addBodyPart(html);
/* 86:   */       
/* 87:88 */       mailMessage.setContent(mainPart);
/* 88:   */       
/* 89:90 */       Transport.send(mailMessage);
/* 90:   */       
/* 91:92 */       return true;
/* 92:   */     }
/* 93:   */     catch (MessagingException ex)
/* 94:   */     {
/* 95:94 */       ex.printStackTrace();
/* 96:   */     }
/* 97:96 */     return false;
/* 98:   */   }
/* 99:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     email.SimpleMailSender
 * JD-Core Version:    0.7.0.1
 */