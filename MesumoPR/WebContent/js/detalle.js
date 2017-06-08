$(function() {
	$("#botonVolver").click(function(){
		if(parseInt($("requesterId").val()) == 1){
			window.location.href = "principal.jsp";
		}else {
			window.location.href = "bienvenida.jsp";
		}
	});
	
	$("#mesumologo").on("click", function(event){
		window.location.href = "ingreso.jsp";
	});
});