package com.mingliang.travelagencymanagement.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/6/19 8:27
 * Github: https://github.com/tyza66
 **/

@Data
@NoArgsConstructor
public class Out1WithMassage {
    Integer oid;
    String bid;
    Integer gid;
    Timestamp out1;
    Timestamp back;
    Integer massage_id;
    String massage;

    public Out1WithMassage(Out1 out1,String massage){
        this.oid = out1.getOid();
        this.bid = out1.getBid();
        this.gid = out1.getGid();
        this.out1 = out1.getOut1();
        this.back = out1.getBack();
        this.massage = massage;
    }
}
