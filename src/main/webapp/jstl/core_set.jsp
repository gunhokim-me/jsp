<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL : core_set</title>
</head>
<body>
<h3>set</h3>
	<%-- 속성을 생성하는 태그
	reqeust.setAttribute("속성명", 속성값); ==> set태그
	${속성명}, <%= request.getAttribute("속성명") %> --%>
	var : 속성명 <br>
	value : 속성값 <br>
	scope : 저장할 스코프(page, request, session, application)
	        *scope를 지정하지 않을 경우 page스코프가 적용됨
<c:set var="userid" value="brown" /><br><br>
userid : ${userid}<br>
userid-pageContext : <%=pageContext.getAttribute("userid") %><br>

<h3>remove</h3>
스코프에 저장된 속성을 제거 : request.removeAttribute("속성명"); <br>
<c:remove var="userid"/>
userid : ${userid}<br>
userid-pageContext : <%=pageContext.getAttribute("userid") %><br>
</body>
</html>