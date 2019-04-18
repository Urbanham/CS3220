package kanban;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteInProgress
 */
@WebServlet("/DeleteInProgress")
public class DeleteInProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInProgress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
        
		ArrayList<KanbanEntryInProgress> inProgressKanban= (ArrayList<KanbanEntryInProgress>) getServletContext().getAttribute("InProgress");
        
        for( KanbanEntryInProgress inProg : inProgressKanban )
            if( inProg.getId().equals( id ) )
            {
               inProgressKanban.remove( inProg );
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
