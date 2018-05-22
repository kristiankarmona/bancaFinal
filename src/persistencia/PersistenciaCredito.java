package persistencia;

import java.util.List;
import java.util.ArrayList;

import entidades.*;

public class PersistenciaCredito {
	
	private static List<Credito> creditos = new ArrayList<Credito>();

	public static List<Credito> getCreditos() {
		return creditos;
	}

	public static void setCredito(Credito credito) {
		creditos.add(credito);
		
		System.out.println("--------------- Ingresaron un nuevo Credito ahora estos son los creditos actuales: ----------");
		System.out.println("");
		System.out.println("Actualmente existe "+ creditos.size()+" Creditos");
		for (Credito creditoIterado : creditos) {
			
			System.out.println(" -------------     Iteracion Credito       ----------------");
			System.out.println("");
			System.out.println("Credito estado:" + creditoIterado.getEstado());
			System.out.println("Credito meses pagados: " + creditoIterado.getMesesPagados());
			System.out.println("Credito monto aprobado: " + creditoIterado.getMontoAprobado());
			System.out.println("Credito plazo meses: " + creditoIterado.getPlazoMeses());
			System.out.println("Credito saldo: " + creditoIterado.getSaldo());
			System.out.println("Credito cuota: " + creditoIterado.getCuota());
			System.out.println("Credito tasa mensual:" + creditoIterado.getTasaMensual());
			System.out.println("Cliente del Credito Edad : " + creditoIterado.getCliente().getEdad());
			System.out.println("Cliente del Credito Ident : " + creditoIterado.getCliente().getIdentificacion());
			System.out.println("Cliente del Credito Nombre : " + creditoIterado.getCliente().getNombre());
			System.out.println("Cliente del Credito Salario : " + creditoIterado.getCliente().getSalario());
		}
		
	}
}




	

	
	