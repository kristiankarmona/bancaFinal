package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Banco;
import entidades.Credito;
import logica.GestionarCredito;

/**
 * Servlet implementation class EstadoCuenta
 */
@WebServlet("/EstadoCuentaServlet")
public class EstadoCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Credito> creditosActivos = new ArrayList<Credito>();
	private List<Credito> creditosFinalizados = new ArrayList<Credito>();;
	private List<Credito> creditosAPerdida= new ArrayList<Credito>();;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstadoCuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestionarCredito gestionCredito = new GestionarCredito();
		request.setAttribute("capital", Banco.getBanco().getCapital());
		request.setAttribute("capitalInicial", Banco.getBanco().getCapitalInicial());
		request.setAttribute("saldoPorCobrar", Banco.getBanco().getSaldoPorCobrar());
		request.setAttribute("perdidas", Banco.getBanco().getPerdidas());
		
		List<Credito> creditosTemporal;
		creditosActivos.clear();
		creditosAPerdida.clear();
		creditosFinalizados.clear();
		
		
		
		for (Credito credito : gestionCredito.getCreditos()) {
			switch (credito.getEstado()) {
			case "Otorgado":
				creditosActivos.add(credito);
				break;
//			case "Desembolsado":
//				creditosActivos.add(credito);
//				break;
			case "Finalizado":
				creditosFinalizados.add(credito);
				break;
			case "Perdida":
				creditosAPerdida.add(credito);
				break;			
				default:
				break;
			}			
		}
		request.setAttribute("creditosActivos",creditosActivos );
		request.setAttribute("creditosFinalizados",creditosFinalizados );
		request.setAttribute("creditosAPerdida",creditosAPerdida );
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/estadoCuenta.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
