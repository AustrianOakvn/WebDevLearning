package com.mpec.javaweb.dao;

import com.mpec.javaweb.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    // Đây là interface mà các interface khác sẽ kế thừa
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...parameters);
}
