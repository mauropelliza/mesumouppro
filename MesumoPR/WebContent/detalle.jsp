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
	<script type="text/javascript" src="js/detalle.js"></script>
	

</head>

<body> 

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
		<div class="col-xs-8">
				<button class="btn btn-default" id="botonVolver">Volver</button>
				<input type="hidden" value="<s:property value="busq.id" />"> 
				<h3><s:property value="busq.titulo" /></h3>
				<h5><s:property value="busq.descripcion" /></h5>
				<p><s:property value="busq.idcategoria" /></p>
				<p><s:property value="busq.idusuario" /></p>
				<p><s:property value="busq.fechapublicacion" /></p>
				<button class="btn btn-success pull-right">Contactar</button>
		</div>
		<div class="col-xs-4"></div>
	</div>
</div>
</body>
</html>