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
<table id="AuthManagement"></table> 
<script>
$.Admin.AuthManagement = {
    //组件ID
    'id' : '#AuthManagement',
    //工具栏
    'tools' : [
        { text: '添加', iconCls: 'fa fa-plus', handler: function(){
                $.Admin.AuthManagement.AddRole();
            } 
        },
        { text: '编辑', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.AuthManagement.EditRole();
            } 
        },
        { text: '删除', iconCls: 'fa fa-remove', handler: function(){
            	$.Admin.AuthManagement.DelRole();
            } 
        },
    ],

    //添加角色
    'AddRole' : function(){
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '新增职位类型',
            iconCls: 'fa fa-plus',
            href: "AuthManagement/getTanAuth",
            modal: true,
            closed: false,
            width:400,
          //  height:200,
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

  //编辑角色
    'EditRole' : function(){
        var get_select_row = $($.Admin.AuthManagement.id).treegrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {permission_grouping_id: get_select_row.permission_grouping_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '编辑职位类型',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "AuthManagement/getEditMvAuth",
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
    }, 
    //删除角色
    'DelRole' : function(){
            var get_select_row = $($.Admin.AuthManagement.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
                return false;
            }
            var data = {permission_grouping_id: get_select_row.permission_grouping_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '删除职位类型',
            iconCls: 'fa fa-delete',
            href: "AuthManagement/delAuth",
            modal: true,
            width:400,
            queryParams:data,
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
    //函数格式化
    'formatter' : {
        'status' : function(value,row,index){
            if(parseInt(value)){
                return "<span class='fa fa-check text-primary'></span>";
            } else {
                return "<span class='fa fa-remove text-danger'></span>";
            }
        },
        'sort' : function(value,row,index){
            return '<span class="textbox" style="margin:5px 0px;"><input type="text" name="sort['+row.id+']" class="textbox-text sortbox-text" style="text-align:center;color:#000;padding-top: 4px; padding-bottom: 4px;width:30px;" value="'+value+'" /></span>';
        }
    }
}
 
$($.Admin.AuthManagement.id).datagrid({
	title: '当前位置：系统中心 > 用户设置 > 角色管理',
    border: false,
    toolbar: $.Admin.AuthManagement.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    animate: true,
    idField: 'permission_grouping_id',
    url: 'AuthManagement/getAuthManagement',
    /* pagination:true,
	pagePosition:'bottom',
	pageNumber:1, */
	/* pageSize:20,
	pageList:[10,20,30], */
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'permission_grouping_id',title:'',align:'center',width:100,sortable:'true',hidden:'true'},
	          {field:'permission_grouping_name',title:'权限分组名称',align:'center',width:100,sortable:'true'},
	          {field:'buffer',title:'菜单名称',align:'center',width:100,sortable:'true'},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
        $(this).datagrid("unselectAll"); //取消所有选中项
        $(this).datagrid("selectRow", index); //根据索引选中该行
        $('#AdminRole_User').menu('show',{
            left: e.pageX,
            top: e.pageY
        });
    }
});
 

</script>