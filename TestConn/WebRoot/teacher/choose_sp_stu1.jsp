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

	String[] color = { "#D3F0F3", "#E6F3FF" };//�����ɫ
	int tesekk=0;
	//����4����Ҳ���õ��ı���
	
%>


<script type="text/javascript">
var garyBox ;
var garyBoxHead;
var garyBoxTitleText;
var garyBoxClose;
var garyBoxIframe;

function createGaryBox()
{
document.body.innerHTML+="<div id=\"garyBox\" style=\"display:none\"><div id=\"garyBoxHead\"><h4 ><span id=\"garyBoxTitleText\">title</span></h4><h4><span id=\"garyBoxClose\">�ر�</span></h4></div><div><iframe id=\"garyBoxIframe\" name=\"garyBoxIframe\"  width=\"100%\" height=\"100%\" frameBorder=\"0\" frameSpacing=\"0\" scrolling=\"auto\" marginHeight=\"0\" marginWidth=\"0\" ></iframe></div></div>";
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
    if(window.confirm("ȷ��ָ�ɸ���ѧ��"))
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
		
		System.out.println("1Ժϵ�ǣ�"+tb.getYuanxi());
		System.out.println("2Ժϵ�ǣ�"+sb.getYuanxi());
		}
	    if(tb == null || x==0 ){
	 %>
<script type="text/javascript">
	  alert("���޴�ѧ���������˶�ѧ��ѧ��"); 	
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';
 </script> 
 <table>
		<tr>
		<th>���޴�ѧ���������˶�ѧ��ѧ�ţ����<a
			href="teacher/teacher.jsp?function=choose_sp_stu">����ѡ��</a>�ٴ�����ѧ��ѧ�ţ�</th>
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
		<td width="50%">��&nbsp&nbsp�ţ�</td>
		<td><%=sb.getId() %></td>
	</tr>
	<tr>
		<td width="50%">��&nbsp&nbspĿ��</td>
		<td><%=sb.getTitle() %></td>
	</tr>
	<tr>
		<td width="50%">��&nbsp&nbspʦ��</td>
		<td><%=sb.getTeacher() %></td>
	</tr>
   
	<tr>
		<td width="50%">��&nbsp&nbsp�ţ�</td>
		<td><%=tb.getId()  %></td>
	</tr>
	
	<tr>
		<td>��&nbsp&nbsp����</td>
		<td><%=tb.getName()==null?"":tb.getName() %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>��&nbsp&nbsp��</td>
		<td><%=com.ax.subject.model.SEX.toStringValue(tb.getSex())+"" %></td>
	</tr>
	<tr></tr>
	<tr>
		<td>��&nbsp&nbsp����</td>
		<td><%=tb.getCls()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>ר&nbsp&nbspҵ��</td>
		<td><%=tb.getMajor()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>�绰���룺</td>
		<td><%=tb.getPhoneNum()==null?"":tb.getPhoneNum()%></td>
	</tr>
	<tr></tr>
	<tr>
		<td>�������䣺</td>
		<td><%=tb.getEmail()==null?"":tb.getEmail()%></td>
	</tr>
	</table>
	<button type="submit"   >ȷ��ָ��</button>
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
	  alert("��ѧ���ѱ�������ʦָ����"); 
	  window.location.href='teacher/teacher.jsp?function=choose_sp_stu';	
 </script>  
   
    <%
    
	}else{
	%>
	<script type="text/javascript">
	  alert("ָ���ɹ���");

 </script>
	 <% 
	}   
    }
    }
    }
	%>
	
	
	








        
        
        
            
       
     
    </body>
</html>
