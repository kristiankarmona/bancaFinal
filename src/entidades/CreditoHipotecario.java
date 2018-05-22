package entidades;

public class CreditoHipotecario extends Credito{
	
	private static final int PERIODO_CREDITO_MAXIMO_HIPOTECARIO=60;
	private static double TASA_INCENTIVO = 0.2;
	
	
	
	public CreditoHipotecario(double tasaMensual, long montoAprobado, long saldo, String estado, int plazoMeses,
			int mesesPagados, Cliente cliente) {
		super(tasaMensual, montoAprobado, saldo, estado, plazoMeses, mesesPagados, cliente);
		calculaCuota(montoAprobado, plazoMeses);
	}

	@Override
	public boolean validaPeriodo(int plazoSolicitado) {
		if (plazoSolicitado<= PERIODO_CREDITO_MAXIMO_HIPOTECARIO) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public long calculaCuota(long montoSolicitado, int plazo) {
		
//		R = P [     (i (1 + i)n)       /         ((1 + i)n – 1)-0.2]
//					operando A					operando B
		
//		R = Cuota mensual.
//		P = valor préstamo.
//		i = tasa de interés
//		n = número de periodos.
//		
		double operandoA =  this.getTasaMensual() * (Math.pow((1+this.getTasaMensual()), this.getPlazoMeses())) ;
		double operandoB =  (Math.pow((1+this.getTasaMensual()), this.getPlazoMeses())-1) ;

		this.cuota =(long)(montoSolicitado*((operandoA/operandoB)- TASA_INCENTIVO));
		this.cuota = 100000;
		
		return this.cuota;
	}
}
