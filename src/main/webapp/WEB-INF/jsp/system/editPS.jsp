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
<form action="System/srt_editParameter" class="table_form" method="post">			
     <table class="table_list">
         <tr>
             <th>参数编号：</th>
             <td ><input type="text" name="serial_number" value="${data.data.serialNumber}" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/></td>
         </tr>
     
         <tr>
             <th width="70">参数名：</th>
             <td ><input type="hidden" name="parameter_id" value="${data.data.parameterId}"/>
                  <input type="text"  name="parameter_name" value="${data.data.parameterName}" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>参数描述：</th>
             <td ><input type="text" name="parameter_description" value="${data.data.parameterDescription}" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/></td>
         </tr>
         <tr>
             <th>参数值：</th>
             <td ><input type="text" name="parameter" value="${data.data.parameter}" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>