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
<table id="VIPMerchantAdmin"></table>
<script>
$.Admin.VIPMerchantAdmin = {
    //组件ID
    'id' : '#VIPMerchantAdmin',
    //工具栏
    'tools' : [    
		{ text: '添加', iconCls: 'fa fa-plus', handler: function(){
		    $.Admin.VIPMerchantAdmin.AddVIPMer();
			} 
		},
		{ text: '编辑', iconCls: 'fa fa-edit', handler: function(){
		    $.Admin.VIPMerchantAdmin.EditVIPMer();
			} 
		},
		{ text: '删除', iconCls: 'fa fa-edit', handler: function(){
		    $.Admin.VIPMerchantAdmin.DeleteVIPMer();
			} 
		},
		{ text: '&nbsp&nbsp&nbsp&nbsp<input id="hzn_VIPSearch" type="text"></input>',
       	},
       {  iconCls:'icon-search',
       	  handler: function(){
           		$.Admin.VIPMerchantAdmin.Hzn_VIPSearch();
       		} 
       },
    ],
  //搜索
	'Hzn_VIPSearch' : function(){
		var search_content=$('#hzn_VIPSearch').val();
        var hzn_searchInfo={};
        hzn_searchInfo.hzn_vipMersearch_content=search_content;
      $.ajax({
   	  type:'POST',
   	  data: hzn_searchInfo,
   	  dataType:'json',
   	  url:"VIPMerAccount/VIPMerAccount",
   	  success: function(hzn_return_list){
   		$('#VIPMerchantAdmin').datagrid('loadData', hzn_return_list);
   	  }
      }); 
	},
    //添加VIP账号
    'AddVIPMer' : function(){
        var addVipMer_account_id = $.Admin.random_dialog();
        $(addVipMer_account_id).dialog({
            title: '添加VIP账号',
            iconCls: 'fa fa-plus',
            href: "VIPMerAccount/addVIPMerPage",
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

    //编辑VIP账号
    'EditVIPMer' : function(){
        var get_select_row = $($.Admin.VIPMerchantAdmin.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {id: get_select_row.user_id};    //此处的id 与mapper里找的id 一致
        var editVipMer_account_id = $.Admin.random_dialog();
        $(editVipMer_account_id).dialog({
            title: '编辑VIP账号',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "VIPMerAccount/editVIPMerchantPage",
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
  //删除VIP账号
    'DeleteVIPMer' : function(){
        var get_select_row = $($.Admin.VIPMerchantAdmin.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
            return false;
        }
        var data = {id: get_select_row.user_id};     //此处的id 与mapper里找的id 一致
        var deleteVipMer_account_id = $.Admin.random_dialog();
        $(deleteVipMer_account_id).dialog({
            title: '删除VIP账号',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "VIPMerAccount/showDelVIPMerchant",
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

$($.Admin.VIPMerchantAdmin.id).datagrid({
	title: '当前位置：业务管理 > 审核管理 > VIP商户账号管理',
    border: false,
    toolbar: $.Admin.VIPMerchantAdmin.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'user_id',
    url: "VIPMerAccount/VIPMerAccount",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'merchants_name',title:'商户名称',align:'center',width:100,sortable:'true'},
	          {field:'industry_name',title:'所属行业',align:'center',width:100,sortable:'true'},
	          {field:'head',title:'负责人',align:'center',width:100,sortable:'true'},
	          {field:'phone',title:'电话',align:'center',width:100,sortable:'true'},
	          {field:'vip_start',title:'VIP起始日期',align:'center',width:100,sortable:'true'},
	          {field:'vip_end',title:'VIP截止日期',align:'center',width:100,sortable:'true'},
	          {field:'merchants_state',title:'商户状态',align:'center',width:100,sortable:'true'}
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});
		$('#hzn_VIPSearch').textbox().textbox({ icons: [{ 
			iconCls: 'icon-clear',
			handler: function (e) { 
				$(e.data.target).textbox('clear');
				$.Admin.VIPMerchantAdmin.Hzn_VIPSearch();
				} 
		}] });
</script>