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
//	}

	String[] color = { "#D3F0F3", "#E6F3FF" };//�����ɫ
	
	//����4����Ҳ���õ��ı���
	int pageSize = 10; //ÿҳ��ʾ�ļ�¼����
	int pageNow = 1; //��ǰ��ʾ�ڼ�ҳ
	int rowCount = arrSSTB.size(); //��¼������
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

<script tyep="text/javascript">
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
<form name="form1" method="post">
<%
	 if (wish == 3) {//stage != 1
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
			<%--<td width=8% align="center">��ʦ</td>--%>
			<td width=8% align="center">ѧ��</td>
			<td width=8% align="center">ѧ��־Ը</td>
			<td width=8% align="center">״̬</td>
			<td width=8% align="center">������ʦ־Ը</td>
		</tr>
		<%
			int j = 0;
			String a = "����";
			String b = "����ѡ��";
			String c = "��ʦ��ѡ����ѧ��";

			int ss = 0;
			
			TeacherSubBeanCl tsbc = new TeacherSubBeanCl();
			TeacherBeanCl tbc = new TeacherBeanCl();
			SubjectBeanCl sbc = new SubjectBeanCl();
			StudentBeanCl stubc = new StudentBeanCl();

			/* 			for (; j <rowCount ; j++) { ֮ǰ��ѭ��*/
			for (; j < (pageNow != pageCount ? pageSize : 1 + (rowCount - 1)
					% pageSize); j++) {
				StuSubTeaBean sstb = arrSSTB.get((pageNow - 1) * pageSize + j);
				Collections.sort(arrSSTB);
				
				/*
				kangkang 2015.11.11
				�������ȡ��ʦѧ����Ŀ���ֵ���Ϣ
				 */
				String teaId = tsbc.getTeaId(sstb.getSubId());
				sstb.setTeaName((tbc.getTeacherById(teaId)).getName());
				sstb.setSubTitle(sbc.getSubjectById(sstb.getSubId()).getTitle());
				sstb.setStuName(stubc.getStuById(sstb.getStuId() + "")
						.getName());
				

		       
				if (sstb.getState() == 0) {
		%>
		<%-- <tr height="30px" bgcolor=<%=color[j % 2]%>> --%>
		<tr height="30px">
			<td align="center"><%=sstb.getSubId()%></td>
			<%-- <td align="center"><%=sstb.getSubTitle()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getSubTitle()%>"
				onclick="showGaryBox('��Ŀ������Ϣ','teacher/sub_modify1.jsp?id=<%=sstb.getSubId()%>')"></td>
			<%--<td align="center"><%=sstb.getTeaName()%></td>--%>
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('ѧ��������Ϣ','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center"><%=sstb.getWish()%></td>
			<td align="center"><%=Tools.getDescribeOfState1(sstb.getState())%></td>
			<td><div align="center">
					<select id="wish_type<%=j%>" name="">
						<option value="0"></option>
						<option value="1">��һ־Ը</option>
						<option value="2">�ڶ�־Ը</option>
						<option value="3">����־Ը</option>
					</select> <input type="button" value="�ύ"
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
			<td align="center"><%=sstb.getSubId()%></td>
			<%-- <td align="center"><%=sstb.getSubTitle()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getSubTitle()%>"
				onclick="showGaryBox('��Ŀ������Ϣ','teacher/sub_modify1.jsp?id=<%=sstb.getSubId()%>')"></td>
			<td align="center"><%=sstb.getTeaName()%></td>
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('ѧ��������Ϣ','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center"><%=sstb.getWish()%></td>
			<td align="center"><%=Tools.getDescribeOfState1(sstb.getState())%></td>
			<td align="center"><a
				href="javascript:handle(<%=sstb.getState()%>,<%=sstb.getSubId()%>,<%=sstb.getStuId()%>,<%=sstb.getWish()%>)"><%=Tools.getHandleDescribe(sstb.getState())%></a>
			</td>
			<!-- <td align="center">����</td> -->
		</tr>
		<%
			}
		%>
		<%
			}
		%>		
		<%
			}else{
		%>
		<table>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<th>���ڲ��Ƿ���־Ը�׶Σ����<a
			href="teacher/teacher.jsp?function=..//common/stage">ѡ��׶�</a>�鿴���׶�ʱ�����飡</th>
	</tr>
	</table>
	<%
			}
		%>	
		
		<!-- �����ҳ -->
		<tr>

			<%
				if (rowCount != 0) {
			%>
			<td colspan="8" scope="col" align="center" height="30px">
				<%
					if (pageCount > 8) {
				%> <a href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow=1"%>>[��ҳ]</a>
				<%
					}
						if (pageNow != 1) {
				%> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
							+ (pageNow - 1)%>>[��һҳ]</a>
				<%
					}
						if (pageCount < 8) {//ҳ����������8���������ҳ���ǩ
							for (int i = 1; i <= pageCount; i++) {
								if (pageNow == i) {
				%> <label><%=i%></label>&nbsp; <%
 	} else {
 %> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
									+ i%>>[<%=i%>]
			</a>&nbsp; <%
 	}
 			}
 		} else if (pageNow <= 4) {//ҳ����������8����ǰҳ������4�����1~8
 			for (int i = 1; i <= 8; i++) {
 				if (pageNow == i) {
 %> <label><%=i%></label>&nbsp; <%
 	} else {
 %> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
									+ i%>>[<%=i%>]
			</a>&nbsp; <%
 	}
 			}
 		} else if (pageNow > pageCount - 4) {//�����8ҳ
 			for (int i = pageCount - 7; i <= pageCount; i++) {
 				if (pageNow == i) {
 %> <label><%=i%></label>&nbsp; <%
 	} else {
 %> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
									+ i%>>[<%=i%>]
			</a>&nbsp; <%
 	}
 			}
 		} else {//���ǰ3��4
 			for (int i = pageNow - 3; i <= pageNow + 4; i++) {
 				if (pageNow == i) {
 %> <label><%=i%></label>&nbsp; <%
 	} else {
 %> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
									+ i%>>[<%=i%>]
			</a>&nbsp; <%
 	}
 			}
 		}
 		if (pageNow != pageCount) {
 %> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
							+ (pageNow + 1)%>>[��һҳ]</a>
				<%
					}
						if (pageCount > 8) {
				%> <a
				href=<%="teacher/teacher.jsp?function=choose_stu1&pageNow="
							+ pageCount%>>[βҳ]</a>
				<%
					}
				%>
			</td>
			<%
				} else {
			%>
			<td colspan="8" scope="col" align="center" height="30px">��ѯ�޽��</td>
			<%
				}
			%>
			</div>
			</td>
		</tr>

	</table>
	<table border="0" align="center">
		<td colspan="7" align="center">(ע�⣺�����Ŀ���޸ģ����ѧ���ɲ鿴ѧ��������Ϣ)</td>
	</table>
</form>