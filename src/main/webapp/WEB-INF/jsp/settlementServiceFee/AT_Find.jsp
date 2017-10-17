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
	<table cellpadding="10" id="at-position-table" class="table_list">
		<tr>
		 	<td style="display:none"><input type='text' id='at_merchant_id' name='user_id' /></td>
		    <td style="text-align: right" width="120px">商户名称:</td>
			<td colspan="1"><input  class="wu-text easyui-combobox" id="at_add_name"
              name="merchants_name" value="${data.merchants_name}" style="width: 250px" disabled  data-options="
					url:'securityPosition/SaddAT',
					method:'get',
					valueField:'user_id',
					textField:'merchants_name',
					panelHeight:'auto'">
		   </td>
		    <td style="text-align: right" width="120px">收费流水号:</td>
			<td><input type="text" name="withdrawal_serial_number" id="withdrawal_serial_number" value="${data.withdrawal_serial_number}" class="easyui-textbox"
				style="width: 250px" disabled /></td>
		</tr>
		<tr>
		 	<td style="text-align: right">收费时间:</td>
			<td><input class="easyui-datetimebox"name="settlement_time" value="${data.settlement_time }"
				data-options="required:true,showSeconds:false" style="width: 250px" disabled>
		   </td> 
			<td style="text-align: right">结算费用分类:</td>
			<td>
				<select name="classification_of_settlement_expenses" class="easyui-combobox" style="width: 250px" disabled>
					<option value="0" <c:if test="${data.classification_of_settlement_expenses=='0'}">selected="selected"</c:if>>代付工资</option>
					<option value="1" <c:if test="${data.classification_of_settlement_expenses=='1'}">selected="selected"</c:if>>平台服务费</option>
				</select>
			</td>
		</tr>
		<tr>
		<td style="text-align: right">收费金额:</td>
			<td><input type="text" name="settlement_amount"
				class="easyui-textbox" value="${data.settlement_amount}" style="width: 250px" disabled /></td>
		<td style="text-align: right">操作员:</td>
			<td><input type="text" name="" value="${data.employees_name}" class="easyui-textbox"
				style="width: 250px"  disabled /></td>
		</tr>
		<tr>
			<td style="text-align: right">说明:</td>
			<td colspan="3">
			<input class="easyui-textbox"  name="instructions" value="${data.instructions}" data-options="multiline:true,validType:'length[1,200]'," invalidMessage="最大长度不能超过200字"   style="width:700px;height:100px" disabled>
			</td>
		</tr>
	</table>
<div id="dd" style="display:none"></div>

	
	