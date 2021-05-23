<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Add a Buyer here</title>
</head>
<body>

	<h3>Fill the form to add a new buyer</h3>
	<div>${message}</div>

	<form method="post" action="AddBuyerSubmit">

		<div class="labels">
			<div>
				<label for="buyerName">Buyer name</label> <input type="text"
					name="buyerName" />
			</div>
			<br />

			<div>
				<label for="buyerAddress">Buyer address</label> <input type="text"
					name="buyerAddress" />
			</div>
		</div>
		<br />

		<div class="button">
			<button type="submit">Add buyer</button>
		</div>

	</form>
	<br />

	<div>
		<a href="main">&#8592; Back</a>
	</div>

</body>
</html>