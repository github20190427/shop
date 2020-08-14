package com.changgou.order.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContraller {

    @GetMapping("/test")
    public String test(){
        return "18081";
    }
}
