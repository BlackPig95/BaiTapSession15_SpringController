package com.ra.baitapsession15_springmvc.model.dao.impl;

import com.ra.baitapsession15_springmvc.model.dao.IEmployeeDao;
import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao
{
    @Override
    public List<Employee> findAll()
    {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        try
        {
            PreparedStatement prepare = connection.prepareStatement("select * from employee");
            ResultSet resultSet = prepare.executeQuery();
            while (resultSet.next())
            {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("emp_id"));
                employee.setEmployeeName(resultSet.getString("emp_name"));
                employee.setGender(resultSet.getBoolean("gender"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddress(resultSet.getString("address"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getFloat("salary"));
                employeeList.add(employee);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return employeeList;
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
