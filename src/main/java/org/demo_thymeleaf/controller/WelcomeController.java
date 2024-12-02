package org.demo_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Refers to index.html in /WEB-INF/templates/
    }

}