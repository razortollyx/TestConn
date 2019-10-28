<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String yuanxi=session.getAttribute("yuanxi").toString();
%>

<script type="text/javascript">
	function check() {
			document.form1.action = "TeaManageServlet?flag=admin_modify";
			document.form1.submit();
	}
</script>

<form action="TeaManageServlet?flag=admin_modify" method="post" name="form1">


	<table border="1">
		<%
			response.setCharacterEncoding("UTF-8");

			String[] jtArr = new JobTitleBeanCl().getAllJT(yuanxi);
			ArrayList<Department> depArr = new DepartmentCl().getAllDep(yuanxi);

			String teaId = request.getParameter("teaId");
			AdminBean tb = new AdminBeanCl().getAdminById(teaId);
		%>
		<tr>
			<th colspan="2" scope="col"><div align="left">管理员信息修改</div>
			</th>
		</tr>
		<tr>
			<td width="100">账&nbsp;&nbsp;号</td>
			<td align="center"><input type="text" border="1" name="id"
				readonly="readonly" value="<%=teaId%>">
			</td>
		</tr>
		<tr>
			<td width="100">密&nbsp;&nbsp;码</td>
			<td><input type="text" border="1" name="psw"
				value="<%=tb.getPsw()%>">
			</td>
		</tr>
		<tr>
			<td>姓&nbsp;&nbsp;名</td>
			<td><input type="text" border="1" name="name"
				value="<%=tb.getName()%>">
			</td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td>电话号码</td>
			<td><input type="text" border="1" name="phoneNum"
				value="<%=tb.getPhoneNum()%>"
				onkeyup="value=value.replace(/[^\d]/g,'') ">
			</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td><input type="text" border="1" name="email"
				value="<%=tb.getEmail()%>">
			</td>
		</tr>	
			<tr align="center">
				<td><input type="submit" value="保存修改">
				</td>
				<td><input type="reset" value="重    置"></td>
			</tr>
	</table>
</form>
