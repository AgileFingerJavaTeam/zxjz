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
<div style="width:100%;height:100%">
	<div style="width:50%;height:100%;float:left">
		<table id="GyPositionType"></table>
		<input type="hidden" name="station_id" value="${infoList.station_id}"/>
		<input type="hidden" name="station_name" value="${infoList.station_name}"/>
	</div>
	<div style="width:50%;height:100%;float:left">
		<table id="SrtPositionType"></table>
	</div>
</div>
<script>
$.Admin.GyPositionType = {
    //组件ID
    'id' : '#GyPositionType',
    //工具栏
    'tools' : [
        { text: '添加类型', iconCls: 'fa fa-plus', handler: function(){
                $.Admin.GyPositionType.AddRole();
            } 
        },
        { text: '编辑类型', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.GyPositionType.EditRole();
            } 
        },
        { text: '删除类型', iconCls: 'fa fa-remove', handler: function(){
            $.Admin.GyPositionType.DelRole();
            } 
        },
    ],
    //添加角色
    'AddRole' : function(){
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '新增职位类型',
            iconCls: 'fa fa-plus',
            href: "GyStation/getTanStation",
            modal: true,
            closed: false,
            width:400,
          //  height:200,
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

    //编辑角色
    'EditRole' : function(){
        var get_select_row = $($.Admin.GyPositionType.id).treegrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {id: get_select_row.stationId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '编辑职位类型',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "GyStation/getEditMvDetails",
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
    //删除角色
    'DelRole' : function(){
            var get_select_row = $($.Admin.GyPositionType.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
                return false;
            }
            var data = {id: get_select_row.stationId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '删除职位类型',
            iconCls: 'fa fa-delete',
            href: "GyStation/getDelMvDetails",
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
    //函数格式化
    'formatter' : {
        'status' : function(value,row,index){
            if(parseInt(value)){
                return "<span class='fa fa-check text-primary'></span>";
            } else {
                return "<span class='fa fa-remove text-danger'></span>";
            }
        },
        'sort' : function(value,row,index){
            return '<span class="textbox" style="margin:5px 0px;"><input type="text" name="sort['+row.id+']" class="textbox-text sortbox-text" style="text-align:center;color:#000;padding-top: 4px; padding-bottom: 4px;width:30px;" value="'+value+'" /></span>';
        }
    }
};

var currentFirstLevelID = "";
var currentFirstLevelName = "";

$($.Admin.GyPositionType.id).datagrid({
	title: '当前位置：基础管理 > 基础信息 > 职位类型管理',
    border: false,
    toolbar: $.Admin.GyPositionType.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: true,
    rownumbers: true,
    animate: true,
    idField: 'stationId',
    url: 'GyStation/StationList',
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	    //      {field:'ck',checkbox:true},    
//	          {field:'stationId',title:'ID',align:'center'},
	          {field:'stationName',title:'职位类型名称',width:200},
	          /* {field:'status',title:'状态',align:'center',formatter:$.Admin.Role.formatter.status,width:80} */
	      ]],
 //---------双击事件----------//
    onDblClickRow: function(row){  	
    },
    //----------点击当前行时右侧联动-----------//
    onClickRow:function(index,row){
    	var get_select_row = $($.Admin.GyPositionType.id).treegrid('getSelected');
        currentFirstLevelID = get_select_row.stationId;
        currentFirstLevelName = get_select_row.stationName;
    	var srt_cnamestatusInfo={};
        var page=1;
        var rows=20;
        srt_cnamestatusInfo.page=page;
        srt_cnamestatusInfo.rows=rows;

    	srt_cnamestatusInfo.pstationId=currentFirstLevelID;
    	srt_cnamestatusInfo.PstationName=currentFirstLevelName;
       $.ajax({
    	  type:'POST',
    	  data: srt_cnamestatusInfo,
    	  dataType:'json',
    	  url:"GyStation/TwoStationList",
    	  success: function(srt_return_list){
    		$('#SrtPositionType').datagrid('loadData', srt_return_list);
    	  }
       }); 
    },
 //--------右击当前行事件--------------//
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
        $(this).datagrid("unselectAll"); //取消所有选中项
//        $(this).datagrid("selectRow", index); //根据索引选中该行
        $('#AdminRole_User').menu('show',{
            left: e.pageX,
            top: e.pageY
        });
    },
 //---------加载完成默认选择第一行然后加载次级列表----------//
    onLoadSuccess:function(){
    	$(this).datagrid("selectRow",0);
    	var get_select_row = $($.Admin.GyPositionType.id).treegrid('getSelected');
    	var srt_cnamestatusInfo={};
        var page=1;
        var rows=20;
        srt_cnamestatusInfo.page=page;
        srt_cnamestatusInfo.rows=rows;

    	currentFirstLevelID = get_select_row.stationId;
    	currentFirstLevelName = get_select_row.stationName;
        srt_cnamestatusInfo.pstationId=currentFirstLevelID;
        srt_cnamestatusInfo.PstationName=currentFirstLevelName;
       $.ajax({
    	  type:'POST',
    	  data: srt_cnamestatusInfo,
    	  dataType:'json',
    	  url:"GyStation/TwoStationList",
    	  success: function(srt_return_list){
    		$('#SrtPositionType').datagrid('loadData', srt_return_list);
    	  }
       }); 
    	//------------------二级---------------------------//
    	 $.Admin.SrtPositionType = {
    	    //组件ID
    	    'id' : '#SrtPositionType',
    	    //工具栏
    	    'tools' : [  
    	        { text: '添加分类', iconCls: 'fa fa-plus', handler: function(){
    	            $.Admin.SrtPositionType.AddClassify();
    	            } 
    	        },
    		    { text: '编辑分类', iconCls: 'fa fa-edit', handler: function(){
    		        $.Admin.SrtPositionType.EditClassify();
    		        } 
    		    },
    		    { text: '删除分类', iconCls: 'fa fa-remove', handler: function(){
    		    	$.Admin.SrtPositionType.DelectClassify();
    		        } 
    		    },
    	    ],  
    	  //添加职位分类
    	    'AddClassify' : function(){
    	        var id = $.Admin.random_dialog();
    	        $(id).dialog({
    	            title: '新增职位分类',
    	            iconCls: 'fa fa-plus',
    	            href: "GyStation/getTwoTanStation?pid="+currentFirstLevelID+"&pname="+currentFirstLevelName,
    	            modal: true,
    	            closed: false,
    	            width:400,
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

    	    //编辑职位分类
    	    'EditClassify' : function(){
    	        var get_select_row = $($.Admin.SrtPositionType.id).treegrid('getSelected');
    	        if(get_select_row == null){
    	            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
    	            return false;
    	        }
    	        var data = {id: get_select_row.stationId};
    	        var id = $.Admin.random_dialog();
    	        $(id).dialog({
    	            title: '编辑职位分类',
    	            iconCls: 'fa fa-edit',
    	            queryParams: data,
					href:"GyStation/showChildJobEditPage",
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
    	    //删除此职位分类
    	    'DelectClassify' : function(){
    	            var get_select_row = $($.Admin.SrtPositionType.id).datagrid('getSelected');
    	            if(get_select_row == null){
    	                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
    	                return false;
    	            }
    	            var data = {id: get_select_row.stationId};
    	        var id = $.Admin.random_dialog();
    	        $(id).dialog({
    	            title: '删除职位分类',
    	            iconCls: 'fa fa-delete',
    	            href: "GyStation/showDelCClassify",
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

    	$($.Admin.SrtPositionType.id).datagrid({
    		title: '当前位置：基础管理 > 基础信息 > 职位分类管理(子类)',
    	    border: false,
    	    toolbar: $.Admin.SrtPositionType.tools,
    	    fitColumns: true,
    	    fit: true,
    	    ctrlSelect: true,
    	    singleSelect:true,
    	    rownumbers: true,
    	    idField: 'uid',
 //   	    url: "GyStation/TwoStationList",
    	    remoteSort:false, 
    	    pagination:true,
    		pagePosition:'bottom',
    		pageNumber:1,
    		pageSize:20,
    		pageList:[10,20,30,50,100],
    		columns:[[
    		   //       {field:'ck',checkbox:true},    
//    		          {field:'stationId',title:'ID',align:'center'},
    		          {field:'stationName',title:'职位分类(子类)名称',width:80,},
    		      ]],
    	    onDblClickRow: function(row){ 
    	    	
    	    },
    	    onRowContextMenu: function(e,index,data){
    	        e.preventDefault();//阻止浏览器捕获右键事件
    	    }
    	});
    },

});
 
</script>