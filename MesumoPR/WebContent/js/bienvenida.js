$(function() {
	
	var paginaEnReady =  parseInt($("#paginaActual").val());
	categoriaElegida = null;
	traerDatos($("#rutaLista").val(),null,paginaEnReady);
	
	
	$(".catButton").on("click", function(event){
		categoriaElegida = $(this).data("cat");
		traerDatos( $("#listarPorCategoria").val() , categoriaElegida,1);
		//cuando se cambia la categoria se empieza por la primera pagina
	});
	
	$("#mesumologo").on("click", function(event){
		window.location.href = "ingreso.jsp";
	});
	
	$(document).on("click",".ms-card", function(event){
		var href = $(this).find("a.fa-sign-in").attr("href");
		window.location.href = href;
	});
	
	$(document).on("click","#paginadorContainer .pageNumber", function(event){
		var pagina = parseInt($(this).text());
		$("#paginaActual").val(pagina);
		var ruta= "";
		if (categoriaElegida != null){
			ruta = $("#listarPorCategoria").val();
		}else {
			ruta = $("#rutaLista").val();
		}
		traerDatos(ruta,categoriaElegida,pagina);
	});
});

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
	var html = "";
	$(data.listaBusquedas).each(function( index, elem ) {
		var l1 = '<div class="ms-card" data-id="'+ elem.id +'">';
		var l2 = '<div class="row">';
		var l3 = '<div class="col-xs-10">';
		var l4 = '<h4>' + elem.titulo +'</h4>';
		var l5 = '<p>' + elem.descripcion +'</p>';traerBusqueda
		var l6 = '</div>';
		var l7 = '<div class="col-xs-2 ms-card-options">';
		var l8 = '<a class="fa fa-lg fa-sign-in" href="'+ ruta + '?busq.id=' + elem.id+'&requester='+ 0 +'"></a>';
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
