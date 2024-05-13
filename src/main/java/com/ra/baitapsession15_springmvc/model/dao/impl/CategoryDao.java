package com.ra.baitapsession15_springmvc.model.dao.impl;

import com.ra.baitapsession15_springmvc.model.dao.ICategoryDao;
import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao
{
    @Override
    public List<Category> findAll()
    {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("select * from categories");
            ResultSet rs = call.executeQuery();
            while (rs.next())
            {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                categoryList.add(category);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return categoryList;
    }

    @Override
    public Category findById(Integer _id)
    {
        Category category = new Category();
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("select * from categories " +
                    "where id = ?");
            call.setInt(1, _id);
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
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return category;
    }

    @Override
    public void save(Category category)
    {
        Connection connection = ConnectDB.getConnection();
        CallableStatement call = null;
        try
        {
            if (category.getId() == null)
            {
                call = connection.prepareCall("insert into categories (name, status) " +
                        "values (?,?)");
            } else
            {
                call = connection.prepareCall("update categories " +
                        "set name = ?, status = ? where id = ?");
                call.setInt(3, category.getId());
            }
            call.setString(1, category.getName());
            call.setBoolean(2, category.getStatus());
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
    public void deleteById(Integer _id)
    {
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("delete from categories" +
                    " where id = ?");
            call.setInt(1, _id);
            call.executeUpdate();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
    }
}
