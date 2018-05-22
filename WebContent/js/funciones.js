function myFunction() {
	tipoCliente = document.getElementById('tipoCliente').value;
	if (tipoCliente == 'interno') {
		document.getElementById('antiguedad').style = 'display:block;';
		document.getElementById('antiguedadLbl').style = 'display:block;';
		document.getElementById('antiguedad').setAttribute('required', 'true');

		document.getElementById('codigoEmp').style = 'display:block;';
		document.getElementById('codigoEmpLbl').style = 'display:block;';
		document.getElementById('codigoEmp').setAttribute('required', 'true');

		document.getElementById('entidadLabora').removeAttribute('required');
		document.getElementById('entidadLabora').style = 'display:none;';
		document.getElementById('entidadLaboraLbl').style = 'display:none;';

	} else {
		document.getElementById('antiguedad').removeAttribute('required');
		document.getElementById('antiguedad').style = 'display:none;';
		document.getElementById('antiguedadLbl').style = 'display:none;';

		document.getElementById('codigoEmp').removeAttribute('required');
		document.getElementById('codigoEmp').style = 'display:none;';
		document.getElementById('codigoEmpLbl').style = 'display:none;';

		document.getElementById('entidadLabora').setAttribute('required',
				'true');
		document.getElementById('entidadLabora').style = 'display:block;';
		document.getElementById('entidadLaboraLbl').style = 'display:block;';
	}

}

var modal = document.getElementById('myModal');
var span = document.getElementsByClassName("close")[0];


function cambiarCondiciones() {

	document.getElementById('montoSolicitado').removeAttribute('disabled');
	document.getElementById('plazo').removeAttribute('disabled');
	document.getElementById('btnEnviarEstudio').removeAttribute('disabled');
	document.getElementById('tipoCredito').removeAttribute('disabled');

}

span.onclick = function() {
	modal.style.display = "none";
}
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}

function clearEstado() {
	document.getElementById('estado').value = null;
	a = document.getElementById('estado').value;
}
