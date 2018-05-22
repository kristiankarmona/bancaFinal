package entidades;

public class ClienteInterno extends Cliente{
	
	private String codigoEmpleado;
	private int antiguedad;

	public ClienteInterno(long identificacion, String nombre, int edad, long salario, String codigoEmpleado,
			int antiguedad) {
		super(identificacion, nombre, edad, salario);
		this.codigoEmpleado = codigoEmpleado;
		this.antiguedad = antiguedad;
	}
	
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	

}
