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
<div style="width: 1300px; height: 300px;">
    <table cellpadding="10" id="at-position-table" class="table_list" >
        <tr>
            <td style="text-align: right;width: 500px;">商户名称:</td>
            <td><input type="text" value="${data.merchantsName}" class="easyui-textbox"
                       style="width: 250px"  disabled/></td>
        </tr>
        <tr>
            <td style="text-align: right">授信总额:</td>
            <td><input type="text"  value="${data.creditTotal}"
				class="easyui-textbox" style="width: 250px" disabled />
            </td>
        </tr>
        <tr>
            <td style="text-align: right">授信余额:</td>
            <td><input type="text"  value="${data.creditBalance}" class="easyui-textbox"
				style="width: 250px" disabled />
            </td>
        </tr>
        <tr>
            <td style="text-align: right">欠款金额:</td>
            <td><input type="text" value="${data.sumActual}" class="easyui-textbox" style="width: 250px" disabled />
            </td>
        </tr>
        <tr>
            <td style="text-align: right">账期:</td>
            <td><input type="text" name="merchants_name" value="${data.paymentDays}" class="easyui-textbox" style="width: 250px"  disabled/></td>
        </tr>
        <!-- 			<td colspan="4">
                        <button type="button" class="table_form_close_dialog "
                            style="float: right">关闭</button>
                        <button type="button" class="table_form_submit_dialog"
                            style="float: right">确定</button>
                    </td> -->
    </table>
</div>
<hr>
<div region="center" style="padding:5px; height: 410px;" border="false">
<table id="at_marchantArrears"></table>
<script>
    $.Admin.at_marchantArrears = {
        //组件ID
        'id' : '#at_marchantArrears',
        //工具栏
        'tools' : [
            {
                text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="at_searchs" style="width:200px">',
            },
            {
                iconCls:'icon-search',
                handler:function(){
                    $.Admin.at_marchantArrears.search();
                }
            },

        ],
        //模糊查询
        'search' :function(){
            var a=$('#at_searchs').val();
            var v=${data.userId};
            var at_searchs={};
            at_searchs.at_searchs=a;
            at_searchs.id=v;
            $.ajax({
                type:'post',
                title: '模糊查询',
                data:at_searchs,
                iconCls:'icon-search',
                url: "MarchantArrear/getReceivablesListSearch",
                datatype:'json',
                success:function(search_list){
                    $('#at_marchantArrears').datagrid('loadData', search_list);
                }

            });
        },
    }
    var data = {id:${data.userId}};
    $($.Admin.at_marchantArrears.id).datagrid({
        iconCls: 'fa fa-edit',
        title: '应收款列表',
        border: false,
        toolbar: $.Admin.at_marchantArrears.tools,
        fitColumns: true,
        fit: true,
        ctrlSelect: true,
        singleSelect: false,
        rownumbers: true,
        queryParams: data,
        idField: 'userId',
        url: "MarchantArrear/getReceivablesList",
        pagination:true,
        pagePosition:'bottom',
        pageNumber:1,
        pageSize:20,
        pageList:[10,20,30,50,100],
        columns:[[
            {field:'ck',checkbox:true},
            {field:'serialNumber',title:'应收款序号',align:'center',width:100},
            {field:'arrearsTime',title:'欠款时间',align:'center',width:100},
            {field:'deductedS',title:'应扣款金额',align:'center',width:100},
            {field:'deductedI',title:'实扣款金额',align:'center',width:100},
            {field:'actualAmount',title:'应收金额',align:'center',width:100},
            {field:'isBack',title:'是否收回',align:'center',width:100},
        ]],

        onDblClickRow: function(row){

        },
        onRowContextMenu: function(e,index,data){
            e.preventDefault();//阻止浏览器捕获右键事件
        }
    });

    $('#at_searchs').textbox({ icons: [{
        iconCls: 'icon-clear',
        handler: function (e) {
            $(e.data.target).textbox('clear');
            $.Admin.at_marchantArrears.search();
        } }] });

</script>
</div>