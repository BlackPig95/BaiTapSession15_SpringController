package com.ra.baitapsession15_springmvc.model.entity;

import java.util.Date;


public class Employee
{
    private Integer employeeId;
    private String employeeName;
    private Boolean gender;
    private Date birthday;
    private String address;
    private String department;
    private String position;
    private Float salary;

    public Employee()
    {
    }

    public Employee(Integer employeeId, String employeeName, Boolean gender, Date birthday, String address, String department, String position, Float salary)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public Integer getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public Boolean getGender()
    {
        return gender;
    }

    public void setGender(Boolean gender)
    {
        this.gender = gender;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public Float getSalary()
    {
        return salary;
    }

    public void setSalary(Float salary)
    {
        this.salary = salary;
    }
}
