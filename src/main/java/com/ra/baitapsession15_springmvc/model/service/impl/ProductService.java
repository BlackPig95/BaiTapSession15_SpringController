package com.ra.baitapsession15_springmvc.model.service.impl;

import com.ra.baitapsession15_springmvc.model.dao.ICategoryDao;
import com.ra.baitapsession15_springmvc.model.dao.IProductDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.CategoryDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.ProductDao;
import com.ra.baitapsession15_springmvc.model.dto.ProductDto;
import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.model.entity.Product;
import com.ra.baitapsession15_springmvc.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService
{
    private static final IProductDao productDao = new ProductDao();
    private static final ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Product> findAll()
    {
        return productDao.findAll();
    }

    @Override
    public Product findById(Integer id)
    {
        return productDao.findById(id);
    }

    @Override
    public void save(ProductDto productDto)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setStatus(productDto.getStatus());
        System.out.println(productDto.getCategoryId());
        product.setCategory(getCategoryFromId(productDto.getCategoryId()));
        productDao.save(product);
    }

    @Override
    public void deleteById(Integer id)
    {
        productDao.deleteById(id);
    }

    private Category getCategoryFromId(Integer categoryId)
    {
        return categoryDao.findById(categoryId);
    }
}
