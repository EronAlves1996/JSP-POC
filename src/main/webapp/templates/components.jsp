<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Components Test</title>
</head>
<body>
<h2>Componenting test</h2>
<p>Start component container</p>
<%= request.getAttribute("component") %>
<p>Stop component container</p>
</body>
</html>