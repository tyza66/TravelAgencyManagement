package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.BusWithInfo;
import com.mingliang.travelagencymanagement.entity.Buser;
import com.mingliang.travelagencymanagement.mapper.BuserMapper;
import com.mingliang.travelagencymanagement.service.BuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BuserServiceImpl extends ServiceImpl<BuserMapper, Buser> implements BuserService {


    @Override
    public List<BusWithInfo> selectAllBuser() {
        List<Buser> busers = baseMapper.selectList(null);
        List<BusWithInfo> list = new ArrayList<>();
        for(Buser one:busers){
            list.add(new BusWithInfo(one,baseMapper.selectOut(one.getBid()), baseMapper.selectMassage(one.getBid())));
        }
        return list;
    }

    public List<BusWithInfo> selectBuserById(String id){
        QueryWrapper<Buser> buserQueryWrapper = new QueryWrapper<>();
        buserQueryWrapper.like("bid", id);
        List<Buser> busers = baseMapper.selectList(buserQueryWrapper);
        List<BusWithInfo> list = new ArrayList<>();
        for(Buser one:busers){
            list.add(new BusWithInfo(one,baseMapper.selectOut(one.getBid()), baseMapper.selectMassage(one.getBid())));
        }
        return list;
    }

}
