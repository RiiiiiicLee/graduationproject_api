package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Goods;
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
 *
 * @author makejava
 * @since 2020-04-22 23:41:12
 */
@RestController
@RequestMapping("shoppingcar")
public class ShoppingcarController {
    /**
     * 服务对象
     */
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
        Claims claims = jwtConfig.getClaimByToken(auth);
        if(claims == null || JwtConfig.isTokenExpired(claims.getExpiration())){
            throw new AuthenticationException("token不可用");
        }
        String username = claims.getSubject();
        return this.shoppingcarService.list(username);
    }
}