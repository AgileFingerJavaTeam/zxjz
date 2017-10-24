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
        { text: '读取', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.InformationApproval.UpdateStatus();
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

        { text: '开始时间:&nbsp&nbsp&nbsp<input id="start_time"  class="easyui-datebox" type="text"></input>',
            handler: function(e){
            }
        },
        { text: '结束时间:&nbsp&nbsp&nbsp<input id="end_time"  class="easyui-datebox" type="text"></input>',
            handler: function(e){
            }
        },
        { text: '查询', iconCls: 'fa fa-search', handler: function(){
            $.Admin.InformationApproval.Bxw_Search();
        }
        },
        { text: '清空', iconCls: 'fa fa-edit', handler: function(e){
           $('#start_time').datebox('clear');
            $('#end_time').datebox('clear');
            $.Admin.InformationApproval.Bxw_Search();
        }
        },

    ],

  //搜索
	 'Bxw_Search' : function(){
		var search_content=$('#bxw_search').val();
		var start=$('#start_time').val();
		var end=$('#end_time').val();
         if(start!=null||start!=''){
             if(end<start){
                 $.messager.show({
                     title:'消息',
                     msg:'请填写正确的结束日期'
                 })
                 return false;
             };
         };




        var bxw_searchInfo={};
        bxw_searchInfo.bxw_search_content=search_content;
        bxw_searchInfo.start=start;
        bxw_searchInfo.end=end;
      $.ajax({
   	  type:'POST',
   	  data: bxw_searchInfo,
   	  dataType:'json',
   	  url:"StuMsg/getStuMsg",
   	  success: function(bxw_return_list){
   		$('#InformationApproval').datagrid('loadData', bxw_return_list);
   	  }
      }); 
	},


    'UpdateStatus' : function(){

        var get_select_row = $($.Admin.InformationApproval.id).datagrid('getSelected');
        var data = {user_id: get_select_row.userId}
        if(get_select_row.isLook=="是"){
            $.messager.show({
                title:'消息',
                msg:'已读的消息不能更改'
            })
           return false;
		};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '审核信息',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "StuMsg/updateStatusPage",
            modal: true,
            width: 500,
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



}
$($.Admin.InformationApproval.id).datagrid({
	title: '当前位置：业务管理 > 信息管理 > 学生信息查看',
    border: false,
    toolbar: $.Admin.InformationApproval.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'userId',
    url: "StuMsg/getStuMsg",
	remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          /*{field:'ck',checkbox:true},  */
	          {field:'regDatetime',title:'注册时间',align:'center',width:100,sortable:'true'},
	          {field:'name',title:'学生姓名 ',align:'center',width:100,sortable:'true'},
	          {field:'sex',title:'性别',align:'center',width:50,sortable:'true'},
	          {field:'phone',title:'绑定手机号',align:'center',width:100,sortable:'true'},
	          {field:'school',title:'学校',align:'center',width:100,sortable:'true'},
	          {field:'state',title:'状态',align:'center',width:50,sortable:'true'},
	          {field:'isLook',title:'是否读取',align:'center',width:100,sortable:'true', formatter: function(value,row,index){
                  if (value=="否"){
                      return '未读';
                  } else {
                      return '已读';
                  }
              }}

	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});



$('#bxw_search').textbox().textbox({ icons: [{ 
	iconCls: 'icon-clear',
	handler: function (e) { 
		$(e.data.target).textbox('clear');
		$.Admin.InformationApproval.Bxw_Search();
		} 
}] });



</script>