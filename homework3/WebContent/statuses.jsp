<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="customerheader" uri="WEB-INF/customer-header.tld"%>      
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../app_pri_lab4.css" type="text/css" />
</head>
<body>
<div style="max-width: 80%; margin: 0px auto">
	<customerheader:CustomerHeader/>
	
		<h2>Your Order</h2>
        <table cellpadding="10" border="1" width="100%">
          <thead><tr><th>Item</th><th>Qty</th><th>Total</th><th>Customer</th><th>Status</th></tr></thead>
        
				<c:forEach items = "${orderEntries}" var="item">
				<tr>
				<td>${item.getOrderName()}</td>
				<td>${item.qty}</td>
				<td>${item.total}</td>
			    <td>${item.customerName}</td>
			    <td>
			   		${item.ostatus}
			    </td>
				</tr>
				</c:forEach>
        </table>
	 
	
	</div>
</body>
</html>