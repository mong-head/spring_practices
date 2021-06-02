package com.douzone.hellospring.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * RequestMapping
 * 클래스(type) 단독 mapping
 * 
 * @author melon
 * */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController:delete";
	}
	
	
}
