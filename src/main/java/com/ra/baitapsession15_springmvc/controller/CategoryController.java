package com.ra.baitapsession15_springmvc.controller;

import com.ra.baitapsession15_springmvc.model.dao.ICategoryDao;
import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController
{
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listCategory(Model model)
    {
        model.addAttribute("list", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/add")
    public String viewAdd()
    {
        return "/category/add";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id)
    {
        categoryService.deleteById(id);
        return "redirect:/category/list";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category)
    {
        categoryService.save(category);
        return "redirect:/category/list";
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category)
    {
        categoryService.save(category);
        return "redirect:/category/list";
    }
}
