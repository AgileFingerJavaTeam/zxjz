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
<form action="StarEnterpriseLoGo/editLogo" id="form1" class="table_form" method="post" enctype="multipart/form-data">
    <table class="table_list">
        <tr >
            <th width="100" >缩略图：</th>
            <td>
                <input type="hidden" id="icon_id" name=icon_id value="${data.iconId}" style="width: 249px; display: none" />
                <a href="TP/${data.pictureUrl}" target="_blank" ><img alt="企业logo" src="TP/${data.pictureUrl}" width=130px height=100px></a>
                <input  id="carouselFile" style="width: 124px" runat="server" value="${data.pictureUrl}"name="picture_url" type="file" />
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float: right">关闭</button>
                <button type="button" class="table_form_submit_file_dialog" style="float: right">确定</button>
            </td>
        </tr>
    </table>
</form>
<script>


</script>


