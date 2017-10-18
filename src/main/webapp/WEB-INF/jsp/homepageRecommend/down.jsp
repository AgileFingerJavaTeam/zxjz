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
<form action="homepageRecommend/downHomepageRecommend" class="table_form"method="post"  enctype="multipart/form-data">
	<table class="table_list">
		<tr>
			<td>确认该职位改变首页推荐状态？</td>
				<td style="display:none"><input type='text' value="${data.recruitingId}" name='recruiting_id' id="hzn_idd"/></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog" id="hzn_close_homepage_guarantee_state"
					style="float: right">确定</button>
			</td>
		</tr>
	</table>
</form>
