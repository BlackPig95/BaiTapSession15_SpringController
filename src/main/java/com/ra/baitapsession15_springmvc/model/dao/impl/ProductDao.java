package com.ra.baitapsession15_springmvc.model.dao.impl;

import com.ra.baitapsession15_springmvc.model.dao.IProductDao;
import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.model.entity.Product;
import com.ra.baitapsession15_springmvc.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao
{
    @Override
    public List<Product> findAll()
    {
        List<Product> productList = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("select * from products p " +
                    "join categories c on p.category_id = c.id");
            ResultSet rs = call.executeQuery();
            while (rs.next())
            {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(selectCategory(rs.getInt("category_id")));
                product.setStatus(rs.getBoolean("status"));
                productList.add(product);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public Product findById(Integer id)
    {
        Product product = new Product();
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("select * from products" +
                    " where id = ?");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next())
            {
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(selectCategory(rs.getInt("category_id")));
                product.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return product;
    }

    @Override
    public void save(Product product)
    {
        Connection connection = ConnectDB.getConnection();
        CallableStatement call = null;
        try
        {
            if (product.getId() == null)
            {
                call = connection.prepareCall("insert into products " +
                        "(name,price,stock,category_id,status) " +
                        " values (?,?,?,?,?) ");
            } else
            {
                call = connection.prepareCall("update products " +
                        "set name = ?, price = ?, stock = ?, category_id = ?," +
                        "status = ? where id =?");
                call.setInt(6, product.getId());
            }
            call.setString(1, product.getName());
            call.setDouble(2, product.getPrice());
            call.setInt(3, product.getStock());
            call.setInt(4, product.getCategory().getId());
            call.setBoolean(5, product.getStatus());
            call.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id)
    {
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("delete from products " +
                    "where id = ?");
            call.setInt(1, id);
            call.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }

    private Category selectCategory(Integer cat_id)
    {
        Category category = new Category();
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("select * from " +
                    "categories where id = ?");
            call.setInt(1, cat_id);
            ResultSet rs = call.executeQuery();
            if (rs.next())
            {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return category;
    }
}
