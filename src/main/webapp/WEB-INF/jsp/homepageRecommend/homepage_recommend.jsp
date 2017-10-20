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
<table id="hzn_homepage_recommend"></table>
<script>
$.Admin.hznHomepageRecommend = {
    //组件ID
    'id' : '#hzn_homepage_recommend',
    //工具栏
    'tools' : [     
        { text: '是否上首页推荐', iconCls: 'fa fa-edit', handler: function(){
                $.Admin.hznHomepageRecommend.UpOrDown();
            } 
        },
        { text: '关闭', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.hznHomepageRecommend.Down();
        } 
   		},
        { text: '详情', iconCls: 'fa fa-edit', handler: function(){
            $.Admin.hznHomepageRecommend.showSecurity();
            }
        },
        { 
          text:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="hzn_home_recommend_search" style="width:200px">', 
        },
        {
          iconCls:'icon-search',
          handler:function(){ 
          $.Admin.hznHomepageRecommend.search();
        }
        },
        {
          text:'状态筛选:<select style="width:100px; height: 25px; border-radius: 5px;" id="hznRecommendStatusSearch"><option value="">全部</option><option value="1">上架</option><option value="0">下架</option></select></div>',
        
          },
    ], 
    //模糊查询
    'search' :function(){
    	var a=$('#hzn_home_recommend_search').val();
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
            	  $('#hzn_homepage_recommend').datagrid('loadData', search_list);
              }
              
          });
    },
  
    //是否上首页推荐
    'UpOrDown' : function(){
        var get_select_row = $($.Admin.hznHomepageRecommend.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要更改的数据行','error');
            return false;
        }
        var data = {id: get_select_row.recruitingId};     //此处的id 与mapper里找的id 一致
        var account_id = $.Admin.random_dialog();
        $(account_id).dialog({
            title: '首页推荐',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "homepageRecommend/showWeatherHomepageRecommend",
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
  //关闭上首页推荐
    'Down' : function(){
        var get_select_row = $($.Admin.hznHomepageRecommend.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要更改的数据行','error');
            return false;
        }
        var data = {id: get_select_row.recruitingId};     //此处的id 与mapper里找的id 一致
        var account_id = $.Admin.random_dialog();
        $(account_id).dialog({
            title: '首页推荐',
            iconCls: 'fa fa-edit',
            queryParams: data,
            href: "homepageRecommend/showDowmHomepageRecommend",
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
    //职位详情
    'showSecurity' : function(){
        var get_select_row = $($.Admin.hznHomepageRecommend.id).datagrid('getSelected');
        if(get_select_row == null){
            $.Admin.tips('温馨提示信息', '请先选择 您要查看的数据行','error');
            return false;
        }
        var data = {id: get_select_row.recruitingId};
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '职位详情',
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

$($.Admin.hznHomepageRecommend.id).datagrid({
	title: '当前位置：业务管理 > 担保职位管理> 是否上首页推荐',
    border: false,
    toolbar: $.Admin.hznHomepageRecommend.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    rownumbers: true,
    idField: 'recruitingId',
    url: "securityPosition/getSecurityPositionList2",
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
	          {field:'good_begin_time',title:'首页担保开始日期',align:'center',width:100},
	          {field:'good_end_time',title:'首页担保结束日期',align:'center',width:100},
	          {field:'whether_on_homepage_recommend',title:'是否上首页推荐',align:'center',width:100},
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
	          {field:'page_url',title:'封页图URL（老虎）',align:'center',width:100,formatter:showImage1},
	          {field:'first_page_carousel_url',title:'首页图URL（用于App首页轮播的图片）衣服',align:'center',width:100,formatter:showImage2},
	          {field:'main_page_url',title:'详情页主图URL',align:'center',width:100,formatter:showImage3},
	          {field:'reported',title:'是否被举报',align:'center',width:100}, */
	          {field:'mainTitle',title:'主标题',align:'center',width:100},
	          {field:'subtitle',title:'副标题',align:'center',width:100},
	          {field:'shortDescription',title:'简介',align:'center',width:100},
	         
	         // {field:'details_page_introduction',title:'详情页介绍',align:'center',width:100},
	       /*    {field:'user_id',title:'商户ID',align:'center',width:100}, */
	          {field:'upDownFrame',title:'上架状态',align:'center',width:100},
	          {field:'recommendBeginTime',title:'推荐开始日期',align:'center',width:100},
	          {field:'recommendEndTime',title:'推荐结束日期',align:'center',width:100},
	          {field:'whetherOnHomepageRecommend',title:'是否上首页推荐',align:'center',width:100},
	          
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});  
  	  //显示图片1
	/* function showImage1(value,row,index){
		var html='<div style="padding:10px">';
		if (row.page_url!='' || row.page_url!=null){
			html+='<img src="TP/'+row.page_url+'" style="width:60px; height:50px">';
		} else {
			html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
		}
		html+='</div>';
		return html;
	}
	  //显示图片2
	function showImage2(value,row,index){
		var html='<div style="padding:10px">';
		if (row.first_page_carousel_url!='' || row.first_page_carousel_url!=null){
			html+='<img src="TP/'+row.first_page_carousel_url+'" style="width:60px; height:50px">';
		} else {
			html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
		}
		html+='</div>';
		return html;
	}
	  //显示图片3
	function showImage3(value,row,index){
		var html='<div style="padding:10px">';
		if (row.main_page_url!='' || row.main_page_url!=null){
			html+='<img src="TP/'+row.main_page_url+'" style="width:60px; height:50px">';
		} else {
			html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
		}
		html+='</div>';
		return html;
	}
 */
     $('#hzn_home_recommend_search').textbox({ icons: [{ 
    	 iconCls: 'icon-clear', 
    	 handler: function (e) { 
    		 $(e.data.target).textbox('clear');
    		 $.Admin.hznHomepageRecommend.search();
    		 } }] });
    		 
    $('#hznRecommendStatusSearch').on('change',function(){
     	var a=$('#hznRecommendStatusSearch').val();
    	var statusSearch={};
    	statusSearch.statusSearch=a;
          $.ajax({
        	  type:'post',
              title: '状态筛选',
              data:statusSearch,
              url: "securityPosition/StatusSearch2",
              datatype:'json',
              success:function(search_list){
            	  $('#hzn_homepage_recommend').datagrid('loadData', search_list);
              }
    })
    });
  
</script>