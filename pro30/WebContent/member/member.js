function isEmpty() {             //아이디, 패스워드 입력 확인 메서드
	if(document.loginForm.id.value == "" && document.loginForm.pwd.value != "") {    //아이디를 입력하지 않은 경우              
		alert("아이디를 입력해주세요.");
		document.loginForm.id.focus();
	} else if (document.loginForm.pwd.value == "" && document.loginForm.id.value != ""){     //비밀번호를 입력하지 않은 경우   
		alert("비밀번호를 입력해주세요.");
		document.loginForm.pwd.focus(); 
	} else if (document.loginForm.id.value == "" && document.loginForm.pwd.value == ""){            //아이디와 비밀번호 모두 입력하지 않은 경우      
		alert("아이디와 비밀번호를 입력하지 않으셨습니다."); 
		document.loginForm.id.focus();
	} else {   
		document.loginForm.submit();
	}
}





function go_next() {
	//alert("join");
	
	//1. 동의함을 체크했을 시 command=join_form 으로 전달합니다.
	if(document.formJoin.okon1[0].checked == true){
		//alert("동의함");
		//document.formJoin.action ="NonageShop?command=join_form";
		document.formJoin.submit();
	}
	//2. 동의 안함을 체크했을 시 "약관에 동의하셔야만 합니다." 알림창만 띄웁니다.
	else{
		alert("약관에 동의하셔야만 합니다.");
	}
}
