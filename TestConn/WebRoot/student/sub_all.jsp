<%@page import="com.kk.subject.model.StuSubBean"%>
<%@page import="com.kk.subject.model.StuSubBeanCl"%>
<%@page import="com.kk.subject.model.StuWishBean"%>
<%@page import="com.kk.subject.model.StuWishBeanCI"%>
<%@page import="com.kk.subject.model.StuspBean"%>
<%@page import="com.kk.subject.model.StuspBeanCI"%>
<%@ page language="java" import="java.util.*,com.ax.subject.model.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	ArrayList<StuWishBean> arrSSTB;
	 
	
	
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

</script>

<form name="form1" action="" method="post">
	<%
		SubjectBean sb = null;
		HttpSession hs = request.getSession(true);
		StudentBean tb = (StudentBean) hs.getAttribute("user");
		StudentBeanCl stubc = new StudentBeanCl();
		String yuanxi=session.getAttribute("yuanxi").toString();
		String[] color = { "#CFDFF4", "#DFEAF8" };
		response.setCharacterEncoding("UTF-8");
		ArrayList<SubjectBean> al = null;
		System.out.println("学生ID"+tb.getId());
		al = (ArrayList<SubjectBean>) hs.getAttribute("searchResult");
		String Direction=null;
		Direction=(String)hs.getAttribute("Direction");
		String Title=null;
		Title=(String)hs.getAttribute("Title");
		String teacherName=null;
		teacherName=(String)hs.getAttribute("teacherName");
		if(Direction==null){
			Direction="";
		}
		if(Title==null){
			Title="";
		}
		if(teacherName==null){
			teacherName="";
		}
		//分页问题解决 注释下面的代码 11.3
		//hs.removeAttribute("searchResult");
		if(al==null){	
		al = new SubjectBeanCl().getAllSub(tb.getId(),yuanxi);
		}
		int pageSize = 15; //每页显示的记录条数
		int pageNow = 1; //当前显示第几页
		int rowCount = al.size(); //记录总条数
		int pageCount = (rowCount-1)/pageSize + 1; //总共多少页
		SetBeanCl setBeanCl = new SetBeanCl();
		SetBean setBean = setBeanCl.getAllinfo(yuanxi);
		
		String k=request.getParameter("pageNow");
		if(k!=null){
			pageNow = Integer.parseInt(k);
		}
		int i1=0;
		int i2=0;
		int i3=0;
		int i4=0;
		int i5=0;
		int i6=0;
		ArrayList<StuSubBean> sb1= null;
		sb1=new StuSubBeanCl().getAllSSBbystuid(yuanxi, tb.getId());
		for(int j=0;j<sb1.size();j++){
			if(sb1.get(j).getWish()==1){
				i1=1;
			}else if(sb1.get(j).getWish()==2){
				i2=1;
			}else if(sb1.get(j).getWish()==3){
				i3=1;
			}else if(sb1.get(j).getWish()==4){
				i4=1;
			}else if(sb1.get(j).getWish()==5){
				i5=1;
			}else if(sb1.get(j).getWish()==6){
				i6=1;
			}				
		}
		
	%>
	<script type="text/javascript">
	    function subm(i,selectedNum,temp,tesxx){
	    var subId = document.getElementById("subId"+i);
		subId.name="subId";
		var wish_type=document.getElementById("wish_type"+i);
		wish_type.name="wish_type";
		if(tesxx!=0){
			alert("导师已指派特定学生，您无法选择该题目！")
		    return ;
		}
		if(1!=<%=stubc.getStudentById(tb.getId()).getPrivilege()%>){
		    alert("您没有选题权限，请联系管理员。")
		    return ;
		}
	    if(3!=<%=new com.kk.subject.model.StageBeanCl().getCurrentStage(yuanxi)%>){
			alert("非选题阶段!");
			return ;
		} 
	    if(0==wish_type.value){
			alert("您没有选择志愿");
			return ;
		} 
	    if(<%=new SetBeanCl().getAllinfo(yuanxi).getWarnNum()%>>selectedNum){
	    	document.form1.action = "UpdateDataServlet?flag=select_sub";
			//document.form1.action = "UpdateDataServlet?flag=select_sub";
			document.form1.submit();
		}else if(<%=new SetBeanCl().getAllinfo(yuanxi).getWarnNum()%><=selectedNum && <%=new SetBeanCl().getAllinfo(yuanxi).getMaxSelNum()%>>selectedNum){
		      if(window.confirm("此题已选人数过多,请选择其它题目以确保你能选上,如要继续选择此题请点击确定，不选择此题请点击取消"))
			{
			    document.form1.action = "UpdateDataServlet?flag=select_sub";
				document.form1.submit();
			}
		}else {
			alert("选择此题人数已满，请选择其它题目");
		} 
	}

    function search(){
    document.form1.action = "UpdateDataServlet?flag=screening";
    document.form1.submit();
   }
   
   function test(){
//这里还需要实现一些对于输入页码的安全性验证。比如不能为空，必须是数字这些。
  var pages = document.getElementById("pages").value; 
  var num = parseInt(pages); 
  window.open("student/student.jsp?function=sub_all&pageNow="+num);

 }
</script>
	<table width="100%" border="1">
		<%
			if (!stubc.Fill_Info(tb.getId() + "")) {
		%>
		<tr>
			<a href="student/student.jsp?function=info_modify">请先完善信息</a>
		<tr>
			<%
				} else {
			%>
		
		<tr>
			<th colspan="8"><div align="center">所有题目<%=new com.kk.subject.model.StageBeanCl().getCurrentStage(tb.getYuanxi())+1%></div></th>
		</tr>
<input name="selDepartment" type="hidden"  value="<%=yuanxi %>">
<input name="userid" type="hidden"  value="<%=tb.getId() %>">
		<tr>
			<td colspan="8" align="center">
				<table>
					<tr>
						<td><div>
								老师:<input name="teacher" type="text" size="10" value="<%=teacherName %>" >
							</div>
						</td>
						<td><div>
								题目方向：<input name="direction" type="text" size="5" value="<%=Direction %>">
							</div>
						</td>
							<td><div>
								题目搜索：<input name="title" type="text" size="10" value="<%=Title %>">
							</div>
						</td>
						<td><div>
								&nbsp;&nbsp;&nbsp;&nbsp;<input id="ser" type="button" value="确定"
									onclick="search()">
							</div>
						</td>
					</tr>
				</table></td>

		</tr>
		<tr  bgcolor="#50806F">
			<td width="5%"><div align="center">编号</div></td>
			<td width="50%"><div align="center">标题</div></td>
			
			<td width="10%"><div align="center">出题人</div></td>
			<td width="5%"><div align="center">是否特招</div></td>
			<td width="5%"><div align="center">已选人数</div></td>
			<td width="5%"><div align="center">志愿分布</div></td>
			<td width="10%"><div align="center">题目方向</div></td>
			<td width="20%"><div align="center">志愿</div></td>
		</tr>
		<%
			for (int i = 0; i < (pageNow != pageCount ? pageSize : 1
						+ (rowCount - 1) % pageSize); i++) {
					sb = al.get((pageNow - 1) * pageSize + i);
					 arrSSTB = new StuWishBeanCI().getStuWishById(String.valueOf(sb.getId()));
					 StuspBean te=new StuspBeanCI().getStuSpById(String.valueOf(sb.getId()));
					 String te1[]={"否","是"};
					 int tesxx=0;
					 if(te.getSub_id()!=null){
					 System.out.println(sb.getId());
					 System.out.println("te不为空");
					    tesxx=1;
					 }
		%>
		<tr bgcolor=<%=color[i % 2]%>>
			<td align="center"><%=sb.getId()%><input id="subId<%=i%>"
				name="" type="hidden" value=<%=sb.getId()%>>
			</td>
			<td align="center"><a
				href=<%=path + "/common/sub_detail.jsp?id=" + sb.getId()%>
				target="_blank"><%=sb.getTitle()%></a></td>
				
		    
			<td><input id="ser" name="a" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sb.getTeacher()%>"
				onclick="showGaryBox('出题人基本信息','student/teainfo.jsp?sub_id=<%=sb.getId()%>')"></td>
			
			<td><div align="center"><%=te1[tesxx]%></div></td>
			
			<td align="center"><%=arrSSTB.size()%><input type="hidden"
				id="selectedNum<%=i%>" value=<%= arrSSTB.size()%>></td>
				
		<!--	<td align="center"><a  	
				href=<%=path + "/student/wish_state.jsp?sub_id=" + sb.getId()%>
				target="_blank">查看详情</a></td>
	    -->		
 			<td><input id="ser" name="a1" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="详情查看"
				onclick="showGaryBox('志愿分布信息','student/wish_state.jsp?sub_id=<%=sb.getId()%>')"></td>
			
			<td><div align="center"><%=sb.getDirection()%></div></td>
			<td><div align="center">
					<select id="wish_type<%=i%>" name="">
						<option value="0"></option>
						<% if(i1==0 ){%>
						<option value="1">第1志愿</option>
						<% }%>
						<% if(i2==0 ){%>
						<option value="2">第2志愿</option>
						<% }%>
						<% if(i3==0 ){%>
						<option value="3">第3志愿</option>
						<% }%>
						<% if(i4==0 ){%>
						<option value="4">第4志愿</option>
						<% }%>
						<% if(i5==0 ){%>
						<option value="5">第5志愿</option>
						<% }%>
						<% if(i6==0 ){%>
						<option value="6">第6志愿</option>
						<% }%>
					</select> <input type="button" value="提交"
						
						onclick="subm(<%=i%>,<%=arrSSTB.size()%>,<%=sb.getId() %>,<%=tesxx %>)">
				</div></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="8"><div align="center">
		 <a href=<%="student/student.jsp?function=sub_all&pageNow="
							+1%>>首页</a>
					<%

						if (pageNow != 1) {
								//out.println("pageNow=" + pageNow);
					%>
					
					<a
						href=<%="student/student.jsp?function=sub_all&pageNow="
							+ (pageNow - 1)%>>上一页</a>
					<%
						}
							//页面总数少于8，输出所有页码标签
							if (pageCount < 8) {
								for (int i = 1; i <= pageCount; i++) {
					%>
					&nbsp<a
						href=<%="student/student.jsp?function=sub_all&pageNow="
								+ i%>><%=i%></a>&nbsp
					<%
						}
							} else if (pageNow <= 4) {//页面总数大于8，当前页不大于4，输出1~8
								for (int i = 1; i <= 8; i++) {
					%>
					&nbsp<a
						href=<%="student/student.jsp?function=sub_all&pageNow="
								+ i%>><%=i%></a>&nbsp
					<%
						}
							} else if (pageNow > pageCount - 4) {//输出后8页
								for (int i = 1; i <= 8; i++) {
					%>
					&nbsp<a
						href=<%="student/student.jsp?function=sub_all&pageNow="
								+ (pageCount - 8 + i)%>><%=pageCount - 8 + i%></a>&nbsp
					<%
						}
							} else {
								for (int i = 1; i <= 8; i++) {
					%>
					&nbsp<a
						href=<%="student/student.jsp?function=sub_all&pageNow="
								+ (pageNow + i - 4)%>><%=pageNow + i - 4%></a>&nbsp
					<%
						}
							}
							if (pageNow != pageCount) {
					%>
					<a
						href=<%="student/student.jsp?function=sub_all&pageNow="
							+ (pageNow + 1)%>>下一页</a>
							
							
					<%
						}
					%>
					
					<a href=<%="student/student.jsp?function=sub_all&pageNow="
							+ pageCount%>>尾页</a>
						
							<!--  <input type="text" name="pages" id="pages"  >
							 
							 <a href="#" onClick="test()">跳转</a> -->					
				</div> 
			</td>
		</tr>
		<%} %>
	</table>
</form>
<%
		ArrayList<StudentSubjectBean> ssbAl = new StudentSubjectBeanCl().getSubAlByStuId(tb.getId());
	   	SubjectBean subBean;
	   int wish = new com.kk.subject.model.StageBeanCl().getCurrentStage(tb.getYuanxi())+1; 	
	   	System.out.println(ssbAl.size());
	   	for(int i=0;i<ssbAl.size();i++){
	   		System.out.println(ssbAl.get(i).getTemp());
			subBean = new SubjectBeanCl().getSubjectById(ssbAl.get(i).getSub_id());
		}

%>
<script type="text/javascript">
function submit(id){
  if(3==<%=new com.kk.subject.model.StageBeanCl().getCurrentStage(tb.getYuanxi())%>){
			document.form.action="UpdateDataServlet?flag=deleteSub1&subId="+id;
			document.form.submit();		
		}else{
		    alert("非选题阶段!");
			return ;
		}
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
    document.body.style.overflow = "hidden"; 
    
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
<form name="form" method = "post" action="">
<table width="100%" border="1">
	<tr>
		<th colspan="9"><div align="center">已选题数</div></th>
	</tr>
	<tr bgcolor="#50806F">
	<td><div align="center">编号</div></td>
		<td><div align="center">标题</div>
		</td>
		<td><div align="center">出题人</div>
		</td>
		<td><div align="center">题目方向</div>
		</td>
		<td><div align="center">志愿</div>
		</td>
		<td><div align="center">选题人数</div>
		</td>
		<td><div align="center">志愿分布</div>
		</td>
		<td><div align="center">题目是否选中</div>
		</td>
		<td><div align="center">操作</div></div></td>
	</tr>

	<%
		for(int i=0;i<ssbAl.size();i++){
			subBean = new SubjectBeanCl().getSubjectById(ssbAl.get(i).getSub_id());
			 arrSSTB = new StuWishBeanCI().getStuWishById(String.valueOf(ssbAl.get(i).getSub_id()));
			//System.out.println(ssbAl.size());
	if(wish!=0){//wish==3
	%>
	<tr>
	<td><div align="center"><%=subBean.getId() %></div></td>
		<td><div align="center"><%=subBean.getTitle()%></div>
		</td>	
		<td><div align="center"><%=subBean.getTeacher()%></div>
		</td>	
		<%-- <td ><input  id="ser" name="a<%=i %>" style= "background:transparent;border-style:none;width:100%;height:100%;  "  value="<%=subBean.getTeacher()%>" > --%>
		</td>
		<td><div align="center"><%=subBean.getDirection()%></div>
		</td>
		<td><div align="center"><%=((StudentSubjectBean)ssbAl.get(i)).getWish()%></div>
		</td>
		<td><div align="center"><%=arrSSTB.size()%></div>
		</td>
		<td><input id="ser" name="a1" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="详情查看"
				onclick="showGaryBox('志愿分布信息','student/wish_state.jsp?sub_id=<%=ssbAl.get(i).getSub_id()%>')"></td>
		<td><div align="center"><%=com.kk.subject.model.Tools.getDescribeOfState(((StudentSubjectBean)ssbAl.get(i)).getState()) %></div>
	    <td><div align="center"><a href="javascript:submit(<%=subBean.getId() %>);">撤销</a></div></td>
	</tr>
	<%  
		} else {
	%>
	<tr>
	<td><div align="center"><%=subBean.getId() %></div></td>
		<td><div align="center"><%=subBean.getTitle()%></div>
		</td>
		<td><div align="center"><%=subBean.getTeacher()%></div>
		</td>
		
		<%-- <td ><input  id="ser" name="a<%=i %>" type="text" style= "background:transparent;border-style:none;width:100%;height:100%;  "  value="<%=subBean.getTeacher()%>" > --%>
		</td>
		<td><div align="center"><%=subBean.getDirection()%></div>
		</td>
		<td><div align="center"><%=((StudentSubjectBean)ssbAl.get(i)).getWish()%></div>
		</td>
		<td align="center"><%=arrSSTB.size()%><input type="hidden"
				id="selectedNum<%=i%>" value=<%= arrSSTB.size()%>></td>
				<td><input id="ser" name="a1" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="详情查看"
				onclick="showGaryBox('志愿分布信息','student/wish_state.jsp?sub_id=<%=ssbAl.get(i).getSub_id()%>')"></td>
		<td><div align="center"><%=com.kk.subject.model.Tools.getDescribeOfState(((StudentSubjectBean)ssbAl.get(i)).getState()) %></div>
	    <td><div align="center">无</div></td>
	</tr>
	<%} %>
	<%} %>


</table>

<table border="0"  align="center" >
	<td  colspan="7" align="center">
					 
			</td>
	</table>
</form>