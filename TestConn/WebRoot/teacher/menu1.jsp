<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table class="dtree"  style="vertical-align:top">
	<script type="text/javascript"  style="vertical-align:top">
			d = new dTree('d');
			/*
			dTree.add(id,pid,name,url,title,target,icon,iconOpen,open); 
			id:��ǰ�ڵ��ʶ, 
			pid:���ڵ��ʶ,
			name:��ǰ�ڵ�����,
			url:���˵������ʱ��Ӧ�ĳ�����,
			title:��ʾ�������ȥ����ʾ��
			target:��Ŀ�괰�ڴ����ӣ�ûŪ����
			icon:�ر�ʱ����ʾͼ��,
			iconOpen:��ʱ����ʾͼ��,
			open:Ĭ�ϵĴ�״̬,
			true��,
			false�ر�(���������cookie, ������ʱ������Ч��)			
			*/
			d.add("root", -1, '��ʦ����');
			d.add("info", "root", '������Ϣ');
			d.add("info_view", "info", '�ҵ���Ϣ', 'teacher/teacher.jsp?function=info_view');
			d.add("info_modify", "info", '��Ϣ�༭', 'teacher/teacher.jsp?function=info_modify');
			d.add("psw_modify", "info", '�����޸�', 'teacher/teacher.jsp?function=psw_modify');
			d.add("subject", "root", '�������');
			d.add("info_mine", "subject", '������֪���ض���', 'teacher/teacher.jsp?function=attentions');
			d.add("sub_mine", "subject", '�ҵ���Ŀ', 'teacher/teacher.jsp?function=sub_mine');
			d.add("sub_add", "subject", '�����Ŀ', 'teacher/teacher.jsp?function=sub_add');
			d.add("sub_all", "subject", '������Ŀ', 'teacher/teacher.jsp?function=sub_all');
			d.add("sub_all1", "subject", '������Ŀ', 'teacher/teacher.jsp?function=sub_all1');
			//d.add("document", "subject", '��ҵ���ָ����', 'teacher/teacher.jsp?function=document');
			d.add("sh", "root", '��Ŀ���');
			d.add("sub_verify", "sh", '��Ŀ���', 'teacher/teacher.jsp?function=sub_verify'); 
			d.add("sub_choose", "root", 'ѡ�����');
			//d.add("choose_stu", "sub_choose", 'ѡ��ѧ��', 'teacher/teacher.jsp?function=choose_stu');
			d.add("choose_sp_stu", "sub_choose", '����ѧ��', 'teacher/teacher.jsp?function=choose_sp_stu');
			d.add("choose_stu1", "sub_choose", 'ѡ��ѧ��', 'teacher/teacher.jsp?function=choose_stu1');
			d.add("choose_tearesult", "sub_choose", 'ѡ����', 'teacher/teacher.jsp?function=choose_tearesult');
			//d.add("result", "sub_choose", 'ѡ����', 'teacher/teacher.jsp?function=choose_result');
			//d.add("result2", "sub_choose", 'ѡ����2', 'teacher/teacher.jsp?function=choose_result2');
			d.add("notice", "root", '֪ͨ����');
			d.add("not_chooseStage", "notice", 'ѡ��׶�', 'teacher/teacher.jsp?function=..//common/stage');
			d.add("not_info", "notice", 'ͨ����Ϣ', 'teacher/teacher.jsp?function=..//common/notice_all');
			
			d.add("use_info", "root", 'ʹ����֪');
			d.add("use_info_1", "use_info", 'ϵͳ˵��', 'teacher/teacher.jsp?function=attentions1');
			d.add("use_info_2", "use_info", 'ʹ��ָ��', 'teacher/teacher.jsp?function=attentions2');
			document.write(d);
		</script>

</table>

