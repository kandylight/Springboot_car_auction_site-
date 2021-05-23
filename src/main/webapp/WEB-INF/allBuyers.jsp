<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
<title>Buyers list</title>
</head>
<body>
	<h3>Buyers list</h3>
	<div>${message}</div>
	<br />

	<table>
		<tr>
			<th>Edit</th>
			<th>Name</th>
			<th>Address</th>
		</tr>

		<c:forEach items="${allBuyers}" var="buyer">
			<tr>
				<td><a href="EditBuyer/${buyer.buyerId}">Edit this buyer</a></td>
				<td>${buyer.buyerName}</td>
				<td>${buyer.buyerAddress}</td>
			</tr>
		</c:forEach>
	</table>
	<br />

	<div>
		<a href="main">&#8592; Back</a>
	</div>
	
</body>
</html>