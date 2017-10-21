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
<table id="Bill"></table>
<script>
$.Admin.Bill = {
    //组件ID
    'id' : '#Bill',
    //工具栏
    'tools' : [    
        { text: '查看详情', iconCls: 'fa fa-video-camera', handler: function(){
            $.Admin.Bill.CheckBill();
            } 
        },
        //-------搜索-------//
        { text: '请选择商户<input id="srt_searchbox" name="merchants_name" type="text"></input>'
       },
    ],
    //查看详细账单
    'CheckBill' : function(){
            var get_select_row = $($.Admin.Bill.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要查看的数据行','error');
                return false;
            }
        var data = {user_id: get_select_row.userId,reference_bill_classification: get_select_row.referenceBillClassification,references_the_internal_serial_number1: get_select_row.referencesTheInternalSerialNumber1,merchants_name: get_select_row.merchantsName,work_id: get_select_row.workId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '查看账单',
            iconCls: 'fa fa-delete',
            href:"CheckBill/showBillDetails",
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

$($.Admin.Bill.id).datagrid({
	title: '当前位置：系统中心 > 系统设置 > 系统参数管理',
    border: false,
    toolbar: $.Admin.Bill.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'uid',
//    url: "CheckBill/findBills",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
//	          {field:'ck',checkbox:true},    
	          {field:'merchantsName',title:'商户名称',align:'center',width:'15%',sortable:true,},
	          {field:'currentAccountNumber',title:'序号',align:'center',width:'10%',sortable:true,},
	          {field:'accountingTime',title:'记账时间',align:'center',width:'20%',sortable:true,},
	          {field:'referenceBillClassification',title:'分类',align:'center',width:'15%',sortable:true,},
	          {field:'description',title:'说明',align:'center',width:'25%',sortable:true,},
	          {field:'amount',title:'金额',align:'center',width:'15%',sortable:true,},
//	          {field:'referencesTheInternalSerialNumber1',title:'票据ID',align:'center',width:'15%',sortable:true,},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

//---------xin  search--------//
$("#srt_searchbox").combogrid({    
		delay: 500,
	    mode: 'remote',
	    panelWidth:500,
	    fitColumns: true,
	    fit: true,   
	    url:"CheckBill/findMerName",    
	    idField: 'userId',
	    textField: 'merchantsName',
	    pagination:true,
		pagePosition:'bottom',
		pageNumber:1,
		pageSize:20,
		pageList:[10,20,30,50,100],
	    columns: [[    
	        {field:'merchantsName',title:'商户名称',halign:'center',align:'center',width:60},
	    ]],   
       onSelect:function(){selectMer()}
	  });
 
       function selectMer(){
    	   var merId = $('#srt_searchbox').val();
    	    $.ajax({
    		   	  type:'POST',
    		   	  data:{"merId":merId},
    		   	  dataType:'json',
    		   	  url:"CheckBill/findBills",     
    		   	  success: function(srt_return_list){
    		   		$('#Bill').datagrid('loadData', srt_return_list);
    		   	  } 
    		      }); 
       }
</script>