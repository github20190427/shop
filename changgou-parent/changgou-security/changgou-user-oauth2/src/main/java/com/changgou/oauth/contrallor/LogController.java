package com.changgou.oauth.contrallor;

import com.changgou.oauth.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LogController {

    @Autowired
    TemplateService templateService;

    @GetMapping("/user")
    public String loginUser(String username,String password){
        System.out.println("username:"+username+" password:"+password);
        String token = templateService.logService(username,password);
        return "token:"+token;
    }
}
