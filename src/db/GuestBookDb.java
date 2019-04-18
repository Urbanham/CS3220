package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/db/GuestBookDb")
public class GuestBookDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public void init( ServletConfig config ) throws ServletException
	    {
	        super.init( config );

	        try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
	    }
       

    
    public GuestBookDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu73";
            String username = "cs3220stu73";
            String password = "kFy*#YZm";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from guestbook" );
            
            ArrayList<GuestBookEntry> guestbookEntries = new ArrayList<GuestBookEntry>();
            
            
            while( rs.next() )
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String message = rs.getString("message");
                
                GuestBookEntry entry = new GuestBookEntry(id,name,message);
                guestbookEntries.add(entry);
                
                
            }
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
            request.getRequestDispatcher("/WEB-INF)
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
