<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<table id="addMerchant"></table>
<script>
    $.Admin.addMerchant = {
        //组件ID
        'id' : '#addMerchant',
        //工具栏
        'tools' : [
            //搜索
            {text: '&nbsp&nbsp&nbsp&nbsp<input id="searchMerchant" type="text"></input>'},
            {iconCls: 'icon-search',
                handler : function (){
                $.Admin.addMerchant.searchMerchant();
                }
            },
            //新增
            {text:'新增',iconCls:'fa fa-plus',
                handler:function () {
                $.Admin.addMerchant.insertMerchant();
                }
            },
            //编辑
            {text:'编辑',iconCls:'fa fa-search',
                handler:function () {
                $.Admin.addMerchant.editMerchant();
                }
            }
        ],
        //搜索
        'searchMerchant' : function(){
            var search_content = $('#searchMerchant').val();
            var merchantManage_searchInfo={};
            var page=1;
            var rows=20;
            merchantManage_searchInfo.page=page;
            merchantManage_searchInfo.rows=rows;
            merchantManage_searchInfo.search_content=search_content;;
            $.ajax({
                type:'POST',
                data: merchantManage_searchInfo,
                dataType:'json',
                url:"AddMerchant/findAcceptedMerchantsList",
                success: function(AcceptedMerchantsList){
                    $('#addMerchant').datagrid('loadData', AcceptedMerchantsList);
                }
            });
        },
        //新增
        'insertMerchant' : function () {
            var merchantId = $.Admin.random_dialog();
            $(merchantId).dialog({
                title:'新增商户',
                iconCls:'fa fa-plus',
                href:"AddMerchant/showAddMerchantDialog",
                modal:true,
                closed:false,
                width:400,
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
        },
        //编辑
        'editMerchant':function () {
            var get_select_row = $($.Admin.addMerchant.id).treegrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息','请先选择您要编辑的数据行','error');
                return false;
            }
            var merchantId = {id:get_select_row.userId};
            var editMerchantDialog = $.Admin.random_dialog();
            $(editMerchantDialog).dialog({
                title:'编辑商户',
                iconCls: 'fa fa-edit',
                queryParams: merchantId,
                href: "AddMerchant/showEditMerchantDialog",
                modal: true,
                width: 400,
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
    },
        $($.Admin.addMerchant.id).datagrid({
            title: '当前位置：系统中心 > 系统设置 > 系统参数管理',
            border: false,
            toolbar: $.Admin.addMerchant.tools,
            fitColumns: true,
            fit: true,
            ctrlSelect: true,
            singleSelect: false,
            rownumbers: true,
            idField: 'userId',
            url: "AddMerchant/findAcceptedMerchantsList",
            remoteSort:false,
            pagination:true,
            pagePosition:'bottom',
            pageNumber:1,
            pageSize:20,
            pageList:[10,20,30,50,100],
            columns:[[
//	            {field:'ck',checkbox:true},
//              {field:'userId',title:'商户ID',align:'center',width:80,},
                {field:'registrationTime',title:'注册时间',align:'center',width:80,},
                {field:'boundPhone',title:'手机号',align:'center',width:80,},
            ]],
            onDblClickRow: function(row){

            },
            onRowContextMenu: function(e,index,data){
                e.preventDefault();//阻止浏览器捕获右键事件
            }
        });
    //取消搜索插件
    $('#searchMerchant').textbox().textbox({ icons: [{
        iconCls: 'icon-clear',
        handler: function (e) {
            $(e.data.target).textbox('clear');
            $.Admin.addMerchant.searchMerchant();
        }
    }] })

</script>