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
<table id="starEnterpriseLoGo"></table>
<script>

    $.Admin.starEnterpriseLoGo = {
        //组件ID
        'id' : '#starEnterpriseLoGo',
        //工具栏
        'tools' : [
            { text: '编辑', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.starEnterpriseLoGo.CheckInfo();
            }
            },
        ],

        //修改信息
        'CheckInfo' : function(){
            var get_select_row = $($.Admin.starEnterpriseLoGo.id).datagrid('getSelected');

            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
                return false;
            }
            var data = {icon_id: get_select_row.iconId};
            var id = $.Admin.random_dialog();
            $(id).dialog({
                title: '修改企业Logo',
                iconCls: 'fa fa-edit',
                queryParams:data,
                href: "StarEnterpriseLoGo/showUpdateStarLoGo",
                modal: true,
                width: 300,
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


    }
    $($.Admin.starEnterpriseLoGo.id).datagrid({
        title: '当前位置：业务管理>审核管理>首页明星企业logo管理',
        border: false,
        toolbar: $.Admin.starEnterpriseLoGo.tools,
        fitColumns: true,
        fit: true,
        ctrlSelect: true,
        singleSelect: false,
        rownumbers: true,
        idField: 'iconId',
        url: "StarEnterpriseLoGo/StarEnterpriseLoGoLists",
        pagination:true,
        pagePosition:'bottom',
        pageNumber:1,
        pageSize:20,
        pageList:[10,20,30],
        columns:[[
            {field:'ck',checkbox:true},
            {field:'iconId',title:'序号',align:'center',width:100,sortable:'true'},
            {field:'pictureUrl',title:'logo',align:'center',width:100,sortable:'true',formatter:showImage1},
        ]],
        onDblClickRow: function(row){

        },
        onRowContextMenu: function(e,index,data){
            e.preventDefault();//阻止浏览器捕获右键事件
        }
    });

    //显示图片1
    function showImage1(value,row,index){
        var html='<div style="padding:10px">';
        if (row.pictureUrl!='' || row.pictureUrl!=null){
            html+='< img src="TP/'+row.pictureUrl+'" style="width:60px; height:50px">';
        } else {
            html+='< img src="TP/default_category.png" style="width:60px; height:50px">';
        }
        html+='</div>';
        return html;
    }



</script>