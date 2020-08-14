package com.changgou.security.controller;


import com.changgou.security.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginUserService loginUserService;

    @GetMapping("/login")
    public String loginUser(String username,String password){


        return "";
    }

}
