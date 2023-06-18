package com.mingliang.travelagencymanagement.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mingliang.travelagencymanagement.entity.Cus;
import com.mingliang.travelagencymanagement.entity.CusWithInfo;
import com.mingliang.travelagencymanagement.service.impl.CusServiceImpl;
import com.mingliang.travelagencymanagement.service.impl.OutServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    @Autowired
    private OutServiceImpl outService;

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

    @ApiOperation("分页查询游客信息")
    @GetMapping("/page")
    public JSON getCusByPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            IPage<Cus> list = cusService.selectByPage(page, limit);
            List<Cus> records = list.getRecords();
            List<CusWithInfo> infoList= new ArrayList<>();
            for(Cus one:records){
                infoList.add(new CusWithInfo(one,outService.getById(one.getOid()).getOut1(),"giao"));
            }
            end.set("code", 200);
            end.set("data", list);
            end.set("dataWithInfo",infoList);
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

    @ApiOperation("按游客名搜索游客信息")
    @GetMapping("/search")
    public JSON searchCusByName(@RequestParam("name") String name) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Cus>  list= cusService.searchCusByName(name);
            List<CusWithInfo> infoList= new ArrayList<>();
            for(Cus one:list){
                infoList.add(new CusWithInfo(one,outService.getById(one.getOid()).getOut1()==null?new Timestamp(0) :outService.getById(one.getOid()).getOut1(),"giao"));
            }
            end.set("code", 200);
            end.set("data", infoList);
        } else {
            end.set("code", 201);
            end.set("msg", "请先登录");
        }
        return end;
    }

    @ApiOperation("添加游客信息")
    @PostMapping("/add")
    public JSON addCus(@RequestBody Cus cus) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
           int b = cusService.addAndCheckOid(cus);
            if (b==0) {
                end.set("code", 200);
                end.set("msg", "添加成功");
            } else if(b==1){
                end.set("code", 201);
                end.set("msg", "添加失败");
            }else if (b==2) {
                end.set("code", 202);
                end.set("msg", "oid不存在");
            }
        } else {
            end.set("code", 201);
            end.set("msg", "请先登录");
        }
        return end;
    }

    @ApiOperation("修改游客信息")
    @PostMapping("/update")
    public JSON updateCus(@RequestBody Cus cus) {
        JSONObject end = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            int b = cusService.updateAndCheckOid(cus);
            if (b==0) {
                end.set("code", 200);
                end.set("msg", "修改成功");
            } else if(b==1){
                end.set("code", 201);
                end.set("msg", "修改失败");
            }else if (b==2) {
                end.set("code", 202);
                end.set("msg", "oid不存在");
            }
        } else {
            end.set("code", 201);
            end.set("msg", "请先登录");
        }
        return end;
    }
}
