$(function() {
	
	var paginaEnReady =  parseInt($("#paginaActual").val());
	traerDatos($("#rutaLista").val(),null,paginaEnReady);
	
	$("#enviarBusqueda").click(function(){
		enviarNuevaBusqueda();
		limpiarModal();
	});
	
	$("#cancelarBusqueda").click(function(){
		limpiarModal();
	});

	$(document).on("click",".borrarAccion",function(){
		var thisPage = parseInt($("#paginaActual").val())
		var id = $(this).closest(".ms-card").data("id");
		//si es el ultimo item de la pagina y no estamos en la primera pagina pide la anterior pagina
		if ( ($("#lista .ms-card").length == 1) &&  thisPage != 1){
			$("#paginaActual").val(thisPage - 1);
		}
		var rutaBorrar = $("#eliminarBusqueda").val()+ '?busq.id=' + id + "&page=" + parseInt($("#paginaActual").val());
		$.ajax({
	        type: 'POST',
	        url:rutaBorrar,
	        dataType: 'json',
	        success: actualizarLista
	    });
	});
	
	$(document).on("click","#paginadorContainer .pageNumber", function(event){
		var pagina = parseInt($(this).text());
		$("#paginaActual").val(pagina);
		var ruta= $("#rutaLista").val();

		traerDatos(ruta,null,pagina);
	});
	
});

function enviarNuevaBusqueda(){
	//cuando vuelva la lista se carga desde el principio así se ve la nueva busqueda
	var categoria = $('#catSelect option:selected').val();
	var idusertag = parseInt($("#idusertag").val());
	$.ajax({
        type: 'POST',
        url:'BusquedaNueva.action?busq.titulo='+ $('#tituloBusqueda').val()+'&busq.descripcion='
        +$('#descBusqueda').val()+'&busq.idcategoria='+categoria+'&busq.idusuario='+idusertag + + "&page=1",
        dataType: 'json',
        success: actualizarLista
    });
	
}
function traerDatos(ruta,categoria,pagina) {
	var url = ruta;
	if (pagina != null) { url += "?page=" + pagina}
	if (categoria != null && pagina != null) {url += "&busq.idcategoria=" + categoria }
	if (categoria != null && pagina == null) {url += "?busq.idcategoria=" + categoria }
	$.ajax({
        type: 'POST',
        url:   url ,
        dataType: 'json',
        success: actualizarLista
    });
}

function actualizarLista(data){
	var ruta = $("#traerBusqueda").val();
	// hay que manejar el borrado con un onclick para meterle el numero de pagina
	var html = "";
	$(data.listaBusquedas).each(function( index, elem ) {
		var l1 = '<div class="ms-card" data-id="'+ elem.id +'">';
		var l2 = '<div class="row">';
		var l3 = '<div class="col-xs-10">';
		var l4 = '<h4>' + elem.titulo +'</h4>';
		var l5 = '<p>' + elem.fechapublicacionForm +'</p>';
		var l6 = '</div>';
		var l7 = '<div class="col-xs-2 ms-card-options">';
		var l8 = '<a class="fa fa-lg fa-sign-in" href="'+ ruta + '?busq.id=' + elem.id+'&requester='+ 1 +'"></a>';
		l8 += '<a class="fa fa-lg fa-trash borrarAccion"></a>';
		var l9 = '</div>';
		var l10 = '</div>';
		var l11 = '</div>';
		html += l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 + l11;
	});
	
	$("#lista").html(html);
	actualizarPaginador(data.ultimaPagina);
}

function actualizarPaginador(maxpag){

	var verde = parseInt($("#paginaActual").val());
    var pag = $("#paginadorContainer .pg-pagination");
    var html = "";
    var i = 0;
    while ( i < parseInt(maxpag)){
    	if ((verde-1) == i){
    		html += '<a class="pageNumber active">'+ (i+1) +'</a>';
    	} else {
    		html += '<a class="pageNumber">'+ (i+1) +'</a>';
    	}
        i++;
    }
    pag.html(html);
}

function limpiarModal() {
	$("#catSelect option:selected").prop("selected", false);
	$("#myModal input, #myModal textarea").val("");
}