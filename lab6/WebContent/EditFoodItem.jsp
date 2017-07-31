<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="adminHeader" uri="WEB-INF/admin-header.tld"%>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Food Item</title>
<link rel="stylesheet" href="../app_pri_lab4.css" type="text/css" />
</head>
<body>
<div style="max-width: 80%; margin: 0px auto">
	<adminHeader:AdminHeader/>
	<h2>Edit FoodItem</h2>
	<form method="post">
	<label for="name">Name: </label> <br>
	<input name="name" id="name" type="text" value="${item.name}"><br>
	<label for="url">Image Link: </label><br>
	<input name="imgurl" id="url" type="text" value="${item.imgURL}"><br>
	<label for="description">Description: </label><br>
	<input name="description" id="description" type="text" value="${item.description}"></input> <br>
	<label for="price">Price: </label><br>
	<input name="price" id="price" type="text" value="${item.price}"><br>
	<button>Update</button>
	</form>
		
</div>	
</body>
</html>