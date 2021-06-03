package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	// contextLoadListener로 만들어진 Root Application Context의 EmaillistRepository사용
	@Autowired // 의존성 주입 관련; wiring; Web Application Context에서 없는 EmaillistRepository에 대해 부모인 Root Application Context에서 자동으로 찾기 함
	private EmaillistRepository emaillistRepository; 
	
	@RequestMapping("")
	public String index(Model model) {
		/* 전에 사용했을 때 */
		//List<EmaillistVo> list = new EmaillistRepository().findAll(); 
		//model.addAttribute("list",list);
		
		/*Root Application Context내의 EmaillistRepository객체 사용*/
		List<EmaillistVo> list = emaillistRepository.findAll(); 
		model.addAttribute("list",list);
		return "WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/"; //index로 가게
	}
}
