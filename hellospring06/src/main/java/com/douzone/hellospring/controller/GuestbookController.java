package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * RequestMapping
 * 클래스(type) 단독 mapping
 * - interceptor추가 후 문제가 생겨서 class+handler mapping사용
 * 
 * @author melon
 * */

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete() {
		return "GuestbookController:delete";
	}
	
	
}
