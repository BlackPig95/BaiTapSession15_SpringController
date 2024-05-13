package com.ra.baitapsession15_springmvc.model.service;

import com.ra.baitapsession15_springmvc.model.dto.ProductDto;
import com.ra.baitapsession15_springmvc.model.entity.Product;

import java.util.List;

public interface IProductService
{
    List<Product> findAll();

    Product findById(Integer id);

    void save(ProductDto productDto);

    void deleteById(Integer id);
}
