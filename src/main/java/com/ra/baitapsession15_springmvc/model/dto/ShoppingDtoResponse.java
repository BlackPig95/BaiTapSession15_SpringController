package com.ra.baitapsession15_springmvc.model.dto;

import com.ra.baitapsession15_springmvc.model.entity.Product;
import com.ra.baitapsession15_springmvc.model.entity.User;

public class ShoppingDtoResponse
{
    private Integer id;
    private User user;
    private Product product;
    private Integer quantity;

    public ShoppingDtoResponse()
    {
    }

    public ShoppingDtoResponse(Integer id, User user, Product product, Integer quantity)
    {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
}
