package entidades;

public class CreditoLibreInversion extends Credito {

	private static final int PERIODO_CREDITO_MAXIMO_LIBRE_INVERSION = 40;

	public CreditoLibreInversion(double tasaMensual, long montoAprobado, long saldo, String estado, int plazoMeses,
			int mesesPagados, Cliente cliente) {
		super(tasaMensual, montoAprobado, saldo, estado, plazoMeses, mesesPagados, cliente);
		calculaCuota(montoAprobado, plazoMeses);

	}

	@Override
	public boolean validaPeriodo(int plazoSolicitado) {
		if (plazoSolicitado <= PERIODO_CREDITO_MAXIMO_LIBRE_INVERSION) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public long calculaCuota(long montoSolicitado, int plazo) {
		// R = P [ (i (1 + i)n) / ((1 + i)n – 1)]
		// operando A operando B

		// R = Cuota mensual.
		// P = valor préstamo.
		// i = tasa de interés
		// n = número de periodos.
		//18946992.60 para plazo 8 y para tasa 1.8 con monto 140.000.000

		double operandoA = this.getTasaMensual() * (Math.pow((1 + this.getTasaMensual()), this.getPlazoMeses()));
		double operandoB = (Math.pow((1 + this.getTasaMensual()), this.getPlazoMeses()) - 1);

		this.cuota = (long) (montoSolicitado * (operandoA / operandoB));
		this.cuota = 100000;
		return this.cuota;

	}

}
