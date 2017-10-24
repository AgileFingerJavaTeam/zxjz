<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<form action="StuMsg/updateStatus"id="form1" class="table_form" method="post">
     <table class="table_list">
         <tr >

             是否标记为已读？

             <input type="hidden" name="user_id" value="${id}"/>
         </tr>

        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >取消</button>
                <button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>
<script>


</script>

