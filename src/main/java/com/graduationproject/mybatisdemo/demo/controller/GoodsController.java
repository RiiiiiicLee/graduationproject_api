package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Goods;
import com.graduationproject.mybatisdemo.demo.entity.Shoppingcar;
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

    @PostMapping(value = "/showGoods", produces = "application/json;charset=UTF-8")
    public Goods showGoods(@RequestHeader("Auth") String auth,
                        @RequestBody String goodsId)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        return this.goodsService.queryById(Integer.parseInt(goodsId));
    }

    @PostMapping(value = "/new", produces = "application/json;charset=UTF-8")
    public Goods newgoods(@RequestHeader("Auth") String auth,
                           @RequestBody Goods goods)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(goods==null){
            throw new AuthenticationException("参数为空");
        }
        return this.goodsService.insert(goods);
    }

    @PostMapping(value = "/edit", produces = "application/json;charset=UTF-8")
    public Goods edit(@RequestHeader("Auth") String auth,
                    @RequestBody Goods goods)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(goods == null){
            throw new AuthenticationException("参数为空");
        }
        return this.goodsService.update(goods);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Goods delete(@RequestHeader("Auth") String auth,
                      @RequestBody String goodsId)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(goodsId == null){
            throw new AuthenticationException("参数为空");
        }
        Goods goods =new Goods();
        goods.setGoodsid(Integer.parseInt(goodsId));
        goods.setIsdeleted(1);
        return this.goodsService.update(goods);
    }

    public Boolean tokenCheck(String auth){
        Claims claims = jwtConfig.getClaimByToken(auth);
        return claims == null || JwtConfig.isTokenExpired(claims.getExpiration());
    }
}