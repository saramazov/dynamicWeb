package dynweb01.converter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.test.Convertitore;
import jdbc.test.ConvertitoreFactory;
import nuovoConcessionario.db.ConnectionFactory;

/**
 * Servlet implementation class SqlBridge
 */
@WebServlet(description = "Riceve una query SQL e visualizza il risultato"
		+ "in html o c csv",
		urlPatterns = { "/SqlBridge", "/sql" })
public class SqlBridge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		//connessione al db(connFact)
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
		            ResultSet.CONCUR_READ_ONLY);
			//esecuzione query
			String query = request.getParameter("query");
			results = statement.executeQuery(query);
			Convertitore convertitore = 
					ConvertitoreFactory.createConvertitore("html");
			String html = convertitore.converti(results);
			request.setAttribute("oggetto.da.stampare", html);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
			throw new ServletException(e);
			
			
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("/sqlview");
		RequestDispatcher rd = request.getRequestDispatcher("a.jsp");
		rd.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
