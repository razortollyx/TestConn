<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	HttpSession hs = request.getSession(true);
	TeacherBean tb = (TeacherBean) hs.getAttribute("user");
	int stage = new StageBeanCl().getCurrentStage(tb.getDepartment());  //获取当前的阶段
	int[] subIds = new TeacherSubBeanCl().getS_id(tb.getId());
	String yuanxi=session.getAttribute("yuanxi").toString();
	
	 ArrayList<StuWishBean> arrSSTB;
	 
	
	 
%>

<script type="text/javascript">

	function delConf(){
		return window.confirm("删除将不能恢复，确定要删除吗？");
	}
	function modifyConf(state){
		if(state!="0")
		return window.confirm("修改操作将使得审核状态为“待审核”，确定要修改吗？");
	}

</script>
<%
	for(int K:subIds)
	{System.out.print("K:"+K);}
	if (subIds == null) {
%>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<th>您暂未出题，点击<a href="teacher/teacher.jsp?function=sub_add">添加题目</a>添加题目开始出题吧！</th>
	</tr>

</table>
<%
	} else {
%>

<br><br>
<table width="100%" border="1">
	<tr>
		<td colspan="8"><div align="center">我的题目</div></td>
	</tr>
	<tr>
		<td><div align="center">编号</div></td>
		<td><div align="center">标题</div></td>
		<td><div align="center">题目方向</div></td>
		
		<td><div align="center">选题人数</div></td>

        <td><div align="center">当前选题状态</div></td>
		
		<td><div align="center">出题时间</div></td>
		<td><div align="center">审核状态</div></td>
		<td><div align="center">操作</div></td>
                
	</tr>
	<%
		for (int i = 0; i < subIds.length; i++) {
				SubjectBean sb = new SubjectBeanCl().getSubjectById(String.valueOf(subIds[i]));
					
				int ttkk00=subIds[i];
				arrSSTB = new StuWishBeanCI().getStuWishById(String.valueOf(sb.getId()));
				
	%>
	<tr>
		<td align="center"><%=sb.getId()%></td>
		
		<td><div align="center">
				<a href=<%=path + "/common/sub_detail.jsp?id=" + sb.getId()%>
					target="_blank"><%=sb.getTitle()%></a>
			</div></td>
		
		<td><div align="center"><%=sb.getDirection()%></div></td>
		
		<td><div align="center"><%=arrSSTB.size()%>
			</div></td>
		
		<td><div align="center">
				<a href=<%=path + "/teacher/teacher.jsp?function=sub_state&ttkk00="+ttkk00 %>
					target="_blank">详情查看</a>
			</div></td>


		<td><div align="center"><%=sb.getTime()%></div></td>
		
		<td><div align="center"><%=(sb.getState() == -1) ? "未通过"
							: (sb.getState() == 0 ? "待审核" : "通过")%></div></td>
		<td>

			<div align="center">
			<%if(sb.getState() !=1) {%>
				<a onclick="return delConf();"
					href="TeaSubManageServlet?flag=sub_del&id=<%=sb.getId()%>">删除</a>
				
				<a onclick="return modifyConf(<%=sb.getState()%>);"
				
					href="teacher/teacher.jsp?function=sub_modify&id=<%=sb.getId()%>">修改</a>	<%} %>
					<a href=<%=path + "/common/document.jsp?id=" + sb.getId()%>
					target="_blank">打印</a>
			</div>
		</td>
	</tr>
	<%
		}
	%>

	

	<tr>
		<td colspan="8"><div align="left">
				您总共出了<%=subIds.length%>道题，还可以出<%=tb.getMaxSubNum() - subIds.length%>道题。
			</div></td>
	</tr>
</table>
<%}%>


