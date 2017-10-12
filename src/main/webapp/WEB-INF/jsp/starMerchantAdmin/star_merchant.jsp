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
<table id="hzn_star_merchant"></table>
<script>
$.Admin.hznStarMerchant = {
    //组件ID
    'id' : '#hzn_star_merchant',
    //工具栏
    'tools' : [     
        { text: '是否成为明星雇主', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.hznStarMerchant.UpOrDown();
            } 
        }, 
        /* { text: '详情', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.hznStarMerchant.showSecurity();
            }
        }, */
        { 
          text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="hzn_star_merchant_search" style="width:200px">', 
        },
        {
          iconCls:'icon-search',
          handler:function(){ 
          $.Admin.hznStarMerchant.search();
        }
        },
        /* {
          text:'状态筛选:<select style="width:70px;" id="hznStarMerchantStatusSearch"><option value="">全部</option><option value="上架">上架</option><option value="下架">下架</option></select></div>',
        
          }, */
    ], 
    //模糊查询
    'search' :function(){
    	var a=$('#hzn_star_merchant_search').val();
    	var search={};
    	search.search=a;
          $.ajax({
        	  type:'post',
              title: '模糊查询',
              data:search,
              iconCls:'icon-search',
              url: "StarMerchant/starMerchantList",
              datatype:'json',
              success:function(search_list){
            	  $('#hzn_star_merchant').datagrid('loadData', search_list);
              }
              
          });
    },
  
    //是否成为明星雇主
    'UpOrDown' : function(){
        var get_select_row = $($.Admin.hznStarMerchant.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要更改的数据行','error');
            return false;
        }
        var data = {id: get_select_row.user_id};     //此处的id 与mapper里找的id 一致
        var account_id = $.Admin.random_dialog();
        $(account_id).dialog({
            title: '是否改变明星雇主状态',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "StarMerchant/changeStarStatusPage",
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
    //企业详情
    /* 'showSecurity' : function(){
        var get_select_row = $($.Admin.hznStarMerchant.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要查看的数据行','error');
            return false;
        }
        var data = {id: get_select_row.user_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '企业详情',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "StarMerchant/starMerchantList",
            modal: true,
            width: 900,
            height:500,
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
    } */
}

$($.Admin.hznStarMerchant.id).datagrid({
	title: '当前位置：业务管理 > 担保职位管理> 是否明星雇主',
    border: false,
    toolbar: $.Admin.hznStarMerchant.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'user_id',
    url: "StarMerchant/starMerchantList",
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
	          {field:'is_star',title:'是否明星雇主',align:'center',width:100,sortable:'true'},
	          
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});  

     $('#hzn_star_merchant_search').textbox({ icons: [{ 
    	 iconCls: 'icon-clear', 
    	 handler: function (e) { 
    		 $(e.data.target).textbox('clear');
    		 $.Admin.hznStarMerchant.search();
    		 } }] });
    		 
   /*  $('#hznStarMerchantStatusSearch').on('change',function(){
     	var a=$('#hznStarMerchantStatusSearch').val();
    	var StatusSearch={};
    	StatusSearch.StatusSearch=a;
          $.ajax({
        	  type:'post',
              title: '状态筛选',
              data:StatusSearch,
              url: "StarMerchant/starMerchantList",
              datatype:'json',
              success:function(search_list){
            	  $('#hzn_star_merchant').datagrid('loadData', search_list);
              }
    })
    }); */
  
</script>