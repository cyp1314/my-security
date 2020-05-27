package com.cyp.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter {

    @Bean(value = "passwordEncoder")
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")   //客户端 client_id
                .secret(passwordEncoder().encode("secret")) //客户端 secret
                .authorizedGrantTypes("authorization_code")  //授权类型，授权码
                .scopes("app")   //范围
                .redirectUris("http://localhost:9003/") //重定向地址
                .and()
                .withClient("client1")   //客户端 client_id
                .secret(passwordEncoder().encode("secret")) //客户端 secret
                .authorizedGrantTypes("authorization_code")  //授权类型，授权码
                .scopes("app")   //范围
                .redirectUris("http://localhost:9006/login"); //重定向地址

    }
}
