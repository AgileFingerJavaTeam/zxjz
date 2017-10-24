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

         { text: '<input id="bxw_search" type="text"></input>',
             handler: function(e){
             }
       },
       
       {  iconCls:'icon-search',
       	  handler: function(e){
           		$.Admin.InformationApproval.Bxw_Search();
       		} 
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
	          {field:'isLook',title:'操作',align:'center',width:100,sortable:'true', formatter: function(value,row,index){
                  if (value=="否"){
                      return '<button onclick="editUser('+index+')">未读</button>';
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


function editUser(index){
    var row =  $('#InformationApproval').datagrid('selectRow',index);
   /* var get_select_row = $($.Admin.InformationApproval.id).datagrid('getSelected');*/
    var data = {user_id: row.userId}
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
}

</script>