package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kanban.KanbanEntryToDo;


/**
 * Servlet implementation class FavoriteSitesIndex
 */
@WebServlet("/FavoriteSitesIndex")
public class FavoriteSitesIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteSitesIndex() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    	ArrayList<FavoriteSitesEntries> favWebSites = new ArrayList<FavoriteSitesEntries>();
    	favWebSites.add((new FavoriteSitesEntries("reddit.com","A place where you can browse almost anything",0,0)));
    	
    	ServletContext context = this.getServletContext();
    	context.setAttribute("FavSites", favWebSites);
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType( "text/html" );
         PrintWriter out = response.getWriter();
         
         out.println( "<head><title>Favorite Websites</title>" );
         out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
         out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n" + "");
         
         out.println("</head>");
         
         
         out.println( "<body>" );
         out.println("<h1> Favorite Websites</h1>");
         
         ServletContext context = this.getServletContext();
         ArrayList<FavoriteSitesEntries> favSiteEntries= (ArrayList<FavoriteSitesEntries>) context.getAttribute("FavSites"); 
         
         out.println("<div class =\"d-flex flex-row  justify-content-center\">");
         
         out.println("	<div class =\"d-flex flex-column\">");
       
         out.println("<h1> Favorite Websites</h1>");
         for( FavoriteSitesEntries favoriteSite : favSiteEntries) {
        	
        
         	out.println("<div class = \"card  \"style= 'width:18rem;' >");
        	out.println("<a href = https://www." + favoriteSite.getFavoriteWebsiteName() +"><h5 class = \"card-header bg-danger\" >" +favoriteSite.getFavoriteWebsiteName() + "</h5></a>");
        	out.println("<div class = \"card-body\"> ");
        	out.println("<p class = \"card-text\" >"+ " 	"+ favoriteSite.getMessageForWebsite() + "</p>" );
        	out.println("<h6 class = \"card-text\" >"+ " 	likes: "+favoriteSite.getLikes() + "</h6>" );
        	out.println("<h6 class = \"card-text\" >"+ " 	dislikes: "+ favoriteSite.getDislike() +"</h6>" );
        	out.println("<a href = 'DeleteWebSite?FavoriteSiteName=" + favoriteSite.getFavoriteWebsiteName() + "' >delete</a>");
        	out.println("<a href = 'AddLike?FavoriteSiteName=" + favoriteSite.getFavoriteWebsiteName() +  "&FavoriteWebsiteLikes="+ favoriteSite.getLikes()
        	 + "'>Like?</a>");
        	out.println("<a href = 'AddDislike?FavoriteSiteName=" + favoriteSite.getFavoriteWebsiteName() +  "&FavoriteWebsiteDislikes="+ favoriteSite.getDislike()
       	 + "'>Dislike?</a>");
        	
       	  
        	out.println("</div>");
        	out.println("</div>");
        	
         }
         out.println("</div>");
         
         
        
         out.println("<br/>");
         out.println("<div class = \"d-flex justify-content-start\">" );
         out.println( "<form =\"#\" method='post'>" );
         out.println( "Add Website: <input type='text' name='name' /> <br />" );
         out.println("Message: <input type = 'text' name ='message' /> <br/>");
         
         out.println( "<input type='submit'  name = 'name' name = 'message' value='Add' /> <br />" );
         out.println( "</form>" );
         out.println("</div>");
         

         out.println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter( "name" );
		String message = request.getParameter( "message" );
		
		boolean isValidName= name!=null && name.trim().length()>0;

		boolean isValidMessage= message!=null && message.trim().length()>0;
		
		if(isValidName && isValidMessage) {
		
		ArrayList<FavoriteSitesEntries> favWebSites = (ArrayList<FavoriteSitesEntries>) getServletContext().getAttribute("FavSites");
		
		favWebSites.add(new FavoriteSitesEntries(name,message,0,0));
		}
		else {
			response.sendRedirect("FavoriteSitesIndex");
		}
		
		doGet(request, response);
	}

}
