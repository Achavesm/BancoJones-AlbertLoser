<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Formulario básico</title>
</head>
<style>
	.formulario {
		position:absolute;
		left:50px;
		top:30px;
	}
	.letra {
		width: 14px;
	}
</style>
<body>
	
	<form class="formulario" action="Checker">
		Nombre:<br><input type="text" name="nombre">${errorName}<br>
		Apellido:<br><input type="text" name="apellido">${errorSurname}<br>
		Fecha de nacimiento:<br><input type="text" name="nacimiento">${errorDate}<br>
		NIF:<br><input type="text" name="nif">
		<input class="letra"type="text" name="letra" maxlength="1" value="${letter}">${errorNif}<br>
		DNI:<br><input type="text" name="dni">${errorDni}<br>
		<input type="submit" value="submit">
	</form>
</body>
</html>