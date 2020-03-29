package com.graduationproject.mybatisdemo.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.graduationproject.mybatisdemo.demo.dao.UserDao;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginCheck(String username , String pwd) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(pwd)) {
            return this.userDao.queryById(1);
        } else {
            return null;
        }
    }
}
