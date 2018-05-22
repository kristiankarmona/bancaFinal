<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilos.css">
<title>Insert title here</title>
</head>
  <body onload="myFunction3()">
    <div style="text-align:center">
      <svg width="640" height="150" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
       <!-- Created with SVG-edit - http://svg-edit.googlecode.com/ -->

       <g>
        <title>Layer 1</title>
        <text stroke="#000000" transform="matrix(3.6378378868103027,0,0,3.8461537361145015,-110.71216477453706,-228.9999928474426) " xml:space="preserve" text-anchor="middle" font-family="serif" font-size="24" id="svg_1" y="83.91999" x="116.49777" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="0" fill="#7f0000">Banca Final</text>
        <path id="svg_13" d="m293.33334,102.66667c-120,105.33333 -269.33334,-76 -269.33334,-77.33334c0,-1.33333 -1.33333,88 6.66667,76" stroke-linecap="null" stroke-linejoin="null" stroke-dasharray="null" stroke-width="0" stroke="#000000" fill="#7f0000"/>
       </g>
      </svg>
    </div>
    
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<p>Creacion Exitosa del Cliente</p>
		</div>

	</div>
    

<form action="CrearClienteServlet" method="post">

  <table align="center">
    <tr>
      <td> <h1>Creacion de Cliente</h1> </td>
    </tr>
    <tr>
      <td>
          <label for="nombre">Nombre Completo</label>
      </td>
      <td>
        <input type="text" name="nombre" required >
      </td>
    </tr>
    <tr>
      <td>
          <label for="ident">Identificacion</label>
      </td>
      <td>
        <input type="number" name="ident" required >
      </td>
    </tr>
    <tr>
      <td>
          <label for="edad">Edad</label>
      </td>
      <td>
        <input type="number" name="edad" required >
      </td>
    </tr>
    <tr>
      <td>
          <label for="salario">Salario</label>
      </td>
      <td>
        <input type="number" name="salario" required >
      </td>
    </tr>
    <tr>
      <td>
          <label for="tipoCliente">Tipo Cliente</label>
      </td>
      <td>
        <select id="tipoCliente" class="" name="tipoCliente" onchange="myFunction()">
          <option value="externo">Externo</option>
          <option value="interno">Interno</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>
          <label for="entidadLabora" id="entidadLaboraLbl">Entidad donde Labora</label>
      </td>
      <td>
        <input type="text" name="entidadLabora" id="entidadLabora" required >
      </td>
    </tr>
    <tr>
      <td>
          <label id="codigoEmpLbl" for="codigoEmp" style='display:none;'>Codigo Empleado</label>
      </td>
      <td>
        <input type="text" id="codigoEmp" name="codigoEmp" style='display:none;'>
      </td>
    </tr>
    <tr>
      <td>
          <label for="antiguedad" id="antiguedadLbl" style='display:none;'>Antiguedad en  años</label>
      </td>
      <td>
        <input type="number" id="antiguedad" name="antiguedad" style='display:none;'>
      </td>
    </tr>
    <tr>
      <td> </td>
      <td>
        <div>
          <input type="submit" name="" value="Crear Cliente">
          <input type="button" name="" value="   Volver    " onclick="location.href='index.html';">
        </div>
      </td>
    </tr>
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
