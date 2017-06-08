<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bienvenido a me sumo</title>
	<%@include file="rutas.jsp" %>
	<script type="text/javascript" src="js/bienvenida.js"></script>	 
</head>
<body>
	<input type="hidden" id="rutaLista" value="<s:url action="BienvenidaLista" method="cargarLista" />" />
	<input type="hidden" id="traerBusqueda" value="<s:url action="traerBusqueda" method="traerDetalle" />" />
	<input type="hidden" id="paginaActual" value="1" />
	<input type="hidden" id="listarPorCategoria" value="<s:url action="ListarPorCategoria" method="cargarListaPorCategoria" />" />
	<%@include file="header.jsp" %>
	<div class="container-fluid" id="ms-bienvenidaContainer">
		<div class="row">
			<div class="col-xs-1">
			</div>
			<div class="col-xs-3">
				<div class="row">
					<h1>Encontrar oportunidades es muy f&aacute;cil</h1>
					<h4>Cliqueá un botón para elegir una categoría en especial</h4>
				</div>
			</div>
			<div class="col-xs-8">
				
				<div class="row ms-col-container">
					<div class="col-xs-12">
						<a data-cat="1" class="ms-action-button catButton shadow ms-animate blue">Cooperadora</a>
					  	<a data-cat="2" class="ms-action-button catButton shadow ms-animate red">Mantenimiento</a>
					  	<a data-cat="3" class="ms-action-button catButton shadow ms-animate green">Informaciones</a>
					  	<a data-cat="4" class="ms-action-button catButton shadow ms-animate orange">Pacientes</a>
				  	</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div id="lista">
				
				
						</div>
						<div id="paginadorContainer">
							<div class="pg-center">
								<div class="pg-pagination">
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>	

		</div>
	</div>
</body>
</html>