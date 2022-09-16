package com.mpec.javaweb.mapper;

import com.mpec.javaweb.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

// Implement cho interface RowMapper để map từng hàng trong resultset vào model
public class NewMapper implements RowMapper<NewsModel>{
    @Override
    public NewsModel mapRow(ResultSet rs) {
        // Tìm theo id chứ không tìm theo index để tránh nhầm lẫn
        try {
            NewsModel news = new NewsModel();
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            return news;
        }catch (SQLException e) {
            return null;
        }
    }
}
