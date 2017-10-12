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
<table id="stuCertification"></table>
<script>
$.Admin.stuCertification = {
    //组件ID
    'id' : '#stuCertification',
    //工具栏
    'tools' : [  
         //----------------查看-----------------------//     
       { text: '查看&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp',
        	iconCls: 'fa fa-video-camera',
        	handler: function(){
                $.Admin.stuCertification.auditStu();
            } 
        },
        //--------------筛选---------------------//
        { text: '审核状态:&nbsp&nbsp&nbsp<select id="srt_filtrate" class="easyui-combobox" name="srt_filtrate" style="width:100px;" data-options="required:true,editable:false">'+" "
    		+'<option value="">全部</option><option value="2">审核通过</option><option value="1">审核驳回</option><option value="0">等待审核</option></select>',
        },
        //--------搜索----------//
        { text: '&nbsp&nbsp&nbsp&nbsp<input id="srt_searchStu" type="text"></input>',
        	// iconCls:'icon-clear',
             handler: function(e){            	 
             }
        },
       //--------------搜索图标---------------//
        {  iconCls:'icon-search',
       	  handler: function(){
           		$.Admin.stuCertification.srt_searchStu();
       		} 
        },
    ],
  //查看&&审核
    'auditStu' : function(){
        var get_select_row = $($.Admin.stuCertification.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要审核的数据行','error');
            return false;
        }
        var data = {id:get_select_row.user_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '审核学生信息',
            iconCls: 'fa fa-video-camera',
            queryParams:data,
            href: "stuCertification/showAuditStuPage",
            modal: true,
            width:400,
            height:300,
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
    //搜索
	'srt_searchStu' : function(){
		var search_content=$('#srt_searchStu').val();
		var onch=$('#srt_filtrate').combobox('getValue');
        var srt_searchStuInfo={};
        srt_searchStuInfo.srt_searchStu_content=search_content;
        srt_searchStuInfo.srt_filtrate=onch;
      $.ajax({
   	  type:'post',
   	  data: srt_searchStuInfo,
   	  dataType:'json',
   	  url:"stuCertification/getStudentInfo",
   	  success: function(srt_return_list){
   		$('#stuCertification').datagrid('loadData', srt_return_list);
   	  }
      }); 
	},

},
$($.Admin.stuCertification.id).datagrid({
	title: '当前位置：业务管理 > 审核管理 > 学生认证审核',
    border: false,
    toolbar: $.Admin.stuCertification.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'user_id',
    url: "stuCertification/getStudentInfo",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
//	          {field:'user_id',title:'学生ID',align:'center',width:80,},
	          {field:'name',title:'学生姓名',align:'center',width:80,},
	       //   {field:'studentcard_pic',title:'学生证照片',align:'center',width:80,},	     
	          {field:'stu_number',title:'学号',align:'center',width:80},
	       //   {field:'idcard_pic',title:'身份证照片',align:'center',width:80},
	          {field:'id_card',title:'身份证号码',align:'center',width:80},
	      //    {field:'operating_time',title:'操作时间',align:'center',width:80},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});
//----------筛选框------------//
$("#srt_filtrate").combobox({
	onChange: function () {
         var onch=$('#srt_filtrate').combobox('getValue');
         var srt_filtrateInfo={};
         srt_filtrateInfo.srt_filtrate=onch;
       $.ajax({
    	  type:'POST',
    	  data:srt_filtrateInfo,
    	  dataType:'json',
    	  url:"stuCertification/getStudentInfo",
    	  success: function(sRt_return_list){
    		$('#stuCertification').datagrid('loadData', sRt_return_list);
    	  }
       });  
   
	}
});
//-----取消搜索插件----------//
$('#srt_searchStu').textbox().textbox({ icons: [{ 
		iconCls: 'icon-clear',
		handler: function (e) { 
			$(e.data.target).textbox('clear');
			$.Admin.stuCertification.srt_searchStu();
			} 
	}] })    

</script>