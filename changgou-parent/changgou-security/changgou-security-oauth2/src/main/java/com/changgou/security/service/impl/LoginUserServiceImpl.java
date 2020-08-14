package com.changgou.security.service.impl;

import com.changgou.security.service.LoginUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LoginUserServiceImpl implements LoginUserService {

//    @Value("${responseEntity.getBody}")
//    private String clientId ;
    @Override
    public Map loginUser() {

        String url = "";
        MultiValueMap<String, String> headers = new LinkedMultiValueMap();
        headers.add("1","1");
        MultiValueMap<String, String> body = new LinkedMultiValueMap();
        headers.add("2","2");
        HttpEntity httpEntity = new HttpEntity(body,headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseEntity =restTemplate.exchange(url, HttpMethod.POST,httpEntity, Map.class);
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }
}
