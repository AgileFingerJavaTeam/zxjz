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
<form action="Recharge/subform" id="formsub" class="table_form" method="post">
     <table class="table_list">
         <tr >
	             <th width="160" >商户名称：</th>
	             <td colspan="3">
	             
	            	  <input type="text"   name="user_id" style="width:100%" id="merchants_name" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>                    
         </tr>
		 <tr>
				 <th >充值流水号：</th>
	             <td >
	                  <input type="text" id="sequence_number"  name="recharge_sequence_number" class="easyui-textbox easyui-validatebox" data-options="readonly:true"/>
	             </td>
	              <th width="100">充值时间：</th>
	             <td >
				         <input  id="rechargeTime"  name="recharge_time" value="now" class="easyui-datetimebox" data-options="required:true" />
	             </td>   
		 </tr>
		 <tr>
				 <th >充值方式：</th>
	             <td >
	             		<input type="hidden" id="chargemethodnum" name="recharge_mode" />
	                  <input type="text" id="chargemethod"  name="recharge_mode_name" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td> 
	             <th >充值金额：</th>
	             <td >
				         <input  id="rechargeAmount"  name="amount_of_recharge" class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>
		 </tr>
		 <tr>
	             <th >支付平台流水号：</th>
	             <td >
				         <input  name="payment_platform_flow_number" class="easyui-textbox easyui-validatebox"  />
	             </td>
	             <th >操作员：</th>
	             <td >
	                  <input type="text"  name="operating_staff_id" value="11"  class="easyui-textbox easyui-validatebox" readonly/>
	             </td>                           
         </tr> 
         <tr>
	             <th >说明：</th>
	             <td colspan="3">
	                  <input type="text"  name="declare" class="easyui-textbox easyui-validatebox" data-options="multiline:true,validType:'length[1,200]'," invalidMessage="最大长度不能超过200字"   style="width:100%;height:100px" />
	             </td>                          
         </tr>   
      
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>               
                <button type="button" class="bxw_pass table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>
<script>
$("#merchants_name").combogrid({    
		delay: 500,
	    mode: 'remote',
	    panelWidth:500,
	    fitColumns: true,
	    fit: true,   
	    url:"Recharge/getMerchantsName",    
	    idField: 'userId',
	    textField: 'merchantsName',
	    pagination:true,
		pagePosition:'bottom',
		pageNumber:1,
		pageSize:20,
		pageList:[10,20,30,50,100],
	    columns: [[    
	        {field:'merchantsName',title:'商户名称',halign:'center',align:'center',width:100,sortable:true},
	    ]],
	    onSelect:function(){ aaa()}
	  })
$("#chargemethod").combobox({    
	  url:"Recharge/getChargeMethod",
	  method : "post",  
	  valueField: 'rechargeModeName',
	  textField: 'rechargeModeName',
	  onSelect:function(chargemethodlist){
	      alert(chargemethodlist.rechargeMode);
		 $('#chargemethodnum').val(chargemethodlist.rechargeMode);
	  }
	  }) ;
	  
	  
	  
	  	function aaa(){
		  var merchants_id=$('#merchants_name').val();
		  $.ajax({  
			    type: "POST",  
			    url: "Recharge/getNum",  
			    data: {'merchants_id':merchants_id},  
			    dataType: "json",  
			    success: function(num){//调用成功
					$('#sequence_number').textbox("setValue",num);
			    },  
			 });
  		}

  		$("#formsub").click(
  		    function () {
				var array=$("#formsub").serializeArray();
				console.log(array);
            }
		);

</script>


