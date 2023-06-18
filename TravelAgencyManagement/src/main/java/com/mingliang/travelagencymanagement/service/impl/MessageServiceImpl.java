package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.Massage;
import com.mingliang.travelagencymanagement.mapper.MessageMapper;
import com.mingliang.travelagencymanagement.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * Author: tyza66
 * Date: 2023/6/18 17:46
 * Github: https://github.com/tyza66
 **/

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Massage> implements MessageService {

    @Override
    public String SecletInfoByOid(int oid) {
        return baseMapper.SecletInfoByOid(oid);
    }
}
