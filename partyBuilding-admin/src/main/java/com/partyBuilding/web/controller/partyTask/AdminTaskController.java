package com.partyBuilding.web.controller.partyTask;

import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.activity.service.IAdminTaskService;
import com.partyBuilding.common.core.domain.AjaxResult;
import com.partyBuilding.common.core.domain.R;
import com.partyBuilding.common.core.page.PageDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/selectprogress")
    public AjaxResult selectProgress(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize){
        PageVo pageVo = adminTaskService.selectProgress(pageNum,  pageSize);
        return AjaxResult.success(pageVo);
    }
    //查看具体进度
    @GetMapping("/selectprogress/{studentId}")
    public AjaxResult detail(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @PathVariable Long studentId){
        PageVo pageVo = adminTaskService.detail(pageNum,  pageSize,  studentId );
        return AjaxResult.success(pageVo);    }
}