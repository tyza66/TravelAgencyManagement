package com.mingliang.travelagencymanagement.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mingliang.travelagencymanagement.entity.Buser;
import com.mingliang.travelagencymanagement.entity.Guide;
import com.mingliang.travelagencymanagement.service.impl.GuideServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "导游管理")
@RestController
@RequestMapping("/guide")
public class GuideController {
    @Autowired
    GuideServiceImpl guideService;

    @ApiOperation("导游列表")
    @GetMapping("/all")
    public JSON allGuide() {
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Guide> guides = guideService.selectAll();
            obj.set("code", "200");
            obj.set("msg", guides);
        } else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }

    @ApiOperation("增加导游")
    @PostMapping("/add")
    public JSON addGuide(@RequestBody Guide guide) {
        guide.setGid(0);
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            boolean save = guideService.save(guide);
            if (save) {
                obj.set("code", "200");
                obj.set("msg", save);
            } else {
                obj.set("code", "400");
                obj.set("msg", "添加失败");
            }
        } else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }

    @ApiOperation("修改信息")
    @PostMapping("/up")
    public JSON updateGuide(@RequestBody Guide guide) {
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            boolean b = guideService.updateById(guide);
            if (b) {
                obj.set("code", "200");
                obj.set("msg", b);
            } else {
                obj.set("code", "400");
                obj.set("msg", "修改失败");
            }
        } else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }

    @ApiOperation("删除导游")
    @PostMapping("/del")
    public JSON deleteGuide(@RequestBody Guide guide) {
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            boolean b = guideService.removeById(guide.getGid());
            if (b) {
                obj.set("code", "200");
                obj.set("msg", b);
            } else {
                obj.set("code", "400");
                obj.set("msg", "删除失败");
            }
        } else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }

    @ApiOperation("通过姓名获得导游列表")
    @GetMapping("/getByName")
    public JSON getByName(@RequestParam String name) {
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Guide> guides = guideService.selectByName(name);
                obj.set("code", "200");
                obj.set("msg", guides);
        } else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }
}
