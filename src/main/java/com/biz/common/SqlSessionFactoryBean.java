package com.biz.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class SqlSessionFactoryBean {
    private static SqlSessionFactory sqlSessionFactory;  // sql session 생성

    static {
        try {
            if (sqlSessionFactory == null) {
                String configuration = "sql-map-config.xml";
                Reader reader = Resources.getResourceAsReader(configuration);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSessionInstance() {
        return sqlSessionFactory.openSession();
    }

}
