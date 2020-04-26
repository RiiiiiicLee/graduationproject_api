package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Goods;
import com.graduationproject.mybatisdemo.demo.entity.Notification;
import com.graduationproject.mybatisdemo.demo.service.NotificationService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * (Notification)表控制层
 *
 * @author makejava
 * @since 2020-04-24 04:08:12
 */
@RestController
@RequestMapping("notification")
public class NotificationController {
    /**
     * 服务对象
     */

    @Autowired
    private JwtConfig jwtConfig;
    @Resource
    private NotificationService notificationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Notification selectOne(Integer id) {
        return this.notificationService.queryById(id);
    }

    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public List<Notification> list() throws AuthenticationException {
        return this.notificationService.list();
    }

    @PostMapping(value = "/showNotifications", produces = "application/json;charset=UTF-8")
    public Notification showNotifications(@RequestHeader("Auth") String auth,
                           @RequestBody String notificationid)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        return this.notificationService.queryById(Integer.parseInt(notificationid));
    }

    @PostMapping(value = "/edit", produces = "application/json;charset=UTF-8")
    public Notification edit(@RequestHeader("Auth") String auth,
                                          @RequestBody Notification notification)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(notification==null){
            throw new AuthenticationException("参数为空");
        }
        return this.notificationService.update(notification);
    }

    @PostMapping(value = "/new", produces = "application/json;charset=UTF-8")
    public Notification newNotification(@RequestHeader("Auth") String auth,
                             @RequestBody Notification notification)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(notification==null){
            throw new AuthenticationException("参数为空");
        }
        return this.notificationService.insert(notification);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Notification delete(@RequestHeader("Auth") String auth,
                        @RequestBody String notificationid)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(notificationid == null){
            throw new AuthenticationException("参数为空");
        }
        Notification notification =new Notification();
        notification.setNotificationid(Integer.parseInt(notificationid));
        notification.setIsdeleted(1);
        return this.notificationService.update(notification);
    }

    public Boolean tokenCheck(String auth){
        Claims claims = jwtConfig.getClaimByToken(auth);
        return claims == null || JwtConfig.isTokenExpired(claims.getExpiration());
    }
}