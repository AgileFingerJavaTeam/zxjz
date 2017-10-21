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
<form action="StudentWithdraw/disposeStudentWithdrawInfo" class="table_form" method="post">
	 <table class="table_list">
	     <tr>
             <th>提现人：</th>
			 <td>
				 <input   name="user_name" value="${data.data.name}" class="easyui-textbox easyui-validatebox"  readonly="readonly" width="100px">
				 <input type="hidden"  name="user_id" value="${data.data.userId}" width="100px">
				 <input type="hidden"  name="status" value="${data.data.isOk}" width="100px">
			 </td>
         </tr>
		 <tr>
			 <th>提现流水号：</th>
			 <td>
				 <input   name="withdraw_num" value="${data.data.withdrawNum}" class="easyui-textbox easyui-validatebox"  readonly="readonly" width="100px">
			 </td>
		 </tr>
		 <tr>
			 <th>提现时间：</th>
			 <td>
				 <input   name="witdrawTime" value="${data.data.withdrawTime}" class="easyui-textbox easyui-validatebox"  readonly="readonly" width="100px">
			 </td>
		 </tr>
		 <tr>
			 <th>提现金额：</th>
			 <td>
				 <input   name="withdrawMoney" value="${data.data.withdrawMoney}" class="easyui-textbox easyui-validatebox"  readonly="readonly" width="100px">
			 </td>
		 </tr>
		 <tr>
			 <th>支付宝账号：</th>
			 <td>
				 <input   name="aliPayId" value="${data.data.alipayId}" class="easyui-textbox easyui-validatebox"  readonly="readonly" width="100px">
			 </td>
		 </tr>
		 <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog studentWithdrawPass" style="float:right">受理</button>
            </td>
         </tr>
	
	 </table>
</form>
<script>
    $(document).ready(function(){
        var a=$("input[name='status']").val();
        if(a!='0'){
            $('.studentWithdrawPass').hide();
        }
    });
</script>
