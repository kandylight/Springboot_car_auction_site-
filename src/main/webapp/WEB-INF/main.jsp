<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Auction site admin page</title>
</head>
<body>
	<h2>Welcome to the admin area of the auction site</h2>
	<div>${message}</div>

	<div class="link">
		<ul>
			<li><a href="AllBuyers">List of buyers in the database</a></li>
			<li><a href="AddBuyer">Add a buyer</a></li>
		</ul>

		<ul>
			<li><a href="AllSellers">List of sellers in the database</a></li>
			<li><a href="AddSeller">Add a seller</a></li>
		</ul>

		<ul>
			<li><a href="AllCars">List of cars in the database</a></li>
			<li><a href="AddCar">Add a car</a></li>
		</ul>

		<ul>
			<li><a href="AllBids">List of bids in the database</a></li>
			<li><a href="AddBid">Add a bid</a></li>
		</ul>
	</div>
	
	<div>
		<a href="home.html">&#8592; Back</a>
	</div>
</body>
</html>