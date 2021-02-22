package com.ailtonluiz.sgs.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.userdetails.User;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal User user) {
        if (user != null) {
            return "redirect:/products";
        }

        return "Login";
    }

    @GetMapping("/403")
    public String acessoNegado() {
        return "403";
    }


}
