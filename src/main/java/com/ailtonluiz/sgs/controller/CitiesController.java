package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cities")
public class CitiesController {

    public ModelAndView newCity(City city) {
        ModelAndView modelAndView = new ModelAndView("city/RegisterCity");

        return modelAndView;
    }
}
