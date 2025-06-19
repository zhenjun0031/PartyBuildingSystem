package com.partyBuilding.activity.mapper;

import com.github.pagehelper.Page;
import com.partyBuilding.activity.domain.UserTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface UserTaskMapper {


    /**
     * 查询用户任务列表
     * @param StudentId
     * @return
     */
    @Select("select id,taskName,usertask.beginTime,usertask.endTime,commitTime,status from usertask where studentId=#{studentId}")
    Page<UserTask> list(String StudentId);

    /**
     * 更新用户任务
     * @param userTask
     * @return
     */
    int update(UserTask userTask);

    /**
     * 根据id查询用户任务
     * @param id
     * @return
     */
    UserTask  getById(Long id);

    /**
     * 查询用户未完成数量
     * @param studentId
     * @return
     */
    @Select("SELECT COUNT(*) FROM userTask WHERE studentId = #{studentId} AND status=0")
    Integer countUnfinishedByStudentId(String studentId);
}
