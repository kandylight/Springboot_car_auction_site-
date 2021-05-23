<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTP-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Add a Seller here</title>
</head>
<body>

	<h3>Fill the form to add a new seller</h3>
	<div>${message}</div>

	<form method="post" action="AddSellerSubmit">

		<div class="labels">
			<div>
				<label for="sellerName">Seller name</label> <input type="text"
					name="sellerName" />
			</div>
			<br />

			<div>
				<label for="sellerAddress">Seller address</label> <input type="text"
					name="sellerAddress" />
			</div>
			<br />

			<div>
				<label for="sellerEmail">Seller email</label> <input type="email"
					name="sellerEmail" />
			</div>


		</div>
		<br />

		<div class="button">
			<button type="submit">Add seller</button>
		</div>

	</form>
	<br />

	<div>
		<a href="main">&#8592; Back</a>
	</div>

</body>
</html>