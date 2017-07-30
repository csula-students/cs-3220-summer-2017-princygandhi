<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="adminHeader" uri="WEB-INF/admin-header.tld"%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../app_pri_lab4.css" type="text/css" />
</head>
<body>
<form   method="post" action="#">
<div style="max-width: 80%; margin: 0px auto">
	<adminHeader:AdminHeader/>
	
		<h2>Order Food</h2>
        <table cellpadding="10" border="1" width="100%">
          <thead><tr><th>Item</th><th>Qty</th><th>Total</th><th>Customer</th><th>Order Status</th></tr></thead>
        
				<c:forEach items = "${orderEntries}" var="item">
				<tr>
				<td>${item.getOrderName()}</td>
				<td>${item.qty}</td>
				<td>${item.total}</td>
			    <td>${item.customerName}  <input type='hidden' name='itemId' value="${item.id}"></td>
			    <td>
       <select name="ostatus_${item.id}">
           <option>In Progress</option>  
           <option>Completed</option>
       </select>
     
</td>
				</tr>
				</c:forEach>
        </table>
	 
	
<button>Update Statuses</button>
	</div>
	</form>
</body>
</html>