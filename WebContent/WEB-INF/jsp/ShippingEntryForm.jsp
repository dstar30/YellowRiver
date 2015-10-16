<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yellow River</title>
</head>
<body style="margin-left: 20px;">
<h2>Shipping Information</h2>
<form:form modelAttribute="shippingInfo" method="post" action="/YellowRiver/purchase/submitShipping">
    <table class="table table-striped">
        <tr>
	     <td>Name:</td>
         <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
	     <td>Address Line 1:</td>
         <td><form:input type="text" path="addressLine1"/></td>
        </tr>
        <tr>
	     <td>Address Line 2:</td>
         <td><form:input type="text" path="addressLine2"/></td>
        </tr>
        <tr>
	     <td>City:</td>
         <td><form:input type="text" path="city"/></td>
        </tr>
        <tr>
	     <td>State:</td>
         <td><form:input type="text" path="state"/></td>
        </tr>
        <tr>
	     <td>ZIP:</td>
         <td><form:input type="text" path="zip"/></td>
        </tr>
    </table>
    <input type="submit" class="btn-primary" name="Submit" value="Submit" />
</form:form>
</body>
</html>