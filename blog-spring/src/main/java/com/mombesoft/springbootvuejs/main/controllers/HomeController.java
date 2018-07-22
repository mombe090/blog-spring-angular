package com.mombesoft.springbootvuejs.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @GetMapping
    @ResponseBody
    public String root() {
        return "Hello world";
    }
}
