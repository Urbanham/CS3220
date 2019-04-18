package toDo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddList
 */
@WebServlet("/AddList")
public class AddList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int idSeed = 2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddList() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            // display form
            response.setContentType( "text/html" );
            PrintWriter out = response.getWriter();
            
            out.println( "<html><head><title>Add New Task</title></head><body>" );

            out.println( "<form action='AddList' method='post'>" );
            out.println( "Name: <input type='text' name='name' /> <br />" );
            
            out.println( "<input type='submit'  name = 'name' value='Add' /> <br />" );
            out.println( "</form>" );
            

            out.println( "</body></html>" );
        }

        @SuppressWarnings("unchecked")
        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            // get the user input
            String name = request.getParameter( "name" );
            
          

            // add the new entry
            ArrayList<ToDoListEntry> entries = (ArrayList<ToDoListEntry>) getServletContext().getAttribute("EntriesOfList");
            
            entries.add( new ToDoListEntry(idSeed++,name,false));

     
            response.sendRedirect( "ToDoList" );
        }
}
