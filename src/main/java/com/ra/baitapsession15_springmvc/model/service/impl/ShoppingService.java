package com.ra.baitapsession15_springmvc.model.service.impl;

import com.ra.baitapsession15_springmvc.model.dao.IProductDao;
import com.ra.baitapsession15_springmvc.model.dao.IShoppingDao;
import com.ra.baitapsession15_springmvc.model.dao.IUserDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.ProductDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.ShoppingDao;
import com.ra.baitapsession15_springmvc.model.dao.impl.UserDao;
import com.ra.baitapsession15_springmvc.model.dto.ShoppingDtoResponse;
import com.ra.baitapsession15_springmvc.model.entity.Product;
import com.ra.baitapsession15_springmvc.model.entity.ShoppingCart;
import com.ra.baitapsession15_springmvc.model.entity.User;
import com.ra.baitapsession15_springmvc.model.service.IShoppingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService implements IShoppingService
{
    private final static IShoppingDao shoppingDao = new ShoppingDao();
    private final static IProductDao productDao = new ProductDao();
    private final static IUserDao userDao = new UserDao();

    @Override
    public List<ShoppingDtoResponse> findAll(Integer userId)
    {
        List<ShoppingDtoResponse> shoppingDtoResponseList = new ArrayList<>();
        List<ShoppingCart> shoppingCartList = shoppingDao.findAll(userId);
//        List<Product> productList = shoppingCartList.stream().map(s->productDao.findById(s.getProductId())).toList();
//        List<User> userList = shoppingCartList.stream().map(s->userDao.findById(s.getUserId())).toList();
        for (ShoppingCart s : shoppingCartList)
        {
            ShoppingDtoResponse dto = changeShopModelToDto(s);
            shoppingDtoResponseList.add(dto);
        }
        return shoppingDtoResponseList;
    }

    @Override
    public ShoppingDtoResponse findById(Integer id)
    {
        return changeShopModelToDto(shoppingDao.findById(id));
    }

    @Override
    public void save(ShoppingCart shoppingCart)
    {
        shoppingDao.save(shoppingCart);
    }

    @Override
    public void deleteById(Integer id)
    {
        shoppingDao.deleteById(id);
    }

    private ShoppingDtoResponse changeShopModelToDto(ShoppingCart s)
    {
        ShoppingDtoResponse dto = new ShoppingDtoResponse();
        Product product = productDao.findById(s.getProductId());
        User user = userDao.findById(s.getUserId());
        dto.setId(s.getId());
        dto.setProduct(product);
        dto.setUser(user);
        dto.setQuantity(s.getQuantity());
        return dto;
    }
}
