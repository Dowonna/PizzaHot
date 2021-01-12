<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="w3-main" style="margin-left:300px;margin-top:43px;">
  <div class="w3-content">
  
  <div class="w3-content">
    <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">About</h1>
    <p>PizzaHot is very good restaurant. we never followed PizzaHut.</p>
    <p><strong>The Head Chef?</strong> Mr. Changhun <br>
    <strong>The Vice Chef?</strong> Mr. Mingeon <br>
    <strong>Washing Dishes?</strong> Mr. TaeYeol 
    
    <img src="images/TY.PNG" style="width:150px; height: 100px" class="w3-circle w3-right" alt="Chef"><img src="images/CH.PNG" style="width:150px; height: 100px" class="w3-circle w3-right" alt="Chef"><img src="images/MG.PNG" style="width:150px; height: 100px" class="w3-circle w3-right" alt="Chef"></p>
    <p>We are proud of our interiors.</p>

	<div id="map" style="width:500px;height:400px;"></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=insert_ur_apikey"></script>
		<script>
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(33.450701, 126.570667),
				level: 3
			};
	
			var map = new kakao.maps.Map(container, options);
		</script>
	
    <h1><b>Opening Hours</b></h1>
    
    <div class="w3-row">
      <div class="w3-col s6">
        <p>Mon & Tue CLOSED</p>
        <p>Wednesday 10.00 - 24.00</p>
        <p>Thursday 10:00 - 24:00</p>
      </div>
      <div class="w3-col s6">
        <p>Friday 10:00 - 12:00</p>
        <p>Saturday 10:00 - 23:00</p>
        <p>Sunday Closed</p>
      </div>
    </div>
    
  </div>
</div>
</div>
<script>
function test(){
	alert(1);
}
</script>