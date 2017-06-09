$(function() {
	$("#botonCrearCuenta").click(function(){
		window.location.href = "registro.jsp";
	});
	
	$("#aca").click(function(){
		window.location.href = "bienvenida.jsp";
	});
	$("#formRegistrarse").submit(function(event){
		event.preventDefault();
		if(
			($("#registrarse_password").val() != $("#repetir_password").val())
			|| ( ($("#registrarse_password").val() == "") && ($("#repetir_password").val() == ""))
			){
			$("#registrarse_password").addClass("ms-error");
			$("#repetir_password").addClass("ms-error");
			return false;
		}
	});
	
	$("#registrarse_password,#repetir_password").on("focus", function (){
		$("#registrarse_password").removeClass("ms-error");
		$("#repetir_password").removeClass("ms-error");
	});
});