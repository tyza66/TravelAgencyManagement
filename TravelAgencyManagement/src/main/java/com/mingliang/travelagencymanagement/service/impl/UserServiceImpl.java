package com.mingliang.travelagencymanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingliang.travelagencymanagement.entity.User;
import com.mingliang.travelagencymanagement.mapper.UserMapper;
import com.mingliang.travelagencymanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/15 10:50
 * Github: https://github.com/tyza66
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean login(String username, String password) {
        QueryWrapper<User> queryMapper = new QueryWrapper<>();
        queryMapper.eq("uid", username);
        queryMapper.eq("upw", password);
        List<User> users = baseMapper.selectList(queryMapper);
        if(users.size()>=1){
            return true;
        }
        return false;
    }
}
