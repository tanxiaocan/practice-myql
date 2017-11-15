package com.txc.mysql.mybatis.test;

import com.txc.mysql.mybatis.base.SqlSessionFactoryUtil;
import com.txc.mysql.mybatis.domain.User;
import com.txc.mysql.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by tanxiaocan on 2017/11/3.
 */
public class FirstTestCase {
    @Test
    public void testMybatisConfig(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory("org/mybatis/example/mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUid(10645923);
        System.out.println(user);
    }
}
