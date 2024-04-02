package com.biz.board;

import com.biz.common.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// Data Access Object
public class BoardDAO {
    // sql session 객체가 바로 mybatis 컨테이너 객체
    private SqlSession mybatis;

    public BoardDAO() {
        this.mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
    }

    public void insertBoard(BoardVO vo){
        mybatis.insert("BoardMapper.insertBoard", vo);
    }

    public void updateBoard(BoardVO vo){
        mybatis.update("BoardMapper.updateBoard", vo);
    }

    public void deleteBoard(BoardVO vo){
        mybatis.delete("BoardMapper.deleteBoard", vo);
    }

    public BoardVO getBoard(BoardVO vo) {
        return mybatis.selectOne("BoardMapper.getBoard");
    }

    public List<BoardVO> getBoardList() {
        return mybatis.selectList("BoardMapper.getBoardList");
    }
}
