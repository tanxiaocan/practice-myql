package com.txc.mysql.utils;

import java.sql.*;

/**
 * Created by tanxiaocan on 2017/11/1.
 */
public class MysqlConnection {

    public static void main(String args[]){
        Connection root = getConnection("jdbc:mysql://localhost:3306/focus_news?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "");
        try {
            PreparedStatement preparedStatement = root.prepareStatement("select * from news_basic");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                System.out.println(id);
            }
        } catch (SQLException e) {
            if(root != null){
                try {
                    root.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String url,String username,String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
