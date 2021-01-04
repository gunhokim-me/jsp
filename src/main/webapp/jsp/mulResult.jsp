<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%=request.getAttribute("param1") %> * <%= request.getAttribute("param2") %> ==> <%= session.getAttribute("mulResult") %>
</body>
</html>