package dynweb01.test;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prova
 */
@WebServlet(
		description = "Classe per la prova del Web Container", 
		urlPatterns = { 
				"/Prova", 
				"/PR", 
				"/pr"
		})

public class Prova extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prova() {
        super();
        System.out.println(getClass().getName()+" Costruttore attivato!");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println(getClass().getName()+" Init attivata!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println(getClass().getName()+" Destroy attivata!");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request,
	 *  HttpServletResponse response)
	 *  Attiva il lavoro del controller quando arriva una
     * http get alla url /Pr
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getClass().getName()+" doGet attivata!");
		response.getWriter().append("Hello from here!");
		response.getWriter().append("Hello from here!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
