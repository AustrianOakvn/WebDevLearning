package com.mpec.javaweb.mapper;

import java.sql.ResultSet;

// Trong resultSet chứa dữ table, khi set giá trị từ resultset
// là chúng ta đang mapp dữ liệu từ resultset sang model
public interface RowMapper<T> {
    // Hàm để map từ resultset ra model
    T mapRow(ResultSet rs);
}
