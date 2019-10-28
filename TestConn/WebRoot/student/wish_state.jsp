<%@ page language="java" import="java.util.*,com.kk.subject.model.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	 ArrayList<StuWishBean> arrSSTB;
	 String sub_id=request.getParameter("sub_id");
	
	 arrSSTB = new StuWishBeanCI().getStuWishById(sub_id);
     int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0;
    
%>
<table border="1">
    <tr>
		<td>题目编号</td>
		<td><%=sub_id%></td>
	</tr> 
	
	<%
	for (int j = 0; j < arrSSTB.size(); j++) {
			StuWishBean sstb = arrSSTB.get(j);
			if(Integer.parseInt(sstb.getWishNum())==1) a1++;
			if(Integer.parseInt(sstb.getWishNum())==2) a2++;
			if(Integer.parseInt(sstb.getWishNum())==3) a3++;
			if(Integer.parseInt(sstb.getWishNum())==4) a4++;
			if(Integer.parseInt(sstb.getWishNum())==5) a5++;
			if(Integer.parseInt(sstb.getWishNum())==6) a6++;
	}
	 %>
    <tr>
    
		<td>第一志愿人数</td>
		<td><%=a1 %></td>
	</tr> 
	<tr>
    
		<td>第二志愿人数</td>
		<td><%=a2 %></td>
	</tr> 
	<tr>
    
		<td>第三志愿人数</td>
		<td><%=a3 %></td>
	</tr> 
	<tr>
    
		<td>第四志愿人数</td>
		<td><%=a4 %></td>
	</tr> 
	<tr>
    
		<td>第五志愿人数</td>
		<td><%=a5 %></td>
	</tr> 
	<tr>
    
		<td>第六志愿人数</td>
		<td><%=a6 %></td>
	</tr> 
	
	
	

	<%-- <tr>
		<td>最大出题数</td>
		<td><%=tb.getMaxSubNum() %></td>
	</tr> --%>

</table>
