package com.changgou.oauth.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyTokenConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {

        /*
        "user_name": "3",
        "authorities": [
        "vip"
           ],
         */
        User user = (User)authentication.getPrincipal();

        Map map = new HashMap();
        map.put("like","1233");
        map.put("age","1113");
        map.put("user_name",user.getUsername());
        map.put("user_password",user.getPassword());
        map.put("authorities", AuthorityUtils.authorityListToSet(user.getAuthorities()));
        return map;
    }
}
