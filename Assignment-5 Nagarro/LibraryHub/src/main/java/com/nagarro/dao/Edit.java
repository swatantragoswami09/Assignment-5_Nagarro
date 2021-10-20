/* 
  Class name : Edit
 * 
 * Version info
 * 
 * Copyright notice
 * 
 * Author info: Swatantra
 *
 */
package com.nagarro.dao;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.nagarro.entity.Books;



/**
 * The below class edit the details of the image.
 * @author Swatantra
 *
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	HttpClient client = HttpClient.newHttpClient();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookId = request.getParameter("id");//61
		String bookname = request.getParameter("newbook");
		String author = request.getParameter("newauthor");
		String dataadded = request.getParameter("newdate");
//		System.out.println(bookId+" : "+ bookname+" : "+author+" : "+dataadded);

		Books book =new Books();
		book.setBookcode(bookId);
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setDataadded(dataadded);
		
		ObjectMapper jacksonObjMapper = new ObjectMapper();
		String rawjson= jacksonObjMapper.writeValueAsString(book);
		JsonNode json= jacksonObjMapper.readValue(rawjson.toString(),JsonNode.class);
		ObjectNode node = (ObjectNode) json;
		
		HttpRequest req = HttpRequest.newBuilder()
	            .uri(URI.create("http://localhost:8081/books"+"/"+bookId))
	            .setHeader("Content-Type", "application/json")
	            .PUT(HttpRequest.BodyPublishers.ofString(rawjson))	            
	            .build();
		String s="";
		try {
			s = client.sendAsync(req,BodyHandlers.ofString()) .thenApply(HttpResponse::body).get();
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		
		
		
          
     }

	}


