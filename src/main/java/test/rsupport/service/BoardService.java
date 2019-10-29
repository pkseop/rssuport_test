package test.rsupport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import test.rsupport.entity.Board;
import test.rsupport.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	public List<Board> fetchPagedData(int start, int length) {
		PageRequest req = PageRequest.of(start/length, length, Sort.Direction.DESC, "no");
		return boardRepository.findAll(req).getContent();
	}
	
	public long countAll() {
		return boardRepository.count();
	}
	
	public Board findByNo(int no) {
		return boardRepository.findById(no).get();
	}
}
