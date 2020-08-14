package com.changgou.oauth.config;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    //从数据库中查询出客户端信息
    @Autowired
    JdbcClientDetailsService jdbcClientDetailsService;
    @Bean
    JdbcClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }

//  jwt 令牌转换器
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    MyTokenConverter tokenConverter;

    @Bean
    public JwtAccessTokenConverter getJwtAccessTokenConverter(MyTokenConverter tokenConverter) {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //获取私钥和公钥的钥匙
        ClassPathResource pathResource = new ClassPathResource("keystore.jks");
        KeyStoreKeyFactory storeKeyFactory = new KeyStoreKeyFactory(pathResource,"mypass".toCharArray());
        KeyPair keyPair = storeKeyFactory.getKeyPair("mytest","mypass".toCharArray());
        jwtAccessTokenConverter.setKeyPair(keyPair);

        //设置设置自定义jwt转换器
        DefaultAccessTokenConverter accessTokenConverter = (DefaultAccessTokenConverter)jwtAccessTokenConverter.getAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(tokenConverter);
        return jwtAccessTokenConverter;
    }

//    @Bean
//    public JwtAccessTokenConverter getJwtAccessTokenConverter() {
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//        //获取私钥和公钥的钥匙
//        ClassPathResource pathResource = new ClassPathResource("keystore.jks");
//        KeyStoreKeyFactory storeKeyFactory = new KeyStoreKeyFactory(pathResource,"mypass".toCharArray());
//        KeyPair keyPair = storeKeyFactory.getKeyPair("mytest","mypass".toCharArray());
//        jwtAccessTokenConverter.setKeyPair(keyPair);
//        return jwtAccessTokenConverter;
//    }

    //token 保存策略
    @Autowired
    TokenStore tokenStore;
    @Bean
    @Autowired
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    //授权码模式专用对象
    @Autowired
    AuthorizationCodeServices authorizationCodeServices;
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }


    /***
     * 授权服务器的安全配置
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .passwordEncoder(new BCryptPasswordEncoder())
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jdbcClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(jwtAccessTokenConverter)             //jwt令牌转换器
                .authenticationManager(authenticationManager)               //认证管理器
                .authorizationCodeServices(authorizationCodeServices)       //授权码模式专用对象
                .tokenStore(tokenStore)                                     //token保存策略
                .userDetailsService(myUserDetailsService);                  //用户信息service
    }
}
