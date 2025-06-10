package com.partyBuilding.activity.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {

    //  总记录数
    private Long total;

    //返回的数据
    private Object records;

}
