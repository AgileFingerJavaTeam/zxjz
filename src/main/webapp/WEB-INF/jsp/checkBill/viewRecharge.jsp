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
     <table class="table_list">
         <tr>
             <th>商户名称：</th>
             <td ><input type="text"  value="${payInfo.merchants_name}" class="easyui-textbox easyui-validatebox"  readonly="readonly" data-options="width:'100%' "/></td>
         </tr>
         <tr>
             <th>充值序号：</th>
             <td >
                  <input type="text"  value="${payInfo.recharge_sequence_number}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>充值方式：</th>
             <td ><input type="text"  value="${payInfo.recharge_mode_name}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
         </tr>
         <tr>
             <th>充值时间：</th>
             <td ><input type="text"  value="${payInfo.recharge_time}" class="easyui-textbox easyui-validatebox easyui-datetimebox" showSeconds="false" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>充值金额：</th>
             <td ><input type="text"  value="${payInfo.amount_of_recharge}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2"readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
         <tr>
             <th>支付平台流水号：</th>
             <td ><input type="text"  value="${payInfo.payment_platform_flow_number}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
         <tr>
             <th>操作员工：</th>
             <td ><input type="text"  value="${payInfo.employees_name}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>充值说明：</th>
             <td ><input type="text"  value="${payInfo.recharge_declare}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
            </td>
        </tr>
     </table>

