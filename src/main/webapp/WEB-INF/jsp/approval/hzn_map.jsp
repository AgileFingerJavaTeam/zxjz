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
      <form action="" method="get" id="mapPage">
        <div style=" margin:auto;width:640px;height:480px;border:2px solid gray; " id="container"></div>
        <div style="text-align:center">
	        
	        <div id="r-result" style=" margin:auto;text-algin:center">
	        	<h4 style="color: red;">介绍：红点即是公司地址</h4>	
				经度: <input id="hzn_this_longitude" readonly="readonly" name="this_latitude" type="text" style="width:100px; margin-right:10px;" />
				纬度: <input id="hzn_this_latitude" readonly="readonly" name="this_latitude" type="text" style="width:100px; margin-right:10px;" />		
			</div>
		</div>		
        </form>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2&callback=BMapFCK"></script>
        
 		 <script type="text/javascript">

		var BMapFCK=function(){
 		   //如果经纬度没有给个默认值
 		   var longitude=$('#hzn_company_longitude').val();
 		   var latitude=$('#hzn_company_latitude').val();
 		   $('#hzn_this_longitude').val(longitude);
 		   $('#hzn_this_latitude').val(latitude);
 		   
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
 		    document.getElementById("hzn_this_longitude").value = e.point.lng;
 		    document.getElementById("hzn_this_latitude").value = e.point.lat;
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
 		    document.getElementById("hzn_this_longitude").value = e.point.lng;
 		    document.getElementById("hzn_this_latitude").value = e.point.lat;
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
 		 $('#hzn_map_find_poisition').on('click',function(){
 			 var a=$('#hzn_map_address').val();
 			 sear(a);
 		 });
		};

		$('input#confirm_map').click(function(){
			$('#hzn_map_div').window("close");
			
		});
		
  </script>
