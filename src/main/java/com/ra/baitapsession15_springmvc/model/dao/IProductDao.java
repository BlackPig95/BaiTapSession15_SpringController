package com.ra.baitapsession15_springmvc.model.dao;

import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.model.entity.Product;

import java.util.List;

public interface IProductDao
{
    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void deleteById(Integer id);
}
