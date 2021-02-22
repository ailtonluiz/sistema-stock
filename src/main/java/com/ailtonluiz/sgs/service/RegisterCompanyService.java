package com.ailtonluiz.sgs.service;

import com.ailtonluiz.sgs.model.Company;
import com.ailtonluiz.sgs.repository.Companies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


@Service
public class RegisterCompanyService {

    @Autowired
    private Companies companies;

    @Transactional
    public Company save(Company company) {
        return companies.saveAndFlush(company);
    }

}

