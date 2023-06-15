package com.mingliang.travelagencymanagement.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mingliang.travelagencymanagement.entity.User;
import com.mingliang.travelagencymanagement.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: tyza66
 * Date: 2023/6/15 10:13
 * Github: https://github.com/tyza66
 **/

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public JSON login(@RequestBody User user, HttpSession session){
        JSONObject end = JSONUtil.createObj();
        boolean login = userService.login(user.getUid(), user.getUpw());
        if (login){
            session.setAttribute("user",user);
            StpUtil.login(0);
            end.set("code",200);
            end.set("msg","登陆成功");
        }else {
            end.set("code",201);
            end.set("msg","用户不存在");
        }
        return end;
    }

    @ApiOperation("获取验证码")
    @GetMapping("/qr")
    public void getQr(HttpServletRequest request, HttpServletResponse response) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30, 4, 25);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            lineCaptcha.write(response.getOutputStream());
            String code = lineCaptcha.getCode();
            request.getSession().setAttribute("qr", code);
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("检查登录状态")
    @GetMapping("/check")
    public JSON check(HttpSession session) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            end.put("code", 200);
            end.put("msg", "已登录");
            end.put("user", (User)session.getAttribute("user"));
        } else {
            end.put("code", 201);
            end.put("msg", "未登录");
        }
        return end;
    }
}
