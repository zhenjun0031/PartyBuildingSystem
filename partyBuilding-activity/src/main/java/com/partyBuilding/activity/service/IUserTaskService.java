package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.dto.UserTaskPageQueryDto;
import com.partyBuilding.activity.domain.vo.PageVo;

public interface IUserTaskService {

    /**
     * 获取用户任务列表
     * @param userTaskPageQueryDto
     * @return
     */
    PageVo list(UserTaskPageQueryDto userTaskPageQueryDto);
}
