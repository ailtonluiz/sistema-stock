package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Unity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/units")
public class UnitsController {

    public ModelAndView newUnit(Unity unity) {
        ModelAndView modelAndView = new ModelAndView("unity/RegisterUnit");
        return modelAndView;


    }
}
