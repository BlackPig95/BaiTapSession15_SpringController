package com.ra.baitapsession15_springmvc.model.dao;

import com.ra.baitapsession15_springmvc.model.entity.Employee;

import java.util.List;

public interface IEmployeeDao
{
    List<Employee> findAll();

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);
}
