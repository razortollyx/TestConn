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
	TeacherBean tbb = (TeacherBean)hs.getAttribute("user");
	 ArrayList<StuSubTeaBean> arrSSTBB;
	 int wish = new StageBeanCl().getCurrentStage(tbb.getDepartment())+1;
	//arrSSTBB = (ArrayList<StuSubTeaBean>) hs.getAttribute("arrSSTBB"); 

	int ttkk00 = Integer.parseInt(request.getParameter("ttkk00"));

	//if (arrSSTBB == null) {
		arrSSTBB = new StuSubTeaBeanCl().getAllSSTB2(tbb.getId());
		Collections.sort(arrSSTBB);
//	}

	String[] color = { "#D3F0F3", "#E6F3FF" };//�����ɫ
	
	//����4����Ҳ���õ��ı���
	int pageSize = 10; //ÿҳ��ʾ�ļ�¼����
	int pageNow = 1; //��ǰ��ʾ�ڼ�ҳ
	int rowCount = arrSSTBB.size(); //��¼������
	int pageCount = (rowCount - 1) / pageSize + 1; //�ܹ�����ҳ

	String k = request.getParameter("pageNow");
	if (k != null) {
		pageNow = Integer.parseInt(k.trim());
	}
%>
<script type="text/javascript">
	function handle(state, subId, stuId, wish,j) {
	if (state != 0) {//����
		document.form1.action = "ChooseServlet?flag=repeal1&subId="+ subId + "&stuId=" + stuId;
	}else{
		//	if (5 == wish) {//��������Ա��ָ��
	//			document.form1.action = "AssignServlet?flag=repeal1&subId="
		//				+ subId + "&stuId=" + stuId;
	//		} else {//������ʦ��ѡ��
	//			document.form1.action = "ChooseServlet?flag=repeal1&subId="
	//					+ subId + "&stuId=" + stuId;
	//		}
		var wish_type=document.getElementById("wish_type"+j);
		wish_type.name="wish_type";
		if (state == 0) {
			if(wish_type.value==0){
				alert("��û�з���־Ը");
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

</script>
<form name="form1" method="post">
<%
	 if ( (wish == 3) || (wish == 2) ) {//stage != 1
%>
	<table width="100%" height="269" border="1" cellpadding="0"
		cellspacing="0">
		<tr height="30px"></tr>
		<tr height="70px">
			<th colspan="7" height="50px" bgcolor="#E6F3FF"><div
					align="center" style="font-size: 35px">ѡ&nbsp;��&nbsp;״&nbsp;̬</div>
			</th>

		</tr>

		<tr bgcolor="#50806F">
			<td height="30px" width="6%" align="center">���</td>
			<td width=50% align="center">��Ŀ</td>
			<td width=8% align="center">��ʦ</td>
			<td width=8% align="center">ѧ��</td>
			<td width=8% align="center">ѧ��־Ը</td>
			
		</tr>
		<%

			int j = 0;
			String a = "����";
			String b = "����ѡ��";
			String c = "��ʦ��ѡ����ѧ��";

			int ss = 0;
			
			TeacherSubBeanCl tsbcc = new TeacherSubBeanCl();
			TeacherBeanCl tbcc = new TeacherBeanCl();
			SubjectBeanCl sbcv = new SubjectBeanCl();
			StudentBeanCl stubcv = new StudentBeanCl();

			
			
            for(int tt=0;tt<6;tt++){
			 
             for (; j < 36; j++) {
			
				StuSubTeaBean sstbb = arrSSTBB.get((pageNow - 1) * pageSize + j);
				
				//Collections.sort(arrSSTBB);
				
				/*
				kangkang 2015.11.11
				�������ȡ��ʦѧ����Ŀ���ֵ���Ϣ
				 */
				String teaId = tsbcc.getTeaId(sstbb.getSubId());
				sstbb.setTeaName((tbcc.getTeacherById(teaId)).getName());
				sstbb.setSubTitle(sbcv.getSubjectById(sstbb.getSubId()).getTitle());
				sstbb.setStuName(stubcv.getStuById(sstbb.getStuId() + "")
						.getName());
				
				if(ttkk00 == sstbb.getSubId())	{
		       
				if (sstbb.getState() == 0) {
		%>
		<%-- <tr height="30px" bgcolor=<%=color[j % 2]%>> --%>
		<tr height="30px">
			<td align="center"><%=sstbb.getSubId()%></td>
			<%-- <td align="center"><%=sstbb.getSubTitle()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstbb.getSubTitle()%>"
				></td>
			<td align="center"><%=sstbb.getTeaName()%></td>
			<%-- <td align="center"><%=sstbb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstbb.getStuName()%>"
				onclick="showGaryBox('ѧ��������Ϣ','teacher/studentinfo.jsp?stu_id=<%=sstbb.getStuId()%>')"></td>
			<td align="center"><%=sstbb.getWish()%></td>
			
			<!-- 			<td align="center">
			
			</td> -->
			<!-- <a href="javascript:handle(<%=j%>,<%=sstbb.getState()%>,<%=sstbb.getSubId()%>,<%=sstbb.getStuId()%>,<%=sstbb.getWish()%>)"><%=Tools.getHandleDescribe(sstbb.getState())%></a> -->
		</tr>
		<%
			} else {
		%>
		<tr height="30px">
			<td align="center"><%=sstbb.getSubId()%></td>
			<%-- <td align="center"><%=sstbb.getSubTitle()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstbb.getSubTitle()%>"
				></td>
			<td align="center"><%=sstbb.getTeaName()%></td>
			<%-- <td align="center"><%=sstbb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstbb.getStuName()%>"
				onclick="showGaryBox('ѧ��������Ϣ','teacher/studentinfo.jsp?stu_id=<%=sstbb.getStuId()%>')"></td>
			<td align="center"><%=sstbb.getWish()%></td>
			<td align="center"><%=Tools.getDescribeOfState1(sstbb.getState())%></td>
			<td align="center"><a
				href="javascript:handle(<%=sstbb.getState()%>,<%=sstbb.getSubId()%>,<%=sstbb.getStuId()%>,<%=sstbb.getWish()%>)"><%=Tools.getHandleDescribe(sstbb.getState())%></a>
			</td>
			<!-- <td align="center">����</td> -->
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
			}
		%>
		
	
	
		


	</table>
	<table border="0" align="center">
		
	</table>
</form>