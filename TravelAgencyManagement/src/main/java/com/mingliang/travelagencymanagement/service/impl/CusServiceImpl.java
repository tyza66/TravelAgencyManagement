package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Cus;
import com.mingliang.travelagencymanagement.entity.Out1;
import com.mingliang.travelagencymanagement.mapper.CusMapper;
import com.mingliang.travelagencymanagement.mapper.OutMapper;
import com.mingliang.travelagencymanagement.service.CusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/15 13:45
 * Github: https://github.com/tyza66
 **/

@Service
public class CusServiceImpl extends ServiceImpl<CusMapper, Cus> implements CusService {

    @Resource
    private OutMapper outMapper;

    @Override
    public IPage<Cus> selectByPage(Integer page, Integer limit) {
        return baseMapper.selectPage(new Page<>(page, limit), null);
    }

    @Override
    public List<Cus> searchCusByName(String name) {
        QueryWrapper<Cus> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("cname", name);
        List<Cus> posts = baseMapper.selectList(queryWrapper);
        return posts;
    }

    @Override
    public boolean deleteById(Integer id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public int addAndCheckOid(Cus cus) {
        int end = 1;
        Out1 out1 = outMapper.selectById(cus.getOid());
        if(out1!=null){
            int insert = baseMapper.insert(cus);
            if(insert>=1){
                //插入成功
                end = 0;
            }else{
                //插入失败
                end = 1;
            }
        }else{
            //oid不存在
            end = 2;
        }
        return end;
    }
}
