package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.ResponseDao.salesrecordResponseDao;
import com.graduationproject.mybatisdemo.demo.ResponseDao.shoppingCarResponseDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Salesrecord;
import com.graduationproject.mybatisdemo.demo.service.SalesrecordService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * (Salesrecord)表控制层
 *
 * @author makejava
 * @since 2020-04-24 04:29:11
 */
@RestController
@RequestMapping("salesrecord")
public class SalesrecordController {
    /**
     * 服务对象
     */
    @Resource
    private SalesrecordService salesrecordService;

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Salesrecord selectOne(Integer id) {
        return this.salesrecordService.queryById(id);
    }

    @GetMapping("/list")
    public List<salesrecordResponseDao> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        String username = getUsername(auth);
        if (username == null) {
            throw new AuthenticationException("token不可用");
        }
        return this.salesrecordService.list(username);
    }

    public String getUsername(String auth) {
        Claims claims = jwtConfig.getClaimByToken(auth);
        if (claims == null || JwtConfig.isTokenExpired(claims.getExpiration())) {
            return null;
        }
        return claims.getSubject();
    }
}