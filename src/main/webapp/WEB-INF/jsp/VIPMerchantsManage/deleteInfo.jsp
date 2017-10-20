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
<form action="VIPMerAccount/deleteVIPMerchant" class="table_form"method="post" id="deleteVIPMerchantAccount" enctype="multipart/form-data">
	<table class="table_list">
		<tr>
			<td>确认删除这个公司VIP权限么？</td>
				<td style="display:none"><input type='text' value="${data.data.userId}" name='user_id'/></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog"
					style="float: right">确定</button>
			</td>
		</tr>
	</table>
</form>
<script>
		 $("#hzn_addVIP_name").combobox({
			panelHeight:'auto',
			onChange: function () {		         
		         var id=$('#hzn_addVIP_name').val();
	             if(id!=''){
	             	$('input#merchant_id').val(id);
	             }		   
			}
		}); 
</script>