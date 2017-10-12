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
<table id="industry"></table>
<script>

$.Admin.industry = {
    //组件ID
    'id' : '#industry',
    //工具栏
    'tools' : [    
        { text: '新增', iconCls: 'fa fa-plus', handler: function(){
                $.Admin.industry.AddJB();
            } 
        },
        { text: '编辑', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.industry.EditJB();
            } 
        },
        { text: '删除', iconCls: 'fa fa-remove', handler: function(){
            	$.Admin.industry.DelJB();
        } 
    },

    ],
    
    
    
  //添加角色
    'AddJB' : function(){
        var value = $.Admin.random_dialog();
        $(value).dialog({
            title: '添加行业分类',
            iconCls: 'fa fa-plus',
            href: "IndustryManage/addInfo",
            modal: true,
            width:400,
            onClose : function(){
                $(this).dialog("destroy");
            },
            onOpen : function(){
                var top = 
                	$(this).offset().top-$(this).position().top;
                $(this).dialog('resize',{
                    top: (top/2)+'px'
                });
            }
        });
    },    

    //编辑系统参数
    'EditJB' : function(){
        var get_select_row = $($.Admin.industry.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {value: get_select_row.value};    //此处的id 与mapper里找的id 一致
        var value = $.Admin.random_dialog();
        $(value).dialog({
            title: '编辑行业分类',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "IndustryManage/showeditInfo",
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
    //删除系统参数
    'DelJB' : function(){
            var get_select_row = $($.Admin.industry.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
                return false;
            }
            var data = {value: get_select_row.value};
        var value = $.Admin.random_dialog();
        $(value).dialog({
            title: '删除行业分类',
            iconCls: 'fa fa-delete',
            href: "IndustryManage/showDelInfo",
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
}

$($.Admin.industry.id).datagrid({
	title: '当前位置：基础管理 > 基础信息 > 行业分类管理',
    border: false,
    toolbar: $.Admin.industry.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'value',
    url: "IndustryManage/getIndustryList",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
		columns:[[
	          {field:'ck',checkbox:true},    
	//          {field:'value',title:'行业分类ID',align:'center'},
	          {field:'text',title:'行业分类名称',width:100},
	//          {field:'is_delete',title:'是否已删除',align:'center',width:100,formatter:is_delete},
	  	  ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

//是否删除
		function is_delete(value,row,index){
			switch(row.is_delete){
				case  0:
					return "是";
				case  1:
					return "否"; 
			 
				default:
					return "请选择是否删除"; 
			}
		} 
</script>

	<script type="text/javascript"> 
	function qq(value,name){ 
	alert(value+":"+name) 
	} 
	</script> 
	
	<input id="ss" class="easyui-searchbox" style="width:300px" 
	data-options="searcher:qq,prompt:'Please Input Value',menu:'#mm'"></input> 
	
	<div id="mm" style="width:120px"> 
	<div data-options="name:'all',iconCls:'icon-ok'">All News</div> 
	<div data-options="name:'sports'">Sports News</div> 
	</div>