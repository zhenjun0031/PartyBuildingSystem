package com.partyBuilding.activity.domain.vo;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class selectByNamePageResultVo {

    private String studentId;

    private String userName;

    private Long total;

    private Integer taskNumber;

    private Integer finishTaskNumber;

    private List<?> task;
}
