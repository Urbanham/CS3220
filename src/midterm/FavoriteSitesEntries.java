package midterm;

public class FavoriteSitesEntries {
	String favoriteWebsiteName;
	String messageForWebsite;
	Integer likes;
	Integer dislike;
	
	
	public FavoriteSitesEntries(String favoriteWebsiteName, String messageForWebsite, Integer likes, Integer dislike) {
		super();
		this.favoriteWebsiteName = favoriteWebsiteName;
		this.messageForWebsite = messageForWebsite;
		this.likes = likes;
		this.dislike = dislike;
	}
	public String getFavoriteWebsiteName() {
		return favoriteWebsiteName;
	}
	public void setFavoriteWebsiteName(String favoriteWebsiteName) {
		this.favoriteWebsiteName = favoriteWebsiteName;
	}
	public String getMessageForWebsite() {
		return messageForWebsite;
	}
	public void setMessageForWebsite(String messageForWebsite) {
		this.messageForWebsite = messageForWebsite;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Integer getDislike() {
		return dislike;
	}
	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}
	

}
