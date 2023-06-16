package com.mingliang.travelagencymanagement.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mingliang.travelagencymanagement.entity.Out1;
import com.mingliang.travelagencymanagement.service.impl.OutServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "出行表管理")
@RestController
@RequestMapping("/out")
public class OutController {
    @Autowired
    OutServiceImpl outService;
    @ApiOperation("计划列表")
    @PostMapping("/all")
    public JSON allOut() {
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()) {
            List<Out1> out = outService.selectAll();
            if (out.size() > 0) {
                obj.set("code", "200");
                obj.set("msg", out);
            } else {
                obj.set("code", "400");
                obj.set("msg", "列表为空");
            }
        } else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }
    @ApiOperation("添加计划")
    @PostMapping("/add")
    public JSON addOut(@RequestBody Out1 out){
        JSONObject obj = JSONUtil.createObj();
        Boolean guide = outService.guideTimeConflict(out.getGid(), out.getOut1(), out.getBack());
        Boolean bus = outService.buserTimeConflict(out.getBid(), out.getOut1(), out.getBack());
        if (StpUtil.isLogin()){
            boolean save = outService.save(out);
            if (guide){
                if(bus){
                if (save) {
                obj.set("code", "200");
                obj.set("msg", out);
                 } else {
                obj.set("code", "400");
                obj.set("msg", "列表为空");
                }
                }else {
                    obj.set("code", "222");
                    obj.set("msg", "大巴时间冲突");
                }
            }else {
                obj.set("code", "222");
                obj.set("msg", "导游时间冲突");
            }
        }else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;

    }
    @ApiOperation("修改计划")
    @PostMapping("/up")
    public JSON updateOut(@RequestBody Out1 out){
        JSONObject obj = JSONUtil.createObj();
        Boolean guide = outService.guideTimeConflict(out.getGid(), out.getOut1(), out.getBack());
        Boolean bus = outService.buserTimeConflict(out.getBid(), out.getOut1(), out.getBack());
        if (StpUtil.isLogin()){
            boolean save = outService.updateById(out);
            if (guide){
                if(bus){
                    if (save) {
                        obj.set("code", "200");
                        obj.set("msg", save);
                    } else {
                        obj.set("code", "400");
                        obj.set("msg", "计划添加失败");
                    }
                }else {
                    obj.set("code", "222");
                    obj.set("msg", "大巴时间冲突");
                }
            }else {
                obj.set("code", "222");
                obj.set("msg", "导游时间冲突");
            }
        }else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }
    @ApiOperation("删除计划")
    @PostMapping("/del")
    public JSON deleteOut(@RequestBody Out1 out){
        JSONObject obj = JSONUtil.createObj();
        if (StpUtil.isLogin()){
            boolean save = outService.removeById(out);
            if (save) {
                obj.set("code", "200");
                obj.set("msg", out);
            } else {
                obj.set("code", "400");
                obj.set("msg", "列表为空");
            }
        }else {
            obj.set("code", "201");
            obj.set("msg", "请先登录");
        }
        return obj;
    }
}
