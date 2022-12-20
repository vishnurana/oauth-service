package com.rana.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource")
public class ResourceController {

    @GetMapping("public/greeting")
    public String greeting(){
        return "Good Morning";
    }

    @GetMapping("private/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return "Hi " + name + " welcome back.";
    }

}
