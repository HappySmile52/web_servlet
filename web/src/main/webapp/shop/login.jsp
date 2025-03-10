<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// out.print 적용했을 때 null 출력될 경우 (session) => 연산기호 사용 (equals 사용x)
	HttpSession hs = request.getSession();
	String mid = (String)hs.getAttribute("mid");
	String mnm = (String)hs.getAttribute("mnm");
	
	if(mid != null | mnm != null){	// 로그인이 되어있을 경우 다시 로그인 하지 못하도록 처리
		out.print("<script>"
				+ "alert('이미 로그인하셨습니다.');"
				+ "location.href='./main.jsp';"
				+ "</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<form id="frm" method="post" action="./shop_loginok.do" onsubmit="return loginck()">
<p>[회원 로그인]</p>
<div>
<label><input type="radio" name="spart" value="P" onclick="partcheck(this.value)" checked>일반 회원</label>
<label><input type="radio" name="spart" value="C" onclick="partcheck(this.value)">사업자 회원</label>
<br><br>
<input type="text" name="sid" placeholder="아이디를 입력하세요"><br>
<input type="password" name="spw" placeholder="패스워드를 입력하세요"><br>
<span id="snoview" style="display:none;">
<input type="text" name="sno" placeholder="사업자 번호를 입력하세요"><br>
</span>
<br>
<input type="submit" value="로그인">
</div>
</form>
</body>
<script src="./login.js?v=1"></script>
</html>