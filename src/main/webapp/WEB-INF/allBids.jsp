<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Bid list</title>
</head>
<body>

	<h3>List of current bids</h3>
	<div class="message">${message}</div>
	<br />

	<table>
		<tr>
			<th>Edit</th>
			<th>Buyer</th>
			<th>Car</th>
			<th>Bid date</th>
			<th>Amount</th>
		</tr>

		<c:forEach items="${allBids}" var="bid">
			<tr>
				<td><a href="EditBid/${bid.bidId}">Edit this bid</a></td>
				<td><c:forEach items="${bid.buyer}" var="buyer">
						<div>${buyer.buyerName}</div>
					</c:forEach></td>
				<td><c:forEach items="${bid.car}" var="car">
						<div>${car.make}${car.model}</div>
					</c:forEach></td>
				<td>${bid.bidDate}</td>
				<td>${bid.amount}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	
	<div>
		<a href="main">&#8592; Back</a>
	</div>

</body>
</html>