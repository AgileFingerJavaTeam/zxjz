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
<form action="GyStation/editDetails" class="table_form" method="post">			
     <table class="table_list">
     	<tr>
        	<th width="70">职位类型名称：</th>
            <td ><input type="hidden" name="station_id" value="${data.station_id}"/>
                 <input type="text"  name="station_name" value="${data.station_name}"  class="easyui-textbox easyui-validatebox"  data-options="required:true,width:'100%'"/>
            </td>
        </tr>
        <tr>
            <td colspan="4">
               	<button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
               	<button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>