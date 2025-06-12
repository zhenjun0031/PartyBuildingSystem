package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.StatisticsMapper;
import com.partyBuilding.activity.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Override
    public Map<String,Object> getMonthCompleted(LocalDate begin, LocalDate end) {
        LocalDateTime beginTime = LocalDateTime.of(begin, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(end, LocalTime.MIN);
        List<Map<String, Object>> resultList =statisticsMapper.MonthCompleted(beginTime, endTime);
        List<String> monthList = new ArrayList<>();
        List<Integer> completedList = new ArrayList<>();
        List<Integer> uncompletedList = new ArrayList<>();
        for (Map<String, Object> row : resultList) {
            monthList.add((String) row.get("month"));
            completedList.add((Integer) row.get("submittedCount"));
            uncompletedList.add((Integer) row.get("unSubmittedCount"));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("month",monthList);
        map.put("submittedCount",completedList);
        map.put("unSubmittedCount",uncompletedList);
        return  map;
    }

}
