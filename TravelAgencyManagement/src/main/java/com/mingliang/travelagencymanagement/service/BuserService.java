package com.mingliang.travelagencymanagement.service;


import com.mingliang.travelagencymanagement.entity.BusWithInfo;
import com.mingliang.travelagencymanagement.entity.Buser;

import java.sql.Timestamp;
import java.util.List;

public interface BuserService {
    public List<BusWithInfo> selectAllBuser();
    public List<BusWithInfo> selectBuserById(String id);

}
