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
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{height:500px;width:100%;}
		#r-result{width:100%; font-size:14px;}
	</style>
	
	<title>城市名定位</title>
</head>
<body>
	<div id="allmap" style=" margin:auto;width:800px;height:500px;" ></div>
	<div id="r-result" style=" margin:auto;text-align:center">
		经度: <input id="longitude" readonly name="position_longitude" type="text" style="width:100px; margin-right:10px;" />
		纬度: <input id="latitude" readonly name="position_latitude" type="text" style="width:100px; margin-right:10px;" />		
	</div>
	
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=fFbuSxVFx29Xxp2OG5ePIPkbUqlv9nxe&callback=BMapFCK"></script>
<script type="text/javascript">


var BMapFCK=function(){
	// 百度地图API功能
	var map = new BMap.Map("allmap");//创建map实例
	map.centerAndZoom(new BMap.Point(117.2,39.13),13);//初始化地图,设置中心点坐标和地图级别
	map.enableScrollWheelZoom(true);//开启鼠标滚轮缩放

	var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_RIGHT});
	var overView = new BMap.OverviewMapControl();
	var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
	map.addControl(mapType2);          //右上角，默认地图控件
	map.setCurrentCity("天津");        //由于有3D图，需要设置城市哦
	map.addControl(overView);          //添加默认缩略地图控件
	map.addControl(overViewOpen);      //右下角，打开
	var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
	map.addControl(top_left_control);        
	map.addControl(top_left_navigation);
	map.addTileLayer(new BMap.PanoramaCoverageLayer());

	var stCtrl = new BMap.PanoramaControl(); //构造全景控件
	stCtrl.setOffset(new BMap.Size(10, 50));
	map.addControl(stCtrl);//添加全景控件
	var a=$("#long").val();
	var b=$("#lat").val();
	$("#longitude").val(a);
	$("#latitude").val(b);
	var new_point = new BMap.Point($("#longitude").val(),$("#latitude").val());
	var marker = new BMap.Marker(new_point);  // 创建标注
	map.addOverlay(marker);  
	map.panTo(new_point); 

}
</script>
	
</body>
</html>
