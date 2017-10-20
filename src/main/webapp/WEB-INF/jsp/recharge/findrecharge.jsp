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
<form action="Recharge/subadd" class="table_form" method="post">			
     <table class="table_list">
         <tr >
             <th width="130" >商户名称：</th>
             <td >
            	  <input type="text"   name="user_id" value="${data.merchantsName}" id="merchants_name" class="easyui-textbox easyui-validatebox" data-options="readonly:true"/>
             </td> 
             <th width="130">充值流水号：</th>
             <td >
                  <input type="text"  name="recharge_sequence_number" value="${data.rechargeSequenceNumber}"  class="easyui-textbox easyui-validatebox" data-options="readonly:true"/>
             </td>          
         </tr>

         <tr>
             <th width="130">充值时间：</th>
             <td >
			         <input  id="admiDivisionCode"  name="recharge_time" value="${data.rechargeTime}" class="easyui-datetimebox" data-options="readonly:true" />
             </td> 
             <th width="130">充值方式：</th>
             <td >
                  <input type="text" id="chargemethod"  name="recharge_mode_name" value="${data.rechargeModeName}"  class="easyui-textbox easyui-validatebox" data-options="readonly:true"/>
             </td>            
         </tr>   
         <tr>
             <th width="130">充值金额：</th>
             <td >
			         <input  id="admiDivisionCode"  name="amount_of_recharge" value="${data.amountOfRecharge}"  class="easyui-textbox easyui-validatebox" data-options="readonly:true" />
             </td> 
             <th width="130">说明：</th>
             <td >
                  <input type="text"  name="declare" class="easyui-textbox easyui-validatebox" value="${data.rechargeDeclare}" data-options="readonly:true" />
             </td>            
         </tr>   
         <tr>
             <th width="130">支付平台流水号：</th>
             <td >
			         <input    name="payment_platform_flow_number" class="easyui-textbox easyui-validatebox" value="${data.paymentPlatformFlowNumber}" data-options="readonly:true" />
             </td> 
             <th width="130">操作员：</th>
             <td >
             	<input type="hidden"  value="${data.employeesId}">
                  <input type="text"  name="employees_name" class="easyui-textbox easyui-validatebox" value="${data.employeesName}"data-options="readonly:true" />
             </td>            
         </tr>       
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>               
               
            </td>
        </tr>
     </table>
</form>
<script>

$("#chargemethod").combobox({    
	  url:"Recharge/getChargeMethod",
	  method : "post",  
	  valueField: 'rechargeModeName',
	  textField: 'rechargeModeName',
	  }) 	  
</script>


