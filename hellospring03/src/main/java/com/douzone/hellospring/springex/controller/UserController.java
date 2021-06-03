package com.douzone.hellospring.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		/*
		 * (@ModelAttribute UserVo vo)
		 * @ModelAttribute : login시 유용하게 사용
		 * 		jsp로 데이터 넘겨주는 거
		 */
		System.out.println(vo);
		return "redirect:/"; //main으로
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value="n", required=true, defaultValue="") String name) {
		/*
		 * <400 error 막는 방법>
		 * 1. required : false로 해주는 경우 n이 없더라도 에러를 보내지 않음
		 * 			@RequestParam(value="n", required=false)
		 * 			required : default - true
		 * 				만약 n이라는 이름의 parameter 없는 경우, 
		 * 				400 Bad Request 에러 발생 
		 * 2. 내부에서 null임을 검사 : 그닥 좋지 않음
		 * 3. required=true, defaultValue="" : good 방법, 근데 사실 param부분이 긴 것도 좋지는 않음
		 * 		defaultValue의 경우  parameter가 int라도 String으로 받아야함
		 * 			(@RequestParam(value="p", required=true, defalutValue="1") int page)
		 */
		// 2번 째 방법
//		if(name == null) {
//			name="";
//		}
		System.out.println("---"+name);
		return "UserController.update()";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value="n", required=true, defaultValue="") String name,
			@RequestParam(value="a", required=true, defaultValue="0") int age) {
		System.out.println("---" + name + ":" + age);
		return "UserController.update()";
	}
	
}
