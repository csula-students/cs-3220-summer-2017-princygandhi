<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="adminHeader" uri="WEB-INF/admin-header.tld"%>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Removed</title>
<link rel="stylesheet" href="../app_pri_lab4.css" type="text/css" />
</head>
<body>
<div style="max-width: 80%; margin: 0px auto; text-align:center;">
	<adminHeader:AdminHeader/>

        <table cellpadding="10"  width="100%">
          <tr>
          <td>
              <h1> Selected food item has been removed successfully!</h1>
          </td>
          </tr>
          <tr>
          <td>
                <a href='./adminfoods'>Go back to Inventory.</a>
          </td>
          </tr>
          
        </table>

</div>


</body>
</html>