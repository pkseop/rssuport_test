package test.rsupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import test.rsupport.entity.Board;
import test.rsupport.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@GetMapping("/board/post")
	public String newWirte(Model model) {
		model.addAttribute("username", getCurrUsername());
		
		return "post";
	}
	
	@GetMapping("/board/{no}/hit")
	public String postHit(@PathVariable int no, Model model) {
		String username = getCurrUsername();
		Board board = boardService.findByNo(no);
		Boolean canModify = username.equals(board.getUsername());
		
		model.addAttribute("canModify", canModify);
		model.addAttribute("board", board);
		
		return "post-hit";
	}
	
	private String getCurrUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		UserDetails userDetails = (UserDetails)principal; 
		return userDetails.getUsername();
	}
	
	@GetMapping("/board/{no}/modify")
	public String postModify(@PathVariable int no, Model model) {
		Board board = boardService.findByNo(no);
		model.addAttribute("board", board);
		
		return "post-modify";
	}
}
