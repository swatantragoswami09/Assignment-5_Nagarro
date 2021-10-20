<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@page import="com.nagarro."%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Edit Page</title>
</head>
<body>



	<div class="edit-form" id="myForm">
	<h1 Style="text-align: center">Add Book Details</h1>
		<form action="data" class="form-container" method="post" Style="text-align: center">
			<tr>
				<td>Add Book code :</td>
				<td><input type="text" placeholder="Enter Book code" name="bookcode" required /><br/></td>
			</tr>
			<tr>
				<td>Book Name :</td>
				<td><input type="text" placeholder="Enter Book name " name="bookname" required /><br/></td>
			</tr>
			
			<tr>
				<td>Author :</td>
				<td><input type="text" placeholder="Enter Author name" name="author" required /><br/></td>
			</tr>
			<tr>
				<td>Data added :</td>
				<td><input type="text" placeholder="Enter data added" name="datadded" required /><br/></td>
			</tr>
			
			
			
			
			<button type="submit" class="btn">Submit</button>
			<button type="Reset" class="btn cancel" >Cancel</button>
		</form>
	</div>

</body>
</html>