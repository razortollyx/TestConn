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

	String[] color = { "#D3F0F3", "#E6F3FF" };//�����ɫ
	int tesekk=0;
	//����4����Ҳ���õ��ı���
	
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
	  alert("��ѧ���ѱ�������ʦָ����"); 
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
 </script>  
   
    <%
    
	}else{
	%>
	<script type="text/javascript">
	  alert("ָ���ɹ���");
      window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script>
	 <% 
	}   
    
    
    
	%>
	
	
	








        
        
        
            
       
     
    </body>
</html>
