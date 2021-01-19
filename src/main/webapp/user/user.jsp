<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
<script>
	//문서 로딩이 완료 되었을 때
$(function(){
	$("#modifyBtn").on("click", function(){
		$("#frm").attr("method","get");		
		$("#frm").attr("action","${pageContext.request.contextPath}/userModify");
		$("#frm").submit();
	});
	$("#deleteBtn").on("click", function(){
		$("#frm").attr("method","post");		
		$("#frm").attr("action","${pageContext.request.contextPath}/deleteUser");
		$("#frm").submit();
	});
});
</script>
</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<%
				UserVo vo = (UserVo)request.getAttribute("uservo");
			%>
				<form class="form-horizontal" role="form" id="frm" action="${pageContext.request.contextPath}/userModify">
					<input type = "hidden" name="userid" value="<%=vo.getUserid() %>"/>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img alt="이미지 없음" src="${pageContext.request.contextPath}/profile/<%=vo.getUserid()%>.png">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getUserid() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getUsernm()%></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
						<label class="control-label">
							<%
								int a = vo.getPass().length();
								String test = vo.getPass();
								for(int i = 1; i <= a; i++){%>
									*
								<%}%>
								</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${user.reg_dt}" pattern="yyyy.MM.dd"/></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getAlias() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getAddr1() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getAddr2() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호 코드</label>
						<div class="col-sm-10">
							<label class="control-label"><%=vo.getZipcode() %></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
<!--						사용자 수정 : method - get = /userModify
							사용자 삭제 : mothod - post = /deleteUser
							파라미터는 둘다 userid 하나만 있으면 가능 -->
							<button type="button" id="modifyBtn" class="btn btn-default">사용자 수정</button>
							<button type="button" id="deleteBtn" class="btn btn-default">사용자 삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>