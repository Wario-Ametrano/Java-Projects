

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomData
 */
@WebServlet("/HomData")
public class HomData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connessione connect = new Connessione();
		Prodotto p = new Prodotto();
		
		String scelta=request.getParameter("scelta");
		String nome=request.getParameter("nome");
		
				if(scelta.equals("ricerca")) {	
					p=connect.ricercaProdotto(nome);
					request.setAttribute("connect",p);
					request.getRequestDispatcher("ricerca.jsp").forward(request,response);
					
				}else if(scelta.equals("inserisci")) {	
					int idProdotto=Integer.valueOf(request.getParameter("idProdotto"));
					String codice=request.getParameter("idProdotto");
					connect.inserisciProdotto(idProdotto,nome,codice);
					request.getRequestDispatcher("stampa.jsp").forward(request,response);

				}else if(scelta.equals("cancella")) {	
					
					
					
					request.getRequestDispatcher("cancella.jsp").forward(request,response);
				}
					
		}
	}
	


