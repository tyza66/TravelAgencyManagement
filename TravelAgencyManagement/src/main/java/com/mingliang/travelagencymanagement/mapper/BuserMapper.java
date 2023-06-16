package com.mingliang.travelagencymanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingliang.travelagencymanagement.entity.Buser;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

public interface BuserMapper extends BaseMapper<Buser> {
    @Select("select * from (SELECT o.out1 from out1 o,buser b where b.bid=o.bid  and b.bid=#{bid} ORDER BY o.out1) e where e.out1>SYSDATE()")
    public Timestamp selectOut(String bid);
    @Select("select m.massage from massage m,out1 o,buser b where b.bid=#{bid} and b.bid=o.bid and o.oid=m.oid")
    public String selectMassage(String bid);
}
