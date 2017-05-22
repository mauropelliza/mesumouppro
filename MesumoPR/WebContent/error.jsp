<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Parece que hubo un error</title>
		<%@include file="rutas.jsp" %>
	</head>
	<body>
		<%@include file="header.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-2">
				</div>
				<div class="col-xs-2">
					<img alt="error" class="img-responsive" src="recursos/alerta.png">
				</div>
				<div class="col-xs-6">
					<h1>Parece que hubo un error</h1>
				</div>
				<div class="col-xs-2">
				</div>
			</div>
		</div>
	
	</body>
</html>