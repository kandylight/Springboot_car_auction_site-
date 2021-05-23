<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Login to the Auction site</title>
</head>
<body>

	<h2>Login here</h2>
	<div>${message}</div>
	<br />

	<form action="LoginSubmit" method="post">

		<div class="label_login">
			<div>
				<label for="username">Username</label> <input type="text"
					name="username" required="required" />
			</div>
			<br />

			<div>
				<label for="password">Password</label> <input type="password"
					name="password" required="required" />
			</div>
		</div>
		<br />

		<div class="button">
			<button type="submit">Login</button>
		</div>
	</form>
</body>
</html>