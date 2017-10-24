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
    <table id="at_marchantFind"></table>
    <script>
        $.Admin.at_marchantFind = {
            //组件ID
            'id' : '#at_marchantFind',
            //工具栏
            'tools' : [
                { text: '修改', iconCls: 'fa fa-edit', handler: function(){
                    $.Admin.at_marchantFind.showSecurity();
                }
                },
                {
                    text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="at_marchant_search" style="width:200px">',
                },
                {
                    iconCls:'icon-search',
                    handler:function(){
                        $.Admin.at_marchantFind.search();
                    }
                },
                {
                    text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择日期：<input id="at_date_time_start" class="easyui-datebox" required  style="width:150px">&nbsp;一&nbsp;<input id="at_date_time_end" class="easyui-datebox" required style="width:150px">',
                },
                {
                    iconCls:'icon-search',
                    handler:function(){
                        $.Admin.at_marchantFind.at_date_time();
                    }
                },
                {
                    iconCls:'icon-clear',
                    handler:function(){
                        $('#at_date_time_start').textbox('clear');
                        $('#at_date_time_end').textbox('clear');
                        $.Admin.at_marchantFind.at_date_time();
                    }
                },
            ],

            //时间查询
            'at_date_time' :function(){
                var start_time=$('#at_date_time_start').val();
                var end_time=$('#at_date_time_end').val();
                var at_date_time={};
                if(start_time == null && end_time == null){
                    at_date_time = '';
                }else if(start_time !=null && end_time == null){
                    at_date_time.start_time=start_time;
                }else if(end_time !=null && start_time == null){
                    at_date_time.end_time=end_time;
                }else{
                    at_date_time.start_time=start_time;
                    at_date_time.end_time=end_time;
                }
                $.ajax({
                    type:'post',
                    title: '时间查询',
                    data:at_date_time,
                    iconCls:'icon-search',
                    url: "MarchantFind/getMarchantListTimeSearch",
                    datatype:'json',
                    success:function(search_list){
                        $('#at_marchantFind').datagrid('loadData', search_list);
                    }

                });
            },
            //模糊查询
            'search' :function(){
                var a=$('#at_marchant_search').val();
                var at_marchant_search={};
                at_marchant_search.at_marchant_search=a;
                $.ajax({
                    type:'post',
                    title: '模糊查询',
                    data:at_marchant_search,
                    iconCls:'icon-search',
                    url: "MarchantFind/getMarchantList",
                    datatype:'json',
                    success:function(search_list){
                        $('#at_marchantFind').datagrid('loadData', search_list);
                    }

                });
            },
            //修改
            'showSecurity' : function(){
                var get_select_row = $($.Admin.at_marchantFind.id).datagrid('getSelected');
                var data = {id: get_select_row.userId}
                if(get_select_row.isLook=="是"){
                    $.messager.show({
                        title:'消息',
                        msg:'已读的消息不能更改'
                    })
                    return false;
                };
                var id = $.Admin.random_dialog();
                $(id).dialog({
                    title: '修改信息审核状态',
                    iconCls: 'fa fa-edit',
                    queryParams: data,
                    href: "MarchantFind/showUpdate",
                    modal: true,
                    width: 400,
                    height:200,
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

        $($.Admin.at_marchantFind.id).datagrid({
            title: '当前位置：业务管理 > 商户财务管理> 商户信息查看',
            border: false,
            toolbar: $.Admin.at_marchantFind.tools,
            fitColumns: true,
            fit: true,
            ctrlSelect: true,
            singleSelect: false,
            rownumbers: true,
            idField: 'userId',
            url: "MarchantFind/getMarchantList",
            pagination:true,
            pagePosition:'bottom',
            pageNumber:1,
            fit:true,
            pageSize:20,
            pageList:[10,20,30,50,100],
            columns:[[
                {field:'ck',checkbox:true},
                {field:'registrationTime',title:'注册时间',align:'center',width:100},
                {field:'merchantsName',title:'商户名',align:'center',width:100},
                {field:'head',title:'负责人',align:'center',width:100},
                {field:'boundPhone',title:'联系方式',align:'center',width:100},
                {field:'merchantsState',title:'信息审核状态',align:'center',width:100},
                {field:'state',title:'状态',align:'center',width:100},
                {field:'isLook',title:'读取状态',align:'center',width:100,formatter: function(value,row,index){
                    if( value == '否'){
                        return '未读'
                    }else{
                        return '已读'
                    }
                }},
            ]],
            onDblClickRow: function(row){

            },
            onRowContextMenu: function(e,index,data){
                e.preventDefault();//阻止浏览器捕获右键事件
            }
        });

        $('#at_marchant_search').textbox({ icons: [{
            iconCls: 'icon-clear',
            handler: function (e) {
                $(e.data.target).textbox('clear');
                $.Admin.at_marchantFind.search();
            } }] });



    </script>