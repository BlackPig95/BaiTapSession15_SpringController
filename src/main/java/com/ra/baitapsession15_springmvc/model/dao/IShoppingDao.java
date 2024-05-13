package com.ra.baitapsession15_springmvc.model.dao;

import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.model.entity.ShoppingCart;

import java.util.List;

public interface IShoppingDao
{
    List<ShoppingCart> findAll(Integer userId);

    ShoppingCart findById(Integer id);

    void save(ShoppingCart shoppingCart);

    void deleteById(Integer id);
}
