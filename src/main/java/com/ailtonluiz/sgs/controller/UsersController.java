package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {

    public ModelAndView newUser(User user) {

        ModelAndView modelAndView = new ModelAndView("user/RegisterUser");

        return modelAndView;

    }
}
