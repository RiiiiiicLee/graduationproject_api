package com.graduationproject.mybatisdemo.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.graduationproject.mybatisdemo.demo.dao.UserDao;
import com.graduationproject.mybatisdemo.demo.entity.User;
import com.graduationproject.mybatisdemo.demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;
import java.sql.SQLException;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserDao userDao;

    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Override
    public User loginCheck(String username , String pwd) {
        User user = new User();
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(pwd)) {
            try{
             user = this.userDao.login(username,pwd);}
            catch (Exception e){
                logger.debug("login failed ", e);
            }
        }
        if(user != null){
            return user;
        }else{
            logger.debug("用户名或密码错误");
            return null;
        }
    }
}
