package com.ra.baitapsession15_springmvc.model.service.impl;

import com.ra.baitapsession15_springmvc.model.dao.IUserDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.UserDao;
import com.ra.baitapsession15_springmvc.model.entity.User;
import com.ra.baitapsession15_springmvc.model.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService
{
    private final static IUserDao userDao = new UserDao();

    @Override
    public List<User> findAll()
    {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id)
    {
        return userDao.findById(id);
    }

    @Override
    public void save(User user)
    {
        userDao.save(user);
    }

    @Override
    public void deleteById(Integer id)
    {
        userDao.deleteById(id);
    }
}
