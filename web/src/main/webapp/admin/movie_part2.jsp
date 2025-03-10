<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	String mname = (String)request.getAttribute("mname");
	String mtel = (String)request.getAttribute("mtel");
	String movie = (String)request.getAttribute("movie");
	// String date = (String)request.getAttribute("date");
	String date[] = (String[])request.getAttribute("dates");
	*/
	
	ArrayList<String> data = (ArrayList)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 확인</title>
</head>
<body>
<p>영화 예매 확인</p>
고객명 : <%=data.get(0)%><br>
연락처 : <%=data.get(1)%><br>
영화 선택 : <%=data.get(2)%><br>
예매 일자 : <%=data.get(3)%>년 <%=data.get(4)%>월 <%=data.get(5)%>일<br><br>

<%--
<p>영화 예매 확인</p>
고객명 : <%=mname%><br>
연락처 : <%=mtel%><br>
영화 선택 : <%=movie%><br>
예매 일자 : <%
	out.print(date[0] + "년 " + date[1] + "월 " + date[2] + "일");
%><br><br>
 --%>
<input type="button" value="확인" onclick="location.href='./movie_part1.jsp';">
</body>
</html>