package logica;

import entidades.*;
import persistencia.PersistenciaCliente;

public class GestionarCliente {
	
	public void guardarClienteExterno(long identificacion, String nombre, int edad, long salario, String entidadDondeLabora) {
		Cliente clienteExterno = new ClienteExterno(identificacion,nombre, edad, salario,entidadDondeLabora);
		PersistenciaCliente.setClientes(clienteExterno);
	
	}

	public void guardarClienteInterno(long identificacion, String nombre, int edad, long salario, String codigoEmpleado,
			int antiguedad) {
		Cliente clienteInterno = new ClienteInterno(identificacion, nombre, edad, salario, codigoEmpleado, antiguedad);
		PersistenciaCliente.setClientes(clienteInterno);
		
	}
	
	public Cliente obtenerClienteXCedula (long cedula) {
		Cliente clienteSolicitado = null;
		for (Cliente clienteIterado : PersistenciaCliente.getClientes()) {
			
			if (clienteIterado.getIdentificacion()==cedula) {
			clienteSolicitado = clienteIterado;
			break;
			}
			System.out.println("fin iteracion");
		}
		return clienteSolicitado;
	}
}
