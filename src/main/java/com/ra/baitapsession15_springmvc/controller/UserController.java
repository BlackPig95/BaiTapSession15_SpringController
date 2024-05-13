package com.ra.baitapsession15_springmvc.controller;

import com.ra.baitapsession15_springmvc.model.dao.IUserDao;
import com.ra.baitapsession15_springmvc.model.entity.User;
import com.ra.baitapsession15_springmvc.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUser(Model model)
    {
        model.addAttribute("list", userService.findAll());
        return "user/list";
    }

    @GetMapping("/add")
    public String viewAdd()
    {
        return "user/add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user)
    {
        userService.save(user);
        return "redirect:/user/list";
    }
}
