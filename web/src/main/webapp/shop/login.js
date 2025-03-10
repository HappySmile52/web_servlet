function partcheck(part){
	var snoview = document.getElementById("snoview");
	
	if(part == "C"){
		snoview.style.display = "block";
	}
	else{
		snoview.style.display = "none";
	}
}

function loginck(){
	if(frm.sid.value == ""){
		alert("아이디를 입력하세요.");
		return false;
	}
	else if(frm.spw.value == ""){
		alert("패스워드를 입력하세요");
		return false;
	}
	else{
		if(frm.spart[0].checked == true){	// 일반 회원 체크
			// frm.submit();
			return true;
		}
		else if(frm.spart[1].checked == true){	// 사업자 회원 체크
			if(frm.sno.value == ""){
				alert("사업자 번호를 입력하세요");
				return false;
			}
			else if(frm.sno.value.length < 10){
				alert("올바른 사업자 번호를 입력하세요");
				return false;
			}
			else{
				return true;
			}
		}
	}
}