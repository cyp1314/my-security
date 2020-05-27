package com.cyp.authresource.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/view/1")
    public String hello1(){
        return "view";
    }

    @GetMapping("/insert/1")
    public String hello2(){
        return "insert";
    }
}
