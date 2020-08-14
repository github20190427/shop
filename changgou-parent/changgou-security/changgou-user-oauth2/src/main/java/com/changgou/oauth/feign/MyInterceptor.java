package com.changgou.oauth.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //获取私钥和公钥的钥匙
        ClassPathResource pathResource = new ClassPathResource("keystore.jks");
        KeyStoreKeyFactory storeKeyFactory = new KeyStoreKeyFactory(pathResource,"mypass".toCharArray());
        KeyPair keyPair = storeKeyFactory.getKeyPair("mytest","mypass".toCharArray());

        //指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        String[] roles = new String[1];
        roles[0] = "ROLE_VIP";
        Map map = new HashMap();
        map.put("authorities",roles);
        map.put("username","3");

        //当前系统时间
        long nowMillis = System.currentTimeMillis();
        //令牌签发时间
        Date now = new Date(nowMillis);
        //令牌过期时间设置
        long expMillis = nowMillis + 1000000;
        Date expDate = new Date(expMillis);

        //封装Jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId("8eeb2c22-b338-4f14-870a-a3b890ea742b")                    //唯一的ID
                .setSubject("subject")          // 主题  可以是JSON数据
                .setIssuer("admin")          // 签发者
                .setIssuedAt(now)             // 签发时间
                .setClaims(map)
//                .signWith(signatureAlgorithm, keyPair.getPrivate()) // 签名算法以及密匙
                .signWith(keyPair.getPrivate())
                .setExpiration(expDate);      // 设置过期时间

        //存放token
        String token ="bearer "+ builder.compact();
        System.out.println(token);
        requestTemplate.header("Authorization",token);
    }
}
