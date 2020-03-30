package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.User;
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


    @Autowired
    private JwtConfig jwtConfig;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @PostMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public Map<String , Object> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        {
            Claims claims = jwtConfig.getClaimByToken(auth);
            if (claims == null || JwtConfig.isTokenExpired(claims.getExpiration())) {
                throw new AuthenticationException("token不可用");
            }
            List<User> list = this.userService.list();
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                map.put("User"+i, list.get(i));
            }
            return map;
        }
    }
}