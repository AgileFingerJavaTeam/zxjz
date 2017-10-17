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
<form action="AuthManagement/AddAuthManagement" class="table_form" method="post">			
     <table class="table_list">
       	<tr>
        	<th width="100">权限分组名称：</th>
            <td>
      			<input type="hidden" name="permission_grouping_id" value="${data.permission_grouping_id}"/>
            	<input type="text"  name="permission_grouping_name" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
            </td>
        </tr>
        <tr>
        	<th width="100">菜单名称：</th>
            <td>
            	<input type="hidden" name="hidden_menu_id" id="hidden_menu_id"/>
            	<input class="easyui-combobox" 
            		   id="gy_menu"	
					   name="language"
					   data-options="
					   url:'AuthManagement/getMenuName',
					   method:'get',
					   valueField:'menu_id',
					   textField:'menu_name',
					   panelHeight:'auto'"
					   multiple="multiple"
				>
            </td>
        </tr>
        <tr>
            <td colspan="4">
               	<button type="button" class="table_form_close_dialog" style="float:right" >关闭</button>
               	<button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>
<script>
	 $('#gy_menu').combobox({
		onChange: 
			function(rec){
			$('#hidden_menu_id').val($('#gy_menu').combobox('getValues').join(','));
			},
	 	/* onUnselect:
		 	function(rec){var val = $('#gy_menu').combobox('getValues').join(',');
			$('#hidden_menu_id').val(val);} */
	 });
	 
</script>