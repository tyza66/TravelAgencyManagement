package com.mingliang.travelagencymanagement.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mingliang.travelagencymanagement.entity.Cus;
import com.mingliang.travelagencymanagement.service.CusService;
import com.mingliang.travelagencymanagement.service.impl.CusServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/15 13:48
 * Github: https://github.com/tyza66
 **/

@Api(tags = "游客管理")
@RestController
@RequestMapping("/customer")
public class CusController {
    @Autowired
    private CusServiceImpl cusService;

    @ApiOperation("获取所有游客信息")
    @GetMapping("/all")
    public JSON getAllCus() {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Cus> list = cusService.list();
            end.set("code", 200);
            end.set("data", list);
        } else {
            end.set("code", 201);
            end.set("msg", "请先登录");
        }
        return end;
    }

    @ApiOperation("通过id删除指定游客信息")
    @PostMapping("/delete")
    public JSON deleteCusById(@RequestBody Cus cus) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            boolean b = cusService.removeById(cus.getCid());
            if (b) {
                end.set("code", 200);
                end.set("msg", "删除成功");
            } else {
                end.set("code", 201);
                end.set("msg", "删除失败");
            }
        } else {
            end.set("code", 201);
            end.set("msg", "请先登录");
        }
        return end;
    }

}
