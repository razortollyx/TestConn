<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="UTF-8"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	//response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");//传值编码
	response.setContentType("text/html;charset=UTF-8");//设置传输编码
%>
<script type="text/javascript">
	function createXmlHttpRequest() {
		var xmlreq = false;
		if (window.XMLHttpRequest) {
			xmlreq = new XMLHttpRequest();
		} else if (window.ActiveXobject) {
			try {
				xmlreq = new ActiveXobject("Msxm12.XMLHTTP");
			} catch (e1) {
				try {
					xmlreq = new ActiveXobject("Miscoft.XMLHTTP");
				} catch (e2) {
				}
			}
		}
		return xmlreq;
	}

	//检测类型是否已经存在
	function chenkExist() {

		var adminId = document.getElementById("adminId").value;
		//alert(newID);
		if (adminId == "" || adminId== null) {
			document.getElementById("checkResult").innerHTML = "不能为空";
		} else {
			var request = createXmlHttpRequest();//创建request的对象
			request.open("post",
					"ExistCheckServlet?flag=admin_exist_check&adminId=" + adminId);
			request.send();
			request.onreadystatechange = function() {
				if (request.readyState == 4 & request.status == 200) {
					var value = request.responseText;
					if (value == "true") {
						document.getElementById("checkResult").innerHTML = "账号已存在";
					}
				} else {
					document.getElementById("checkResult").innerHTML = "√";
				}
			}
		}
	}
	//检测类型是否已经存在
	function chenkExist1() {
		var yuanxi = document.getElementById("yuanxi").value;
		if (yuanxi == "" || yuanxi== null) {
			document.getElementById("checkResult1").innerHTML = "不能为空";
		} else {
			var request = createXmlHttpRequest();//创建request的对象
			request.open("post",
					"ExistCheckServlet?flag=yuanxi_exist_check&yuanxi=" + yuanxi);
			request.send();
			request.onreadystatechange = function() {
				if (request.readyState == 4 & request.status == 200) {
					var value = request.responseText;
					if (value == "true") {
						document.getElementById("checkResult1").innerHTML = "院系已存在";
					}
				} else {
					document.getElementById("checkResult1").innerHTML = "√";
				}
			}
		}
	}

	function adminAddConf() {
		var checkResult = document.getElementById('checkResult').innerHTML;
		var checkResult1 = document.getElementById('checkResult1').innerHTML;
		if (checkResult == "账号已存在") {
			alert("账号已存在");
		} else if (checkResult == "不能为空") {
			alert("账号不能为空");
			
		} else if (checkResult1 == "不能为空") {
			alert("院系不能为空");
		} else if(checkResult1 == "院系已存在") {
			alert("院系已存在");
		} else if (checkResult == "√"&&checkResult1=="√") {
			document.form1.action = "TeaManageServlet?flag=admin_add";
			document.form1.submit();
		}
	}
</script>
<form name="form1" method="post">
	<table border="1">
		<%
			HttpSession hs = request.getSession(true);
			response.setCharacterEncoding("UTF-8");
		%>
		<tr>
			<td width="100">账&nbsp;&nbsp;号</td>
			<td><input type="text" border="1" name="adminId" id="adminId"
				onblur="chenkExist()"> <label id="checkResult"
				style="color:#FF6600;">*</label>
			</td>
		</tr>
		<tr>
			<td width="100">密&nbsp;&nbsp;码</td>
			<td><input type="text" border="1" name="psw">
			</td>

		</tr>

		<tr>
			<td>姓&nbsp;&nbsp;名</td>
			<td><input type="text" border="1" name="name">
			</td>
		</tr>
		<tr>
			<td>性&nbsp;&nbsp;别</td>
			<td align="center"><select name="sex">
					<option value="男">男</option>
					<option value="女">女</option>
			</select></td>
		</tr>
		<tr>
			<td>电话号码</td>
			<td><input type="text" border="1" name="phoneNum"
				onkeyup="value=value.replace(/[^\d]/g,'') ">
			</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td><input type="text" border="1" name="email">
			</td>
		</tr>
		<tr>
			<td>所属院</td>
			<td align="center"><input  id="yuanxi" type="text" border="1" onblur="chenkExist1()" name="yuanxi">
			<label id="checkResult1"
				style="color:#FF6600;">*</label>
			</td>
		</tr>
		<tr align="center">
			<td><input type="reset" value="重    置"></td>
			<td><input type="submit" onclick="adminAddConf()" value="提    交">
			</td>
		</tr>
	</table>
</form>