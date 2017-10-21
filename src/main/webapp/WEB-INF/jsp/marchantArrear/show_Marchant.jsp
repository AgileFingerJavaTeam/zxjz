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
<table id="asd" height="70px;" align="center">
	<tr>
		<td style="text-align: right">欠款商户数量:</td>
		<td><input type="text"  value="${count}"
				   class="easyui-textbox" style="width: 100px" disabled />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td style="text-align: right">欠款总金额: ￥</td>
		<td><input type="text"  value="${money}"
				   class="easyui-textbox" style="width: 100px" disabled />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td style="text-align: right">当前授信商户数量:</td>
		<td><input type="text"  value="${vip}"
				   class="easyui-textbox" style="width: 100px" disabled />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td style="text-align: right">当前授信商户授信总金额: ￥</td>
		<td><input type="text"  value="${vipMoney}"
				   class="easyui-textbox" style="width: 100px" disabled />
		</td>
	</tr>
</table>
<div region="center" style="padding:5px; height: 575px;" border="false">
<table id="at_marchantArrear"></table>
<script>
    $.Admin.at_marchantArrear = {
        //组件ID
        'id' : '#at_marchantArrear',
        //工具栏
        'tools' : [
            { text: '查看', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.at_marchantArrear.showSecurity();
            }
            },
            {
                text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="at_search" style="width:200px">',
            },
            {
                iconCls:'icon-search',
                handler:function(){
                    $.Admin.at_marchantArrear.search();
                }
            },

        ],
        //模糊查询
        'search' :function(){
            var a=$('#at_search').val();
            var at_search={};
            at_search.at_search=a;
            $.ajax({
                type:'post',
                title: '模糊查询',
                data:at_search,
                iconCls:'icon-search',
                url: "MarchantArrear/getMarchantListSearch",
                datatype:'json',
                success:function(search_list){
                    $('#at_marchantArrear').datagrid('loadData', search_list);
                }

            });
        },

        //查看
        'showSecurity' : function(){
            var get_select_row = $($.Admin.at_marchantArrear.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要查看的数据行','error');
                return false;
            }
            var data = {id: get_select_row.userId};
            var id = $.Admin.random_dialog();
            $(id).dialog({
                title: '资金账户基本信息',
                iconCls: 'fa fa-edit',
                queryParams: data,
                href: "MarchantArrear/showSecurity",
                modal: true,
                width: 1300,
                height:800,
                onClose : function(){
                    $(this).dialog("destroy");
                },
                onOpen : function(){
                    var top = $(this).offset().top-$(this).position().top;
                    $(this).dialog('resize',{
                        top: (top/2)+'px'
                    });
                }
            });
        }
    }

    $($.Admin.at_marchantArrear.id).datagrid({
        title: '当前位置：业务管理 > 商户财务管理> 商户欠费统计',
        border: false,
        toolbar: $.Admin.at_marchantArrear.tools,
        fitColumns: true,
        fit: true,
        ctrlSelect: true,
        singleSelect: false,
        rownumbers: true,
        idField: 'userId',
        url: "MarchantArrear/getMarchantList",
        pagination:true,
        pagePosition:'bottom',
        pageNumber:1,
        fit:true,
        pageSize:20,
        pageList:[10,20,30,50,100],
        columns:[[
            {field:'ck',checkbox:true},
            {field:'merchantsName',title:'商户名称',align:'center',width:100},
            {field:'creditTotal',title:'授信总额',align:'center',width:100},
            {field:'creditBalance',title:'授信余额',align:'center',width:100},
            {field:'sumActual',title:'欠款金额',align:'center',width:100},
            {field:'paymentDays',title:'账期',align:'center',width:100},
        ]],
        onDblClickRow: function(row){

        },
        onRowContextMenu: function(e,index,data){
            e.preventDefault();//阻止浏览器捕获右键事件
        }
    });
    $('#at_search').textbox({ icons: [{
        iconCls: 'icon-clear',
        handler: function (e) {
            $(e.data.target).textbox('clear');
            $.Admin.at_marchantArrear.search();
        } }] });

</script>
</div>