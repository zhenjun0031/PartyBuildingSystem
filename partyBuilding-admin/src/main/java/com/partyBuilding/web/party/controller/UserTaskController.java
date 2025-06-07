package com.partyBuilding.web.party.controller;

import com.partyBuilding.web.party.service.IUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/task")
public class UserTaskController {
    @Autowired
    private IUserTaskService userTaskService;

    //查询用户未完成数

    //统计月份的柱状图（用户）

    //查询任务列表

    //办理任务

    //修改已提交的任务

}
