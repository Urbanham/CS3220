package toDo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAllCompleted
 */
@WebServlet("/DeleteAllCompleted")
public class DeleteAllCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllCompleted() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
           
            
            ArrayList<ToDoListEntry> listEntries = (ArrayList<ToDoListEntry>) getServletContext().getAttribute(
                "EntriesOfList" );
            
            ArrayList<ToDoListEntry> trueList = new ArrayList<ToDoListEntry>();
            
            for (ToDoListEntry e: listEntries) {
            	
            	if(e.getCompleted()== true) {
            		trueList.add(e);
            		
            	}
            	
            }
            
            for(ToDoListEntry t : trueList) {
            	listEntries.remove(t);
            	
            }
            response.sendRedirect( "ToDoList" );
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
