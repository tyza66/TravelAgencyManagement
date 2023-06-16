package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Buser;
import com.mingliang.travelagencymanagement.mapper.BuserMapper;
import com.mingliang.travelagencymanagement.service.BuserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class BuserServiceImpl extends ServiceImpl<BuserMapper, Buser> implements BuserService {
    BuserMapper buserMapper;
    @Override
    public List<Buser> selectAllBuser() {
       return baseMapper.selectList(null);
    }

    @Override
    public Timestamp recentTime(int id) {
        Timestamp timestamp = buserMapper.selectOut(id);
        return timestamp;
    }
}
