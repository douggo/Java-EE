package servlet.Actions;


import java.io.IOException;
import java.io.PrintWriter;

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
		
		Empresa empresa = new Empresa();
		empresa.setNome(request.getParameter("nome"));
		
		Banco banco = new Banco();
		banco.adicionaEmpresa(empresa);
		
		String text = String.format("Empresa %s cadastrada com sucesso", empresa.getNome());
		
		PrintWriter out = response.getWriter();
		out.write(text);
	}

}