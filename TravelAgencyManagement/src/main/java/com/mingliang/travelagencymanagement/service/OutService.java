package com.mingliang.travelagencymanagement.service;

import com.mingliang.travelagencymanagement.entity.Out;

import java.sql.Timestamp;
import java.util.List;

public interface OutService {
    public List<Out> selectAll();
    public Boolean guideTimeConflict(int id, Timestamp outtime,Timestamp backtime);
    public Boolean buserTimeConflict(int id, Timestamp outtime,Timestamp backtime);

}
