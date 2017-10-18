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
<form action="VIPMerAccount/editVIPMerchant" class="table_form" method="post" id="editVIPMerchantAccount" enctype="multipart/form-data">
	<table class="table_list">
		<tr>
			<td style="text-align:center">公司名称：</td>
             <td><input id="hzn_editVIP_name" class="wu-text easyui-combobox" readonly="readonly"
              name="merchants_name" style="width: 250px" required value="${data.data.merchantsName}"></td>
				<td><input type='text' name='user_id' value="${data.data.userId}" style="display:none"/></td>
		</tr>
		<tr>
			<td align="right">VIP起始日期:</td>
			<td><input class="easyui-datebox" name="vip_start" required
				id="hzn_editVIP_sd"
				data-options="onSelect:onSelect"
				value="${data.data.vipStart}"
				style="width: 150px"></td>
		</tr>
		<tr>
			<td align="right">VIP截止日期:</td>
			<td><input class="easyui-datebox" name="vip_end" required
				id="hzn_editVIP_ed"
				data-options="onSelect:onSelect"
				value="${data.data.vipEnd}"
				style="width: 150px"></td>
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
	function onSelect(d) {
	    var issd = this.id == 'hzn_editVIP_sd',sd = issd ? d : new Date($('#hzn_editVIP_sd').datebox('getValue')), ed = issd ? new Date($('#hzn_editVIP_ed').datebox('getValue')) : d;
	        if (ed < sd) {
	        	$.messager.show({
	                  title:'注意',
	                  msg:'截止日期小于起始日期'
	              });
	            //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
	            $('#hzn_editVIP_ed').datebox('setValue', '').datebox('showPanel');
	        }
	    }
</script>
