package com.ra.baitapsession15_springmvc.controller;

import com.ra.baitapsession15_springmvc.model.entity.Employee;
import com.ra.baitapsession15_springmvc.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/employee")
@Controller
public class EmployeeController
{
    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }


    @GetMapping("/listemp")
    public String listEmployee(Model model)
    {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employee/listemp";
    }
}
