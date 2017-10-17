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
<table id="AT-Service"></table>
<script>
$.Admin.ATService = {
    //组件ID
    'id' : '#AT-Service',
    //工具栏
    'tools' : [     
        { text: '添加', iconCls: 'fa fa-plus', handler: function(){
            $.Admin.ATService.Add();
            } 
        },
        { text: '查看', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.ATService.Find();
        } 
   		 },
        { 
          text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="attr" style="width:200px">', 
        },
        {
          iconCls:'icon-search',
          handler:function(){ 
          $.Admin.ATService.search();
        }
        },
    ], 
    //查看
    'Find' : function(){
    	 var get_select_row = $($.Admin.ATService.id).datagrid('getSelected');
         if(get_select_row == null){
             $.Admin.tips('温馨提示信息', '请先选择 您要查看的数据行','error');
             return false;
         }
         var data = {id: get_select_row.user_id, ob:get_select_row.withdrawal_serial_number,uid:get_select_row.employees_id};
         var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '查看单据',
            queryParams: data,
            iconCls: 'fa fa-plus',
            href: "Settlement/find",
            modal: true,
            width:900,
            height:300,
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
    //添加
    'Add' : function(){
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '添加单据',
            iconCls: 'fa fa-plus',
            href: "Settlement/add",
            modal: true,
            width:700,
            height:330,
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
    //模糊查询
    'search' :function(){
    	var a=$('#attr').val();
    	var search={};
    	search.search=a;
          $.ajax({
        	  type:'post',
              title: '模糊查询',
              data:search,
              iconCls:'icon-search',
              url: "Settlement/search",
              datatype:'json',
              success:function(search_list){
            	  $('#AT-Service').datagrid('loadData', search_list);
              }
              
          });
    },
  
}

$($.Admin.ATService.id).datagrid({
	title: '当前位置：业务管理 > 商户财务管理> 结算服务费',
    border: false,
    toolbar: $.Admin.ATService.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'user_id',
    url: "Settlement/SettlementJspList",
    pagination:true,
	pagePosition:'bottom',
	remoteSort:false,
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'merchants_name',title:'商户名称',align:'center',width:100,sortable:true,},
	          {field:'settlement_time',title:'收费时间',align:'center',width:100,sortable:true,},
	          {field:'clearing_fee_name',title:'费用分类',align:'center',width:100,sortable:true,},
	          {field:'settlement_amount',title:'收费金额',align:'center',width:100,sortable:true,},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});  
$('#attr').textbox({ icons: [{ 
	 iconCls: 'icon-clear', 
	 handler: function (e) { 
		 $(e.data.target).textbox('clear');
		 $.Admin.ATService.search();
		 } }] })
</script>