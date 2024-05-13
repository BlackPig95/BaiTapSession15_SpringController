package com.ra.baitapsession15_springmvc.model.service.impl;

import com.ra.baitapsession15_springmvc.model.dao.impl.EmployeeDao;
import com.ra.baitapsession15_springmvc.model.dao.IEmployeeDao;
import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.model.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService
{
    private static final IEmployeeDao employeeDao = new EmployeeDao();

    @Override
    public List<Employee> findAll()
    {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer id)
    {
        return null;
    }

    @Override
    public void save(Employee employee)
    {

    }

    @Override
    public void deleteById(Integer id)
    {

    }
}
