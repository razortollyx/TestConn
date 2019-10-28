<%@ page language="java" import="java.util.*,com.kk.subject.model.*"
	pageEncoding="GB18030"%>
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
	
	//if (arrSSTB == null) {
		arrSSTB = new StuSubTeaBeanCl().getAllSSTB2(tb.getId());
		Collections.sort(arrSSTB);
//	}

	String[] color = { "#D3F0F3", "#B0C4DE" };//交替变色  transparent无填充色
	
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
	function handle(state, subId, stuId, wish,j) {
	if (state != 0) {//撤销
		document.form1.action = "ChooseServlet?flag=repeal1&subId="+ subId + "&stuId=" + stuId;
	}else{
		//	if (5 == wish) {//撤销管理员的指派
	//			document.form1.action = "AssignServlet?flag=repeal1&subId="
		//				+ subId + "&stuId=" + stuId;
	//		} else {//撤销老师的选择
	//			document.form1.action = "ChooseServlet?flag=repeal1&subId="
	//					+ subId + "&stuId=" + stuId;
	//		}
		var wish_type=document.getElementById("wish_type"+j);
		wish_type.name="wish_type";
		if (state == 0) {
			if(wish_type.value==0){
				alert("您没有分配志愿");
				return ;
			} else{
			document.form1.action = "ChooseServlet?flag=chooseStu1&subId="
					+ subId + "&stuId=" + stuId + "&wish=" + wish;
			}
		}
	}
		document.form1.submit();
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
	 if ( wish == 5 ) {//stage != 1
%>
	<table width="100%" height="269" border="1" cellpadding="0"
		cellspacing="0">
		<tr height="30px"></tr>
		<tr height="70px">
			<th colspan="7" height="50px" bgcolor="#E6F3FF"><div
					align="center" style="font-size: 35px">选&nbsp;题&nbsp;状&nbsp;态</div>
			</th>

		</tr>

<tr bgcolor="#50806F">
<td height="30px" width="6%" align="center">编号</td>
<td width=50% align="center">题目</td>
<td width=8% align="center">老师</td>
<td width=8% align="center">学生</td>
<td width=8% align="center">学生志愿</td>
<td width=8% align="center">状态</td>
<td width=8% align="center">分配老师志愿</td>

</tr>


		<tr bgcolor="#50806F">
		
		<%
			int j1 = 0;
			int testkk2=0;
			
			TeacherSubBeanCl tsbc1 = new TeacherSubBeanCl();
			TeacherBeanCl tbc1 = new TeacherBeanCl();
			SubjectBeanCl sbc1 = new SubjectBeanCl();
			StudentBeanCl stubc1 = new StudentBeanCl();
			
			
		/* 	StuSubTeaBean sstb1 = arrSSTB.get(0);
			ArrayList<StuWishBean> arrSSTB1;
			int[] subIds = new TeacherSubBeanCl().getS_id(tb.getId());
            arrSSTB1 = new StuWishBeanCI().getStuWishById(String.valueOf(sstb1.getSubId()));
            for(int kkk=0;kkk<arrSSTB1.size();kkk++){}
        */ 
                
                
		       
             int chunchu[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
             int[] subIds={0,0,0,0,0,0,0};
             int testkk1=0;
			/* 			for (; j <rowCount ; j++) { 之前的循环*/
			for (; j1 < arrSSTB.size(); j1++) {
				StuSubTeaBean sstb = arrSSTB.get(j1);			
				String teaId = tsbc1.getTeaId(sstb.getSubId());
				sstb.setTeaName((tbc1.getTeacherById(teaId)).getName());
				sstb.setSubTitle(sbc1.getSubjectById(String.valueOf(sstb.getSubId())).getTitle());
				sstb.setStuName(stubc1.getStuById(sstb.getStuId() + "").getName());
				 		       
		        chunchu[j1]=sstb.getSubId(); 	
		        }
		        
		        
		   
		    
		    int chun[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	        
	       
	       for(int test1=0;test1<chunchu.length;test1++){
	    	
	    	for(int test2=test1+1;test2<chunchu.length;test2++){
	    		if(chunchu[test2]==chunchu[test1]&&chunchu[test2]!=0){
	    			chun[test1]++;
	    			
	    			chunchu[test2]=0;
	    		}
	    		
	       }

         }
         int sub_num=0;
         int subt_num=0;
	    for(int kk=0;kk<chun.length;kk++){
	    	if(chunchu[kk]!=0){
	    		chun[kk]++;
	    		chun[subt_num]=chun[kk];
	    		subt_num++;
	    		System.out.println("chun_num:"+chun[kk]);
	    	}
	    	
	    }//每个题目有几个学生选(用于控制下面的双重循环输出合并行、列)
	    for(int kk=0;kk<chunchu.length;kk++){
	    if(chunchu[kk]!=0){
	    	System.out.println("chunchu"+chunchu[kk]);
	    	chunchu[sub_num]=chunchu[kk];
	    	sub_num++;
	     }
	    }//有几个题目被学生选了(如老师除了六个题目，但是只有四个被学生选择)
	    
	    
		    		
%>		    		

		    	
		    
		    
		        
<% 		       
		         	
 	
		int testk01=0;
   		for(int test01=0;test01<sub_num;test01++){
   		 
   		
 %>

 
 
<tr>
 <th rowspan="<%=chun[test01]+1%>"><%=chunchu[test01]%></th>  
 <th rowspan="<%=chun[test01]+1%>"><%=sbc1.getSubjectById(String.valueOf(chunchu[test01])).getTitle()%></th>
 <th rowspan="<%=chun[test01]+1%>"><%=tbc1.getTeacherById(tsbc1.getTeaId(chunchu[test01])).getName()%></th>
 <!-- 用于控制 -->
 <%
 		    
			String a = "命中";
			String b = "正在选题";
			String c = "老师已选其他学生";

			int ss = 0;
			
			
			TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
			TeacherBeanCl tbc = new TeacherBeanCl();
			SubjectBeanCl sbc = new SubjectBeanCl();
			StudentBeanCl stubc = new StudentBeanCl();
			
			
		/* 	StuSubTeaBean sstb1 = arrSSTB.get(0);
			ArrayList<StuWishBean> arrSSTB1;
			int[] subIds = new TeacherSubBeanCl().getS_id(tb.getId());
            arrSSTB1 = new StuWishBeanCI().getStuWishById(String.valueOf(sstb1.getSubId()));
            for(int kkk=0;kkk<arrSSTB1.size();kkk++){}
        */ 
            
  
            
			/* 			for (; j <rowCount ; j++) { 之前的循环*/
			for (int j=0; j < arrSSTB.size(); j++) {
			    
				StuSubTeaBean sstb = arrSSTB.get(j);
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
				
                if(chunchu[test01]==sstb.getSubId()){
		        
				if (sstb.getState() == 0) {
		%>
		 <tr height="30px" bgcolor=<%=color[j % 2]%>> 
		<%-- <tr height="30px"> --%>
		
			
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('学生基本信息','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center">第<%=sstb.getWish()%>志愿</td>
			<td align="center"><%=Tools.getDescribeOfState1(sstb.getState())%></td>
			<td><div align="center">
					<select id="wish_type<%=j%>" name="">
						<option value="0"></option>
						<option value="1">第1志愿</option>
						<option value="2">第2志愿</option>
						<option value="3">第3志愿</option>
					</select> <input type="button" value="提交"
						onclick="handle(<%=sstb.getState()%>,<%=sstb.getSubId()%>,<%=sstb.getStuId()%>,<%=sstb.getWish()%>,<%=j%>)">
				</div></td>
			<!-- 			<td align="center">
			
			</td> -->
			<!-- <a href="javascript:handle(<%=j%>,<%=sstb.getState()%>,<%=sstb.getSubId()%>,<%=sstb.getStuId()%>,<%=sstb.getWish()%>)"><%=Tools.getHandleDescribe(sstb.getState())%></a> -->
		</tr>
		<%
			} else {
		%>
		<tr height="30px">
			
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('学生基本信息','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center">第<%=sstb.getWish()%>志愿</td>
			<td align="center"><%=Tools.getDescribeOfState1(sstb.getState())%></td>
			<td align="center"><a
				href="javascript:handle(<%=sstb.getState()%>,<%=sstb.getSubId()%>,<%=sstb.getStuId()%>,<%=sstb.getWish()%>)"><%=Tools.getHandleDescribe(sstb.getState())%></a>
			</td>
			<!-- <td align="center">撤销</td> -->
		</tr>
		<%
			}
		%>		
		<%
			}
		%>		
		<%
			}
			}
		%>	
	<table border="0" align="center">
	   注：点击学生名称可以查看学生基本信息
	</table>
	    <%	
			}else{
		%>	
		<table>
		<tr>
		<th>现在不是分配志愿阶段，点击<a
			href="teacher/teacher.jsp?function=..//common/stage">选题阶段</a>查看各阶段时间详情！</th>
	</tr>
          </table>                         
		<%	
			
			
			}
		%>	
		
		

	</table>
	
</form>
  </body>
</html>