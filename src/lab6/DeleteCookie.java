package lab6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookie
 */
@WebServlet("/lab6/DeleteCookie")
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        out.println( "<html><head><title>Deleted Cookie</title></head>" );
        out.println("<body");
        
        Cookie[] cookies = request.getCookies();
		
	       if( cookies != null ) {
	    	   
	           for( Cookie cookie : cookies ) {
	               if( cookie.getName().equals("bGColor") ) {
	            	   cookie.setValue("");
	            	   cookie.setPath("/");
	                   cookie.setMaxAge(0);
	                   response.addCookie(cookie);
	                  
	               }
	           }
	       }
	       
        out.println(">");
        
        out.println("<h1> Background </h1>");
        out.println("<a  href = \"SetBackground\"> Set a new Background? </a>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	       
		doGet(request, response);
	}

}
