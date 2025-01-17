<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list JSP</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div id="content">
		<h3>고객 목록</h3>
		<table class='w-pct60'>
			<tr>
				<th class='w-px60'>번호</th>
				<th class='w-px200'>고객명</th>
				<th>전화번호</th>
			</tr>
			<core:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.id}</td>
					<td><a href="detail.cu?id=${vo.id}">${vo.name}</a></td>
					<td>${vo.phone}</td>
				</tr>
			</core:forEach>
		</table>
	</div>
	<div class="btnSet">
		<a class="btn-fill" href="new.cu">신규 고객</a>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>