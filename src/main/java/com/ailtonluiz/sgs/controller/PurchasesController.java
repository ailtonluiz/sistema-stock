package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Purchase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/purchases")
public class PurchasesController {

    public ModelAndView newPurchase(Purchase purchase) {
        ModelAndView modelAndView = new ModelAndView("purchase/RegistrationPurchase");

        return modelAndView;
    }

}
