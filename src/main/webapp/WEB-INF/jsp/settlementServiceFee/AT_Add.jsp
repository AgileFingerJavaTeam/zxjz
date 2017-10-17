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
<form action="Settlement/addFunction" class="table_form" method="post">
	<table cellpadding="10" id="at-position-table" class="table_list">
		<tr>
		 	<td style="display:none"><input type='text'  id='at_merchant_id' name='user_id' /></td>
		    <td style="text-align: right" width="120px;">商户名称:</td>
			<td colspan="3"><input type="text" name="merchants_name"  id="merchants_name" class="easyui-textbox easyui-validatebox" data-options="required:true "/>
		  
		</tr>
		<tr>
	 	 	<td style="text-align: right" width="120px;">收费时间:</td>
			<td><input class="easyui-datetimebox"name="settlement_time" id="settlement_time"
				 value="now" data-options="required:true,showSeconds:false" style="width:87%"required>
		   </td>
		    <td style="text-align: right" width="120px;" >收费流水号:</td>
			<td><input type="text" name="withdrawal_serial_number" id="withdrawal_serial_number"  
				style="width: 87%;height:25px;line-height: 25px;border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ; background-color: #eee;" readonly/></td>
			
		</tr>
		<tr>
			<td style="text-align: right">结算费用分类:</td>
			<td>
				<select name="classification_of_settlement_expenses" class="easyui-combobox" style="width: 89%;" required>
					<option value="0">代付工资</option>
					<option value="1">平台服务费</option>
				</select>
			</td>
			<td style="text-align: right">收费金额:</td>
			<td><input type="text" name="settlement_amount"
				class="easyui-textbox" style="width: 87%" required /></td>
			
		</tr>
		<tr>
			<td style="text-align: right">说明:</td>
			<td colspan="3">
			<input class="easyui-textbox" name="instructions" data-options="multiline:true,validType:'length[1,200]'," invalidMessage="最大长度不能超过200字"   style="width:96%;height:100px">
			</td>
		</tr>
		<tr>
			<td style="text-align: right">操作员:</td>
			<td><input type="text"  value="${name}" style="width: 87%;height:25px;line-height: 25px;border-radius:5px; padding: 0px; margin: 0px; border:1px solid #DBDBDB ; background-color: #eee;" readonly/></td>
			<td style="display:none"><input type="text" name="employees_id" value="${id}"  readonly/></td>
			<td colspan="2">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog"
					style="float: right">确定</button>
			</td>
		</tr>
	</table>
</form>
<div id="dd" style="display:none"></div>

	
	<script>
	$("#merchants_name").combogrid({    
		delay: 500,
	    mode: 'remote',
	    panelWidth:null,
	    fitColumns: true,
	    fit: true,   
	    url:"Settlement/getMerchantsName",    
	    idField: 'user_id',    
	    textField: 'merchants_name',
	    pagination:true,
		pagePosition:'bottom',
		/* remoteSort:false, */  //商户名称的  前台排序 
		pageNumber:1,
		pageSize:20,
		pageList:[10,20,30,50,100],
	    columns: [[                                                                          //商户名称的  前台排序 
	        {field:'merchants_name',title:'商户名称',halign:'center',align:'center',width:100/* ,sortable:true */},      
	    ]],
	    onSelect:function(){changeFun()}
	  })
	    $("select.easyui-combobox").combobox({
	    	panelHeight:'auto'
	    });
		   function changeFun(){		         
		         var id=$('#merchants_name').val();
	             if(id!=''){
	             	$('input#at_merchant_id').val(id);}
	             	var data={};
	             	data.id=id;
                     $.ajax({
                    	 type:'get',
                    	 data:data,
                    	 url:'Settlement/add1',
                    	 datatype:'json',
                    	 success:function(data){
                    		 if(data == '0'){
                    			 $('input#withdrawal_serial_number').val(1);
                    		 }else{
                    			 var obj = new Function("return" + data)();//转换后的JSON对象  
                     		    console.log(obj.withlist); 
                    			 $('input#withdrawal_serial_number').val(obj.withlist+1);
                    		 }
                    	}
                     })
		   }
	</script>
