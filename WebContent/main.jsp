<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="bgimg w3-main" style="margin-left:300px;margin-top:43px; font-family: 'Amatic SC'">
<div class="w3-display-container" id="home">
  	<div class="w3-display-bottomleft w3-padding">
	    <span class="w3-tag w3-xlarge">Open from 10am to 12pm</span>
  	</div>
  	<div class="w3-center" style="padding-top: 200px; padding-bottom: 200px">
	    <span class="w3-text-white w3-hide-small" style="font-size:150px"><b>PIZZAHOT</b></span>
	    <span class="w3-text-white w3-hide-large w3-hide-medium" style="font-size:60px;"><b>thin<br>CRUST PIZZA</b></span>
	    <p><a onclick="menu()" class="w3-button w3-xxlarge w3-black">Let me see the menu</a></p>
  	</div>
	</div>
</div>
<script>
function menu() {
	axios.get("menu_axios.jsp").then(function (r12){
			document.getElementById("11").innerHTML = r12.data;
	}).catch(function(){
		console.log("예외 발생");
	})
	
}
</script>