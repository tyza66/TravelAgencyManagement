package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Out1;
import com.mingliang.travelagencymanagement.mapper.OutMapper;
import com.mingliang.travelagencymanagement.service.OutService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class OutServiceImpl extends ServiceImpl<OutMapper, Out1> implements OutService {
    @Override
    public List<Out1> selectAll() {
        List<Out1> outs = baseMapper.selectList(null);
        return outs;
    }

    @Override
    public Boolean guideTimeConflict(int id , Timestamp outtime,Timestamp backtime) {
        QueryWrapper<Out1> outQueryWrapper = new QueryWrapper<>();
        outQueryWrapper.eq("gid",id);
        List<Out1> outs = baseMapper.selectList(outQueryWrapper);
        for (Out1 i:outs){
            if (i.getOut1().getTime()<=outtime.getTime()&&i.getBack().getTime()<=outtime.getTime()){
                return false;
            }else if (i.getOut1().getTime()<=backtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return  false;
            }else if (i.getOut1().getTime()>=outtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return false;
            }

        }return true;
    }


    @Override
    public Boolean buserTimeConflict(String id, Timestamp outtime, Timestamp backtime) {
        QueryWrapper<Out1> outQueryWrapper = new QueryWrapper<>();
        outQueryWrapper.eq("bid",id);
        List<Out1> outs = baseMapper.selectList(outQueryWrapper);
        for (Out1 i:outs){
            if (i.getOut1().getTime()<=outtime.getTime()&&i.getBack().getTime()<=outtime.getTime()){
                return false;
            }else if (i.getOut1().getTime()<=backtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return  false;
            }else if (i.getOut1().getTime()>=outtime.getTime()&&i.getBack().getTime()<=backtime.getTime()){
                return false;
            }

        }return true;
    }
}
