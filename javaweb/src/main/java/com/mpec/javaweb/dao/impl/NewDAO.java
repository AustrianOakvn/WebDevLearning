package com.mpec.javaweb.dao.impl;

import com.mpec.javaweb.dao.INewDAO;
//import com.mpec.javaweb.model.CategoryModel;
import com.mpec.javaweb.mapper.NewMapper;
import com.mpec.javaweb.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        return query(sql, new NewMapper(), categoryId);
    }
}
