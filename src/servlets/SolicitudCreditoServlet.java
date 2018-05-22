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
import entidades.Credito;
import entidades.CreditoHipotecario;
import entidades.CreditoLibreInversion;
import logica.GestionarCliente;
import logica.GestionarCredito;
import java.io.PrintWriter;
/**
 * Servlet implementation class SolicituCredito
 */
@WebServlet("/SolicituCreditoServlet")
public class SolicitudCreditoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final double TASA_HIPOTECARIO = 0.7;
	private static final double TASA_LIBRE_INVERSION= 1.8;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudCreditoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			StringBuffer mensajesNegacion = new StringBuffer();
			
			//validaciones
			
			long identificacion = Long.parseLong(request.getParameter("ident2"));
			String nombre = request.getParameter("nombre");
			int edad = Integer.parseInt(request.getParameter("edad"));
			long salario = Long.parseLong(request.getParameter("salario"));
			String tipoCredito = request.getParameter("tipoCredito");
			String tipoCliente = request.getParameter("tipoCliente");
			int plazo = Integer.parseInt(request.getParameter("plazo"));
			long montoSolicitado = Long.parseLong(request.getParameter("montoSolicitado"));
			
			Credito credito = null;
			
			GestionarCliente gestion = new GestionarCliente();
			Cliente cliente = gestion.obtenerClienteXCedula(identificacion);
			
			if (tipoCredito.equals("hipotecario")) {
				
				
					credito = new CreditoHipotecario(TASA_HIPOTECARIO,montoSolicitado,montoSolicitado,"Solicitado",plazo,0,cliente);
					
			}else	
				if (tipoCredito.equals("libreInversion")) {
					credito = new CreditoLibreInversion(TASA_LIBRE_INVERSION,montoSolicitado,montoSolicitado,"Solicitado",plazo,0,cliente);
				
				}
	
				//polimorfismo
				boolean cumpleEdad= credito.validarEdad(edad);
				boolean cumpleSalario = credito.validarSalario(salario);
				long cuota = credito.calculaCuota(montoSolicitado, plazo);
				boolean cumplePeriodo= credito.validaPeriodo(plazo);
				boolean cumpleCuota = credito.validarCuota(cuota,salario);
				boolean cumpleCapital = credito.validaCapital(montoSolicitado);
				
				//datos para primera columna de tabla
				request.setAttribute("ident", identificacion);
				request.setAttribute("nombre", nombre);
				request.setAttribute("edad", edad);
				request.setAttribute("salario", salario);
				
				if (tipoCliente.equals("interno")) {
					request.setAttribute("antiguedad", request.getParameter("antiguedad"));
					request.setAttribute("codigoEmpleado", request.getParameter("codigoEmpleado"));
					request.setAttribute("tipoCliente", "interno");
				}else {
					request.setAttribute("entidadLabora", request.getParameter("entidadLabora"));
					request.setAttribute("tipoCliente", "externo");
					
				}
				//datos para segunda columna de tabla
				request.setAttribute("montoSolicitado", montoSolicitado);
				request.setAttribute("plazo", plazo);
				request.setAttribute("tipoCredito", tipoCredito);
				

				
			if(cumpleEdad && cumpleSalario && cumpleCuota && cumplePeriodo && cumpleCapital)
			{
				if (request.getParameter("estado")== null || "".equals(request.getParameter("estado"))) {
					request.setAttribute("estado", "Aprobado");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/solicitarCredito.jsp");
					dispatcher.forward(request, response);
				}else {
					try {
						//Persistencia de objeto
						GestionarCredito gestionCredito = new GestionarCredito();
						if (tipoCredito.equals("hipotecario")) {
							gestionCredito.guardarCreditoHipotecario(TASA_HIPOTECARIO, montoSolicitado, montoSolicitado,
									"Otorgado", plazo, 0, cliente);
						} else if (tipoCredito.equals("libreInversion")) {
							gestionCredito.guardarCreditoLibreInversion(TASA_LIBRE_INVERSION, montoSolicitado,
									montoSolicitado, "Otorgado", plazo, 0, cliente);

						} 
						response.setContentType("text/html");
						response.setCharacterEncoding("utf-8");
						PrintWriter pw = response.getWriter();
						pw.println("<html>");
						pw.println("  <head>");
						pw.println("    <meta charset=\"utf-8\">");
						pw.println("    <title>Banca Final</title>");
						pw.println("    <style media=\"screen\">");
						pw.println("    a.button {");						
						pw.println("        -webkit-appearance: button;");
						pw.println("        -moz-appearance: button;");
						pw.println("        appearance: button;");
						pw.println("");
						pw.println("        text-decoration: none;");
						pw.println("        color: initial;");
						pw.println("    }");
						pw.println("		</style>");
						pw.println("  </head>");
						pw.println("  <body>");
						pw.println("    <div style=\"text-align:center\">");
						pw.println("      <svg width=\"640\" height=\"150\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:svg=\"http://www.w3.org/2000/svg\">");
						pw.println("       <!-- Created with SVG-edit - http://svg-edit.googlecode.com/ -->");
						pw.println("");
						pw.println("       <g>");
						pw.println("        <title>Layer 1</title>");
						pw.println("        <text stroke=\"#000000\" transform=\"matrix(3.6378378868103027,0,0,3.8461537361145015,-110.71216477453706,-228.9999928474426) \" xml:space=\"preserve\" text-anchor=\"middle\" font-family=\"serif\" font-size=\"24\" id=\"svg_1\" y=\"83.91999\" x=\"116.49777\" stroke-linecap=\"null\" stroke-linejoin=\"null\" stroke-dasharray=\"null\" stroke-width=\"0\" fill=\"#7f0000\">Banca Final</text>");
						pw.println("        <path id=\"svg_13\" d=\"m293.33334,102.66667c-120,105.33333 -269.33334,-76 -269.33334,-77.33334c0,-1.33333 -1.33333,88 6.66667,76\" stroke-linecap=\"null\" stroke-linejoin=\"null\" stroke-dasharray=\"null\" stroke-width=\"0\" stroke=\"#000000\" fill=\"#7f0000\"/>");
						pw.println("       </g>");
						pw.println("      </svg>");
						pw.println("    </div>");
						pw.println("<div style=\"text-align:center;\">");
						pw.println("  <table align=\"center\">");
						pw.println("	<tr>");
						pw.println("		<h1>Creacion Exitosa del Credito</h1>");
						pw.println("	</tr>");
						pw.println("    <tr>");
						pw.println("      <td> <input type=\"button\" value=\"Volver\" onclick=\"location.href='index.html';\"> </td>");
						pw.println("    </tr>");
						pw.println("  </table>");
						pw.println("</div>");
						pw.println("</body>");
						pw.println("</html>");
						
					} catch (Exception e) {
						System.out.println("Error al persistir el Credito debido a:");
						e.printStackTrace();
					}
				}
			}else
			{
				
				//asignacion Mensajes Negacion
				mensajesNegacion.append(cumpleEdad?"": "-No Cumple con la Edad minima \n");
				mensajesNegacion.append(cumpleSalario?"": "-No Cumple con el salario minimo \n");
				mensajesNegacion.append(cumplePeriodo?"": "-No Cumple con el periodo maximo \n");
				mensajesNegacion.append(cumpleCuota?"": "-No Cumple con las politicas de cuota \n");
				mensajesNegacion.append(cumpleCapital?"": "-Se nos acabo el dinero  \n");
				
				request.setAttribute("estado", "Negado");
				request.setAttribute("causasNegacion", mensajesNegacion);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/solicitarCredito.jsp");
				dispatcher.forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
