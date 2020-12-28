<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	<div class="w3-bar-block">
	<a href="javascript:void(0)" onclick="openMenu(event, 'Overview');" id="myLink">
        <div class="w3-bar-item w3-button w3-padding">Overview</div>
      </a>
      <a href="javascript:void(0)" onclick="openMenu(event, 'MENU');">
        <div class="w3-bar-item w3-button w3-padding">MENU</div>
      </a>
      <a href="javascript:void(0)" onclick="openMenu(event, 'ABOUT');">
        <div><a href="http://localhost/project_pizzahot/test/demo3.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  ABOUT</a></div>
      </a>
	<!-- <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="http://localhost/project_pizzahot/demo1.jsp" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-users fa-fw"></i>  Overview</a>
    <a href="http://localhost/project_pizzahot/demo2.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i>  MENU</a>
    <a href="http://localhost/project_pizzahot/demo3.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  ABOUT</a>
    <a href="http://localhost/project_pizzahot/demo4.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bullseye fa-fw"></i>  Contact</a>
    <a href="Controller?command=guestAll" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i>  관리자_예약자 관리</a> -->
    <!-- <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell fa-fw"></i>  News</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i>  General</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-history fa-fw"></i>  History</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Settings</a><br><br> -->
    </div>
    <script>
function openMenu(evt, menuName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("menu");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
     tablinks[i].className = tablinks[i].className.replace(" w3-blue", "");
  }
  document.getElementById(menuName).style.display = "block";
  evt.currentTarget.firstElementChild.className += " w3-blue";
  console.log(evt.currentTarget.firstElementChild.className)
}
document.getElementById("myLink").click();
</script>
    
    