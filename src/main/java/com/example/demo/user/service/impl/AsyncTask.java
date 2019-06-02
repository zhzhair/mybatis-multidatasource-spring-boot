package com.example.demo.user.service.impl;

import com.example.demo.user.daoAction.UserActionMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AsyncTask {
    @Resource
    private UserActionMapper userActionMapper;

    @Async
    public void addLoginHistory(Integer userId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userActionMapper.addLoginHistory(userId);
    }
}
