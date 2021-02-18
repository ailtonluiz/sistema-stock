package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/countries")
public class CountriesController {

    public ModelAndView newCounty(Country country) {
        ModelAndView modelAndView = new ModelAndView("country/RegisterCountry");

        return modelAndView;
    }
}
