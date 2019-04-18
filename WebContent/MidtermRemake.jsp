<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    
	<%@ page import = "midterm.FavoriteSitesEntries" %>
	<% ArrayList<FavoriteSitesEntries> favWebSites = new ArrayList<FavoriteSitesEntries>(); 
	favWebSites.add((new FavoriteSitesEntries("reddit.com","A place where you can browse almost anything",0,0)));
	favWebSites.add((new FavoriteSitesEntries("youtube.com","A place to watch videos",0,0)));
	ServletContext context = this.getServletContext();
	
	context.setAttribute("favSites", favWebSites);

	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FavSites Jsp</title>
</head>
<body>
<h1> Jsp Midterm</h1>

	
	
<% 
ArrayList<FavoriteSitesEntries> favSiteEntries= (ArrayList<FavoriteSitesEntries>) context.getAttribute("favSites");
for( FavoriteSitesEntries favoriteSite : favSiteEntries) {%>
	
    
 	<div class = card  style= 'width:18rem;' >
	<a href = "https://www. <%=  favoriteSite.getFavoriteWebsiteName()%> ">  <%= favoriteSite.getFavoriteWebsiteName()%> </a>
	<div class = card-body> 
	<p class = card-text >  	<%=  favoriteSite.getMessageForWebsite() %> </p>
	<h6 class = "card-text" > 	likes:  <%=  favoriteSite.getLikes() %></h6>
	<h6 class = "card-text" >	dislikes:  <%=   favoriteSite.getDislike()%> </h6> 
	<a href = 'DeleteWebSite?FavoriteSiteName=" + favoriteSite.getFavoriteWebsiteName() + "' >delete</a>
	<a href = 'AddLike?FavoriteSiteName=" + favoriteSite.getFavoriteWebsiteName() +  "&FavoriteWebsiteLikes="+ favoriteSite.getLikes()
	 + "'>Like?</a>
	 <a href = 'AddDislike?FavoriteSiteName=" + favoriteSite.getFavoriteWebsiteName() +  "&FavoriteWebsiteDislikes="+ favoriteSite.getDislike()
	 + "'>Dislike?</a>
	
	  
	</div>
	</div>
	</br>
	
<%  }
%>




		<div class = "d-flex justify-content-start">
    	 <form =\"#\" method='post'>
        Add Website: <input type='text' name='name' /> <br />
       	Message: <input type = 'text' name ='message' /> <br/>
         
       	<input type='submit'  name = 'name' name = 'message' value='Add' /> <br />
     	</form>
        </div>



	<% 
	String name = request.getParameter( "name" );
	String message = request.getParameter( "message" );
	
	
	favWebSites.add(new FavoriteSitesEntries(name,message,0,0));
	
	
	context.setAttribute("favSites", favWebSites);
	
	
	%>














</body>
</html>