package com.akrot.bookcrossing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping
public class BookController
{
    @GetMapping("/books")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello world");
        return "books";
    }

    @GetMapping("/share")
    public String share(Map<String, Object> model) {
        model.put("message", "Hello world");
        return "share";
    }
}
