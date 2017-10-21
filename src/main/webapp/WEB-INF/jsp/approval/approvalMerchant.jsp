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
<form id="approval_form" action="MerchantApproval/hzn_approvalMerchant" class="table_form" method="post">
     <table class="table_list" cellpadding="10px">
           <tr>
             <td style="display:none">审核记录ID：</td>

             <td style="display:none">
                  <input type="text"  name="approval_id" value="${data.data.approvalId}" class="easyui-textbox easyui-validatebox" data-options="width:'100%'" readonly="readonly"/>
             </td>
             <td style="display:none">审核商家ID：</td>

             <td style="display:none">
                  <input type="text"  name="user_id" value="${data.data.userId}" class="easyui-textbox easyui-validatebox" data-options="width:'100%'" readonly="readonly"/>
             </td>
             </tr> 
            <tr>
             <td style="text-align:right" width="120px;">申请序号：</td>
             <td><input class="easyui-textbox" name="approval_num" readonly="readonly"
				data-options="required:true,showSeconds:false"
				value="${data.data.approvalNum}" style="width: 250px" required ></td>
			<td style="text-align:right" width="120px;">公司名称：</td>
             <td><input class="easyui-textbox" name="company_name" readonly="readonly"
				data-options="readonly:true,required:true,showSeconds:false"
				value="${data.data.companyName}" style="width: 250px" required ></td>
            </tr>
         <tr>
	          <td style="text-align:right">申请时间：</td>
	             <td><input class="easyui-textbox" name="apply_time" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.applyTime}" style="width: 250px" required ></td>
			  <td style="text-align:right">负责人：</td>
	             <td><input class="easyui-textbox" name="head" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.head}" style="width: 250px" required ></td>
         </tr>
          <tr>
          	 <td style="text-align:right">公司地址：</td>
	             <td><input class="easyui-textbox" name="company_address" readonly="readonly"
	             	 id="hzn_company_address" 
					value="${data.data.companyAddress}" style="width: 220px" required >
					<a  class="easyui-linkbutton" 
					plain="true"
					iconCls="icon-search"
					id="hzn_show_map"></a></td>
			 <td style="text-align:right">所属行业：</td>
	             <td><input class="easyui-textbox" name="industry_involved" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.industryInvolved}" style="width: 250px" required ></td>
         </tr>
         <tr style="display:none">
             <th width="100">经度：</th>
             <td >
                  <input type="text" id="hzn_company_longitude" name="longitude" value="${data.data.longitude}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
             <th width="70">纬度：</th>
             <td >
                  <input type="text" id="hzn_company_latitude" name="latitude" value="${data.data.latitude}" class="easyui-textbox easyui-validatebox" readonly="readonly" data-options="width:'100%'"/>
             </td>
         </tr>
         <tr>
          	 <td style="text-align:right">职位：</td>
	             <td><input class="easyui-textbox" name="job" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.job}" style="width: 250px" required ></td>
			 <td style="text-align:right">电话：</td>
	             <td><input class="easyui-textbox" name="phone" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.phone}" style="width: 250px" required ></td>
         </tr>
         <tr>
          	 <td style="text-align:right">审核状态：</td>
	             <td><input class="easyui-textbox" name="status" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.status}" style="width: 250px" required ></td>
			<td style="text-align:right">审核时间：</td>
	             <td><input class="easyui-textbox" name="audit_time" readonly="readonly"
					data-options="showSeconds:false"
					value="${data.data.auditTime}" style="width: 250px" ></td>
         </tr>
          <tr>
          <!-- dddddddddddd -->
	       <td style="text-align:right">审核员工：</td>
	             <td><input type="hidden" name="employees_id" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${id}" style="width: 250px;height:25px;line-height: 25px;border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ;" required >
	             	<input  id="one" name="audit_staff" readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${name}" style="width: 250px;height:25px;line-height: 25px;border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ;" required >
					 <input  id="two" name=""  readonly="readonly"
					data-options="required:true,showSeconds:false"
					value="${data.data.employeesName}" style="width: 250px;height:25px;line-height: 25px;border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ;" required >
					</td>
				 <td style="text-align:right">驳回原因：</td>
	             <td><input id="refuse_reason" class="easyui-textbox" name="note" 
					data-options="showSeconds:false"
					value="${data.data.note}" style="width: 250px" ></td>
         </tr>
         <tr>
         	 <td style="text-align:right" >企业营业<br>执照图片：</td>
             <td align="center">
                  <a href="TP/${data.data.url}" target="_blank" ><img alt="营业执照" src="TP/${data.data.url}" width=150px height=200px></a>
                  <input name="url" value="${data.data.url}" style="display:none"/>
             </td>
             <td style="text-align:right" >企业logo图片：</td>
             <td align="center">
                  <a href="TP/${data.data.logoUrl}" target="_blank" ><img alt="企业logo" src="TP/${data.data.logoUrl}" width=150px height=200px></a>
                  <input name="logo_url" value="${data.data.logoUrl}" style="display:none"/>
             </td>
         </tr>  
		<input class="approval_result" name="approval_result" value="result" style="display:none"/>        
         <tr>
            <td colspan="4">          
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog hzn_reject" style="float:right">驳回</button>
                <button type="button" class="table_form_submit_dialog hzn_adopt" style="float:right">通过</button>
            </td>
        </tr>
     </table>
</form>
<div id="hzn_map_div" style="display:none"></div>
<script>
	$(document).ready(function(){	
		var a=$("input[name='status']").val();
		if(a!='等待审核'){
			$('.hzn_reject').hide();
			$('.hzn_adopt').hide();
			$('#one').hide();
		}else{
			$('#one').show();
			$('#two').hide();
		}
		
		
		$('a#hzn_show_map').click(function(){
			$('#hzn_map_div').dialog({    
    		    title: '地图',    
    		    width: 750,    
    		    height: 550,    
    		    closed: false,    
    		    cache: false,    
    		    href: 'MerchantApproval/showMerchantMapPage',
    		    modal: true   
    		}); 
		});
	});
     $("button.hzn_reject").on('click',function(){
    	  if($('#refuse_reason').val().trim()==""||$('#refuse_reason').val().trim()==null){
    		  $.messager.show({
                  title:'注意',
                  msg:'请填写驳回信息'
              });
    		 return false;
    	 } 
    	 $("input.approval_result").val("审核驳回");
     });

     $("button.hzn_adopt").on('click',function(){

    	 $("input.approval_result").val("审核通过");
     });
     
     
     function submitForm(){
			$('#approval_form').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
</script>
