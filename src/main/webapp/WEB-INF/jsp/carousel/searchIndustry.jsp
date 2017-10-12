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
<form action="IndustryManage/searchIndustry" class="table_form"method="post" id="addCarousel" enctype="multipart/form-data">
	<table class="table_list">
<tr>
			<td align="right">行业分类名称:</td>
			<td><input id="job_name" name="job_name"  class="easyui-textbox"  style="width:200px">
			
</td>
</tr>
</table>
</form>

	