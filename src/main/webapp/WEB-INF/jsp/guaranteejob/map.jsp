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
      <form action="MapFrom" method="get" id="mapPage">
        <div style=" margin:auto;width:800px;height:500px;border:2px solid gray; " id="container"></div>
        <div style="text-align:center">
	        <h4 style="color: red;">介绍：输入地点然后点击“地图查找”搜索，再点击地图地点获取相应经纬度</h4>
	        <label>输入地点：</label>
	        <input id="where" name="where" type="text" placeholder="请输入地址">
	        <input id="but" type="button" value="地图查找"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 经度：
	        <input id="lonlat" name="lonlat" type="text" maxlength="10">纬度：
	        <input id="lonlat2" name="lonlat2" type="text" maxlength="9"><br>
	        <div style="text-align:center">
		        <input type="button" id="confirm_map" value="确认" class="easyui-linkbutton" style="width: 70px; height: 40px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        <input type="reset" id="axax1" value="重置" class="easyui-linkbutton" style="width: 70px; height: 40px;">
			</div>
		</div>		
        </form>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2&callback=BMapFCK"></script>
        
 		 <script type="text/javascript">

		var BMapFCK=function(){
 		   //如果经纬度没有给个默认值
 		   var longitude=105.386515;
 		   var latitude=28.91124;
 		   
 		   var map = new BMap.Map("container");
 		  map.setDefaultCursor("crosshair");
 		  map.enableScrollWheelZoom();
 		  var point = new BMap.Point(longitude,latitude);
 		  map.centerAndZoom(point, 13);
 		  var gc = new BMap.Geocoder();
 		  map.addControl(new BMap.NavigationControl());
 		  map.addControl(new BMap.OverviewMapControl());
 		  map.addControl(new BMap.ScaleControl());
 		  map.addControl(new BMap.MapTypeControl());
 		  map.addControl(new BMap.CopyrightControl());
 		  var marker = new BMap.Marker(point);
 		  map.addOverlay(marker);
 		  marker.addEventListener("click",
 		  function(e) {
 		    document.getElementById("lonlat").value = e.point.lng;
 		    document.getElementById("lonlat2").value = e.point.lat;
 		  });
 		  marker.enableDragging();
 		  marker.addEventListener("dragend",
 		  function(e) {
 		    gc.getLocation(e.point,
 		    function(rs) {
 		      showLocationInfo(e.point, rs);
 		    });
 		  });
 		  function showLocationInfo(pt, rs) {
 		    var opts = {
 		      width: 250,
 		      height: 150,
 		      title: "当前位置"
 		    };
 		    var addComp = rs.addressComponents;
 		    var addr = "当前位置：" + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber + "<br/>";
 		    addr += "纬度: " + pt.lat + ", " + "经度：" + pt.lng;
 		    var infoWindow = new BMap.InfoWindow(addr, opts);
 		    marker.openInfoWindow(infoWindow);
 		  }
 		  map.addEventListener("click",
 		  function(e) {
 		    document.getElementById("lonlat").value = e.point.lng;
 		    document.getElementById("lonlat2").value = e.point.lat;
 		  });
 		  var traffic = new BMap.TrafficLayer();
 		  map.addTileLayer(traffic);
 		  function iploac(result) {
 		    var cityName = result.name;
 		  }
 		  var myCity = new BMap.LocalCity();
 		  myCity.get(iploac);
 		  
 		 function sear(result) {
  		    var local = new BMap.LocalSearch(map, {
  		      renderOptions: {
  		        map: map
  		      }
  		    });
  		    local.search(result);
  		  }
 		 $('#but').on('click',function(){
 			 var a=$('#where').val();
 			 sear(a);
 		 });
		};
		$('input#confirm_map').click(function(){
			console.log(777)
			var location=$('input#where').val();
			var longitude=$('input#lonlat').val();
			var latitude=$('input#lonlat2').val();
			$('input#at_location').textbox("setValue", location);
			$('input#at_position_longitude').val(longitude);
			$('input#at_position_latitude').val(latitude);
			$('#dd').window("close");
			
		});
		
  </script>
