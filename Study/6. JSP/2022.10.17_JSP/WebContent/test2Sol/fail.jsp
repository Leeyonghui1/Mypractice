<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{color:violet; background:pink}
</style>
</head>
<body>
	<%! String birth; %>
	
	<%
		birth = request.getParameter("birth");
		System.out.println(birth+"값은 이상함");
	%>
	
	<h1>당신은 잘못된 값을 입력했습니다. <%=birth %>는 잘못된 값입니다.</h1>
	<a href="T2.html">처음으로</a>
</body>
</html>