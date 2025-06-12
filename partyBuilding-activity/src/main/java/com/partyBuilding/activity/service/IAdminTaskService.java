package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.vo.PageResultVo;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.common.core.page.PageDomain;

import java.util.List;

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
}
