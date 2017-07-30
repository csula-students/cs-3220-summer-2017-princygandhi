<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="adminHeader" uri="WEB-INF/admin-header.tld"%>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../app_pri_lab4.css" type="text/css" />
</head>
<body>
<div style="max-width: 80%; margin: 0px auto">
	<adminHeader:AdminHeader/>
	
		<h2>Food Menu</h2>
        <table cellpadding="10" border="1" width="100%">
          <thead><tr><th>Item</th><th>Description</th><th>Image</th><th>Price</th><th>Edit/Delete</th></tr></thead>
        
		  <c:forEach items = "${entries}" var="item">
				<tr>
				<td>${item.name}</td>
				<td>${item.description}</td>
				<td> <img src="${item.imgURL}" width="300"/></td>
			    <td>${item.price}</td>
				<td>
				   <a href='/edit?id=${item.id}'>Edit</a> <a href='./DeleteFoodItem?id=${item.id}'>Delete</a>
				</td>
				</tr>
			</c:forEach>
        </table>

</div>

<%-- <c:out value="Hello JSTL" />
<Addtag-add:add op1="3" op2="5" />--%>

</body>
</html>