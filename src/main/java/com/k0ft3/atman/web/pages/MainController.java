package com.k0ft3.atman.web.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = { "/", "/login" })
    public String entry() {
        return "index";
    }
}