package servlet.Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Model.Banco;
import servlet.Model.Empresa;

@WebServlet("/mostra-empresa")
public class MostraEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		request.setAttribute("empresa", banco.getEmpresaById(id));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/form-altera-empresa.jsp");
		requestDispatcher.forward(request, response);
	}

}
