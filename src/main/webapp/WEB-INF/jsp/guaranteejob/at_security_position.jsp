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
<table id="at-security-position"></table>
<script>
$.Admin.atSecurityPosition = {
    //组件ID
    'id' : '#at-security-position',
    //工具栏
    'tools' : [    
        { text: '添加', iconCls: 'fa fa-plus', handler: function(){
                $.Admin.atSecurityPosition.AddAT();
            } 
        }, 
        { text: '编辑', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.atSecurityPosition.editAT();
            } 
        },
        { text: '详情', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.atSecurityPosition.showSecurity();
            }
        },
        { 
          text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="attr1" style="width:200px">', 
        },
        {
          iconCls:'icon-search',
          handler:function(){ 
          $.Admin.atSecurityPosition.search();
        }
        },
        {
          text:'状态筛选:<select style="width:70px;" id="statusSearch"><option value="">全部</option><option value="1">上架</option><option value="0">下架</option></select></div>',
        
          },
    ],
    //添加角色
    'AddAT' : function(){
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '添加担保职位',
            iconCls: 'fa fa-plus',
            href: "securityPosition/addAT",
            modal: true,
            width:900,
            height:700,
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
   
    //模糊查询
    'search' :function(){
    	var a=$('#attr1').val();
    	var search={};
    	search.search=a;
          $.ajax({
        	  type:'post',
              title: '模糊查询',
              data:search,
              iconCls:'icon-search',
              url: "securityPosition/search",
              datatype:'json',
              success:function(search_list){
            	  $('#at-security-position').datagrid('loadData', search_list);
              }
              
          });
    },
  
    //编辑系统参数
    'editAT' : function(){
        var get_select_row = $($.Admin.atSecurityPosition.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要编辑的数据行','error');
            return false;
        }
        var data = {id: get_select_row.recruitingId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '编辑系统参数',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "securityPosition/editAT",
            modal: true,
            width:900,
            height:700,
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
    //系统参数详情
    'showSecurity' : function(){
        var get_select_row = $($.Admin.atSecurityPosition.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要查看的数据行','error');
            return false;
        }
        var data = {id: get_select_row.recruitingId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '系统参数详情',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "securityPosition/showSecurity",
            modal: true,
            width: 900,
            height:500,
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
    }
}

$($.Admin.atSecurityPosition.id).datagrid({
	title: '当前位置：业务管理 > 担保职位管理 > 发布担保职位',
    border: false,
    toolbar: $.Admin.atSecurityPosition.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'recruitingId',
    url: "securityPosition/getSecurityPositionList",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'merchantsName',title:'商户名称',align:'center',width:100},
/* 	          {field:'release_time',title:'发布时间',align:'center',width:100},
	          {field:'refresh_time',title:'刷新时间',align:'center',width:100},
	          {field:'post_name',title:'岗位名称',align:'center',width:100},
	          {field:'post_classification',title:'岗位分类',align:'center',width:100},
	          {field:'details_page_category',title:'详情页面分类',align:'center',width:100},
	          {field:'whether_on_homepage_guarantee',title:'是否上首页担保',align:'center',width:100},
	          {field:'good_begin_time',title:'首页担保开始日期',align:'center',width:100},
	          {field:'good_end_time',title:'首页担保结束日期',align:'center',width:100},
	          {field:'whether_on_homepage_recommend',title:'是否上首页推荐',align:'center',width:100},
	          {field:'recommend_begin_time',title:'推荐开始日期',align:'center',width:100},
	          {field:'recommend_end_time',title:'推荐结束日期',align:'center',width:100},
	          {field:'work_date',title:'工作日期',align:'center',width:100},
	          {field:'work_time',title:'工作时间',align:'center',width:100},
	          {field:'work_location',title:'工作地点',align:'center',width:100},
	          {field:'position_longitude',title:'工作地点经度',align:'center',width:100},
	          {field:'position_latitude',title:'工作地点纬度',align:'center',width:100},
	          {field:'work_content',title:'工作内容',align:'center',width:100},
	          {field:'settlement_method',title:'结算方式',align:'center',width:100},
	          {field:'salary_treatment',title:'工资待遇',align:'center',width:100},
	          {field:'commission',title:'提成',align:'center',width:100},
	          {field:'benefits',title:'福利',align:'center',width:100},
	          {field:'gender_requirements',title:'性别要求',align:'center',width:100},
	          {field:'other_requirements',title:'其他要求',align:'center',width:100},
	          {field:'recruitment',title:'招聘人数',align:'center',width:100},
	          {field:'people_num',title:'已经报名人数',align:'center',width:100},
	          {field:'hiring_expiration_date',title:'招聘到期时间',align:'center',width:100},
	          {field:'recruitment_status',title:'招聘状态',align:'center',width:100},
	          {field:'view_count',title:'浏览次数',align:'center',width:100},
	          {field:'collection_count',title:'收藏次数',align:'center',width:100},
	          {field:'reported',title:'是否被举报',align:'center',width:100}, */
	          {field:'mainTitle',title:'主标题',align:'center',width:100},
	          {field:'subtitle',title:'副标题',align:'center',width:100},
	          {field:'shortDescription',title:'简介',align:'center',width:100},
	          {field:'pageUrl',title:'封页图URL（老虎）',align:'center',width:100,formatter:showImage1},
	          {field:'firstPageCarouselUrl',title:'首页图URL（用于App首页轮播的图片）衣服',align:'center',width:100,formatter:showImage2},
	          {field:'mainPageUrl',title:'详情页主图URL',align:'center',width:100,formatter:showImage3},
	         // {field:'details_page_introduction',title:'详情页介绍',align:'center',width:100},
	       /*    {field:'user_id',title:'商户ID',align:'center',width:100}, */
	          {field:'upDownFrame',title:'上架状态',align:'center',width:100},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});  
  	  //显示图片1
	function showImage1(value,row,index){
		var html='<div style="padding:10px">';
		if (row.pageUrl!='' || row.pageUrl!=null){
			html+='<img src="TP/'+row.pageUrl+'" style="width:60px; height:50px">';
		} else {
			html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
		}
		html+='</div>';
		return html;
	}
	  //显示图片2
	function showImage2(value,row,index){
		var html='<div style="padding:10px">';
		if (row.firstPageCarouselUrl!='' || row.firstPageCarouselUrl!=null){
			html+='<img src="TP/'+row.firstPageCarouselUrl+'" style="width:60px; height:50px">';
		} else {
			html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
		}
		html+='</div>';
		return html;
	}
	  //显示图片3
	function showImage3(value,row,index){
		var html='<div style="padding:10px">';
		if (row.mainPageUrl!='' || row.mainPageUrl!=null){
			html+='<img src="TP/'+row.mainPageUrl+'" style="width:60px; height:50px">';
		} else {
			html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
		}
		html+='</div>';
		return html;
	}
	/*     $.extend($.fn.textbox.methods, {
			addClearBtn: function(jq, iconCls){
				return jq.each(function(){
					var t = $(this);
					var opts = t.textbox('options');
					opts.icons = opts.icons || [];
					opts.icons.unshift({
						iconCls: iconCls,
						handler: function(e){
							$(e.data.target).textbox('clear').textbox('textbox').focus();
							$(this).css('visibility','hidden');
						}
					});
					t.textbox();
					if (!t.textbox('getText')){
						t.textbox('getIcon',0).css('visibility','hidden');
					}
					t.textbox('textbox').bind('keyup', function(){
						var icon = t.textbox('getIcon',0);
						if ($(this).val()){
							icon.css('visibility','visible');
						} else {
							icon.css('visibility','hidden');
						}
					});
				});
			}
		});  */
     $('#attr1').textbox({ icons: [{ 
    	 iconCls: 'icon-clear', 
    	 handler: function (e) { 
    		 $(e.data.target).textbox('clear');
    		 $.Admin.atSecurityPosition.search();
    		 } }] })
    		 
    $('#statusSearch').on('change',function(){
     	var a=$('#statusSearch').val();
    	var statusSearch={};
    	statusSearch.statusSearch=a;
          $.ajax({
        	  type:'post',
              title: '状态筛选',
              data:statusSearch,
              url: "securityPosition/StatusSearch",
              datatype:'json',
              success:function(search_list){
            	  $('#at-security-position').datagrid('loadData', search_list);
              }
    })
    });
  
</script>