<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success page</title>
<link rel="stylesheet" href="mystyle.css">

</head>
<body>
	<div class="result">
	<h2>Your product has successfully registered</h2>
	<p> Barcode:${barcode }<br><br>
		Name: ${name }<br><br>
		Color: ${color }<br><br>
		Description: ${description }<br><br>
	</p>
	<a href="index.html"> Add new product </a>
</div>
</body>
</html>