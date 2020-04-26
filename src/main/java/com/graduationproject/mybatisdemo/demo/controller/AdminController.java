package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.RequestDao.loginDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.dao.AdminDao;
import com.graduationproject.mybatisdemo.demo.entity.Admin;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-04-26 21:54:08
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Map<String , Object> login(@RequestBody Admin admin){
        Admin ad = this.adminService.loginCheck(admin.getAdminname(), admin.getPassword());
        if(ad == null){
            throw new RuntimeException("管理员用户名或密码错误");
        }
        Map<String , Object> map =new HashMap<>();
        String token = this.jwtConfig.generateToken(ad.getAdminname());
        map.put("Token",token);
        map.put("Admin",ad);
        return map;
    }
}