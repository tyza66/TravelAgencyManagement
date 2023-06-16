package com.mingliang.travelagencymanagement.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/6/16 10:57
 * Github: https://github.com/tyza66
 **/

@Data
public class CusWithInfo {
    Integer cid;
    String cname;
    Integer bid;
    Integer gid;
    Integer oid;
    Timestamp schedule;
    String info;
    public CusWithInfo(Cus cus, Timestamp schedule, String info){
        this.cid = cus.getCid();
        this.cname = cus.getCname();
        this.bid = cus.getBid();
        this.gid = cus.getGid();
        this.oid = cus.getOid();
        this.schedule = schedule;
        this.info = info;
    }
}
