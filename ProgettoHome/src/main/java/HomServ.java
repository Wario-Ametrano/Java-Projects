
import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomServ
 */
@WebServlet("/HomServ")
public class HomServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HomServ() {
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
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		listaProdotti.add(new Prodotto("sedia","a12"));
		listaProdotti.add(new Prodotto("tavolo","b34"));
		listaProdotti.add(new Prodotto("armadio","c56"));
		
		Prodotto p;
		String scelta=request.getParameter("scelta");
		String nome=request.getParameter("nome");
				if(scelta.equals("ricerca")) {	
					
					for(int i = 0;i<listaProdotti.size();i++) {
						if(listaProdotti.get(i).getNome().equalsIgnoreCase(nome)) {
							request.setAttribute("nomeProdotto",listaProdotti.get(i));
							request.getRequestDispatcher("stampa.jsp").forward(request,response);
						}
					}
				}else if(scelta.equals("inserisci")) {
					
					p = new Prodotto();
					p.setNome(request.getParameter("nome"));
					p.setCodice(request.getParameter("codice"));
					listaProdotti.add(p);
					request.setAttribute("prodotto", p);
					request.getRequestDispatcher("stampa.jsp").forward(request,response);
					
				}else if(scelta.equals("cancella"))	{	
					for(int i = 0;i<listaProdotti.size();i++) {
						if(listaProdotti.get(i).getNome().equalsIgnoreCase(nome)) {
							listaProdotti.remove(i);
							request.getRequestDispatcher("cancella.jsp").forward(request,response);
						}
					}
				}
				
	}

}
