package servlets;

import javax.servlet.ServletContextListener;

import entidades.Banco;
import logica.GestionarCliente;
import logica.GestionarCredito;

import javax.servlet.ServletContextEvent;

public class MyServletContextListener implements ServletContextListener{
	
   public static long CAPITAL = 2000000000;
   public static long SALDO_POR_COBRAR = 0;
   public static long PERDIDA = 0;

   @Override
   public void contextInitialized(ServletContextEvent contextEvent) {
	   
	    Banco banco = Banco.instanciarSoloUnaVezBanco(CAPITAL, SALDO_POR_COBRAR, PERDIDA);

	    GestionarCliente g = new GestionarCliente();
		g.guardarClienteInterno(75098263,"Cristian Carmona",36,3800000,"343434",9);
		g.guardarClienteInterno(12345,"Juan",36,3800000,"343434",9);
		g.guardarClienteInterno(46543,"Pedro",37,3800000,"343434",9);
		g.guardarClienteInterno(986453,"Carmen",38,3800000,"343434",9);
		g.guardarClienteInterno(1837454645,"Julia",39,3800000,"343434",9);
		g.guardarClienteInterno(5555,"gloria",34,6800000,"222",7);
		
		
		GestionarCredito gc = new GestionarCredito();
		
		gc.guardarCreditoHipotecario(1.8, 140000000, 140000000, "Otorgado", 4, 0, g.obtenerClienteXCedula(75098263));
		banco.setCapital(banco.getCapital()-140000000);
		banco.setSaldoPorCobrar(banco.getSaldoPorCobrar()+140000000);
		
		gc.guardarCreditoHipotecario(1.8, 25000000, 25000000, "Otorgado", 3, 0, g.obtenerClienteXCedula(12345));
		banco.setCapital(banco.getCapital()-25000000);
		banco.setSaldoPorCobrar(banco.getSaldoPorCobrar()+25000000);
		
		gc.guardarCreditoHipotecario(1.8, 111000000, 111000000, "Otorgado", 5, 0, g.obtenerClienteXCedula(46543));
		banco.setCapital(banco.getCapital()-111000000);
		banco.setSaldoPorCobrar(banco.getSaldoPorCobrar()+111000000);
		
		gc.guardarCreditoHipotecario(1.8, 123000000, 123000000, "Otorgado", 6, 0, g.obtenerClienteXCedula(986453));
		banco.setCapital(banco.getCapital()-123000000);
		banco.setSaldoPorCobrar(banco.getSaldoPorCobrar()+123000000);
		
		gc.guardarCreditoHipotecario(1.8, 350000000, 350000000, "Otorgado", 7, 0, g.obtenerClienteXCedula(1837454645));	   
		banco.setCapital(banco.getCapital()-350000000);
		banco.setSaldoPorCobrar(banco.getSaldoPorCobrar()+350000000);
	   
		gc.guardarCreditoLibreInversion(1.8, 140000000, 140000000, "Otorgado", 8, 0, g.obtenerClienteXCedula(5555));	   
		banco.setCapital(banco.getCapital()-140000000);
		banco.setSaldoPorCobrar(banco.getSaldoPorCobrar()+140000000);

		
		
        
        banco.start();
   }

   @Override
   public void contextDestroyed(ServletContextEvent contextEvent) {
        /* Do Shutdown stuff. */
   }

}