package com.mingliang.travelagencymanagement.service;


import com.mingliang.travelagencymanagement.entity.Buser;

import java.sql.Timestamp;
import java.util.List;

public interface BuserService {
    public List<Buser> selectAllBuser();
    public Timestamp recentTime(int id);
}
