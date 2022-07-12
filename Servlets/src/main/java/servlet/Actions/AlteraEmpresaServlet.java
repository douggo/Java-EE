package servlet.Actions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.Model.Banco;
import servlet.Model.Empresa;


@WebServlet("/altera-empresa")
public class AlteraEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaById(getIdEmpresaFromParametro(request));
		empresa.setNome(getNomeFromParametro(request));
		empresa.setDataAbertura(getDataAberturaFromParametro(request));
		response.sendRedirect("lista-empresas");
	}
	
	private Integer getIdEmpresaFromParametro(HttpServletRequest request) {
		String id = request.getParameter("id");
		return Integer.valueOf(id);
	}
	
	private String getNomeFromParametro(HttpServletRequest request) {
		return request.getParameter("nome");
	}
	
	private Date getDataAberturaFromParametro(HttpServletRequest request) throws ServletException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura = null;
		try {
			dataAbertura = format.parse(request.getParameter("dataAbertura")); 
		} catch (Exception e) {
			throw new ServletException(e);
		}
		return dataAbertura;
	}

}
