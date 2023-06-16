package com.mingliang.travelagencymanagement.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Out {
    @TableId
    Integer oid;
    Integer bid;
    Integer gid;
    Timestamp out;
    Timestamp back;
}
