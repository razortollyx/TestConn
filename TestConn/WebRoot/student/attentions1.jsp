<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<table>
	<div align="left">
		
		<p><big><strong>选题系统操作指南：</strong></p>
		<p><strong>个人信息：</strong></p>
		<p>(1)点击 个人信息->我的信息 查看基础信息是否有误。</p>
		<p>(2)点击 个人信息->信息修改 对姓名、性别、班级有误的地方进行修改，添加 电话号码、电子邮箱，方便导师与您联系，邮箱是您<strong>找回密码</strong>与<strong>老师确认信息</strong></p>
		<p>的重要凭证，请如实填写。</p>
		<p>(3)点击 个人信息->密码修改 对原有密码进行修改。</p>
        <img src="images/stu/geren1.png" height="70%" style="border:3px solid #000;" /> 
        
		<p><strong>选题：</strong></p>
		<p>(4)点击 选题->选择题目志愿 在所有题目下可以对老师、题目方向、题目名称进行精确搜索 点击标题可以查看具体毕业论文题目信息；</p>
		<p>点击<strong>出题人</strong>可以查看命题导师相关信息，已选人数这里提示的是当前题目已有学生选题的总数，点击<strong>志愿分布</strong>可以查看每个题目具体志愿分布信息。</p>
		<p>点击志愿下的选择可以根据 第一志愿至第六志愿进行选题。选中题目以后，会将选题结果列在已选题数下面，在选题阶段可以进行、撤销重选等操作。</p>
		<p>(5)点击 选题->查看已选题数 可以查看到当前选题情况。</p>
		<p>(6)点击 选题->选题结果 可以在管理员分配志愿阶段后，对选上的毕业论文题目进行查看。</p>
		<p><img src="images/stu/xuanze1.png" height="60%" style="border:3px solid #000;" /></p>
		<p><img src="images/stu/xuanze2.png" height="60%" style="border:3px solid #000;" /></p>
		<p><img src="images/stu/xuanze3.png" height="60%" style="border:3px solid #000;" /></p>
		<p><img src="images/stu/xuanze4.png" height="60%" style="border:3px solid #000;" /></p>
		<p><img src="images/stu/xuanze5.png" height="60%" style="border:3px solid #000;" /></p>
		<p><img src="images/stu/xuanze6.png" height="60%" style="border:3px solid #000;" /></p>
		<p><img src="images/stu/tezhao1.png" height="60%" style="border:3px solid #000;" /></p>
		<p>已特招题目查看</p>
		
		<p><img src="images/stu/xuanze7.png" height="60%" style="border:3px solid #000;" /></p>
		<p>非选题阶段提示</p>
		<p><img src="images/stu/xuanze8.png" height="60%" style="border:3px solid #000;" /></p>
		<p></>非选题阶段只能够浏览</p>
		<p><img src="images/stu/xuanze9.png" height="60%" style="border:3px solid #000;" /></p>
		<p></>公布志愿阶段查看结果</p>

		<p><strong>选题信息：</strong></p>
		<p>(7)点击 选题信息->通告信息 可以查看管理员发布的相关通告信息。</p>
		<p>(8)点击 选题信息->选题阶段 可以查看本次毕业论文题目选题阶段及选题时间分布。</p>
		<img src="images/stu/xuanti1.png" height="60%" style="border:3px solid #000;" /> 
		<p>查看选题信息</p>
		<!-- <p>1、各阶段的任务（时间控制）</p>
		<p>2、已加密</p>
		<p>3、学生管理-班级管理里，对于班级信息的操作只有删除，没有修改项(未完成)</p>
		<p>4、所有题目（需要添加查找功能？）</p> -->

		
	</div>

</table>