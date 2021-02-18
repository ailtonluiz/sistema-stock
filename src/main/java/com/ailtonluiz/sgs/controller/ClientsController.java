package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    public ModelAndView newClient(Client client) {
        ModelAndView modelAndView = new ModelAndView("client/RegisterClient");

        return modelAndView;
    }
}
