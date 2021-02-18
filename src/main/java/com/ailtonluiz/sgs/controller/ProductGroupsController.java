package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.ProductGroup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/productGroups")
public class ProductGroupsController {
    public ModelAndView newProductGroup(ProductGroup productGroup) {
        ModelAndView modelAndView = new ModelAndView("productGroup/RegisterProductGroup");

        return modelAndView;
    }

}
