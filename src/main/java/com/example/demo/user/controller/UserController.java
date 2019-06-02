package com.example.demo.user.controller;

import com.example.demo.common.controller.BaseController;
import com.example.demo.common.dto.BaseResponse;
import com.example.demo.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
@Api(description = "基础 -- 用户")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "添加测试用户数据", notes = "添加测试用户数据，默认用户名和密码都是xiaoming")
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseResponse<Object> login(String userName, String password) {
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        boolean bool = userService.login(userName, password);
        if (bool) {
            baseResponse.setCode(0);
            baseResponse.setMsg("登录成功");
        } else {
            baseResponse.setCode(1);
            baseResponse.setMsg("用户名或密码不正确");
        }
        return baseResponse;
    }

}
