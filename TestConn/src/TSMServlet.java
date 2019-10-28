/*    */ import com.kk.subject.model.SubjectBeanCl;
/*    */ import com.kk.subject.model.TeacherBean;
/*    */ import java.io.IOException;
/*    */ import java.sql.Date;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class TSMServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 29 */     doPost(request, response);
/*    */   }
/*    */   
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 46 */     request.setCharacterEncoding("UTF-8");
/*    */     
/*    */ 
/* 49 */     String flag = request.getParameter("flag");
/* 50 */     String sql = "";
/*    */     
/* 52 */     HttpSession session = request.getSession(true);
/* 53 */     String t_id = ((TeacherBean)session.getAttribute("user")).getId();
/* 54 */     if (flag.equals("sub_modify1"))
/*    */     {
/* 55 */       String id = request.getParameter("id");
/* 56 */       String title = request.getParameter("title");
/* 57 */       String direction = request.getParameter("direction");
/* 58 */       String introduction = request.getParameter("introduction");
/* 59 */       String schedule = request.getParameter("schedule");
/* 60 */       String reference = request.getParameter("reference");
/* 61 */       String requirement = request.getParameter("requirement");
/* 62 */       String domain = request.getParameter("domain");
/* 63 */       Date time = new Date(System.currentTimeMillis());
/* 64 */       sql = "update t_subject set title='" + title + "',direction='" + direction + "',introduction='" + introduction + 
/* 65 */         "',schedule='" + schedule + "',reference='" + reference + "',requirement='" + requirement + 
/* 66 */         "',domain='" + domain + "',time='" + time + "',state='1' where id='" + id + "'";
/* 67 */       new SubjectBeanCl().modifySubject(sql);
/*    */       
/*    */ 
/* 70 */       response.sendRedirect("modify_success.jsp");
/*    */     }
/*    */   }
/*    */ }


/* Location:           C:\Users\hequanchuan\Desktop\毕业选题网站\源代码\ROOT\WEB-INF\classes\
 * Qualified Name:     TSMServlet
 * JD-Core Version:    0.7.0.1
 */