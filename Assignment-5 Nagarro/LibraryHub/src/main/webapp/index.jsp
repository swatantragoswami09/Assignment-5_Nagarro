<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Librarian Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<style>
.header {
	margin-top: 40px;
	padding-top: 20px;
	background-color: #EBF1F7;
	border-color: rgb(130, 153, 173);
	border-width: 1px;
	border-top-style: solid;
	border-bottom-style: solid;
}

.footer {
	margin-top: 30px;
	padding-top: 20px;
	padding-bottom: 10px;
	background-color: #EBF1F7;
	border-color: rgb(130, 153, 173);
	border-width: 1px;
	border-top-style: solid;
	border-bottom-style: solid;
}
</style>
</head>
<body>
	<c:if test="${not empty error }">
		<div class="alert alert-warning ">
			<strong class="text-center"><c:out value="${error}" /></strong>
		</div>
		<c:set var="error" value="" scope="session" />
	</c:if>
	<div class="container" style="background-color: #F5F8FB;">
		<form action="login" method="post">
			<div class="form-group row header">
				<h4 style="color: rgb(45, 45, 97); margin-left: 10px">Login</h4>
			</div>

			<div class="form-group row" style="margin-top: 50px">
				<label for="username" class="col-sm-2 col-form-label">Username</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" placeholder="Username"
						required="required" name="username" />
				</div>
			</div>
			<div class="form-group row">
				<label for="Password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" placeholder="Password"
						required="required" name="password" /> <br>
				</div>

			</div>
			<div>
				<button type="submit"
					style="margin-left: 555px; display: inline-block;">Login</button>

				</div>

			<a href="#" class="btn btn-link"
				style="margin-left: 180px; margin-top: 10px"> Forgotten your
				Password? </a> <a href="register" class="btn btn-link"
				style="margin-left: 10px; margin-top: 10px"> Register Here</a>
			<div class="form-group row footer">

				

			</div>



		</form>

	</div>
</body>
</html>