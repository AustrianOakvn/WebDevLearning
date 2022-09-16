package com.mpec.javaweb.dao.impl;

import com.mpec.javaweb.dao.GenericDAO;
import com.mpec.javaweb.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

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


    // <T> trong public <T> List<T> nghĩa là khai báo kiểu không biết trước T, nó có thể là anything trừ non-primitive
    // List<T> nghĩa là kiểu dữ liệu trả về là 1 List và các phần tử trong đó là kiểu dữ liệu T
    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            // Chỗ này sẽ để set parameters
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(rowMapper.mapRow(resultSet));
            }
            return result;
        }catch(SQLException e){
            return null;
            // Cuối cùng nhớ đóng kết nối
        }finally {
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

    // Hàm sử dụng để set parameter vào câu truy vấn sql
    private void setParameter(PreparedStatement statement, Object ...parameters) throws SQLException {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                // Do khi set param ta set từ 1 nên sử dụng index khác
                int index = i + 1;
                // Do ta không biết kiểu dữ liệu của parameter nên phải xét sử dụng instance of
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String){
                    statement.setString(index, (String)parameter);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
