package com.mpec.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mpec.javaweb.dao.ICategoryDAO;
import com.mpec.javaweb.mapper.CategoryMapper;
import com.mpec.javaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

//    public Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            // String url = "jdbc:mysql://hostname:port/dbname";
//            String url = "jdbc:mysql://localhost:3306/newservlet12month2018";
//            String user = "root";
//            String password = "7";
//            return DriverManager.getConnection(url, user, password);
//
//        } catch (ClassNotFoundException | SQLException e) {
//            return null;
//        }
//    }

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }
}
