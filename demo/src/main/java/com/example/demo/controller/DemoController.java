package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "com/example/democontroller")
public class DemoController {

    @RequestMapping("/demo")
    public String index() {
        System.out.println(2);
        return "Hello World ";
    }
}
