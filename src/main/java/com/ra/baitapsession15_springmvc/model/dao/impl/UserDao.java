package com.ra.baitapsession15_springmvc.model.dao.impl;

import com.ra.baitapsession15_springmvc.model.dao.IUserDao;
import com.ra.baitapsession15_springmvc.model.entity.User;
import com.ra.baitapsession15_springmvc.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao
{

    @Override
    public List<User> findAll()
    {
        Connection connection = ConnectDB.getConnection();
        List<User> userList = new ArrayList<>();
        try
        {
            CallableStatement call = connection.prepareCall("select * from users");
            ResultSet rs = call.executeQuery();
            while (rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setStatus(rs.getBoolean("status"));
                userList.add(user);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return userList;
    }

    @Override
    public User findById(Integer id)
    {
        Connection connection = ConnectDB.getConnection();
        User user = new User();
        try
        {
            CallableStatement call = connection.prepareCall("select * from users where id = ?");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next())
            {
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            ConnectDB.closeConnection(connection);
        }
        return user;
    }

    @Override
    public void save(User user)
    {
        Connection connection = ConnectDB.getConnection();
        CallableStatement call = null;
        try
        {
            if (user.getId() == null)
            {
                call = connection.prepareCall("insert into users (fullName, email, password, address, phone, status) " +
                        " values (?,?,?,?,?,?)");
            } else
            {
                call = connection.prepareCall("update users set fullName = ?, email = ?, password = ?, address = ?, phone = ?, status = ? where id = ?");
                call.setInt(7, user.getId());
            }
            call.setString(1, user.getFullName());
            call.setString(2, user.getEmail());
            call.setString(3, user.getPassword());
            call.setString(4, user.getAddress());
            call.setString(5, user.getPhone());
            call.setBoolean(6, user.getStatus());
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
            CallableStatement call = connection.prepareCall("delete from users where id = ?");
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
