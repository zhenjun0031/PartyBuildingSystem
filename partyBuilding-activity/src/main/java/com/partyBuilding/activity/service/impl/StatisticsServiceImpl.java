package com.partyBuilding.activity.service.impl;

import com.partyBuilding.activity.mapper.StatisticsMapper;
import com.partyBuilding.activity.service.IStatisticsService;
import com.partyBuilding.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
     * @return {月份数组->任务完成数数组}
     */
    @Override
    public Map<String,Object> getMonthlyTaskOrgUserCompletionNum(String studentId) {

        // 1. 获取数据库查询结果（当没有任何数据符合条件时，dbResults将是一个空列表[]）
        List<Map<String, Object>> dbResults = statisticsMapper.selectMonthlyTaskCompletion(studentId);

        // 2. 生成最近n个月的月份列表（包含当前月）
        List<String> allMonths = DateUtils.generateRecentMonths(6);

        // 3. 将数据库结果转为月份->数量的Map（当dbResults是空列表时不执行循环，monthContMap是一个空Map{}）
        Map<String,Integer> monthContMap=new  HashMap<>();
        for(Map<String, Object> item:dbResults){
            String month=(String) item.get("month");
            Integer  count=(Integer) item.get("count");
            monthContMap.put(month,count);
        }

        // 4. 填充完整月份数据（缺失的月份补0）
        List<Integer> completedCount = new ArrayList<>();
        for(String month:allMonths){
            Integer tempcount=monthContMap.get(month);//当month不存在于monthContMap时返回null（map默认行为）
            if(tempcount==null){
                completedCount.add(Integer.valueOf(0));//当没有任务完成时，所有月份对应任务完成数填充0
            }else{
                completedCount.add(tempcount);
            }
        }


        // 5. 构建返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("month", allMonths);
        result.put("completedCount", completedCount);

        return result;
    }

    @Override
    public Map<String,Object> getMonthCompleted(LocalDate begin, LocalDate end) {
        LocalDateTime beginTime = LocalDateTime.of(begin, LocalTime.MIN);
        LocalDateTime endTime = LocalDateTime.of(end, LocalTime.MIN);

        List<Map<String, Object>> dbResults =statisticsMapper.MonthCompleted(beginTime, endTime);

        List<String> allMonths = DateUtils.generateRecentMonths(12);

        List<String>   monthList= new ArrayList<>();
        List<Integer> completedList = new ArrayList<>();
        List<Integer> uncompletedList = new ArrayList<>();

        for (String month:allMonths) {
            boolean found = false;
            for (Map<String, Object> row : dbResults) {
                String dbMonth = (String) row.get("task_month");
                if (month.equals(dbMonth)) {
                    monthList.add(month);
                    completedList.add(((BigDecimal) row.get("completedCount")).intValue());
                    uncompletedList.add(((BigDecimal) row.get("uncompletedCount")).intValue());
                    found = true;
                    break;
                }
            }
            if (!found) {
                monthList.add(month);
                completedList.add(0);
                uncompletedList.add(0);
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("month",monthList);
        map.put("submittedCount",completedList);
        map.put("unSubmittedCount",uncompletedList);
        return  map;
    }

}
