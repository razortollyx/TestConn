<%@ page language="java" import="java.util.*,com.kk.subject.model.*,com.common.controller.*"
	pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	String yuanxi=session.getAttribute("yuanxi").toString();
	String stuname=session.getAttribute("stuname").toString();
	response.setCharacterEncoding("UTF-8");
%>
<%

	//HttpSession hs = request.getSession(true);
	 ArrayList<StuSubTeaBean> arrSSTB;
	
	//arrSSTB = (ArrayList<StuSubTeaBean>) hs.getAttribute("arrSSTB"); 
	
	//if (arrSSTB == null) {
		arrSSTB = new StuSubTeaBeanCl().getAllSSTB1(yuanxi);
		Collections.sort(arrSSTB);
//	}

	String[] color = { "#D3F0F3", "#E6F3FF" };//交替变色
	
	//定义4个分也会用到的变量
	int pageSize = 10; //每页显示的记录条数
	int pageNow = 1; //当前显示第几页
	int rowCount = arrSSTB.size(); //记录总条数 
	
	
	
	int pageCount = (rowCount - 1) / pageSize + 1; //总共多少页

	String k = request.getParameter("pageNow");
	if (k != null) {
		pageNow = Integer.parseInt(k.trim());
	}
%>
<script type="text/javascript">
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
    function exportExcel(yuanxi){
	    document.form1.action="ExportServlet1";
	    document.form1.submit();
		/* alert('待完善！'); */
	}

	function handle(state, subId, stuId, wish) {

		if (state == 1) {//撤销
			if (5 == wish) {//撤销管理员的指派
				document.form1.action = "AssignServlet?flag=repeal&subId="
						+ subId + "&stuId=" + stuId;
			} else {//撤销老师的选择
				document.form1.action = "ChooseServlet?flag=repeal&subId="
						+ subId + "&stuId=" + stuId;
			}
		} else if (state == 0) {//命中此志愿
			document.form1.action = "ChooseServlet?flag=chooseStu&subId="
					+ subId + "&stuId=" + stuId;
		}
		document.form1.submit();
	}
	
	
	
	
</script>
<form name="form1" method="post">
<input name="yuanxi" type="hidden"  value="<%=yuanxi %>">
	<table id="testList" width="100%" height="269" border="1" cellpadding="0"
		cellspacing="0">
		<tr height="30px"></tr>
		<tr height="70px">
			<th colspan="7" height="50px" bgcolor="#E6F3FF"><div
					align="center" style="font-size: 35px">选&nbsp;题&nbsp;结&nbsp;果</div>
			</th>
		</tr>
		<!-- 		<tr>
			<td colspan="7" scope="col" align="center" height="30px">选择专业: <select
				id="selMajor" name="selMajor" onchange="setSelCls()">

					<option value="0">所有</option>

			</select> &nbsp;&nbsp;&nbsp;选择班级:<select id="selCls" name="selCls">
					<option value="0">所有</option>

			</select>&nbsp;&nbsp;<input type="button" value="筛选">
			</td>
		</tr> -->
		<tr bgcolor="#50806F">
			<td height="30px" width="6%" align="center">编号</td>
			<td width=50% align="center">题目</td>
			<td width=8% align="center">老师</td>
			<td width=8% align="center">学生</td>
			<td width=8% align="center">学生志愿</td>
			<td width=8% align="center">老师分配状态</td>
<!-- 			<td width=8% align="center">结果</td> -->
		</tr>
		<%
			int j = 0;
			
			int a=1;
			TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
			TeacherBeanCl tbc = new TeacherBeanCl();
			SubjectBeanCl sbc = new SubjectBeanCl();
			StudentBeanCl stubc = new StudentBeanCl();
			for (; j <rowCount; j++) {
				//获取当前页面的所有类对象 
				StuSubTeaBean sstb = arrSSTB.get(j);
				/*
				kangkang 2015.11.11
				在这里获取老师学生题目名字等信息
				 */
				String teaId = tsbc.getTeaId(sstb.getSubId());
				sstb.setTeaName((tbc.getTeacherById(teaId)).getName()); 
				sstb.setSubTitle(sbc.getSubjectById(String.valueOf(sstb.getSubId())).getTitle());
				sstb.setStuName(stubc.getStuById(sstb.getStuId() + "").getName());
				if((a==sstb.getChoose())&&(sstb.getStuName().equals(stuname))){	
		%>
		<tr height="30px" bgcolor=<%=color[j % 2]%>>
			<td align="center"><%=sstb.getSubId()%></td>
			<td align="center"><%=sstb.getSubTitle()%></td>
			<%--<td align="center"><%=sstb.getTeaName()%></td>--%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getTeaName()%>"
				onclick="showGaryBox('老师基本信息','student/teacherinfo.jsp?tea_id=<%=teaId%>')"></td>
			
			
			<td align="center"><%=sstb.getStuName()%></td>
			<td align="center"><%=sstb.getWish()%></td>
			<td align="center"><%=Tools.getDescribeOfState(sstb.getState())%></td>
<%-- 			<td align="center"><a
				href="javascript:handle(<%=sstb.getState()%>,<%=sstb.getSubId()%>,<%=sstb.getStuId()%>,<%=sstb.getWish()%>)"><%=Tools.getHandleDescribe(sstb.getState())%></a>
			</td> --%>
		</tr>
		<%
			}
		%>
		<%}
         %>
	</table>
</form>