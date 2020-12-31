<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table border="1">
		<% for(int i = 1; i <= 9; i++){
			out.write("<tr>");
			for(int j = 2; j <= 9; j++){
				out.write("<td>"+j+" * " + i +" = " + (j*i) +"</td>");
				}
			out.write("</tr>");
				}
			%>
		
	</table>

</body>
</html>