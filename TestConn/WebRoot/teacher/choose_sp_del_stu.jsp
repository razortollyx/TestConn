<%@ page language="java" import="java.util.*,com.kk.subject.model.*,com.ax.subject.model.*"
	pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	HttpSession hs = request.getSession(true);

%>




<%
	String sub_id=request.getParameter("sub_id");
	String stu_id=request.getParameter("stu_id");
	session.setAttribute("sub_id", sub_id);
	session.setAttribute("stu_id", stu_id);
	if( ("".equals(sub_id) == false)  ){
		System.out.println(sub_id);
	}
	else {
	   
		System.out.println(sub_id);
	}
		
	System.out.println("sub_id"+sub_id);
	System.out.println("stu_id"+stu_id);
	
	int j = new StuspBeanCI().delStuSpById(sub_id);
	int j1=	 new StuspBeanCI().delStuSubById(sub_id,stu_id);
    if(j!=-1){
    %>
    <script type="text/javascript">
	  alert("撤回成功！可以重新指派学生！"); 
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
    </script>  
    
    
    <%
    
    
    }
		
		
	   
	 %>

 <table>
		<tr>
		<th>查无此学生！请您核对学生学号，点击<a
			href="teacher/teacher.jsp?function=choose_sp_stu">特招选生</a>再次输入学生学号！</th>
	</tr>
 </table>    
	
        
        
        
            
       
     
    </body>
</html>
