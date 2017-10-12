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
<table id="authority"></table>
<script>

$.Admin.authority = {
    //组件ID
    'id' : '#authority',
    //工具栏
    'tools' : [           
        { text: '新增', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.authority.AddInfo();
            } 
        },
        { text: '修改', iconCls: 'fa fa-edit', handler: function(){
            	$.Admin.authority.CheckInfo();
        	} 
    	},
    	{ text: '删除', iconCls: 'fa fa-edit', handler: function(){
    			$.Admin.authority.DeleteInfo();
	    	} 
		},
    ],  
    
    //新增信息
    'AddInfo' : function(){

        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '新增信息',
            iconCls: 'fa fa-add',
            href: "authority/addinfo",
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
    
    
    
    
    
    
    
    //修改信息
    'CheckInfo' : function(){
        var get_select_row = $($.Admin.authority.id).datagrid('getSelected');
  
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {employees_id: get_select_row.employees_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '修改信息',
            iconCls: 'fa fa-edit',
            queryParams:data,
            href: "authority/editinfo",
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
    
    
    
    //删除信息
    'DeleteInfo' : function(){
        var get_select_row = $($.Admin.authority.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
            return false;
        }
        var data = {employees_id: get_select_row.employees_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '删除信息',
            iconCls: 'fa fa-delete',
            queryParams:data,
            href: "authority/deleteinfo",
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
    }
    
    
}
$($.Admin.authority.id).datagrid({
	title: '当前位置：系统中心 >用户设置>用户管理',
    border: false,
    toolbar: $.Admin.authority.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'employees_id',
    url: "authority/getauthority",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30],
	columns:[[
	          {field:'ck',checkbox:true},    	         
	          {field:'employees_num',title:'员工编号',align:'center',width:100,sortable:'true'},
	          {field:'employees_name',title:'员工姓名',align:'center',width:100,sortable:'true'},
	          {field:'permission_grouping_name',title:'权限分组',align:'center',width:100,sortable:'true'}
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});


 
</script>