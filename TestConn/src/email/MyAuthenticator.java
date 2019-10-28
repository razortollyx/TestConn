/*  1:   */ package email;
/*  2:   */ 
/*  3:   */ import javax.mail.Authenticator;
/*  4:   */ import javax.mail.PasswordAuthentication;
/*  5:   */ 
/*  6:   */ public class MyAuthenticator
/*  7:   */   extends Authenticator
/*  8:   */ {
/*  9: 6 */   String userName = null;
/* 10: 7 */   String password = null;
/* 11:   */   
/* 12:   */   public MyAuthenticator() {}
/* 13:   */   
/* 14:   */   public MyAuthenticator(String username, String password)
/* 15:   */   {
/* 16:12 */     this.userName = username;
/* 17:13 */     this.password = password;
/* 18:   */   }
/* 19:   */   
/* 20:   */   protected PasswordAuthentication getPasswordAuthentication()
/* 21:   */   {
/* 22:16 */     return new PasswordAuthentication(this.userName, this.password);
/* 23:   */   }
/* 24:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     email.MyAuthenticator
 * JD-Core Version:    0.7.0.1
 */