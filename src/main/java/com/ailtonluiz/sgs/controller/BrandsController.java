package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Brand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands")
public class BrandsController {

    public ModelAndView newBrand(Brand brand) {
        ModelAndView modelAndView = new ModelAndView("brand/RegisterBrand");

        return modelAndView;


    }
}
