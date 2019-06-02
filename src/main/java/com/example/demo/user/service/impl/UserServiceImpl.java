package com.example.demo.user.service.impl;

import com.example.demo.user.dao.UserMapper;
import com.example.demo.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AsyncTask addLoginHistory;

    @Override
    public boolean login(String userName, @NotBlank String password) {
        Integer userId = userMapper.login(userName, DigestUtils.md5DigestAsHex(password.getBytes()));
        if (userId != null) {
            addLoginHistory.addLoginHistory(userId);
            return true;
        }
        return false;
    }

}
