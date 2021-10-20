<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.nagarro.entity.Books"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Edit Page</title>
</head>
<body>



	<div class="edit-form" id="myForm">
	<h1 Style="text-align: center">fill out details to edit</h1>
		<form action="Edit?id=<%=request.getParameter("id") %>" class="form-container" method="post" Style="text-align: center">
			<tr>
				<td>Enter Book Name :</td>
				<td><input type="text" placeholder="Enter new Book name" name="newbook" required /><br/></td>
			</tr>
			<tr>
				<td>Enter Author :</td>
				<td><input type="text" placeholder="Enter new Author" name="newauthor" required /><br/></td>
			</tr>
			
			<tr>
				<td>Data added  :</td>
				<td><input type="text" placeholder="Enter new date added" name="newdate" required /><br/></td>
			</tr>
			
			
			
			<button type="submit" class="btn">Edit Details</button>
			<button type="Reset" class="btn cancel" >Cancel</button>
		</form>
	</div>

</body>
</html>