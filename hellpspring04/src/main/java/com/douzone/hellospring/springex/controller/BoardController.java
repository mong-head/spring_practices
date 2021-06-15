package com.douzone.hellospring.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 *  method 단독 mapping
 *  
 * @author melon
 * 
 *
 */

@Controller
public class BoardController {
	
	@ResponseBody  //message
	@RequestMapping(/*@RequestParam*/ "/board/write" ) //이게 있으면 이제 action이 필요없어짐
	public String write() {
		return "BoardController:write"; //jsp가 아님. browser에 바로 보냄
	}
	
	@ResponseBody  
	@RequestMapping("/board/view/{n}") 
	public String view(@PathVariable("n") Long boardNo) {
		return "BoardController:view("+boardNo+")"; //jsp가 아님. browser에 바로 보냄
	}
}
