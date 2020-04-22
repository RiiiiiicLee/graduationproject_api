package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Goods;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.GoodsService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2020-04-22 03:10:26
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */

    @Autowired
    private JwtConfig jwtConfig;
    @Resource
    private GoodsService goodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Goods selectOne(Integer id) {
        return this.goodsService.queryById(id);
    }

    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public List<Goods> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        return this.goodsService.list();
    }

    public Boolean tokenCheck(String auth){
        Claims claims = jwtConfig.getClaimByToken(auth);
        return claims == null || JwtConfig.isTokenExpired(claims.getExpiration());
    }
}