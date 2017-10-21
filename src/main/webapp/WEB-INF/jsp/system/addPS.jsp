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
<form action="System/insertParameter" class="table_form" method="post">			
     <table class="table_list">
         <tr>
             <th>参数编号：</th>
             <td ><input type="text" name="serial_number"  class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/></td>
         </tr>
         <tr>
             <th width="70">参数名：</th>
             <td >
                  <input type="text"  name="parameter_name"  class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th>参数描述：</th>
             <td ><input type="text" name="parameter_description"  class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/></td>
         </tr>
         <tr>
             <th>参数值：</th>
             <td ><input type="text" name="parameter"  class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/></td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>
