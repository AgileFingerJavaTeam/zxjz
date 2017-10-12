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
<form action="authority/subemploy" class="table_form" method="post">			
     <table class="table_list">
         <tr >
             <th width="100" >员工编号：</th>
             <td >
            	  <input type="text"  id="bxw_btn" name="employees_num"  id="employees_num" class="easyui-textbox easyui-validatebox" data-options="required:true, width:'100%',events:{change: function(){ aaa() }} "/>
             </td>           
         </tr>
         <tr>
         	 <th width="100">员工姓名：</th>
             <td >
                  <input type="text"  name="employees_name" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
             </td>
         </tr>
         <tr>
             <th width="100">权限分组：</th>
             <td >
			         <input  id="admiDivisionCode" value="${data.permission_grouping_name}" name="permission_grouping_name" style="width:100%" data-options="required:true" />  
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
/* 下拉框 */
  $("#admiDivisionCode").combobox({    
  url:"authority/checkauth",
  method : "post",  
  valueField: 'permission_grouping_name',  
  textField: 'permission_grouping_name',
  })  
  
  	  
/* 检验员工编号是否重复 */
   	function aaa(){
	  $.ajax({  
		    type: "POST",  
		    url: "authority/checknum",  
		    data: '',  
		    dataType: "json",  
		    success: function(response){//调用成功  
		    	con = "";
		    	$.each(response, function(index, item){
		    		con = item.employees_num;   
		    		var a=$('#bxw_btn').val();
					if(a==con){
						alert('员工编号已存在')
						$('#bxw_btn').textbox('reset');
					}
		    	 });		    					
		    },  
		 });
  }

</script>


