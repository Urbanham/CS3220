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
 * Servlet implementation class SetBackground
 */
@WebServlet("/lab6/SetBackground")
public class SetBackground extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetBackground() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// display form
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        out.println( "<html><head><title>Set Background</title></head>" );
        out.println("<body ");
        
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
        for(int i = 0; i < cookies.length; i++) {
        	
            Cookie cookie1 = cookies[i];
            
            if (cookie1.getName().equals("bGColor")) {
                out.println("bgcolor = " + cookie1.getValue());
                
            }
        }  
        }
        
        out.println(">");
        out.println( "<form action='SetBackground' method='post'>" );
        
        out.println( "Back Ground Color: <input type='text' name='bGColor' /> <br />" );
       
        
       
        out.println( "<input type='submit'  name = 'bGColor'  value='Add' /> <br />" );
        
        out.println( "</form>" );
        
        out.println("<a  href = \"ViewBackground\"> Go to Background? </a>" );
        out.println("<a  href = \"DeleteCookie\"> Delete Cookie? </a>" );
        out.println( "</body></html>" );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String rgb = request.getParameter( "bGColor" );
	
		Cookie bGColor = new Cookie("bGColor",rgb );
		
		
		bGColor.setMaxAge(432000);
	
		
		bGColor.setPath("/");
		
		response.addCookie(bGColor);
		

		response.sendRedirect( "ViewBackground" );
		
		doGet(request, response);
	}
	private String getValue( HttpServletRequest request )
    {
        Cookie[] cookies = request.getCookies();
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "name" ) )
                    return cookie.getValue();

        return null;
    }

}
