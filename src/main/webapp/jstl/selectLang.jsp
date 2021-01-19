<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common/common_lib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SELECTLANG</title>
<script>
	$(function(){
		$("select").change(function(){
			var lang = $(this).val();
			$("#langs").val(lang);
			$("#lang").submit();
		});
		$("select").val("${param.langs}");
	});
</script>

</head>
<body>
<!-- select box로 설정한 언어로 GREETING, LANG 값을 표현
	 select box는 사용자가 설정한 언어 값으로 선택이 되어 있게 설정 -->
<form id="lang" action="${cp}/jstl/selectLang.jsp" method="get">
	<input type="hidden" id="langs" name="langs" value=""/>
</form>
<select name="sel">
	<option value="ko" >한국어</option>
	<option value="en" >English</option>
	<option value="ja" >日本語</option>
	<option value="aa" >기타</option>
</select>

<br>
<fmt:setLocale value="${param.langs }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/><br>
	<fmt:message key="GREETING" >
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

</body>
</html>