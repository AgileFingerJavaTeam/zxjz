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
             <td ><input type="text"  value="${withdrawInfo.merchants_name}" class="easyui-textbox easyui-validatebox"  readonly="readonly" data-options="required:true,width:'100%' "/></td>
         </tr>
         <tr>
             <th>提现序号：</th>
             <td >
                  <input type="text"  value="${withdrawInfo.withdrawal_sequence_number}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="required:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>提现方式：</th>
             <td ><input type="text"  value="${withdrawInfo.withdrawal_mode_name}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="required:true,width:'100%'"/></td>
         </tr>
         <tr>
             <th>提现时间：</th>
             <td ><input type="text"  value="${withdrawInfo.withdrawal_time}" class="easyui-textbox easyui-validatebox easyui-datetimebox" showSeconds="false" readonly="readonly" data-options="required:true,width:'100%'"/></td>
        </tr>
        <tr>
             <th>提现金额：</th>
             <td ><input type="text"  value="${withdrawInfo.withdrawal_amount}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="required:true,width:'100%'"/></td>
        </tr>
         <tr>
             <th>支付平台流水号：</th>
             <td ><input type="text"  value="${withdrawInfo.payment_platform_flow_number}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="required:true,width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
            </td>
        </tr>
     </table>

