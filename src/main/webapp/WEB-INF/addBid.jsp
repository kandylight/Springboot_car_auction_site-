<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Add a Bid here</title>
</head>
<body>

	<h3>Fill the form to add a new bid</h3>
	<div>${message}</div>

	<sf:form method="post" action="AddBidSubmit" modelAttribute="bid">

		<div class="label">
			<div>
				<sf:errors path="buyer"></sf:errors>
				<sf:label path="buyer">Buyer</sf:label>
				<sf:select path="buyer" items="${allBuyers}" itemLabel="buyerName"></sf:select>
			</div>
			<br />

			<div>
				<sf:errors path="car"></sf:errors>
				<sf:label path="car">Car</sf:label>
				<sf:select path="car" items="${allCars}" itemLabel="carId"></sf:select>
			</div>
			<br />

			<div>
				<sf:errors path="bidDate"></sf:errors>
				<sf:label path="bidDate">Date</sf:label>
				<sf:input path="bidDate" type="date"></sf:input>
			</div>
			<br />

			<div>
				<sf:errors path="amount"></sf:errors>
				<sf:label path="amount">Amount</sf:label>
				<sf:input path="amount" tyrpe="currency"></sf:input>
			</div>
		</div>
		<br />

		<div class="button">
			<input type="submit" value="Add bid" />
		</div>
	</sf:form>
	<br />

	<div>
		<a href="main">&#8592; Back</a>
	</div>



</body>
</html>