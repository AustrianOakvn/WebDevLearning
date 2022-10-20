package com.mpec.javaweb.service;

import com.mpec.javaweb.model.NewsModel;

import java.util.List;

public interface INewService {

    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newModel);
    NewsModel update(NewsModel updateModel);

    void delete(long[] ids);
    List<NewsModel> findAll();
    
    
}
