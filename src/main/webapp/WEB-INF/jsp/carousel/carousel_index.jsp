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
<body >
	<div class="easyui-layout" data-options="fit:true">
	    <!-- Begin of toolbar -->
	    <div id="carousel-toolbar">
	        <div class="wu-toolbar-button">
	            <a class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
	        </div>
	    </div>
	    <!-- End of toolbar -->
	    <table id="carousel-table" toolbar="#carousel-toolbar" >  
		    <thead>   
		        <tr>  
		            <th data-options="field:'carousel_figure_type',width:100,halign:'center',align:'center',formatter:xzf_CarouselKind">轮播图分类</th>   
		            <th data-options="field:'picture_url',width:100,halign:'center',align:'center',formatter:showImage">名称</th>   
		            <th data-options="field:'target_type',width:100,halign:'center'">价格</th> 
		            <th data-options="field:'target_id',width:100,halign:'center'">编码</th>   
		            <th data-options="field:'target_url',width:100,halign:'center'">名称</th>   
		            <th data-options="field:'target_parameter',width:100,halign:'center'">价格</th> 
		            <th data-options="field:'start_date',width:100,halign:'center'">编码</th>   
		            <th data-options="field:'end_date',width:100,halign:'center'">名称</th>   
		            <th data-options="field:'state',width:100,halign:'center'">价格</th>   
		            <th data-options="field:'operator',width:100,halign:'center'">操作人</th>
		            <th data-options="field:'_operate',width:120,halign:'center',align:'center',formatter:btnOp">操作</th>   
		        </tr>   
		    </thead>   
	    </table>
	</div>
	<!-- Begin 新增/编辑弹出框 -->
	<div id="carousel-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" 
	     style="width:600px; padding:10px;">
		<form id="carousel-form" method="post" enctype="multipart/form-data">
	        <table cellpadding="5">
	            <tr>
	                <td style="display:none">
					    <input name="carousel_figure_id" />
				    </td>
	                <td  align="right">轮播图片:</td>
	             	<td>
 						<input id="carouselFile" style="width:224px" runat="server" name="image" 
 						onchange="javascript:setImagePreview(this,carouselDiv,carouselPreview,200,200);" type="file" />             	
	             	</td>
	            	<td rowspan="4">
	            	    <div id="carouselDiv"> 
	    					<img id="carouselPreview" /> 
						</div>
					</td>
	            </tr>
	           <tr>
	                <td align="right">轮播图分类:</td>
	             	<td>
 						<select class="easyui-combobox" name="carousel_figure_type" data-options="width:100,panelHeight:50">   
						    <option value="1">学生首页app</option>   
						    <option value="2">微信首页</option>
						</select>  
	             	</td>
	            	 
	            </tr>
	        </table>
	    </form>
	</div>
	<!-- End  新增/编辑弹出框  -->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.form.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/custom/utils.js"></script> 
	<script type="text/javascript">
		$(document).ready(function() {
			$('#carousel-table').datagrid({
				url:"carouselManage/getCarouselList",
				loadFilter:pagerFilter,
				singleSelect:true, 
				pageSize:20,
				pagination:true,
				fitColumns:true, 
				fit:true,
			    onLoadSuccess:function(data){
			    	$(".editCarousel").linkbutton({plain:true, iconCls:'icon-page-white-edit' });
			    	$(".deleteCarousel").linkbutton({plain:true, iconCls:'icon-arrow-up' });
			    	$(".pauseCarousel").linkbutton({plain:true, iconCls:'icon-arrow-down' });
			    	$(".launchCarousel").linkbutton({plain:true, iconCls:'icon-node-tree16' });
			    }  
			});
		});
		//添加
		function openAdd(){
			showDialog('carouselManage/addCarousel');
		}
		//编辑
		function openEditCate(id,index){
			var row = $('#carousel-table').datagrid('getData').rows[index];
			$('#carousel-form').form("load",row);
			showDialog('carouselManage/editCarousel');
		}
		function showImage(value,row,index){
			var html='<div style="padding:10px">';
			if (row.picture_url!='' || row.picture_url!=null){
				html+='<img src="TP/'+row.picture_url+'" style="width:60px">';
			} else {
				html+='<img src="TP/default_category.png" style="width:60px">';
			}
			html+='</div>';
			return html;
		}
		function btnOp(value,row,index){
		    var html='<a class="easyui-linkbutton editCarousel" onclick="openEditCate('+ row.id+','+index+')">编辑</a>';
		    html+='<a class="easyui-linkbutton deleteCarousel"  onclick="downCate('+row.id +')" plain="true">删除</a>';
		    if(row.state=='有效'){
		    	html+='<a class="easyui-linkbutton pauseCarousel" onclick="upCate('+row.id +')" plain="true">暂停</a>';
		    }else{
			    html+='<a class="easyui-linkbutton launchCarousel" onclick="upCate('+row.id +')" plain="true">启用</a>';
		    }
			return html;
		}
		function xzf_CarouselKind(value,row,index){
			//console.log(row.carousel_figure_type);
			switch(row.carousel_figure_type){
				case '1':
					return "学生app首页";
				case '2':
					return "微信首页"; 
				default:
					return "默认值";
			}
		}
		function showDialog(url){
			$('#carousel-dialog').dialog({
				closed: false,
				modal:true,
		        title: "轮播图信息",
		        buttons: [{
		            text: '确定',
		            iconCls: 'icon-ok',
		            handler: function(){
		               //提交form表单
		         	   //$.messager.progress(); 
		         	   jquerySubmit2(url,'carousel-form',function(data){
		         		   //$.messager.progress('close');
		             	   if(data.status==1){
		             		  $('#carousel-dialog').dialog('close');
			             	  $('#carousel-form').form('reset');
			             	  $('#carouselPreview').attr('src',"");
		             		  $('#carousel-table').datagrid('reload');
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
		                $('#carousel-dialog').dialog('close');                    
		            }
		        }]
		    });
		}
	</script>
</body>
</html>
