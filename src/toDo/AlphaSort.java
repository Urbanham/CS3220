package toDo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlphaSort
 */
@WebServlet("/AlphaSort")
public class AlphaSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlphaSort() {
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
        
        out.println( "<html><head><title>Add New Task</title></head><body>" );

        out.println( "<form action='AlphaSort' method='post'>" );
        out.println( "Want to Sort Alphabetacally? : <input type='radio' name='sort' value = 'yes'/> Yes " );
        out.println("<input type = 'radio' name='no' value = 'no'/> No");
        
        out.println( "<input type='submit'  name = 'sort' value='Submit' /> <br />" );
        out.println( "</form>" );
        

        out.println( "</body></html>" );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String name = request.getParameter("sort");
        

        // add the new entry
        ArrayList<ToDoListEntry> listEntries = (ArrayList<ToDoListEntry>) getServletContext().getAttribute("EntriesOfList");
        
       Collections.sort(listEntries);
       
      
//		response.sendRedirect("ToDoList");
	}

}
