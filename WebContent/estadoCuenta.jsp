<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="entidades.Credito"%>
<%@ page import="entidades.Cliente"%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilos.css">
<title>Insert title here</title>
</head>
<body onload="myFunction3()">
	<div style="text-align: center">
		<svg width="640" height="150" xmlns="http://www.w3.org/2000/svg"
			xmlns:svg="http://www.w3.org/2000/svg">
       <!-- Created with SVG-edit - http://svg-edit.googlecode.com/ -->

       <g>
        <title>Layer 1</title>
        <text stroke="#000000"
				transform="matrix(3.6378378868103027,0,0,3.8461537361145015,-110.71216477453706,-228.9999928474426) "
				xml:space="preserve" text-anchor="middle" font-family="serif"
				font-size="24" id="svg_1" y="83.91999" x="116.49777"
				stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null"
				stroke-width="0" fill="#7f0000">Banca Final</text>
        <path id="svg_13"
				d="m293.33334,102.66667c-120,105.33333 -269.33334,-76 -269.33334,-77.33334c0,-1.33333 -1.33333,88 6.66667,76"
				stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null"
				stroke-width="0" stroke="#000000" fill="#7f0000" />
       </g>
      </svg>
	</div>

	<form action=EstadoCuenta method="post">

		<table align="center">
			<tr>
				<td>
					<h1>Estado Cuenta</h1>
				</td>
			</tr>

			<tr>
				<td><label for="Capital Incial">Capital Inicial</label></td>
				<td><input type="number" name="capitalInicial"
					value="${requestScope['capitalInicial']}" readonly></td>
			</tr>

			<tr>
				<td><label for="capital">Capital</label></td>
				<td><input type="number" name="capital"
					value="${requestScope['capital']}" readonly></td>
			</tr>

			<tr>
				<td><label for="saldoPorCobrar">Saldo por cobrar</label></td>
				<td><input type="number" name="saldoPorCobrar"
					value="${requestScope['saldoPorCobrar']}" readonly></td>
			</tr>


			<tr>
				<td><label for="capital">Perdidas</label></td>
				<td><input type="number" name="perdidas"
					value="${requestScope['perdidas']}" readonly></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div>
						<input type="button" name="" value="   Volver    "
							onclick="location.href='index.html';">
					</div>
				</td>
			</tr>

		</table>








		<h1  class="titulo1">Creditos Activos:</h1>
		<table align="center" class="tablebonita">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Monto Aprobado</th>
					<th>Estado</th>
					<th>Saldo</th>
					<th>Cuota</th>
				</tr>
			<thead>
				<c:forEach items="${creditosActivos}" var="credito">
					<tr>
						<td>${credito.getCliente().getNombre()}</td>
						<td>${credito.getMontoAprobado()}</td>
						<td>${credito.getEstado()}</td>
						<td>${credito.getSaldo()}</td>
						<td>${credito.getCuota()}</td>
					</tr>
				</c:forEach>
		</table>
		<br>
		<br>		
		
		<h1 class="titulo1">Creditos Finalizados:</h1>
		<table align="center" class="tablebonita">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Monto Aprobado</th>
					<th>Estado</th>
					<th>Saldo</th>
					<th>Cuota</th>
				</tr>
			<thead>
				<c:forEach items="${creditosFinalizados}" var="credito">
					<tr>
						<td>${credito.getCliente().getNombre()}</td>
						<td>${credito.getMontoAprobado()}</td>
						<td>${credito.getEstado()}</td>
						<td>${credito.getSaldo()}</td>
						<td>${credito.getCuota()}</td>
					</tr>
				</c:forEach>
		</table>
		<br>
		<br>		
		<h1 class="titulo1">Creditos Castigados:</h1>
		<table align="center" class="tablebonita">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Monto Aprobado</th>
					<th>Estado</th>
					<th>Saldo</th>
					<th>Cuota</th>
				</tr>
			<thead>
				<c:forEach items="${creditosAPerdida}" var="credito">
					<tr>
						<td>${credito.getCliente().getNombre()}</td>
						<td>${credito.getMontoAprobado()}</td>
						<td>${credito.getEstado()}</td>
						<td>${credito.getSaldo()}</td>
						<td>${credito.getCuota()}</td>
					</tr>
				</c:forEach>
		</table>	





	</form>
	<script src="js/funciones.js"></script>

	<script>
function myFunction3() {
	if ("${requestScope['creacionExitosa']}" == 'true') {
		modal.style.display = "block";
	}
}

</script>

</body>
</html>
