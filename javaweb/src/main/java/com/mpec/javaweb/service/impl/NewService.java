package com.mpec.javaweb.service.impl;

import com.mpec.javaweb.dao.INewDAO;
import com.mpec.javaweb.model.NewsModel;
import com.mpec.javaweb.service.INewService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService{

    @Inject
    private INewDAO newDao;


    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newDao.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newModel) {
//        Đặt ngày giờ tạo
        newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newModel.setCreatedBy("");
        Long newId = newDao.save(newModel);
//        System.out.println(newId);
//        return null;
//        Truy vấn lấy tìm dữ liệu xem đã được lưu hay chưa
        return newDao.findOne(newId);
    }

    @Override
    public NewsModel update(NewsModel updateModel) {
//        Khi update thì ta lấy lại những thông tin không thay đổi của
//        dữ liệu cũ như id, ngày tạo, tạo bởi,
//        Dữ liệu cần thay đổi sẽ là ngày thay đổi và người thay đổi
        NewsModel oldModel = newDao.findOne(updateModel.getId());
        updateModel.setCreatedDate(oldModel.getCreatedDate());
        updateModel.setCreatedBy(oldModel.getCreatedBy());
        updateModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateModel.setModifiedBy("");
        newDao.update(updateModel);
//        Kiểm tra xem update đc lưu hay chưa
        return newDao.findOne(updateModel.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long i : ids){
            newDao.delete(i);
        }
    }

    @Override
    public List<NewsModel> findAll() {
        return newDao.findAll();
    }
}
