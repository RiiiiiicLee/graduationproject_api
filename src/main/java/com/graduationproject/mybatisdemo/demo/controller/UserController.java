package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.RequestDao.userRequestDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.LoginService;
import com.graduationproject.mybatisdemo.demo.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-25 20:05:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private LoginService loginService;

    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public List<User> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        {
            Claims claims = jwtConfig.getClaimByToken(auth);
            if (claims == null || JwtConfig.isTokenExpired(claims.getExpiration())) {
                throw new AuthenticationException("token不可用");
            }
            List<User> list = this.userService.list();
            return list;
        }
    }

    @PostMapping(value = "/new", produces = "application/json;charset=UTF-8")
    public User newUser(@RequestHeader("Auth") String auth, @RequestBody userRequestDao userRequestDao){
        if(!this.loginService.signupCheck(userRequestDao.getUsername(),userRequestDao.getPassword())){
            throw new RuntimeException("用户已注册");
        }
        return null;
    }

}