<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yellow River</title>
</head>
<body style="margin-left: 20px;">
<h2>Order Entry</h2>
<form:form modelAttribute="order" method="post" action="/YellowRiver/purchase/submitItems">
    <table class="table table-striped">
        <tr>
	     <td>Book Name</td>
         <td>Quantity</td>
        </tr>
        <tr>
	     <td>HarryPotter</td>
         <td><form:input type="text" path="items[0].quantity"/></td>
        </tr>
        <tr>
	     <td>HungerGame</td>
         <td><form:input type="text" path="items[1].quantity"/></td>
        </tr>
        <tr>
	     <td>SecretGarden</td>
         <td><form:input type="text" path="items[2].quantity"/></td>
        </tr>

    </table>
    <input class="btn-primary" type="submit" name="submit" value="Submit" />
</form:form>
<c:out value="${sessionScope.warning}"/>

</body>
</html>