package com.partyBuilding.web.controller.partyTask;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.vo.PageResultVo;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.activity.service.IAdminTaskService;
import com.partyBuilding.activity.service.IStatisticsService;
import com.partyBuilding.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/task")
@PreAuthorize("@ss.hasRole('admin')")//权限控制
public class AdminTaskController {
    @Autowired
    private IAdminTaskService adminTaskService;

    @Autowired
    private IStatisticsService statisticsService;

    /**
     * 查询管理员下的未/已完成数
     */
    @PostMapping("/task-completion")
    public AjaxResult getTaskStats() {
        int a = adminTaskService.getTaskStats(0);
        int b = adminTaskService.getTaskStats(1);
        Map<String, Integer> map = Map.of("unComplete", a, "complete", b);

        return AjaxResult.success(map);
    }


    //统计月份的柱状图（管理员）
    @GetMapping("/statistics")
    public AjaxResult getTaskStats(
            @RequestParam(name = "beginTime", required = false) LocalDate beginTime,
            @RequestParam(name = "endTime", required = false) LocalDate endTime
    ){
        if (beginTime == null) {
            beginTime = LocalDate.now().withDayOfMonth(1).minusMonths(13);
        }

        if (endTime == null) {
            endTime = LocalDate.now().withDayOfMonth(1);
        }
        Map<String,Object> taskStats = statisticsService.getMonthCompleted(beginTime, endTime);
        return AjaxResult.success(taskStats);
    }

    //查询任务列表
    @GetMapping("/selecttask")
    public AjaxResult selectTask(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize){
        PageResultVo pageResultVo = adminTaskService.selectTaskList(pageNum, pageSize);
        return AjaxResult.success(pageResultVo);
    }

    //新增任务列表
    @PostMapping("/inserttask")
    public AjaxResult insertTask(@RequestBody Task task){
        try {
            int rows = adminTaskService.insertTask(task);
            if (rows > 0) {
                Map<String, Object> data = new HashMap<>();
                data.put("taskId", task.getId());
                data.put("taskName", task.getTaskName());
                return AjaxResult.success(data);
            } else {
                return AjaxResult.error();
            }
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    //删除任务列表
    @DeleteMapping("deletetask/{ids}")
    public AjaxResult deleteTasks(@PathVariable("ids") Long[] ids) {
        try {
            int i = adminTaskService.deleteTasks(ids);
            if (i > 0) {
                String[] deletedIds = Arrays.stream(ids).map(String::valueOf).toArray(String[]::new);
                Map<String, Object> data = new HashMap<>();
                data.put("deletedIds", deletedIds);
                return AjaxResult.success(data);
            } else {
                return AjaxResult.error();
            }
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

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