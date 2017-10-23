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
<form action="authority/subdelete" class="table_form" method="post">			
     <table class="table_list">
         <tr >
             
             <td >
             	确认删除吗？
             	<input type="hidden" name="employees_id" value="${data.data.employeesId}"/>
            	
             </td>           
         </tr>
              
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >取消</button>               
                <button type="button" class="bxw_pass table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>
