<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Date day = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매</title>
</head>
<body>
<form id="frm" method="post" action="./movieok.do">
<p>영화 예매 시스템</p>
고객명 : <input type="text" name="mname"><br>
연락처 : <input type="text" name="mtel" maxlength="11"> "-" 없이 숫자만 입력<br>
<p>영화 선택</p>
<label><input type="radio" name="movie" value="히트맨2">히트맨2</label><br>
<label><input type="radio" name="movie" value="써니데이">써니데이</label><br>
<label><input type="radio" name="movie" value="브루탈리스트">브루탈리스트</label><br>
<label><input type="radio" name="movie" value="히어">히어</label><br>
<label><input type="radio" name="movie" value="하얼빈">하얼빈</label><br>
<br>
예매 일자 : <input type="date" id="date" name="date" min="<%=sf.format(day)%>"><br><br>
<input type="button" value="예매하기" onclick="book()">
</form>
</body>
<script>
function book(){
	var movie = document.getElementsByName("movie");
	var movie_ch = false;
	for(var f = 0; f < movie.length; f++){
		if(movie[f].checked){
			movie_ch = true;
			break;
		}
	}
	
	var date = document.getElementById("date").value;
	
	if(frm.mname.value == ""){
		alert("고객명을 입력하세요.");
	}
	else if(frm.mtel.value == ""){
		alert("연락처를 입력하세요.");
	}
	else if(!movie_ch){
		alert("영화를 선택해주세요.");
	}
	else if(date == ""){
		alert("예매 일자를 선택해주세요.");
	}
	else{
		frm.submit();
	}
}
</script>
</html>