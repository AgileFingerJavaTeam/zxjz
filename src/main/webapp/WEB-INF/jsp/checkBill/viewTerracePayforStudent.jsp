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
             <td ><input type="text"  value="${PaymentInfo.data.merchantsName}" class="easyui-textbox easyui-validatebox"  readonly="readonly" data-options="width:'100%' "/></td>
         </tr>
         <tr>
             <th>应收款序号：</th>
             <td >
                  <input type="text"  value="${PaymentInfo.data.serialNumber}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>欠款时间：</th>
             <td ><input type="text"  value="${PaymentInfo.data.arrearsTime}" class="easyui-textbox easyui-validatebox easyui-datetimebox" showSeconds="false" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>结算序号：</th>
             <td ><input type="text"  value="${PaymentInfo.data.clearNum}" class="easyui-textbox easyui-validatebox " readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
         <tr>
             <th>应收款金额：</th>
             <td ><input type="text"  value="${PaymentInfo.data.deductedS}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
         <tr>
             <th>实扣款金额：</th>
             <td ><input type="text"  value="${PaymentInfo.data.deductedI}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>应收金额：</th>
             <td ><input type="text"  value="${PaymentInfo.data.actualAmount}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>是否收回：</th>
             <td ><input type="text"  value="${PaymentInfo.data.isBack}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>收回日期：</th>
             <td ><input type="text"  value="${PaymentInfo.data.backTime}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>充值序号：</th>
             <td ><input type="text"  value="${PaymentInfo.data.prepaidNumber}" class="easyui-textbox easyui-validatebox" readonly="readonly" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
            </td>
        </tr>
     </table>

