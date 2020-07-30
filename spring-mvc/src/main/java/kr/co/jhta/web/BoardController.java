package kr.co.jhta.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 요청핸들러메소드라고불리운다
	// insert, delete, update 관련된 요청핸들러메소드는 redirect: 키워드를 붙여서 반환한다, 재요청키워드
	
	// JSP 응답을 보내는 경우 반환값을 String로 지정(JSP페이지를 반환하는 경우)
	@RequestMapping("/list.do")
	public String boardlist(Model Model) {
		return "board/list";
	}
	
	@RequestMapping("/form.do")
	public String form() {
		
		return "board/form";
	}
	
	@RequestMapping("/add.do")
	public String addBoard() {
		return "redirect:list.do";
	}
}
