<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 [약관동의]</title>
</head>
<body>
<form id="frm" method="get" action="./part2.do">
<p>회원가입 약관</p>
<!-- get으로 보내면 URL에 값이 보인다. -->
<!-- id 값은 중복이 되면 안 됨 -->
<input type="checkbox" id="all" onclick="all_check(this.checked)">전체선택<br>
<input type="checkbox" name="agree" value="Y0" onclick="ag_check()">서비스 이용약관 동의 (필수)<br>
<input type="checkbox" name="agree" value="Y1" onclick="ag_check()">개인정보 수집 및 이용 (필수)<br>
<input type="checkbox" name="agree" value="Y2" onclick="ag_check()">이메일 정보 수신 약관 (필수)<br>
<input type="checkbox" name="agree" value="Y3" onclick="ag_check()">광고성 정보 수신 (선택)<br><br>
<input type="button" value="회원가입" onclick="go_page()">
</form>
</body>
<script>
function go_page(){	// part2.do로 전송
	if(frm.agree[0].checked == true && frm.agree[1].checked == true && frm.agree[2].checked == true){
		frm.submit();
	}
	else{
		alert("필수 조건은 무조건 동의하셔야만 회원가입이 진행됩니다.");
	}
}

var all_check = function(z){
	// console.log(z);	// 전체선택 체크하면 true, 해제하면 false
	
	var ob = frm.agree;	// form 태그 안에서 agree라는 name명을 가진 오브젝트 전체
	// console.log(ob);
	var ea = ob.length;
	// console.log(ea);
	
	var w = 0;
	do{
		ob[w].checked = z;	// 같은 이름의 name 값은 배열로 순차적으로 처리됨
		w++;
	}while(w < ea);
}

// 하나라도 false일 경우 전체 선택을 해제 또는 모두 체크가 되었을 경우 전체 선택이 체크됨
var ag_check = function(){	 
	var ob = frm.agree;
	var ea = ob.length;
	
	var w = 0;
	var count = 0;
	while(w < ea){
		if(ob[w].checked == true){
			count++;
		}
		w++;
	}
	
	if(ea == count){
		document.getElementById("all").checked = true;
	}
	else{
		document.getElementById("all").checked = false;
	}
}
</script>
</html>