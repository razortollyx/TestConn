<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<table>
	<div align="left">
		
		<!-- <p>1、各阶段的任务（时间控制）</p>
		<p>2、已加密</p>
		<p>3、学生管理-班级管理里，对于班级信息的操作只有删除，没有修改项(未完成)</p>
		<p>4、所有题目（需要添加查找功能？）</p> -->
<p><strong>	<big>选题系统说明：</strong></p>
<p>管理员拥有整个系统最高的权限，可以对学生、老师的信息进行添加修改（主要包括有 学生的班级、学生专业、班级人数、教师用户的添加、查询和修改等）,可以对教师出题进行审核，可以分配最后的志愿，可以调整指定落选学生的题目，发布整个系统可见的公告，可以设置选题阶段各个时间，可以设置教师出题最大题目数量，可以设置每个题目的选题人数。</p>

<p><strong>1 选题自动指派：</strong></p>
<p>在教师挑选学生阶段完成以后，使用该功能会按照志愿匹配规则进行自动匹配。</p>

<p><strong>2 落选学生的题目指派：</strong></p>
<p>在选题自动指派完成以后，会有部分落选学生与落选题目，左边是选择落选学生，右边是选择落选题目，挑选学生和题目以后，在下面的指派题目栏会将学生与题目信息完整显示，确认指派以后学生的毕业论文题目就会被指派到该题目。</p>

<p><strong>3 志愿匹配规则示意图：</strong></p>
<img src="images/xuanti.png" height="100%"  />

<p><strong>	<big>选题系统操作指南：</strong></p>
<p>1初始设置：</p>
<p>(1)点击 初始设置->选题阶段 可以对本年度毕业选题阶段时间进行设置。</p>
<p>(2)点击 初始设置->密码修改 可以对管理员用户的密码进行修改。</p>
<p>(3)点击 初始设置->通用设置 可以对志愿选择上限、题目选择上限、教师出题上限、题目方向、系名、教师职称、毕业生年级进行进行设置。</p>
<img src="images/xuanti.png" height="100%"  />
<p><strong>2 教师管理：</strong></p>
<p>(4)点击 教师管理->教师信息 可以查看、修改、删除教师的信息。</p>
<p>(5)点击 教师管理->添加教师账号 可以添加教师账号，并且可以设置系主任账号(拥有审题权限)。</p>

<p><strong>3 学生管理：</strong></p>
<p>(6)点击 学生管理->专业管理 可以对学生的专业进行查看、修改、添加、删除等操作。</p>
<p>(7)点击 学生管理->班级管理 可以对学生的班级人数、专业进行查看、修改、添加、删除等操作。</p>
<p>(8)点击 学生管理->学生信息 可以查看、修改、添加、删除学生的信息。</p>
<p>(9)点击 学生管理->添加学生 可以逐个添加学生的基本信息。</p>

<p><strong>4 题目管理：</strong></p>
<p>(10)点击 题目管理->题目审核 可以对本年度所有论文题目进行审核。</p>

<p><strong>5 选题统计：</strong></p>
<p>(11)点击 选题统计->所有题目 可以查看本年度所有的论文题目。</p>
<p>(12)点击 选题统计->选题状态 可以查看学生与导师之间的志愿选择分配情况，在教师挑选学生阶段完成以后点击自动分配志愿会按照匹配规则对题目进行匹配。</p>
<p>(13)点击 选题统计->落选学生 可以在 选题状态->自动分配志愿 阶段以后对落选的学生进行统计查看。</p>
<p>(14)点击 选题统计->落选题目 可以在 选题状态->自动分配志愿 阶段以后对落选的题目进行统计查看。</p>
<p>(15)点击 选题统计->落选与指派 可以在 选题状态->自动分配志愿 阶段以后对落选的学生与落选的题目进行一一指派，左边是选择落选学生，右边是选择落选题目，挑选学生和题目以后，在下面的 指派题目栏 会将学生与题目信息完整显示，确认指派以后学生的毕业论文题目就会被指派到该题目。</p>
<p>(16)点击 选题统计->选题结果 可以在各阶段查看到目前已经完成的选题的学生和题目信息查看。</p>

<p><strong>6 通知公告：</strong></p>
<p>(17)点击 通知公告->查看公告 可以对已经发布的公告进行查看。</p>
<p>(18)点击 通知公告->发布公告 可以发布新的公告信息。</p>
		 
	</div>

</table>