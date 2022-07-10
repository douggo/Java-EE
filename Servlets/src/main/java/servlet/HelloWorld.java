package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/HelloWorld")
public class HelloWorld extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("    <body>");
		out.write("        <h1>Hello World! [09/07 - 20:47]</h1>");
		out.write("    <body>");
		out.write("</html>");
		System.out.println("O Servlet foi chamado com sucessso!");
	}
	
	
}
