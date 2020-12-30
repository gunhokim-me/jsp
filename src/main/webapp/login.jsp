<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	
</script>

<style>
	label {
		display: inline-block;
		width : 100px;
	}
</style>
</head>
<body>
	<%--개인정보를 전송하므로 url에 노툴되지 않도록 request body 영억에 파라미터를 전송 ==> method="POST" --%>
	<form action="<%=request.getContextPath() %>/LoginController" method="POST">
		<label id="test">user id :</label><input type="text" name="userid" value="brown"/><br>
		<label id="test">user id :</label><input type="text" name="userid" value="sally"/><br>
		<label id="test">password :</label><input type="password" name="pass" value="qwe123"/><br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>