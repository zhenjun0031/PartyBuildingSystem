package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.StatisticsMapper;
import com.partyBuilding.activity.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;

}
