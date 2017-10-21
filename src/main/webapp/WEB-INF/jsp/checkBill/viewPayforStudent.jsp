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
             <th>工作名称：</th>
             <td >
                 <input type="text" name="serial_number" value="${salaryInfo.postName}" class="easyui-textbox easyui-validatebox"  readonly="readonly" data-options="width:'100%' "/>
             </td>
         </tr>
         <tr>
             <th>结算序号：</th>
             <td >
                  <input type="text"  name="parameter_name" value="${salaryInfo.settlementNum}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>结算时间：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.settlementTime}" class="easyui-textbox easyui-validatebox easyui-datetimebox" showSeconds="false" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>应发金额：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.total_Pay_Amount}" class="easyui-textbox easyui-validatebox easyui-numberbox" readonly="readonly" precision="2" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>扣减金额：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.wageDeductions}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>扣减原因：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.deductingReason}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>奖励金额：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.bounty}" class="easyui-textbox easyui-validatebox easyui-numberbox" readonly="readonly" precision="2" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>奖励原因：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.rewardsCausation}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>实发金额：</th>
             <td ><input type="text" name="parameter" value="${salaryInfo.finalPay}" class="easyui-textbox easyui-validatebox easyui-numberbox" precision="2" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
            </td>
        </tr>
     </table>

