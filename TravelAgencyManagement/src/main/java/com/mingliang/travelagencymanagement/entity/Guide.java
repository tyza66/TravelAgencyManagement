package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guide {
    @TableId
    Integer gid;
    String gname;
    String gstate;
    Integer gtel;
}