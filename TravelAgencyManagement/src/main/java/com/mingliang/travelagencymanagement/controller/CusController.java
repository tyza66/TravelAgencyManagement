package com.mingliang.travelagencymanagement.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mingliang.travelagencymanagement.service.CusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/6/15 13:48
 * Github: https://github.com/tyza66
 **/

@Api("游客管理")
@RestController
@RequestMapping("/customer")
public class CusController {
    @Autowired
    private CusService cusService;

    @ApiOperation("获取所有游客信息")
    @GetMapping("/all")
    public JSON getAllCus() {
        JSONObject obj = JSONUtil.createObj();
        
    }
}
