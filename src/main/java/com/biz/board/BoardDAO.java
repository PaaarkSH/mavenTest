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

    public void insertBoard(BoardVO vo) {
        mybatis.insert("BoardMapper.insertBoard", vo);
        mybatis.commit();
    }

    public void updateBoard(BoardVO vo) {
        mybatis.update("BoardMapper.updateBoard", vo);
        mybatis.commit();
    }

    public void deleteBoard(BoardVO vo) {
        mybatis.delete("BoardMapper.deleteBoard", vo);
        mybatis.commit();
    }

    public BoardVO getBoard(BoardVO vo) {
        return mybatis.selectOne("BoardMapper.getBoard", vo);
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        if (vo.getSearchCondition().equals("TITLE")) {
            return mybatis.selectList("BoardMapper.getBoardList_T", vo);
        } else if (vo.getSearchCondition().equals("CONTENT")) {
            return mybatis.selectList("BoardMapper.getBoardList_C", vo);
        } else {
            return null;
        }
    }
}
