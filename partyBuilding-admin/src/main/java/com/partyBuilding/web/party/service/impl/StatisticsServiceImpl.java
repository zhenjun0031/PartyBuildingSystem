package com.partyBuilding.web.party.service.impl;

import com.partyBuilding.web.party.mapper.StatisticsMapper;
import com.partyBuilding.web.party.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;

}
