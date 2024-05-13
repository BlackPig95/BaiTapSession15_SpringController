package com.ra.baitapsession15_springmvc.model.dto;

import com.ra.baitapsession15_springmvc.model.entity.Category;

public class ProductDto
{
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer categoryId;
    private Boolean status;

    public ProductDto()
    {
    }

    public ProductDto(Integer id, String name, Double price, Integer stock, Integer categoryId, Boolean status)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
        this.status = status;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }
}
