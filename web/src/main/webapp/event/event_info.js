function wordck(){
	// var w = "010-1234-5678";
	// let ck = /[0-9]/;	// true	// 0~9
	// let ck = /[a-z]/;	// false
	
	// var w = "010-1234-5678b";
	// let ck = /[a-zA-z]/;	// true	// a~z 소문자
	// console.log(ck.test(w));	// true, false 출력
	
	// var w = "010123-45678";
	// let ck = /^[0-9]/;	// 0~9 숫자 외에 단어
	// console.log(w.match(ck));	// 배열 형태의 값을 출력
	
	// var w = "a010123-45678";	// false
	// var w = "010123-45678";	// true
	// let ck = /^[0-9]/;
	
	// var w = "010123-45678";
	// let ck = /^[0-9]/g;	// true
	// let ck = /[0-9]/g;	// true
	
	// var w = "01012345678";
	// let ck = /[0-9]/g;	// true
	// let ck = /^\d{2,3}-\d{3,4}-\d{4}$/;	// false
	
	// var w = "010-1234-5678";
	// let ck = /^\d{2,3}-\d{3,4}-\d{4}$/;	// true
	
	// var w = "01012345678";
	// let ck = /^\d{2,3}-\d{3,4}-\d{4}$/;	// false
	
	// $ : 해당 패턴에 문자열을 대입하여 체크하는 방식
	// var w = "01012345678";
	// let ck = /^\d{2,3}\d{3,4}\d{4}$/;	// true
	console.log(ck.test(w));
}

function eventok(){
	if(f.ename.value==""){
		alert("고객명을 입력하세요!");
	}
	else if(f.etel.value==""){
		alert("연락처를 입력하세요!");
	}
	else if(f.email.value==""){
		alert("이메일을 입력하세요!");
	}
	else if(f.ememo.value==""){
		alert("이벤트 참여 이유를 입력하세요!");
	}
	else if(f.info1.checked == false){
		alert("개인 정보 활용에 동의하셔야만 이벤트에 참여가 가능합니다.");
	}
	else if(f.info2.checked == false){
		alert("제 3자의 정보 제공에 동의하셔야만 이벤트에 참여가 가능합니다.");
	}
	else{
		// 정규식 코드 사용 (연락처 확인)
		let ck = /^\d{2,3}\d{3,4}\d{4}$/;	// 숫자 외에 다른 문자일 경우 false
		if(ck.test(f.etel.value) == false){
			alert("연락처를 정상적으로 입력하세요.");
		}
		else{	// 정규식 코드 (true)
			f.submit();
		}
	}
}