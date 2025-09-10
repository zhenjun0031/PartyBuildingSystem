package com.partyBuilding.web.controller.partyTask;

import com.partyBuilding.activity.domain.dto.TaskQueryDTO;
import com.partyBuilding.activity.domain.vo.TaskChartVo;
import com.partyBuilding.activity.service.IStatisticsService;
import com.partyBuilding.common.annotation.Log;
import com.partyBuilding.common.core.domain.AjaxResult;
import com.partyBuilding.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private IStatisticsService statisticsService;

    /**
     * 获取任务统计图表数据
     * @param queryDTO 年份、月份等查询条件
     * @return 封装了图表数据的统一响应结果
     */
    @PostMapping("/taskChartData")
    public AjaxResult getTaskChartData(@RequestBody TaskQueryDTO queryDTO){
        TaskChartVo taskChartVo = statisticsService.getTaskChartData(queryDTO);
        return AjaxResult.success(taskChartVo);
    }


}
