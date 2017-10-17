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
             <td ><input type="text"  value="${PaymentInfo.merchants_name}" class="easyui-textbox easyui-validatebox"  readonly="readonly" data-options="width:'100%' "/></td>
         </tr>
         <tr>
             <th>应收款序号：</th>
             <td >
                  <input type="text"  value="${PaymentInfo.serial_number}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>欠款时间：</th>
             <td ><input type="text"  value="${PaymentInfo.arrears_time}" class="easyui-textbox easyui-validatebox easyui-datetimebox" showSeconds="false" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>结算序号：</th>
             <td ><input type="text"  value="${PaymentInfo.clear_num}" class="easyui-textbox easyui-validatebox " readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
         <tr>
             <th>应收款金额：</th>
             <td ><input type="text"  value="${PaymentInfo.deductedS}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
         <tr>
             <th>实扣款金额：</th>
             <td ><input type="text"  value="${PaymentInfo.deductedI}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>应收金额：</th>
             <td ><input type="text"  value="${PaymentInfo.actual_amount}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>是否收回：</th>
             <td ><input type="text"  value="${PaymentInfo.is_back}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>收回日期：</th>
             <td ><input type="text"  value="${PaymentInfo.back_time}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>充值序号：</th>
             <td ><input type="text"  value="${PaymentInfo.prepaid_number}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
            </td>
        </tr>
     </table>

