package entidades;

import java.util.List;

import logica.GestionarCliente;
import logica.GestionarCredito;
import java.lang.Math;

public class Banco extends Thread {
	
	private static long capitalInicial;
	private static long capital;
	private static long saldoPorCobrar;
	private static long perdidas;
	//para patron singleton
	private static Banco banco;
	private static final int MILISEGUNDOS_QUE_SIMULARAN_UN_MES = 10000;
	private static int NUMERO_DE_MESES_DE_SIMULACION = 10;

	private Banco(long capital,long saldoPorCobrar, long perdidas) {
		this.capital = capital;
		this.saldoPorCobrar = saldoPorCobrar;
		this.perdidas = perdidas;
	}
	
	public static Banco instanciarSoloUnaVezBanco(long capital,long saldoPorCobrar, long perdida) {
		if(banco==null) {
			banco=new Banco(capital,saldoPorCobrar, perdida);
			banco.capitalInicial=capital;
		}else{
            System.out.println("No se puede crear el objeto Banco porque ya existe un objeto de esta clase");
        }
		return banco;
	}
	
	@Override
	public void run() {
		ejecutarPago();
	}
	private void ejecutarPago() {
		
		int contadorDeMesesCorridos =0;
		try {
			do {
				//ejecutar pago
				  //obtener creditos
				//TODO Preguntar a Daimer si esta instanciacion es errada ya que el metodo getCreditos es el mismo para cualquier instancia, ¿deberia ser estatico en clase GestionarCredito?
					GestionarCredito gestionCredito= new GestionarCredito();
					List<Credito> creditos = gestionCredito.getCreditos();
				  //recorrerlos y modificar los atributos del credito que correspondan
					boolean esteCreditoSeraPerdida;
					for (Credito creditoIterado : creditos) {
						
						if (!creditoIterado.getEstado().equals("Perdida")&& !creditoIterado.getEstado().equals("Finalizado")) {
							esteCreditoSeraPerdida = (Math.random() * 100) <= 10 ? true : false;
							if (esteCreditoSeraPerdida) {
								//Acciones de perdida
								System.out.println("Credito a perdida");
								System.out.println("Se sumara a perdidas del banco el saldo de este credito");
								this.perdidas= this.perdidas+creditoIterado.getSaldo();
								System.out.println("se restara a saldo por cobrar el saldo del credito que no pagara");
								this.saldoPorCobrar = this.saldoPorCobrar - creditoIterado.getSaldo();
								creditoIterado.setEstado("Perdida");
								
							} else {
								//Acciones de abono
								this.capital = this.capital+creditoIterado.getCuota();
								creditoIterado.setSaldo(creditoIterado.getSaldo()-creditoIterado.getCuota());
								creditoIterado.setMesesPagados(creditoIterado.getMesesPagados()+1);
								
								if(creditoIterado.getMesesPagados()==creditoIterado.getPlazoMeses()) {
									creditoIterado.setEstado("Finalizado");
								}
								
								System.out.println("---------------------------------------------");
								System.out.println("Meses pagados:"+creditoIterado.getMesesPagados());
								System.out.println("plazo solicitado:"+creditoIterado.getPlazoMeses());
								System.out.println("Credito a abonado");
							} 
						}
												
					}
				  //modificar los atributos del banco que correspondan
				
				//esperar 1 mes simulado
				contadorDeMesesCorridos++;
				System.out.println("------------------------------- ejecucion :"+contadorDeMesesCorridos + " --------------------");
				Thread.sleep(MILISEGUNDOS_QUE_SIMULARAN_UN_MES);
				
			} while (contadorDeMesesCorridos<= NUMERO_DE_MESES_DE_SIMULACION);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static long getCapital() {
		return capital;
	}

	public static void setCapital(long capital) {
		Banco.capital = capital;
	}

	public static long getSaldoPorCobrar() {
		return saldoPorCobrar;
	}

	public static void setSaldoPorCobrar(long saldoPorCobrar) {
		Banco.saldoPorCobrar = saldoPorCobrar;
	}

	public static long getPerdidas() {
		return perdidas;
	}

	public static void setPerdidas(long perdidas) {
		Banco.perdidas = perdidas;
	}

	public static Banco getBanco() {
		return banco;
	}

	public static long getCapitalInicial() {
		return capitalInicial;
	}

	public static void setCapitalInicial(long capitalInicial) {
		Banco.capitalInicial = capitalInicial;
	}
	
}
