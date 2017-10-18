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
<form action="homepageGuarantee/upOrDownHomepageGuarantee" class="table_form"method="post" id="deleteVIPMerchantAccount" enctype="multipart/form-data">
	<table class="table_list">
		<tr>
			<td colspan="4">确认该职位改变首页担保状态？</td>
				<td style="display:none"><input type='text' value="${data.recruitingId}" name='recruiting_id' id="hzn_idd"/></td>
		</tr>
		<tr>
			<td align="right" >首页担保起始日期:</td>
			<td><input class="easyui-datebox" name="hzn_good_begin_time" required
				id="hzn_good_begin_time"
				data-options="onSelect:onSelect"
				style="width: 150px"></td>
		</tr>
		<tr>
			<td align="right">首页担保截止日期:</td>
			<td><input class="easyui-datebox" name="hzn_good_end_time" required
				id="hzn_good_end_time"
				data-options="onSelect:onSelect"
				style="width: 150px"></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog" id="hzn_change_homepage_guarantee_state"
					style="float: right">确定</button>
			</td>
		</tr>
	</table>
</form>
<script>
	function onSelect(d) {
	    var issd = this.id == 'hzn_good_begin_time',sd = issd ? d : new Date($('#hzn_good_begin_time').datebox('getValue')), ed = issd ? new Date($('#hzn_good_end_time').datebox('getValue')) : d;
	        if (ed < sd) {
	        	$.messager.show({
	                  title:'注意',
	                  msg:'截止日期小于起始日期'
	              });
	            //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
	            $('#hzn_good_end_time').datebox('setValue', '').datebox('showPanel');
	        }
	    }
			

</script>