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
<table id="studentWithdraw"></table>
<script>
$.Admin.studentWithdraw = {
    //组件ID
    'id' : '#studentWithdraw',
    //工具栏
    'tools' : [  

        //--------搜索----------//
        { text: '&nbsp&nbsp&nbsp&nbsp<input id="withdraw_search" type="text"></input>',
             handler: function(e){
             }
		},
       //-------搜索图标--------//
       {  iconCls:'icon-search',
       	  handler: function(){
           		$.Admin.studentWithdraw.withdraw_search();
       		} 
       },
       //------------筛选-------//
       { text: '审核状态:&nbsp&nbsp&nbsp<select id="manageStatus" class="easyui-combobox" name="selectStatus" style="width:100px;" data-options="required:true,editable:false">'+" "
   		+'<option value="">全部</option><option value="1">已经受理</option><option value="0">尚未受理</option></select>',
       },
       //------------受理-------//
       { text: '受理', iconCls: 'fa fa-search', handler: function(){
           $.Admin.studentWithdraw.AcceptWithdraw();
           } 
       },
    ],
  //搜索
	'withdraw_search' : function(){
		var search_content=$('#withdraw_search').val();
		var onch=$('#manageStatus').val();
        var srt_searchInfo1={};
        var page=1;
        var rows=20;
        srt_searchInfo1.page=page;
        srt_searchInfo1.rows=rows;
        srt_searchInfo1.withdraw_search=search_content;
        srt_searchInfo1.manageStatus=onch;
      $.ajax({
   	  type:'POST',
   	  data: srt_searchInfo1,
   	  dataType:'json',
   	  url:"StudentWithdraw/findStudentWithdrawList",
   	  success: function(srt_return_list){
   		$('#studentWithdraw').datagrid('loadData', srt_return_list);
   	  }
      }); 
	},
   
    //受理
    'AcceptWithdraw' : function(){
        var get_select_row = $($.Admin.studentWithdraw.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {user_id:get_select_row.userId,withdraw_num:get_select_row.withdrawNum};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '受理申请',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "StudentWithdraw/showAcceptStudentWithdrawPage",
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
},
$($.Admin.studentWithdraw.id).datagrid({
	title: '当前位置：系统中心 > 系统设置 > 系统参数管理',
    border: false,
    toolbar: $.Admin.studentWithdraw.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'uid',
    url: "StudentWithdraw/findStudentWithdrawList",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
//	          {field:'ck',checkbox:true},
	       //   {field:'userId',title:'学生ID',align:'center',width:80,},
	          {field:'name',title:'提现人',align:'center',width:80,},
	          {field:'withdrawNum',title:'提现流水号',align:'center',width:80,},
	          {field:'withdrawTime',title:'提现时间',align:'center',width:80},
	          {field:'withdrawMoney',title:'提现金额',align:'center',width:80},
	          {field:'alipayId',title:'支付宝账号',align:'center',width:80},
	          {field:'employeesName',title:'处理人员',align:'center',width:80},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

	//----------筛选框------------//
	$("#manageStatus").combobox({
		onChange: function () {
             var onch=$('#manageStatus').val();
             var srt_statusInfo={};
             var page=1;
             var rows=20;
             srt_statusInfo.page=page;
             srt_statusInfo.rows=rows;
             srt_statusInfo.selectStatus=onch;
           $.ajax({
        	  type:'POST',
        	  data: srt_statusInfo,
        	  dataType:'json',
        	  url:"StudentWithdraw/findStudentWithdrawList",
        	  success: function(srt_return_list){
        		$('#studentWithdraw').datagrid('loadData', srt_return_list);
        	  }
           });  
       
		}
	});
	//-----取消搜索插件----------//
	  $('#withdraw_search').textbox().textbox({ icons: [{
			iconCls: 'icon-clear',
			handler: function (e) { 
				$(e.data.target).textbox('clear');
				$.Admin.studentWithdraw.withdraw_search();
				} 
		}] })    
		
</script>