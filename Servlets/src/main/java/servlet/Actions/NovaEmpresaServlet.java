package servlet.Actions;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Model.Banco;
import servlet.Model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/new-empresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--- Cadastrando uma nova empresa ---");
		Banco banco = new Banco();
		banco.adicionaEmpresa(criaEmpresa(request));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("new-empresa-success.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private Empresa criaEmpresa(HttpServletRequest request) throws ServletException {
		Empresa empresa = new Empresa();
		empresa.setNome(request.getParameter("nome"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			empresa.setDataAbertura(format.parse(request.getParameter("dataAbertura")));
			System.out.println(empresa.getDataAbertura());
		} catch (Exception e) {
			throw new ServletException(e);
		}
		request.setAttribute("nomeEmpresa", empresa.getNome());
		return empresa;
	}

}
