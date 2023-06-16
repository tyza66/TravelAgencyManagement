package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Massage {
    @TableId
    Integer massage_id;
    String massage;
    Integer oid;
}
