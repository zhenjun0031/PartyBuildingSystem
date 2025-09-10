package com.partyBuilding.activity.domain.vo;

import lombok.Data;

import java.util.Map;

@Data
public class TaskChartVo {
    //饼状图：完成与未完成的比例
    private Map<String,Integer> pieCharData;
    //数据图表:年月查询
    private Map<String,Integer> barChartData;

}
