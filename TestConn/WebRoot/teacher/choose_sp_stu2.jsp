<%@ page language="java" import="java.util.*,com.kk.subject.model.*,com.ax.subject.model.*"
	pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	//	HttpSession hs = request.getSession(true);
	HttpSession hs = request.getSession(true);
	
	
	
		
//	}

	String[] color = { "#D3F0F3", "#E6F3FF" };//交替变色
	int tesekk=0;
	//定义4个分也会用到的变量
	
%>




	<%
	
	System.out.println("1:"+tesekk);
	String sub_id=request.getParameter("sub_id");
	String stu_id=request.getParameter("stu_id");
	session.setAttribute("stu_id", stu_id);
	
	System.out.println("tesekk:"+tesekk); 
	com.ax.subject.model.StudentBean tb = new com.ax.subject.model.StudentBeanCl().getStudentById(stu_id);
	int i=new StuspBeanCI().setStuSpById(sub_id,stu_id,tb.getYuanxi());
    int j=new StuspBeanCI().setStuSubById(sub_id,stu_id,tb.getYuanxi());
    System.out.println("j:"+j);
    if(i==-1 ){
    %>
 <script type="text/javascript">
	  alert("此学生已被其他老师指定！"); 
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
 </script>  
   
    <%
    
	}else{
	%>
	<script type="text/javascript">
	  alert("指定成功！");
      window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script>
	 <% 
	}   
    
    
    
	%>
	
	
	








        
        
        
            
       
     
    </body>
</html>
