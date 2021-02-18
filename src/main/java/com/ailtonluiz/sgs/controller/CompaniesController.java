package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/companies")
public class CompaniesController {

    public ModelAndView newCompany(Company company) {
        ModelAndView modelAndView = new ModelAndView("company/RegisterCompany");

        return modelAndView;
    }
}
