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
<table id="SrtPositionType"></table>
<script>
$.Admin.SrtPositionType = {
    //组件ID
    'id' : '#SrtPositionType',
    //工具栏
    'tools' : [  
               

        //--------------审核---------------------//
        { text: '选择父级类型:&nbsp&nbsp&nbsp<input id="sRt_cbox" name="pstationName"  width="100px">',
        }, 
        { text: '添加', iconCls: 'fa fa-plus', handler: function(){
            $.Admin.SrtPositionType.AddClassify();
            } 
        },
	    { text: '编辑', iconCls: 'fa fa-edit', handler: function(){
	        $.Admin.SrtPositionType.EditClassify();
	        } 
	    },
	    { text: '删除', iconCls: 'fa fa-remove', handler: function(){
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
            href: "GyStation/getTwoTanStation",
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

    //编辑职位分类
    'EditClassify' : function(){
        var get_select_row = $($.Admin.SrtPositionType.id).treegrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {id: get_select_row.station_id};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '编辑职位分类',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "GyStation/showEditDetails",
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
            var data = {id: get_select_row.station_id};
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
	title: '当前位置：基础管理 > 基础信息 > 职位分类管理',
    border: false,
    toolbar: $.Admin.SrtPositionType.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'uid',
    url: "GyStation/TwoStationList",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	  	    //      {field:'station_id',title:'ID',align:'center'},
	          {field:'station_name',title:'职位分类名称',width:80,},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});

	//----------筛选框------------//
	$("#sRt_cbox").combobox({
		onChange: function () {
             var onch=$('#sRt_cbox').val();
             var srt_cnamestatusInfo={};
             srt_cnamestatusInfo.pstationName=onch;
           $.ajax({
        	  type:'POST',
        	  data: srt_cnamestatusInfo,
        	  dataType:'json',
        	  url:"GyStation/TwoStationList",
        	  success: function(srt_return_list){
        		$('#SrtPositionType').datagrid('loadData', srt_return_list);
        	  }
           });         
		}
	});
	//-----取消搜索插件----------//
	  $('#srt_search1').textbox().textbox({ icons: [{ 
			iconCls: 'icon-clear',
			handler: function (e) { 
				$(e.data.target).textbox('clear');
				$.Admin.SrtPositionType.Srt_search1();
				} 
		}] })    
    //-----------筛选框赋值-------------//
    $('#sRt_cbox').combobox({
         url:'GyStation/getPInfo',                       
         valueField: 'station_id',
         textField: 'station_name'
         });                            
</script>