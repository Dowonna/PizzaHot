<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<title>PizzaHot</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
.bgimg {
  background-repeat: repeat;
  background-size: cover;
  background-image: url("images/pizza_home.jpg");
  min-height: 90%;
}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <span class="w3-bar-item w3-right">Logo</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container">
    <h5>Dashboard</h5>
  </div>
  <jsp:include page="nav.jsp"/> 
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="bgimg w3-main" style="margin-left:300px;margin-top:43px; font-family: 'Amatic SC'">

<!-- Header with image -->
	<div class="w3-display-container" id="home">
  	<div class="w3-display-bottomleft w3-padding">
	    <span class="w3-tag w3-xlarge">Open from 10am to 12pm</span>
  	</div>
  	<div class="w3-center" style="padding-top: 200px; padding-bottom: 200px">
	    <span class="w3-text-white w3-hide-small" style="font-size:150px"><b>PIZZAHOT</b></span>
	    <span class="w3-text-white w3-hide-large w3-hide-medium" style="font-size:60px;"><b>thin<br>CRUST PIZZA</b></span>
	    <p><a href="Controller?command=menuAll" class="w3-button w3-xxlarge w3-black">Let me see the menu</a></p>
  	</div>
	</div>
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>