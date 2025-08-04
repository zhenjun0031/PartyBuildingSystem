package com.partyBuilding.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.partyBuilding.activity.domain.Task;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.AdminTaskPageQureyDTO;
import com.partyBuilding.activity.domain.vo.*;
import com.partyBuilding.activity.mapper.AdminTaskMapper;
import com.partyBuilding.activity.mapper.UserTaskMapper;
import com.partyBuilding.activity.service.IAdminTaskService;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminTaskServiceImpl implements IAdminTaskService {
    private static final Logger log = LoggerFactory.getLogger(AdminTaskServiceImpl.class);
    @Autowired
    private AdminTaskMapper adminTaskMapper;
    @Autowired
    private UserTaskMapper userTaskMapper;

    //查询全部进度
    @Override
    public PageVo selectProgress(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTask> taskList = adminTaskMapper.selectProgress("学生");
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
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertTask(Task task) {
        int rows = adminTaskMapper.insertTask(task);
        if(rows>0){
            List<UserTask> ids = userTaskMapper.getAllStudentIds();

            List<UserTask> userTaskRecords = new ArrayList<>();
            for (UserTask student: ids){
                UserTask record=new UserTask();
                record.setStudentId(student.getStudentId());
                record.setUserName(student.getUserName());

                record.setTaskName(task.getTaskName());
                record.setTaskId(task.getId().intValue());
                record.setBeginTime(task.getBeginTime());
                record.setEndTime(task.getEndTime());
                record.setStatus(0);

                userTaskRecords.add(record);
            }
            if (!userTaskRecords.isEmpty()){
                try {
                    userTaskMapper.insertUserTask(userTaskRecords);
                }catch (Exception e){
                    throw new RuntimeException("添加任务失败"+ e.getMessage());
                }
            }
        }
        return rows;

    }
    //删除任务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteTasks(Long[] ids) {
        try{
            userTaskMapper.deleteUserTask(ids);
            return adminTaskMapper.deleteTasks(ids);
        }catch(Exception e){
            throw new RuntimeException("删除任务失败"+ e.getMessage());
        }
    }

    /**
     *获取管理员下的未/已完成数
     */
    @Override
    public int getTaskStats(int status) {
        return adminTaskMapper.countTaskStats(status);
    }

    /**
     * 按时间查询（年月查询）
     */
    @Override
    public PageResultVo selectYearAndMonth(AdminTaskPageQureyDTO adminTaskPageQureyDTO) {
        //开启分页查询
        PageHelper.startPage(adminTaskPageQureyDTO.getPage(), adminTaskPageQureyDTO.getPageSize());
        Page<Task> page = adminTaskMapper.selectByYearAndMonth(adminTaskPageQureyDTO);

        return new PageResultVo(page.getTotal(), page.getResult());
    }

    /**
     * 按姓名查询
     */
    @Override
    public selectByNamePageResultVo selectName(Integer pageNum, Integer pageSize, String name) {

        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        Page<UserTaskVo> page = adminTaskMapper.selectByName(name);

        String studentId=adminTaskMapper.selectStudentIDByName(name);

        Integer taskNumber=adminTaskMapper.getTaskNumber(name);
        Integer finishTaskNumber=adminTaskMapper.getFinishTaskNumber(name);

        return new selectByNamePageResultVo(studentId,name,page.getTotal(),taskNumber,finishTaskNumber, page.getResult());
    }
}
