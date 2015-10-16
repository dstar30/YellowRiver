<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
function hide(){
  document.getElementById('main').style.display = 'none';
}
</script>
</head>
<body>
<center>
<h1 style="font-family:Connie;">Yellow River</h1>
<table>
<th><a href="/YellowRiver">Home</a></th>
<th><a href="/YellowRiver/purchase"  target="body" onclick="hide()">Purchase</a></th>
<th><a href="/YellowRiver/about"  target="body" onclick="hide()">About</a></th>
<th><a href="/YellowRiver/contact"  target="body" onclick="hide()">Contact</a></th>
</table>
</center>
</body>
</html>