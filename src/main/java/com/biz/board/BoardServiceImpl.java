package com.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 실질적인 비즈니스 로직
@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO dao;

    public BoardServiceImpl(BoardDAO dao) {
        this.dao = dao;
    }
    public void insertBoard(BoardVO vo){
        dao.insertBoard(vo);
    }
    public void deleteBoard(BoardVO vo){
        dao.deleteBoard(vo);
    }
    public void updateBoard(BoardVO vo){
        dao.updateBoard(vo);
    }
    public BoardVO getBoard(BoardVO vo){
        return dao.getBoard(vo);
    }
    public List<BoardVO> getBoardList(BoardVO vo){
        return dao.getBoardList(vo);
    }
}
