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
<script>
	function check() {
		var selValue = document.getElementById("target_type").value;
		if (selValue == "担保职位详情") {
			document.getElementById("target_url").style.display = "none";
			document.getElementById("target_url_text").value="";
			document.getElementById("postName").style.display = "";
		} else if (selValue == "H5") {
			$("#recruiting_id").combobox('clear');
			document.getElementById("target_url").style.display = "";
			document.getElementById("postName").style.display = "none";
		} else if (selValue == "请选择分类") {
			$('#target_url').hide();
			$('#postName').hide();
		}
	}
	function onSelect(d) {
	    var issd = this.id == 'sd', sd = issd ? d : new Date($('#sd').datebox('getValue')), ed = issd ? new Date($('#ed').datebox('getValue')) : d;
	        if (ed < sd) {
	        	$.messager.show({
	                  title:'注意',
	                  msg:'截止日期小于起始日期'
	              });
	            //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
	            $('#ed').datebox('setValue', '').datebox('showPanel');
	        }
	    } 

	$("#recruiting_id").combobox({
		panelHeight : 'auto',
		onChange : function() {
			var id = $('#recruiting_id').val();
			if (id != '') {
				$('input#target_id').val(id);
			}
			var name = $('#recruiting_id').combobox('getText');
			if (name != '') {
				$('input#target_parameter').val(name);
			}
		}
	});
</script>
<form action="CarouselManage/addCarousel" class="table_form"
	method="post" id="addCarousel" enctype="multipart/form-data">
	<input type="text" id="target_id" name=target_id style="width:249px; display:none" />
	<input type="text"id="target_parameter" name=target_parameter style="width: 249px; display:none" />
	<table class="table_list">
		<tr>
             <td>输入编号：</td>
             <td><input type="text" class="easyui-textbox" name="carousel_code"  required /></td>
         </tr>
         <tr>
             <td>名称：</td>
             <td>
                  <input type="text" class="easyui-textbox"  name="carousel_name" required />
             </td>
         </tr>
			 <tr style="display:none" >
				<td align="right">轮播图分类:</td>
				<td><select  class="easyui-combobox"
					name="carousel_figure_type" style="width:200; panelHeight:100"
					required>
						<option value="1"
							<c:if test="${data.carousel_figure_type=='学生首页app'}">selected="selected"</c:if>>学生首页app</option>
						<%-- <option value="2"
							<c:if test="${data.carousel_figure_type=='微信首页'}">selected="selected"</c:if>>微信首页</option>
						<option value="3"
							<c:if test="${data.carousel_figure_type=='网页'}">selected="selected"</c:if>>网页</option>
						<option value="4"
							<c:if test="${data.carousel_figure_type=='商家app'}">selected="selected"</c:if>>商家app</option> --%>
				</select></td>
			</tr> 
		<tr>
			<td align="right">轮播图片:</td>
			<td><input id="carouselFile" style="width: 124px" runat="server"
				name="image"  value="${data.pictureUrl}"
				type="file" /></td>
		</tr>
		<tr>
			<td align="right">目标分类:</td>
			<td><select id="target_type" onchange="check()" 
				name="target_type" style="width: 180px; height:26px; border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ;" required>
					<option value="请选择分类"
						<c:if test="${data.target_type=='请选择分类'}">selected="selected"</c:if>>请选择分类</option>
					<option value="担保职位详情"
						<c:if test="${data.target_type=='担保职位详情'}">selected="selected"</c:if>>担保职位详情</option>
					<option value="H5"
						<c:if test="${data.target_type=='H5'}">selected="selected"</c:if>>H5</option>
			</select> </td></tr>
			<tr id="target_url" style="display: none">
			<td align="right">H5地址输入:</td>
			<td>
			<input type="text" id="target_url_text" name=target_url
				style="width: 180px; height:26px; border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ;" />
			</td>
				</tr>
		<tr id="postName" style="display: none">
			<td style="text-align: center">岗位名称:</td>
			<td><input id="recruiting_id" class="wu-text easyui-combobox"
				name="recruiting_id" style="width: 180px;"
				data-options="
						url:'CarouselManage/findTitle',
						method:'get',
						valueField:'recruitingId',
						textField:'postName',
						groupField:'companyName',
						panelHeight:'auto',									
					"></td>
		</tr>

		<tr style="display:none" >

			<td align="right">是否担保职位:</td>
			<td><select  class="easyui-combobox"
				name="is_good_position" style="panelHeight: 100; width: 50px"
				required>
					<option value="是"
						<c:if test="${data.is_good_position=='是'}">selected="selected"</c:if>>是</option>
					<%-- <option value="否"
						<c:if test="${data.is_good_position=='否'}">selected="selected"</c:if>>否</option> --%>
			</select></td>
		</tr>
		<tr>
			<td align="right">播放起始日期:</td>
			<td><input id="sd" class="easyui-datetimebox" name="start_date" required
				data-options="onSelect:onSelect" value="9/1/2017 0:0"
				style="width: 180px"></td>
		</tr>
		<tr>
			<td align="right">播放截止日期:</td>
			<td><input id="ed" class="easyui-datetimebox" name="end_date" 	required
				data-options="onSelect:onSelect"
				value="10/1/2017 25:59" style="width: 180px"></td>
		</tr>
		<tr style="display:none" >
			<td align="right">状态:</td>
			<td><select  class="easyui-combobox" name="state"
				style="width: 200, panelHeight:100" required>
					<option value="有效"
						<c:if test="${data.state=='有效'}">selected="selected"</c:if>>有效</option>
					<%-- <option value="暂停"
						<c:if test="${data.state=='暂停'}">selected="selected"</c:if>>暂停</option>
					<option value="已删除"
						<c:if test="${data.state=='已删除'}">selected="selected"</c:if>>已删除</option> --%>
			</select></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_file_dialog"
					style="float: right">确定</button>
				<input type="hidden" name="carousel_figure_id"/>
			</td>
			
		</tr>
	</table>
</form>
