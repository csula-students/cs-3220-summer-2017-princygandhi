<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="customerheader" uri="WEB-INF/customer-header.tld"%>        
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" href="../app_pri_lab4.css" type="text/css" />
</head>
<body>
<form method="post">
<div style="max-width: 80%; margin: 0px auto">
	<customerheader:CustomerHeader/>
		<h2>Food Menu</h2>
        <table cellpadding="10" border="1" width="100%">
          <thead><tr><th>Item</th><th>Description</th><th>Image</th><th>Price</th><th>Qty</th></tr></thead>
        
				<c:forEach items = "${fooditems}" var="item">
				<tr>
				<td>${item.name}</td>
				<td>${item.description}</td>
				<td> <img src="${item.imgURL}" width="300"/></td>
			    <td>${item.price}</td>
			    <td> <input type='text' width='10px' name='fitem_id_" + ${item.id} + "' value='0' /> 
			         <input type='hidden' name='fid_"+ ${item.id} +"' value="${item.id}">
			    </td> 
				</tr>
				</c:forEach>
        </table>
	    <button>Add to Cart</button> 
	
	</div>
	</form>
	
</body>
</html>