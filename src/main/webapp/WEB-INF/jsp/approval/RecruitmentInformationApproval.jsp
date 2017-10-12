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
<table id="InformationApproval"></table>

	


<script>

$.Admin.InformationApproval = {
    //组件ID
    'id' : '#InformationApproval',
    //工具栏
    'tools' : [           
        { text: '查看', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.InformationApproval.CheckInfo();
            } 
        },
         { text: '<input id="bxw_search" type="text"></input>',
             handler: function(e){
             }
       },
       
       {  iconCls:'icon-search',
       	  handler: function(e){
           		$.Admin.InformationApproval.Bxw_Search();
       		} 
       },
       { text: '审核状态:&nbsp&nbsp&nbsp<select id="bxw_chooseStatus" class="easyui-combobox" name="bxw_approval_status" style="width:100px; height:auto" data-options="required:true,editable:false">'+" "
   		+'<option value="全部">全部</option><option value="待审核">待审核</option><option value="已驳回">已驳回</option><option value="已通过">已通过</option></select>',	
   },
    ],
    
  //搜索
	 'Bxw_Search' : function(){
		var search_content=$('#bxw_search').val();
		var onch=$("#bxw_chooseStatus").val();
        var bxw_searchInfo={};
        bxw_searchInfo.bxw_search_content=search_content;
        bxw_searchInfo.bxw_approval_status=onch;
      $.ajax({
   	  type:'POST',
   	  data: bxw_searchInfo,
   	  dataType:'json',
   	  url:"approval/getinfoList",
   	  success: function(bxw_return_list){
   		$('#InformationApproval').datagrid('loadData', bxw_return_list);
   	  }
      }); 
	},
    
     
    
    //信息审核
    'CheckInfo' : function(){
        var get_select_row = $($.Admin.InformationApproval.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {recruiting_id: get_select_row.recruiting_id,releases_user_id:get_select_row.releases_user_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '审核信息',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "approval/CheckInformation",
            modal: true,
            width: 600,
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
$($.Admin.InformationApproval.id).datagrid({
	title: '当前位置：业务管理 > 审核管理 > 招聘信息审批',
    border: false,
    toolbar: $.Admin.InformationApproval.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'recruiting_id',
    url: "approval/getinfoList",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100,100,100,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'merchants_name',title:'发布用户',align:'center',sortable:'true'},
	          {field:'apply_time',title:'申请时间 ',width:100,sortable:'true'},
	          {field:'post_name',title:'岗位名称',align:'center',width:100,sortable:'true'},
	          {field:'work_date',title:'工作日期',align:'center',width:100,sortable:'true'},
	          {field:'work_time',title:'工作时间',align:'center',width:100,sortable:'true'},
	          {field:'work_location',title:'工作地点',align:'center',width:100,sortable:'true'},
	          {field:'settlement_method',title:'结算方式',align:'center',width:100,sortable:'true'},
	          {field:'recruitment',title:'招聘人数',align:'center',width:100,sortable:'true'},
	          {field:'audit_status',title:'审核状态',align:'center',width:100,sortable:'true'},
	          {field:'employees_name',title:'审核人',align:'center',width:100,sortable:'true'},
	          {field:'status_time',title:'审核时间',align:'center',width:100,sortable:'true'}
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

$('#bxw_chooseStatus').combobox({    
    panelHeight:"auto",
    editable:false,
    onChange:function(){
    	 var onch=$('#bxw_chooseStatus').val();
         var bxw_statusInfo={};
         bxw_statusInfo.bxw_approval_status=onch;
    	 $.ajax({
             type: "POST",
             url: "approval/getinfoList",
             data: bxw_statusInfo,
             dataType: "json",
             success: function(data){
                 		$('#InformationApproval').datagrid('loadData', data);
                      }
         });
    	
    },
}); 

$('#bxw_search').textbox().textbox({ icons: [{ 
	iconCls: 'icon-clear',
	handler: function (e) { 
		$(e.data.target).textbox('clear');
		$.Admin.InformationApproval.Bxw_Search();
		} 
}] });    


 
</script>