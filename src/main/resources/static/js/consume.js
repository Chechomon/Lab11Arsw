
a= (function (){
	
	var apidata=[];
	
	$(document).ready(function(){
	$.ajax({
		url: "http://localhost:8080/cinema"
	}).then(function(data){
	
		console.log(data);
		for(var i= 0; i < data.length; i++){
			apidata[data[i].name]= data[i];
			
		}
		
		console.log(apidata["CineColombia"]);		
	})
	})
})();