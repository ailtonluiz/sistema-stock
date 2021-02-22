package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Company;
import com.ailtonluiz.sgs.repository.Companies;
import com.ailtonluiz.sgs.service.RegisterCompanyService;
import com.ailtonluiz.sgs.service.exception.CompanyNameAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private Companies companies;

    @Autowired
    private RegisterCompanyService registerCompanyService;

    @RequestMapping("/new")
    public ModelAndView newCompany(Company company) {
        ModelAndView modelAndView = new ModelAndView("company/RegisterCompany");

        return modelAndView;
    }

    @RequestMapping(value = {"/new", "{\\d+}"}, method = RequestMethod.POST)
    public ModelAndView save(@Valid Company company, BindingResult result, Model model,
                             RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return newCompany(company);
        }
//Company name already registered
        //CompanyNameAlreadyRegisteredException
        try {
            registerCompanyService.save(company);
        } catch (CompanyNameAlreadyRegisteredException e) {
            result.rejectValue("nameCompany", e.getMessage(), e.getMessage());
            return newCompany(company);
        }
        attributes.addFlashAttribute("message", "Empresa guardados con éxito!");
        return new ModelAndView("redirect:/companies/new");

    }
}
