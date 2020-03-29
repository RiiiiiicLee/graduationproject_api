package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.entity.User;
import org.springframework.stereotype.Service;


public interface LoginService {
    User loginCheck(String username,String pwd);
}
