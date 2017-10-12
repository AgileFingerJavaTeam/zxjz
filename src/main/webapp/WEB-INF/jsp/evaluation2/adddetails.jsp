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
<form action="GyStation/AddCInfo" class="table_form" method="post">			
     <table class="table_list">
        <tr>
             <th>此职位父类名：</th>            
			  <td>
			   <input type="text"  name="pstation_name" value="${data.pname}" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
			  <!-- <input  id="Srt_cbox" name="station_id" width="100px"class="wu-text easyui-combobox"required 
              data-options="
					url:'GyStation/getPInfo',
					method:'get',
					valueField:'station_id',
					textField:'station_name',
					panelHeight:'auto',"> -->
			</td>  
         </tr>
         <tr>
        	<th width="100">职位分类名称：</th>
            <td ><input type="hidden" name="p_station_id" value="${data.pid}"/>
                 <input type="text"  name="station_name" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
            </td>
        </tr>
      
        
		
        <tr>
            <td colspan="4">
               	<button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
               	<button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
        </tr>
     </table>
</form>
<script type="text/javascript">       
$("#Srt_cbox").combobox({
	panelHeight:'auto',
	onChange: function () {		         
         var id=$('#Srt_cbox').val();
/*          if(id!=''){
         	$('input#merchant_id').val(id);
         }	 */	   
	}
});
  //绑定下拉框
/*  $('#Srt_cbox').combobox({
         url:'GyStation/StationList',                       
         valueField: 'station_id',
         textField: 'station_name'
         });                            
 $("#srt_cbox").combobox('getValues') */
</script>