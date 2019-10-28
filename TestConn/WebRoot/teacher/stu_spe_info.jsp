<%@ page language="java" import="java.util.*,com.ax.subject.model.*" 
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession hs = request.getSession(true);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  response.setContentType("text/html;charset=UTF-8");
  request.setCharacterEncoding("UTF-8");
  String stu_id=null;

  
  
  //String stu_class=null;
  stu_id=request.getParameter("stu_id").trim();
  String stu_name =request.getParameter("stu_name").trim();
  
  System.out.println(stu_name);
  session.setAttribute("stu_name", stu_name);
  session.setAttribute("stu_id", stu_id);
  String yuanxi = (String)session.getAttribute("yuanxi");
  

  System.out.println("stu_id:"+stu_id);
  
  
  System.out.println("stu_name:"+stu_name);
  if("".equals(stu_name) == true ){
  	System.out.println("   1 stuname null");
  }else {
  System.out.println("   2 stuname !");
  //System.out.println(stu_class);
}
  if("".equals(stu_id) == true ){
  	System.out.println("   1 stu id null");
  }else {
  System.out.println("   2 stu id !");
  //System.out.println(stu_class);
}
  
   %>
  
 
  

<table border="2" cellspacing="0" width="15%" >
<h3></h3>

	<%
	    
		if( ("".equals(stu_id) == false) && ("".equals(stu_name) == true) ){ // false true
		
		

		StudentBean tb = new StudentBeanCl().getStudentById(stu_id);

		
	    if(tb == null ){
	 %>
<script type="text/javascript">
	  alert("查无此学生！请您核对学生学号"); 	
	   window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script> 
 <table>
		<tr>
		<th>查无此学生！请您核对学生学号，点击<a
			href="teacher/teacher.jsp?function=choose_sp_stu">特招选生</a>再次查询学生信息！</th>
	</tr>
          </table>    
	 <%  
	 //response.sendRedirect("student/student.jsp?function=sub_all"); &&  ("".equals(stu_name) == true)
	
	System.out.println(1);
    } else {
    System.out.println(tb.getId());
	%>
	
	<tr>
		<td width="80%">账&nbsp&nbsp号：</td>
		<td><%=tb.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
		<tr></tr>
	<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	<% 
	}  
	}   
    
	%>
	
	<%
	if("".equals(stu_id) == true &&  "".equals(stu_name) == false){ //true false
		
		

		 StudentBean tb = new StudentBeanCl().getStudentByName(stu_name);
	     if(tb == null){
         
	 %>
	<script type="text/javascript">
	 alert("查无此学生！请您核对学生姓名");
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
   	</script> 
   	<table>
		<tr>
		<th>查无此学生！请您核对学生姓名，点击<a
			href="teacher/teacher.jsp?function=choose_sp_stu">特招选生</a>再次查询学生信息！</th>
	</tr>
          </table>  
   	<%  
   	response.sendRedirect("/teacher/teacher.jsp?function=choose_sp_stu");
	
    } else {
	%>
	
	<tr>
		<td width="100%">账&nbsp&nbsp号：</td>
		<td><%=tb.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
		<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	<%
	}  
	}
	%>
	
	<%
		if( ("".equals(stu_id) == true) && ("".equals(stu_name) == true) ){// true true
		
	    ArrayList<StudentBean> arrSSTB;
	 
	    

		TeacherBean tb = (TeacherBean) hs.getAttribute("user");
		arrSSTB = new StudentBeanCl().getAllStudent(yuanxi);

		
		
	    if(arrSSTB == null){
	 %>
<script type="text/javascript">
	  alert("查无此学生！请您核对学生学号"); 	
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script> 
	 <%  
	 //response.sendRedirect("student/student.jsp?function=sub_all"); &&  ("".equals(stu_name) == true)
	
	System.out.println(1);
    } else {
    %>
 <script type="text/javascript">
	  alert("您的输入为空，请您输入姓名或者学号进行搜索！"); 	
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script>    
    
    
    <%
 
	}   
    }
	%>
	
	<%
		if( ("".equals(stu_id) == false) && ("".equals(stu_name) == false) ){//false false
		StudentBean tb = new StudentBeanCl().getStudentById(stu_id);
		StudentBean tb1 = new StudentBeanCl().getStudentByName(stu_name);
	    
		
	
	if(tb!=null && tb1!=null){
	if((tb.getId()).equals(tb1.getId())){
	%>
	
		<tr>
		<td width="80%">账&nbsp&nbsp号：</td>
		<td><%=tb.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
		<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	<% 
	}else{
	
	%>
	<script type="text/javascript">
alert("姓名与学号不匹配！我们为您提供了学号与姓名的搜索结果：");
</script> 
	<tr>
	<td colspan='2'><center>学号匹配</center></td>
	
	
	</tr>
	<tr>
		<td width="80%">账&nbsp&nbsp号：</td>
		<td><%=tb.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
		<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	<tr>
	<td colspan='2'><center>姓名匹配</center></td>
	
	
	</tr>

	

	<tr>
		<td width="80%">账&nbsp&nbsp号：</td>
		<td><%=tb1.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb1.getName()==null?"":tb1.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb1.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb1.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb1.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb1.getPhoneNum()==null?"":tb1.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb1.getEmail()==null?"":tb1.getEmail()%></td>
	</tr>
		<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	
	
	
	<%
	}}else{
	if(tb==null && tb1!=null){
		
	%>
	<script type="text/javascript">
	  alert("查无此学号！请您核对学生学号，我们为您提供了该名称的搜索内容如下："); 	
 </script> 
 <tr>
		<td width="100%">账&nbsp&nbsp号：</td>
		<td><%=tb1.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb1.getName()==null?"":tb1.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb1.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb1.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb1.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb1.getPhoneNum()==null?"":tb1.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb1.getEmail()==null?"":tb1.getEmail()%></td>
	</tr>
		<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	
	<%
	}
	if(tb1==null && tb!=null){
	 %>
<script type="text/javascript">
alert("查无此学生姓名！，我们为您提供了该学号的搜索内容如下："); 	
</script> 
<tr>
		<td width="100%">账&nbsp&nbsp号：</td>
		<td><%=tb.getId() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
		<tr>
		<td>院系：</td>
		<td><%=tb.getYuanxi()==null?"":tb.getYuanxi()%></td>
	</tr>
	<%
	
	} 
	 
	}
	if(tb==null && tb1==null){
	%>
<script type="text/javascript">
alert("查无此学生姓名！查无此学生学号！请您核对学生姓名与学号：");
 window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
</script> 
<table>
		<tr>
		<th>查无此学生姓名！查无此学生学号！请您核对学生信息，点击<a
			href="teacher/teacher.jsp?function=choose_sp_stu">特招选生</a>再次查询学生信息！</th>
	</tr>
          </table>  
	<% 	
	}
	}   
    
	%>
	

</table>
</html>
