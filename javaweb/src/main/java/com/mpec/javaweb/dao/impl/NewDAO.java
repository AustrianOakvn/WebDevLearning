package com.mpec.javaweb.dao.impl;

import com.mpec.javaweb.dao.INewDAO;
//import com.mpec.javaweb.model.CategoryModel;
import com.mpec.javaweb.mapper.NewMapper;
import com.mpec.javaweb.model.NewsModel;

import java.util.List;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public NewsModel findOne(Long id) {
        String sql = "SELECT * FROM news WHERE id=?";
//        Do query luôn trả về một list nên cần sử dụng truy vấn như dưới
        List<NewsModel> news = query(sql, new NewMapper(), id);
//        Do list chỉ có 1 phần tử nên kiểm tra nếu nó rỗng thì trả về null còn không thì trả về phần tử đầu tiên
        return news.isEmpty() ? null:news.get(0);
    }


    @Override
    public Long save(NewsModel newModel) {
//        String sql = "INSERT INTO news (title, content, categoryid) VALUES (?, ?, ?)";
        StringBuilder sql = new StringBuilder("INSERT INTO news");
        sql.append("(title, content, thumbnail, shortdescription, categoryid, createddate, createdby)");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),
                                        newModel.getThumbNail(), newModel.getShortDescription(),
                                        newModel.getCategoryId(), newModel.getCreatedDate(),
                                        newModel.getCreatedBy());
    }

    @Override
    public void update(NewsModel updateNew) {
//        StringBuilder là class để tạo ra chuỗi có thể thay đổi (mutable)
        StringBuilder sql = new StringBuilder("UPDATE news SET title=?, thumbnail=?");
        sql.append("shortdescription=?, content=?, categoryid=?");
        sql.append("createddate=?, createdBy=?, modifieddate=?, modifiedby=? WHERE id=?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbNail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(),
                updateNew.getCreatedBy(), updateNew.getModifiedDate(),
                updateNew.getModifiedBy(), updateNew.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM news WHERE id=?";
        update(sql, id);
    }

    @Override
    public List<NewsModel> findAll() {
        String sql = "SELECT * FROM news";
        return query(sql, new NewMapper());
    }

    ///////////////////////////////////////////////////////
    /* Bản viết bằng tay chưa có common trong AbstractDAO*/
    ///////////////////////////////////////////////////////
//    @Override
//    public Long save(NewsModel newModel) {
//        ResultSet resultSet = null;
//        Long id = null;
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            String sql = "INSERT INTO news (title, content, categoryid) VALUES (?, ?, ?)";
//            connection = getConnection();
//            // Đặt auto commit = false để không tự động commit
//            connection.setAutoCommit(false);
//            // Phải thêm return generated keys để có thể gọi được getGeneratedKeys() ở resultSet
//            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            // Set tham số
//            statement.setString(1, newModel.getTitle());
//            statement.setString(2 , newModel.getContent());
//            statement.setLong(3, newModel.getId());
//            // Thao tác thay đổi dữ liệu ta cần sử dụng executeUpdate()
//            statement.executeUpdate();
//            // Lấy ra khóa chính được tạo tự động
//            resultSet = statement.getGeneratedKeys();
//            // Trả về id để về sau load lại trang chi tiết bài viết và hiển thị lưu thành công
//            if (resultSet.next()){
//                id = resultSet.getLong(1);
//            }
//            // Nếu không gọi commit thì sẽ không lưu xuống database
//            connection.commit();
//            return id;
//        } catch (SQLException e) {
//            // Nếu tác vụ bị fail thì rollback hết các thay đổi
//            if (connection != null){
//                try {
//                    connection.rollback();
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//            return null;
//            // Đóng các đối tượng đã sử dụng
//        } finally {
//            try{
//                if (connection != null) {
//                    connection.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//            } catch (SQLException e) {
//                return null;
//            }
//        }
//    }
}
