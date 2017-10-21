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
<form action="employer/audit" class="table_form" method="post">
	 <table class="table_list">
	     <tr>
             <th>选择受理员工：</th>
			 <td><input  id="srt_cbox" name="employees_name" width="100px">
		     <input type="hidden" name="user_id" value="${data1.data.userId}"/>
			 </td>
         </tr>
		 <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog" style="float:right">通过审核</button>
            </td>
         </tr>
	
	 </table>
</form>

<script type="text/javascript">                                
  //绑定下拉框
 $('#srt_cbox').combobox({
         url:'employer/getAccEm',
         valueField: 'employeesId',
         textField: 'employeesName'
         });                            
 $("#srt_cbox").combobox('getValues')
</script>