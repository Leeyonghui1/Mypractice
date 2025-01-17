<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
 <head>
  <title>책 상세</title>
 </head>
 <body>
  <h1>책 상세</h1>
  <p>제목 : ${data.title} </p>
  <p>카테고리 : ${data.category}</p>
  <p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}" /></p> 
  <%-- 날짜변환에서 오류가 발생함 (자바 버전 차이인데 정확한 이유는 모름) --%>
  <%-- <p>입력일 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss" /></p> --%>
  <%-- 위 표현식에서 오류가 발생하면 아래와 같이 써야함 --%>
  <fmt:parseDate value="${data.insert_date}" pattern="yyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both"/>
  <p>입력일 : <fmt:formatDate pattern="dd.MM.yyy HH:mm:ss" value="${parsedDateTime}"/> </p>	
  <p>
   <a href="/update?bookId=${bookId}">수정</a>
  </p>
  <form method="POST" action="/delete">
   <input type="hidden" name="bookId" value="${bookId}" />
   <input type="submit" value="삭제" />
  </form>
  <p>
   <a href="/list">목록으로</a>
  </p>
 </body>
</html>