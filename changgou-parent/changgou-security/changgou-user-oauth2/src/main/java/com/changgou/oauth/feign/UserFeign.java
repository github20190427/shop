package com.changgou.oauth.feign;


import com.changgou.user.pojo.User;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user")
@RequestMapping("/user")
public interface UserFeign {

    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable String id);
    @GetMapping("/load/{name}")
    public Result<User> findByName(@PathVariable String name);
}
