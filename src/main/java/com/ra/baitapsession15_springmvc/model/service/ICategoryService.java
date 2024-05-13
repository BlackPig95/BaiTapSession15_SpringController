package com.ra.baitapsession15_springmvc.model.service;

import com.ra.baitapsession15_springmvc.model.entity.Category;

import java.util.List;

public interface ICategoryService
{
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
