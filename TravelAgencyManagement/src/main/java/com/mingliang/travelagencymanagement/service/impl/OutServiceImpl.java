package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Out;
import com.mingliang.travelagencymanagement.mapper.OutMapper;
import com.mingliang.travelagencymanagement.service.OutService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class OutServiceImpl extends ServiceImpl<OutMapper, Out> implements OutService {
    @Override
    public List<Out> selectAll() {
        List<Out> outs = baseMapper.selectList(null);
        return outs;
    }

    @Override
    public Boolean guideTimeConflict(int id , Timestamp outtime,Timestamp backtime) {
        QueryWrapper<Out> outQueryWrapper = new QueryWrapper<>();
        outQueryWrapper.eq("gid",id);
        List<Out> outs = baseMapper.selectList(outQueryWrapper);
        for (Out i:outs){
            if (i.getOut().getTime()<=outtime.getTime()&&i.getBack().getTime()<=outtime.getTime()){
                return false;
            }else if (i.getOut().getTime()<=backtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return  false;
            }else if (i.getOut().getTime()>=outtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return false;
            }

        }return true;
    }

    @Override
    public Boolean buserTimeConflict(int id, Timestamp outtime, Timestamp backtime) {
        QueryWrapper<Out> outQueryWrapper = new QueryWrapper<>();
        outQueryWrapper.eq("bid",id);
        List<Out> outs = baseMapper.selectList(outQueryWrapper);
        for (Out i:outs){
            if (i.getOut().getTime()<=outtime.getTime()&&i.getBack().getTime()<=outtime.getTime()){
                return false;
            }else if (i.getOut().getTime()<=backtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return  false;
            }else if (i.getOut().getTime()>=outtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return false;
            }

        }return true;
    }


}
