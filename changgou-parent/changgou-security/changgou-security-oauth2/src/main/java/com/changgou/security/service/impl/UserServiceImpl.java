package com.changgou.security.service.impl;

import com.changgou.user.feign.SysUserFeign;
import com.changgou.security.dao.SysUserMapper;
import com.changgou.security.service.UserService;
import com.changgou.user.pojo.SysRole;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    private String userName;
    private String passWord;
    private SysRole sysRole;
    private List<SimpleGrantedAuthority> roles;

    @Autowired
    SysUserFeign sysUserFeign;

//    ClientDetailsService

    @Override
    public UserDetails loadUserByUsername(String s){
//        try {
////            System.out.println(new ObjectMapper().writeValueAsString(userMapper.findByName(s)));
////        } catch (JsonProcessingException e) {
////            e.printStackTrace();
////        }
//        return userMapper.findByName(s);

        Result<com.changgou.user.pojo.SysUser> sUser = sysUserFeign.findsByName(s);
        userName = sUser.getData().getUsername();
        passWord = sUser.getData().getPassword();
        roles = new ArrayList<>();
        Iterator iterator = sUser.getData().getRoles().iterator();
        while (iterator.hasNext()){
            sysRole = (SysRole) iterator.next();
            roles.add(new SimpleGrantedAuthority(sysRole.getROLENAME()));
        }
        System.out.println(userName+"  "+passWord);
        User user = new User(userName,passWord,roles);
        return user;
    }
}
