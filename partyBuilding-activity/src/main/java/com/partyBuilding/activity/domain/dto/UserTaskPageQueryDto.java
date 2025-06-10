package com.partyBuilding.activity.domain.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTaskPageQueryDto {

    // 当前页码
    private Integer page;

    //当前用户id
    private String studentId;
}
