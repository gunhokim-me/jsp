<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>총합</title>
</head>
<body>
처음 값: <%=request.getAttribute("start")%><br>
마지막 값 : <%= request.getAttribute("end")%> <br>
두 수 사이의 합 : <%=session.getAttribute("sumResult") %>
</body>
</html>