package com.mingliang.travelagencymanagement.service;

import com.mingliang.travelagencymanagement.entity.Guide;

import java.util.List;

public interface GuideService {
    public List<Guide> selectAll();

    public List<Guide> selectByName(String name);
}
