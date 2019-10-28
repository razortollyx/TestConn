<%@ page language="java" import="java.util.*,com.kk.subject.model.*,com.ax.subject.model.*"
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
	
	
	
		
//	}

	String[] color = { "#D3F0F3", "#E6F3FF" };//交替变色
	int tesekk=0;
	//定义4个分也会用到的变量
	
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

function myFunction(){
    if(window.confirm("确认指派给该学生"))
			{
			    
				document.form1.submit();
			}	
    
}
</script>
<%	

  
 	
	System.out.println("1:"+tesekk);
	String sub_id=request.getParameter("sub_id").trim();	
	String stu_id=request.getParameter("stu_id").trim();

	session.setAttribute("stu_id", stu_id);

	
	if( ("".equals(stu_id) == false)  ){
		System.out.println(stu_id);
	}
	else {
	   
		System.out.println(stu_id);
	}
		if( ("".equals(stu_id) == false)  ){ // false true
		
		

		int x=0;
		com.ax.subject.model.StudentBean tb = new com.ax.subject.model.StudentBeanCl().getStudentById(stu_id);
		com.kk.subject.model.SubjectBean sb = new com.kk.subject.model.SubjectBeanCl().getSubjectById(sub_id);
		
		if(tb!=null && sb!=null){
		if( (sb.getYuanxi()).equals(tb.getYuanxi() ) ){
			x=1;
		}
		
		System.out.println("1院系是："+tb.getYuanxi());
		System.out.println("2院系是："+sb.getYuanxi());
		}
	    if(tb == null || x==0 ){
	 %>
<script type="text/javascript">
	  alert("查无此学生！请您核对学生学号"); 	
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script> 
 <table>
		<tr>
		<th>查无此学生！请您核对学生学号，点击<a
			href="teacher/teacher.jsp?function=choose_sp_stu">特招选生</a>再次输入学生学号！</th>
	</tr>
          </table>    
	 <%  
	 //response.sendRedirect("student/student.jsp?function=sub_all"); &&  ("".equals(stu_name) == true)
	
    } else {
    System.out.println(tb.getId());
    %>
   
	
    <% 
    
        
	%>
	 <table>
	<form  id="testt" action=<%=path + "/teacher/teacher.jsp?function=choose_sp_stu2&sub_id="+sub_id+"&stu_id="+tb.getId()+" "  %>
method="post">
   <table border="1" cellspacing="0" width="20%" >
   <tr>
		<td width="50%">编&nbsp&nbsp号：</td>
		<td><%=sb.getId() %></td>
	</tr>
	<tr>
		<td width="50%">题&nbsp&nbsp目：</td>
		<td><%=sb.getTitle() %></td>
	</tr>
	<tr>
		<td width="50%">教&nbsp&nbsp师：</td>
		<td><%=sb.getTeacher() %></td>
	</tr>
   
	<tr>
		<td width="50%">账&nbsp&nbsp号：</td>
		<td><%=tb.getId()  %></td>
	</tr>
	
	<tr>
		<td>姓&nbsp&nbsp名：</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>性&nbsp&nbsp别：</td>
		<td><%=com.ax.subject.model.SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>班&nbsp&nbsp级：</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>专&nbsp&nbsp业：</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电话号码：</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>电子邮箱：</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
	</table>
	<button type="submit"   >确定指派</button>
    </form>
	<%
	if(tesekk==1){
	System.out.println("tesekk:"+tesekk); 
	int i=new StuspBeanCI().setStuSpById(sub_id,stu_id,tb.getYuanxi());
    int j=new StuspBeanCI().setStuSubById(sub_id,stu_id,tb.getYuanxi());
    System.out.println("j:"+j);
    if(i==-1 ){
    %>
 <script type="text/javascript">
	  alert("此学生已被其他老师指定！"); 
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
 </script>  
   
    <%
    
	}else{
	%>
	<script type="text/javascript">
	  alert("指定成功！");

 </script>
	 <% 
	}   
    }
    }
    }
	%>
	
	
	








        
        
        
            
       
     
    </body>
</html>
