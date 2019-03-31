package com.sienna.postertracker.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        return "index.html";
    }
}
