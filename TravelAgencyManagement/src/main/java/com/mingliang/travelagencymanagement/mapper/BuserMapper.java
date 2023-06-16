package com.mingliang.travelagencymanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingliang.travelagencymanagement.entity.Buser;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

public interface BuserMapper extends BaseMapper<Buser> {
    @Select("select * from (SELECT o.out from `out` o,buser b where b.bid=o.bid  and b.bid=#{bid} ORDER BY o.out) e where e.out>SYSDATE()")
    public Timestamp selectOut(int bid);
}
