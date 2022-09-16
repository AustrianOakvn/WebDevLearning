package com.mpec.javaweb.service.impl;

import com.mpec.javaweb.dao.INewDAO;
import com.mpec.javaweb.model.NewsModel;
import com.mpec.javaweb.service.INewService;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService{

    @Inject
    private INewDAO newDao;


    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newDao.findByCategoryId(categoryId);
    }
}
