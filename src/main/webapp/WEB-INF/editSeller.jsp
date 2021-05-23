<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit this seller</title>
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
	width: 300px;
	border: 1px solid #939597;
	padding: 5px;
	float: right;
	margin-right: 800px;
	font-size: 12px;
}
</style>
</head>
<body>


	<h3>Edit this seller</h3>
	<div>${message}</div>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/EditSellerSubmit"
		modelAttribute="seller">
		
		<div class="labels">
			<div>
				<sf:errors path="sellerName" />
				<sf:label path="sellerName">Seller name</sf:label>
				<sf:input path="sellerName" type="text" required="required" />
			</div>
			<br />

			<div>
				<sf:errors path="sellerAddress" />
				<sf:label path="sellerAddress">Seller address</sf:label>
				<sf:input path="sellerAddress" type="text" required="required" />
			</div>
		</div>
		<br />

		<div class="button">
			<sf:hidden path="sellerId" value="${sellerId}" />
			<input type="submit" value="Update seller" /> <input type="submit"
				value="Delete" name="Delete" />
		</div>

	</sf:form>


</body>
</html>