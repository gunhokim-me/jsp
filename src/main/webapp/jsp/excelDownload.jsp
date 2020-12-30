<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Content-Disposition header : 파일 다운로드, 업로드시 사용하는 파일과 관련된 헤더
	response.setHeader("Content-Disposition", "attachement; filename=excel.xls");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excel Download</title>
</head>
<body>
	<table>
		<tr>
			<th>userid</th>
			<th>이름</th>
		</tr>
		<tr>
			<th>brown</th>
			<th>브라운</th>
		</tr>
		<tr>
			<th>sally</th>
			<th>샐리</th>
		</tr>
		<tr>
			<th>cony</th>
			<th>코니</th>
		</tr>
	</table>
</body>
</html>