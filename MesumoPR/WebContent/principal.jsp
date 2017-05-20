<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tu cuenta</title>
	<link rel=stylesheet href="css/bootstrap-theme.css" type="text/css">
	<link rel=stylesheet href="css/bootstrap-theme.css.map" type="text/css">
	<link rel=stylesheet href="css/bootstrap-theme.min.css" type="text/css">
	<link rel=stylesheet href="css/bootstrap-theme.min.css.map" type="text/css">
	<link rel=stylesheet href="css/bootstrap.css" type="text/css">
	<link rel=stylesheet href="css/bootstrap.css.map" type="text/css">
	<link rel=stylesheet href="css/bootstrap.min.css" type="text/css">
	<link rel=stylesheet href="css/bootstrap.min.css.map" type="text/css">
	<link rel=stylesheet href="css/font-awesome.min.css" type="text/css">
	<link rel=stylesheet href="css/misestilos.css" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Concert+One" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/principal.js"></script>
	

</head>

<body> 
<input type="hidden" id="rutaLista" value="<s:url action="CargarLista" method="cargarLista" />" />
<input type="hidden" id="traerBusqueda" value="<s:url action="traerBusqueda" method="traerDetalle" />" />
<input type="hidden" id="eliminarBusqueda" value="<s:url action="Eliminar" method="borrarAccion" />" />

	<div class="ms-header container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="pull-left ms-header-left">
					<img alt="ME SUMO" class="ms-logo-header" src="img/mesumologo.png">
				</div>
				<div class="pull-right ms-header-right">
					<div class="ms-font-header ms-banner-header">Conectamos <span class="ms-red">hospitales</span> con personas con ganas de <span class="ms-green">ayudar</span></div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid ms-cuerpoPagina">
		<div class="row">
			<div class="col-xs-12">
				<button id="creaBusq" class="btn btn-success btn-md" data-toggle="modal" data-target="#myModal">Cre&aacute; una nueva búsqueda</button>
				<div class="ms-usercard">
<%-- 					<span class="ms-username"><s:property value="usuario" /></span> --%>
					<span class="ms-username">Mauro Pelliza</span>
					<span class="fa fa-user-md ms-usericon"></span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div id="lista">
				
				
				</div>
			</div>
		</div>	
	</div>	
	
	<div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog modal-md">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Cre&aacute; una nueva búsqueda</h4>
	        </div>
	        <div class="modal-body">
				<div id="nuevaBusqForm">
					<div class="form-group">
						<label>T&iacute;tulo</label>
						<s:textfield cssClass="form-control ms-forminput" id="tituloBusqueda"/>
						<label>Descripci&oacute;n</label>
						<s:textarea cssClass="form-control ms-forminput" id="descBusqueda" rows="8"/>
						<label>Categor&iacute;a</label>
						<select id="catSelect" class="form-control">
							<option value="1">Cooperadora</option>
							<option value="2">Mantenimiento</option>
							<option value="3">Informaciones</option>
							<option value="4">Pacientes</option>
			            </select>
					</div>
				</div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" id="cancelarBusqueda" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	          <button type="button" id="enviarBusqueda" class="btn btn-success" data-dismiss="modal">Confirmar</button>
	        </div>
	      </div>
	    </div>
  	</div>
  
</body>
</html>