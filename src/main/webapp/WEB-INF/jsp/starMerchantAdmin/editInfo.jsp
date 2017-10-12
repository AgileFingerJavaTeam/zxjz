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
<form action="StarMerchant/changeStarStatus" class="table_form" method="post" enctype="multipart/form-data">
	<table class="table_list">
		<tr>
			<td>确认该企业改变明星雇主状态？</td>
				<td style="display:none"><input type='text' value="${data.user_id}" name='user_id' id="hzn_idd"/></td>
				<td style="display:none"><input type='text' value="${data.is_star}" name='change' id='hzn_is_star_state'/></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog" id="hzn_change_is_star_state"
					style="float: right">确定</button>
			</td>
		</tr>
	</table>
</form>
<script>
		$("#hzn_change_is_star_state").click(function(){
			var state=$("#hzn_is_star_state").val();
			if(state=="否"||state==""){
				$("#hzn_is_star_state").val("是");
			}else{
				$("#hzn_is_star_state").val("否");
			}
		});
			

</script>