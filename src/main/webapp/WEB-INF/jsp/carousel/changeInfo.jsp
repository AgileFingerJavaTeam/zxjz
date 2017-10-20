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
<form action="CarouselManage/changeCarousel" class="table_form" method="post">			
     <table class="table_list">
		<tr>
		<td align="right" style="width=:30%">更改状态为:
			<select id="upState" class="easyui-combobox" name="state"
				style="width:50%" data-options="panelHeight:'auto'" required>
					<option value="有效"
						<c:if test="${data.state=='有效'}">selected="selected"</c:if>>有效</option>
					<option value="暂停"
						<c:if test="${data.state=='暂停'}">selected="selected"</c:if>>暂停</option>
			</select>
		</td>
		</tr> 
         <tr>
            <td>
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
                <button type="button" class="table_form_submit_dialog" style="float:right">确定</button>
            </td>
         </tr>
        	<input type="hidden" name="carousel_figure_id" value="${data.carouselFigureId}" />
     </table>
</form>
