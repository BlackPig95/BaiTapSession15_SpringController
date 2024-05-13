package com.ra.baitapsession15_springmvc.model.service.impl;

import com.ra.baitapsession15_springmvc.model.dao.ICategoryDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.CategoryDao;
import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.model.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService
{
    private static final ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> findAll()
    {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Integer id)
    {
        return categoryDao.findById(id);
    }

    @Override
    public void save(Category category)
    {
        categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id)
    {
        categoryDao.deleteById(id);
    }
}
