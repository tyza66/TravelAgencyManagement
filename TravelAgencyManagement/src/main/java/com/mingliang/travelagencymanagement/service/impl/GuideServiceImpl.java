package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Guide;
import com.mingliang.travelagencymanagement.mapper.GuideMapper;
import com.mingliang.travelagencymanagement.service.GuideService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuideServiceImpl extends ServiceImpl<GuideMapper, Guide> implements GuideService {
    @Override
    public List<Guide> selectAll() {
        List<Guide> guides = baseMapper.selectList(null);
        return guides;
    }
}
