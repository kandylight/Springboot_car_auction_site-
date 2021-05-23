<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Edit this buyer</title>
<style>
BODY {
	background-color: #F0FFFF;
	font-family: Helvetica, Arial, sans-serif;
	font-size: 13px;
	color: #363945;
	margin-left: 50px;
	margin-top: 50px;
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
	width:300px;
	border: 1px solid #939597;
	padding: 5px;
	float: right;
	margin-right: 800px;
	font-size: 12px;
}
</style>
</head>
<body>
	<h3>Edit this buyer</h3>
	<div>${message}</div>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/EditBuyerSubmit"
		modelAttribute="buyer">

		<div class="labels">
			<div>
				<sf:errors path="buyerName" />
				<sf:label path="buyerName">Buyer name</sf:label>
				<sf:input path="buyerName" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="buyerAddress" />
				<sf:label path="buyerAddress">Buyer address</sf:label>
				<sf:input path="buyerAddress" type="text" required="required" />
			</div>
		</div>
		<br />

		<div class="button">
			<sf:hidden path="buyerId" value="${buyerId}" />
			<input type="submit" value="Update buyer" /> <input type="submit"
				value="Delete" name="Delete" />
		</div>

	</sf:form>

</body>
</html>