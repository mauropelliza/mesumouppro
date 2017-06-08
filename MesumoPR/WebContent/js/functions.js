$(function() {
	$("#botonCrearCuenta").click(function(){
		window.location.href = "registro.jsp";
	});
	
	$("#aca").click(function(){
		window.location.href = "bienvenida.jsp";
	});
	$("#mandarUsuario").submit(function(event){//revisarrrrrrr
		if($("#Registrarse_password").val() != $("#Registrarse_").val()) {
			$("#Registrarse_password").addClass("ms-error");
			$("#Registrarse_").addClass("ms-error");
			event.preventDefault()
		}
	});     
});