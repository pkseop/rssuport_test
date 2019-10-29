package test.rsupport.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import test.rsupport.entity.Board;
import test.rsupport.service.BoardService;

@Slf4j
@RestController
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/board/list")
	public Map<String, Object> list(HttpServletRequest request) {
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		String draw = request.getParameter("draw");
		
		log.info("start: " + start + "  length: " + length + " draw: " + draw);
		
		long total = boardService.countAll();
		List<Board> list = boardService.fetchPagedData(Integer.parseInt(start), Integer.parseInt(length));
		
		Map<String, Object> m = Maps.newHashMap();
		m.put("data", list);
		m.put("recordsTotal", total);
		m.put("recordsFiltered", total);
		m.put("draw", draw);
		return m;
	}
	
}
