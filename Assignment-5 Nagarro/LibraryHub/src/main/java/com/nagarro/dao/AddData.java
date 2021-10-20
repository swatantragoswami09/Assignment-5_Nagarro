package com.nagarro.dao;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagarro.entity.Books;

@WebServlet("/adddata")
public class AddData extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HttpClient client = HttpClient.newHttpClient();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(req, resp);
		String bookcode = req.getParameter("bookcode");
		String bookname = req.getParameter("bookname");
		String author = req.getParameter("author");
		String dataadded = req.getParameter("datadded");
		Books book =new Books();
		book.setBookcode(bookcode);
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setDataadded(dataadded);
		CallApi api=new CallApi();
//		try {
//			api.postData(book);
//		} catch (JsonProcessingException | InterruptedException | ExecutionException e) {
//			
//			e.printStackTrace();
//			System.err.println("something went wrong");
//		}
	}
}
