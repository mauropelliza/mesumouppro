<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cre&aacute; tu cuenta</title>
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
		<div class="row">
			<h1 class="col-xs-offset-1">Cre&aacute; tu cuenta ahora, es muy sencilo</h1>
		</div>
		<div class="row">
			<s:form action="Registrarse">
				<div class="col-xs-1">
	
				</div>
				<div class="col-xs-10">
					<div class="row ms-col-container">
						<div class="col-xs-4 ms-ingreso">
							<div class="form-group">
								<h4>Datos de tu cuenta</h4>	
								<label>Nombre de usuario</label>
								<s:textfield cssClass="form-control ms-forminput" name="usuario" />
								<label>Contraseña</label>
								<s:password cssClass="form-control ms-forminput" name="password" />
								<label>Repet&iacute; la contraseña</label>
								<s:password cssClass="form-control ms-forminput" />
							</div>
						</div>
						<div class="col-xs-4 ms-ingreso">
							<div class="form-group">	
								<h4>Datos particulares</h4>
								<label>Nombre</label>
								<s:textfield cssClass="form-control ms-forminput" name="nombre" />
								<label>Apellido</label>
								<s:textfield cssClass="form-control ms-forminput" name="apellido" />
								<label>N&uacute;mero de documento</label>
								<s:textfield cssClass="form-control ms-forminput" name="dni" />
							</div>
						</div>
						<div class="col-xs-4 ms-ingreso">
							<div class="form-group">	
								<h4>Datos de la instituci&oacute;n</h4>
								<label>Nombre del hospital</label>
								<s:textfield cssClass="form-control ms-forminput" name="hnombre" />
								<label>Direcci&oacute;n</label>
								<s:textfield cssClass="form-control ms-forminput" name="hdireccion" />
								<label>Teléfono</label>
								<s:textfield cssClass="form-control ms-forminput" name="htelefono" />
								<label>Correo electr&oacute;nico</label>
								<s:textfield cssClass="form-control ms-forminput" name="hemail" />
								<s:submit cssClass="form-control btn btn-success" value="Confirmar" />
							</div>
						</div>	
					</div>
				</div>	
				<div class="col-xs-1">
	
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>