package com.ra.baitapsession15_springmvc.controller;

import com.ra.baitapsession15_springmvc.model.dao.ICategoryDao;
import com.ra.baitapsession15_springmvc.model.dto.ProductDto;
import com.ra.baitapsession15_springmvc.model.entity.Category;
import com.ra.baitapsession15_springmvc.model.entity.Product;
import com.ra.baitapsession15_springmvc.model.service.ICategoryService;
import com.ra.baitapsession15_springmvc.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController
{
    private final IProductService productService;
    private final ICategoryService categoryService;

    @Autowired
    public ProductController(IProductService productService, ICategoryService categoryService)
    {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listProduct(Model model)
    {
        model.addAttribute("list", productService.findAll());
        return "product/list";
    }

    @GetMapping("/add")
    public String viewAddProduct(Model model)
    {
        model.addAttribute("categories", categoryService.findAll());
        return "product/add";
    }

    @GetMapping("/edit/{id}")
    public String viewEditProduct(@PathVariable("id") Integer id, Model model)
    {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "/product/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id)
    {
        productService.deleteById(id);
        return "redirect:/product/list";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDto productDto)
    {
        productService.save(productDto);
        return "redirect:/product/list";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute ProductDto productDto)
    {
        productService.save(productDto);
        return "redirect:/product/list";
    }
}
