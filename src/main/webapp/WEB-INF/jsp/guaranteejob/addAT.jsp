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
<form action="securityPosition/getSecurityPositionAdd" class="table_form" method="post" id="getSecurityPositionAdd" enctype="multipart/form-data">
	<table cellpadding="10" id="at-position-table" class="table_list">
		<tr>
		 	<td style="display:none"><input type='text' id='at_merchant_id' name='releases_user_id' /></td>
		    <td style="text-align: right" width="120px">商户名称:</td>
			<td><input  class="wu-text easyui-combobox" id="at_add_name"
              name="merchants_name"  style="width: 250px" required  data-options="
					url:'securityPosition/SaddAT',
					method:'get',
					valueField:'user_id',
					textField:'merchants_name',
					panelHeight:'auto'">
		   </td>
		    <td style="text-align: right" width="120px">岗位名称:</td>
			<td><input type="text" name="post_name" required class="easyui-textbox easyui-validatebox"
				style="width: 250px" /></td>
		</tr>
		<tr>
			<td style="text-align: right">岗位分类:</td>
			<td><input  class="wu-text easyui-combobox" id="station_name"
              name="station_name"  style="width: 125px" required  data-options="
					url:'securityPosition/SaddATT',
					method:'get',
					valueField:'station_id',
					textField:'station_name',
					panelHeight:'auto'">
				<input  class="wu-text easyui-combobox" id="post_classification"
              name="post_classification" style="width: 125px" required data-options="
              		valueField:'station_id',
					textField:'station_name',
					panelHeight:'auto'
             		 ">
              
			</td>
			<td style="text-align: right">工作内容:</td>
			<td><input type="text" name="work_content" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">工作日期:</td>
			<td><input type="text" name="work_date" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
			<td style="text-align: right">工作时间:</td>
			<td><input type="text" name="work_time" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">工作地点:</td>
			<td>
			<input id="at_location" name="work_location" class="easyui-textbox" style="width:250px" data-options="
			prompt: '地图',
			iconWidth: 22,
			icons: [{
			
				iconCls:'icon-search',
				handler: function(e){
					var v = $(e.data.target).textbox('getValue');
					$('#dd').dialog({    
	    		    title: '地图',    
	    		    width: 900,    
	    		    height: 600,    
	    		    closed: false,    
	    		    cache: false,    
	    		    href: 'securityPosition/Map',    
	    		    modal: true   
	    		}); 
				}
			}]
			">
			</td>
			<td style="text-align: right">工资待遇:</td>
			<td><input type="text" name="salary_treatment" class="easyui-textbox easyui-validatebox easyui-numberspinner"
				style="width: 250px" required /></td>
		</tr>
		<tr style="display: none;">
			<td style="text-align: right">工作地点经度:</td>
			<td><input type="hidden" name="position_longitude" class="wu-text"
			    id='at_position_longitude'
				style="width: 250px" required /></td>
			<td style="text-align: right">工作地点纬度:</td>
			<td><input type="hidden" name="position_latitude" class="wu-text" 
			    id='at_position_latitude'
				style="width: 250px" required /></td>
		</tr> 
		<tr>
			<td style="text-align: right">提成:</td>
			<td><input type="text" name="commission" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required></td>
			<td style="text-align: right">福利:</td>
			<td><input type="text" name="benefits" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">性别要求:</td>
			<td><select id="cc_sex" class="easyui-combobox"
				name="gender_requirements" style="width: 250px;" required>
					<option value="不限">不限</option>
					<option value="男">男</option>
					<option value="女">女</option>
			</select></td>
			<td style="text-align: right">其他要求:</td>
			<td><input type="text" name="other_requirements" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">招聘人数:</td>
			<td><input type="text" name="recruitment" class="easyui-textbox easyui-validatebox easyui-numberspinner"
				style="width: 250px" required /></td>
			<td style="text-align: right">招聘到期时间:</td>
			<td><input class="easyui-datetimebox"
				name="hiring_expiration_date"
				data-options="required:true,showSeconds:false" style="width: 250px"
				required></td>
		</tr>
		<tr>
			<td style="text-align: right">主标题:</td>
			<td><input type="text" name="main_title" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
			<td style="text-align: right">副标题:</td>
			<td><input type="text" name="subtitle" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">简介:</td>
			<td><input type="text" name="short_description" class="easyui-textbox easyui-validatebox"
				style="width: 250px" required /></td>
			<td style="text-align: right">封页图URL:</td>
			<td><input type="file" name="page_url" class="wu-text"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">首页图URL:</td>
			<td><input type="file" name="first_page_carousel_url"
				class="wu-text" style="width: 250px" required /></td>
			<td style="text-align: right">详情页主图URL:</td>
			<td><input type="file" name="main_page_url" class="wu-text"
				style="width: 250px" required /></td>
		</tr>
		<tr>
			<td style="text-align: right">详情页介绍:</td>
			<td colspan="3">
				<textarea rows="3" style="width:200px;height:100px" id="sn-textarea-intrduction" name="details_page_introduction" class="easyui-validatebox" data-options="required:true,validType:'length[1,1000000]'" invalidMessage="最大长度不能超过1000000""></textarea>  
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_file_dialog"
					style="float: right">确定</button>
			</td>
		</tr>
	</table>
</form>
<div id="dd" style="display:none"></div>

	
	<script>
		var editor;  
	    $(function() {  
	          editor = KindEditor.create('#sn-textarea-intrduction',{
	        	  resizeType : 1,width:"200px",height:"100px",
	        	  filterMode : false,
	        	afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	    });
	  	
	    $("select.easyui-combobox").combobox({
	    	panelHeight:'auto'
	    });
	    $("#at_add_name").combobox({
			panelHeight:'auto',
			onChange: function () {		         
		         var id=$('#at_add_name').val();
	             if(id!=''){
	             	$('input#at_merchant_id').val(id);
	             }		   
			}
		});	  
	    
	    
	    $(function(){  
	        var provinceId = $('#provinceId').combobox({  
	            url:'${pageContext.request.contextPath}/region/province/json.htm',  
	            editable:false,  
	            valueField:'id',  
	            textField:'name',  
	            onSelect:function(record){  
	                //刷新数据，重新读取省份下的城市，并清空当前输入的值  
	                cityId.combobox({  
	                    disabled:false,  
	                    url:'${pageContext.request.contextPath}/region/city/'+record.id+'/json.htm',  
	                    valueField:'id',  
	                    textField:'name'  
	                }).combobox('clear');  
	            }  
	        });  
	        var cityId = $('#cityId').combobox({  
	            disabled:true,  
	            url:'${pageContext.request.contextPath}/region/city/'+provinceId.val()+'/json.htm',  
	            valueField:'id',  
	            textField:'name'  
	        });  
	});  
	    $("#station_name").combobox({
			panelHeight:'auto',
			onChange: function () {		         
		         var aaa=$('#station_name').combobox('getValue');
		         var Stata={};
		         Stata.p_station_id=aaa;
                $.ajax({
                	type:'get',
                	url:'securityPosition/SaddATT2',
                	data:Stata,
                	dataType:'json',
                	success:function(data){
                		$('#post_classification').combobox('clear');
                		$('#post_classification').combobox('loadData', data);    
                	}
                })
               
			}
		});	  
	</script>
