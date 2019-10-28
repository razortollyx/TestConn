<%@page import="com.kk.subject.model.StuSubBean"%>
<%@page import="com.kk.subject.model.StuSubBeanCl"%>
<%@page import="com.kk.subject.model.StuWishBean"%>
<%@page import="com.kk.subject.model.StuWishBeanCI"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	HttpSession hs = request.getSession(true);
	TeacherBean tb = (TeacherBean) hs.getAttribute("user");
	int stage = new StageBeanCl().getCurrentStage(tb.getDepartment())+1;  //获取当前的阶段
	int[] subIds = new TeacherSubBeanCl().getS_id(tb.getId());
	String yuanxi=session.getAttribute("yuanxi").toString();
	
	 ArrayList<StuWishBean> arrSSTB;
	 
	
	 
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">

	function delConf(){
		return window.confirm("删除将不能恢复，确定要删除吗？");
	}
	function modifyConf(state){
		if(state!="0")
		return window.confirm("修改操作将使得审核状态为“待审核”，确定要修改吗？");
	}
    
    var garyBox ;
var garyBoxHead;
var garyBoxTitleText;
var garyBoxClose;
var garyBoxIframe;

function createGaryBox()
{
document.body.innerHTML+="<div id=\"garyBox\" style=\"display:none\"><div id=\"garyBoxHead\"><h4 ><span id=\"garyBoxTitleText\">title</span></h4><h4><span id=\"garyBoxClose\">关闭</span></h4></div><div><iframe id=\"garyBoxIframe\" name=\"garyBoxIframe\"  width=\"100%\" height=\"100%\" frameBorder=\"0\" frameSpacing=\"0\" scrolling=\"auto\" marginHeight=\"0\" marginWidth=\"0\" ></iframe></div></div>";
    garyBox = document.getElementById("garyBox");
    garyBox.style.cssText="border:1px solid #369;width:400px;height:250px;background:#e2ecf5;z-index:1000;position:absolute;display:none;"; 

    garyBoxHead=document.getElementById("garyBoxHead"); 
    garyBoxHead.style.cssText="height:20px;background:#369;color:#000000;padding:5px 0 0 5px;";
    
    garyBoxTitleText=document.getElementById("garyBoxTitleText"); 
    garyBoxTitleText.style.cssText="float:left;";
    
    garyBoxClose = document.getElementById("garyBoxClose"); 
    garyBoxClose.style.cssText="cursor:pointer;float:right; margin-right:10px;";        
    
    garyBoxIframe=document.getElementById("garyBoxIframe");     
}    
    function showGaryBox(title,url,onClose,width,height)
{
      if(!garyBox)createGaryBox();
      if(!arguments[3]) width = 600;
      if(!arguments[4]) height = 300;
     
    garyBoxTitleText.innerHTML=title;
     
    garyBox.style.display = "block"; 
    garyBox.style.position = "absolute"; 
    garyBox.style.top = "50%"; 
    garyBox.style.left = "50%"; 
    garyBox.style.marginTop = (-height/2)+"px"; 
    garyBox.style.marginLeft = (-width/2)+"px";
    
    garyBox.style.width=width+'px';
    garyBox.style.height=height+'px'; 
    
    garyBoxIframe.style.width=garyBox.style.width;
    garyBoxIframe.style.height=garyBox.style.height;
 
    
    var garyBoxBg = document.createElement("div"); 
    garyBoxBg.setAttribute("id","garyBoxBg"); 
    garyBoxBg.style.background = "#ffffff"; 
    garyBoxBg.style.width = "100%"; 
    garyBoxBg.style.height = "100%"; 
    garyBoxBg.style.position = "absolute"; 
    garyBoxBg.style.top = "0"; 
    garyBoxBg.style.left = "0"; 
    garyBoxBg.style.zIndex = "500"; 
    garyBoxBg.style.opacity = "0.3"; 
    garyBoxBg.style.filter = "Alpha(opacity=30)"; 
    document.body.appendChild(garyBoxBg);
    document.body.style.overflow = "auto"; 
    
    garyBoxClose.onclick = function() 
    { 
        garyBox.style.display = "none"; 
        garyBoxBg.style.display = "none";     
        if(onClose)
        {
            onClose();
        }    
    }    
    garyBoxIframe.style.margin=0;
    garyBoxIframe.style.padding=0;
    garyBoxIframe.src=url;
    garyBoxIframe.onload=function(){
        
    }
}
</script>
<%
 if ( stage  == 3 ) {// stage == 3 
	if (subIds == null) {
%>
<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<th>您暂未出题，无法指定学生，点击<a href="teacher/teacher.jsp?function=sub_add">添加题目</a>添加题目开始出题吧！</th>
	</tr>

</table>

<%
	} else {
%>
<table id="testList" width="100%" height="120" border="1" cellpadding="0"
		cellspacing="0">
		<tr height="30px"></tr>
		<tr height="50px">
			<th colspan="7" height="50px" bgcolor="#E6F3FF"><div
					align="center" style="font-size: 35px">查&nbsp;找&nbsp;学&nbsp;生</div>
			</th>
		</tr>
		</table>
		<%
		
			Random ra =new Random();
			
		%>
<table width="100%" border="1">
<form  id="testt<%=ra.nextInt(20)+1%>" action=<%=path + "/teacher/teacher.jsp?function=stu_spe_info" %> 
method="post"  accept-charset="UTF-8">
		<tr>
			<td colspan="7" align="center">
				<table>
					<tr>
						<td><div>
								学生名称:<input name="stu_name" id="test1<%=ra.nextInt(20)+1%>" type="text" size="10" >
							</div>
						</td>
						<td><div>
								学生学号：<input name="stu_id" id="test2<%=ra.nextInt(20)+1%>" type="text" size="10" >
							</div>
						</td> 
						<!-- 	<td><div>
								学生班级：<input name="title" type="text" size="10" value="<%=3 %>">
							</div>
						</td> -->
						<td><div>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<td><div align="center"><input type="submit" value=" 查询 " /></div></td>	
							</div>
						</td>
					</tr>
					</form>
				</table></td>

		</tr>




<table width="100%" border="1">
	<table id="testList" width="100%" height="269" border="1" cellpadding="0"
		cellspacing="0">
		<tr height="30px"></tr>
		<tr height="70px">
			<th colspan="9" height="50px" bgcolor="#E6F3FF"><div
					align="center" style="font-size: 35px">指&nbsp;派&nbsp;学&nbsp;生</div>
			</th>
		</tr>
	<tr>
		<td><div align="center">编号</div></td>
		<td><div align="center">标题</div></td>
		<td><div align="center">题目方向</div></td>
		
		
		
		<td><div align="center">出题时间</div></td>
		<td><div align="center">审核状态</div></td>
		<td><div align="center">指定学生(输入学号)</div></td>
		
		<td><div align="center">操作</div></td>
                
	</tr>
	<%
		for (int i = 0; i < subIds.length; i++) {
				SubjectBean sb = new SubjectBeanCl().getSubjectById(String.valueOf(subIds[i]));
					
				int ttkk00=subIds[i];
				arrSSTB = new StuWishBeanCI().getStuWishById(String.valueOf(sb.getId()));
				
				StuspBean test1=new StuspBeanCI().getStuSpById(String.valueOf(sb.getId()));
			    if( test1.getStu_id() == null){
			    
	%>
	<tr>
		<td align="center"><%=sb.getId()%></td>
		
		<td><div align="center">
				<a href=<%=path + "/common/sub_detail.jsp?id=" + sb.getId()%>
					target="_blank"><%=sb.getTitle()%></a>
			</div></td>
		
		<td><div align="center"><%=sb.getDirection()%></div></td>
		
		


		<td><div align="center"><%=sb.getTime()%></div></td>
		
		<td><div align="center"><%=(sb.getState() == -1) ? "未通过"
							: (sb.getState() == 0 ? "待审核" : "通过")%></div></td>
		
		
							
		<form id="a1<%=i%>" action=<%=path + "/teacher/teacher.jsp?function=choose_sp_stu1&sub_id="+sb.getId() %>
		method="post">
		
		<td><div align="center"><input name="stu_id" id="a<%=i%>" type="text" size="10" required oninvalid="setCustomValidity('学生学号不能为空！');" oninput="setCustomValidity('');"  /></div></td>
		<td><div align="center"><input type="submit"  value=" 提交" /></div></td>	
		</form>				
		
		<%
		}else {
		
		com.ax.subject.model.StudentBean tb1 = new com.ax.subject.model.StudentBeanCl().getStudentById(test1.getStu_id());
		%>
		<tr>
		<td align="center"><%=sb.getId()%></td>
		
		<td><div align="center">
				<a href=<%=path + "/common/sub_detail.jsp?id=" + sb.getId()%>
					target="_blank"><%=sb.getTitle()%></a>
			</div></td>
		
		<td><div align="center"><%=sb.getDirection()%></div></td>
		
		


		<td><div align="center"><%=sb.getTime()%></div></td>
		
		<td><div align="center"><%=(sb.getState() == -1) ? "未通过"
							: (sb.getState() == 0 ? "待审核" : "通过")%></div></td>
		
		<%
	//	ArrayList<StuSubTeaBean> arrSSTB1;
	//	arrSSTB1 = new StuSubTeaBeanCl().getAllSSTB2(sb.getId());
			
		
		%>
		
		<td><div align="center"><input id="ser" name="a<%=i%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="      姓名：<%=tb1.getName()%>          学号：<%=test1.getStu_id()%>"
				onclick="showGaryBox('学生基本信息','teacher/studentinfo.jsp?stu_id=<%=test1.getStu_id()%>')"></div></td>
		
			
		<td><div align="center">
				<a href=<%=path + "/teacher/teacher.jsp?function=choose_sp_del_stu&sub_id="+sb.getId()+"&stu_id="+test1.getStu_id()%>
					target="_blank">撤销</a>
			</div></td>	
						
					
		
	</tr>
	<%
		}
	%>

	

	<tr>
		<td colspan="9"><div align="left">
				
			</div></td>
	</tr>

<%}
} 
}else {
System.out.println("stage:"+stage);

%>	
		<table>
		<tr>
		<th>现在不是特招学生阶段，点击<a
			href="teacher/teacher.jsp?function=..//common/stage">选题阶段</a>查看各阶段时间详情！</th>
	</tr>
          </table>                         
<%	
  
}
%>
</table>
</table>
</form>
</table>
</body>
</html>

