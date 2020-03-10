package com.k0ft3.atman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({ "/", "/index" })
    public String getMethodName() {
        return "index.html";
    }

}