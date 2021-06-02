package com.douzone.hellospring.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//annotaion
@Controller
public class HelloController {
	
	/*RequestBody annotation 없는 경우*/
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp"; //view 이름 return, forwarding 또 다른 곳에서 함
	}
	
	//parameter 받기
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp"; //view name
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name); //view name 뽑아내기
		mav.setViewName("/WEB-INF/views/hello3.jsp");  //view name 뽑아내기
		return mav; 
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute(name);
		return "/WEB-INF/views/hello4.jsp";   //string return
	}
}
