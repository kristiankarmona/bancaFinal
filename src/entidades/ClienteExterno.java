package entidades;

public class ClienteExterno extends Cliente {
	

	public ClienteExterno(long identificacion, String nombre, int edad, long salario, String entidadDondeLabora) {
		super(identificacion, nombre, edad, salario);
		this.entidadDondeLabora = entidadDondeLabora;
	}

	private String entidadDondeLabora;
	
	public String getEntidadDondeLabora() {
		return entidadDondeLabora;
	}

	public void setEntidadDondeLabora(String entidadDondeLabora) {
		this.entidadDondeLabora = entidadDondeLabora;
	}
}
