package com.partyBuilding.web.controller.partyTask;

import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.UserTaskPageQueryDto;
import com.partyBuilding.activity.service.impl.UserTaskServiceImpl;
import com.partyBuilding.common.constant.HttpStatus;
import com.partyBuilding.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/task")
public class UserTaskController {

    //注入bean
    @Autowired
    private UserTaskServiceImpl userTaskService;

    //查询用户未完成数

    //统计月份的柱状图（用户）

    //查询任务列表

    /**
     * 查询用户任务列表
     * @return
     */
    @GetMapping("/list")
    public AjaxResult list(@RequestBody UserTaskPageQueryDto userTaskPageQueryDto) {
        return new AjaxResult(HttpStatus.SUCCESS,
                "success",
                userTaskService.list(userTaskPageQueryDto));
    }

    //办理任务

    //修改已提交的任务

}
