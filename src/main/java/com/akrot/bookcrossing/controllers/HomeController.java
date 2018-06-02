package com.akrot.bookcrossing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello world");
        return "home";
    }
}
