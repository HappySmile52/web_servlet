function book(){
	if(frm.mid.value == ""){
		alert("아이디를 입력하세요.");
		frm.mid.focus();
	}
	else if(frm.mno.value == ""){
		alert("쿠폰 번호를 입력하세요.");
		frm.mno.focus();
	}
	else if(frm.ad.checked == false){
		 alert("광고 수신 동의를 하셔야 쿠폰 등록이 가능합니다.");
	}
	else{
		frm.submit();
	}
}