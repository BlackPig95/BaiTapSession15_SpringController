package com.ra.baitapsession15_springmvc.model.service;

import com.ra.baitapsession15_springmvc.model.entity.User;

import java.util.List;

public interface IUserService
{
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void deleteById(Integer id);
}
