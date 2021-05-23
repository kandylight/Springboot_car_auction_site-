<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Edit this bid</title>
<style>
BODY {
	background-color: #F0FFFF;
	font-family: Helvetica, Arial, sans-serif;
	font-size: 13px;
	color: #363945;
	margin-left: 50px;
	margin-top: 50px;
}

div select {
	width: 300px;
	border: 1px solid #939597;
	padding: 5px;
	float: right;
	margin-right: 800px;
	font-size: 12px;
	margin-bottom: 5px;
}

.button input {
	border: 1px solid #939597;
	padding : 5px;
	border-radius: 4px;
	background-color: #000000;
	color: #ffffff;
	padding: 5px;
	font-size: 12px;
}

.labels div input {
	width: 280px;
	border: 1px solid #939597;
	padding: 5px;
	float: right;
	margin-right: 800px;
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div class="body">
		<h3>Edit this bid</h3>
		<div class="message">${message}</div>

		<sf:form method="post"
			action="${pageContext.request.contextPath}/EditBidSubmit"
			modelAttribute="bid">

			<div class="labels">
				<div>
					<sf:errors path="buyer"></sf:errors>
					<sf:label path="buyer">Buyer</sf:label>
					<sf:select path="buyer" items="${allBuyers}" itemLabel="buyerName"
						required="required"></sf:select>
				</div>
				<br />

				<div>
					<sf:errors path="car"></sf:errors>
					<sf:label path="car">Car</sf:label>
					<sf:select path="car" items="${allCars}" itemLabel="make"
						required="required"></sf:select>
				</div>
				<br />

				<div>
					<sf:errors path="bidDate"></sf:errors>
					<sf:label path="bidDate">Date</sf:label>
					<sf:input path="bidDate" type="date" required="required" />
				</div>
				<br />

				<div>
					<sf:errors path="amount"></sf:errors>
					<sf:label path="amount">Amount</sf:label>
					<sf:input path="amount" type="currency" required="required" />
				</div>
			</div>
			<br />

			<div class="button">
				<sf:hidden path="bidId" value="${bidId}" />
				<input type="submit" value="Update bid" /> <input type="submit"
					value="Delete" name="Delete" />
			</div>

		</sf:form>
	</div>
</body>
</html>