package com.mingliang.travelagencymanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingliang.travelagencymanagement.entity.Massage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * Author: tyza66
 * Date: 2023/6/18 17:47
 * Github: https://github.com/tyza66
 **/

public interface MessageMapper extends BaseMapper<Massage> {

    @Select("SELECT * FROM `travle`.`massage` WHERE `oid` = #{oid}")
    public String SecletInfoByOid(int oid);
}
