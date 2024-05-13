package com.ra.baitapsession15_springmvc.model.service;

import com.ra.baitapsession15_springmvc.model.entity.Employee;

import java.util.List;

public interface IEmployeeService
{
    List<Employee> findAll();

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);
}
