package org.example.model;

public class Audio {
	private String artist_name;
	private String track_title;
	private String album_title;
	private String track_number;
	private Integer year;
	private Integer no_of_reviews;
	private Integer no_of_copies_sold;
	
	// get() and set() for artist_name 
	public String getArtistName() {
		return artist_name;
	}
	public void setArtistName(String artist_name) {
		this.artist_name = artist_name;
	}
	
	// get() and set() for track_title
	public String getTrackTitle() {
		return track_title;
	}
	public void setTrackTitle(String track_title) {
		this.track_title = track_title;
	}
	
	// get() and set() for album_title
	public String getAlbumTitle() {
		return album_title;
	}
	public void setAlbumTitle(String album_title) {
		this.album_title = album_title;
	}
	
	// get() and set() for track_number
	public String getTrackNumber() {
		return track_number;
	}
	public void setTrackNumber(String track_number) {
		this.track_number = track_number;
	}
	
	// get() and set() for year
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	//get() and set() for no_of_reviews
	public int getNoOfReviews() {
		return no_of_reviews;
	}
	public void setNoOfReviews(int no_of_reviews) {
		this.no_of_reviews = no_of_reviews;
	}
	
	//get() and set() for no_of_copies_sold
	public int getNoOfCopiesSold() {
		return no_of_copies_sold;
	}
	public void setNoOfCopiesSold(int no_of_copies_sold) {
		this.no_of_copies_sold = no_of_copies_sold;
	}
}
