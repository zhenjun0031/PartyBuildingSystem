package com.partyBuilding.activity.service;

import com.partyBuilding.activity.domain.UserTask;
import com.partyBuilding.activity.domain.dto.UserTaskHandleDto;
import com.partyBuilding.activity.domain.dto.UserTaskPageQueryDto;
import com.partyBuilding.activity.domain.vo.PageVo;
import org.springframework.web.multipart.MultipartFile;

public interface IUserTaskService {

    /**
     * 获取用户任务列表
     * @param userTaskPageQueryDto
     * @return
     */
    PageVo list(UserTaskPageQueryDto userTaskPageQueryDto);


    /**
     * 用户办理任务
     * @param userTaskHandleDto
     */
    void handle(UserTaskHandleDto userTaskHandleDto);

    /**
     * 用户上传文件
     * @param file
     */
    String userFileUpload(MultipartFile file,Long id);

    /**
     * 根据id获取用户任务
     * @param id
     * @return
     */
    UserTask getUserTaskById(Long id);


    /**
     * 修改用户任务
     * @param userTaskHandleDto
     */
    void update(UserTaskHandleDto userTaskHandleDto);
}
