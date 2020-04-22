package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.RequestDao.shoppingCartRequsetDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
import com.graduationproject.mybatisdemo.demo.service.ShoppingcarService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * (Shoppingcar)表控制层
 */
@RestController
@RequestMapping("shoppingcar")
public class ShoppingcarController {

    @Resource
    private ShoppingcarService shoppingcarService;

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Shoppingcar selectOne(Integer id) {
        return this.shoppingcarService.queryById(id);
    }


    @GetMapping("/list")
    public List<shoppingCarResponseDao> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        String username = getUsername(auth);
        if (username == null) {
            throw new AuthenticationException("token不可用");
        }
        return this.shoppingcarService.list(username);
    }

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public int add(@RequestHeader("Auth") String auth,@RequestBody shoppingCartRequsetDao shoppingCartRequsetDao) throws AuthenticationException{
        String username = getUsername(auth);
        if (username == null) {
            throw new AuthenticationException("token不可用");
        }
         if(shoppingCartRequsetDao == null){
             throw new AuthenticationException("参数为空");
        }
        return this.shoppingcarService.add(username,shoppingCartRequsetDao);
    }

    public String getUsername(String auth) {
        Claims claims = jwtConfig.getClaimByToken(auth);
        if (claims == null || JwtConfig.isTokenExpired(claims.getExpiration())) {
            return null;
        }
        return claims.getSubject();
    }
}