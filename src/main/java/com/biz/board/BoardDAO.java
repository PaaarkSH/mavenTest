package com.biz.board;

import com.biz.common.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

// Data Access Object
@Repository
public class BoardDAO {
    // sql session 객체가 바로 mybatis 컨테이너 객체

    @Autowired  // type injection
    private SqlSession mybatis;

    public void insertBoard(BoardVO vo) {
        mybatis.insert("BoardMapper.insertBoard", vo);
    }

    public void updateBoard(BoardVO vo) {
        mybatis.update("BoardMapper.updateBoard", vo);
    }

    public void deleteBoard(BoardVO vo) {
        mybatis.delete("BoardMapper.deleteBoard", vo);
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
