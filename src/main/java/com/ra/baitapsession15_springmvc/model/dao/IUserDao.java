package com.ra.baitapsession15_springmvc.model.dao;

import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.model.entity.User;

import java.util.List;

public interface IUserDao
{
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void deleteById(Integer id);
}
