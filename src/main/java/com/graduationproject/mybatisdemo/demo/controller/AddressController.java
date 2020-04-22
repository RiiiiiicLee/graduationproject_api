package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Address;
import com.graduationproject.mybatisdemo.demo.service.AddressService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * (Address)表控制层
 *
 * @author makejava
 * @since 2020-04-23 01:36:18
 */
@RestController
@RequestMapping("address")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

    @Autowired
    private JwtConfig jwtConfig;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Address selectOne(Integer id) {
        return this.addressService.queryById(id);
    }

    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public List<Address> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        String username = getUsername(auth);
        if(username==null){
            throw new AuthenticationException("token不可用");
        }
        return this.addressService.list(username);
    }

//    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
//    public int add(@RequestBody  ){
//        return this.addressService.add();
//    }

    public String getUsername(String auth){
        Claims claims = jwtConfig.getClaimByToken(auth);
        if(claims == null || JwtConfig.isTokenExpired(claims.getExpiration())){
            return null;
        }
        return claims.getSubject();
    }
}