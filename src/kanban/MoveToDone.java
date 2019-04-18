package kanban;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoveToDone
 */
@WebServlet("/MoveToDone")
public class MoveToDone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveToDone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Integer id = Integer.valueOf( request.getParameter( "id" ) );
        
		ArrayList<KanbanEntryDone> doneKanban = (ArrayList<KanbanEntryDone>) getServletContext().getAttribute("Done");
		ArrayList<KanbanEntryInProgress> inProgressEntries = (ArrayList<KanbanEntryInProgress>) getServletContext().getAttribute("InProgress");
	        
		for( KanbanEntryInProgress kEntry : inProgressEntries )
			
            if( kEntry.getId().equals( id ) )
            {
            	
            	kEntry.setLocation("inProgress");
            	
            	doneKanban.add(new KanbanEntryDone(kEntry.getId(),kEntry.getToDoName(),kEntry.getMessage(),kEntry.getLocation(),kEntry.getPriority()));
            	inProgressEntries.remove( kEntry );
            
            	
            	break;
            }
		response.sendRedirect("Kanban");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
