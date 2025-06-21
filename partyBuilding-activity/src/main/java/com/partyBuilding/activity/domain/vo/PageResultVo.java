package com.partyBuilding.activity.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultVo {
    //总数
    private Long total;

    //任务列表数据
    private List<?> rows;

}
