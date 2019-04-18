package toDo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeComp
 */
@WebServlet("/ChangeComp")
public class ChangeComp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeComp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            Integer id = Integer.valueOf( request.getParameter( "id" ) );
            
            ArrayList<ToDoListEntry> entries = (ArrayList<ToDoListEntry>) getServletContext().getAttribute(
                "EntriesOfList" );
            
            for( ToDoListEntry entry : entries ) {
                if( entry.getId().equals( id ) && entry.getCompleted()==false)
                {
                    entry.setCompleted(true);
                   
                }
                else if (entry.getId().equals( id ) && entry.getCompleted()==true) {
                	entry.setCompleted(false);
                }
            }
               
            response.sendRedirect( "ToDoList" );
        }

        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            doGet( request, response );
        }

}
