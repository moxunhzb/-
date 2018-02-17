<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
select{
display:inline-block;
width:50px;
}

</style>
</head>
<body>
    <div id="province"></div>
    <div id="city"></div>
    <div id="text"></div>
</body>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
function loadCities(cityId) {
    $.post("CityJsonServlet", {provinceId:cityId},
              loadCityCallback
          );
}

function loadCityCallback(data) {
	 var data = eval("("+data+")");
	    var cityHTML="";
	    var optionHTML="<select name=\"city\">";
	    for(var i=0;i<data.length;i++){
	        var city = data[i];
	       
	     	optionHTML+="<option value=\""+city.cityId+"\">"+city.cityName+"</option>";
	        cityHTML+="<p><b>"+city.cityName+"</b></p>";
	        cityHTML+="人口:"+city.personSize+",面积:"+city.cityArea+"<br>";
	        cityHTML+="名胜:"+city.place+"<br>";
	        
	    }
	    optionHTML+="</select>";
	    $("#city").html(optionHTML);
	    $("#text").html(cityHTML);
}
        $(document).ready(function(){
        	
            $.post("ProvinceJsonServlet", null,
                function(data){
                    // alert("Data Loaded: " + data);                    
                   var  optionHTML="<select name=\"province\" onchange=\"loadCities(this.value)\">";
                     var data = eval("("+data+")");
                     for(var i=0;i<data.length;i++){
                         var province = data[i];
                         //alert(province.provinceId);
                         optionHTML+="<option value=\""+province.provinceId+"\">"+province.provinceName+"</option>"; 
                     }
                     optionHTML+="</select>";
                     $("#province").html(optionHTML);//将数据填充到省份的下拉列表中
            });
            
        });
</script>
</html>