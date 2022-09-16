package com.mpec.javaweb.dao;

import com.mpec.javaweb.model.NewsModel;

import java.util.List;

public interface INewDAO extends GenericDAO<NewsModel>{

    List<NewsModel> findByCategoryId(Long categoryId);
}
