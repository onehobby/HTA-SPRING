package kr.co.jhta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// JSP 응답을 보내는 경우 반환값을 String로 지정(JSP페이지를 반환하는 경우)
	@RequestMapping("/home.do")
	public String home(Model model) {
		model.addAttribute("message", "안녕하세요");
		model.addAttribute("notice", "정식오픈은 다음 주 월요일입니다.");
		
		return "home";
	}
	

}
