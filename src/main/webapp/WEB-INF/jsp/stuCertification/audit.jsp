<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<form id="auditStu" action="stuCertification/substudentinfo" class="table_form" method="post">	
 <table class="table_list">
         <tr>
             <th>学生姓名：</th>
			 <td><input  id="Stuname" name="name" value="${data.data.name}" width="100%" readonly="readonly" style="border:0px">
			 	<input name="user_id" value="${data.data.userId}"type="hidden">
			 </td>
         </tr>
         <tr>
             <th>学生证：</th>
			 <td> <a href="TP/${studentcard_pic}" target="_blank" ><img alt="学生证照片" src="TP/${data.data.studentcardPic}" width=150px height=200px></a>
                  <input name="url" value="${data.data.studentcardPic}" style="display:none"/>
			 </td>
         </tr>
         <tr>
             <th>学号：</th>
			 <td><input  id="stu_number" name="stu_number" value="${data.data.stuNumber}" width="100%" readonly="readonly" style="border:0px">
			 </td>
         </tr>
         <tr>
             <th>身份证：</th>
			 <td> <a href="TP/${idcard_pic}" target="_blank" ><img alt="身份证照片" src="TP/${data.data.idcardPic}" width=150px height=200px></a>
                  <input name="url" value="${data.data.idcardPic}" style="display:none"/>
			 </td>
         </tr>
         <tr>
             <th>身份证号码：</th>
			 <td><input  id="id_card" name="id_card" value="${data.data.idCard}" width="100%" readonly="readonly" style="border:0px">
			     <input  type="hidden"  value="${data.data.checkState}"   name="check_state">
			     <input type="hidden" class="stat_res" name="stat_res" value="0"/>
			     <input  type="hidden" id="check_state" name="check_state" value="${data.data.checkState}" width="100%" readonly="readonly" style="border:0px">
			 </td>
         </tr>
         <tr>
            <td colspan="4">          
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog srt_reject" style="float:right">驳回</button>
                <button type="button" class="table_form_submit_dialog srt_pass" style="float:right">通过</button>
            </td>
         </tr>
 </table>
 </form>
 <script>
 $(document).ready(function(){
		var a=$("input[name='check_state']").val();	
		if(a!='0'){
			$('.srt_reject').hide();
			$('.srt_pass').hide();
		}	
	});

	
   $(".srt_reject").on('click',function(){ 
 	 $(".stat_res").val("1");		
  }); 
 </script>