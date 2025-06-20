package com.partyBuilding.web.controller.partyTask;

import com.partyBuilding.activity.service.IAdminTaskService;
import com.partyBuilding.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/task")
@PreAuthorize("@ss.hasRole('admin')")//权限控制
public class AdminTaskController {

    //注入bean
    @Autowired
    private IAdminTaskService adminTaskService;

    /**
     * 查询管理员下的未/已完成数
     * @return 返回格式：
     *  {
     *      "code": 200,
     *      "msg": "操作成功",
     *      "data": {
     *           "uncompleted": 未完成任务数,
     *           "completed": 已完成任务数
     *       }
     *   }
     */
    @PostMapping("/task-completion")
    public AjaxResult getTaskStats() {
        return AjaxResult.success(adminTaskService.getTaskStats());
    }


    //统计月份的柱状图（管理员）

    //查询任务列表

    //新增任务列表

    //删除任务列表

    //查询全部进度

    //查看具体进度
}