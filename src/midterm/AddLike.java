package midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLike
 */
@WebServlet("/AddLike")
public class AddLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLike() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer likes = Integer.valueOf( request.getParameter( "FavoriteWebsiteLikes" ) );
		String name = request.getParameter("FavoriteSiteName");
		
	    
		ArrayList<FavoriteSitesEntries> favSites= (ArrayList<FavoriteSitesEntries>) getServletContext().getAttribute("FavSites");
	    
	    for( FavoriteSitesEntries entry : favSites )
	        if( entry.getFavoriteWebsiteName().equals(name) )
	        {
	            entry.setLikes(++likes);
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
