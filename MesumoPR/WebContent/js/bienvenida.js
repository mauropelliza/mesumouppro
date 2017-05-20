$(function() {
	$.ajax({
        type: 'POST',
        url: $("#rutaLista").val(),
        dataType: 'json',
        success: actualizarLista
    });
	
	$(".catButton").on("click", function(event){
		idcategoria = $(this).data("cat");
		var ir = $("#listarPorCategoria").val() + "?busq.idcategoria=" + idcategoria;
		$.ajax({
	        type: 'POST',
	        url: ir,
	        dataType: 'json',
	        success: actualizarLista
	    });
		
	});
	
	$(document).on("click",".ms-card", function(event){
		var href = $(this).find("a.fa-sign-in").attr("href");
		window.location.href = href;
	});
});

function actualizarLista(data){
	var ruta = $("#traerBusqueda").val();
	
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
		var l9 = '</div>';
		var l10 = '</div>';
		var l11 = '</div>';
		html += l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 + l11;
	});
	
	$("#lista").html(html);
}
