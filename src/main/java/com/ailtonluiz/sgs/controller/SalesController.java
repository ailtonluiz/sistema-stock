package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sales")
public class SalesController {

    public ModelAndView newSale(Sale sale) {
        ModelAndView modelAndView = new ModelAndView("sale/RegisterSale");

        return modelAndView;
    }

}
