<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	fieldset{
		width : 100px;
	}
	input{
		margin-bottom: 5px;
	}
</style>
</head>
<body>
<fieldset>
	<legend>두 수 사이의 합</legend>
		<form action="/sumCalculation" method="post">
			<input type="text" name="start" placeholder="처음 값"/><br> 
			<input type="text" name="end" placeholder="마지막 값"/><br> 
			<input type="submit" value="전송"/> 
		</form>
</fieldset>

<fieldset>
	<legend>두 수 사이의 곱</legend>
		<form action="/mulCalculation" method="post">
			<input type="text" name="param1" placeholder="처음 값"/><br> 
			<input type="text" name="param2" placeholder="마지막 값"/><br> 
			<input type="submit" value="전송"/> 
		</form>
</fieldset>
</body>
</html>