package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("getBoardList.do")
	public void getBoardList(String searchCondition, String searchKeyword, Model m) {
		System.out.println("컬럼명: " + searchCondition + "  /  키워드: " + searchKeyword);
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<BoardVO> list = boardService.getBoardList(map);
		m.addAttribute("boardList", list);
	}

	@RequestMapping("{step}.do")
	public String open(@PathVariable String step) {
		return step;
	}
	
//	@RequestMapping("insertBoard.do")
//	public String insertBoard() {
//
//		System.out.println("insert");
//
//		return "insertBoard";
//	}

	@RequestMapping("saveBoard.do")
	public String insertBoard(BoardVO boardVO) {
		System.out.println("insertBoard");
		boardService.insertBoard(boardVO);

		return "redirect:getBoardList.do";
	}

	@RequestMapping("getBoard.do")
	public String selectBoard(BoardVO boardVO, Model m) {
		BoardVO vo = boardService.getBoard(boardVO);
		m.addAttribute("board", vo);

		return "getBoard";
	}

	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
		return "redirect:getBoardList.do";
	}
}
