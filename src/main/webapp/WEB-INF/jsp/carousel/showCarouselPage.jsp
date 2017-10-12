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
<table id="carousel"></table>
<script>
function qq(value,name){ 
alert(value) 
} 
$('#ss').appendTo('.datagrid-toolbar');

$.Admin.carousel = {
    //组件ID
    'id' : '#carousel',
    //工具栏
    'tools' : [    
        { text: '添加', iconCls: 'fa fa-plus', handler: function(){
                $.Admin.carousel.AddCP();
            } 
        },
        { text: '修改', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.carousel.EditCP();
            } 
        },
        { text: '变更状态', iconCls: 'fa fa-edit', handler: function(){
          	  $.Admin.carousel.ChangeCP();
      	  } 
 	   },
 	 
        { text: '删除', iconCls: 'fa fa-remove', handler: function(){
        		$.Admin.carousel.DelCP();
		    } 
		},        
        //-------搜索-------//
        { text: '&nbsp&nbsp&nbsp&nbsp<input id="xzf_search" type="text"></input>',	
             handler: function(e){
             }
       },
        {  iconCls:'icon-search',
       	   handler: function(){
           		$.Admin.carousel.SearchCP();
       		} 
        },
        
    ],
  //添加
    'AddCP' : function(){
        var carousel_figure_id = $.Admin.random_dialog();
        $(carousel_figure_id).dialog({
            title: '添加轮播图',
            iconCls: 'fa fa-plus',
            href: "CarouselManage/addInfo",
            modal: true,
            width:400,
            onClose : function(){
                $(this).dialog("destroy");
            },
            onOpen : function(){
                var top = 
                	$(this).offset().top-$(this).position().top;
                $(this).dialog('resize',{
                    top: (top/2)+'px'
                });
            }
        });
    },    

    //编辑轮播图参数
    'EditCP' : function(){
        var get_select_row = $($.Admin.carousel.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {carousel_figure_id: get_select_row.carousel_figure_id};    //此处的id 与mapper里找的id 一致
        var carousel_figure_id = $.Admin.random_dialog();
        $(carousel_figure_id).dialog({
            title: '编辑轮播图参数',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "CarouselManage/editInfo",
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
    //变更状态
    'ChangeCP' : function(){
            var get_select_row = $($.Admin.carousel.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
                return false;
            }
         var data = {carousel_figure_id: get_select_row.carousel_figure_id};    //此处的id 与mapper里找的id 一致
         var carousel_figure_id = $.Admin.random_dialog();
        $(carousel_figure_id).dialog({
            title: '变更状态',
            iconCls: 'fa fa-delete',
            href: "CarouselManage/changeInfo",
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
    //删除轮播图
    'DelCP' : function(){
            var get_select_row = $($.Admin.carousel.id).datagrid('getSelected');
            if(get_select_row == null){
                $.Admin.tips('温馨提示信息', '请先选择 您要删除的数据行','error');
                return false;
            }
         var data = {carousel_figure_id: get_select_row.carousel_figure_id};    //此处的id 与mapper里找的id 一致
         var carousel_figure_id = $.Admin.random_dialog();
        $(carousel_figure_id).dialog({
            title: '删除轮播图',
            iconCls: 'fa fa-delete',
            href: "CarouselManage/delInfo",
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
    //搜索
	'SearchCP' : function(){
		var search_content=$('#xzf_search').val();
        var xzf_searchInfo={};
        xzf_searchInfo.xzf_search_content=search_content;
      $.ajax({
   	  type:'POST',
   	  data: xzf_searchInfo,
   	  dataType:'json',
   	  url:"CarouselManage/getCarouselList",
   	  success: function(xzf_return_list){
   		$('#carousel').datagrid('loadData',xzf_return_list);
   	  }
      }); 
	},
}

$($.Admin.carousel.id).datagrid({
	title: '当前位置：基础管理 > 基础信息 > 轮播图管理',
    border: false,
    toolbar: $.Admin.carousel.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'carousel_figure_id',
    url: "CarouselManage/getCarouselList",
    remoteSort:false,
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
		columns:[[
	          {field:'ck',checkbox:true}, 
	          {field:'carousel_code',title:'编号',align:'center',sortable:true,
	        	  sorter:function(a,b){
	        		  return(a>b?1:-1);
	        	  }
	          },
	          {field:'carousel_name',title:'名称',align:'center',sortable:true,},
	          {field:'carousel_figure_type',title:'轮播图分类',align:'center',formatter:carouselKind,sortable:true},
	          {field:'picture_url',title:'图片URL',width:100,formatter:showImage},
	          {field:'target_type',title:'目标分类',align:'center',width:100,sortable:true,},
	          {field:'target_id',title:'目标ID',align:'center',width:100,sortable:true,},
	          {field:'target_url',title:'目标URL',align:'center',width:100,formatter:showUrl},
	          {field:'is_good_position',title:'是否担保职位',halign:'center',align:'center',sortable:true,},
	          {field:'target_parameter',title:'目标参数',align:'center',width:100,sortable:true,},
	          {field:'start_date',title:'播放起始日期',align:'center',width:100,sortable:true,
	        	  sorter:function(a,b){
	        		  return(a>b?1:-1);
	        	  }},
	          {field:'end_date',title:'播放截止日期',align:'center',width:100,sortable:true,
	        		  sorter:function(a,b){
		        		  return(a>b?1:-1);
		        	  }},
	          {field:'state',title:'状态',align:'center',width:100,sortable:true,},
	          {field:'operator',title:'操作人',align:'center',width:100,sortable:true,
	        	  sorter:function(a,b){
	        		  return(a>b?1:-1);
	        	  }}
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});
    //轮播图分类选择功能
		function carouselKind(value,row,index){
			switch(row.carousel_figure_type){
				case  1:
					return "学生app首页";
				case  2:
					return "微信首页"; 
				case  3:
					return "网页";
				case  4:
					return "商家app"; 
				default:
					return "请选择类型"; 
			}
		} 

		//显示图片
		function showImage(value,row,index){
			var html='<div style="padding:10px" >';
			if (row.picture_url!='' || row.picture_url!=null){
				html+='<img src="TP/'+row.picture_url+'" style="width:60px;height:50px" >';
		
			} else {
				html+='<img src="TP/default_category.png" style="width:60px;height:50px" >';
			}
			html+='</div>';
			return html;
		}

		//H5 超链接
		function showUrl(value,row,index){
			var html='<div style="padding:10px">';
			if (row.target_url!='' || row.target_url!=null){
				html+='<a target="_blank" href="'+row.target_url+'" style="width:60px;height:50px">'+row.target_url+'</a>';
			} else {
			}
			html+='</div>';
			return html;
		}
		//-------取消搜索插件------//
		$('#xzf_search').textbox().textbox({ icons: [{ 
			iconCls: 'icon-clear',
			handler: function (e) { 
				$(e.data.target).textbox('clear');
				$.Admin.carousel.SearchCP();
				} 
		}] }) 

		
		
</script>