<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/mystyle.css" />" />
<script>
function resize(){
  var f=document.getElementById('mainframe');
  var m=document.getElementById("main");
  var b=document.getElementById('bottom').getBoundingClientRect().top;
  f.style.height = b - 120 + 'px';
  m.style.height = b - 120 + 'px';
}
</script>

</head>

<body onload="resize()">
<div class="header">
<jsp:include page="header.jsp">
</jsp:include>
</div>

<div id="main" style="overflow: scroll; margin-left:20px">
<h1>Yellow River</h1>
<h2>Our Vision and Mission:</h2>
	Yellow River offer customers the best experience of online shopping of
	various books, magazines and related products and services. Whether
	it's a textbook or fiction, a best seller, or an old classic, you'll
	find the most incredible and unique assortment of books. 
	<h3>More than Books</h3>
		Our Yellow River Kids is the ideal destination for anyone
		looking for the best in children's books, videos, and music. With
		age-based recommendations, as well as specialty stores that cater to
		Harry Potter and other big titles, it's the ultimate one-stop shop for
		kids. Our E-book Store's 500+ titles make it the destination of choice
		for good e-books. You can view more than 10,000 pages of samples --
		and instantly order what you have seen -- making it the most
		customer-friendly site around. What’s more, Yellow River is a
		significant bridge between Chinese culture and American culture. We
		have more Chinese books and bilingual Chinese-English books than other
		online stores. So you can explore, read, and order more books related
		to Chinese culture. We are convinced that this can help you know more
		about Chinese culture and promote communications between two cultures.
		
	<h2>Our Business Strategy</h2>
	Almost books and related stuff is half the publisher's price or less.
	Our search engine enables customers to locate books by title, author,
	or keyword in a few seconds at most. Customers with a general idea of
	what they want can use our Main pages to sift through different
	categories to find exactly the right book. To further assist users, we
	offer descriptions and reviews to assistant customers to make their
	best deal.
<h2>Products and Services offered</h2>
		<ul>
			<li>Chinese books</li>
			<li>English books
			<li>E-books</li>
			<li>Childern's books</li>
			<li>CD/DVD</li>
		</ul>
</div>

<iframe id="mainframe" name="body" frameborder="0" width="100%" onload="resize()">
</iframe>

<div class="footer" id="bottom">
<jsp:include page="footer.jsp">
</jsp:include>
</div>
</body>
</html>