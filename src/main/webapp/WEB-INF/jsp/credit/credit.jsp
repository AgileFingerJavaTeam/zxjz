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
<table id="creditPayment"></table>
<script>
$.Admin.creditPayment = {
    //组件ID
    'id' : '#creditPayment',
    //工具栏
    'tools' : [    

		{ text: '授信', iconCls: 'fa fa-edit', handler: function(){
		    $.Admin.creditPayment.editcredit();
			} 
		},
		{ text: '账期', iconCls: 'fa fa-edit', handler: function(){
		    $.Admin.creditPayment.payment();
			} 
		},
		{ text: '<input id="bxw_searchcredit" type="text"></input>',
            handler: function(e){
            }
      },
       {  iconCls:'icon-search',
       	  handler: function(){
           		$.Admin.creditPayment.Bxw_SearchCredit();
       		} 
       },
    ],
    
    
    
    //搜索
  	 'Bxw_SearchCredit' : function(){
  		var search_content=$('#bxw_searchcredit').val();
          var bxw_searchInfo={};
          bxw_searchInfo.bxw_search_content=search_content;
        $.ajax({
     	  type:'POST',
     	  data: bxw_searchInfo,
     	  dataType:'json',
     	  url:"money/getcreditList",
     	  success: function(bxw_return_list){
     		$('#creditPayment').datagrid('loadData', bxw_return_list);
     	  }
        }); 
  	},
    
    
 	
    //授信总额
    'editcredit' : function(){
        var get_select_row = $($.Admin.creditPayment.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {user_id: get_select_row.user_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '授信总额',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "money/editcredit",
            modal: true,
            width: 300,
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
    },
    
    
    
//账期
'payment' : function(){
    var get_select_row = $($.Admin.creditPayment.id).datagrid('getSelected');
    if(get_select_row == null){
        $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
        return false;
    }
    var data = {user_id: get_select_row.user_id};
    var id = $.Admin.random_dialog();
    $(id).dialog({
        title: '账期',
        iconCls: 'fa fa-edit',
        queryParams: data,
        href: "money/payment",
        modal: true,
        width: 300,
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
  
},

$($.Admin.creditPayment.id).datagrid({
	title: '当前位置：业务管理 > 审核管理 > 授信与账期设置',
    border: false,
    toolbar: $.Admin.creditPayment.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'user_id',
    url: "money/getcreditList",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,50,50,50,50,50],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'merchants_name',title:'商户名称',align:'center',width:100,sortable:'true'},
	          {field:'text',title:'所属行业',align:'center',width:100,sortable:'true'},
	          {field:'head',title:'负责人',align:'center',width:100,sortable:'true'},
	          {field:'phone',title:'电话',align:'center',width:100,sortable:'true'},
	          {field:'account_balance',title:'账户余额',align:'center',width:100,sortable:'true'},
	          {field:'credit_total',title:'授信总额',align:'center',width:100,sortable:'true'},
	          {field:'credit_balance',title:'授信余额',align:'center',width:100,sortable:'true'},
	          {field:'debt',title:'欠款金额',align:'center',width:100,sortable:'true'},
	          {field:'payment_days',title:'账期',align:'center',width:100,sortable:'true'}
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

$('#bxw_searchcredit').textbox().textbox({ icons: [{ 
	iconCls: 'icon-clear',
	handler: function (e) { 
		$(e.data.target).textbox('clear');
		$.Admin.creditPayment.Bxw_SearchCredit();
		} 
}] }); 


</script>