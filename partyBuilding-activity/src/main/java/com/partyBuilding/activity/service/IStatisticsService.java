package com.partyBuilding.activity.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IStatisticsService {
    //用户月份统计
    /**
     * 获取当前用户每月的任务完成数
     * @return 每月任务完成数列表
     */
    List<Map<String, Object>> getMonthlyTaskOrgUserCompletionNum(String studentId);

    //管理员月份统计

}
