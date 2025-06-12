package com.partyBuilding.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.vo.PageResultVo;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.activity.mapper.AdminTaskMapper;
import com.partyBuilding.activity.service.IAdminTaskService;
import com.partyBuilding.common.core.page.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {
    @Autowired
    private AdminTaskMapper adminTaskMapper;

    //查询全部进度
    @Override
    public PageVo selectProgress(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTask> taskList = adminTaskMapper.selectProgress();
        Page<UserTask> p = (Page<UserTask>) taskList;
        PageVo result = new PageVo(p.getTotal(), p.getResult());
        return result;
    }

    //查询具体进度
    @Override
    public PageVo detail(Integer pageNum, Integer pageSize , Long studentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTask> taskList = adminTaskMapper.detail(studentId);
        Page<UserTask> p = (Page<UserTask>) taskList;
        PageVo result = new PageVo(p.getTotal(), p.getResult());
        return result;
    }

    //查询任务
    @Override
    public PageResultVo selectTaskList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,  pageSize);
        List<Task> tasks = adminTaskMapper.selectTasks();
        Page<Task> p = (Page<Task>) tasks;
        return new PageResultVo(p.getTotal(), p.getResult());
    }

    //添加任务
    @Override
    public int insertTask(Task task) {
        return adminTaskMapper.insertTask(task);
    }
    //删除任务
    @Override
    public int deleteTasks(Long[] ids) {
        return adminTaskMapper.deleteTasks(ids);
    }

}
