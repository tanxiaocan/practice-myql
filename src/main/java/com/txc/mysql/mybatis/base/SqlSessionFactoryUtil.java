package com.txc.mysql.mybatis.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.txc.mysql.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tanxiaocan on 2017/11/3.
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory(String resource){
        if(sqlSessionFactory != null){
            return sqlSessionFactory;
        }
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 纯Java程序方式，不使用xml
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory != null){
            return sqlSessionFactory;
        }
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/focus_join?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        druidDataSource.setUsername("root");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",transactionFactory,druidDataSource);
        Configuration configuration = new Configuration(environment);
        //UserMapper.xml文件也会自动加载进来
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }
}
