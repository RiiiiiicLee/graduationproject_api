package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.RequestDao.loginDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.LoginService;
import com.graduationproject.mybatisdemo.demo.service.impl.LoginServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private JwtConfig jwtConfig;

    @Resource
    private LoginService loginService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Map<String , Object> login(@RequestBody loginDao loginDao){
        User user = this.loginService.loginCheck(loginDao.getUsername(), loginDao.getPassword());
        if(user == null){
            throw new RuntimeException("用户名或密码错误");
        }
        Map<String , Object> map =new HashMap<>();
        String token = this.jwtConfig.generateToken(user.getUsername());
        map.put("Token",token);
        map.put("User",user);
        return map;
    }

    @PostMapping(value = "/signup", produces = "application/json;charset=UTF-8")
    public Map<String , Object> signup(@RequestBody loginDao loginDao){
        if(!this.loginService.signupCheck(loginDao.getUsername(),loginDao.getPassword())){
            throw new RuntimeException("用户已注册");
        }
        User user = this.loginService.signup(loginDao.getUsername(),loginDao.getPassword());
        if(user == null){
            throw new RuntimeException("注册失败");
        }
        Map<String , Object> map =new HashMap<>();
        String token = this.jwtConfig.generateToken(user.getUsername());
        map.put("Token",token);
        map.put("User",user);
        return map;
    }


    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestHeader("Auth") String auth) throws AuthenticationException{
        Claims claims = jwtConfig.getClaimByToken(auth);
        if(claims == null || JwtConfig.isTokenExpired(claims.getExpiration())){
            throw new AuthenticationException("token不可用");
        }
        return claims.getSubject();
    }
}
