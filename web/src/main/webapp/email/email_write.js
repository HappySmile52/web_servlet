function m_send(){
	if(frm.to_name.value == ""){
		alert("담당자 성함을 입력하세요.");
		frm.to_name.focus();
	}
	else if(frm.to_mail.value == ""){
		alert("회신 받을 메일 주소를 입력하세요.");
		frm.to_mail.focus();
	}
	else if(frm.subject.value == ""){
		alert("제목을 입력하세요.");
		frm.subject.focus();
	}
	else if(frm.context.value == ""){
		alert("내용을 입력하세요.");
		frm.context.focus();
	}
	else{
		frm.submit();
	}
}