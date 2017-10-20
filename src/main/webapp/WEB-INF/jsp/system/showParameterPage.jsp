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
<table id="SystemParameter"></table>
<script>
$.Admin.SystemParameter = {
    //组件ID
    'id' : '#SystemParameter',
    //工具栏
    'tools' : [    
        { text: '新增', iconCls: 'fa fa-plus', handler: function(){
                $.Admin.SystemParameter.AddSP();
            } 
        },
        { text: '修改', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.SystemParameter.EditSP();
            } 
        },
        { text: '删除', iconCls: 'fa fa-remove', handler: function(){
            $.Admin.SystemParameter.DelSP();
            } 
        },
        //-------搜索-------//
        { text: '&nbsp&nbsp&nbsp&nbsp<input id="srt_search" type="text"></input>',	
             handler: function(e){
             }
       },
        {  iconCls:'icon-search',
       	   handler: function(){
           		$.Admin.SystemParameter.Srt_Search();
       		} 
        },
    ],
  //搜索
	'Srt_Search' : function(){
		var search_content=$('#srt_search').val();
        var srt_searchInfo={};
        var page=1;
        var rows=20;
        srt_searchInfo.page=page;
        srt_searchInfo.rows=rows;
        srt_searchInfo.srt_search_content=search_content;
      $.ajax({
   	  type:'POST',
   	  data: srt_searchInfo,
   	  dataType:'json',
   	  url:"System/parameter",
   	  success: function(srt_return_list){
   		$('#SystemParameter').datagrid('loadData', srt_return_list);
   	  }
      }); 
	},
    //新增系统参数
    'AddSP' : function(){
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '新增系统参数',
            iconCls: 'fa fa-plus',
            href: "System/addPS",
            modal: true,
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

//---------------------------------

    //修改系统参数
    'EditSP' : function(){
        var get_select_row = $($.Admin.SystemParameter.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {id:get_select_row.parameterId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '修改系统参数',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "System/editPS",
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
    'DelSP' : function(){
		var get_select_row = $($.Admin.SystemParameter.id).datagrid('getSelected');
		if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
                return false;
		}
        var data = {id:get_select_row.parameterId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '删除系统参数',
            iconCls: 'fa fa-delete',
            href: "System/delPS",
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


},

$($.Admin.SystemParameter.id).datagrid({
	title: '当前位置：系统中心 > 系统设置 > 系统参数管理',
    border: false,
    toolbar: $.Admin.SystemParameter.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'parameterId',
    url: "System/parameter",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},
              {field:'parameterId',title:'ID',align:'center',width:80},
	          {field:'serialNumber',title:'参数编号',align:'center',width:80,sortable:true,
	        	  sorter:function(a,b){
	        		  return(a>b?1:-1);
	        	  }},
	          {field:'parameterName',title:'参数名称',align:'center',width:80,sortable:true,},
	          {field:'parameter',title:'参数值',align:'center',width:80},
	          {field:'parameterDescription',title:'参数说明',align:'center',width:80},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

$('#ss').searchbox({ 
	searcher:function(value,name){ 
	alert(value + "," + name); 
	}, 
	menu:'#mm', 
	prompt:'请输入值' 
	}); 
	//-------取消搜索插件------//
$('#srt_search').textbox().textbox({ icons: [{ 
	iconCls: 'icon-clear',
	handler: function (e) { 
		$(e.data.target).textbox('clear');
		$.Admin.SystemParameter.Srt_Search();
		} 
}] })
//----------排序------------------//

</script>