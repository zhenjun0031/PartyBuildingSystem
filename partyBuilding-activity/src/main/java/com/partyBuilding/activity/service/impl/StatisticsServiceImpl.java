package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.StatisticsMapper;
import com.partyBuilding.activity.service.IStatisticsService;
import com.partyBuilding.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public Map<String,Object> getMonthlyTaskOrgUserCompletionNum(String studentId) {

        List<Map<String,Object>> list = statisticsMapper.selectMonthlyTaskCompletion(studentId);

        List<String>  month = new ArrayList<>();
        List<Integer>  completedCount = new ArrayList<>();

        for (Map<String, Object> map : list) {
            month.add(map.get("month").toString());
            int count = ((Number) map.get("completedCount")).intValue();
            completedCount.add(count);
        }


        Map<String,Object> result=new HashMap<>();
        result.put("month",month);
        result.put("completedCount",completedCount);


        return result;
    }
}
