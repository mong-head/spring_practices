package com.douzone.hellospring.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping
 *  : class + handler(method)
 *  
 * */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET /*get 방식으로 받기*/)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST /*post 방식으로 받기*/)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/"; //main으로
	}
}
