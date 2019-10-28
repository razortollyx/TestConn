<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	//	HttpSession hs = request.getSession(true);
	HttpSession hs = request.getSession(true);
	TeacherBean tb = (TeacherBean)hs.getAttribute("user");
	 ArrayList<StuSubTeaBean> arrSSTB;
	 int wish = new StageBeanCl().getCurrentStage(tb.getDepartment())+1;
	//arrSSTB = (ArrayList<StuSubTeaBean>) hs.getAttribute("arrSSTB"); 

	int ttkk00 = Integer.parseInt(request.getParameter("ttkk00"));

	//if (arrSSTB == null) {
		arrSSTB = new StuSubTeaBeanCl().getAllSSTB2(tb.getId());
		Collections.sort(arrSSTB);
//	}

	String[] color = { "#D3F0F3", "#E6F3FF" };//交替变色
	
	//定义4个分也会用到的变量
	int pageSize = 40; //每页显示的记录条数
	int pageNow = 1; //当前显示第几页
	int rowCount = arrSSTB.size(); //记录总条数
	int pageCount = (rowCount - 1) / pageSize + 1; //总共多少页

	String k = request.getParameter("pageNow");
	if (k != null) {
		pageNow = Integer.parseInt(k.trim());
	}
%>
<script type="text/javascript">
	function handle(state, subId, stuId, wish,j) {
	
		
	}
</script>

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

</script>
<form name="form1" method="post">
<%
	 if (  wish != 0 ) {//stage != 1
%>
	<table width="100%" height="269" border="1" cellpadding="0"
		cellspacing="0">
		<tr height="30px"></tr>
		<tr height="70px">
			<th colspan="7" height="50px" bgcolor="#E6F3FF"><div
					align="center" style="font-size: 35px">当&nbsp;前&nbsp;选&nbsp;题&nbsp;状&nbsp;态</div>
			</th>

		</tr>

		<tr bgcolor="#50806F">
			<td height="30px" width="6%" align="center">编号</td>
			<td width=50% align="center">题目</td>
			<td width=8% align="center">老师</td>
			<td width=8% align="center">学生</td>
			<td width=8% align="center">学生志愿</td>
			
		</tr>
		<%

			int j = 0;
			char[] hanzi = { '零', '一', '二', '三', '四', '五', '六'};
			int ss = 0;
			
			TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
			TeacherBeanCl tbc = new TeacherBeanCl();
			SubjectBeanCl sbc = new SubjectBeanCl();
			StudentBeanCl stubc = new StudentBeanCl();

			
	             
			 /*			for (; j <rowCount ; j++) { 之前的循环 */
            
			for (; j < (pageNow != pageCount ? pageSize : 1 + (rowCount - 1)
					% pageSize); j++) {
				StuSubTeaBean sstb = arrSSTB.get((pageNow - 1) * pageSize + j);
				
				//Collections.sort(arrSSTB);
				
				/*
				kangkang 2015.11.11
				在这里获取老师学生题目名字等信息
				 */
				String teaId = tsbc.getTeaId(sstb.getSubId());
				sstb.setTeaName((tbc.getTeacherById(teaId)).getName());
				sstb.setSubTitle(sbc.getSubjectById(String.valueOf(sstb.getSubId())).getTitle());
				sstb.setStuName(stubc.getStuById(sstb.getStuId() + "")
						.getName());
				
				if(ttkk00 == sstb.getSubId())	{
		       
				if (sstb.getState() == 0) {
		%>
		<%-- <tr height="30px" bgcolor=<%=color[j % 2]%>> --%>
		<tr height="30px">
			<td align="center"><%=sstb.getSubId()%></td>
			<%-- <td align="center"><%=sstb.getSubTitle()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getSubTitle()%>"
				></td>
			<td align="center"><%=sstb.getTeaName()%></td>
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('学生基本信息','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
				
				
			<td align="center"><%=sstb.getWish()%></td>
			
			<!-- 			<td align="center">
			
			</td> -->
			<!-- <a href="javascript:handle(<%=j%>,<%=sstb.getState()%>,<%=sstb.getSubId()%>,<%=sstb.getStuId()%>,<%=sstb.getWish()%>)"><%=Tools.getHandleDescribe(sstb.getState())%></a> -->
		</tr>
		<%
			} else {
		%>
		<tr height="30px">
			<td align="center"><%=sstb.getSubId()%></td>
			<%-- <td align="center"><%=sstb.getSubTitle()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getSubTitle()%>"
				></td>
			<td align="center"><%=sstb.getTeaName()%></td>
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('学生基本信息','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center"><%=sstb.getWish()%></td>
			
		</tr>
		<%
			}
		%>
		<%
			}
                       }
			
		%>		
		<%
			}
			
	 
		%>
		
	
	
		


	</table>
	<table border="0" align="center">
		注：点击学生名字可以查看学生相关信息
	</table>
</form>