<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro</title>
</head>
<body>
	Datos de registro:
	<br>
	<br>
	<form class="formulario" action="Checker">
		Nombre:<br>
		<input type="text" name="nombre"><br> Apellido:<br>
		<input type="text" name="apellido"><br> Fecha de
		nacimiento:<br>
		<input type="text" name="nacimiento"><br> DNI:<br>
		<input type="text" name="dni"><br> Contraseña:<br>
		<input type="password" name="passwd"><br>
		<br> <input type="submit" value="submit">
	</form>
</body>
</html>