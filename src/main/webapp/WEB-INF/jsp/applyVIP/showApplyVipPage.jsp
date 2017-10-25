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
<table id="ApplyVIP"></table>
<script>
$.Admin.ApplyVIP = {
    //组件ID
    'id' : '#ApplyVIP',
    //工具栏
    'tools' : [  
               

        
        //--------搜索----------//
        { text: '&nbsp&nbsp&nbsp&nbsp<input id="srt_search1" type="text"></input>',
        	 iconCls:'icon-clear',
             handler: function(e){
            	 
             }
       },
       //--------------搜索图标---------------//
       {  iconCls:'icon-search',
       	  handler: function(){
           		$.Admin.ApplyVIP.Srt_search1();
       		} 
       },
     //--------------审核---------------------//
       { text: '审核状态:&nbsp&nbsp&nbsp<select id="srt_chooseStatus1" class="easyui-combobox" name="srt_approval_status1" style="width:100px;" data-options="required:true,editable:false">'+" "
   		+'<option value="">全部</option><option value="已经受理">已经受理</option><option value="尚未受理">尚未受理</option></select>',
       },
       //----------------受理-------------------//
       { text: '受理', iconCls: 'fa fa-check', handler: function(){
           $.Admin.ApplyVIP.AcceptApply();
           } 
       },
    ],
  //搜索
	'Srt_search1' : function(){
		var search_content=$('#srt_search1').val();
		var onch=$('#srt_chooseStatus1').val();
        var srt_searchInfo1={};
        var page=1;
        var rows=20;
        srt_searchInfo1.page=page;
        srt_searchInfo1.rows=rows;
        srt_searchInfo1.srt_search_content1=search_content;
        srt_searchInfo1.srt_approval_status1=onch;
      $.ajax({
   	  type:'POST',
   	  data: srt_searchInfo1,
   	  dataType:'json',
   	  url:"employer/GetApplyVipInfo",
   	  success: function(srt_return_list){
   		$('#ApplyVIP').datagrid('loadData', srt_return_list);
   	  }
      }); 
	},
   
    //受理商户升级VIP申请
    'AcceptApply' : function(){
        var get_select_row = $($.Admin.ApplyVIP.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {id:get_select_row.userId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '审核商家',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "employer/showCheckPage",
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
$($.Admin.ApplyVIP.id).datagrid({
	title: '当前位置：系统中心 > 系统设置 > 系统参数管理',
    border: false,
    toolbar: $.Admin.ApplyVIP.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'uid',
    url: "employer/GetApplyVipInfo",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
//	          {field:'ck',checkbox:true},
	       //   {field:'userId',title:'商户ID',align:'center',width:80,},
	          {field:'merchantsName',title:'商户名称',align:'center',width:80,},
	          {field:'applyTime',title:'申请时间',align:'center',width:80,},
	          {field:'isDispose',title:'是否已受理',align:'center',width:80},
	          {field:'acceptEmployees',title:'受理员工',align:'center',width:80},
	          {field:'operatingStaff',title:'操作员工',align:'center',width:80},
	          {field:'operatingTime',title:'操作时间',align:'center',width:80},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

	//----------筛选框------------//
	$("#srt_chooseStatus1").combobox({
		onChange: function () {
             var onch=$('#srt_chooseStatus1').val();
             var srt_statusInfo={};
             var page=1;
             var rows=20;
             srt_statusInfo.page=page;
            srt_statusInfo.rows=rows;
             srt_statusInfo.srt_approval_status1=onch;
           $.ajax({
        	  type:'POST',
        	  data: srt_statusInfo,
        	  dataType:'json',
        	  url:"employer/GetApplyVipInfo",
        	  success: function(srt_return_list){
        		$('#ApplyVIP').datagrid('loadData', srt_return_list);
        	  }
           });  
       
		}
	});
	//-----取消搜索插件----------//
	  $('#srt_search1').textbox().textbox({ icons: [{ 
			iconCls: 'icon-clear',
			handler: function (e) { 
				$(e.data.target).textbox('clear');
				$.Admin.ApplyVIP.Srt_search1();
				} 
		}] })    
		
</script>