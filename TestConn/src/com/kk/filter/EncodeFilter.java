/*  1:   */ package com.kk.filter;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import javax.servlet.Filter;
/*  5:   */ import javax.servlet.FilterChain;
/*  6:   */ import javax.servlet.FilterConfig;
/*  7:   */ import javax.servlet.ServletException;
/*  8:   */ import javax.servlet.ServletRequest;
/*  9:   */ import javax.servlet.ServletResponse;
/* 10:   */ 
/* 11:   */ public class EncodeFilter
/* 12:   */   implements Filter
/* 13:   */ {
/* 14:13 */   private String encode = null;
/* 15:14 */   private boolean ignore = false;
/* 16:   */   
/* 17:   */   public void destroy()
/* 18:   */   {
/* 19:16 */     this.encode = null;
/* 20:17 */     this.ignore = false;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/* 24:   */     throws IOException, ServletException
/* 25:   */   {
/* 26:21 */     if ((!this.ignore) && 
/* 27:22 */       (request.getCharacterEncoding() == null)) {
/* 28:23 */       request.setCharacterEncoding(this.encode);
/* 29:   */     }
/* 30:26 */     chain.doFilter(request, response);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void init(FilterConfig filterConfig)
/* 34:   */     throws ServletException
/* 35:   */   {
/* 36:29 */     String encode = filterConfig.getInitParameter("encode");
/* 37:30 */     String ignore = filterConfig.getInitParameter("ignore");
/* 38:31 */     if (this.encode == null) {
/* 39:32 */       this.encode = encode;
/* 40:   */     }
/* 41:33 */     if (("1".equals(ignore)) || ("yes".equals(ignore))) {
/* 42:34 */       this.ignore = true;
/* 43:   */     }
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.filter.EncodeFilter
 * JD-Core Version:    0.7.0.1
 */