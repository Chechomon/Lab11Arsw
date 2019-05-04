api =(function(){

	var apidata=[];
	
	$(document).ready(function(){
	$.ajax({
		url: "http://localhost:8080/cinema"
	}).then(function(data){
	
		for(var i= 0; i < data.length; i++){
			apidata[data[i].name]= [data[i]];
			
		}
	})
	});

	return {
		getCinemaByName:function(name,callback){
			callback(
				apidata[name]
			);
		}
	}	

})();





