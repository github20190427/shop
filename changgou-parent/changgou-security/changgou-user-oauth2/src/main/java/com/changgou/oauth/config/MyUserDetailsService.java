package com.changgou.oauth.config;

import com.changgou.oauth.feign.UserFeign;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserFeign userFeign;
    List<SimpleGrantedAuthority> roles = new ArrayList<>();
    String userName = "";
    String passWord = "";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Result<com.changgou.user.pojo.User> feignUser = userFeign.findById("13904211939");
        userName = feignUser.getData().getUsername();
        passWord = feignUser.getData().getPassword();
        System.out.println("this is  feign diaoyong de api");
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_VIP");
        roles.add(grantedAuthority);
        User user = new User(userName,passWord,roles);
//        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_*");
//        roles.add(grantedAuthority);
//        //根据用户名查找用户信息
//        userName = "3";
//        passWord = "$2a$10$e92latkHt6W9ecZISfaX8uHAV7CHWVHrGh1DxvSpcUi31hx4ljQEi";
////        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////        passWord = encoder.encode(passWord);
//        User user = new User(userName,passWord,roles);
        return user;
    }
}
