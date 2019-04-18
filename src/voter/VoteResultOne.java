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

/**
 * Servlet implementation class VoteResultOne
 */
@WebServlet("/VoteResultOne")
public class VoteResultOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteResultOne() {
        super();
        // TODO Auto-generated constructor stub
    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();


        // get the counter
        Integer counter1 = (Integer) servletContext.getAttribute( "VoteResultOne" );
        Integer counter2 = (Integer) servletContext.getAttribute( "VoteResultTwo" );
        Integer counter3 = (Integer) servletContext.getAttribute( "VoteResultThree" );
        
       
        
        
        // increment the counter
        ++counter1;
        
        // save it back the application scope
        servletContext.setAttribute( "VoteResultOne", counter1 );
        servletContext.setAttribute( "VoteResultTwo", counter2 );
        servletContext.setAttribute( "VoteResultThree", counter3 );
        
        double totalVotes = counter1+counter2+counter3; 
        
        Integer votePercent1 = (int) ((counter1/ totalVotes) * 100f); 
        Integer votePercent2 = (int) ((counter2/ totalVotes) * 100f); 
        Integer votePercent3 = (int) ((counter3/ totalVotes) * 100f); 
        
        // display the message "the counter is incremented"
        PrintWriter out = response.getWriter();

        response.setContentType( "text/html" );
        out.println( "<head><title>Vote Here</title>" );
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n" + "");
        out.println( "</head>" );
        out.println("<h1> Voting results</h1>");
        out.println("<p><img src= 'images/lal.png' width = 100 height = 100 >");
        out.println( "The counter value is currently: " + counter1 + "("+ votePercent1+ " %)" + "</p>" );
        out.println("<br>");
        out.println( "<p><img src = 'images/celtics.png' width = 100 height = 100>");
        out.println( "The counter value is currently: " + counter2 + "("+ votePercent2+ " %)" +"</p>" );
        out.println("<br>");
        out.println( "<p><img src = 'images/NYKnicks.png'width = 200 height = 100>");
        out.println( "The counter value is currently: " + counter3 + "("+ votePercent3+ " %)" +"</p>" );
        out.println( "<a class=\"btn btn-primary mr-5\" style=\"width: 500px \"href=\"Vote\" role=\"button\">Cast Another Vote</a>");
        out.println( "</body></html>" );
	}

	
	

}
