package toDo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDoList
 */
@WebServlet("/ToDoList")
public class ToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoList() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	ArrayList<ToDoListEntry> entries = new ArrayList<ToDoListEntry>();
    	
    	entries.add(new ToDoListEntry(1,"do the dishes",false));
    	
    	
    	ServletContext context = this.getServletContext();
    	
    
    	
    	context.setAttribute("EntriesOfList", entries);
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
        // display it
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        out.println( "<head><title> TO DO LIST</title>" );
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n" + "");
        
        out.println("</head>");
        
        out.println( "<body>" );
        out.println("<h1> To Do list </h1>"); 

        out.println( "<table table class = \"table table-bordered table-striped table-hover\">" );
        out.println( "<tr><th>Thing needed to be done</th><th>completed?</th><th><br /></th></tr>" );
        
        ServletContext context = this.getServletContext();
        
        ArrayList<ToDoListEntry> listEntries= (ArrayList<ToDoListEntry>) context.getAttribute("EntriesOfList"); 
        
        for( ToDoListEntry entries : listEntries) {
        	
        	out.println("<tr>");
        	out.println("		<td>" + entries.getId() + " "+ entries.getToDoName() + "</td>");
        	out.println(		"<td><a href='ChangeComp?id=" + entries.getId() + "'>Completed </a>" + entries.getCompleted());
        	out.println(		"<a href='DeleteList?id=" + entries.getId() +"'>Delete</a></td></tr>");
        	
        	out.println("</tr>");
        
        	
        }
        
        out.println( "</table>" );
        
        int falseCounter=0;
        int trueCounter = 0;
        int totalCounter = 0;
        ArrayList<ToDoListEntry> trueList = new ArrayList<ToDoListEntry>();
        
        for (ToDoListEntry entries: listEntries) {
        	totalCounter++;
        	
        	if(entries.getCompleted() == false) {
        		falseCounter++;
        		
        	}
        	if(entries.getCompleted()== true) {
        		trueCounter++;
        		trueList.add(entries);
        		
        	}
        	
        }
        
        
        
        out.println( "<p><a href='AddList'>Add to List</a></p>" );
        out.println( "<p><a href='DeleteAllCompleted'> Delete all Comp</a></p>" );
        out.println( "<p><a href='AlphaSort'> Sort the list?</a></p>" );
       
        
        out.println("<p> Total Amount of undone task: " + falseCounter + "</p>");
        out.println("<p> Total Amount of done task: " + trueCounter + "</p>");
        out.println("<p> Total Amount of task: " + totalCounter + "</p>");
        

        

        out.println( "</body></html>" );	}

	
	

}
