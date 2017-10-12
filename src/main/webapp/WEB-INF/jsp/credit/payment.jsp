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
<form action="money/subpayment"id="form1" class="table_form" method="post">			
     <table class="table_list">
         <tr >
             <th width="100" >商户名称：</th>
             <td >
             	<input type="hidden" name="user_id" value="${data.user_id}"/>
            	<input type="text"  id="bxw_btn" name="merchants_name" value="${data.merchants_name}"  id="employees_num" class="easyui-textbox easyui-validatebox" data-options="readonly:true, width:'100%',events:{change: function(){ aaa() }} "/>
             </td>           
         </tr>
         <tr>
         	 <th width="100">账户余额：</th>
             <td >
                  <input type="text"  name="account_balance" value="${data.account_balance}" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th width="100">授信总额：</th>
             <td >
              
			         <input   value="${data.credit_total}" name="credit_total" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>  
			    	

             </td>            
         </tr>  
          <tr>
             <th width="100">授信余额：</th>
             <td >
              
			         <input   value="${data.credit_balance}" name="credit_balance" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>  
			    	

             </td>            
         </tr>  
          <tr>
             <th width="100">欠款金额：</th>
             <td >
              
			         <input   value="${data.debt} " name="dept" class="easyui-textbox easyui-validatebox" data-options="readonly:true,width:'100%'"/>  
			    	

             </td>            
         </tr>  
          <tr>
             <th width="100">账期：</th>
             <td >
              
			         <input  value="${data.payment_days}" name="payment_days" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>  
			    	

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
	
</script>


