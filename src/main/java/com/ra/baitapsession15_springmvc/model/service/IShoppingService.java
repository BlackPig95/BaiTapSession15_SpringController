package com.ra.baitapsession15_springmvc.model.service;

import com.ra.baitapsession15_springmvc.model.dto.ShoppingDtoResponse;
import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.model.entity.ShoppingCart;

import java.util.List;

public interface IShoppingService
{
    List<ShoppingDtoResponse> findAll(Integer userId);

    ShoppingDtoResponse findById(Integer id);

    void save(ShoppingCart shoppingCart);

    void deleteById(Integer id);
}
