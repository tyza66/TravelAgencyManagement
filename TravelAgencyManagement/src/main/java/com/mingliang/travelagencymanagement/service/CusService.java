package com.mingliang.travelagencymanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Cus;
import com.mingliang.travelagencymanagement.mapper.CusMapper;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/15 13:44
 * Github: https://github.com/tyza66
 **/

public interface CusService {
    public IPage<Cus> selectByPage(Integer page, Integer limit);

    public List<Cus> searchCusByName(String name);

    public boolean deleteById(Integer id);

    //检查并添加oid 这里使用情况表示 0为添加成功 1为添加失败 2oid不存在
    public int addAndCheckOid(Cus cus);

    public int updateAndCheckOid(Cus cus);
}
