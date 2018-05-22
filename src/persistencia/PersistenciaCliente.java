package persistencia;

import java.util.List;
import java.util.ArrayList;
import entidades.*;

public class PersistenciaCliente {
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();
	

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(Cliente cliente) {
		PersistenciaCliente.clientes.add(cliente);

//		for (Cliente a : clientes) {
//			System.out.println("-----------  Informacion Cliente ----------------");
//			System.out.println("edad:"+a.getEdad());
//			System.out.println("identificacion:"+a.getIdentificacion());
//			System.out.println("nombre:"+a.getNombre());
//			System.out.println("salario:"+a.getSalario());
//			
//			if (a instanceof ClienteInterno) {
//				System.out.println("antiguedad:" + ((ClienteInterno) a).getAntiguedad());
//				System.out.println("codigoEmpleado:" + ((ClienteInterno) a).getCodigoEmpleado());
//			}
//		}
		
	}

}
