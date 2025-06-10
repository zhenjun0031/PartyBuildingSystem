package com.partyBuilding.activity.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTaskHandleDto {

    //被办理任务id
    private Long id;

    //用户学号
    private String studentId;

    //用户姓名
    @JsonProperty("studentName")
    private String userName;

    //文件地址
    private String file;
}
