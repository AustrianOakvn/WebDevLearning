package com.mpec.javaweb.dao;

import com.mpec.javaweb.model.NewsModel;

import java.util.List;

public interface INewDAO extends GenericDAO<NewsModel>{

    List<NewsModel> findByCategoryId(Long categoryId);

    NewsModel findOne(Long id);
    Long save(NewsModel newModel);

    void update(NewsModel updateNew);
    void delete(long id);

    List<NewsModel> findAll();
}
