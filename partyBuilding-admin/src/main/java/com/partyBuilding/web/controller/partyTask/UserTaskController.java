package com.partyBuilding.web.controller.partyTask;

import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.UserTaskHandleDto;
import com.partyBuilding.activity.domain.dto.UserTaskPageQueryDto;
import com.partyBuilding.activity.service.IStatisticsService;
import com.partyBuilding.activity.service.impl.UserTaskServiceImpl;
import com.partyBuilding.common.annotation.Log;
import com.partyBuilding.common.constant.HttpStatus;
import com.partyBuilding.common.core.domain.AjaxResult;
import com.partyBuilding.common.enums.BusinessType;
import com.partyBuilding.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/task")
public class UserTaskController {

    //注入bean
    @Autowired
    private UserTaskServiceImpl userTaskService;

    @Autowired
    private IStatisticsService statisticsService;

    //查询用户未完成数



    //统计月份的柱状图（用户）
    //统计月份的柱状图（用户）
    @GetMapping("/monthlyCompletion")
    public AjaxResult monthlyCompletion() {
        String studentId = SecurityUtils.getLoginUser().getUser().getStudentId();
        Map<String, Object> stats = statisticsService.getMonthlyTaskOrgUserCompletionNum(studentId);
        return AjaxResult.success(stats);
        //SecurityUtils.getLoginUser().getUser().getStudentId();获取当前用户的学号
    }

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

    /**
     * 用户办理任务
     * @param userTaskHandleDto
     * @return
     */
    @PostMapping("/handle")
    @Log(title = "用户办理任务", businessType = BusinessType.UPDATE)
    public AjaxResult handleTask(@RequestBody UserTaskHandleDto userTaskHandleDto) {
        userTaskService.handle(userTaskHandleDto);
        return AjaxResult.success();
    }

    //用户上传文件

    /**
     * 用户上传文件
     * @param file
     * @return
     */
    @PostMapping("/file/upload/{id}")
    @Log(title = "用户上传文件", businessType = BusinessType.UPDATE)
    public AjaxResult userUploadFile( MultipartFile file ,
                                     @PathVariable("id") Long id){
        Object data=userTaskService.userFileUpload(file,id);
        return AjaxResult.success(data);
    }


    //修改已提交的任务

    /**
     * 用户修改已提交任务
     * @param userTaskHandleDto
     * @return
     */
    @Log(title = "用户修改任务", businessType = BusinessType.UPDATE)
    @PutMapping("/update")
    public AjaxResult update(@RequestBody UserTaskHandleDto userTaskHandleDto) {
        userTaskService.update(userTaskHandleDto);
        return AjaxResult.success();
    }

    //用户修改以及提交任务的数据回显（根据任务id查询数据）

    /**
     * 用户修改以及提交任务的数据回显（根据任务id查询数据）
     * @param id
     * @return
     */
    @GetMapping("/list/{id}")
    public AjaxResult getUserTaskById(@PathVariable("id") Long id) {
        UserTask userTask = userTaskService.getUserTaskById(id);
        return AjaxResult.success(userTask);
    }

}
