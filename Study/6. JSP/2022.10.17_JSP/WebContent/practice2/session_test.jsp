<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration enu = session.getAttributeNames();
		int i = 0;
		while(enu.hasMoreElements())
		{
			i++; // 키 값 읽을때마다 i값 증가
			String sName = enu.nextElement().toString();
			String sValue = (String)session.getAttribute(sName);
			System.out.println("sName : "+sName);
			System.out.println("sValue : "+sValue);
		}
		out.println("남아 있는 세션의 수 : "+i);
	%>
</body>
</html>