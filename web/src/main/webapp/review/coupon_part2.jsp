<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> data = (ArrayList)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 완료 페이지</title>
</head>
<body>
<p>쿠폰 등록 완료 페이지</p>
아이디 : <%=data.get(0)%><br>
쿠폰번호 : <%=data.get(1)%><br>
광고 수신 동의함
</body>
</html>