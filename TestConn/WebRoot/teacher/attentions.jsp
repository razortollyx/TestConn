<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<table>
	<div align="left">
		<p>注意：</p>
		<p>1、系统分为了学生选题阶段和教师分配志愿阶段</p>
		<p>2、教师出的题目，必须经过院级管理员审核才能被学生选择（管理员要审核）</p>
		<p>3、学生：可以选择6个题目志愿。</p>
		<p>4、教师：可以为同一个题目分配3个题目志愿，若教师已经分配第一志愿，当再次分配第一志愿时会覆盖之前的选择，其余志愿同理</p>
		<p>5、匹配规则：优先匹配学生的第一志愿，按照教师分配的志愿选择最优的学生。若学生第一志愿落选，则匹配学生的第二志愿，以此类推</p>
		<!-- <p>1、各阶段的任务（时间控制）</p>
		<p>2、已加密</p>
		<p>3、学生管理-班级管理里，对于班级信息的操作只有删除，没有修改项(未完成)</p>
		<p>4、所有题目（需要添加查找功能？）</p> -->

		<img src="images/xuanti.png" height="100%"  /> 
	</div>

</table>