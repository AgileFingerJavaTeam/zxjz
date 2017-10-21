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
<form action="GyStation/editCDetails" class="table_form" method="post">			
     <table class="table_list">
        <tr>
             <th>选择此职位父类：</th>
			 <td><input  id="Srt_cbox" name="pstationId"  value="${data.data.parentJobName}" width="100px"class="wu-text easyui-combobox"required
              data-options="
					url:'GyStation/getPInfo',
					method:'get',
					valueField:'stationId',
					textField:'stationName',
					panelHeight:'auto',"></td>
         </tr>
         <tr>
        	<th width="100">职位分类名称：</th>
            <td >
                 <input type="text"  name="station_name" value="${data.data.childJobInfo.stationName}" class="easyui-textbox easyui-validatebox" data-options="required:true,width:'100%'"/>
                 <input type="hidden" name="station_id" value="${data.data.childJobInfo.stationId}"/>
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
          $('#Srt_cbox').val();   
	}
});

</script>