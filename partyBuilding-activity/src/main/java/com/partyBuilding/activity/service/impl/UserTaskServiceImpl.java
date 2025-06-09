package com.partyBuilding.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.UserTaskPageQueryDto;
import com.partyBuilding.activity.domain.vo.PageVo;
import com.partyBuilding.activity.mapper.UserTaskMapper;
import com.partyBuilding.activity.service.IUserTaskService;
import com.partyBuilding.common.constant.UserTaskConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserTaskServiceImpl implements IUserTaskService {
    @Autowired
    private UserTaskMapper userTaskMapper;


    /**
     * 分页查询用户任务
     * @param userTaskPageQueryDto
     * @return
     */
    @Override
    public PageVo list(UserTaskPageQueryDto userTaskPageQueryDto) {
        //校验参数
        if(Objects.isNull(userTaskPageQueryDto)||
                Objects.isNull(userTaskPageQueryDto.getStudentId())||
                Objects.isNull(userTaskPageQueryDto.getPage())){
            throw new RuntimeException("参数错误");
        }
        //获取分页查询信息
        Integer page=userTaskPageQueryDto.getPage();
        String studentId=userTaskPageQueryDto.getStudentId();
        //开启分页查询
        PageHelper.startPage(page, UserTaskConstants.USER_TASK_PAGE_SIZE);
        Page<UserTask> pageResult = userTaskMapper.list(studentId);
        return new PageVo(pageResult.getTotal(),  pageResult.getResult());
    }
}
