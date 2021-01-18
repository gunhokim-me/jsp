<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>times Tables</title>
<style>
	table{
		width : 100%;
		height : 500px;
		text-align: center;
		font-weight: bold;
		border-collapse: collapse;
		background-color: lightgreen;
	}
</style>
</head>
<body>
<h3>JSTL버전</h3>
	<table border="1">
		<c:forEach begin="1" end="9" var="i">
			<tr>
				<c:forEach begin="2" end="9" var="j">
					<td>${j} * ${i} = ${j*i}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>