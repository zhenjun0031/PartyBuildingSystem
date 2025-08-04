package com.partyBuilding.activity.domain.dto;

import lombok.Data;

@Data
public class AdminTaskPageQureyDTO {

    //年份
    private Integer year;

    //月份
    private Integer month;

    //页码
    private Integer page;

    //每页显示记录数
    private Integer pageSize;
}
