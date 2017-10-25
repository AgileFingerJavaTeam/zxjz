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
<table id="messageApproval"></table>

	


<script>



$.Admin.messageApproval = {
    //组件ID
    'id' : '#messageApproval',
    //工具栏
    'tools' : [
        { text: '读取', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.messageApproval.UpdateStatus();
        }
        },

         { text: '<input id="searchmsg" type="text"></input>',
             handler: function(e){
             }
       },
       
       {  iconCls:'icon-search',
       	  handler: function(e){
           		$.Admin.messageApproval.Bxw_Search();
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
            $.Admin.messageApproval.Bxw_Search();
        }
        },
        { text: '清空', iconCls: 'fa fa-edit', handler: function(e){
           $('#start_time').datebox('clear');
            $('#end_time').datebox('clear');
            $.Admin.messageApproval.Bxw_Search();
        }
        },
        { text: '导出', iconCls: 'fa fa-save', handler: function(){
            $.Admin.messageApproval.export();
        }
        },


    ],

  //搜索
	 'Bxw_Search' : function(){
		var search_content=$('#searchmsg').val();
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
   		$('#messageApproval').datagrid('loadData', bxw_return_list);
   	  }
      }); 
	},
	
	'export':function () {
            var data = JSON.stringify($($.Admin.messageApproval.id).datagrid('getData').rows);
            console.log(data);
            if (data == '')
                return;

            JSONToCSVConvertor(data, "Download", true);
    },
	


    'UpdateStatus' : function(){

        var get_select_row = $($.Admin.messageApproval.id).datagrid('getSelected');
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
    }



}
$($.Admin.messageApproval.id).datagrid({
	title: '当前位置：业务管理 > 信息管理 > 学生信息查看',
    border: false,
    toolbar: $.Admin.messageApproval.tools,
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



$('#searchmsg').textbox().textbox({ icons: [{
	iconCls: 'icon-clear',
	handler: function (e) { 
		$(e.data.target).textbox('clear');
		$.Admin.messageApproval.Bxw_Search();
		} 
}] });



function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
    //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
        : JSONData;
    var CSV = '';
    //Set Report title in first row or line
    CSV += ReportTitle + '\r\n\n';
    //This condition will generate the Label/Header
    if (ShowLabel) {
        var row = "";
        //This loop will extract the label from 1st index of on array
        for ( var index in arrData[0]) {
            //Now convert each value to string and comma-seprated
            row += index + ',';
        }
        row = row.slice(0, -1);
        //append Label row with line break
        CSV += row + '\r\n';
    }
    //1st loop is to extract each row
    for (var i = 0; i < arrData.length; i++) {
        var row = "";
        //2nd loop will extract each column and convert it in string comma-seprated
        for ( var index in arrData[i]) {
            row += '"' + arrData[i][index] + '",';
        }
        row.slice(0, row.length - 1);
        //add a line break after each row
        CSV += row + '\r\n';
    }
    if (CSV == '') {
        alert("Invalid data");
        return;
    }
    //Generate a file name
    var fileName = "MyReport_";
    //this will remove the blank-spaces from the title and replace it with an underscore
    fileName += ReportTitle.replace(/ /g, "_");
    //Initialize file format you want csv or xls
    var uri = 'data:text/csv;charset=GBK,' + encodeURI(CSV);
    // Now the little tricky part.
    // you can use either>> window.open(uri);
    // but this will not work in some browsers
    // or you will not get the correct file extension
    //this trick will generate a temp <a /> tag
    var link = document.createElement("a");
    link.href = uri;
    //set the visibility hidden so it will not effect on your web-layout
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";
    //this part will append the anchor tag and remove it after automatic click
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}



</script>