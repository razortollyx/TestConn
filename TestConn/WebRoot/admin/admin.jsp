<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	HttpSession hs = request.getSession(true);
	AdminBean ab = (AdminBean) hs.getAttribute("user");
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>人工智能学院毕业选题系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- 引用 dtree -->
<link rel="stylesheet" type="text/css" href="dtree/dtree.css">
<script type="text/javascript" src="dtree/dtree.js"></script>
<!-- 引入日历控件 -->

<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>



<style type="text/css">
<!--
.gradient { /*   width:1680px;
    height:1050px; */
	filter: alpha(opacity = 60 finishopacity = 100 style = 1 startx = 0, starty = 0,
		finishx = 0, finishy = 150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#235E98,
		endcolorstr=#DEEBF3, gradientType=0 );
	-ms-filter: alpha(opacity = 60 finishopacity = 100 style = 1 startx = 0, starty = 0,
		finishx = 0, finishy = 150) progid:DXImageTransform.Microsoft.gradient(startcolorstr=#235E98,
		endcolorstr=#DEEBF3, gradientType=0 ); /*IE8*/
	background: #006600; /* 一些不支持背景渐变的浏览器 */
	background: -moz-linear-gradient(top, rgba(35, 94, 152, 1),
		rgba(222, 235, 243, 0.6) ); /*Firefox*/
	background: -webkit-gradient(linear, 0 0, 0 bottom, from(rgba(35, 94, 152, 1)
		), to(rgba(222, 235, 243, 0.6) ) ); /*chrome Safari*/
	background: -o-linear-gradient(top, rgba(35, 94, 152, 1),
		rgba(222, 235, 243, 0.6) ); /*Opera11*/
}
//
-->
</style>
<!-- <body> -->
<body class="gradient">


	<div align="left">
		<img src="images/banner.png" height="10%" /> <span
			style="position: absolute; center: 300px; top: 30px; font-size: 24px; font-weight: bolder; color: White; font-family: 楷体, 楷体_GB2312;">
			欢迎使用双向选题系统 </span>
	</div>

	<!--  <table width="80%" border="0" align="center" cellpadding="0"
		cellspacing="0"  >
		<tr>
		<td colspan="2" align="left"><div align="left" style="box-shadow:2px 1px 1px #C7EDCC;text-align:center;"><img src="images/myview.jpg" width="100%" height="100%" />
				</div></td>
		</tr>
</table>
-->
	&nbsp; &nbsp;
</head>
<%
	String center = request.getParameter("function") + ".jsp";
%>
<body>
	<table width="100%" border="1" align="left" cellpadding="0"
		cellspacing="0"
		style="border: 8px #CFDFF4 groove; border-radius: 5px; background-color: #eee;">
		<tr>
			<td colspan="2" height="30px"><div align="center">&nbsp;<%=ab.getYuanxi()%>管理员，欢迎您使用双向选题系统
				</div>
				<div align="right">
					<a href="logout.jsp" style="color: #000000;"
						onClick="{if(confirm('确实要注销吗？')){return true;}return false;}">注销</a>
				</div></td>
		</tr>
		<tr>
			<td colspan="2" height="30px" align="center"><marquee
					onmouseout=this.start() onmouseover=this.stop() behavior="scroll"
					width="80%" height="20px" SCROLLDELAY="90" style="color: #FF6600;"><%=Tools.getScrollNotice(ab.getYuanxi())%></marquee>
			</td>
		</tr>
		<tr>
			<td width="15%" height="600px" valign="top" bgcolor="#E1EEFB">
				<div align="left">
					<!-- 引入menu.jsp页面 -->
					<jsp:include page="menu.jsp"></jsp:include>
				</div>
			</td>
			<td width="85%" height="100%" valign="top" bgcolor="#DCE3EF">
				<div align="left">
					<jsp:include page="<%=center%>"></jsp:include>
				</div>
			</td>
		</tr>
	</table>
	<table width="60%" height="85" border="0" align="center"
		style="font-size: 12px">
		<tr bordercolor="#F0F0F0">
			<td>
				<div align="center" class="STYLE1">版权所有
					www.paperlayout.com 鄂ICP备17006782号-1</div>
			</td>
		</tr>
	</table>
</body>
</html>
