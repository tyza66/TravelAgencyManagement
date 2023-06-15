package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: tyza66
 * Date: 2023/6/15 10:44
 * Github: https://github.com/tyza66
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId
    String uid;
    String upw;
}
