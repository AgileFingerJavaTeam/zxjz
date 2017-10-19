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
<table id="rechargePage"></table>
<script>

$.Admin.rechargePage = {
    //组件ID
    'id' : '#rechargePage',
    //工具栏
    'tools' : [  
		{ text: '新增', iconCls: 'fa fa-edit', handler: function(){
		    $.Admin.rechargePage.addCharge();
		} 
		},              
        { text: '查看', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.rechargePage.checkCharge();
            } 
        },
         { text: '<input id="bxw_searchrecharge" type="text"></input>',
             handler: function(e){
             }
       },
       
       {  iconCls:'icon-search',
       	  handler: function(e){
           		$.Admin.rechargePage.Bxw_SearchRecharge();
       		} 
       }, 
    ],
    
  //搜索
	 'Bxw_SearchRecharge' : function(){
		var search_content=$('#bxw_searchrecharge').val();
        var bxw_searchInfo={};
        bxw_searchInfo.bxw_search_content=search_content;
      $.ajax({
   	  type:'POST',
   	  data: bxw_searchInfo,
   	  dataType:'json',
   	  url:"Recharge/getRechargeList",
   	  success: function(bxw_return_list){
   		$('#rechargePage').datagrid('loadData', bxw_return_list);
   	  }
      }); 
	},
    
	
	  //新增充值
    'addCharge' : function(){

        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '新增充值',
            iconCls: 'fa fa-add',
            href: "Recharge/addCharge",
            modal: true,
            width: 650,
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
     
    
    //查看充值
    'checkCharge' : function(){
        var get_select_row = $($.Admin.rechargePage.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {user_id: get_select_row.userId,recharge_sequence_number:get_select_row.rechargeSequenceNumber};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '详情',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "Recharge/findRechargePage",
            modal: true,
            width: 650,
            onClose : function(){
                $(this).dialog("destroy");
            },
            onOpen : function(){
                var top = $(this).offset().top-$(this).position().top;
                $(this).dialog('resize',{
                    top: (top/6)+'px'
                });
            }
        });
    }
}
$($.Admin.rechargePage.id).datagrid({
	title: '当前位置：业务管理 > 商户财务管理 > 商户充值管理',
    border: false,
    toolbar: $.Admin.rechargePage.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'recruiting_id',
    url: "Recharge/getRechargeList",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'merchantsName',title:'商户名称',align:'center',width:100,sortable:'true'},
	          {field:'rechargeTime',title:'充值时间',align:'center',width:70,sortable:'true'},
	          {field:'rechargeModeName',title:'充值方式',align:'center',width:70,sortable:'true'},
	          {field:'amountOfRecharge',title:'充值金额',align:'center',width:70,sortable:'true'}
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

 $('#bxw_searchrecharge').textbox().textbox({ icons: [{ 
	iconCls: 'icon-clear',
	handler: function (e) { 
		$(e.data.target).textbox('clear');
		$.Admin.rechargePage.Bxw_SearchRecharge();
		} 
}] }) ;


</script>