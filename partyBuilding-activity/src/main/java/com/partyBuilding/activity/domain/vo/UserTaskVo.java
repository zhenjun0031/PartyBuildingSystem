package com.partyBuilding.activity.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.partyBuilding.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTaskVo {
    private Integer taskId;
    private String taskName;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Integer status;
    private LocalDateTime commitTime;

}
