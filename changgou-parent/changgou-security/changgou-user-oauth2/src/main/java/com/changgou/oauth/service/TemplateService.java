package com.changgou.oauth.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TemplateService {

    private RestTemplate restTemplate = null;
    private String url;
    private HttpMethod httpMethod;
    private HttpEntity httpEntity;
    private Map map;

    public String logService(String userName,String passWord){

        url = "http://127.0.0.1:9001/oauth/token";
        httpMethod = HttpMethod.POST;

        MultiValueMap fromData = new LinkedMultiValueMap();
        fromData.add("grant_type","password");
        fromData.add("username",userName);
        fromData.add("password",passWord);
        fromData.add("client_id","heima_one");
        fromData.add("client_secret","123");

        httpEntity = new HttpEntity(fromData,fromData);

        restTemplate = new RestTemplate();
        ResponseEntity<Map> mapResponseEntity = restTemplate.exchange(url,httpMethod,httpEntity, Map.class);
        map = mapResponseEntity.getBody();
        //访问令牌(jwt)
        String accessToken = (String) map.get("access_token");
        //刷新令牌(jwt)
        String refreshToken = (String) map.get("refresh_token");
        //jti，作为用户的身份标识
        String jwtToken= (String) map.get("jti");
        return "token: "+accessToken;
    }

}
