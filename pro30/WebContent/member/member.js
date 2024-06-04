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


function go_save() {
	//alert("join");
	
	var formJoin = document.formJoin;
	
	if(formJoin.id.value == "") {           //1. 아이디 입력하지 않았을 경우
		alert("아이디를 입력하여 주세요.");
		formJoin.id.focus();
	} else if(formJoin.pwd.value == "") {   //2. 비밀번호를 입력하지 않았을 경우
		alert("비밀번호를 입력해 주세요.");
		formJoin.pwd.focus();
	} else if(formJoin.pwdCheck.value == "") {   //3. 비밀번호를 다시 한번 입력하지 않았을 경우
		alert("비밀번호를 다시 한번 입력해주세요.");
		formJoin.pwdCheck.focus();
	} else if(formJoin.pwd.value != formJoin.pwdCheck.value) {   //4. 비밀번호가 일치하지 않았을 경우
		alert("비밀번호가 일치하지 않습니다.");
		formJoin.pwd.focus();
	} else if(formJoin.name.value == "") {      //5. 이름을 입력하지 않았을 경우
		alert("이름을 입력해 주세요.");
		formJoin.name.focus();
	} else if(formJoin.email.value == "") {   //6. 이메일을 입력하지 않았을 경우
		alert("이메일을 입력해 주세요.");	
		formJoin.email.focus();
	} else {
		formJoin.submit();
	}
}

function post_zip() {
	var url = "NonageShop?command=find_zip_num";
	window.open( url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300");
}

function idcheck() {

	if(document.formJoin.id.value == "") {
		alert("아이디를 입력하여 주십시오.");
		document.formJoin.id.focus();
		return;
	}
	
	//팝업 띄울 예정
	var url = "NonageShop?command=id_check_form&id=" + document.formJoin.id.value;
	window.open( url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300");
}