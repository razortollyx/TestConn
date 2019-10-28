/*   1:    */ package com.kk.filter;
/*   2:    */ 
/*   3:    */ import java.io.IOException;
/*   4:    */ import javax.servlet.Filter;
/*   5:    */ import javax.servlet.FilterChain;
/*   6:    */ import javax.servlet.FilterConfig;
/*   7:    */ import javax.servlet.ServletException;
/*   8:    */ import javax.servlet.ServletRequest;
/*   9:    */ import javax.servlet.ServletResponse;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import javax.servlet.http.HttpSession;
/*  13:    */ 
/*  14:    */ public class LoginFilter
/*  15:    */   implements Filter
/*  16:    */ {
/*  17: 15 */   String[] permitUrls = null;
/*  18: 16 */   boolean ignore = false;
/*  19: 17 */   String gotoUrl = null;
/*  20:    */   
/*  21:    */   public void destroy()
/*  22:    */   {
/*  23: 20 */     this.permitUrls = null;
/*  24: 21 */     this.ignore = false;
/*  25: 22 */     this.gotoUrl = null;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*  29:    */     throws IOException, ServletException
/*  30:    */   {
/*  31: 28 */     HttpServletRequest res = (HttpServletRequest)request;
/*  32: 29 */     HttpServletResponse resp = (HttpServletResponse)response;
/*  33: 32 */     if ((!this.ignore) && 
/*  34: 33 */       (!isPermitUrl(request)) && 
/*  35: 34 */       (filterCurrUrl(request)))
/*  36:    */     {
/*  37: 35 */       resp.sendRedirect(res.getContextPath() + this.gotoUrl);
/*  38: 36 */       return;
/*  39:    */     }
/*  40: 40 */     chain.doFilter(request, response);
/*  41:    */   }
/*  42:    */   
/*  43:    */   public boolean isPermitUrl(ServletRequest request)
/*  44:    */   {
/*  45: 44 */     boolean isPermit = false;
/*  46: 46 */     if ((this.permitUrls != null) && (this.permitUrls.length > 0)) {
/*  47: 47 */       for (int i = 0; i < this.permitUrls.length; i++) {
/*  48: 48 */         if (this.permitUrls[i].equals(currentUrl(request)))
/*  49:    */         {
/*  50: 49 */           isPermit = true;
/*  51: 50 */           break;
/*  52:    */         }
/*  53:    */       }
/*  54:    */     }
/*  55: 54 */     return isPermit;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public boolean filterCurrUrl(ServletRequest request)
/*  59:    */   {
/*  60: 59 */     boolean filter = false;
/*  61: 60 */     HttpServletRequest res = (HttpServletRequest)request;
/*  62: 61 */     Object user = res.getSession().getAttribute("user");
/*  63: 62 */     if (user == null) {
/*  64: 63 */       filter = true;
/*  65:    */     }
/*  66: 65 */     return filter;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String currentUrl(ServletRequest request)
/*  70:    */   {
/*  71: 75 */     HttpServletRequest res = (HttpServletRequest)request;
/*  72: 76 */     String task = request.getParameter("task");
/*  73: 77 */     String path = res.getContextPath();
/*  74: 78 */     String uri = res.getRequestURI();
/*  75: 79 */     if (task != null) {
/*  76: 80 */       uri = uri.substring(path.length(), uri.length()) + "?" + "task=" + task;
/*  77:    */     } else {
/*  78: 82 */       uri = uri.substring(path.length(), uri.length());
/*  79:    */     }
/*  80: 85 */     return uri;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void init(FilterConfig filterConfig)
/*  84:    */     throws ServletException
/*  85:    */   {
/*  86: 90 */     String ignore = filterConfig.getInitParameter("ignore");
/*  87: 91 */     String permitUrls = filterConfig.getInitParameter("permitUrls");
/*  88: 92 */     String gotoUrl = filterConfig.getInitParameter("gotoUrl");
/*  89: 94 */     if (("1".equals(ignore)) || ("yes".equals(ignore)) || ("true".equals(ignore))) {
/*  90: 95 */       this.ignore = true;
/*  91:    */     }
/*  92: 97 */     if ((permitUrls != null) && (permitUrls.length() > 0)) {}
/*  93: 98 */     this.permitUrls = permitUrls.split(",");
/*  94:    */     
/*  95:100 */     this.gotoUrl = gotoUrl;
/*  96:    */   }
/*  97:    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\源文件\ROOT\WEB-INF\classes\
 * Qualified Name:     com.kk.filter.LoginFilter
 * JD-Core Version:    0.7.0.1
 */