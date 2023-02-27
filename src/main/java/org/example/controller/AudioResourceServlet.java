package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@WebServlet(name = "audio",value="audio")
public class AudioResourceServlet extends HttpServlet{
	
	//Creating internal Memory for Audio
	ConcurrentHashMap<String,Audio> audioDB = new ConcurrentHashMap<>();
	
	@Override
	public void init() throws ServletException{
		Audio song1 = new Audio();
		song1.setArtistName("Taylor Swift");
		song1.setTrackTitle("You Belong With Me");
		song1.setAlbumTitle("Fearless");
		song1.setTrackNumber("001");
		song1.setYear(2009);
		song1.setNoOfReviews(1000);
		song1.setNoOfCopiesSold(5000);
		audioDB.put("You Belong With Me",song1);
		
		Audio song2 = new Audio();
		song2.setArtistName("Demi Lovato");
		song2.setTrackTitle("I Love Me");
		song2.setAlbumTitle("Women's Day 2021");
		song2.setTrackNumber("002");
		song2.setYear(2021);
		song2.setNoOfReviews(2000);
		song2.setNoOfCopiesSold(15000);
		audioDB.put("I Love Me",song2);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String track_title = request.getParameter("track_title");
		Audio song1 = audioDB.get(track_title);
		String artist_name = song1.getArtistName();
		String album_title = song1.getAlbumTitle();
		String track_number = song1.getTrackNumber();
		int year = song1.getYear();
		int no_of_reviews = song1.getNoOfReviews();
		int no_of_copies = song1.getNoOfCopiesSold();
	
		
		
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(audioDB);
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if (song1 == null)
		{
			out.println("GET RESPONSE IN JSON - all elements " + element.toString());
		}
		else
		{
			out.println("RESPONSE IN JSON - Single Element:");
			out.println("Artist Name:"+gson.toJson(artist_name));
			out.println("Track Title:"+gson.toJson(track_title));
			out.println("Album Title:"+gson.toJson(album_title));
			out.println("Track Number:"+gson.toJson(track_number));
			out.println("Year:"+gson.toJson(year));
			out.println("No of Reviews:"+gson.toJson(no_of_reviews));
			out.println("No of Reviews:"+gson.toJson(no_of_copies));
			out.flush();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String track_title = request.getParameter("track_title");
		String artist_name = request.getParameter("artist_name");
		String album_title = request.getParameter("album_title");
		String track_number = request.getParameter("track_number");
		
		response.getOutputStream().println("POST RESPONSE: Audio ");
	}
}
