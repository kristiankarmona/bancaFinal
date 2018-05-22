package logica;

import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import entidades.Credito;
import entidades.CreditoHipotecario;
import entidades.CreditoLibreInversion;
import persistencia.PersistenciaCredito;

public class GestionarCredito {
	
	public void guardarCreditoHipotecario(double tasaMensual,long montoAprobado, long saldo, String estado, int plazoMeses, int mesesPagados, Cliente cliente) {
		Credito creditoHipotecario= new CreditoHipotecario(tasaMensual, montoAprobado, saldo, estado, plazoMeses, mesesPagados, cliente);
		PersistenciaCredito.setCredito(creditoHipotecario);
	}

	public void guardarCreditoLibreInversion(double tasaMensual,long montoAprobado, long saldo, String estado, int plazoMeses, int mesesPagados, Cliente cliente) {
		Credito creditoLibreInversion= new CreditoLibreInversion(tasaMensual, montoAprobado, saldo, estado, plazoMeses, mesesPagados, cliente);
		PersistenciaCredito.setCredito(creditoLibreInversion);
	}
	
	public Credito obtenerCreditoXCedula (long cedula) {
		Credito creditoSolicitado = null;
		for (Credito creditoIterado : PersistenciaCredito.getCreditos()) {
			
			if (creditoIterado.getCliente().getIdentificacion()==cedula) {
			creditoSolicitado = creditoIterado;
			break;
			}
			System.out.println("fin iteracion");
		}
		return creditoSolicitado;
	}
	
	public List<Credito> getCreditos(){
		List<Credito> creditos = null;
		creditos=PersistenciaCredito.getCreditos();
		return creditos;
	}
	
}
