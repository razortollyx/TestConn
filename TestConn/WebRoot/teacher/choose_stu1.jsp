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

	String[] color = { "#D3F0F3", "#B0C4DE" };//�����ɫ  transparent�����ɫ
	
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
	 if ( wish == 5 ) {//stage != 1
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
<td width=8% align="center">״̬</td>
<td width=8% align="center">������ʦ־Ը</td>

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
			/* 			for (; j <rowCount ; j++) { ֮ǰ��ѭ��*/
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
	    	
	    }//ÿ����Ŀ�м���ѧ��ѡ(���ڿ��������˫��ѭ������ϲ��С���)
	    for(int kk=0;kk<chunchu.length;kk++){
	    if(chunchu[kk]!=0){
	    	System.out.println("chunchu"+chunchu[kk]);
	    	chunchu[sub_num]=chunchu[kk];
	    	sub_num++;
	     }
	    }//�м�����Ŀ��ѧ��ѡ��(����ʦ����������Ŀ������ֻ���ĸ���ѧ��ѡ��)
	    
	    
		    		
%>		    		

		    	
		    
		    
		        
<% 		       
		         	
 	
		int testk01=0;
   		for(int test01=0;test01<sub_num;test01++){
   		 
   		
 %>

 
 
<tr>
 <th rowspan="<%=chun[test01]+1%>"><%=chunchu[test01]%></th>  
 <th rowspan="<%=chun[test01]+1%>"><%=sbc1.getSubjectById(String.valueOf(chunchu[test01])).getTitle()%></th>
 <th rowspan="<%=chun[test01]+1%>"><%=tbc1.getTeacherById(tsbc1.getTeaId(chunchu[test01])).getName()%></th>
 <!-- ���ڿ��� -->
 <%
 		    
			String a = "����";
			String b = "����ѡ��";
			String c = "��ʦ��ѡ����ѧ��";

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
            
  
            
			/* 			for (; j <rowCount ; j++) { ֮ǰ��ѭ��*/
			for (int j=0; j < arrSSTB.size(); j++) {
			    
				StuSubTeaBean sstb = arrSSTB.get(j);
				//Collections.sort(arrSSTB);
				
				/*
				kangkang 2015.11.11
				�������ȡ��ʦѧ����Ŀ���ֵ���Ϣ
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
				onclick="showGaryBox('ѧ��������Ϣ','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center">��<%=sstb.getWish()%>־Ը</td>
			<td align="center"><%=Tools.getDescribeOfState1(sstb.getState())%></td>
			<td><div align="center">
					<select id="wish_type<%=j%>" name="">
						<option value="0"></option>
						<option value="1">��1־Ը</option>
						<option value="2">��2־Ը</option>
						<option value="3">��3־Ը</option>
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
			
			<%-- <td align="center"><%=sstb.getStuName()%></td> --%>
			<td><input id="ser" name="a<%=j%>" type="text"
				style="background: transparent; border-style: none; width: 100%; height: 100%;"
				value="<%=sstb.getStuName()%>"
				onclick="showGaryBox('ѧ��������Ϣ','teacher/studentinfo.jsp?stu_id=<%=sstb.getStuId()%>')"></td>
			<td align="center">��<%=sstb.getWish()%>־Ը</td>
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
			}
			}
		%>	
	<table border="0" align="center">
	   ע�����ѧ�����ƿ��Բ鿴ѧ��������Ϣ
	</table>
	    <%	
			}else{
		%>	
		<table>
		<tr>
		<th>���ڲ��Ƿ���־Ը�׶Σ����<a
			href="teacher/teacher.jsp?function=..//common/stage">ѡ��׶�</a>�鿴���׶�ʱ�����飡</th>
	</tr>
          </table>                         
		<%	
			
			
			}
		%>	
		
		

	</table>
	
</form>
  </body>
</html>