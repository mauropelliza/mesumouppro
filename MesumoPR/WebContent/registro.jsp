<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cre&aacute; tu cuenta</title>
	<%@include file="rutas.jsp" %>
	<script type="text/javascript" src="js/functions.js"></script>
</head>

<body>
	<%@include file="header.jsp" %>
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