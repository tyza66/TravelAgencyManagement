package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: tyza66
 * Date: 2023/6/15 13:38
 * Github: https://github.com/tyza66
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cus {
    @TableField
    Integer cid;
    String cname;
    Integer bid;
    Integer gid;
    Integer oid;
}
