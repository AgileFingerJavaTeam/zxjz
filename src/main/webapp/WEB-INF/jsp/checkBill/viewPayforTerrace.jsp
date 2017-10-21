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
             <td ><input type="text" name="serial_number" value="${costInfo.data.merchantsName}" class="easyui-textbox easyui-validatebox"  readonly="readonly" data-options="width:'100%' "/></td>
         </tr>
         <tr>
             <th>结算序号：</th>
             <td >
                  <input type="text"  value="${costInfo.data.withdrawalSerialNumber}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>费用分类：</th>
             <td ><input type="text"  value="${costInfo.data.clearingFeeName}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
         </tr>
         <tr>
             <th>结算时间：</th>
             <td ><input type="text"  value="${costInfo.data.settlementTime}" class="easyui-textbox easyui-validatebox easyui-datetimebox" showSeconds="false" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>结算金额：</th>
             <td ><input type="text"  value="${costInfo.data.settlementAmount}" class="easyui-textbox easyui-validatebox easyui-numberbox" readonly="readonly" precision="2" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>结算说明：</th>
             <td ><input type="text"  value="${costInfo.data.instructions}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
             <th>操作员工：</th>
             <td ><input type="text"  value="${costInfo.data.employeesName}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
            </td>
        </tr>
     </table>

