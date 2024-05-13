package com.ra.baitapsession15_springmvc.controller;

import com.ra.baitapsession15_springmvc.model.service.IProductService;
import com.ra.baitapsession15_springmvc.model.service.IShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController
{
    private final IShoppingService shoppingService;
    private final IProductService productService;

    @Autowired
    public ShoppingCartController(IShoppingService shoppingService, IProductService productService)
    {
        this.shoppingService = shoppingService;
        this.productService = productService;
    }

    @GetMapping("/list/{id}")
    public String listCart(@PathVariable("id") Integer userId, Model model)
    {
        model.addAttribute("list", shoppingService.findAll(userId));
        model.addAttribute("user_id", userId);
        return "shoppingcart/list";
    }

    @GetMapping("/add/{id}")
    public String viewAdd(@PathVariable("id") Integer userId, Model model)
    {
        //Cho biết cart này thuộc user nào
        model.addAttribute("user_id", userId);
        //Lấy ra danh sách sản phẩm để lựa chọn thêm mới
        //Bên trang add sẽ cho chọn loại sản phẩm và số lượng
        model.addAttribute("product_list", productService.findAll());
        return "/shoppingcart/add";
    }
}
