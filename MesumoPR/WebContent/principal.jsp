<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tu cuenta</title>
	<%@include file="rutas.jsp" %>
	<script type="text/javascript" src="js/principal.js"></script>
</head>

<body> 
	<input type="hidden" id="rutaLista" value="<s:url action="CargarLista" method="cargarLista" />" />
	<input type="hidden" id="traerBusqueda" value="<s:url action="traerBusqueda" method="traerDetalle" />" />
	<input type="hidden" id="eliminarBusqueda" value="<s:url action="Eliminar" method="borrarAccion" />" />
	<input type="hidden" id="idusertag" value="<s:property value="#session.usid" />" />
	<input type="hidden" id="paginaActual" value="1" />
	<%@include file="header.jsp" %>
	<div class="container-fluid ms-cuerpoPagina">
		<div class="row">
			<div class="col-xs-12">
				<button id="creaBusq" class="btn btn-success btn-md" data-toggle="modal" data-target="#myModal">Cre&aacute; una nueva búsqueda</button>
				<div class="ms-usercard dropdown"> 
					<div class="dropdown-toggle" data-toggle="dropdown">
						<span class="ms-username"><s:property value="#session.usalias" /></span>
						<span class="fa fa-user-md ms-usericon"></span>
					</div>
					<ul class="dropdown-menu">
			    		<li><a href="<s:url action="Salir" method="logout" />">Salir</a></li>
			  		</ul>
				</div>
				
				
			</div>
		</div>
		<div class="row">
			<div class="col-xs-9">
				<div id="lista">
				
				
				</div>
				<div id="paginadorContainer">
					<div class="pg-center">
						<div class="pg-pagination">
						
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-3">
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