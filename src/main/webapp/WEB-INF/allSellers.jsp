<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Sellers List</title>
</head>
<body>

	<h3>Sellers list</h3>
	<div class="message">${message}</div>
	<br />

	<table>
		<tr>
			<th>Edit</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
		</tr>

		<c:forEach items="${allSellers}" var="seller">
			<tr>
				<td><a href="EditSeller/${seller.sellerId}">Edit this
						seller</a></td>
				<td>${seller.sellerName}</td>
				<td>${seller.sellerAddress}</td>
				<td>${seller.sellerEmail}</td>
			</tr>
		</c:forEach>
	</table>
	<br />

	<div>
		<a href="main">&#8592; Back</a>
	</div>

</body>
</html>