<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Bienvenido a me sumo</title>
<link rel=stylesheet href="css/bootstrap-theme.css" type="text/css">
<link rel=stylesheet href="css/bootstrap-theme.css.map" type="text/css">
<link rel=stylesheet href="css/bootstrap-theme.min.css" type="text/css">
<link rel=stylesheet href="css/bootstrap-theme.min.css.map" type="text/css">
<link rel=stylesheet href="css/bootstrap.css" type="text/css">
<link rel=stylesheet href="css/bootstrap.css.map" type="text/css">
<link rel=stylesheet href="css/bootstrap.min.css" type="text/css">
<link rel=stylesheet href="css/bootstrap.min.css.map" type="text/css">
<link rel=stylesheet href="css/misestilos.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Concert+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/functions.js"></script>

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
	<div class="container-fluid">
		<div class="jumbotron ms-cartel-entrada">
			<h3 class="ms-roboto">¿Sos jubilado? ¿Querés ayudar con tu tiempo a personas que te necesitan?</h3>
			<h2>Hacé click <a>acá</a> y conoce todas las oportunidades que hay para vos</h2>
			
		</div>
		<div class="row ms-col-container">
			<div class="col-xs-8 ms-bd-rg">
				<div>
					<h2>¿Trabaj&aacute;s en un hospital?</h2>
					<div class="ms-pd-left">
						<h4>Cre&aacute; una cuenta en <span class="ms-nombre-mesumo">mesumo</span> <br>y contactate con mucha gente que quiere ayudar</h4>
						<button id="botonCrearCuenta" class="btn btn-lg btn-default ms-mg-top">Creá tu cuenta</button>
					</div>
				</div>
			</div>
			<div class="col-xs-4 ms-ingreso">
				<div class="form-group">
					<s:form action="Validar">
						<label>Nombre de usuario</label>
						<s:textfield cssClass="form-control ms-forminput" name="userlogin" />
						<label>Contraseña</label>
						<s:password cssClass="form-control ms-forminput" name="userpwd" />
						<s:submit cssClass="form-control btn btn-success" value="Entrar" />
					</s:form>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>