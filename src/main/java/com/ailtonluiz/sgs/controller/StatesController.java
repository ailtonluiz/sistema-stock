package com.ailtonluiz.sgs.controller;

import com.ailtonluiz.sgs.model.State;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/states")
public class StatesController {

    public ModelAndView ModelAndView(State state) {
        ModelAndView modelAndView = new ModelAndView("state/RegisterState");
        return modelAndView;
    }
}
