package midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDislike
 */
@WebServlet("/AddDislike")
public class AddDislike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDislike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer dislikes = Integer.valueOf( request.getParameter( "FavoriteWebsiteDislikes" ) );
		String name = request.getParameter("FavoriteSiteName");
		
	    
		ArrayList<FavoriteSitesEntries> favSites= (ArrayList<FavoriteSitesEntries>) getServletContext().getAttribute("FavSites");
	    
	    for( FavoriteSitesEntries entry : favSites )
	        if( entry.getFavoriteWebsiteName().equals(name) )
	        {
	            entry.setDislike(++dislikes);
	            break;
	        }
	    response.sendRedirect("FavoriteSitesIndex");
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
