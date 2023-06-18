package com.mingliang.travelagencymanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingliang.travelagencymanagement.entity.Cus;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: tyza66
 * Date: 2023/6/15 13:41
 * Github: https://github.com/tyza66
 **/

public interface CusMapper extends BaseMapper<Cus> {

    @Update("INSERT INTO `travle`.`cus` (`cname`, `bid`, `gid`, `oid`) VALUES (#{cname}, #{bid}, #{gid}, #{oid})")
    @Transactional
    public int insertAndUp(Cus cus);
}
