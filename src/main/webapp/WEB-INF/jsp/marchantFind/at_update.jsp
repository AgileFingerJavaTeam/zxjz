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
<form action="MarchantFind/editMarchant" class="table_form" method="post">
    <input type="text"  name=id
           value="${data.userId}" style="display: none; " />
    <input type="text"  name=isLook
           value="${data.isLook}" style="display: none; " />
    <table cellpadding="10"  class="table_list" >
        <tr style="height: 100px;">
            <td style="text-align: center;">是否改为已读状态？</td>
        </tr>
        <tr style="height: 60px;">
            <td>
                <button type="button" class="table_form_close_dialog "
                        style="float: right">关闭</button>
                <button type="button" class="table_form_submit_dialog"
                        style="float: right">确定</button>
            </td>
        </tr>
    </table>
</form>