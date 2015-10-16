<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yellow River</title>
</head>
<body style="margin-left: 20px;">
<br>
<form method="POST" action="/YellowRiver/purchase/ConfirmOrder">
<input type="submit" class="btn-primary" value="Confirm" name="Confirm"/>
</form>
<h2>Order Information</h2>
<table class="table table-striped">
<tr>
 <td>BookName</td>
 <td>Quantity</td>
</tr>
<tr>
 <td>Windows</td>
 <td>${order.list[0].quantity}</td>
</tr>
<tr>
<td>Linux</td>
<td>${order.list[1].quantity}</td>
</tr>
<tr>
<td>Unix</td>
<td>${order.list[2].quantity}</td>
</tr>
</table>
<h2>Payment Information</h2>
<table class="table table-striped">
<tr>
<td>Credit Card Number:</td>
<td>${paymentInfo.credit_card_number}</td>
</tr>
<tr>
<td>Expiration Date:</td>
<td>${paymentInfo.expiration_date}</td>
</tr>
<tr>
<td>cvvCode:</td>
<td>${paymentInfo.cvvCode}</td>
</tr>
<tr>
<td>Card Holder Name:</td>
<td>${paymentInfo.card_holder_name}</td>
</tr>
</table>

<h2>Shiping Information</h2>
<table class="table table-striped">
<tr>
 <td>Name:</td>
 <td>${shippingInfo.name}</td>
</tr>
<tr>
<td>addressLine1:</td>
<td>${shippingInfo.addressLine1}</td>
</tr>
<tr>
<td>addressLine1:</td>
<td>${shippingInfo.addressLine1}</td>
</tr>
<tr>
<td>City:</td>
<td>${shippingInfo.city}</td>
</tr>
<tr>
<td>State:</td>
<td>${shippingInfo.state}</td>
</tr>
<tr>
<td>ZIP:</td>
<td>${shippingInfo.zip}</td>
</tr>
</table>
</body>
</html>