package com.mpec.javaweb.service.impl;

import java.util.List;

import com.mpec.javaweb.dao.ICategoryDAO;
import com.mpec.javaweb.dao.impl.CategoryDAO;
import com.mpec.javaweb.model.CategoryModel;
import com.mpec.javaweb.service.ICategoryService;
import javax.inject.Inject;

public class CategoryService implements ICategoryService {

    // private ICategoryDAO categoryDao;

    // public CategoryService() {
    //     categoryDao = new CategoryDAO();
    // }

    @Inject
    private ICategoryDAO categoryDao;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

}
