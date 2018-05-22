<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilos.css">
<title>Solicitud Credito Banca Final</title>
</head>
<body onload="myFunction2()">


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

	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<p>El Cliente Consultado No Existe</p>
		</div>

	</div>
	<form action="ConsultarClienteServlet" method="post">
		<table align="center">
			<tr>
				<td>
					<h1>Solicitud de Credito</h1>
				</td>
			</tr>
			<tr>
				<td><label for="ident">Nro. Identificacion del
						Solicitante</label></td>
				<td><input type="number" name="ident" required></td>
				<td>
				<input type="submit" name="" value="Consultar Cliente">
				<input type="button" name="" value="Volver"
									onclick="location.href='index.html';">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<c:if test="${requestScope['ident'] != null}">
		<form action="SolicituCreditoServlet" method="post">

			<TABLE align="center" border="1">
				<TR>
					<TD>
						<table align="center">
							<tr>
								<td>
									<h3>Informacion del Cliente</h3>
								</td>
							</tr>

							<tr>
								<td><label for="nombre">Nombre Completo</label></td>
								<td><input type="text" name="nombre"
									value="<%=request.getAttribute("nombre")%>" readonly></td>
							</tr>
							<tr>
								<td><label for="ident2">Identificacion</label></td>
								<td><input type="number" name="ident2"
									value="${requestScope['ident']}" readonly></td>
							</tr>
							<tr>
								<td><label for="edad">Edad</label></td>
								<td><input type="number" name="edad"
									value="${requestScope['edad']}" readonly></td>
							</tr>
							<tr>
								<td><label for="salario">Salario</label></td>
								<td><input type="number" name="salario"
									value="${requestScope['salario']}" readonly></td>
							</tr>
							<tr>
								<td><label for="tipoCliente">Tipo Cliente</label></td>
								<td><input type="text" name="tipoCliente"
									value="${requestScope['tipoCliente']}" readonly></td>
							</tr>
							<tr>




								<c:if test="${requestScope['codigoEmpleado'] != null}">
									<td><label id="codigoEmpLbl" for="codigoEmpleado">Codigo
											Empleado</label></td>
									<td><input type="text" id="codigoEmpleado"
										name="codigoEmpleado"
										value="${requestScope['codigoEmpleado']}" readonly></td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${requestScope['antiguedad'] != null}">
									<td><label for="antiguedad" id="antiguedadLbl">Antiguedad
											en años</label></td>
									<td><input type="number" id="antiguedad" name="antiguedad"
										value="${requestScope['antiguedad']}" readonly></td>
								</c:if>
							</tr>
							<tr>
								<c:if test="${requestScope['entidadLabora'] != null}">
									<td><label for="entidadLaboraLbl" id="entidadLaboraLbl">Entidad
											donde labora</label></td>
									<td><input type="number" id="entidadLabora"
										name="entidadLabora" value="${requestScope['entidadLabora']}" readonly></td>
								</c:if>
							</tr>


						</table>

					</TD>
					<TD>
						<table align="center">
							<tr>
								<td>
									<h3>Informacion del Credito</h3>
								</td>
							</tr>

							<tr>
								<td><label for="tipoCredito">TipoCredito</label></td>
								<td><select id="tipoCredito" class="" name="tipoCredito"
									id="tipoCredito">
										<c:if test="${requestScope['tipoCredito'] == null}">
											<option value="libreInversion">Libre Inversion</option>
											<option value="hipotecario">Hipotecario</option>
										</c:if>
										<c:if
											test="${requestScope['tipoCredito'] == 'libreInversion'}">
											<option value="libreInversion" selected>Libre Inversion</option>
											<option value="hipotecario">Hipotecario</option>
										</c:if>
										<c:if test="${requestScope['tipoCredito'] == 'hipotecario'}">
											<option value="libreInversion">Libre Inversion</option>
											<option value="hipotecario" selected>Hipotecario</option>
										</c:if>
								</select></td>
							</tr>
							<tr>
								<c:set var="value" scope="request"
									value="${requestScope['montoSolicitado']}" />
								<td><label for="montoSolicitado">Monto Solicitado</label></td>
								<td><input type="number" name="montoSolicitado"
									id="montoSolicitado"
									value="${not empty value ? value : 'None'}"></td>
							</tr>
							<tr>
								<c:set var="value2" scope="request"
									value="${requestScope['plazo']}" />
								<td><label for="plazo">Plazo en Meses</label></td>
								<td><input type="number" name="plazo" id="plazo"
									value="${not empty value2 ? value2 : 'None'}"></td>
							</tr>
							<tr>
								<td><input type="submit" name="" id="btnEnviarEstudio"
									value="Solicitar Credito" onclick="clearEstado()"><input
									type="button" name="" value="Volver"
									onclick="location.href='index.html';"></td>

							</tr>

						</table>

					</TD>
					<c:if test="${requestScope['estado'] == 'Aprobado'}">
						<TD>
							<table align="center">
								<tr>
									<td>
										<h3>Resultado Solicitud Credito</h3>
									</td>
								</tr>
								<tr>
									<td><label for="estado">Estado: </label> <input
										type="text" name="estado" id="estado"
										value="${requestScope['estado']}" readonly></td>
								</tr>

								<tr>
									<td><h4>Su Credito ha sido aprobado</h4></td>
								</tr>
								<tr>
									<td><input type="submit" name="" value="Tomar Credito" onclick="cambiarCondiciones();"><input
										type="button" name="" value="Rechazar Credito"
										onclick="location.href='index.html';"><input
										type="button" name="" value="Cambiar Condiciones"
										onclick="cambiarCondiciones();"></td>


								</tr>

							</table>

						</TD>
					</c:if>

					<c:if test="${requestScope['estado'] == 'Negado'}">
						<TD>
							<table align="center">
								<tr>
									<td>
										<h3>Resultado Validacion Credito</h3>
									</td>
								</tr>

								<tr>
									<td><label for="estado">Estado: </label> <input
										type="text" name="estado" id="estado"
										value="${requestScope['estado']}" readonly></td>
								</tr>
								<tr>
									<td><h5>Su Credito ha sido negado por las siguientes
											causas:</h5></td>
								</tr>
								<tr>
									<td><textarea rows="4" cols="50">
									${requestScope['causasNegacion']}
								</textarea></td>
								</tr>
								<tr>
									<td><input type="button" name=""
										value="Cambiar Condiciones" onclick="cambiarCondiciones();"></td>

								</tr>

							</table>

						</TD>
					</c:if>

				</TR>
			</TABLE>

		</form>
	</c:if>

<script src="js/funciones.js"></script>

<script >

function myFunction2() {
	if ("${requestScope['existeCliente']}" == 'false') {
		modal.style.display = "block";
	}

	if (("${requestScope['estado']}" == 'Negado')
			|| ("${requestScope['estado']}" == 'Aprobado')) {

		document.getElementById('montoSolicitado').setAttribute('disabled',
				'true');
		document.getElementById('plazo').setAttribute('disabled', 'true');
		document.getElementById('tipoCredito').setAttribute('disabled', 'true');
		document.getElementById('btnEnviarEstudio').setAttribute('disabled',
				'true');
	}

}
</script>



</body>
</html>
