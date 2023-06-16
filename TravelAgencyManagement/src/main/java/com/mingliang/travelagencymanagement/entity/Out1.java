package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Out1 {
    @TableId
    Integer oid;
    Integer bid;
    Integer gid;
    Timestamp out1;
    Timestamp back;
}
