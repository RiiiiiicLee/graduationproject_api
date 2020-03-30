package com.graduationproject.mybatisdemo.demo.service;

import com.graduationproject.mybatisdemo.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    User loginCheck(String username, String pwd);
    Boolean signupCheck(String username, String pwd);
    User signup(String username, String pwd);
}
