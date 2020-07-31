package kr.co.jhta.web;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.jhta.form.BoardForm;
import kr.co.jhta.service.BoardService;
import kr.co.jhta.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Value("${directory.save.freeboard}")
	private String saveDirectory;
	
	// 요청핸들러메소드라고불리운다
	// insert, delete, update 관련된 요청핸들러메소드는 redirect: 키워드를 붙여서 반환한다, 재요청키워드
	
	// JSP 응답을 보내는 경우 반환값을 String로 지정(JSP페이지를 반환하는 경우)
	// Model객체는 Handler Adapter가 메소드를 실행할 때 생성해서 매개변수로 전달해준다.
	@RequestMapping("/list.do")
	public String boardlist(Model Model) {
		
		// 게시글 전체 조회
		List<Board> boardList = boardService.getAllBoards();

		// 조회된 게시글을 Model에 담아서 뷰페이지에 전달하기
		Model.addAttribute("boards", boardList);
		// 내부이동할 JSP페이지의 경로 및 이름 반환
		return "board/list";	// WEB-INF/view/board/list.jsp
	}
	
	@RequestMapping("/form.do")
	public String form() {
		
		return "board/form";
	}
	
	@RequestMapping("/add.do")
	public String addBoard(BoardForm boardForm) throws Exception {
		
		Board board = new Board();
		
		//form의 값은 boardForm객체의 값에 담겨있고 board객체에 동일한 데이터타입, 이름의 값에 복사해서 전달해준다.
		// form.jsp의 input box안의 값들이 boardForm객체에 담겨있고, 그 값을 board객체에 동일한 데이터타입, 이름의 값에 복사해서 전달해준다.
		// 이때, form.jsp input box의 name과 boardForm객체의 멤버변수는 이름과 데이터타입이 같아야한다.
		// 파일관련 주의사항은  boardForm객체의 파일관련 멤버변수의 이름과 board객체의 파일관련 멤버변수의 이름은 달라야한다.
		// 왜냐하면 boardForm객체에는 파일이 담겨있고, board객체에는 파일이름만 담아줄수있기때문에!
		
		// title, writer, content, password 값이 boardForm에서 board로 복사된다.
		BeanUtils.copyProperties(boardForm, board);
		
		// 첨부파일 다루기
		MultipartFile upfile = boardForm.getUpfile();
		
		// MultipartFile객체는 첨부파일이 있던 없던 항상 null이 아니므로 isEmpty()로 파일여부를 확인한다.
		if (!upfile.isEmpty()) {
			// 업로드된 첨부파일의 이름을 알아올 수 있다.
			String filename = upfile.getOriginalFilename();
			// 저장될 파일이름앞에 1초에 1000번 바뀌는 값을 대입하여, 같은파일명일경우를 대비한다.
			filename = System.currentTimeMillis() + filename;
			// 저장될경로, 저장할 파일 이름
			File file = new File(saveDirectory, filename);
			// FileCopyUtils.copy(upfile.getBytes(), file);								<-- 1번방법
			FileCopyUtils.copy(upfile.getInputStream(), new FileOutputStream(file));//  <-- 2번방법
			board.setFilename(filename);
		}
		
		boardService.addNewBoard(board);

		return "redirect:list.do";
	}
	
	@RequestMapping("/likes.do")
	// @RequestParam("요청파라미터이름") 요청파라미터를 담을 변수)
	// insert, delete, update 작업은 redirect를 사용한다.
	public String likesBoard(@RequestParam("no") long boardNo, RedirectAttributes redirectAttributes) {
		boardService.increaseBoardLikes(boardNo);
		
		// URL뒤에 쿼리스트링의 형태로 보내줄때 사용한다.
		redirectAttributes.addAttribute("no", boardNo);
		
		return "redirect:detail.do";
	}
	
	// view페이지(JSP페이지)에 전달할때에는 Model객체에 담아서 전해준다.
	@RequestMapping("/detail.do")
	public String detailBaord(@RequestParam("no") long boardNo, Model model) {
		model.addAttribute("board", boardService.getBoardDetail(boardNo));
		
		return "board/detail";
		
		
	}
	
}
