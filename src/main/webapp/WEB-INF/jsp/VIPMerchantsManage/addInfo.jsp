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
<form action="VIPMerAccount/addVIPMerchantAccount" class="table_form"method="post" id="addVIPMerchantAccount" enctype="multipart/form-data">
	<table class="table_list">
		<tr>
			<td style="text-align:center">公司名称：</td>
             <td><input id="hzn_addVIP_name" class="wu-text easyui-combobox"
              name="merchants_name" style="width: 250px" required 
              data-options="
					url:'VIPMerAccount/findMerchantName',
					method:'get',
					valueField:'user_id',
					textField:'merchants_name',
					panelHeight:'auto',										
				"></td>
				<td style="display:none"><input type='text' id='merchant_id' name='user_id' /></td>
		</tr>
		<tr>
			<td align="right">VIP起始日期:</td>
			<td><input class="easyui-datebox" name="vip_start" required
				id="hzn_addVIP_sd"
				data-options="onSelect:onSelect"
				style="width: 150px"></td>
		</tr>
		<tr>
			<td align="right">VIP截止日期:</td>
			<td><input class="easyui-datebox" name="vip_end" required
				id="hzn_addVIP_ed"
				data-options="onSelect:onSelect"
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
		 $("#hzn_addVIP_name").combobox({
			panelHeight:'auto',
			onChange: function () {		         
		         var id=$('#hzn_addVIP_name').val();
	             if(id!=''){
	             	$('input#merchant_id').val(id);
	             }		   
			}
		}); 
		
		 function onSelect(d) {
			    var issd = this.id == 'hzn_addVIP_sd', sd = issd ? d : new Date($('#hzn_addVIP_sd').datebox('getValue')), ed = issd ? new Date($('#hzn_addVIP_ed').datebox('getValue')) : d;
			        if (ed < sd) {
			        	$.messager.show({
			                  title:'注意',
			                  msg:'截止日期小于起始日期'
			              });
			            //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
			            $('#hzn_addVIP_ed').datebox('setValue', '').datebox('showPanel');
			        }
			    } 
</script>