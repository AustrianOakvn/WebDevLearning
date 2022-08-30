package com.mpec.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mpec.javaweb.dao.ICategoryDAO;
import com.mpec.javaweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

    public Connection getConnection() {
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
    public List<CategoryModel> findAll() {
        List<CategoryModel> results = new ArrayList<>();
        String sql = "SELECT * FROM category";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                // Nếu trong câu query có tham số thì cần init parameter
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    CategoryModel category = new CategoryModel();
                    category.setId(resultSet.getLong("id"));
                    category.setCode(resultSet.getString("code"));
                    category.setName(resultSet.getString("name"));

                    results.add(category);
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
