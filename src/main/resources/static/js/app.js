
app=(function(){
	
	
	var buscar=function(param){
		var tabla = $("#funcionesTabla");
		var tableHeaderRowCount = 1;
		var table = document.getElementById('funcionesTabla');
		var rowCount = table.rows.length;
		for (var i = tableHeaderRowCount; i < rowCount; i++) {
		    table.deleteRow(tableHeaderRowCount);
		}
		
		
		for(var i = 0; i < param[0].functions.length; i++){
			var totalAsientos=0;
			var sillas="";
			for (var k=0; k< param[0].functions[i].seats.length; k++){
					totalAsientos+=param[0].functions[i].seats[k].length;
					sillas+="<tr>";
					for(var j=0; j<param[0].functions[i].seats[k].length; j++){
						if(param[0].functions[i].seats[k][j]== false ){
							sillas+="<td><img src='js/img/asientoNoDisponible.png' id='disponible' width='30' height='30'> </img></td>";
						}else{
						 sillas+="<td><img src='js/img/asientoDisponible.png' id='disponible' width='30' height='30'> </img></td>";
							}
						}				
					sillas+="</tr>";
				}
			tabla.append("<tr><td><button name='button' class=btn btn-primary' data-toggle='collapse' data-target='#collapseExample' aria-expanded='false' aria-controls='collapseExample'>Mostrar</button><div class='collapse' id='collapseExample'><div class='card card-body'><table id='asientosTabla' class='table table-striped'><tr></tr>"+sillas+"</table></div></div></td><td>"+param[0].name+"</td><td>"+param[0].functions[i].movie.name+"</td><td>"+param[0].functions[i].date+"</td><td>"+totalAsientos+"</td>")
			
		}
	}

	return{
		getCinema:function(name){
			return api.getCinemaByName(name,buscar);
		}
	}
	
})();

asientos=(function(){
	
	
	var buscar=function(param){
		var tabla = $("#asientosTabla");
		var tableHeaderRowCount = 1;
		var table = document.getElementById('asientosTabla');
		var rowCount = table.rows.length;
		for (var i = tableHeaderRowCount; i < rowCount; i++) {
		    table.deleteRow(tableHeaderRowCount);
		}
		
		
		var sillas="";
		for (var k=0; k< param[0].functions[0].seats.length; k++){	
			sillas+="<tr>";
			for(var j=0; j<param[0].functions[0].seats[k].length; j++){
				if(param[0].functions[0].seats[k][j]== false ){
					sillas+="<td><img src='js/img/asientoNoDisponible.png' id='disponible' width='30' height='30'> </img></td>";
				}else{
				 sillas+="<td><img src='js/img/asientoDisponible.png' id='disponible' width='30' height='30'> </img></td>";
					}
				}				
			sillas+="</tr>";
		}
		
		tabla.append(sillas)
		
	}

	return{
		getAsientos:function(){
			return apimock.getCinemaByName("Cine80",buscar);
		}
	}
	
})();



