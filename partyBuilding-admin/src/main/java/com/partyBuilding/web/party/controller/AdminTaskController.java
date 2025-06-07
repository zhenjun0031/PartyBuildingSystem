package com.partyBuilding.web.party.controller;

import com.partyBuilding.web.party.service.IAdminTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/task")
public class AdminTaskController {
    @Autowired
    private IAdminTaskService adminTaskService;

    //查询管理员下的未/已完成数

    //统计月份的柱状图（管理员）

    //查询任务列表

    //新增任务列表

    //删除任务列表

    //查询全部进度

    //查看具体进度
}
