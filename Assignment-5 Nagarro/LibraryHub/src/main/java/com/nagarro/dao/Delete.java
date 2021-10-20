package com.nagarro.dao;

/* 
  Class name : DeleteImage
 */


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;




@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpClient client = HttpClient.newHttpClient();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String bookId = req.getParameter("id");
//	int id = Integer.parseInt(ID);
	
	HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8081/books"+"/"+bookId))
            .DELETE()
            .build();
	try {
		String s= client.sendAsync(request,BodyHandlers.ofString()) 
		          .thenApply(HttpResponse::body).get();
//		getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("not found");
	}
	 
	}

}