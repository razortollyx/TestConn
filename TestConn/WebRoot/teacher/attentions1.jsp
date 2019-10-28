<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<table>
	<div align="left">
<p>	<strong>	选题系统说明：</strong></p>
<p>1.教师操作时间： </p>
<p><strong>教师出题阶段</strong>，新增\修改\删除题目信息。<strong>特招阶段</strong>：挑选指定学生作为该题目的第一志愿，一旦指定，其他学生选择时将会提示该题目已有学生被老师指定的提示。<strong>教师挑选学生阶段</strong>：挑选已选中该题目的学生志愿，按照第一、第二、第三志愿进行分配。<strong>其他时间只能够进行浏览。</strong></p>
<p>2.教师挑选学生志愿数：<strong>最多为三个志愿</strong>，按照第一志愿至第三志愿进行分布。</p>
<p>3.在特招阶段，导师可以根据学生的学号或者姓名对学生进行查找，并且查看相关信息，确认无误后进行指定。</p>
<p>4.志愿匹配规则：</p>
		<p>优先匹配学生的第一志愿，按照教师分配的志愿选择最优的学生。若学生第一志愿落选，则匹配学生的第二志愿，以此类推</p>
		<!-- <p>1、各阶段的任务（时间控制）</p>
		<p>2、已加密</p>
		<p>3、学生管理-班级管理里，对于班级信息的操作只有删除，没有修改项(未完成)</p>
		<p>4、所有题目（需要添加查找功能？）</p> -->

		<img src="images/xuanti.png" height="100%"  /> 
	</div>

</table>