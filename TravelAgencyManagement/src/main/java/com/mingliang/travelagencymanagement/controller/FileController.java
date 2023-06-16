package com.mingliang.travelagencymanagement.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Author: tyza66
 * Date: 2023/6/16 8:32
 * Github: https://github.com/tyza66
 **/

@Api(tags = "文件管理")
@RestController
public class FileController {
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public JSON uploadFile(MultipartFile file, HttpServletRequest req){
        JSONObject end = JSONUtil.createObj();
        try {
            String name = file.getOriginalFilename();
            String newname = UUID.randomUUID().toString() + name;
            String filepath = "target/classes/static/uploadFile/" + newname;
            String filepath2 = "static/uploadFile/" + newname;
            File endfile = new File(filepath);
            file.transferTo(endfile);
            FileUtil.copy(endfile, new File(filepath2), true);
            end.set("code", 200);
            end.set("msg", "上传成功");
            String url = req.getScheme() + "://" + req.getServerName() + ":" +
                    req.getServerPort() + "/uploadFile/" + newname;
            end.set("url", url);
        } catch (IOException e) {
            e.printStackTrace();
            end.set("code", 201);
            end.set("msg", "上传失败");
        }
        return end;
    }
}
