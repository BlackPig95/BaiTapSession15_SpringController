package com.ra.baitapsession15_springmvc.model.dao;

import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.model.entity.Employee;

import java.util.List;

public interface ICategoryDao
{
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
