<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Edit this car</title>
<style>
BODY {
	background-color: #F0FFFF;
	font-family: Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #363945;
	margin-left: 50px;
}

.button input {
	border: 1px solid #939597;
	padding: 5px;
	border-radius: 4px;
	background-color: #000000;
	color: #ffffff;
	font-size: 12px;
}

.labels div input {
	width: 300px;
	border: 1px solid #939597;
	padding: 5px;
	float: right;
	margin-right: 700px;
	font-size: 12px;
}

.labels div label {
	font-size: 13px;
}

div select {
	width: 300px;
	border: 1px solid #939597;
	float: right;
	padding: 5px;
	margin-right: 700px;
}
</style>
</head>
<body>

	<h3>Edit this car</h3>
	<div class="message">${message}</div>
	<br />

	<sf:form method="post"
		action="${pageContext.request.contextPath}/EditCarSubmit"
		modelAttribute="car">
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
				<sf:input path="description" type="text" required="required" />
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
			<sf:hidden path="carId" value="${carId}" />
			<input type="submit" value="Update car" /> <input type="submit"
				value="Delete" name="Delete" />
		</div>

	</sf:form>


</body>
</html>