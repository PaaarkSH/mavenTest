package com.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    public UserVO getUser(UserVO vo) {
        return mybatis.selectOne("UserMapper.getUser", vo);
    }
}
