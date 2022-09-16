package com.mpec.javaweb.dao.impl;

import com.mpec.javaweb.dao.INewDAO;
//import com.mpec.javaweb.model.CategoryModel;
import com.mpec.javaweb.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDAO implements INewDAO {


    public Connection getConnection() {
        /*Class để setup connection
        Cần cung cấp driver, tên của database, và tài khoản, mật khẩu truy cập*/
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // String url = "jdbc:mysql://hostname:port/dbname";
            String url = "jdbc:mysql://localhost:3306/newservlet12month2018";
            String user = "root";
            String password = "7";
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        List<NewsModel> results = new ArrayList<>();
        // Dấu "?" là để truyền tham số ở ngoài vào
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        PreparedStatement statement = null;
        // Trong jdbc thì giá trị trả về thuộc dạng ResultSet
        ResultSet resultSet = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                // Truyền tham số vào sql statement
                statement.setLong(1, categoryId);
                // Nếu trong câu query có tham số thì cần init parameter
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    NewsModel news = new NewsModel();
                    // Tìm theo id chứ không tìm theo index để tránh nhầm lẫn
                    news.setId(resultSet.getLong("id"));
                    news.setTitle(resultSet.getString("title"));

                    results.add(news);
                }
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                return results;
            } catch (SQLException e) {
                e.printStackTrace();
                // Do ta không biết có khả năng bị lỗi ở một trong các dòng phía trước if
                // dẫn tới các connection sẽ không bị đóng nên dùng đến finally.
            } finally {
                try{
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    return null;
                }
            }
        }
        return null;
    }
}
