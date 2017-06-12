<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tu cuenta</title>
		<%@include file="rutas.jsp" %>
		<script type="text/javascript" src="js/detalle.js"></script>
	</head>
	
	<body> 
		<%@include file="header.jsp" %>
		<div class="container-fluid ms-cuerpoPagina">
			<div class="row">
				<div class="col-xs-8">
					<button class="btn btn-default" id="botonVolver">Volver</button>
					
					<input type="hidden" value="<s:property value="busq.id" />">
					<div class="panel panel-default" id="ms-panel-detalle">
					    <div class="panel-heading"><h3><s:property value="busq.titulo" /></h3></div>
					    <div class="panel-body">
							<h4><s:property value="busq.descripcion" /></h4>
	<%-- 								<h5><s:property value="busq.descripcion" /></h5> --%>
	<%-- 								<p><s:property value="usuario.idcategoria" /></p> --%>
	<%-- 								<p><s:property value="busq.idusuario" /></p> --%>
							<br/>
							<h3>Informaci&oacute;n de contacto:</h3>
							<p><span class="ms-bld">Instituci&oacute;n: </span><s:property value="usuario.hnombre" /></p>
							<p><span class="ms-bld">Direcci&oacute;n: </span><s:property value="usuario.hdireccion" /></p>
							<p><span class="ms-bld">Tel&eacute;fono: </span><s:property value="usuario.htelefono" /></p>
							<p><span class="ms-bld">Correo electr&oacute;nico: </span><s:property value="usuario.hemail" /></p>
						
						</div>
					    <div class="panel-footer">
					    	<h5>Publicado el: <s:property value="busq.fechapublicacionForm" /></h5>
					    </div>
<!-- 					    <button class="btn btn-success pull-right" style="visibility:hidden">Contactar</button> -->
					</div> 		
				</div>
				<div class="col-xs-4"></div>
				<input id="requesterId" type="hidden" value="<s:property value="requester" />" />
			</div>
		</div>
	</body>
</html>