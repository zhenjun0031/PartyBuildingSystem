package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.StatisticsMapper;
import com.partyBuilding.activity.service.IStatisticsService;
import com.partyBuilding.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;

    /**
     * 获取当前用户每月的任务完成情况
     * @return
     */
    @Override
    public List<Map<String, Object>> getMonthlyTaskOrgUserCompletionNum(String studentId) {
        return statisticsMapper.selectMonthlyTaskCompletion(studentId);

    }
}
