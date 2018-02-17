/*dom=document;
var btn=dom.getElementsByClassName("dropdown-toggle");
var bdis=dom.getElementsByClassName("dropdown-menu");
btn[0].addEventListener("click",function(){
	if(bdis[0].style.display=="none"){
		bdis[0].style.display="block";
	}
	else{
		bdis[0].style.display="none";
	}
	
	
	
});*/
$(document).ready(function() {
	$('.dropdown-toggle').click(function(){
		$('.dropdown-menu').fadeToggle();
	});
 });
