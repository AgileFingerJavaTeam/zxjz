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
<table id="MerchantApproval"></table>
     
<script>
$.Admin.MerchantApproval = {
    //组件ID
    'id' : '#MerchantApproval',
    //工具栏
    'tools' : [    
        { text: '查看&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',
        	iconCls: 'fa fa-video-camera',
        	handler: function(){
                $.Admin.MerchantApproval.Approval();
            } 
        },
        { text: '审核状态:&nbsp&nbsp&nbsp<select id="hzn_chooseStatus" class="easyui-combobox" name="hzn_approval_status" style="width:100px; height:auto" data-options="required:true,editable:false">'+" "
        		+'<option value="">全部</option><option value="审核通过">审核通过</option><option value="审核驳回">审核驳回</option><option value="等待审核">等待审核</option></select>',	
        },
        { text: '&nbsp&nbsp&nbsp&nbsp<input id="hzn_search" type="text"></input>',
       	},
       {  iconCls:'icon-search',
       	  handler: function(){
           		$.Admin.MerchantApproval.Hzn_Search();
       		} 
       },
    ],
	//搜索
	'Hzn_Search' : function(){
		var search_content=$('#hzn_search').val();
		var onch=$('#hzn_chooseStatus').val();
        var hzn_searchInfo={};
        hzn_searchInfo.hzn_search_content=search_content;
        hzn_searchInfo.hzn_approval_status=onch;
      $.ajax({
   	  type:'POST',
   	  data: hzn_searchInfo,
   	  dataType:'json',
   	  url:"MerchantApproval/merchantAccount",
   	  success: function(hzn_return_list){
   		$('#MerchantApproval').datagrid('loadData', hzn_return_list);
   	  }
      }); 
	},
    //审核
    'Approval' : function(){
        var get_select_row = $($.Admin.MerchantApproval.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要审核的数据行','error');
            return false;
        }
        var data = {id: get_select_row.approvalId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '审核企业信息',
            iconCls: 'fa fa-video-camera',
            queryParams:data,
            href: "MerchantApproval/approvalMerchantAccount",
            modal: true,
            width:800,
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
    },
}


$($.Admin.MerchantApproval.id).datagrid({
	title: '当前位置：业务管理 > 审核管理 > 商家认证审核',
    border: false,
    toolbar: $.Admin.MerchantApproval.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'approvalId',
    url: "MerchantApproval/merchantAccount",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'companyName',title:'商户名称',align:'center',width:100,sortable:'true'},
	          {field:'applyTime',title:'申请时间',align:'center',width:100,sortable:'true'},
	          {field:'text',title:'所属行业',align:'center',width:100,sortable:'true'},
	          {field:'head',title:'负责人',align:'center',width:100,sortable:'true'},
	          {field:'phone',title:'电话',align:'center',width:100,sortable:'true'},
	          {field:'status',title:'审核状态',align:'center',width:100,sortable:'true'},	          
	          {field:'auditTime',title:'审核时间',align:'center',width:100,sortable:'true'},
	          {field:'employeesName',title:'审核员工',align:'center',width:100,sortable:'true'},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});
	
	$("#hzn_chooseStatus").combobox({
		panelHeight:'auto',
		onChange: function () {
             var onch=$('#hzn_chooseStatus').val();
             var hzn_statusInfo={};
             hzn_statusInfo.hzn_approval_status=onch;
           $.ajax({
        	  type:'POST',
        	  data: hzn_statusInfo,
        	  dataType:'json',
        	  url:"MerchantApproval/merchantAccount",
        	  success: function(hzn_return_list){
        		$('#MerchantApproval').datagrid('loadData', hzn_return_list);
        	  }
           });  
       
		}
	});
	
	//搜索框
	  /*  $.extend($.fn.textbox.methods, {
            addClearBtn: function (jq, iconCls) {

                var opts = jq.textbox('options');
                opts.icons = opts.icons || [];

                opts.icons.unshift({
                    iconCls: iconCls,
                    handler: function (e) {
                        $(e.data.target).textbox('clear').textbox('textbox').focus();
                        $(this).css('visibility', 'hidden');
                    }
                });
                return jq.each(function () {
                    var t = $(this);
                    t.textbox();
                    if (!t.textbox('getText')) {
                        t.textbox('getIcon', 0).css('visibility', 'hidden');
                    }
                    t.textbox('textbox').bind('keyup', function () {
                        var icon = t.textbox('getIcon', 0);
                        if ($(this).val()) {
                            icon.css('visibility', 'visible');
                        } else {
                            icon.css('visibility', 'hidden');
                        }
                    });
                });
            }
        }); */  
		
		    $('#hzn_search').textbox().textbox({ icons: [{ 
			iconCls: 'icon-clear',
			handler: function (e) { 
				$(e.data.target).textbox('clear');
				$.Admin.MerchantApproval.Hzn_Search();
				} 
		}] });    
		 
			/* $('#hzn_search').textbox().textbox('addClearBtn', 'icon-clear'); */ 
		
		
</script>