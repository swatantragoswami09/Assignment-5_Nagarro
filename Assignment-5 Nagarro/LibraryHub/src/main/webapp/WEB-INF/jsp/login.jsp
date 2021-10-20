
<%@page import="com.nagarro.entity.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%-- <%@page import="com.nagarro.assignment5.Model.ModelData"%>
<%@page import="com.nagarro.assignment5.Services.SaveImage"%>
<%@page import="com.nagarro.assignment5.Connection.Connector"%> --%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
	String userID = (String) session.getAttribute("username");
	 if (userID == null) {
		response.sendRedirect("index.jsp");
	} 
%>

<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

		<style>
			.cbox{
			border: 1px solid black;
			height: 600px;
			}
            .c1box{
                border: 1px solid black;
                height: 200px;
            }
            .c2box{
                border: 1px solid black;
                height: 400px;
            }
            .
            /* .pdiv{
                border: 1px solid black;
            } */
            .c1box h3{
                border: 2px solid black;
            }
            .tableHead{
                text-align: center;
                border: 2px solid black;

            }
            .center{
            	text-align:center;
            }
            .b{
          		padding-left: 40px;
            }
            .t1{
            padding-top: 50px;
            }
            .format{
            	height:150px;
            	wieght:1500px;
            	
            }
            .t2{
            padding: 0px 50px 0px 0px
            }
            .hh{
		        text-align: center;
		        }
		        .pad{
		        	padding: 40px 80px 0px 10px;
		        }
            

        </style>


<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body >
	<div >
				
           <div class="row">

               <h3 class="d-flex justify-content-center py-3 p-3 mb-2">
                   Library
               </h3>
               <form action="logout" class="t2">
	                <div >
						<span style="float:right">Hi ${username} <input type="submit" value="logout" style="color: #ffffff; background-color:blue;"></span><br/>
	                </div>
               </form>   
               
               <form action="add" class="pad">
	                <div >
						<span style="float:right"><input type="submit" value="Add Book" style="color: #ffffff; background-color:blue;"></span><br/>
	                </div>
               </form>
       		</div>

        <div class= "row center ">
            
            
            <div class="table-responsive t1 ">
                <table class="table table-bordered ">

                        <tr>
                        	<th class="hh">S. No.</th>
					        <th class="hh">Book Code</th>
					        <th class="hh">Book Name</th>
					        <th class="hh">Author</th>
					        <th class="hh">Data Added</th>
					        <th class="hh">Action</th>
				    	</tr>
                        
                        
                    
 		    <%
		
		List<Books> list = (List<Books>) request.getSession().getAttribute("list");
		 if (!list.isEmpty()) {
		%>
		
		<%
			Iterator<Books> iterator = list.iterator();
				int i = 0;
				while (iterator.hasNext()) {
					i++;
					Books book = iterator.next();
		%>
		
						<tr class="center">
							<td><%=i %></td>
							<td><%=book.getBookcode()%></td>
							<td><%=book.getBookname()%></td>
							<td><%=book.getAuthor()%></td>
							<td><%=book.getDataadded()%></td>
							  <td><a href="<%= request.getContextPath()%>/Delete?id=<%=book.getBookcode() %>" class="format">Delete</a>
								<a href="<%=request.getContextPath()%>/editpage?id=<%=book.getBookcode()%>">Edit</a> 
							</td> 
						</tr>
			   

		<%
			}
		%>
                   </table>
			</div>
		</div>
		</div>
		<%
		} 
		%>   
</body>
</html>