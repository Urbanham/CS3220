package voter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ServletConfig config ) throws ServletException
    {
        // When you override init(), don't forget to call the super class
        // init() first.
        super.init( config );

        // Note that Java automatically converts between int and Integer
        // (i.e. the "Autoboxing and Unboxing" feature since JDK 1.5.
        int counter = 0;
        
        getServletContext().setAttribute( "VoteResultOne", counter );
        getServletContext().setAttribute( "VoteResultTwo", counter );
        getServletContext().setAttribute( "VoteResultThree", counter );
        
     
    }
	

    
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Vote Here</title>" );
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n" + "");
        out.println( "</head>" );
        out.println( "<body>" );
        
        
        out.println( "<h1>Vote for your favorite things</h1>");
        
        out.println("<img src= 'images/lal.png' width = 500 height = 500 >");
        out.println( "<img src = 'images/celtics.png' width = 500 height = 500>");
        out.println( "<img src = 'images/NYKnicks.png'width = 600 height = 500>");
        
        out.println("<br>");        
      
        out.println( "<a class=\"btn btn-primary mr-5\" style=\"width: 500px \"href=\"VoteResultOne\" role=\"button\">Vote For 1</a>");
       
        out.println( "<a class=\"btn btn-primary mr-5\"  style=\"width: 500px \"href=\"VoteResultTwo\" role=\"button\">Vote For 2</a>");
        out.println( "<a class=\"btn btn-primary ml-5\" style=\"width: 500px \" href=\"VoteResultThree\" role=\"button\">Vote For 3</a>");
        

       

        out.println( "</body></html>" );
    }
}
