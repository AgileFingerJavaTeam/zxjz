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
	<table cellpadding="10" id="at-position-table" class="table_list">
		<tr>
			<td style="text-align: right">发布时间:</td>
			<td><input type="hidden" name="recruiting_id"
				value="${data.recruiting_id}">
				<input type="hidden" name="user_id"
				value="${data.user_id}">
				 <input
				class="easyui-datetimebox" name="release_time"
				data-options="required:true,showSeconds:false"
				value="${data.release_time}" style="width: 250px" required disabled></td>
			<td style="text-align: right">刷新时间:</td>
			<td><input class="easyui-datetimebox" name="refresh_time"
				data-options="required:true,showSeconds:false"
				value="${data.refresh_time}" style="width: 250px" required disabled></td>
		</tr>
		<tr>
			<td style="text-align: right">岗位名称:</td>
			<td><input type="text" name="post_name"
				value="${data.post_name}" class="easyui-textbox"
				style="width: 250px" disabled /></td>
			<td style="text-align: right">岗位分类:</td>
			<td><input type="text" name="post_classification"
				value="${info.station_name}" class="easyui-textbox"
				style="width: 250px" required disabled/></td>
		</tr>

		<tr>
			<td style="text-align: right">详情页面分类:</td>
			<td><select id="cc_edit" class="easyui-combobox"
				name="details_page_category" style="width: 250px;" required disabled>
					<option value="普通"
						<c:if test="${data.details_page_category=='普通'}">selected="selected"</c:if>>普通</option>
					<option value="担保"
						<c:if test="${data.details_page_category=='担保'}">selected="selected"</c:if>>担保</option>
			</select></td>
			<td style="text-align: right">是否上首页担保:</td>
			<td><select id="cc_guarantee" class="easyui-combobox"
				name="whether_on_homepage_guarantee" style="width: 250px;" required disabled>
					<option value="是"
						<c:if test="${data.whether_on_homepage_guarantee=='是'}">selected="selected"</c:if>>是</option>
					<option value="否"
						<c:if test="${data.whether_on_homepage_guarantee=='否'}">selected="selected"</c:if>>否</option>
			</select></td>
		</tr>
		<tr>
			<td style="text-align: right">首页担保开始日期:</td>
			<td><input class="easyui-datetimebox" name="good_begin_time"
				data-options="required:true,showSeconds:false"
				value="${data.good_begin_time}" style="width: 250px" required disabled></td>
			<td style="text-align: right">首页担保结束日期:</td>
			<td><input class="easyui-datetimebox" name="good_end_time"
				data-options="required:true,showSeconds:false"
				value="${data.good_end_time}" style="width: 250px" required disabled></td>
		</tr>

		<tr>
			<td style="text-align: right">是否上首页推荐:</td>
			<td><select id="cc_Recommend" class="easyui-combobox"
				name="whether_on_homepage_recommend" style="width: 250px;" required disabled>
					<option value="是"
						<c:if test="${data.whether_on_homepage_recommend=='是'}">selected="selected"</c:if>>是</option>
					<option value="否"
						<c:if test="${data.whether_on_homepage_recommend=='否'}">selected="selected"</c:if>>否</option>
			</select></td>
			<td style="text-align: right">推荐开始日期:</td>
			<td><input class="easyui-datetimebox"
				name="recommend_begin_time"
				data-options="required:true,showSeconds:false"
				value="${data.recommend_begin_time}" style="width: 250px" required disabled></td>
		</tr>
		<tr>
			<td style="text-align: right">推荐结束日期:</td>
			<td><input class="easyui-datetimebox" name="recommend_end_time"
				data-options="required:true,showSeconds:false"
				value="${data.recommend_end_time}" style="width: 250px" required disabled></td>
			<td style="text-align: right">工作日期:</td>
			<td><input type="text" name="work_date" class="easyui-textbox"
				value="${data.work_date}" style="width: 250px" required disabled/></td>
		</tr>

		<tr>
			<td style="text-align: right">工作时间:</td>
			<td><input type="text" name="work_time" class="easyui-textbox"
				value="${data.work_time}" style="width: 250px" required disabled/></td>
			<td style="text-align: right">工作地点:</td>
			<td><input type="text" name="work_location" class="easyui-textbox"
				value="${data.work_location}" style="width: 250px" required disabled/></td>
		</tr>
		<%-- <tr>
			<td style="text-align: right">工作地点经度:</td>
			<td><input type="text" name="position_longitude" class="wu-text"
				value="${data.position_longitude}" style="width: 250px" required disabled/></td>
			<td style="text-align: right">工作地点纬度:</td>
			<td><input type="text" name="position_latitude" class="wu-text"
				value="${data.position_latitude}" style="width: 250px" required disabled/></td>
		</tr> --%>
		<tr>
			<td style="text-align: right">工作内容:</td>
			<td><input type="text" name="work_content"
				value="${data.work_content }" class="easyui-textbox" style="width: 250px"
				required disabled/></td>
			<td style="text-align: right">结算方式:</td>
			<td><select id="cc_Settlement" class="easyui-combobox"
				name="settlement_method" style="width: 250px;" required disabled>
					<option value="日结"
						<c:if test="${data.settlement_method=='日结'}">selected="selected"</c:if>>日结</option>
					<option value="周结"
						<c:if test="${data.settlement_method=='周结'}">selected="selected"</c:if>>周结</option>
					<option value="月结"
						<c:if test="${data.settlement_method=='月结'}">selected="selected"</c:if>>月结</option>
					<option value="完工结算"
						<c:if test="${data.settlement_method=='完工结算'}">selected="selected"</c:if>>完工结算</option>
					<option value="平台支付随时提现"
						<c:if test="${data.settlement_method=='平台支付随时提现'}">selected="selected"</c:if>>平台支付随时提现</option>
			</select></td>
		</tr>
		<tr>
			<td style="text-align: right">工资待遇:</td>
			<td><input type="text" name="salary_treatment"
				value="${data.salary_treatment}" class="easyui-textbox"
				style="width: 250px" required disabled/></td>
			<td style="text-align: right">提成:</td>
			<td><input type="text" name="commission"
				value="${data.commission}" class="easyui-textbox" style="width: 250px"
				required disabled></td>
		</tr>
		<tr>
			<td style="text-align: right">福利:</td>
			<td><input type="text" name="benefits" value="${data.benefits }"
				class="easyui-textbox" style="width: 250px" required disabled/></td>
			<td style="text-align: right">性别要求:</td>
			<td><select id="cc_sex" class="easyui-combobox"
				name="gender_requirements" style="width: 250px;" required disabled>
					<option value="不限"
						<c:if test="${data.gender_requirements=='不限'}">selected="selected"</c:if>>不限</option>
					<option value="男"
						<c:if test="${data.gender_requirements=='男'}">selected="selected"</c:if>>男</option>
					<option value="女"
						<c:if test="${data.gender_requirements=='女'}">selected="selected"</c:if>>女</option>
			</select></td>
		</tr>
		<tr>
			<td style="text-align: right">其他要求:</td>
			<td><input type="text" name="other_requirements" class="easyui-textbox"
				style="width: 250px" value="${data.other_requirements}" required disabled/></td>
			<td style="text-align: right">招聘人数:</td>
			<td><input type="text" name="recruitment"
				value="${data.recruitment}" class="easyui-textbox" style="width: 250px"
				required disabled/></td>
		</tr>

		<tr>
			<td style="text-align: right">已经报名人数:</td>
			<td><input type="text" name="people_num"
				value="${data.people_num }" class="easyui-textbox" style="width: 250px"
				required disabled/></td>
			<td style="text-align: right">招聘到期时间:</td>
			<td><input class="easyui-datetimebox"
				name="hiring_expiration_date"
				data-options="required:true,showSeconds:false"
				value="${data.hiring_expiration_date}" style="width: 250px" required disabled></td>
		</tr>
		<tr>
			<td style="text-align: right">招聘状态:</td>
			<td><select id="cc_recruit" class="easyui-combobox"
				name="recruitment_status" style="width: 250px;" required disabled>
					<option value="进行中"
						<c:if test="${data.recruitment_status=='进行中'}">selected="selected"</c:if>>进行中</option>
					<option value="已经暂停"
						<c:if test="${data.recruitment_status=='已经暂停'}">selected="selected"</c:if>>已经暂停</option>
					<option value="已经结束"
						<c:if test="${data.recruitment_status=='已经结束'}">selected="selected"</c:if>>已经结束</option>
					<option value="已经删除"
						<c:if test="${data.recruitment_status=='已经删除'}">selected="selected"</c:if>>已经删除</option>
					<option value="已经被投诉下架"
						<c:if test="${data.recruitment_status=='已经被投诉下架'}">selected="selected"</c:if>>已经被投诉下架</option>
			</select></td>
			<td style="text-align: right">浏览次数:</td>
			<td><input type="text" name="view_count"
				value="${data.view_count}" class="easyui-textbox" style="width: 250px"
				required disabled/></td>
		</tr>
		<tr>
			<td style="text-align: right">收藏次数:</td>
			<td><input type="text" name="collection_count"
				value="${data.collection_count}" class="easyui-textbox"
				style="width: 250px" required disabled/></td>
			<td style="text-align: right">是否被举报:</td>
			<td><select id="cc_Report" class="easyui-combobox"
				name="reported" style="width: 250px;" required disabled>
					<option value="是"
						<c:if test="${data.reported=='是'}">selected="selected"</c:if>>是</option>
					<option value="否"
						<c:if test="${data.reported=='否'}">selected="selected"</c:if>>否</option>
			</select></td>
		</tr>
		<tr>
			<td style="text-align: right">主标题:</td>
			<td><input type="text" name="main_title"
				value="${data.main_title }" class="easyui-textbox" style="width: 250px"
				required disabled/></td>
			<td style="text-align: right">副标题:</td>
			<td><input type="text" name="subtitle" value="${data.subtitle}"
				class="easyui-textbox" style="width: 250px" required disabled/></td>
		</tr>
		<tr>
			<td style="text-align: right">简介:</td>
			<td><input type="text" name="short_description"
				value="${data.short_description}" class="easyui-textbox"
				style="width: 250px" required disabled/></td>
			<td style="text-align: right">封页图URL:</td>
			<td><%-- <input type="file" name="page_url" value="${data.page_url}"
				class="wu-text" style="width: 250px" required /> --%>
			    <a href="TP/${data.page_url}" target="_blank" ><img alt="封页图URL" src="TP/${data.page_url}" width=250px height=150px></a>
				</td>
		</tr>
		<tr>
			<td style="text-align: right">首页图URL:</td>
			<td><%-- <input type="file" name="first_page_carousel_url"
				value="${data.first_page_carousel_url }" class="wu-text"
				style="width: 250px" required /> --%>
				<a href="TP/${data.first_page_carousel_url}" target="_blank" ><img alt="首页图URL" src="TP/${data.first_page_carousel_url}" width=250px height=150px></a>
				</td>	
			<td style="text-align: right">详情页主图URL:</td>
			<td><%-- <input type="file" name="main_page_url"
				value="${data.main_page_url}" class="wu-text" style="width: 250px"
				required /> --%>
				<a href="TP/${data.main_page_url}" target="_blank" ><img alt="详情页主图URL" src="TP/${data.main_page_url}" width=250px height=150px></a>
				</td>
		</tr>
		<tr>
			<td style="text-align: right">商户名称:</td>
			<td><input type="text" name="merchants_name"
				value="${data.merchants_name }" class="easyui-textbox"
				style="width: 250px" required disabled/></td>
			<td style="text-align: right">上架状态:</td>
			<td><select id="cc_recruit" class="easyui-combobox"
				name="up_down_frame" style="width: 250px;" required disabled>
					<option value="1"
						<c:if test="${data.up_down_frame=='1'}">selected="selected"</c:if>>上架</option>
					<option value="0"
						<c:if test="${data.up_down_frame=='0'}">selected="selected"</c:if>>下架</option>
			</select></td>
		</tr>
		<tr>
		<td style="text-align: right">详情页介绍:</td>
		<td colspan="3"><input type="text" name="details_page_introduction"
			value="${data.details_page_introduction }" class="easyui-textbox"
			style="width: 100%" required disabled/></td>
		</tr>
<!-- 			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog"
					style="float: right">确定</button>
			</td> -->
		
	</table>
</form>