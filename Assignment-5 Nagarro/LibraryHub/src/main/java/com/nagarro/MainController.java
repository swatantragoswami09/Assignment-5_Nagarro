package com.nagarro;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nagarro.dao.CallApi;
import com.nagarro.entity.Books;


@Controller
public class MainController {
	
	
	@Autowired
	CallApi api;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req,HttpServletRequest res) throws JsonMappingException, JsonProcessingException, InterruptedException, ExecutionException {
		
		HttpSession session = req.getSession();
		Books book= new Books();
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		System.out.println(name+":"+pass);
		if(name.equals("admin") && pass.equals("admin")) {
			session.setAttribute("username", name);
			
			List<Books> list=api.getData();
//					api.postData(book);
			System.out.println(list.toString());
			req.getSession().setAttribute("list",list);
			
			return "login";
		}
		return "error";
		
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest req,HttpServletRequest res) {
		HttpSession session = req.getSession();
		session.removeAttribute("username");
//		res.sendRedirect("index");
//		return "index";
		
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest req,HttpServletRequest res) {
		return "add";
	}
	
	@RequestMapping("/data")
	public String dataAdd(HttpServletRequest req,HttpServletRequest res) throws InterruptedException, ExecutionException, IOException {
		//adding logic
		String bookcode = req.getParameter("bookcode");
		String bookname = req.getParameter("bookname");
		String author = req.getParameter("author");
		String dataadded = req.getParameter("datadded");
		Books book =new Books();
		book.setBookcode(bookcode);
		book.setBookname(bookname);
		book.setAuthor(author);
		book.setDataadded(dataadded);
		System.out.println("calling api");
		
		CallApi api=new CallApi();
		api.postData(book);

		return "saved";
	}
	
	@RequestMapping("/editpage")
	public String editPage(HttpServletRequest req,HttpServletRequest res) throws InterruptedException, ExecutionException, IOException {
		String bookId = req.getParameter("id");
		return "editpage";
	}

}
