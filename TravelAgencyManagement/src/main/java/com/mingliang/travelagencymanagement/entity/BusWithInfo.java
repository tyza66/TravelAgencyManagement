package com.mingliang.travelagencymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusWithInfo {
    Buser buser;
    Timestamp schedule;
    String info;
}
