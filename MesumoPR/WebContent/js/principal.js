$(function() {
	$("#enviarBusqueda").click(function(){
		enviarNuevaBusqueda();
		limpiarModal();
	});
	
	$("#cancelarBusqueda").click(function(){
		limpiarModal();
	});

	$.ajax({
        type: 'POST',
        url: $("#rutaLista").val(),
        dataType: 'json',
        success: actualizarLista
    });
	
	$(document).on("click",".borrarAccion",function(){
		var id = $(this).closest(".ms-card").data("id");
		var rutaBorrar = $("#eliminarBusqueda").val()+ '?busq.id=' + id + "&page=" + parseInt($("#paginaActual").val());
		$.ajax({
	        type: 'POST',
	        url:rutaBorrar,
	        dataType: 'json',
	        success: actualizarLista
	    });
	});
	
	
});

function enviarNuevaBusqueda(){
	//cuando vuelva la lista se carga desde el principio
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



function actualizarLista(data){
	var ruta = $("#traerBusqueda").val();
	// hay que manejar el borrado con un onclick para meterle el numero de pagina
	var html = "";
	$(data).each(function( index, elem ) {
		var l1 = '<div class="ms-card" data-id="'+ elem.id +'">';
		var l2 = '<div class="row">';
		var l3 = '<div class="col-xs-10">';
		var l4 = '<h4>' + elem.titulo +'</h4>';
		var l5 = '<p>' + elem.descripcion +'</p>';traerBusqueda
		var l6 = '</div>';
		var l7 = '<div class="col-xs-2 ms-card-options">';
		var l8 = '<a class="fa fa-lg fa-sign-in" href="'+ ruta + '?busq.id=' + elem.id+ '"></a>';
		l8 += '<a class="fa fa-lg fa-trash borrarAccion"></a>';
		var l9 = '</div>';
		var l10 = '</div>';
		var l11 = '</div>';
		html += l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 + l11;
	});
	
	$("#lista").html(html);
}

function limpiarModal() {
	$("#catSelect option:selected").prop("selected", false);
	$("#myModal input, #myModal textarea").val("");
}