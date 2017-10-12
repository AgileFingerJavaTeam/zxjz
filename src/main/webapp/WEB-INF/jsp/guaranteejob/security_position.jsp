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
<!DOCTYPE html>
<html lang="en">
 <head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>首页</title>
	<meta name="keywords" content="">
	<meta name="description" content=""> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="css/wu.css" />
	<link rel="stylesheet" type="text/css" href="css/icon.css" />	
</head>
 <body>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="carousel-toolbar">
       <div class="wu-toolbar-button">
            <a class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a class="easyui-linkbutton" iconCls="icon-pencil" onclick="openEdit()" plain="true">修改</a>
            <a class="easyui-linkbutton" iconCls="icon-arrow-up" onclick="putOnSale()" plain="true">上架</a>
            <a class="easyui-linkbutton" iconCls="icon-arrow-down" onclick="pullOffShelves()" plain="true">下架</a>
        </div> 
    </div>
    <!-- End of toolbar -->
    <table id="at-position-table" class="easyui-datagrid" toolbar="#carousel-toolbar" 
           data-options="url:'securityPosition/getSecurityPositionList',loadFilter:pagerFilter,rownumbers:true,
		   singleSelect:false, pageSize:20,pagination:true, multiSort:true, fitColumns:true, fit:true">  
	    <thead>   
	        <tr>  
	        <!-- formatter:xzf_CarouselKind  --> 
	           <th data-options="field:'release_time',width:100,halign:'center',align:'center'">发布时间</th>   
	            <th data-options="field:'refresh_time',width:100,halign:'center'">刷新时间</th>   
	            <th data-options="field:'post_name',width:100,halign:'center'">岗位名称</th> 
	             <th data-options="field:'post_classification',width:100,halign:'center'">岗位分类</th>   
	            <th data-options="field:'details_page_category',width:100,halign:'center'">详情页面分类</th>   
	            <th data-options="field:'work_date',width:100,halign:'center'">工作日期</th> 
	            <th data-options="field:'work_time',width:100,halign:'center'">工作时间</th>   
	            <th data-options="field:'work_location',width:100,halign:'center'">工作地点</th>   
	            <th data-options="field:'position_longitude',width:100,halign:'center'">工作地点经度</th>   
	            <th data-options="field:'position_latitude',width:100,halign:'center'">工作地点纬度</th>  
	            <th data-options="field:'work_content',width:100,halign:'center'">工作内容</th>   
	            <th data-options="field:'settlement_method',width:100,halign:'center'">结算方式</th>   
	            <th data-options="field:'salary_treatment',width:100,halign:'center'">工资待遇</th>   
	            <th data-options="field:'commission',width:100,halign:'center'">提成</th>   
	            <th data-options="field:'benefits',width:100,halign:'center'">福利</th>   
	            <th data-options="field:'gender_requirements',width:100,halign:'center'">性别要求</th>   
	            <th data-options="field:'other_requirements',width:100,halign:'center'">其他要求</th>   
	            <th data-options="field:'recruitment',width:100,halign:'center'">招聘人数</th>   
	            <th data-options="field:'people_num',width:100,halign:'center'">已经报名人数</th>    
	            <th data-options="field:'hiring_expiration_date',width:100,halign:'center'">招聘到期时间</th>
	            <th data-options="field:'audit_status',width:100,halign:'center'">审核状态</th>
	            <th data-options="field:'auditor',width:100,halign:'center'">审核人</th>
	            <th data-options="field:'status_time',width:100,halign:'center'">审核时间</th>   
	            <th data-options="field:'status_result',width:100,halign:'center'">审核结果</th>  
	            <th data-options="field:'dismissed_reason',width:100,halign:'center'">驳回原因</th>   
	            <th data-options="field:'recruitment_status',width:100,halign:'center'">招聘状态</th>   
	            <th data-options="field:'reported',width:100,halign:'center'">是否被举报</th>   
	            <th data-options="field:'whether_on_homepage_guarantee',width:100,halign:'center'">是否上首页担保</th>  
	            <th data-options="field:'whether_on_homepage_recommend',width:100,halign:'center'">是否上首页推荐</th>  
	            <th data-options="field:'view_count',width:100,halign:'center'">浏览次数</th>  
	            <th data-options="field:'collection_count',width:100,halign:'center'">收藏次数</th>  
	            
	             <th data-options="field:'main_title',width:100,halign:'center'">主标题</th> 
	             <th data-options="field:'subtitle',width:100,halign:'center'">副标题</th> 
	             <th data-options="field:'short_description',width:100,halign:'center'">简介</th> 
	             <th data-options="field:'page_url',width:100,halign:'center'">封页图URL（老虎）</th> 
	             <th data-options="field:'first_page_carousel_url',width:100,halign:'center'">首页图URL（用于App首页轮播的图片）衣服</th>
	             <th data-options="field:'main_page_url',width:100,halign:'center'">详情页主图URL</th>
	             <th data-options="field:'details_page_introduction',width:100,halign:'center'">详情页介绍</th> 
	             
	        	 <th data-options="field:'_operate',width:150,halign:'center',align:'center',formatter:btnOp">操作</th>     
	       
	         </tr>   
	    </thead>   
    </table>
</div>
<!-- Begin of easyui-dialog -->
	<div id="at-position-dialog" class="easyui-dialog" title="My Dialog"style="width:850px; height: 400px;"
	     data-options="closed:true,iconCls:'icon-save'" >
		<form id="at-position-form" method="post">
	<table cellpadding="10" id="at-position-table">
				<tr>
					<td align="right">发布时间:</td>
					<td><input class="easyui-datetimebox" name="release_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px" required></td>
					<td align="right">刷新时间:</td>
					<td><input class="easyui-datetimebox" name="refresh_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px" required></td>
				</tr>
				<tr>
					<td align="right">岗位名称:</td>
					<td><input type="text" name="post_name" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">岗位分类:</td>
					<td><input type="text" name="post_classification"
						class="wu-text" style="width: 250px" required/></td>
				</tr>

				<tr>
					<td align="right">详情页面分类:</td>
					<td><select id="cc_edit" class="easyui-combobox"
						name="details_page_category" style="width: 250px;" required>
							<option value="普通" selected>普通</option>
							<option value="担保">担保</option>
					</select></td>
					<td align="right">是否上首页担保:</td>
					<td><select id="cc_guarantee" class="easyui-combobox"
						name="whether_on_homepage_guarantee" style="width: 250px;" required>
							<option value="是" selected>是</option>
							<option value="否">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">首页担保开始日期:</td>
					<td><input class="easyui-datetimebox" name="good_begin_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px" required></td>
					<td align="right">首页担保结束日期:</td>
					<td><input class="easyui-datetimebox" name="good_end_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px" required></td>
				</tr>

				<tr>
					<td align="right">是否上首页推荐:</td>
					<td><select id="cc_Recommend" class="easyui-combobox"
						name="whether_on_homepage_recommend" style="width: 250px;" required>
							<option value="是" selected>是</option>
							<option value="否">否</option>
					</select></td>
					<td align="right">推荐开始日期:</td>
					<td><input class="easyui-datetimebox"
						name="recommend_begin_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px" required></td>
				</tr>
				<tr>
					<td align="right">推荐结束日期:</td>
					<td><input class="easyui-datetimebox"
						name="recommend_end_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px" required></td>
					<td align="right">工作日期:</td>
					<td><input type="text" name="work_date" class="wu-text"
						style="width: 250px" required/></td>
				</tr>

				<tr>
					<td align="right">工作时间:</td>
					<td><input type="text" name="work_time" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">工作地点:</td>
					<td><input type="text" name="work_location" class="wu-text"
						style="width: 250px" required/></td>
				</tr>
				<tr>
					<td align="right">工作地点经度:</td>
					<td><input type="text" name="position_longitude"
						class="wu-text" style="width: 250px" required/></td>
					<td align="right">工作地点纬度:</td>
					<td><input type="text" name="position_latitude"
						class="wu-text" style="width: 250px" required/></td>
				</tr>

				<tr>
					<td align="right">工作内容:</td>
					<td><input type="text" name="work_content" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">结算方式:</td>
					<td><select id="cc_Settlement" class="easyui-combobox"
						name="settlement_method" style="width: 250px;" required>
							<option value="日结" selected>日结</option>
							<option value="周结">周结</option>
							<option value="月结">月结</option>
							<option value="完工结算">完工结算</option>
							<option value="平台支付随时提现">平台支付随时提现</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">工资待遇:</td>
					<td><input type="text" name="salary_treatment" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">提成:</td>
					<td><input type="text" name="commission" class="wu-text"
						style="width: 250px" required></td>
				</tr>

				<tr>
					<td align="right">福利:</td>
					<td><input type="text" name="benefits" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">性别要求:</td>
					<td><select id="cc_sex" class="easyui-combobox"
						name="gender_requirements" style="width: 250px;" required>
							<option value="不限" selected>不限</option>
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">其他要求:</td>
					<td><input type="text" name="other_requirements"
						class="wu-text" style="width: 250px" required/></td>
					<td align="right">招聘人数:</td>
					<td><input type="text" name="recruitment" class="wu-text"
						style="width: 250px" required/></td>
				</tr>

				<tr>
					<td align="right">已经报名人数:</td>
					<td><input type="text" name="people_num" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">招聘到期时间:</td>
					<td><input class="easyui-datetimebox"
						name="hiring_expiration_date"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
				</tr>
				<tr>
					<td align="right">招聘状态:</td>
					<td><select id="cc_recruit" class="easyui-combobox"
						name="recruitment_status" style="width: 250px;" required>
							<option value="进行中" selected>进行中</option>
							<option value="已经暂停">已经暂停</option>
							<option value="已经结束">已经结束</option>
							<option value="已经删除">已经删除</option>
							<option value="已经被投诉下架">已经被投诉下架</option>
					</select></td>
					<td align="right">浏览次数:</td>
					<td><input type="text" name="view_count" class="wu-text"
						style="width: 250px" required/></td>
				</tr>
				<tr>
					<td align="right">收藏次数:</td>
					<td><input type="text" name="collection_count" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">是否被举报:</td>
					<td><select id="cc_Report" class="easyui-combobox"
						name="reported" style="width: 250px;" required>
							<option value="是" selected>是</option>
							<option value="否">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">主标题:</td>
					<td><input type="text" name="main_title" class="wu-text"
						style="width: 250px" required/></td>
					<td align="right">副标题:</td>
					<td><input type="text" name="subtitle" class="wu-text"
						style="width: 250px" required/></td>
				</tr>
				<tr>
					<td align="right">简介:</td>
					<td><input type="text" name="short_description"
						class="wu-text" style="width: 250px" required/></td>
					<td align="right">封页图URL:</td>
					<td><input type="text" name="page_url" class="wu-text"
						style="width: 250px" required/></td>
				</tr>
				<tr>
					<td align="right">首页图URL:</td>
					<td><input type="text" name="first_page_carousel_url"
						class="wu-text" style="width: 250px" required/></td>
					<td align="right">详情页主图URL:</td>
					<td><input type="text" name="main_page_url" class="wu-text"
						style="width: 250px" required/></td>
				</tr>
				<tr>
					<td align="right">详情页介绍:</td>
					<td><input type="text" name="details_page_introduction"
						class="wu-text" style="width: 250px" required/></td>
				</tr>
			</table>
			<input type="hidden" name="recruiting_id">
		</form>
	</div>
<!-- log2 -->
<!-- Begin of easyui-dialog -->
	<div id="at-position-dialogAdd" class="easyui-dialog" title="My Dialog"style="width:850px; height: 400px;"
	     data-options="closed:true,iconCls:'icon-save'" >
		<form id="at-position-formAdd" method="post">
	<table cellpadding="10" id="at-position-tableAdd">
				<tr>
					<td align="right">发布时间:</td>
					<td><input class="easyui-datetimebox" name="release_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
					<td align="right">刷新时间:</td>
					<td><input class="easyui-datetimebox" name="refresh_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
				</tr>
				<tr>
					<td align="right">岗位名称:</td>
					<td><input type="text" name="post_name" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">岗位分类:</td>
					<td><input type="text" name="post_classification"
						class="wu-text" style="width: 250px" /></td>
				</tr>

				<tr>
					<td align="right">详情页面分类:</td>
					<td><select id="cc_edit" class="easyui-combobox"
						name="details_page_category" style="width: 250px;">
							<option value="普通" selected>普通</option>
							<option value="担保">担保</option>
					</select></td>
					<td align="right">是否上首页担保:</td>
					<td><select id="cc_guarantee" class="easyui-combobox"
						name="whether_on_homepage_guarantee" style="width: 250px;">
							<option value="是" selected>是</option>
							<option value="否">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">首页担保开始日期:</td>
					<td><input class="easyui-datetimebox" name="good_begin_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
					<td align="right">首页担保结束日期:</td>
					<td><input class="easyui-datetimebox" name="good_end_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
				</tr>

				<tr>
					<td align="right">是否上首页推荐:</td>
					<td><select id="cc_Recommend" class="easyui-combobox"
						name="whether_on_homepage_recommend" style="width: 250px;">
							<option value="是" selected>是</option>
							<option value="否">否</option>
					</select></td>
					<td align="right">推荐开始日期:</td>
					<td><input class="easyui-datetimebox"
						name="recommend_begin_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
				</tr>
				<tr>
					<td align="right">推荐结束日期:</td>
					<td><input class="easyui-datetimebox"
						name="recommend_end_time"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
					<td align="right">工作日期:</td>
					<td><input type="text" name="work_date" class="wu-text"
						style="width: 250px" /></td>
				</tr>

				<tr>
					<td align="right">工作时间:</td>
					<td><input type="text" name="work_time" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">工作地点:</td>
					<td><input type="text" name="work_location" class="wu-text"
						style="width: 250px" /></td>
				</tr>
				<tr>
					<td align="right">工作地点经度:</td>
					<td><input type="text" name="position_longitude"
						class="wu-text" style="width: 250px" /></td>
					<td align="right">工作地点纬度:</td>
					<td><input type="text" name="position_latitude"
						class="wu-text" style="width: 250px" /></td>
				</tr>

				<tr>
					<td align="right">工作内容:</td>
					<td><input type="text" name="work_content" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">结算方式:</td>
					<td><select id="cc_Settlement" class="easyui-combobox"
						name="settlement_method" style="width: 250px;">
							<option value="日结" selected>日结</option>
							<option value="周结">周结</option>
							<option value="月结">月结</option>
							<option value="完工结算">完工结算</option>
							<option value="平台支付随时提现">平台支付随时提现</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">工资待遇:</td>
					<td><input type="text" name="salary_treatment" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">提成:</td>
					<td><input type="text" name="commission" class="wu-text"
						style="width: 250px"></td>
				</tr>

				<tr>
					<td align="right">福利:</td>
					<td><input type="text" name="benefits" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">性别要求:</td>
					<td><select id="cc_sex" class="easyui-combobox"
						name="gender_requirements" style="width: 250px;">
							<option value="不限" selected>不限</option>
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">其他要求:</td>
					<td><input type="text" name="other_requirements"
						class="wu-text" style="width: 250px" /></td>
					<td align="right">招聘人数:</td>
					<td><input type="text" name="recruitment" class="wu-text"
						style="width: 250px" /></td>
				</tr>

				<tr>
					<td align="right">已经报名人数:</td>
					<td><input type="text" name="people_num" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">招聘到期时间:</td>
					<td><input class="easyui-datetimebox"
						name="hiring_expiration_date"
						data-options="required:true,showSeconds:false"
						value="3/4/2010 2:3" style="width: 250px"></td>
				</tr>
				<tr>
					<td align="right">招聘状态:</td>
					<td><select id="cc_recruit" class="easyui-combobox"
						name="recruitment_status" style="width: 250px;">
							<option value="进行中" selected>进行中</option>
							<option value="已经暂停">已经暂停</option>
							<option value="已经结束">已经结束</option>
							<option value="已经删除">已经删除</option>
							<option value="已经被投诉下架">已经被投诉下架</option>
					</select></td>
					<td align="right">浏览次数:</td>
					<td><input type="text" name="view_count" class="wu-text"
						style="width: 250px" /></td>
				</tr>
				<tr>
					<td align="right">收藏次数:</td>
					<td><input type="text" name="collection_count" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">是否被举报:</td>
					<td><select id="cc_Report" class="easyui-combobox"
						name="reported" style="width: 250px;">
							<option value="是" selected>是</option>
							<option value="否">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">主标题:</td>
					<td><input type="text" name="main_title" class="wu-text"
						style="width: 250px" /></td>
					<td align="right">副标题:</td>
					<td><input type="text" name="subtitle" class="wu-text"
						style="width: 250px" /></td>
				</tr>
				<tr>
					<td align="right">简介:</td>
					<td><input type="text" name="short_description"
						class="wu-text" style="width: 250px" /></td>
					<td align="right">封页图URL:</td>
					<td><input type="text" name="page_url" class="wu-text"
						style="width: 250px" /></td>
				</tr>
				<tr>
					<td align="right">首页图URL:</td>
					<td><input type="text" name="first_page_carousel_url"
						class="wu-text" style="width: 250px" /></td>
					<td align="right">详情页主图URL:</td>
					<td><input type="text" name="main_page_url" class="wu-text"
						style="width: 250px" /></td>
				</tr>
				<tr>
					<td align="right">详情页介绍:</td>
					<td><input type="text" name="details_page_introduction"
						class="wu-text" style="width: 250px" /></td>
				</tr>
			</table>
		</form>
	</div>	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.form.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/custom/utils.js"></script> 
	<script type="text/javascript">
	$('#at-position-table').datagrid({
		url:"securityPosition/getSecurityPositionList",
		loadFilter:pagerFilter,
		singleSelect:true, 
		pageSize:20,
		pagination:true,
		fitColumns:true, 
		fit:true,
	    onLoadSuccess:function(data){
	    	$(".editPosition").linkbutton({plain:true, iconCls:'icon-page-white-edit' });
	    	$(".updatePosition").linkbutton({plain:true, iconCls:'icon-pencil' });
	    	/* $(".deleteCarousel").linkbutton({plain:true, iconCls:'icon-arrow-up' }); */
	    	/* $(".pauseCarousel").linkbutton({plain:true, iconCls:'icon-arrow-down' });
	    	$(".launchCarousel").linkbutton({plain:true, iconCls:'icon-node-tree16' }); */
	    }  
	});	  
	
		function openAdd() {
			showDialogAdd('securityPosition/getSecurityPositionAdd');
		function showDialogAdd(url){
			$('#at-position-dialogAdd').dialog({
				closed:false,
				modal : true,
				title:"添加",
				buttons:[{
					text:'确定',
					iconCls:'icon-ok',
					handler: function(){	
						jquerySubmit2(url, 'at-position-formAdd', function(data){
							//$.messager.progress('close');
							if(data.status==1){
			             		  $('#at-position-dialogAdd').dialog('close');
				             	  $('#at-position-formAdd').form('reset');
			             		  $('#at-position-tableAdd').datagrid('reload');
							}else{
								$.messager.alert('提示信息',data.msg,'error');
							}
						}, function(data){
								$.messager.progress('close');
								$.messager.alert('提示信息',data.responseText,'error');	
						});
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						$('#at-position-dialogAdd').dialog('close');
					}
				}]
			});
		}}
		function btnOp(value,row,index){
		    var html='<a class="easyui-linkbutton updatePosition" iconCls="icon-pencil" onclick="openEditCate('+ row.recruiting_id+','+index+')">编辑</a>';
		    	html+='<a class="easyui-linkbutton editPosition"  onclick="downCate('+ row.recruiting_id+','+index+')" plain="true">详情</a>';
		    	html+='<a class="easyui-linkbutton up" onclick="upCate('+row.recruiting_id +')" plain="true">上架</a>';
			    html+='<a class="easyui-linkbutton down" onclick="updownCate('+row.recruiting_id +')" plain="true">下架</a>';
		
			return html;
		}
/* 		$(document).ready(function(){
			$('.down').hide();	
		})
		function upCate(recruiting_id){
			$('.up').hide();
		}
		function updownCate(recruiting_id){
			$('.up').show();
			
		} */
		function xzf_CarouselKind(value, row, index) {
			console.log(row.carousel_figure_type);
			switch (row.carousel_figure_type) {
			case '1':
				return "学生app首页";
			case '2':
				return "微信首页";
			default:
				return "默认值";
			}
		}
		//编辑
		function openEditCate(recruiting_id,index){
			var row = $('#at-position-table').datagrid('getData').rows[index];
			$('#at-position-form').form("load",row);
			showDialog('securityPosition/getSecurityPositionUpdate');
		}
		function showDialog(url){
			$('#at-position-dialog').dialog({
				closed: false,
				modal:true,
		        title: "编辑信息",
		        buttons: [{
		            text: '确定',
		            iconCls: 'icon-ok',
		            handler: function(){
		               //提交form表单
		         	   //$.messager.progress(); 
		         	   jquerySubmit2(url,'at-position-form',function(data){
		         		   //$.messager.progress('close');
		             	   if(data.status==1){
		             		  $('#at-position-dialog').dialog('close');
			             	  $('#at-position-form').form('reset');
		             		  $('#at-position-table').datagrid('reload');
		             	   }else{
		             		   $.messager.alert('提示信息',data.msg,'error');
		             	   }
		         	   },function(data){
		             	   //$.messager.progress('close'); 
		             	   $.messager.alert('提示信息',data.responseText,'error');
		         	   });
		            }
		        }, {
		            text: '取消',
		            iconCls: 'icon-cancel',
		            handler: function () {
		                $('#at-position-dialog').dialog('close');                    
		            }
		        }]
		    });
		}
		 function downCate(recruiting_id,index){
			var row = $('#at-position-table').datagrid('getData').rows[index];
			$('#at-position-form').form("load", row);
			showDialogEdit('securityPosition/getSecurityPositionList');
		}
		 function showDialogEdit(url){
				$('#at-position-dialog').dialog({
					closed: false,
					modal:true,
			        title: "详细信息",
			        buttons: [{
			            text: '确定',
			            iconCls: 'icon-ok',
			            handler: function(){
			               //提交form表单
			         	   //$.messager.progress(); 
			         	   jquerySubmit2(url,'at-position-form',function(data){
			         		   //$.messager.progress('close');
			             	   if(data.status==1){
			             		  $('#at-position-dialog').dialog('close');
				             	  $('#at-position-form').form('reset');
			             		  $('#at-position-table').datagrid('reload');
			             	   }else{
			             		   $.messager.alert('提示信息',data.msg,'error');
			             	   }
			         	   },function(data){
			             	   //$.messager.progress('close'); 
			             	   $.messager.alert('提示信息',data.responseText,'error');
			         	   });
			            }
			        }, {
			            text: '取消',
			            iconCls: 'icon-cancel',
			            handler: function () {
			                $('#at-position-dialog').dialog('close');                    
			            }
			        }]
			    });
			}
	</script>
	</body>
	</html>