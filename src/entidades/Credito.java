package entidades;

public abstract class Credito {
	
	private static int EDAD_MINIMA_PARA_CREDITO = 18;
	private static long SALARIO_MINIMO = 781242;
	private static double PORCENTAJE_TOPE_CUOTA = 0.4;
	protected double tasaMensual;
	protected long montoAprobado;
	protected long saldo;
	protected String estado;
	protected int plazoMeses;
	protected int MesesPagados;
	protected Cliente cliente;
	protected long cuota;
	
	
	
	public Credito(double tasaMensual, long montoAprobado, long saldo, String estado, int plazoMeses, int mesesPagados,
			Cliente cliente) {
		super();
		this.tasaMensual = tasaMensual;
		this.montoAprobado = montoAprobado;
		this.saldo = saldo;
		this.estado = estado;
		this.plazoMeses = plazoMeses;
		MesesPagados = mesesPagados;
		this.cliente = cliente;
	}

	//metodos
	public boolean validarEdad(int edad) {
		return (edad>=EDAD_MINIMA_PARA_CREDITO ? true : false);
	}
	
	public boolean validarSalario(long salario) {
		
		return (salario >= SALARIO_MINIMO ? true :false);
	}
	
	public boolean validarCuota(long cuota, long salario) {
		return (cuota <= (salario * PORCENTAJE_TOPE_CUOTA)? true :false);
	}
	
	public boolean validaCapital(Long montoSolicitado) {
		return (Banco.getCapital()>= montoSolicitado);
	}
	
	public abstract boolean validaPeriodo(int plazoSolicitado) ;
	public abstract long calculaCuota(long montoSolicitado, int plazo) ;

	public double getTasaMensual() {
		return tasaMensual;
	}

	public void setTasaMensual(long tasaMensual) {
		this.tasaMensual = tasaMensual;
	}

	public long getMontoAprobado() {
		return montoAprobado;
	}

	public void setMontoAprobado(long montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPlazoMeses() {
		return plazoMeses;
	}

	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}

	public int getMesesPagados() {
		return MesesPagados;
	}

	public void setMesesPagados(int mesesPagados) {
		MesesPagados = mesesPagados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getCuota() {
		return cuota;
	}

	public void setCuota(long cuota) {
		this.cuota = cuota;
	}

}
