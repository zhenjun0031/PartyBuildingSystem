package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.AdminTaskPageQureyDTO;
import com.partyBuilding.activity.domain.vo.PageResultVo;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.activity.domain.vo.selectByNamePageResultVo;

public interface IAdminTaskService {
    //  查询全部进度
    PageVo selectProgress(Integer pageNum, Integer pageSize);
    //查询具体进度
    PageVo detail(Integer pageNum, Integer pageSize, Long studentId);

    //查询任务列表
    PageResultVo selectTaskList(Integer pageNum, Integer pageSize);
    //添加任务
    int insertTask(Task task);
    //删除任务
    int deleteTasks(Long[] ids);

    /**
     * 获取管理员下的未/已完成数
     */
    int getTaskStats(int status);


    /**
     * 按年（月）查询任务列表
     */
    PageResultVo selectYearAndMonth(AdminTaskPageQureyDTO adminTaskPageQureyDTO);

    /**
     * 按人名查询任务列表
     */
    selectByNamePageResultVo selectName(Integer pageNum, Integer pageSize, String name);
}
