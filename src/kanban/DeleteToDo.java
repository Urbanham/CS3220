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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class DeleteToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteToDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
        
		ArrayList<KanbanEntryToDo> toDoListKanban= (ArrayList<KanbanEntryToDo>) getServletContext().getAttribute("toDoKanban");
        
        for( KanbanEntryToDo entry : toDoListKanban )
            if( entry.getId().equals( id ) )
            {
                toDoListKanban.remove( entry );
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
