package request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/RequestInfo","/lab4/","/lab4/*"})
public class RequestInfo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RequestInfo()
    {
        super();
    }
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    	
    	
    	ServletContext context = this.getServletContext();
    	
    
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Display Request Info</title>" );
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n" + "");
        
        out.println("</head>");
        
        out.println( "<body>" );
        
        out.println( "<b>Request Method</b>: " + request.getMethod() + "<br>" );
        out.println( "<b>Request URI</b>: " + request.getRequestURI() + "<br>" );
        out.println( "<b>Context Path</b>: " + request.getContextPath() + "<br>" );
        out.println( "<b>System Path</b>: " + request.getRealPath("RequestInfo") + "<br>" );
        
        out.println("<div class =\"container\">");
        out.println("<table class = \"table table-bordered table-striped table-hover\">");
        out.println("<tr>");
        
        out.println("<th> Header </th>");
        out.println("<th> Value </th>");

        out.println("</tr>");
        out.println("<tr>");
        
        
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            
            String headValues = request.getHeader(headerName);
            
            out.print("<tr><td>" + headerName +"</td>");
            
            String headerValue = request.getHeader(headerName);
            if(headerValue.length() ==0) {
            	out.println("<i> Null</i>");
            }
            else {
            out.print("<td>" + headerValue +"</td>");	
            }
            
            
            out.println("</em><br/>");
        }
       
        
        out.println("</tr>");
        out.println("<div class =\"container\">");
        out.println("<table class = \"table table-bordered table-striped table-hover\">");
        out.println("<tr>");
        
        out.println("<th> Parameter </th>");
        out.println("<th> value </th>");
        
        out.println("</tr>");
        
        Enumeration<String> paramNames= request.getParameterNames();
        
        while(paramNames.hasMoreElements()) {
        	
            String paramName = paramNames.nextElement();
            
            out.print("<tr><td>" + paramName + "\n<td>");
            
            String[] paramValues = request.getParameterValues(paramName);
            
            if (paramValues.length == 1) {
              String paramValue = paramValues[0];
              if (paramValue.length() == 0)
                out.println("<I>No Value</I>");
              else
                out.println(paramValue);
            } 
            else {
              out.println("<ul>");
              for(int i=0; i<paramValues.length; i++) {
                out.println("<li>" + paramValues[i]);
              }
              out.println("</li>");
            }
            out.println("</tr>");
        
   
        

        
        
     

        out.println( "</body></html>" );
    }
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}