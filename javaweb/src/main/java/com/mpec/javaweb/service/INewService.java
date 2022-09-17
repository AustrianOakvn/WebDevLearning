package com.mpec.javaweb.service;

import com.mpec.javaweb.model.NewsModel;

import java.util.List;

public interface INewService {

    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newModel);
    
    
}
