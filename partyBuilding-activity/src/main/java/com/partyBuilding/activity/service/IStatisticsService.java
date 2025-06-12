package com.partyBuilding.activity.service;

import java.time.LocalDate;
import java.util.Map;

public interface IStatisticsService {
    //用户月份统计
    /**
     * 获取当前用户每月的任务完成情况
     * @return {月份数组->任务完成数数组}
     */
    Map<String,Object> getMonthlyTaskOrgUserCompletionNum(String studentId);

    //管理员月份统计
    Map<String,Object> getMonthCompleted(LocalDate begin, LocalDate end);
}
