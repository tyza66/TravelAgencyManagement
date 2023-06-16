package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buser {
    @TableId
    String bid;
    String Bname;
    String Btel;
    Integer Bnum;
    String Bstate;
}
