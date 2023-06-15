package com.mingliang.travelagencymanagement.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mingliang.travelagencymanagement.entity.Buser;
import com.mingliang.travelagencymanagement.entity.User;
import com.mingliang.travelagencymanagement.service.impl.BuserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(tags = "司机管理")
@RestController
@RequestMapping("/buser")
public class BuserController {

    @Autowired
    private BuserServiceImpl buserService;
    @ApiOperation("司机列表")
    @PostMapping("/all")
    public JSON allBuser(){
        JSONObject obj = JSONUtil.createObj();
        List<Buser> busers = buserService.selectAllBuser();
        if (busers.size()>0){
            obj.set("code","200");
            obj.set("msg",busers);
        }else{
            obj.set("code","400");
            obj.set("msg","列表为空");
        }
        return obj;
    }
    @ApiOperation("添加司机")
    @PostMapping("/add")
    public JSON addBuser(@RequestBody Buser buser){
        JSONObject obj = JSONUtil.createObj();
        boolean save = buserService.save(buser);
        if(save){
            obj.set("code","200");
            obj.set("msg",save);
        }else{
            obj.set("code","400");
            obj.set("msg","添加失败");
        }return obj;
    }
    @ApiOperation("信息修改")
    @PostMapping("/up")
    public JSON updateBuser(@RequestBody Buser buser){
        JSONObject obj = JSONUtil.createObj();
        boolean b = buserService.updateById(buser);
        if(b){
            obj.set("code","200");
            obj.set("msg",b);
        }else{
            obj.set("code","400");
            obj.set("msg","修改失败");
        }return obj;
    }
    @ApiOperation("删除司机")
    @PostMapping("/del")
    public JSON deleteBuser(@RequestBody Buser buser){
        JSONObject obj = JSONUtil.createObj();
        boolean b = buserService.removeById(buser.getBid());
        if(b){
            obj.set("code","200");
            obj.set("msg",b);
        }else{
            obj.set("code","400");
            obj.set("msg","删除失败");
        }return obj;
    }


}
