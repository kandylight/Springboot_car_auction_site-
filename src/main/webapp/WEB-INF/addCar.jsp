<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Add a Car here</title>
</head>
<body>
	<h3>Fill the form to add a new car</h3>
	<div>${message}</div>

	<sf:form method="post" action="AddCarSubmit" modelAttribute="car">

		<div class="labels">
			<div>
				<sf:errors path="make" />
				<sf:label path="make">Make</sf:label>
				<sf:input path="make" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="model" />
				<sf:label path="model">Model</sf:label>
				<sf:input path="model" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="fuelType" />
				<sf:label path="fuelType">Fuel Type</sf:label>
				<sf:input path="fuelType" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="transmission" />
				<sf:label path="transmission">Transmission</sf:label>
				<sf:input path="transmission" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="colour" />
				<sf:label path="colour">Colour</sf:label>
				<sf:input path="colour" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="co2Emission" />
				<sf:label path="co2Emission">Co2Emission</sf:label>
				<sf:input path="co2Emission" type="number" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="price" />
				<sf:label path="price">Price</sf:label>
				<sf:input path="price" type="currency" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="description" />
				<sf:label path="description">Description</sf:label>
				<sf:input path="description" type="text" />
			</div>
			<br />

			<div>
				<sf:errors path="seller" />
				<sf:label path="seller">Seller</sf:label>
				<sf:select path="seller" items="${allSellers}"
					itemLabel="sellerName" required="required" />
			</div>
		</div>
		<br />

		<div class="button">
			<input type="submit" value="Add car" />
		</div>

	</sf:form>
	<br />

	<div>
		<a href="main">&#8592; Back</a>
	</div>

</body>
</html>