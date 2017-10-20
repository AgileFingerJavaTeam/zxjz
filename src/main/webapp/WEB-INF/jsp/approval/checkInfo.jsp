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
<form action="approval/subInfo"id="form1" class="table_form" method="post">			
     <table class="table_list">
         <tr >
             <th width="100" >发布用户：</th>
             <td ><input type="hidden" name="recruiting_id" value="${data.data.recruitingId}"/>
                  <input type="hidden"  name="releases_user_id" value="${data.data.releasesUserId}"/>
            	  <input type="text"  name="merchants_name" value="${data.data.merchantsName}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
             <th width="70">申请序号：</th>
             <td >
                  <input type="text"  name="apply_num" value="${data.data.applyNum}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th width="70">申请时间：</th>
             <td >
                  <input type="text"  name="apply_time" value="${data.data.applyTime}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
             <th width="70">岗位名称：</th>
             <td >
                  <input type="text"  name="post_name" value="${data.data.postName}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
                  <input type="hidden"  name="details_page_category" value="${data.data.detailsPageCategory}"/>
             </td>
         </tr>
         <tr>
             <th width="70">岗位分类：</th>
             <td >
             <input type="hidden"  name="post_classification" value="${data.data.postClassification}"/>
                  <input type="text"  name="station_name" value="${data.data.stationName}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
            <th width="70">工作日期：</th>
             <td >
                  <input type="text"  name="work_date" value="${data.data.workDate}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             
             <th width="70">工作时间：</th>
             <td >
                  <input type="text"  name="work_time" value="${data.data.workTime}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
             
             
             
             <th width="70">工作内容：</th>
             <td >
                  <input type="text"  name="work_content" value="${data.data.workContent}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th width="70" >工作地点：</th>
              <td colspan="3">
              	<input type="hidden"  name="city" value="${data.data.city}"/>
               	<input type="hidden" id="long"  name="position_longitude" value="${data.data.positionLongitude}"/>
				<input type="hidden" id="lat"  name="position_latitude" value="${data.data.positionLatitude}"/>
             	<input type="text"   name="work_location" value="${data.data.workLocation}" class="easyui-textbox easyui-validatebox"  style="width:90%" data-options="readonly:true">
            	<a id="btn"></a>
       
             </td>           
         </tr>
         <tr>
         	 <th width="70">结算方式：</th>
             <td >
                  <input type="text"  name="settlement_method" value="${data.data.settlementMethod}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
            
             <th width="70">工资待遇：</th>
             <td >
                  <input type="text"  name="salary_treatment" value="${data.data.salaryTreatment}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
            
         </tr>
         <tr>
              <th width="70">提成：</th>
             <td >
                  <input type="text"  name="commission" value="${data.data.commission}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
             <th width="70">福利：</th>
             <td >
                  <input type="text"  name="benefits" value="${data.data.benefits}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
             
         </tr>
         <tr>
             <th width="70">性别要求：</th>
             <td >
                  <input type="text"  name="gender_requirements" value="${data.data.genderRequirements}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
			 <th width="70">招聘人数：</th>
             <td >
             <input type="hidden"  name="people_num" value="${data.data.peopleNum}"/>
                  <input type="text"  name="recruitment" value="${data.data.recruitment}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>

             <th width="90">招聘到期时间：</th>
             <td >
                  <input type="text"  name="hiring_expiration_date" value="${data.data.hiringExpirationDate}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
              <th width="70">审核状态：</th>
             <td >
             <input type="hidden" class="stat_res" name="stat_res" value="0"/>
                  <input type="text"  name="audit_status" id="asd" value="${data.data.auditStatus}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
         
             <th width="70">审核人：</th>
             <td >
            	<input type=hidden value="${id}" name="employid">
                  <input type="text" id="auditorman" name="auditor" value="${name}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
            <th width="70">审核时间：</th>
             <td >
                  <input type="text"  name="status_time" value="${data.data.statusTime}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
          
             <th width="70">驳回原因：</th>
             <td colspan="3">
                  <input type="text" id="reason"   name="dismissed_reason" value="${data.data.dismissedReason}" class="easyui-textbox easyui-validatebox"  data-options="readonly:false,width:'100%'"/>
             </td>
         </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button"  class="bxw_reject table_form_submit_dialog" style="float:right" >驳回</button>
                <button type="button" class="bxw_pass table_form_submit_dialog" style="float:right">通过</button>
            </td>
        </tr>
     </table>
</form>
<div id="dd" style="display:none"></div>
<script>

	$(document).ready(function(){
		var a=$('#asd').val();	
		if(a!='待审核'){
			$('.bxw_reject').hide();
			$('.bxw_pass').hide();
			$('#auditorman').textbox().textbox("setValue","${data.data.employeesName}");
		}	
		
		$('#btn').linkbutton({    
			iconCls:'icon-search',				
		});  
	})
	
	$('#btn').on('click',function(){
		var data={pos_long:$("#long").val(),pos_lat:$("#lat").val()};
		$('#dd').dialog({    
		    title: '地图',    
		    width: 900,    
		    height: 600,    
		    closed: false,    
		    cache: false,
		    queryParams:data,
		    href: 'approval/Map',    
		    modal: true ,  
		    onRowContextMenu: function(e,index,data){
		        e.preventDefault();//阻止浏览器捕获右键事件
		    }
		}); 		
	})
	
	
     $(".bxw_reject").on('click',function(){ 
    	 if($('#reason').val().trim()==null||$('#reason').val().trim()==''){
  			$.messager.show({
                 title:'消息',
                 msg:'请填写驳回信息'
             })
             return false;
  		}	 
    	 $(".stat_res").val("1");
 		
     });
  
</script>

