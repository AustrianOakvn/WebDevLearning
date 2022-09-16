package com.mpec.javaweb.dao;

import java.util.List;

import com.mpec.javaweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{

    List<CategoryModel> findAll();
    
}
