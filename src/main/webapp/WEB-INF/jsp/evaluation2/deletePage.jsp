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
<form action="GyStation/delCDetails" class="table_form" method="post">			
     <table class="table_list">
         <tr>
             <td width=100% >确定删除吗？
             <input  type="hidden" name="station_id" value="${data.data.childJobInfo.stationId}"/>
             </td>
         </tr>
         <tr>
            <td>
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
         </tr>
     </table>
</form>
