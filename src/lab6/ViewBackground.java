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
 * Servlet implementation class ViewBackground
 */
@WebServlet("/lab6/ViewBackground")
public class ViewBackground extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBackground() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        out.println( "<html><head><title>Background Color</title></head>" );
        out.println("<body");
        
        Cookie[] cookies = request.getCookies();
        
        for(int i = 0; i < cookies.length; i++) {
        	
            Cookie cookie1 = cookies[i];
            
            if (cookie1.getName().equals("bGColor")) {
                out.println("bgcolor = " + cookie1.getValue());
                
            }
        }  
        out.println(">");
        
        out.println("<h1> Background </h1>");
        out.println("<a  href = \"SetBackground\"> Set a new Background? </a>" );
        
        
      
        
        out.println( "</body></html>" );
	}
	private String getValue( HttpServletRequest request )
    {
        Cookie[] cookies = request.getCookies();
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "rbg" ) )
                    return cookie.getValue();

        return null;
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
