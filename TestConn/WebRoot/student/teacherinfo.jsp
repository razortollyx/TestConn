<%@ page language="java" import="java.util.*,com.ax.subject.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacherinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  String tea_id=request.getParameter("tea_id");
  System.out.println("收到的ID为："+tea_id);
   %>
<table border="0" width="20%" >
<h3></h3>
	<%
		

		TeacherBean tb = new TeacherBeanCl().getTeacherById(tea_id);
	  
	    System.out.println(tb.getId());

	%>
	

	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>职称：</td>
		<td><%=tb.getJobTitle()==null?"":tb.getJobTitle()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=SEX.toStringValue(tb.getSex())+"" %></td>
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

</table>
</html>
