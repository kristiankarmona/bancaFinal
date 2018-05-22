package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.ClienteExterno;
import entidades.ClienteInterno;
import logica.GestionarCliente;

/**
 * Servlet implementation class ConsultarCliente
 */
@WebServlet("/ConsultarClienteServlet")
public class ConsultarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarClienteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long cedula= Long.parseLong(request.getParameter("ident"));
		GestionarCliente gestion = new GestionarCliente();
		Cliente cliente = gestion.obtenerClienteXCedula(cedula);
		
		if (cliente!=null) {
			//envio de atributos a la vista
			//atributos comunes
			request.setAttribute("existeCliente", "true");
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("ident", cliente.getIdentificacion());
			request.setAttribute("edad", cliente.getEdad());
			request.setAttribute("salario", cliente.getSalario());
			//atributos particulares para Cliente externo
			if (cliente instanceof ClienteExterno) {
				request.setAttribute("entidadLabora", ((ClienteExterno) cliente).getEntidadDondeLabora());
				request.setAttribute("tipoCliente", "externo");

			} else {//atributos particulares para Cliente interno
				request.setAttribute("antiguedad", ((ClienteInterno) cliente).getAntiguedad());
				request.setAttribute("codigoEmpleado", ((ClienteInterno) cliente).getCodigoEmpleado());
				request.setAttribute("tipoCliente", "interno");
			} 
		}else {
			request.setAttribute("existeCliente", "false");
		}
		//atributos particulares para Cliente interno
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/solicitarCredito.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
