<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<table>
	<div align="left">
		
		<p><big><strong>选题系统说明：</strong></p>
	

<p>1.学生操作时间：学生选题阶段能进行操作，其他时间只能够进行浏览，请在规定时间内选择毕业论文题目。</p>
<p>2.学生选择志愿数：最多为六个志愿，按照第一志愿至第六志愿进行分布。</p>
<p>3.在特招阶段，只能够看题，不能够选题，请及时填写自己的联系方式，与导师提前联系，方便导师确认信息进行指派。</p>
<p>4.志愿匹配规则：</p>
<p>优先匹配学生的第一志愿，按照教师分配的志愿选择最优的学生。若学生第一志愿落选，则匹配学生的第二志愿，以此类推</p>
		
		
		<!-- <p>1、各阶段的任务（时间控制）</p>
		<p>2、已加密</p>
		<p>3、学生管理-班级管理里，对于班级信息的操作只有删除，没有修改项(未完成)</p>
		<p>4、所有题目（需要添加查找功能？）</p> -->

		<img src="images/xuanti.png" height="100%"  /> 
	</div>

</table>