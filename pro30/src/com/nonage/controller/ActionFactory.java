package com.nonage.controller;

import com.nonage.controller.action.*;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	public ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory " + command);
		//여기서부터 명령어에 해당되는 클래스들의 객체를 생성하여 action에 담습니다.
		
		if(command == null || command.equals("index")) {
			action = new IndexAction();
		} else if(command.equals("login_form")) {
			action = new LoginFormAction();
		} else if(command.equals("login")) {
			action = new LoginAction();
		} else if(command.equals("contract")) {
			action = new ContractAction();
		} else if(command.equals("join_form")) {
			action = new JoinFormAction();
		} else if(command.equals("join")) {
			action = new JoinAction();
		} else if(command.equals("logout")) {
			action = new LogoutAction();
		} else if(command.equals("cart_list")) {
			action = new CartListAction();
		} else if(command.equals("mypage")) {
			action = new MyPageAction();
		} else if(command.equals("qna_list")) {
			action = new QnaListAction();
		}
		
		return action;
	}
}
