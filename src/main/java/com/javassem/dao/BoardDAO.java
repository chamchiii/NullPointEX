package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.BoardVO;

public interface BoardDAO {
	public void insertBoard(BoardVO vo);

	public void updateBoard(BoardVO vo) ;

	public void deleteBoard(BoardVO vo);

	public BoardVO getBoard(BoardVO vo) ;

	public List<BoardVO> getBoardList(HashMap map) ;
}
