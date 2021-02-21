package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @RequestMapping("/new")
    public ModelAndView newProduct(Product product){
        ModelAndView modelAndView = new ModelAndView("product/RegisterProduct");

        return modelAndView;

    }
}
