package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.GestionarCliente;

/**
 * Servlet implementation class CrearClienteServlet
 */
@WebServlet("/CrearClienteServlet")
public class CrearClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearClienteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long cedula = Long.parseLong(request.getParameter("ident"));
		String nombre= request.getParameter("nombre");
		int edad= Integer.parseInt(request.getParameter("edad"));
		long salario= Long.parseLong(request.getParameter("salario"));
		String tipoCliente = request.getParameter("tipoCliente");
		String entidadLabora= request.getParameter("entidadLabora");
		
		
		GestionarCliente gestion = new GestionarCliente();
		
		if ("externo".equals(tipoCliente)) {
			gestion.guardarClienteExterno(cedula, nombre, edad, salario, entidadLabora);
			request.setAttribute("creacionExitosa", "true");
		}else if("interno".equals(tipoCliente)){ 
			String codigoEmp = request.getParameter("codigoEmp");
			int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
			gestion.guardarClienteInterno(cedula, nombre, edad, salario,codigoEmp,antiguedad );
			request.setAttribute("creacionExitosa", "true");
			
		}else {
			throw new RuntimeException("No se obtuvo parametro requerido");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/crearCliente.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
