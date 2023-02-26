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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String track_title = request.getParameter("track_title");
		Audio artist_name = audioDB.get(track_title);
		
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(audioDB);
		
		//Response in JSON type
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.println("RESPONSE IN JSON - Single Element:"+gson.toJson(artist_name));
		out.println("RESPONSE IN JSON - All Elements:" + element.toString());
		out.flush();
	}
	
	
}
