package com.mpec.javaweb.service;

import java.util.List;

import com.mpec.javaweb.model.CategoryModel;

public interface ICategoryService {

    List<CategoryModel> findAll();
    
}
