package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {

    public ModelAndView newSupplier (Supplier supplier){
        ModelAndView modelAndView = new ModelAndView("supplier/Register");

        return modelAndView;
    }
}
