package com.mingliang.travelagencymanagement.service;

import com.mingliang.travelagencymanagement.entity.Out1;

import java.sql.Timestamp;
import java.util.List;

public interface OutService {
    public List<Out1> selectAll();
    public Boolean guideTimeConflict(int id, Timestamp outtime,Timestamp backtime);
    public Boolean buserTimeConflict(String id, Timestamp outtime,Timestamp backtime);

}
