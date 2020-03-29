package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.LoginService;
import com.graduationproject.mybatisdemo.demo.service.impl.LoginServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;

@RestController
public class LoginController {

    @Autowired
    private JwtConfig jwtConfig;

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public String login(String username , String pwd){
        User user = this.loginService.loginCheck(username, pwd);
        String token = this.jwtConfig.generateToken(user.getUserid());
        return token;
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestHeader("Auth") String auth) throws AuthenticationException{
        Claims claims = jwtConfig.getClaimByToken(auth);
        if(claims == null || JwtConfig.isTokenExpired(claims.getExpiration())){
            throw new AuthenticationException("token不可用");
        }
        String userId = claims.getSubject();
        return userId;
    }
}
