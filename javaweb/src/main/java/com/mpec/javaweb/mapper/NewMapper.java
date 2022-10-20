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
            news.setContent(rs.getString("content"));
            news.setCategoryId(rs.getLong("categoryid"));
            news.setThumbNail(rs.getString("thumbnail"));
            news.setShortDescription(rs.getString("shortdescription"));
            news.setCreatedDate(rs.getTimestamp("createddate"));
            news.setCreatedBy(rs.getString("createdby"));
            if (rs.getTimestamp("modifieddate")!=null){
                news.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if (rs.getTimestamp("modifiedby")!=null){
                news.setModifiedBy(rs.getString("modifiedby"));
            }
            return news;
        }catch (SQLException e) {
            return null;
        }
    }
}
