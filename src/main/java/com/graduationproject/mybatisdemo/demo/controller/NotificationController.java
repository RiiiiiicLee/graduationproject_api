package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.entity.Notification;
import com.graduationproject.mybatisdemo.demo.service.NotificationService;
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
}