<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Car list</title>
</head>
<body>

	<h3>List of cars available for bidding</h3>
	<div class="message">${message}</div>
	<br />


	<table>
		<tr>
			<th>Edit</th>
			<th>Make</th>
			<th>Model</th>
			<th>Fuel Type</th>
			<th>Transmission</th>
			<th>Colour</th>
			<th>Co2Emission</th>
			<th>Price</th>
			<th>Description</th>
			<th>Seller</th>
		</tr>

		<c:forEach items="${allCars}" var="car">
			<tr>
				<td><a href="EditCar/${car.carId}">Edit this car</a></td>
				<td>${car.make}</td>
				<td>${car.model}</td>
				<td>${car.fuelType}</td>
				<td>${car.transmission}</td>
				<td>${car.colour}</td>
				<td>${car.co2Emission}</td>
				<td>${car.price}</td>
				<td>${car.description}</td>
				<td>${car.seller.sellerName}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	
	<div>
		<a href="main">&#8592; Back</a>
	</div>

</body>
</html>