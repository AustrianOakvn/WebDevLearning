package com.mpec.javaweb.dao;

import java.util.List;

import com.mpec.javaweb.model.CategoryModel;

public interface ICategoryDAO {

    List<CategoryModel> findAll();
    
}
