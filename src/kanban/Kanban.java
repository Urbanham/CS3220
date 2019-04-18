package kanban;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import toDo.ToDoListEntry;

/**
 * Servlet implementation class Kanban
 */
@WebServlet("/Kanban")
public class Kanban extends HttpServlet {
	private static final long serialVersionUID = 1L;
     int idSeed =10;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kanban() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	ArrayList<KanbanEntryToDo> toDoEntries = new ArrayList<KanbanEntryToDo>();
    	ArrayList<KanbanEntryInProgress> inProgress = new ArrayList<KanbanEntryInProgress>();
    	ArrayList<KanbanEntryDone> doneList = new ArrayList<KanbanEntryDone>();
    	
    	
    	toDoEntries.add(new KanbanEntryToDo(1,"Work on Homework","Do not forget the homework","ToDo",1));
    	
    	inProgress.add(new KanbanEntryInProgress(2,"Do the dishes", "Mom said to do them", "inProgress" ,1));
    	doneList.add(new KanbanEntryDone(3,"Sleep", "get a nice rest", "Done" ,1));
    	
    	ServletContext context = this.getServletContext();
    	
    	context.setAttribute("toDoKanban", toDoEntries);
    	context.setAttribute("InProgress", inProgress);
    	context.setAttribute("Done", doneList);
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType( "text/html" );
         PrintWriter out = response.getWriter();
         
         out.println( "<head><title>Kanban</title>" );
         out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n" + "");
         
         out.println("</head>");
         
         
         out.println( "<body>" );
         out.println("<h1> Kanban</h1>");
         
         ServletContext context = this.getServletContext();
         ArrayList<KanbanEntryToDo> toDoListEntries= (ArrayList<KanbanEntryToDo>) context.getAttribute("toDoKanban"); 
         
         out.println("<div class =\"d-flex flex-row\">");
         
         out.println("	<div class =\"d-flex flex-column\">");
       
         
         for( KanbanEntryToDo kanbanToDo : toDoListEntries) {
        	 out.println("<h1> To Do</h1>");
        	out.println("<div class = \"md-col \">");
         	out.println("<div class = \"card w-80 \" >");
        	out.println("<div class = \"card-body\"> ");
        	out.println("<h5 class = \"card-header bg-danger\" >" +kanbanToDo.getToDoName() + "</h5>");
        	out.println("<h6 class = \"card-text\" >"+ " 	"+ kanbanToDo.getMessage() + "</h6>" );
        	out.println("<a href = 'Delete?id=" + kanbanToDo.getId() + "'> Remove </a>");
        	out.println("<a href = 'MoveToInProgress?id=" + kanbanToDo.getId() + "' > Move to In progress </a>");   
        	out.println("</div>");
        	out.println("</div>");
        	out.println("</div>");
        	
         }
         out.println("</div>");
         
         
         ArrayList<KanbanEntryInProgress> inProgressEntries = (ArrayList<KanbanEntryInProgress>) context.getAttribute("InProgress");
         out.println("<div class =\"d-flex flex-column\">");
         
         
         for(KanbanEntryInProgress kanbanInProg: inProgressEntries) {
        	 out.println("<h1> In Progress</h1>");
        	 out.println("<div class = \"md-col \">");
        	out.println("<div class = \"card w-80 \" >");
         	out.println("<div class = \"card-body\"> ");
         	out.println("<h5 class = \"card-header bg-warning\" >" + kanbanInProg.getToDoName() + "</h5>");
         	out.println("<h6 class = \"card-text\" >"+ " 	"+ kanbanInProg.getMessage() + "</h6>" );
         	out.println("<a href = 'DeleteInProgress?id=" + kanbanInProg.getId() + "'> Remove </a>");
         	out.println("<a href = 'MoveToDone?id=" + kanbanInProg.getId() + "' > Move to Done </a>");   
         	out.println("</div>");
        	out.println("</div>");
        	out.println("</div>");
        	 
         }
         out.println("</div>");
         
         
         ArrayList<KanbanEntryDone> doneEntries = (ArrayList<KanbanEntryDone>) context.getAttribute("Done");
         out.println("<div class =\"d-flex flex-column\">");
         
         
         for(KanbanEntryDone kanbanDone: doneEntries) {
        	 out.println("<h1> Done</h1>");
        	 out.println("<div class = \"md-col \">");
        	out.println("<div class = \"card w-80 \" >");
         	out.println("<div class = \"card-body\"> ");
         	out.println("<h5 class = \"card-header bg-success\" >" + kanbanDone.getToDoName() + "</h5>");
         	out.println("<h6 class = \"card-text\" >"+ " 	"+ kanbanDone.getMessage() + "</h6>" );
         	out.println("</div>");
        	out.println("</div>");
        	out.println("</div>");
        	 
         }
         out.println("</div>");
        
         
         out.println("</div>");
         
         out.println("<br/>");
         out.println("<div class = \"fixed-bottom\">" );
         out.println( "<form =\"#\" method='post'>" );
         out.println( "Task: <input type='text' name='name' /> <br />" );
         out.println("Message: <input type = 'text' name ='message' /> <br/>");
         
         out.println( "<input type='submit'  name = 'name' name = 'message' value='Add' /> <br />" );
         out.println( "</form>" );
         out.println("</div>");
         

         out.println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String name = request.getParameter( "name" );
		String message = request.getParameter( "message" );
        
        

        // add the new entry
        ArrayList<KanbanEntryToDo> toDoEntries = (ArrayList<KanbanEntryToDo>) getServletContext().getAttribute("toDoKanban");
        
       toDoEntries.add( new KanbanEntryToDo(idSeed++,name,message,"ToDo",1));
       response.sendRedirect("Kanban");
	}

}
