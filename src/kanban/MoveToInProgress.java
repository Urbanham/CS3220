package kanban;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import toDo.ToDoListEntry;

/**
 * Servlet implementation class MoveToInProgress
 */
@WebServlet("/MoveToInProgress")
public class MoveToInProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveToInProgress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
        
		ArrayList<KanbanEntryToDo> toDoListKanban = (ArrayList<KanbanEntryToDo>) getServletContext().getAttribute("toDoKanban");
		ArrayList<KanbanEntryInProgress> inProgressEntries = (ArrayList<KanbanEntryInProgress>) getServletContext().getAttribute("InProgress");
	        
		for( KanbanEntryToDo kEntry : toDoListKanban )
			
            if( kEntry.getId().equals( id ) )
            {
            	
            	kEntry.setLocation("inProgress");
            	
            	inProgressEntries.add(new KanbanEntryInProgress(kEntry.getId(),kEntry.getToDoName(),kEntry.getMessage(),kEntry.getLocation(),kEntry.getPriority()));
            	toDoListKanban.remove( kEntry );
            
            	
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
