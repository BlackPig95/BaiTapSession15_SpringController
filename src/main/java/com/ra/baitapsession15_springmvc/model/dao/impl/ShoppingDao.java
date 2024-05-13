package com.ra.baitapsession15_springmvc.model.dao.impl;

import com.ra.baitapsession15_springmvc.model.dao.IShoppingDao;
import com.ra.baitapsession15_springmvc.model.entity.ShoppingCart;
import com.ra.baitapsession15_springmvc.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDao implements IShoppingDao
{

    @Override
    public List<ShoppingCart> findAll(Integer userId)
    {
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        try
        {
            CallableStatement call = connection.prepareCall("select * from shopping_cart where user_id = ?");
            call.setInt(1, userId);
            ResultSet rs = call.executeQuery();
            while (rs.next())
            {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setId(rs.getInt("id"));
                shoppingCart.setUserId(rs.getInt("user_id"));
                shoppingCart.setProductId(rs.getInt("product_id"));
                shoppingCart.setQuantity(rs.getInt("quantity"));
                shoppingCartList.add(shoppingCart);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return shoppingCartList;
    }

    @Override
    public ShoppingCart findById(Integer id)
    {
        Connection connection = ConnectDB.getConnection();
        ShoppingCart shoppingCart = new ShoppingCart();
        try
        {
            CallableStatement call = connection.prepareCall("select * from shopping_cart where id = ?");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            while (rs.next())
            {
                shoppingCart.setId(id);
                shoppingCart.setUserId(rs.getInt("user_id"));
                shoppingCart.setProductId(rs.getInt("product_id"));
                shoppingCart.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return shoppingCart;
    }

    @Override
    public void save(ShoppingCart shoppingCart)
    {
        Connection connection = ConnectDB.getConnection();
        CallableStatement call = null;
        try
        {
            if (shoppingCart.getId() == null)
            {
                call = connection.prepareCall("insert into shopping_cart (user_id, product_id, quantity) " +
                        "values (?, ? ,?)");
            } else
            {
                call = connection.prepareCall("update shopping_cart " +
                        "set user_id = ?, product_id = ?, quantity = ? where id = ?");
                call.setInt(4, shoppingCart.getId());
            }
            call.setInt(1, shoppingCart.getUserId());
            call.setInt(2, shoppingCart.getProductId());
            call.setInt(3, shoppingCart.getQuantity());
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
            CallableStatement call = connection.prepareCall("delete from shopping_cart " +
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
}
