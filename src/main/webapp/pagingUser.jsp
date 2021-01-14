<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>allUser</title>

<%@ include file="/common/common_lib.jsp"%>
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<script>
	//문서가 로딩이 완료되고 나서 실행되는 영역
	$(function(){
		$(".user").on("click", function(){
			//this : 클릭 이벤트가 발생한 element
			//data-속성명  data-userid, 속성명은 대소문자를 가리지 않고 소문자로 인식
			var userid = $(this).data("userid")
			$("#userid").val(userid);
			console.log(1)
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
<form id="frm" action="<%=request.getContextPath()%>/user">
	<input type="hidden" id="userid" name="userid" value=""/>
</form>

	<!-- 헤더 추가 -->
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
			<!-- 레프트 추가 -->
				<%@ include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								<%	
									List<UserVo> list = (List<UserVo>)request.getAttribute("userList");
									for(UserVo vo : list){
								%>
								<tr class="user" data-userid=<%=vo.getUserid()%>>
									<td><%=vo.getUserid()%></td>
									<td><%=vo.getUsernm()%></td>
									<td><%=vo.getAlias()%></td>
									<td><%=vo.getReg_dt_fmt()%></td>
								</tr>
								<%
									}
								%>
							</table>
						</div>
						<a class="btn btn-default pull-right" href="/user/registUser.jsp">사용자 등록</a>
						<div class="text-center">
							<ul class="pagination">
							<li><a href="<%=request.getContextPath()%>/pagingUser?page=1&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span>«</span></a></li>
								<%
									int num = ((PageVo)request.getAttribute("pageVo")).getPage();
									int userCnt = (Integer) request.getAttribute("pagination");
									int cnt = 0;
									if(num != 1 && (num+3) <= 5) {%>
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=1&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span>1</span></a></li>
								<%}else if(num != 1 && (num+3) > 5){%>
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=1&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span>1</span></a></li>
									<li class="prev disabled"><span>---</span></li>
								<%}%>
								<%for (int i = num; i <= userCnt; i++) {
									cnt++;
									if(num == i && i > 2){ cnt += 2;%>
										<li><a href="<%=request.getContextPath()%>/pagingUser?page=<%=i-2%>&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span><%=i-2 %></span></a></li>
										<li><a href="<%=request.getContextPath()%>/pagingUser?page=<%=i-1%>&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span><%=i-1 %></span></a></li>
										<li class="active"><span><%=i %></span></li>	
									<%}else if(num == i && i <= 2){%>
										<li class="active"><span><%=i %></span></li>	
									<%}else{
										if(cnt <= 5){ %>
											<li><a href="<%=request.getContextPath()%>/pagingUser?page=<%=i%>&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span><%=i %></span></a></li>
									<% }%>
								<% } %>
								<% } if(num+2 == userCnt){%>
										<li class="next"><a href="<%=request.getContextPath()%>/pagingUser?page=<%=userCnt%>&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>">»</a></li>
								<%}else{ %>
									<li class="prev disabled"><span>---</span></li>
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=<%=userCnt %>&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>"><span><%=userCnt %></span></a></li>
									<li class="next"><a href="<%=request.getContextPath()%>/pagingUser?page=<%=userCnt%>&pageSize=<%=((PageVo)request.getAttribute("pageVo")).getPageSize()%>">»</a></li>
								<%} %>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
